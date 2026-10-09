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
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object RequestOrchestrationActionSerializer : FhirSerializer<RequestOrchestration.Action> {
  override val descriptor: SerialDescriptor = buildDescriptor("Action", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestOrchestration.Action>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("linkId")
    b.strPrim("prefix")
    b.strPrim("title")
    b.strPrim("description")
    b.strPrim("textEquivalent")
    b.strPrim("priority")
    b.optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("documentation", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("goal", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "condition",
      RequestOrchestrationActionConditionSerializer.listSerializer.descriptor,
    )
    b.optionalElement("input", RequestOrchestrationActionInputSerializer.listSerializer.descriptor)
    b.optionalElement(
      "output",
      RequestOrchestrationActionOutputSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "relatedAction",
      RequestOrchestrationActionRelatedActionSerializer.listSerializer.descriptor,
    )
    b.strPrim("timingDateTime")
    b.optionalElement("timingAge", AgeSerializer.descriptor)
    b.optionalElement("timingPeriod", PeriodSerializer.descriptor)
    b.optionalElement("timingDuration", DurationSerializer.descriptor)
    b.optionalElement("timingRange", RangeSerializer.descriptor)
    b.optionalElement("timingTiming", TimingSerializer.descriptor)
    b.optionalElement("location", CodeableReferenceSerializer.descriptor)
    b.optionalElement(
      "participant",
      RequestOrchestrationActionParticipantSerializer.listSerializer.descriptor,
    )
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("groupingBehavior")
    b.strPrim("selectionBehavior")
    b.strPrim("requiredBehavior")
    b.strPrim("precheckBehavior")
    b.strPrim("cardinalityBehavior")
    b.optionalElement("resource", ReferenceSerializer.descriptor)
    b.strPrim("definitionCanonical")
    b.strPrim("definitionUri")
    b.strPrim("transform")
    b.optionalElement(
      "dynamicValue",
      RequestOrchestrationActionDynamicValueSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "action",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.RequestOrchestrationActionSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action {
    val descriptor = this.descriptor
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
    var priority: RequestPriority? = null
    var _priority: Element? = null
    var code: List<CodeableConcept>? = null
    var documentation: List<RelatedArtifact>? = null
    var goal: List<Reference>? = null
    var condition: List<RequestOrchestration.Action.Condition>? = null
    var input: List<RequestOrchestration.Action.Input>? = null
    var output: List<RequestOrchestration.Action.Output>? = null
    var relatedAction: List<RequestOrchestration.Action.RelatedAction>? = null
    var timingDateTime: FhirDateTime? = null
    var _timingDateTime: Element? = null
    var timingAge: Age? = null
    var timingPeriod: Period? = null
    var timingDuration: Duration? = null
    var timingRange: Range? = null
    var timingTiming: Timing? = null
    var location: CodeableReference? = null
    var participant: List<RequestOrchestration.Action.Participant>? = null
    var type: CodeableConcept? = null
    var groupingBehavior: ActionGroupingBehavior? = null
    var _groupingBehavior: Element? = null
    var selectionBehavior: ActionSelectionBehavior? = null
    var _selectionBehavior: Element? = null
    var requiredBehavior: ActionRequiredBehavior? = null
    var _requiredBehavior: Element? = null
    var precheckBehavior: ActionPrecheckBehavior? = null
    var _precheckBehavior: Element? = null
    var cardinalityBehavior: ActionCardinalityBehavior? = null
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
        13 ->
          priority = RequestPriority.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        22 ->
          timingDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        32 ->
          groupingBehavior =
            ActionGroupingBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        33 ->
          _groupingBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          selectionBehavior =
            ActionSelectionBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        35 ->
          _selectionBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          requiredBehavior =
            ActionRequiredBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        37 ->
          _requiredBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 ->
          precheckBehavior =
            ActionPrecheckBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        39 ->
          _precheckBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 ->
          cardinalityBehavior =
            ActionCardinalityBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      linkId = R5String.of(linkId, _linkId),
      prefix = R5String.of(prefix, _prefix),
      title = R5String.of(title, _title),
      description = Markdown.of(description, _description),
      textEquivalent = Markdown.of(textEquivalent, _textEquivalent),
      priority = Enumeration.of(priority, _priority),
      code = listOrEmpty(code),
      documentation = listOrEmpty(documentation),
      goal = listOrEmpty(goal),
      condition = listOrEmpty(condition),
      input = listOrEmpty(input),
      output = listOrEmpty(output),
      relatedAction = listOrEmpty(relatedAction),
      timing =
        RequestOrchestration.Action.Timing.from(
          DateTime.of(timingDateTime, _timingDateTime),
          timingAge,
          timingPeriod,
          timingDuration,
          timingRange,
          timingTiming,
        ),
      location = location,
      participant = listOrEmpty(participant),
      type = type,
      groupingBehavior = Enumeration.of(groupingBehavior, _groupingBehavior),
      selectionBehavior = Enumeration.of(selectionBehavior, _selectionBehavior),
      requiredBehavior = Enumeration.of(requiredBehavior, _requiredBehavior),
      precheckBehavior = Enumeration.of(precheckBehavior, _precheckBehavior),
      cardinalityBehavior = Enumeration.of(cardinalityBehavior, _cardinalityBehavior),
      resource = resource,
      definition =
        RequestOrchestration.Action.Definition.from(
          Canonical.of(definitionCanonical, _definitionCanonical),
          Uri.of(definitionUri, _definitionUri),
        ),
      transform = Canonical.of(transform, _transform),
      dynamicValue = listOrEmpty(dynamicValue),
      action = listOrEmpty(action),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      CodeableConceptSerializer.listSerializer,
      value.code,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16,
      RelatedArtifactSerializer.listSerializer,
      value.documentation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17,
      ReferenceSerializer.listSerializer,
      value.goal,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18,
      RequestOrchestrationActionConditionSerializer.listSerializer,
      value.condition,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19,
      RequestOrchestrationActionInputSerializer.listSerializer,
      value.input,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      20,
      RequestOrchestrationActionOutputSerializer.listSerializer,
      value.output,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      49,
      RequestOrchestrationActionDynamicValueSerializer.listSerializer,
      value.dynamicValue,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50,
      RequestOrchestrationActionSerializer.listSerializer,
      value.action,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object RequestOrchestrationActionConditionSerializer :
  FhirSerializer<RequestOrchestration.Action.Condition> {
  override val descriptor: SerialDescriptor = buildDescriptor("Condition", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.Condition>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("kind")
    b.optionalElement("expression", ExpressionSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Condition {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var kind: ActionConditionKind? = null
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
        3 ->
          kind = ActionConditionKind.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.Condition(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      kind = required(Enumeration.of(kind, _kind), "RequestOrchestration.Action.Condition", "kind"),
      expression = expression,
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Condition) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<RequestOrchestration.Action.Input> {
  override val descriptor: SerialDescriptor = buildDescriptor("Input", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.Input>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("title")
    b.optionalElement("requirement", DataRequirementSerializer.descriptor)
    b.strPrim("relatedData")
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Input {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.Input(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      title = R5String.of(title, _title),
      requirement = requirement,
      relatedData = Id.of(relatedData, _relatedData),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Input) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<RequestOrchestration.Action.Output> {
  override val descriptor: SerialDescriptor = buildDescriptor("Output", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.Output>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("title")
    b.optionalElement("requirement", DataRequirementSerializer.descriptor)
    b.strPrim("relatedData")
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Output {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.Output(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      title = R5String.of(title, _title),
      requirement = requirement,
      relatedData = R5String.of(relatedData, _relatedData),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Output) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<RequestOrchestration.Action.RelatedAction> {
  override val descriptor: SerialDescriptor = buildDescriptor("RelatedAction", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.RelatedAction>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("targetId")
    b.strPrim("relationship")
    b.strPrim("endRelationship")
    b.optionalElement("offsetDuration", DurationSerializer.descriptor)
    b.optionalElement("offsetRange", RangeSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.RelatedAction {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var targetId: KotlinString? = null
    var _targetId: Element? = null
    var relationship: ActionRelationshipType? = null
    var _relationship: Element? = null
    var endRelationship: ActionRelationshipType? = null
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
        5 ->
          relationship =
            ActionRelationshipType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          endRelationship =
            ActionRelationshipType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.RelatedAction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      targetId =
        required(
          Id.of(targetId, _targetId),
          "RequestOrchestration.Action.RelatedAction",
          "targetId",
        ),
      relationship =
        required(
          Enumeration.of(relationship, _relationship),
          "RequestOrchestration.Action.RelatedAction",
          "relationship",
        ),
      endRelationship = Enumeration.of(endRelationship, _endRelationship),
      offset = RequestOrchestration.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.RelatedAction) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<RequestOrchestration.Action.Participant> {
  override val descriptor: SerialDescriptor = buildDescriptor("Participant", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.Participant>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("typeCanonical")
    b.optionalElement("typeReference", ReferenceSerializer.descriptor)
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
    b.optionalElement("function", CodeableConceptSerializer.descriptor)
    b.strPrim("actorCanonical")
    b.optionalElement("actorReference", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Participant {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: ActionParticipantType? = null
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
        3 ->
          type = ActionParticipantType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.Participant(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = Enumeration.of(type, _type),
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
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<RequestOrchestration.Action.DynamicValue> {
  override val descriptor: SerialDescriptor = buildDescriptor("DynamicValue", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestOrchestration.Action.DynamicValue>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("path")
    b.optionalElement("expression", ExpressionSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.DynamicValue {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestOrchestration.Action.DynamicValue(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      path = R5String.of(path, _path),
      expression = expression,
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.DynamicValue) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrimList("instantiatesCanonical")
    b.strPrimList("instantiatesUri")
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("replaces", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.strPrim("status")
    b.strPrim("intent")
    b.strPrim("priority")
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.strPrim("authoredOn")
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
    var status: RequestStatus? = null
    var _status: Element? = null
    var intent: RequestIntent? = null
    var _intent: Element? = null
    var priority: RequestPriority? = null
    var _priority: Element? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var authoredOn: FhirDateTime? = null
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
        18 -> status = RequestStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        19 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> intent = RequestIntent.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        21 ->
          _intent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          priority = RequestPriority.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        27 ->
          authoredOn = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    val instantiatesCanonical_ =
      List(maxSize(instantiatesCanonical, _instantiatesCanonical)) { index ->
        entryRequired(
          Canonical.of(at(instantiatesCanonical, index), at(_instantiatesCanonical, index)),
          "RequestOrchestration",
          "instantiatesCanonical",
        )
      }
    val instantiatesUri_ =
      List(maxSize(instantiatesUri, _instantiatesUri)) { index ->
        entryRequired(
          Uri.of(at(instantiatesUri, index), at(_instantiatesUri, index)),
          "RequestOrchestration",
          "instantiatesUri",
        )
      }
    return RequestOrchestration(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      instantiatesCanonical = instantiatesCanonical_,
      instantiatesUri = instantiatesUri_,
      basedOn = listOrEmpty(basedOn),
      replaces = listOrEmpty(replaces),
      groupIdentifier = groupIdentifier,
      status = required(Enumeration.of(status, _status), "RequestOrchestration", "status"),
      intent = required(Enumeration.of(intent, _intent), "RequestOrchestration", "intent"),
      priority = Enumeration.of(priority, _priority),
      code = code,
      subject = subject,
      encounter = encounter,
      authoredOn = DateTime.of(authoredOn, _authoredOn),
      author = author,
      reason = listOrEmpty(reason),
      goal = listOrEmpty(goal),
      note = listOrEmpty(note),
      action = listOrEmpty(action),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    if (!value.instantiatesCanonical.isEmpty()) {
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
    if (!value.instantiatesUri.isEmpty()) {
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.basedOn,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      CodeableReferenceSerializer.listSerializer,
      value.reason,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.goal,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      RequestOrchestrationActionSerializer.listSerializer,
      value.action,
    )
  }
}
