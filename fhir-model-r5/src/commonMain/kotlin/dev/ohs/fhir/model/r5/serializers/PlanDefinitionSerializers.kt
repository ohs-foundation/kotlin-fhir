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

import dev.ohs.fhir.model.r5.Age
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.DataRequirement
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.TriggerDefinition
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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

internal object PlanDefinitionGoalSerializer : KSerializer<PlanDefinition.Goal> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Goal") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("description", CodeableConceptSerializer.descriptor)
      optionalElement("priority", CodeableConceptSerializer.descriptor)
      optionalElement("start", CodeableConceptSerializer.descriptor)
      optionalElement("addresses", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("documentation", RelatedArtifactSerializer.listSerializer.descriptor)
      optionalElement("target", PlanDefinitionGoalTargetSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Goal>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var description: CodeableConcept? = null
      var priority: CodeableConcept? = null
      var start: CodeableConcept? = null
      var addresses: List<CodeableConcept>? = null
      var documentation: List<RelatedArtifact>? = null
      var target: List<PlanDefinition.Goal.Target>? = null
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
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            description =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            priority =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            start =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            addresses =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 ->
            documentation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RelatedArtifactSerializer.listSerializer,
                null,
              )
          9 ->
            target =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PlanDefinitionGoalTargetSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Goal: " + i)
        }
      }
      PlanDefinition.Goal(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        category = category,
        description =
          description
            ?: throw SerializationException(
              "Missing required property 'description' on PlanDefinition.Goal"
            ),
        priority = priority,
        start = start,
        addresses = addresses ?: listOf(),
        documentation = documentation ?: listOf(),
        target = target ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.category)
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.description)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.priority)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.start)
      if (value.addresses.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.addresses,
        )
      if (value.documentation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          RelatedArtifactSerializer.listSerializer,
          value.documentation,
        )
      if (value.target.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          PlanDefinitionGoalTargetSerializer.listSerializer,
          value.target,
        )
    }
  }
}

internal object PlanDefinitionGoalTargetSerializer : KSerializer<PlanDefinition.Goal.Target> {
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
      optionalElement("due", DurationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Goal.Target>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal.Target =
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
      var due: Duration? = null
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
          14 -> due = decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Target: " + i)
        }
      }
      PlanDefinition.Goal.Target(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        measure = measure,
        detail =
          PlanDefinition.Goal.Target.Detail.from(
            detailQuantity,
            detailRange,
            detailCodeableConcept,
            R5String.of(detailString, _detailString),
            R5Boolean.of(detailBoolean, _detailBoolean),
            Integer.of(detailInteger, _detailInteger),
            detailRatio,
          ),
        due = due,
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal.Target) {
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
        is PlanDefinition.Goal.Target.Detail.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
        is PlanDefinition.Goal.Target.Detail.Range -> {
          encodeSerializableElement(descriptor, 5, RangeSerializer, choice.value)
        }
        is PlanDefinition.Goal.Target.Detail.CodeableConcept -> {
          encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
        }
        is PlanDefinition.Goal.Target.Detail.String -> {
          encodeStringIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is PlanDefinition.Goal.Target.Detail.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is PlanDefinition.Goal.Target.Detail.Integer -> {
          encodeIntIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is PlanDefinition.Goal.Target.Detail.Ratio -> {
          encodeSerializableElement(descriptor, 13, RatioSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 14, DurationSerializer, value.due)
    }
  }
}

internal object PlanDefinitionActorSerializer : KSerializer<PlanDefinition.Actor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Actor") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("option", PlanDefinitionActorOptionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Actor>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Actor =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var option: List<PlanDefinition.Actor.Option>? = null
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
          3 -> title = decodeStringElement(descriptor, i)
          4 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> description = decodeStringElement(descriptor, i)
          6 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            option =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PlanDefinitionActorOptionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Actor: " + i)
        }
      }
      PlanDefinition.Actor(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        title = R5String.of(title, _title),
        description = Markdown.of(description, _description),
        option = option ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Actor) {
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
      encodeStringIfNotNull(descriptor, 3, value.title?.value)
      encodeElementIfNotNull(descriptor, 4, value.title)
      encodeStringIfNotNull(descriptor, 5, value.description?.value)
      encodeElementIfNotNull(descriptor, 6, value.description)
      if (value.option.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          PlanDefinitionActorOptionSerializer.listSerializer,
          value.option,
        )
    }
  }
}

