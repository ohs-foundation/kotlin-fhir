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
import dev.ohs.fhir.model.r5.terminologies.ActionCardinalityBehavior
import dev.ohs.fhir.model.r5.terminologies.ActionConditionKind
import dev.ohs.fhir.model.r5.terminologies.ActionGroupingBehavior
import dev.ohs.fhir.model.r5.terminologies.ActionParticipantType
import dev.ohs.fhir.model.r5.terminologies.ActionPrecheckBehavior
import dev.ohs.fhir.model.r5.terminologies.ActionRelationshipType
import dev.ohs.fhir.model.r5.terminologies.ActionRequiredBehavior
import dev.ohs.fhir.model.r5.terminologies.ActionSelectionBehavior
import dev.ohs.fhir.model.r5.terminologies.RequestIntent
import dev.ohs.fhir.model.r5.terminologies.RequestPriority
import dev.ohs.fhir.model.r5.terminologies.RequestStatus
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

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> linkId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> prefix = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _prefix =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> textEquivalent = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _textEquivalent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> priority = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        17 ->
          goal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestOrchestrationActionConditionSerializer.listSerializer,
              null,
            )
        19 ->
          input =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestOrchestrationActionInputSerializer.listSerializer,
              null,
            )
        20 ->
          output =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestOrchestrationActionOutputSerializer.listSerializer,
              null,
            )
        21 ->
          relatedAction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestOrchestrationActionRelatedActionSerializer.listSerializer,
              null,
            )
        22 -> timingDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _timingDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          timingAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        25 ->
          timingPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        26 ->
          timingDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        27 ->
          timingRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        28 ->
          timingTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        29 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        30 ->
          participant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestOrchestrationActionParticipantSerializer.listSerializer,
              null,
            )
        31 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        32 -> groupingBehavior = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _groupingBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> selectionBehavior = compositeDecoder.decodeStringElement(descriptor, i)
        35 ->
          _selectionBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> requiredBehavior = compositeDecoder.decodeStringElement(descriptor, i)
        37 ->
          _requiredBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 -> precheckBehavior = compositeDecoder.decodeStringElement(descriptor, i)
        39 ->
          _precheckBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 -> cardinalityBehavior = compositeDecoder.decodeStringElement(descriptor, i)
        41 ->
          _cardinalityBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        43 -> definitionCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _definitionCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 -> definitionUri = compositeDecoder.decodeStringElement(descriptor, i)
        46 ->
          _definitionUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 -> transform = compositeDecoder.decodeStringElement(descriptor, i)
        48 ->
          _transform =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        49 ->
          dynamicValue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestOrchestrationActionDynamicValueSerializer.listSerializer,
              null,
            )
        50 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestOrchestrationActionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action(
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
          if (priority != null) RequestPriority.fromCode(priority) else null,
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
          if (groupingBehavior != null) ActionGroupingBehavior.fromCode(groupingBehavior) else null,
          _groupingBehavior,
        ),
      selectionBehavior =
        Enumeration.of(
          if (selectionBehavior != null) ActionSelectionBehavior.fromCode(selectionBehavior)
          else null,
          _selectionBehavior,
        ),
      requiredBehavior =
        Enumeration.of(
          if (requiredBehavior != null) ActionRequiredBehavior.fromCode(requiredBehavior) else null,
          _requiredBehavior,
        ),
      precheckBehavior =
        Enumeration.of(
          if (precheckBehavior != null) ActionPrecheckBehavior.fromCode(precheckBehavior) else null,
          _precheckBehavior,
        ),
      cardinalityBehavior =
        Enumeration.of(
          if (cardinalityBehavior != null) ActionCardinalityBehavior.fromCode(cardinalityBehavior)
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.linkId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.prefix?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.prefix)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.textEquivalent?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.textEquivalent)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.priority?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.priority)
    if (value.code.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15,
        CodeableConceptSerializer.listSerializer,
        value.code,
      )
    if (value.documentation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16,
        RelatedArtifactSerializer.listSerializer,
        value.documentation,
      )
    if (value.goal.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        17,
        ReferenceSerializer.listSerializer,
        value.goal,
      )
    if (value.condition.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18,
        RequestOrchestrationActionConditionSerializer.listSerializer,
        value.condition,
      )
    if (value.input.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19,
        RequestOrchestrationActionInputSerializer.listSerializer,
        value.input,
      )
    if (value.output.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        20,
        RequestOrchestrationActionOutputSerializer.listSerializer,
        value.output,
      )
    if (value.relatedAction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21,
        RequestOrchestrationActionRelatedActionSerializer.listSerializer,
        value.relatedAction,
      )
    when (val choice = value.timing) {
      null -> {}
      is RequestOrchestration.Action.Timing.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 22, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 23, choice.value)
      }
      is RequestOrchestration.Action.Timing.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 24, AgeSerializer, choice.value)
      }
      is RequestOrchestration.Action.Timing.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 25, PeriodSerializer, choice.value)
      }
      is RequestOrchestration.Action.Timing.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 26, DurationSerializer, choice.value)
      }
      is RequestOrchestration.Action.Timing.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 27, RangeSerializer, choice.value)
      }
      is RequestOrchestration.Action.Timing.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 28, TimingSerializer, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29,
      CodeableReferenceSerializer,
      value.location,
    )
    if (value.participant.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30,
        RequestOrchestrationActionParticipantSerializer.listSerializer,
        value.participant,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      31,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 32, value.groupingBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 33, value.groupingBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 34, value.selectionBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 35, value.selectionBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 36, value.requiredBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 37, value.requiredBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 38, value.precheckBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 39, value.precheckBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 40, value.cardinalityBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 41, value.cardinalityBehavior)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      42,
      ReferenceSerializer,
      value.resource,
    )
    when (val choice = value.definition) {
      null -> {}
      is RequestOrchestration.Action.Definition.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 43, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 44, choice.value)
      }
      is RequestOrchestration.Action.Definition.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 45, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 46, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 47, value.transform?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 48, value.transform)
    if (value.dynamicValue.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        49,
        RequestOrchestrationActionDynamicValueSerializer.listSerializer,
        value.dynamicValue,
      )
    if (value.action.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        50,
        RequestOrchestrationActionSerializer.listSerializer,
        value.action,
      )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Condition {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var expression: Expression? = null
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
        3 -> kind = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _kind =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Condition: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.Condition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      kind =
        Enumeration.of(if (kind != null) ActionConditionKind.fromCode(kind) else null, _kind)
          ?: throw SerializationException(
            "Missing required property 'kind' on RequestOrchestration.Action.Condition"
          ),
      expression = expression,
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Condition) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.kind.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.kind)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      ExpressionSerializer,
      value.expression,
    )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Input {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var requirement: DataRequirement? = null
    var relatedData: KotlinString? = null
    var _relatedData: Element? = null
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
        3 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          requirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        6 -> relatedData = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _relatedData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Input: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.Input(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R5String.of(title, _title),
      requirement = requirement,
      relatedData = Id.of(relatedData, _relatedData),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Input) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.title)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      DataRequirementSerializer,
      value.requirement,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.relatedData?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.relatedData)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Output {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var requirement: DataRequirement? = null
    var relatedData: KotlinString? = null
    var _relatedData: Element? = null
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
        3 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          requirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        6 -> relatedData = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _relatedData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Output: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.Output(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R5String.of(title, _title),
      requirement = requirement,
      relatedData = R5String.of(relatedData, _relatedData),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Output) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.title)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      DataRequirementSerializer,
      value.requirement,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.relatedData?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.relatedData)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.RelatedAction {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> targetId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _targetId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> relationship = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> endRelationship = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _endRelationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          offsetDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        10 ->
          offsetRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedAction: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.RelatedAction(
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
          if (relationship != null) ActionRelationshipType.fromCode(relationship) else null,
          _relationship,
        )
          ?: throw SerializationException(
            "Missing required property 'relationship' on RequestOrchestration.Action.RelatedAction"
          ),
      endRelationship =
        Enumeration.of(
          if (endRelationship != null) ActionRelationshipType.fromCode(endRelationship) else null,
          _endRelationship,
        ),
      offset = RequestOrchestration.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.RelatedAction) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.targetId.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.targetId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.relationship.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.relationship)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.endRelationship?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.endRelationship)
    when (val choice = value.offset) {
      null -> {}
      is RequestOrchestration.Action.RelatedAction.Offset.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, DurationSerializer, choice.value)
      }
      is RequestOrchestration.Action.RelatedAction.Offset.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 10, RangeSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Participant {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> typeCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _typeCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          typeReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          function =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 -> actorCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _actorCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          actorReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(if (type != null) ActionParticipantType.fromCode(type) else null, _type),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.typeCanonical?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.typeCanonical)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      ReferenceSerializer,
      value.typeReference,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CodeableConceptSerializer,
      value.role,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.function,
    )
    when (val choice = value.actor) {
      null -> {}
      is RequestOrchestration.Action.Participant.Actor.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is RequestOrchestration.Action.Participant.Actor.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          12,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.DynamicValue {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var expression: Expression? = null
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
        3 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DynamicValue: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.DynamicValue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path = R5String.of(path, _path),
      expression = expression,
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.DynamicValue) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.path?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.path)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      ExpressionSerializer,
      value.expression,
    )
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
        11 ->
          instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          replaces =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          groupIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        18 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> intent = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _intent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> priority = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        26 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        27 -> authoredOn = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _authoredOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        30 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        31 ->
          goal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        33 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
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
        Enumeration.of(if (status != null) RequestStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on RequestOrchestration"
          ),
      intent =
        Enumeration.of(if (intent != null) RequestIntent.fromCode(intent) else null, _intent)
          ?: throw SerializationException(
            "Missing required property 'intent' on RequestOrchestration"
          ),
      priority =
        Enumeration.of(
          if (priority != null) RequestPriority.fromCode(priority) else null,
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: RequestOrchestration,
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
    if (value.instantiatesCanonical.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (value.instantiatesUri.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        14 + descriptorOffset,
        value.instantiatesUri,
      )
    }
    if (value.basedOn.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.replaces.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.replaces,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.intent.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.intent)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.priority?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.priority)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      27 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.authoredOn)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    if (value.reason.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    if (value.goal.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.goal,
      )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.action.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        RequestOrchestrationActionSerializer.listSerializer,
        value.action,
      )
  }
}
