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

import dev.ohs.fhir.model.r4.Age
import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.RequestGroup
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.ActionCardinalityBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionConditionKind
import dev.ohs.fhir.model.r4.terminologies.ActionGroupingBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionPrecheckBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionRelationshipType
import dev.ohs.fhir.model.r4.terminologies.ActionRequiredBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionSelectionBehavior
import dev.ohs.fhir.model.r4.terminologies.RequestIntent
import dev.ohs.fhir.model.r4.terminologies.RequestPriority
import dev.ohs.fhir.model.r4.terminologies.RequestStatus
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

internal object RequestGroupActionSerializer : FhirSerializer<RequestGroup.Action> {
  override val descriptor: SerialDescriptor = buildDescriptor("Action", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestGroup.Action>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("prefix")
    b.strPrim("title")
    b.strPrim("description")
    b.strPrim("textEquivalent")
    b.strPrim("priority")
    b.optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("documentation", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("condition", RequestGroupActionConditionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "relatedAction",
      RequestGroupActionRelatedActionSerializer.listSerializer.descriptor,
    )
    b.strPrim("timingDateTime")
    b.optionalElement("timingAge", AgeSerializer.descriptor)
    b.optionalElement("timingPeriod", PeriodSerializer.descriptor)
    b.optionalElement("timingDuration", DurationSerializer.descriptor)
    b.optionalElement("timingRange", RangeSerializer.descriptor)
    b.optionalElement("timingTiming", TimingSerializer.descriptor)
    b.optionalElement("participant", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("groupingBehavior")
    b.strPrim("selectionBehavior")
    b.strPrim("requiredBehavior")
    b.strPrim("precheckBehavior")
    b.strPrim("cardinalityBehavior")
    b.optionalElement("resource", ReferenceSerializer.descriptor)
    b.optionalElement(
      "action",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.RequestGroupActionSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): RequestGroup.Action {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
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
    var condition: List<RequestGroup.Action.Condition>? = null
    var relatedAction: List<RequestGroup.Action.RelatedAction>? = null
    var timingDateTime: FhirDateTime? = null
    var _timingDateTime: Element? = null
    var timingAge: Age? = null
    var timingPeriod: Period? = null
    var timingDuration: Duration? = null
    var timingRange: Range? = null
    var timingTiming: Timing? = null
    var participant: List<Reference>? = null
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
    var action: List<RequestGroup.Action>? = null
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
        3 -> prefix = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _prefix =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> textEquivalent = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _textEquivalent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          priority = RequestPriority.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        15 ->
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestGroupActionConditionSerializer.listSerializer,
              null,
            )
        16 ->
          relatedAction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestGroupActionRelatedActionSerializer.listSerializer,
              null,
            )
        17 ->
          timingDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        18 ->
          _timingDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          timingAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        20 ->
          timingPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        21 ->
          timingDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        22 ->
          timingRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        23 ->
          timingTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        24 ->
          participant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        25 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          groupingBehavior =
            ActionGroupingBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        27 ->
          _groupingBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 ->
          selectionBehavior =
            ActionSelectionBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        29 ->
          _selectionBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          requiredBehavior =
            ActionRequiredBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        31 ->
          _requiredBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          precheckBehavior =
            ActionPrecheckBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        33 ->
          _precheckBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          cardinalityBehavior =
            ActionCardinalityBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        35 ->
          _cardinalityBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        37 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestGroupActionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestGroup.Action(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      prefix = R4String.of(prefix, _prefix),
      title = R4String.of(title, _title),
      description = R4String.of(description, _description),
      textEquivalent = R4String.of(textEquivalent, _textEquivalent),
      priority = Enumeration.of(priority, _priority),
      code = listOrEmpty(code),
      documentation = listOrEmpty(documentation),
      condition = listOrEmpty(condition),
      relatedAction = listOrEmpty(relatedAction),
      timing =
        RequestGroup.Action.Timing.from(
          DateTime.of(timingDateTime, _timingDateTime),
          timingAge,
          timingPeriod,
          timingDuration,
          timingRange,
          timingTiming,
        ),
      participant = listOrEmpty(participant),
      type = type,
      groupingBehavior = Enumeration.of(groupingBehavior, _groupingBehavior),
      selectionBehavior = Enumeration.of(selectionBehavior, _selectionBehavior),
      requiredBehavior = Enumeration.of(requiredBehavior, _requiredBehavior),
      precheckBehavior = Enumeration.of(precheckBehavior, _precheckBehavior),
      cardinalityBehavior = Enumeration.of(cardinalityBehavior, _cardinalityBehavior),
      resource = resource,
      action = listOrEmpty(action),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.prefix?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.prefix)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.textEquivalent?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.textEquivalent)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.priority?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.priority)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      CodeableConceptSerializer.listSerializer,
      value.code,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      RelatedArtifactSerializer.listSerializer,
      value.documentation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      RequestGroupActionConditionSerializer.listSerializer,
      value.condition,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16,
      RequestGroupActionRelatedActionSerializer.listSerializer,
      value.relatedAction,
    )
    when (val choice = value.timing) {
      null -> {}
      is RequestGroup.Action.Timing.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 17, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
      is RequestGroup.Action.Timing.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 19, AgeSerializer, choice.value)
      }
      is RequestGroup.Action.Timing.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 20, PeriodSerializer, choice.value)
      }
      is RequestGroup.Action.Timing.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 21, DurationSerializer, choice.value)
      }
      is RequestGroup.Action.Timing.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 22, RangeSerializer, choice.value)
      }
      is RequestGroup.Action.Timing.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 23, TimingSerializer, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24,
      ReferenceSerializer.listSerializer,
      value.participant,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 26, value.groupingBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 27, value.groupingBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 28, value.selectionBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 29, value.selectionBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 30, value.requiredBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 31, value.requiredBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 32, value.precheckBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 33, value.precheckBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 34, value.cardinalityBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 35, value.cardinalityBehavior)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      36,
      ReferenceSerializer,
      value.resource,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      37,
      RequestGroupActionSerializer.listSerializer,
      value.action,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object RequestGroupActionConditionSerializer :
  FhirSerializer<RequestGroup.Action.Condition> {
  override val descriptor: SerialDescriptor = buildDescriptor("Condition", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestGroup.Action.Condition>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("kind")
    b.optionalElement("expression", ExpressionSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestGroup.Action.Condition {
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
    return RequestGroup.Action.Condition(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      kind = required(Enumeration.of(kind, _kind), "RequestGroup.Action.Condition", "kind"),
      expression = expression,
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.Condition) {
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

internal object RequestGroupActionRelatedActionSerializer :
  FhirSerializer<RequestGroup.Action.RelatedAction> {
  override val descriptor: SerialDescriptor = buildDescriptor("RelatedAction", this)

  @JvmField
  internal val listSerializer: KSerializer<List<RequestGroup.Action.RelatedAction>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("actionId")
    b.strPrim("relationship")
    b.optionalElement("offsetDuration", DurationSerializer.descriptor)
    b.optionalElement("offsetRange", RangeSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestGroup.Action.RelatedAction {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var actionId: KotlinString? = null
    var _actionId: Element? = null
    var relationship: ActionRelationshipType? = null
    var _relationship: Element? = null
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
        3 -> actionId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _actionId =
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
          offsetDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        8 ->
          offsetRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RequestGroup.Action.RelatedAction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      actionId =
        required(Id.of(actionId, _actionId), "RequestGroup.Action.RelatedAction", "actionId"),
      relationship =
        required(
          Enumeration.of(relationship, _relationship),
          "RequestGroup.Action.RelatedAction",
          "relationship",
        ),
      offset = RequestGroup.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.RelatedAction) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.actionId.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.actionId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.relationship.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.relationship)
    when (val choice = value.offset) {
      null -> {}
      is RequestGroup.Action.RelatedAction.Offset.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, DurationSerializer, choice.value)
      }
      is RequestGroup.Action.RelatedAction.Offset.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, RangeSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object RequestGroupSerializer : FhirResourceSerializer<RequestGroup> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("RequestGroup")

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
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("action", RequestGroupActionSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): RequestGroup {
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
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var note: List<Annotation>? = null
    var action: List<RequestGroup.Action>? = null
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
          reasonCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 ->
          reasonReference =
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
              RequestGroupActionSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val instantiatesCanonical_ =
      List(maxSize(instantiatesCanonical, _instantiatesCanonical)) { index ->
        entryRequired(
          Canonical.of(at(instantiatesCanonical, index), at(_instantiatesCanonical, index)),
          "RequestGroup",
          "instantiatesCanonical",
        )
      }
    val instantiatesUri_ =
      List(maxSize(instantiatesUri, _instantiatesUri)) { index ->
        entryRequired(
          Uri.of(at(instantiatesUri, index), at(_instantiatesUri, index)),
          "RequestGroup",
          "instantiatesUri",
        )
      }
    return RequestGroup(
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
      status = required(Enumeration.of(status, _status), "RequestGroup", "status"),
      intent = required(Enumeration.of(intent, _intent), "RequestGroup", "intent"),
      priority = Enumeration.of(priority, _priority),
      code = code,
      subject = subject,
      encounter = encounter,
      authoredOn = DateTime.of(authoredOn, _authoredOn),
      author = author,
      reasonCode = listOrEmpty(reasonCode),
      reasonReference = listOrEmpty(reasonReference),
      note = listOrEmpty(note),
      action = listOrEmpty(action),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: RequestGroup,
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
      CodeableConceptSerializer.listSerializer,
      value.reasonCode,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.reasonReference,
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
      RequestGroupActionSerializer.listSerializer,
      value.action,
    )
  }
}