internal object PlanDefinitionActorOptionSerializer : KSerializer<PlanDefinition.Actor.Option> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Option") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("typeCanonical", KotlinString.serializer().descriptor)
      optionalElement("_typeCanonical", ElementSerializer.descriptor)
      optionalElement("typeReference", ReferenceSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Actor.Option>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Actor.Option =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var typeCanonical: KotlinString? = null
      var _typeCanonical: Element? = null
      var typeReference: Reference? = null
      var role: CodeableConcept? = null
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> typeCanonical = decodeStringElement(descriptor, i)
          6 ->
            _typeCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            typeReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Option: " + i)
        }
      }
      PlanDefinition.Actor.Option(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) PlanDefinition.ActionParticipantType.fromCode(type) else null,
            _type,
          ),
        typeCanonical = Canonical.of(typeCanonical, _typeCanonical),
        typeReference = typeReference,
        role = role,
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Actor.Option) {
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
      encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeStringIfNotNull(descriptor, 5, value.typeCanonical?.value)
      encodeElementIfNotNull(descriptor, 6, value.typeCanonical)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.typeReference)
      encodeSerializableIfNotNull(descriptor, 8, CodeableConceptSerializer, value.role)
    }
  }
}

internal object PlanDefinitionActionSerializer : KSerializer<PlanDefinition.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("prefix", KotlinString.serializer().descriptor)
      optionalElement("_prefix", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("textEquivalent", KotlinString.serializer().descriptor)
      optionalElement("_textEquivalent", ElementSerializer.descriptor)
      optionalElement("priority", KotlinString.serializer().descriptor)
      optionalElement("_priority", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("reason", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("documentation", RelatedArtifactSerializer.listSerializer.descriptor)
      optionalElement("goalId", stringNullableListSerializer.descriptor)
      optionalElement("_goalId", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("subjectReference", ReferenceSerializer.descriptor)
      optionalElement("subjectCanonical", KotlinString.serializer().descriptor)
      optionalElement("_subjectCanonical", ElementSerializer.descriptor)
      optionalElement("trigger", TriggerDefinitionSerializer.listSerializer.descriptor)
      optionalElement(
        "condition",
        PlanDefinitionActionConditionSerializer.listSerializer.descriptor,
      )
      optionalElement("input", PlanDefinitionActionInputSerializer.listSerializer.descriptor)
      optionalElement("output", PlanDefinitionActionOutputSerializer.listSerializer.descriptor)
      optionalElement(
        "relatedAction",
        PlanDefinitionActionRelatedActionSerializer.listSerializer.descriptor,
      )
      optionalElement("timingAge", AgeSerializer.descriptor)
      optionalElement("timingDuration", DurationSerializer.descriptor)
      optionalElement("timingRange", RangeSerializer.descriptor)
      optionalElement("timingTiming", TimingSerializer.descriptor)
      optionalElement("location", CodeableReferenceSerializer.descriptor)
      optionalElement(
        "participant",
        PlanDefinitionActionParticipantSerializer.listSerializer.descriptor,
      )
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("groupingBehavior", KotlinString.serializer().descriptor)
      optionalElement("_groupingBehavior", ElementSerializer.descriptor)
      optionalElement("selectionBehavior", KotlinString.serializer().descriptor)
      optionalElement("_selectionBehavior", ElementSerializer.descriptor)
      optionalElement("requiredBehavior", KotlinString.serializer().descriptor)
      optionalElement("_requiredBehavior", ElementSerializer.descriptor)
      optionalElement("precheckBehavior", KotlinString.serializer().descriptor)
      optionalElement("_precheckBehavior", ElementSerializer.descriptor)
      optionalElement("cardinalityBehavior", KotlinString.serializer().descriptor)
      optionalElement("_cardinalityBehavior", ElementSerializer.descriptor)
      optionalElement("definitionCanonical", KotlinString.serializer().descriptor)
      optionalElement("_definitionCanonical", ElementSerializer.descriptor)
      optionalElement("definitionUri", KotlinString.serializer().descriptor)
      optionalElement("_definitionUri", ElementSerializer.descriptor)
      optionalElement("transform", KotlinString.serializer().descriptor)
      optionalElement("_transform", ElementSerializer.descriptor)
      optionalElement(
        "dynamicValue",
        PlanDefinitionActionDynamicValueSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "action",
        listSerialDescriptor(lazyDescriptor { PlanDefinitionActionSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Action =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var linkId: KotlinString? = null
      var _linkId: Element? = null
      var prefix: KotlinString? = null
      var _prefix: Element? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var textEquivalent: KotlinString? = null
      var _textEquivalent: Element? = null
      var priority: KotlinString? = null
      var _priority: Element? = null
      var code: CodeableConcept? = null
      var reason: List<CodeableConcept>? = null
      var documentation: List<RelatedArtifact>? = null
      var goalId: List<KotlinString?>? = null
      var _goalId: List<Element?>? = null
      var subjectCodeableConcept: CodeableConcept? = null
      var subjectReference: Reference? = null
      var subjectCanonical: KotlinString? = null
      var _subjectCanonical: Element? = null
      var trigger: List<TriggerDefinition>? = null
      var condition: List<PlanDefinition.Action.Condition>? = null
      var input: List<PlanDefinition.Action.Input>? = null
      var output: List<PlanDefinition.Action.Output>? = null
      var relatedAction: List<PlanDefinition.Action.RelatedAction>? = null
      var timingAge: Age? = null
      var timingDuration: Duration? = null
      var timingRange: Range? = null
      var timingTiming: Timing? = null
      var location: CodeableReference? = null
      var participant: List<PlanDefinition.Action.Participant>? = null
      var type: CodeableConcept? = null
      var groupingBehavior: KotlinString? = null
      var _groupingBehavior: Element? = null
      var selectionBehavior: KotlinString? = null
      var _selectionBehavior: Element? = null
      var requiredBehavior: KotlinString? = null
      var _requiredBehavior: Element? = null
      var precheckBehavior: KotlinString? = null
      var _precheckBehavior: Element? = null
      var cardinalityBehavior: KotlinString? = null
      var _cardinalityBehavior: Element? = null
      var definitionCanonical: KotlinString? = null
      var _definitionCanonical: Element? = null
      var definitionUri: KotlinString? = null
      var _definitionUri: Element? = null
      var transform: KotlinString? = null
      var _transform: Element? = null
      var dynamicValue: List<PlanDefinition.Action.DynamicValue>? = null
      var action: List<PlanDefinition.Action>? = null
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
          3 -> linkId = decodeStringElement(descriptor, i)
          4 -> _linkId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> prefix = decodeStringElement(descriptor, i)
          6 -> _prefix = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> title = decodeStringElement(descriptor, i)
          8 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> description = decodeStringElement(descriptor, i)
          10 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> textEquivalent = decodeStringElement(descriptor, i)
          12 ->
            _textEquivalent =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> priority = decodeStringElement(descriptor, i)
          14 ->
            _priority = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          16 ->
            reason =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          17 ->
            documentation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RelatedArtifactSerializer.listSerializer,
                null,
              )
          18 ->
            goalId =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          19 ->
            _goalId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          20 ->
            subjectCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          21 ->
            subjectReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          22 -> subjectCanonical = decodeStringElement(descriptor, i)
          23 ->
            _subjectCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          24 ->
            trigger =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TriggerDefinitionSerializer.listSerializer,
                null,
              )
          25 ->
            condition =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PlanDefinitionActionConditionSerializer.listSerializer,
                null,
              )
          26 ->
            input =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PlanDefinitionActionInputSerializer.listSerializer,
                null,
              )
          27 ->
            output =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PlanDefinitionActionOutputSerializer.listSerializer,
                null,
              )
          28 ->
            relatedAction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PlanDefinitionActionRelatedActionSerializer.listSerializer,
                null,
              )
          29 -> timingAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          30 ->
            timingDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          31 ->
            timingRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          32 ->
            timingTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          33 ->
            location =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          34 ->
            participant =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PlanDefinitionActionParticipantSerializer.listSerializer,
                null,
              )
          35 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          36 -> groupingBehavior = decodeStringElement(descriptor, i)
          37 ->
            _groupingBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          38 -> selectionBehavior = decodeStringElement(descriptor, i)
          39 ->
            _selectionBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          40 -> requiredBehavior = decodeStringElement(descriptor, i)
          41 ->
            _requiredBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          42 -> precheckBehavior = decodeStringElement(descriptor, i)
          43 ->
            _precheckBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          44 -> cardinalityBehavior = decodeStringElement(descriptor, i)
          45 ->
            _cardinalityBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          46 -> definitionCanonical = decodeStringElement(descriptor, i)
          47 ->
            _definitionCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          48 -> definitionUri = decodeStringElement(descriptor, i)
          49 ->
            _definitionUri =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          50 -> transform = decodeStringElement(descriptor, i)
          51 ->
            _transform = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          52 ->
            dynamicValue =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PlanDefinitionActionDynamicValueSerializer.listSerializer,
                null,
              )
          53 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PlanDefinitionActionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Action: " + i)
        }
      }
      PlanDefinition.Action(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        linkId = R5String.of(linkId, _linkId),
        prefix = R5String.of(prefix, _prefix),
        title = R5String.of(title, _title),
        description = Markdown.of(description, _description),
        textEquivalent = Markdown.of(textEquivalent, _textEquivalent),
        priority =
          Enumeration.of(
            if (priority != null) PlanDefinition.RequestPriority.fromCode(priority) else null,
            _priority,
          ),
        code = code,
        reason = reason ?: listOf(),
        documentation = documentation ?: listOf(),
        goalId =
          (kotlin.collections.List(maxOf(goalId?.size ?: 0, _goalId?.size ?: 0)) { index ->
            Id.of(goalId?.getOrNull(index), _goalId?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'goalId' on PlanDefinition.Action has neither a value nor an id/extension"
              )
          }),
        subject =
          PlanDefinition.Action.Subject.from(
            subjectCodeableConcept,
            subjectReference,
            Canonical.of(subjectCanonical, _subjectCanonical),
          ),
        trigger = trigger ?: listOf(),
        condition = condition ?: listOf(),
        input = input ?: listOf(),
        output = output ?: listOf(),
        relatedAction = relatedAction ?: listOf(),
        timing =
          PlanDefinition.Action.Timing.from(timingAge, timingDuration, timingRange, timingTiming),
        location = location,
        participant = participant ?: listOf(),
        type = type,
        groupingBehavior =
          Enumeration.of(
            if (groupingBehavior != null)
              PlanDefinition.ActionGroupingBehavior.fromCode(groupingBehavior)
            else null,
            _groupingBehavior,
          ),
        selectionBehavior =
          Enumeration.of(
            if (selectionBehavior != null)
              PlanDefinition.ActionSelectionBehavior.fromCode(selectionBehavior)
            else null,
            _selectionBehavior,
          ),
        requiredBehavior =
          Enumeration.of(
            if (requiredBehavior != null)
              PlanDefinition.ActionRequiredBehavior.fromCode(requiredBehavior)
            else null,
            _requiredBehavior,
          ),
        precheckBehavior =
          Enumeration.of(
            if (precheckBehavior != null)
              PlanDefinition.ActionPrecheckBehavior.fromCode(precheckBehavior)
            else null,
            _precheckBehavior,
          ),
        cardinalityBehavior =
          Enumeration.of(
            if (cardinalityBehavior != null)
              PlanDefinition.ActionCardinalityBehavior.fromCode(cardinalityBehavior)
            else null,
            _cardinalityBehavior,
          ),
        definition =
          PlanDefinition.Action.Definition.from(
            Canonical.of(definitionCanonical, _definitionCanonical),
            Uri.of(definitionUri, _definitionUri),
          ),
        transform = Canonical.of(transform, _transform),
        dynamicValue = dynamicValue ?: listOf(),
        action = action ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action) {
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
      encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
      encodeElementIfNotNull(descriptor, 4, value.linkId)
      encodeStringIfNotNull(descriptor, 5, value.prefix?.value)
      encodeElementIfNotNull(descriptor, 6, value.prefix)
      encodeStringIfNotNull(descriptor, 7, value.title?.value)
      encodeElementIfNotNull(descriptor, 8, value.title)
      encodeStringIfNotNull(descriptor, 9, value.description?.value)
      encodeElementIfNotNull(descriptor, 10, value.description)
      encodeStringIfNotNull(descriptor, 11, value.textEquivalent?.value)
      encodeElementIfNotNull(descriptor, 12, value.textEquivalent)
      encodeStringIfNotNull(descriptor, 13, value.priority?.value?.code)
      encodeElementIfNotNull(descriptor, 14, value.priority)
      encodeSerializableIfNotNull(descriptor, 15, CodeableConceptSerializer, value.code)
      if (value.reason.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          CodeableConceptSerializer.listSerializer,
          value.reason,
        )
      if (value.documentation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          17,
          RelatedArtifactSerializer.listSerializer,
          value.documentation,
        )
      if (value.goalId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          18,
          stringNullableListSerializer,
          value.goalId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 19, value.goalId)
      }
      when (val choice = value.subject) {
        null -> {}
        is PlanDefinition.Action.Subject.CodeableConcept -> {
          encodeSerializableElement(descriptor, 20, CodeableConceptSerializer, choice.value)
        }
        is PlanDefinition.Action.Subject.Reference -> {
          encodeSerializableElement(descriptor, 21, ReferenceSerializer, choice.value)
        }
        is PlanDefinition.Action.Subject.Canonical -> {
          encodeStringIfNotNull(descriptor, 22, choice.value.value)
          encodeElementIfNotNull(descriptor, 23, choice.value)
        }
      }
      if (value.trigger.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          24,
          TriggerDefinitionSerializer.listSerializer,
          value.trigger,
        )
      if (value.condition.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          25,
          PlanDefinitionActionConditionSerializer.listSerializer,
          value.condition,
        )
      if (value.input.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          26,
          PlanDefinitionActionInputSerializer.listSerializer,
          value.input,
        )
      if (value.output.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          27,
          PlanDefinitionActionOutputSerializer.listSerializer,
          value.output,
        )
      if (value.relatedAction.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          28,
          PlanDefinitionActionRelatedActionSerializer.listSerializer,
          value.relatedAction,
        )
      when (val choice = value.timing) {
        null -> {}
        is PlanDefinition.Action.Timing.Age -> {
          encodeSerializableElement(descriptor, 29, AgeSerializer, choice.value)
        }
        is PlanDefinition.Action.Timing.Duration -> {
          encodeSerializableElement(descriptor, 30, DurationSerializer, choice.value)
        }
        is PlanDefinition.Action.Timing.Range -> {
          encodeSerializableElement(descriptor, 31, RangeSerializer, choice.value)
        }
        is PlanDefinition.Action.Timing.Timing -> {
          encodeSerializableElement(descriptor, 32, TimingSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 33, CodeableReferenceSerializer, value.location)
      if (value.participant.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          34,
          PlanDefinitionActionParticipantSerializer.listSerializer,
          value.participant,
        )
      encodeSerializableIfNotNull(descriptor, 35, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 36, value.groupingBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 37, value.groupingBehavior)
      encodeStringIfNotNull(descriptor, 38, value.selectionBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 39, value.selectionBehavior)
      encodeStringIfNotNull(descriptor, 40, value.requiredBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 41, value.requiredBehavior)
      encodeStringIfNotNull(descriptor, 42, value.precheckBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 43, value.precheckBehavior)
      encodeStringIfNotNull(descriptor, 44, value.cardinalityBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 45, value.cardinalityBehavior)
      when (val choice = value.definition) {
        null -> {}
        is PlanDefinition.Action.Definition.Canonical -> {
          encodeStringIfNotNull(descriptor, 46, choice.value.value)
          encodeElementIfNotNull(descriptor, 47, choice.value)
        }
        is PlanDefinition.Action.Definition.Uri -> {
          encodeStringIfNotNull(descriptor, 48, choice.value.value)
          encodeElementIfNotNull(descriptor, 49, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 50, value.transform?.value)
      encodeElementIfNotNull(descriptor, 51, value.transform)
      if (value.dynamicValue.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          52,
          PlanDefinitionActionDynamicValueSerializer.listSerializer,
          value.dynamicValue,
        )
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          53,
          PlanDefinitionActionSerializer.listSerializer,
          value.action,
        )
    }
  }
}

