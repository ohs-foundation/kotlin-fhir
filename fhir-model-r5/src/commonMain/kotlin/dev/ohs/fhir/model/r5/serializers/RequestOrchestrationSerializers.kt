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
import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DataRequirement
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.RequestOrchestration
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
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

internal object RequestOrchestrationActionSerializer : KSerializer<RequestOrchestration.Action> {
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
      optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("documentation", RelatedArtifactSerializer.listSerializer.descriptor)
      optionalElement("goal", ReferenceSerializer.listSerializer.descriptor)
      optionalElement(
        "condition",
        RequestOrchestrationActionConditionSerializer.listSerializer.descriptor,
      )
      optionalElement("input", RequestOrchestrationActionInputSerializer.listSerializer.descriptor)
      optionalElement(
        "output",
        RequestOrchestrationActionOutputSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "relatedAction",
        RequestOrchestrationActionRelatedActionSerializer.listSerializer.descriptor,
      )
      optionalElement("timingDateTime", KotlinString.serializer().descriptor)
      optionalElement("_timingDateTime", ElementSerializer.descriptor)
      optionalElement("timingAge", AgeSerializer.descriptor)
      optionalElement("timingPeriod", PeriodSerializer.descriptor)
      optionalElement("timingDuration", DurationSerializer.descriptor)
      optionalElement("timingRange", RangeSerializer.descriptor)
      optionalElement("timingTiming", TimingSerializer.descriptor)
      optionalElement("location", CodeableReferenceSerializer.descriptor)
      optionalElement(
        "participant",
        RequestOrchestrationActionParticipantSerializer.listSerializer.descriptor,
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
      optionalElement("resource", ReferenceSerializer.descriptor)
      optionalElement("definitionCanonical", KotlinString.serializer().descriptor)
      optionalElement("_definitionCanonical", ElementSerializer.descriptor)
      optionalElement("definitionUri", KotlinString.serializer().descriptor)
      optionalElement("_definitionUri", ElementSerializer.descriptor)
      optionalElement("transform", KotlinString.serializer().descriptor)
      optionalElement("_transform", ElementSerializer.descriptor)
      optionalElement(
        "dynamicValue",
        RequestOrchestrationActionDynamicValueSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "action",
        listSerialDescriptor(lazyDescriptor { RequestOrchestrationActionSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<RequestOrchestration.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action =
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
      var code: List<CodeableConcept>? = null
      var documentation: List<RelatedArtifact>? = null
      var goal: List<Reference>? = null
      var condition: List<RequestOrchestration.Action.Condition>? = null
      var input: List<RequestOrchestration.Action.Input>? = null
      var output: List<RequestOrchestration.Action.Output>? = null
      var relatedAction: List<RequestOrchestration.Action.RelatedAction>? = null
      var timingDateTime: KotlinString? = null
      var _timingDateTime: Element? = null
      var timingAge: Age? = null
      var timingPeriod: Period? = null
      var timingDuration: Duration? = null
      var timingRange: Range? = null
      var timingTiming: Timing? = null
      var location: CodeableReference? = null
      var participant: List<RequestOrchestration.Action.Participant>? = null
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
      var resource: Reference? = null
      var definitionCanonical: KotlinString? = null
      var _definitionCanonical: Element? = null
      var definitionUri: KotlinString? = null
      var _definitionUri: Element? = null
      var transform: KotlinString? = null
      var _transform: Element? = null
      var dynamicValue: List<RequestOrchestration.Action.DynamicValue>? = null
      var action: List<RequestOrchestration.Action>? = null
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
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          16 ->
            documentation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RelatedArtifactSerializer.listSerializer,
                null,
              )
          17 ->
            goal =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          18 ->
            condition =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestOrchestrationActionConditionSerializer.listSerializer,
                null,
              )
          19 ->
            input =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestOrchestrationActionInputSerializer.listSerializer,
                null,
              )
          20 ->
            output =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestOrchestrationActionOutputSerializer.listSerializer,
                null,
              )
          21 ->
            relatedAction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestOrchestrationActionRelatedActionSerializer.listSerializer,
                null,
              )
          22 -> timingDateTime = decodeStringElement(descriptor, i)
          23 ->
            _timingDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          24 -> timingAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          25 ->
            timingPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          26 ->
            timingDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          27 ->
            timingRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          28 ->
            timingTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          29 ->
            location =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          30 ->
            participant =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestOrchestrationActionParticipantSerializer.listSerializer,
                null,
              )
          31 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          32 -> groupingBehavior = decodeStringElement(descriptor, i)
          33 ->
            _groupingBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          34 -> selectionBehavior = decodeStringElement(descriptor, i)
          35 ->
            _selectionBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          36 -> requiredBehavior = decodeStringElement(descriptor, i)
          37 ->
            _requiredBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          38 -> precheckBehavior = decodeStringElement(descriptor, i)
          39 ->
            _precheckBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          40 -> cardinalityBehavior = decodeStringElement(descriptor, i)
          41 ->
            _cardinalityBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          42 ->
            resource = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          43 -> definitionCanonical = decodeStringElement(descriptor, i)
          44 ->
            _definitionCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          45 -> definitionUri = decodeStringElement(descriptor, i)
          46 ->
            _definitionUri =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          47 -> transform = decodeStringElement(descriptor, i)
          48 ->
            _transform = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          49 ->
            dynamicValue =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestOrchestrationActionDynamicValueSerializer.listSerializer,
                null,
              )
          50 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestOrchestrationActionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Action: " + i)
        }
      }
      RequestOrchestration.Action(
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
            if (priority != null) RequestOrchestration.RequestPriority.fromCode(priority) else null,
            _priority,
          ),
        code = code ?: listOf(),
        documentation = documentation ?: listOf(),
        goal = goal ?: listOf(),
        condition = condition ?: listOf(),
        input = input ?: listOf(),
        output = output ?: listOf(),
        relatedAction = relatedAction ?: listOf(),
        timing =
          RequestOrchestration.Action.Timing.from(
            DateTime.of(
              if (timingDateTime != null) FhirDateTime.fromString(timingDateTime) else null,
              _timingDateTime,
            ),
            timingAge,
            timingPeriod,
            timingDuration,
            timingRange,
            timingTiming,
          ),
        location = location,
        participant = participant ?: listOf(),
        type = type,
        groupingBehavior =
          Enumeration.of(
            if (groupingBehavior != null)
              RequestOrchestration.ActionGroupingBehavior.fromCode(groupingBehavior)
            else null,
            _groupingBehavior,
          ),
        selectionBehavior =
          Enumeration.of(
            if (selectionBehavior != null)
              RequestOrchestration.ActionSelectionBehavior.fromCode(selectionBehavior)
            else null,
            _selectionBehavior,
          ),
        requiredBehavior =
          Enumeration.of(
            if (requiredBehavior != null)
              RequestOrchestration.ActionRequiredBehavior.fromCode(requiredBehavior)
            else null,
            _requiredBehavior,
          ),
        precheckBehavior =
          Enumeration.of(
            if (precheckBehavior != null)
              RequestOrchestration.ActionPrecheckBehavior.fromCode(precheckBehavior)
            else null,
            _precheckBehavior,
          ),
        cardinalityBehavior =
          Enumeration.of(
            if (cardinalityBehavior != null)
              RequestOrchestration.ActionCardinalityBehavior.fromCode(cardinalityBehavior)
            else null,
            _cardinalityBehavior,
          ),
        resource = resource,
        definition =
          RequestOrchestration.Action.Definition.from(
            Canonical.of(definitionCanonical, _definitionCanonical),
            Uri.of(definitionUri, _definitionUri),
          ),
        transform = Canonical.of(transform, _transform),
        dynamicValue = dynamicValue ?: listOf(),
        action = action ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action) {
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
      if (value.code.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          CodeableConceptSerializer.listSerializer,
          value.code,
        )
      if (value.documentation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          RelatedArtifactSerializer.listSerializer,
          value.documentation,
        )
      if (value.goal.isNotEmpty())
        encodeSerializableElement(descriptor, 17, ReferenceSerializer.listSerializer, value.goal)
      if (value.condition.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          18,
          RequestOrchestrationActionConditionSerializer.listSerializer,
          value.condition,
        )
      if (value.input.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          19,
          RequestOrchestrationActionInputSerializer.listSerializer,
          value.input,
        )
      if (value.output.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          20,
          RequestOrchestrationActionOutputSerializer.listSerializer,
          value.output,
        )
      if (value.relatedAction.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          21,
          RequestOrchestrationActionRelatedActionSerializer.listSerializer,
          value.relatedAction,
        )
      when (val choice = value.timing) {
        null -> {}
        is RequestOrchestration.Action.Timing.DateTime -> {
          encodeStringIfNotNull(descriptor, 22, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 23, choice.value)
        }
        is RequestOrchestration.Action.Timing.Age -> {
          encodeSerializableElement(descriptor, 24, AgeSerializer, choice.value)
        }
        is RequestOrchestration.Action.Timing.Period -> {
          encodeSerializableElement(descriptor, 25, PeriodSerializer, choice.value)
        }
        is RequestOrchestration.Action.Timing.Duration -> {
          encodeSerializableElement(descriptor, 26, DurationSerializer, choice.value)
        }
        is RequestOrchestration.Action.Timing.Range -> {
          encodeSerializableElement(descriptor, 27, RangeSerializer, choice.value)
        }
        is RequestOrchestration.Action.Timing.Timing -> {
          encodeSerializableElement(descriptor, 28, TimingSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 29, CodeableReferenceSerializer, value.location)
      if (value.participant.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          30,
          RequestOrchestrationActionParticipantSerializer.listSerializer,
          value.participant,
        )
      encodeSerializableIfNotNull(descriptor, 31, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 32, value.groupingBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 33, value.groupingBehavior)
      encodeStringIfNotNull(descriptor, 34, value.selectionBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 35, value.selectionBehavior)
      encodeStringIfNotNull(descriptor, 36, value.requiredBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 37, value.requiredBehavior)
      encodeStringIfNotNull(descriptor, 38, value.precheckBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 39, value.precheckBehavior)
      encodeStringIfNotNull(descriptor, 40, value.cardinalityBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 41, value.cardinalityBehavior)
      encodeSerializableIfNotNull(descriptor, 42, ReferenceSerializer, value.resource)
      when (val choice = value.definition) {
        null -> {}
        is RequestOrchestration.Action.Definition.Canonical -> {
          encodeStringIfNotNull(descriptor, 43, choice.value.value)
          encodeElementIfNotNull(descriptor, 44, choice.value)
        }
        is RequestOrchestration.Action.Definition.Uri -> {
          encodeStringIfNotNull(descriptor, 45, choice.value.value)
          encodeElementIfNotNull(descriptor, 46, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 47, value.transform?.value)
      encodeElementIfNotNull(descriptor, 48, value.transform)
      if (value.dynamicValue.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          49,
          RequestOrchestrationActionDynamicValueSerializer.listSerializer,
          value.dynamicValue,
        )
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          50,
          RequestOrchestrationActionSerializer.listSerializer,
          value.action,
        )
    }
  }
}

internal object RequestOrchestrationActionConditionSerializer :
  KSerializer<RequestOrchestration.Action.Condition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Condition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("kind", KotlinString.serializer().descriptor)
      optionalElement("_kind", ElementSerializer.descriptor)
      optionalElement("expression", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.Condition>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Condition =
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
      RequestOrchestration.Action.Condition(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        kind =
          Enumeration.of(
            if (kind != null) RequestOrchestration.ActionConditionKind.fromCode(kind) else null,
            _kind,
          )
            ?: throw SerializationException(
              "Missing required property 'kind' on RequestOrchestration.Action.Condition"
            ),
        expression = expression,
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Condition) {
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

internal object RequestOrchestrationActionInputSerializer :
  KSerializer<RequestOrchestration.Action.Input> {
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

  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.Input>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Input =
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
      RequestOrchestration.Action.Input(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        title = R5String.of(title, _title),
        requirement = requirement,
        relatedData = Id.of(relatedData, _relatedData),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Input) {
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

internal object RequestOrchestrationActionOutputSerializer :
  KSerializer<RequestOrchestration.Action.Output> {
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

  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.Output>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Output =
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
      RequestOrchestration.Action.Output(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        title = R5String.of(title, _title),
        requirement = requirement,
        relatedData = R5String.of(relatedData, _relatedData),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Output) {
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

internal object RequestOrchestrationActionRelatedActionSerializer :
  KSerializer<RequestOrchestration.Action.RelatedAction> {
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

  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.RelatedAction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.RelatedAction =
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
      RequestOrchestration.Action.RelatedAction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        targetId =
          Id.of(targetId, _targetId)
            ?: throw SerializationException(
              "Missing required property 'targetId' on RequestOrchestration.Action.RelatedAction"
            ),
        relationship =
          Enumeration.of(
            if (relationship != null)
              RequestOrchestration.ActionRelationshipType.fromCode(relationship)
            else null,
            _relationship,
          )
            ?: throw SerializationException(
              "Missing required property 'relationship' on RequestOrchestration.Action.RelatedAction"
            ),
        endRelationship =
          Enumeration.of(
            if (endRelationship != null)
              RequestOrchestration.ActionRelationshipType.fromCode(endRelationship)
            else null,
            _endRelationship,
          ),
        offset = RequestOrchestration.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.RelatedAction) {
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
        is RequestOrchestration.Action.RelatedAction.Offset.Duration -> {
          encodeSerializableElement(descriptor, 9, DurationSerializer, choice.value)
        }
        is RequestOrchestration.Action.RelatedAction.Offset.Range -> {
          encodeSerializableElement(descriptor, 10, RangeSerializer, choice.value)
        }
      }
    }
  }
}

internal object RequestOrchestrationActionParticipantSerializer :
  KSerializer<RequestOrchestration.Action.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("typeCanonical", KotlinString.serializer().descriptor)
      optionalElement("_typeCanonical", ElementSerializer.descriptor)
      optionalElement("typeReference", ReferenceSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actorCanonical", KotlinString.serializer().descriptor)
      optionalElement("_actorCanonical", ElementSerializer.descriptor)
      optionalElement("actorReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.Participant>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Participant =
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
      var function: CodeableConcept? = null
      var actorCanonical: KotlinString? = null
      var _actorCanonical: Element? = null
      var actorReference: Reference? = null
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
          9 ->
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 -> actorCanonical = decodeStringElement(descriptor, i)
          11 ->
            _actorCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            actorReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      RequestOrchestration.Action.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) RequestOrchestration.ActionParticipantType.fromCode(type) else null,
            _type,
          ),
        typeCanonical = Canonical.of(typeCanonical, _typeCanonical),
        typeReference = typeReference,
        role = role,
        function = function,
        actor =
          RequestOrchestration.Action.Participant.Actor.from(
            Canonical.of(actorCanonical, _actorCanonical),
            actorReference,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Participant) {
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
      encodeSerializableIfNotNull(descriptor, 9, CodeableConceptSerializer, value.function)
      when (val choice = value.actor) {
        null -> {}
        is RequestOrchestration.Action.Participant.Actor.Canonical -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is RequestOrchestration.Action.Participant.Actor.Reference -> {
          encodeSerializableElement(descriptor, 12, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object RequestOrchestrationActionDynamicValueSerializer :
  KSerializer<RequestOrchestration.Action.DynamicValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DynamicValue") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("expression", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.DynamicValue>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.DynamicValue =
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
      RequestOrchestration.Action.DynamicValue(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        path = R5String.of(path, _path),
        expression = expression,
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.DynamicValue) {
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

internal object RequestOrchestrationSerializer : FhirResourceSerializer<RequestOrchestration> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("RequestOrchestration")

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
    b.optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("replaces", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("intent", KotlinString.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("priority", KotlinString.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("authoredOn", KotlinString.serializer().descriptor)
    b.optionalElement("_authoredOn", ElementSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("goal", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("action", RequestOrchestrationActionSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): RequestOrchestration {
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
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var basedOn: List<Reference>? = null
    var replaces: List<Reference>? = null
    var groupIdentifier: Identifier? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var authoredOn: KotlinString? = null
    var _authoredOn: Element? = null
    var author: Reference? = null
    var reason: List<CodeableReference>? = null
    var goal: List<Reference>? = null
    var note: List<Annotation>? = null
    var action: List<RequestOrchestration.Action>? = null
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
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          replaces =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> intent = decoder.decodeStringElement(descriptor, i)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> priority = decoder.decodeStringElement(descriptor, i)
        23 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        26 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        28 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        30 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        31 ->
          goal =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        33 ->
          action =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestOrchestrationActionSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding RequestOrchestration: " + i)
      }
    }
    return RequestOrchestration(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(index),
            _instantiatesCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'instantiatesCanonical' on RequestOrchestration has neither a value nor an id/extension"
            )
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiatesUri' on RequestOrchestration has neither a value nor an id/extension"
            )
        }),
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      groupIdentifier = groupIdentifier,
      status =
        Enumeration.of(
          if (status != null) RequestOrchestration.RequestStatus.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on RequestOrchestration"
          ),
      intent =
        Enumeration.of(
          if (intent != null) RequestOrchestration.RequestIntent.fromCode(intent) else null,
          _intent,
        )
          ?: throw SerializationException(
            "Missing required property 'intent' on RequestOrchestration"
          ),
      priority =
        Enumeration.of(
          if (priority != null) RequestOrchestration.RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      code = code,
      subject = subject,
      encounter = encounter,
      authoredOn =
        DateTime.of(
          if (authoredOn != null) FhirDateTime.fromString(authoredOn) else null,
          _authoredOn,
        ),
      author = author,
      reason = reason ?: listOf(),
      goal = goal ?: listOf(),
      note = note ?: listOf(),
      action = action ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: RequestOrchestration,
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
    if (value.instantiatesCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (value.instantiatesUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.instantiatesUri)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.replaces,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.intent)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.priority?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.priority)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      27 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.authoredOn)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.goal,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        RequestOrchestrationActionSerializer.listSerializer,
        value.action,
      )
  }
}