internal object PlanDefinitionActionConditionSerializer :
  KSerializer<PlanDefinition.Action.Condition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Condition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("kind", KotlinString.serializer().descriptor)
      optionalElement("_kind", ElementSerializer.descriptor)
      optionalElement("expression", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Action.Condition>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Condition =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var kind: KotlinString? = null
      var _kind: Element? = null
      var expression: Expression? = null
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
          3 -> kind = decodeStringElement(descriptor, i)
          4 -> _kind = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            expression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Condition: " + i)
        }
      }
      PlanDefinition.Action.Condition(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        kind =
          Enumeration.of(
            if (kind != null) PlanDefinition.ActionConditionKind.fromCode(kind) else null,
            _kind,
          )
            ?: throw SerializationException(
              "Missing required property 'kind' on PlanDefinition.Action.Condition"
            ),
        expression = expression,
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Condition) {
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
      encodeStringIfNotNull(descriptor, 3, value.kind.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.kind)
      encodeSerializableIfNotNull(descriptor, 5, ExpressionSerializer, value.expression)
    }
  }
}

internal object PlanDefinitionActionInputSerializer : KSerializer<PlanDefinition.Action.Input> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Input") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("requirement", DataRequirementSerializer.descriptor)
      optionalElement("relatedData", KotlinString.serializer().descriptor)
      optionalElement("_relatedData", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Action.Input>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Input =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var requirement: DataRequirement? = null
      var relatedData: KotlinString? = null
      var _relatedData: Element? = null
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
          3 -> title = decodeStringElement(descriptor, i)
          4 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            requirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          6 -> relatedData = decodeStringElement(descriptor, i)
          7 ->
            _relatedData = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Input: " + i)
        }
      }
      PlanDefinition.Action.Input(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        title = R5String.of(title, _title),
        requirement = requirement,
        relatedData = Id.of(relatedData, _relatedData),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Input) {
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
      encodeStringIfNotNull(descriptor, 3, value.title?.value)
      encodeElementIfNotNull(descriptor, 4, value.title)
      encodeSerializableIfNotNull(descriptor, 5, DataRequirementSerializer, value.requirement)
      encodeStringIfNotNull(descriptor, 6, value.relatedData?.value)
      encodeElementIfNotNull(descriptor, 7, value.relatedData)
    }
  }
}

internal object PlanDefinitionActionOutputSerializer : KSerializer<PlanDefinition.Action.Output> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Output") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("requirement", DataRequirementSerializer.descriptor)
      optionalElement("relatedData", KotlinString.serializer().descriptor)
      optionalElement("_relatedData", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Action.Output>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Output =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var requirement: DataRequirement? = null
      var relatedData: KotlinString? = null
      var _relatedData: Element? = null
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
          3 -> title = decodeStringElement(descriptor, i)
          4 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            requirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          6 -> relatedData = decodeStringElement(descriptor, i)
          7 ->
            _relatedData = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Output: " + i)
        }
      }
      PlanDefinition.Action.Output(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        title = R5String.of(title, _title),
        requirement = requirement,
        relatedData = R5String.of(relatedData, _relatedData),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Output) {
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
      encodeStringIfNotNull(descriptor, 3, value.title?.value)
      encodeElementIfNotNull(descriptor, 4, value.title)
      encodeSerializableIfNotNull(descriptor, 5, DataRequirementSerializer, value.requirement)
      encodeStringIfNotNull(descriptor, 6, value.relatedData?.value)
      encodeElementIfNotNull(descriptor, 7, value.relatedData)
    }
  }
}

internal object PlanDefinitionActionRelatedActionSerializer :
  KSerializer<PlanDefinition.Action.RelatedAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedAction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("targetId", KotlinString.serializer().descriptor)
      optionalElement("_targetId", ElementSerializer.descriptor)
      optionalElement("relationship", KotlinString.serializer().descriptor)
      optionalElement("_relationship", ElementSerializer.descriptor)
      optionalElement("endRelationship", KotlinString.serializer().descriptor)
      optionalElement("_endRelationship", ElementSerializer.descriptor)
      optionalElement("offsetDuration", DurationSerializer.descriptor)
      optionalElement("offsetRange", RangeSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Action.RelatedAction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.RelatedAction =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var targetId: KotlinString? = null
      var _targetId: Element? = null
      var relationship: KotlinString? = null
      var _relationship: Element? = null
      var endRelationship: KotlinString? = null
      var _endRelationship: Element? = null
      var offsetDuration: Duration? = null
      var offsetRange: Range? = null
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
          3 -> targetId = decodeStringElement(descriptor, i)
          4 -> _targetId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> relationship = decodeStringElement(descriptor, i)
          6 ->
            _relationship =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> endRelationship = decodeStringElement(descriptor, i)
          8 ->
            _endRelationship =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            offsetDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          10 ->
            offsetRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RelatedAction: " + i)
        }
      }
      PlanDefinition.Action.RelatedAction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        targetId =
          Id.of(targetId, _targetId)
            ?: throw SerializationException(
              "Missing required property 'targetId' on PlanDefinition.Action.RelatedAction"
            ),
        relationship =
          Enumeration.of(
            if (relationship != null) PlanDefinition.ActionRelationshipType.fromCode(relationship)
            else null,
            _relationship,
          )
            ?: throw SerializationException(
              "Missing required property 'relationship' on PlanDefinition.Action.RelatedAction"
            ),
        endRelationship =
          Enumeration.of(
            if (endRelationship != null)
              PlanDefinition.ActionRelationshipType.fromCode(endRelationship)
            else null,
            _endRelationship,
          ),
        offset = PlanDefinition.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.RelatedAction) {
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
      encodeStringIfNotNull(descriptor, 3, value.targetId.value)
      encodeElementIfNotNull(descriptor, 4, value.targetId)
      encodeStringIfNotNull(descriptor, 5, value.relationship.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.relationship)
      encodeStringIfNotNull(descriptor, 7, value.endRelationship?.value?.code)
      encodeElementIfNotNull(descriptor, 8, value.endRelationship)
      when (val choice = value.offset) {
        null -> {}
        is PlanDefinition.Action.RelatedAction.Offset.Duration -> {
          encodeSerializableElement(descriptor, 9, DurationSerializer, choice.value)
        }
        is PlanDefinition.Action.RelatedAction.Offset.Range -> {
          encodeSerializableElement(descriptor, 10, RangeSerializer, choice.value)
        }
      }
    }
  }
}

internal object PlanDefinitionActionParticipantSerializer :
  KSerializer<PlanDefinition.Action.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("actorId", KotlinString.serializer().descriptor)
      optionalElement("_actorId", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("typeCanonical", KotlinString.serializer().descriptor)
      optionalElement("_typeCanonical", ElementSerializer.descriptor)
      optionalElement("typeReference", ReferenceSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Action.Participant>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Participant =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var actorId: KotlinString? = null
      var _actorId: Element? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var typeCanonical: KotlinString? = null
      var _typeCanonical: Element? = null
      var typeReference: Reference? = null
      var role: CodeableConcept? = null
      var function: CodeableConcept? = null
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
          3 -> actorId = decodeStringElement(descriptor, i)
          4 -> _actorId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> type = decodeStringElement(descriptor, i)
          6 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> typeCanonical = decodeStringElement(descriptor, i)
          8 ->
            _typeCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            typeReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          10 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          11 ->
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      PlanDefinition.Action.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        actorId = R5String.of(actorId, _actorId),
        type =
          Enumeration.of(
            if (type != null) PlanDefinition.ActionParticipantType.fromCode(type) else null,
            _type,
          ),
        typeCanonical = Canonical.of(typeCanonical, _typeCanonical),
        typeReference = typeReference,
        role = role,
        function = function,
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Participant) {
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
      encodeStringIfNotNull(descriptor, 3, value.actorId?.value)
      encodeElementIfNotNull(descriptor, 4, value.actorId)
      encodeStringIfNotNull(descriptor, 5, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.type)
      encodeStringIfNotNull(descriptor, 7, value.typeCanonical?.value)
      encodeElementIfNotNull(descriptor, 8, value.typeCanonical)
      encodeSerializableIfNotNull(descriptor, 9, ReferenceSerializer, value.typeReference)
      encodeSerializableIfNotNull(descriptor, 10, CodeableConceptSerializer, value.role)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.function)
    }
  }
}

internal object PlanDefinitionActionDynamicValueSerializer :
  KSerializer<PlanDefinition.Action.DynamicValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DynamicValue") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("expression", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PlanDefinition.Action.DynamicValue>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.DynamicValue =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var path: KotlinString? = null
      var _path: Element? = null
      var expression: Expression? = null
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
          3 -> path = decodeStringElement(descriptor, i)
          4 -> _path = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            expression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DynamicValue: " + i)
        }
      }
      PlanDefinition.Action.DynamicValue(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        path = R5String.of(path, _path),
        expression = expression,
      )
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.DynamicValue) {
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
      encodeStringIfNotNull(descriptor, 3, value.path?.value)
      encodeElementIfNotNull(descriptor, 4, value.path)
      encodeSerializableIfNotNull(descriptor, 5, ExpressionSerializer, value.expression)
    }
  }
}

internal object PlanDefinitionSerializer : FhirResourceSerializer<PlanDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("PlanDefinition")

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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("subtitle", KotlinString.serializer().descriptor)
    b.optionalElement("_subtitle", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("subjectReference", ReferenceSerializer.descriptor)
    b.optionalElement("subjectCanonical", KotlinString.serializer().descriptor)
    b.optionalElement("_subjectCanonical", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("usage", KotlinString.serializer().descriptor)
    b.optionalElement("_usage", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("topic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("library", stringNullableListSerializer.descriptor)
    b.optionalElement("_library", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("goal", PlanDefinitionGoalSerializer.listSerializer.descriptor)
    b.optionalElement("actor", PlanDefinitionActorSerializer.listSerializer.descriptor)
    b.optionalElement("action", PlanDefinitionActionSerializer.listSerializer.descriptor)
    b.optionalElement("asNeededBoolean", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_asNeededBoolean", ElementSerializer.descriptor)
    b.optionalElement("asNeededCodeableConcept", CodeableConceptSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): PlanDefinition {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var type: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var subjectCanonical: KotlinString? = null
    var _subjectCanonical: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var usage: KotlinString? = null
    var _usage: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var library: List<KotlinString?>? = null
    var _library: List<Element?>? = null
    var goal: List<PlanDefinition.Goal>? = null
    var actor: List<PlanDefinition.Actor>? = null
    var action: List<PlanDefinition.Action>? = null
    var asNeededBoolean: KotlinBoolean? = null
    var _asNeededBoolean: Element? = null
    var asNeededCodeableConcept: CodeableConcept? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> subtitle = decoder.decodeStringElement(descriptor, i)
        23 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 -> status = decoder.decodeStringElement(descriptor, i)
        26 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        28 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        30 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        31 -> subjectCanonical = decoder.decodeStringElement(descriptor, i)
        32 ->
          _subjectCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 -> date = decoder.decodeStringElement(descriptor, i)
        34 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 -> publisher = decoder.decodeStringElement(descriptor, i)
        36 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        38 -> description = decoder.decodeStringElement(descriptor, i)
        39 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        41 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        42 -> purpose = decoder.decodeStringElement(descriptor, i)
        43 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        44 -> usage = decoder.decodeStringElement(descriptor, i)
        45 ->
          _usage = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        46 -> copyright = decoder.decodeStringElement(descriptor, i)
        47 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        48 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        49 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        50 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        51 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        52 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        53 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        54 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        55 ->
          topic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        56 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        57 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        58 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        59 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        60 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        61 ->
          library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        62 ->
          _library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        63 ->
          goal =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionGoalSerializer.listSerializer,
              null,
            )
        64 ->
          actor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionActorSerializer.listSerializer,
              null,
            )
        65 ->
          action =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionActionSerializer.listSerializer,
              null,
            )
        66 -> asNeededBoolean = decoder.decodeBooleanElement(descriptor, i)
        67 ->
          _asNeededBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        68 ->
          asNeededCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding PlanDefinition: " + i)
      }
    }
    return PlanDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        PlanDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      subtitle = R5String.of(subtitle, _subtitle),
      type = type,
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on PlanDefinition"),
      experimental = R5Boolean.of(experimental, _experimental),
      subject =
        PlanDefinition.Subject.from(
          subjectCodeableConcept,
          subjectReference,
          Canonical.of(subjectCanonical, _subjectCanonical),
        ),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = Markdown.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { index ->
          Canonical.of(library?.getOrNull(index), _library?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'library' on PlanDefinition has neither a value nor an id/extension"
            )
        }),
      goal = goal ?: listOf(),
      actor = actor ?: listOf(),
      action = action ?: listOf(),
      asNeeded =
        PlanDefinition.AsNeeded.from(
          R5Boolean.of(asNeededBoolean, _asNeededBoolean),
          asNeededCodeableConcept,
        ),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PlanDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is PlanDefinition.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is PlanDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.subtitle?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.subtitle)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 27 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.experimental)
    when (val choice = value.subject) {
      null -> {}
      is PlanDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          29 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is PlanDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is PlanDefinition.Subject.Canonical -> {
        encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 38 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 42 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 44 + descriptorOffset, value.usage?.value)
    encoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, value.usage)
    encoder.encodeStringIfNotNull(descriptor, 46 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 48 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 49 + descriptorOffset, value.copyrightLabel)
    encoder.encodeStringIfNotNull(
      descriptor,
      50 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 51 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      52 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 53 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      54 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    if (value.library.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        61 + descriptorOffset,
        stringNullableListSerializer,
        value.library.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 62 + descriptorOffset, value.library)
    }
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        PlanDefinitionGoalSerializer.listSerializer,
        value.goal,
      )
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        64 + descriptorOffset,
        PlanDefinitionActorSerializer.listSerializer,
        value.actor,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        65 + descriptorOffset,
        PlanDefinitionActionSerializer.listSerializer,
        value.action,
      )
    when (val choice = value.asNeeded) {
      null -> {}
      is PlanDefinition.AsNeeded.Boolean -> {
        encoder.encodeBooleanIfNotNull(descriptor, 66 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 67 + descriptorOffset, choice.value)
      }
      is PlanDefinition.AsNeeded.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          68 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
  }
}
