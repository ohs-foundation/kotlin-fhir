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
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.TriggerDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.ActionCardinalityBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionConditionKind
import dev.ohs.fhir.model.r4.terminologies.ActionGroupingBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionParticipantType
import dev.ohs.fhir.model.r4.terminologies.ActionPrecheckBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionRelationshipType
import dev.ohs.fhir.model.r4.terminologies.ActionRequiredBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionSelectionBehavior
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.RequestPriority
import kotlin.Boolean as KotlinBoolean
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

internal object PlanDefinitionGoalSerializer : FhirSerializer<PlanDefinition.Goal> {
  override val descriptor: SerialDescriptor = buildDescriptor("Goal", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PlanDefinition.Goal>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("description", CodeableConceptSerializer.descriptor)
    b.optionalElement("priority", CodeableConceptSerializer.descriptor)
    b.optionalElement("start", CodeableConceptSerializer.descriptor)
    b.optionalElement("addresses", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("documentation", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("target", PlanDefinitionGoalTargetSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          start =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          addresses =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        9 ->
          target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionGoalTargetSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PlanDefinition.Goal(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      category = category,
      description = required(description, "PlanDefinition.Goal", "description"),
      priority = priority,
      start = start,
      addresses = listOrEmpty(addresses),
      documentation = listOrEmpty(documentation),
      target = listOrEmpty(target),
    )
  }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.description,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.priority,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.start,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.addresses,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      RelatedArtifactSerializer.listSerializer,
      value.documentation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      PlanDefinitionGoalTargetSerializer.listSerializer,
      value.target,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PlanDefinitionGoalTargetSerializer : FhirSerializer<PlanDefinition.Goal.Target> {
  override val descriptor: SerialDescriptor = buildDescriptor("Target", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PlanDefinition.Goal.Target>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("measure", CodeableConceptSerializer.descriptor)
    b.optionalElement("detailQuantity", QuantitySerializer.descriptor)
    b.optionalElement("detailRange", RangeSerializer.descriptor)
    b.optionalElement("detailCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("due", DurationSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal.Target {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var measure: CodeableConcept? = null
    var detailQuantity: Quantity? = null
    var detailRange: Range? = null
    var detailCodeableConcept: CodeableConcept? = null
    var due: Duration? = null
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
          measure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          detailQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 ->
          detailRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        6 ->
          detailCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          due =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PlanDefinition.Goal.Target(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      measure = measure,
      detail =
        PlanDefinition.Goal.Target.Detail.from(detailQuantity, detailRange, detailCodeableConcept),
      due = due,
    )
  }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal.Target) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.measure,
    )
    when (val choice = value.detail) {
      null -> {}
      is PlanDefinition.Goal.Target.Detail.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
      }
      is PlanDefinition.Goal.Target.Detail.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, RangeSerializer, choice.value)
      }
      is PlanDefinition.Goal.Target.Detail.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, DurationSerializer, value.due)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PlanDefinitionActionSerializer : FhirSerializer<PlanDefinition.Action> {
  override val descriptor: SerialDescriptor = buildDescriptor("Action", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PlanDefinition.Action>> = ListSerializer(this)

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
    b.optionalElement("reason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("documentation", RelatedArtifactSerializer.listSerializer.descriptor)
    b.strPrimList("goalId")
    b.optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("subjectReference", ReferenceSerializer.descriptor)
    b.optionalElement("trigger", TriggerDefinitionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "condition",
      PlanDefinitionActionConditionSerializer.listSerializer.descriptor,
    )
    b.optionalElement("input", DataRequirementSerializer.listSerializer.descriptor)
    b.optionalElement("output", DataRequirementSerializer.listSerializer.descriptor)
    b.optionalElement(
      "relatedAction",
      PlanDefinitionActionRelatedActionSerializer.listSerializer.descriptor,
    )
    b.strPrim("timingDateTime")
    b.optionalElement("timingAge", AgeSerializer.descriptor)
    b.optionalElement("timingPeriod", PeriodSerializer.descriptor)
    b.optionalElement("timingDuration", DurationSerializer.descriptor)
    b.optionalElement("timingRange", RangeSerializer.descriptor)
    b.optionalElement("timingTiming", TimingSerializer.descriptor)
    b.optionalElement(
      "participant",
      PlanDefinitionActionParticipantSerializer.listSerializer.descriptor,
    )
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("groupingBehavior")
    b.strPrim("selectionBehavior")
    b.strPrim("requiredBehavior")
    b.strPrim("precheckBehavior")
    b.strPrim("cardinalityBehavior")
    b.strPrim("definitionCanonical")
    b.strPrim("definitionUri")
    b.strPrim("transform")
    b.optionalElement(
      "dynamicValue",
      PlanDefinitionActionDynamicValueSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "action",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.PlanDefinitionActionSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action {
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
    var reason: List<CodeableConcept>? = null
    var documentation: List<RelatedArtifact>? = null
    var goalId: List<KotlinString?>? = null
    var _goalId: List<Element?>? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var trigger: List<TriggerDefinition>? = null
    var condition: List<PlanDefinition.Action.Condition>? = null
    var input: List<DataRequirement>? = null
    var output: List<DataRequirement>? = null
    var relatedAction: List<PlanDefinition.Action.RelatedAction>? = null
    var timingDateTime: FhirDateTime? = null
    var _timingDateTime: Element? = null
    var timingAge: Age? = null
    var timingPeriod: Period? = null
    var timingDuration: Duration? = null
    var timingRange: Range? = null
    var timingTiming: Timing? = null
    var participant: List<PlanDefinition.Action.Participant>? = null
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
    var definitionCanonical: KotlinString? = null
    var _definitionCanonical: Element? = null
    var definitionUri: KotlinString? = null
    var _definitionUri: Element? = null
    var transform: KotlinString? = null
    var _transform: Element? = null
    var dynamicValue: List<PlanDefinition.Action.DynamicValue>? = null
    var action: List<PlanDefinition.Action>? = null
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
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        16 ->
          goalId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _goalId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          subjectCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          subjectReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        20 ->
          trigger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer.listSerializer,
              null,
            )
        21 ->
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionActionConditionSerializer.listSerializer,
              null,
            )
        22 ->
          input =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer.listSerializer,
              null,
            )
        23 ->
          output =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer.listSerializer,
              null,
            )
        24 ->
          relatedAction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionActionRelatedActionSerializer.listSerializer,
              null,
            )
        25 ->
          timingDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        26 ->
          _timingDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          timingAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        28 ->
          timingPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        29 ->
          timingDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        30 ->
          timingRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        31 ->
          timingTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        32 ->
          participant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionActionParticipantSerializer.listSerializer,
              null,
            )
        33 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        34 ->
          groupingBehavior =
            ActionGroupingBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        35 ->
          _groupingBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          selectionBehavior =
            ActionSelectionBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        37 ->
          _selectionBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 ->
          requiredBehavior =
            ActionRequiredBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        39 ->
          _requiredBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 ->
          precheckBehavior =
            ActionPrecheckBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        41 ->
          _precheckBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 ->
          cardinalityBehavior =
            ActionCardinalityBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        43 ->
          _cardinalityBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        44 -> definitionCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        45 ->
          _definitionCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        46 -> definitionUri = compositeDecoder.decodeStringElement(descriptor, i)
        47 ->
          _definitionUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        48 -> transform = compositeDecoder.decodeStringElement(descriptor, i)
        49 ->
          _transform =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        50 ->
          dynamicValue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionActionDynamicValueSerializer.listSerializer,
              null,
            )
        51 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionActionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val goalId_ =
      List(maxSize(goalId, _goalId)) { index ->
        entryRequired(
          Id.of(at(goalId, index), at(_goalId, index)),
          "PlanDefinition.Action",
          "goalId",
        )
      }
    return PlanDefinition.Action(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      prefix = R4String.of(prefix, _prefix),
      title = R4String.of(title, _title),
      description = R4String.of(description, _description),
      textEquivalent = R4String.of(textEquivalent, _textEquivalent),
      priority = Enumeration.of(priority, _priority),
      code = listOrEmpty(code),
      reason = listOrEmpty(reason),
      documentation = listOrEmpty(documentation),
      goalId = goalId_,
      subject = PlanDefinition.Action.Subject.from(subjectCodeableConcept, subjectReference),
      trigger = listOrEmpty(trigger),
      condition = listOrEmpty(condition),
      input = listOrEmpty(input),
      output = listOrEmpty(output),
      relatedAction = listOrEmpty(relatedAction),
      timing =
        PlanDefinition.Action.Timing.from(
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
      definition =
        PlanDefinition.Action.Definition.from(
          Canonical.of(definitionCanonical, _definitionCanonical),
          Uri.of(definitionUri, _definitionUri),
        ),
      transform = Canonical.of(transform, _transform),
      dynamicValue = listOrEmpty(dynamicValue),
      action = listOrEmpty(action),
    )
  }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action) {
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
      CodeableConceptSerializer.listSerializer,
      value.reason,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      RelatedArtifactSerializer.listSerializer,
      value.documentation,
    )
    if (!value.goalId.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        16,
        stringNullableListSerializer,
        value.goalId.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 17, value.goalId)
    }
    when (val choice = value.subject) {
      null -> {}
      is PlanDefinition.Action.Subject.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          18,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is PlanDefinition.Action.Subject.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          19,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      20,
      TriggerDefinitionSerializer.listSerializer,
      value.trigger,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21,
      PlanDefinitionActionConditionSerializer.listSerializer,
      value.condition,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22,
      DataRequirementSerializer.listSerializer,
      value.input,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23,
      DataRequirementSerializer.listSerializer,
      value.output,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24,
      PlanDefinitionActionRelatedActionSerializer.listSerializer,
      value.relatedAction,
    )
    when (val choice = value.timing) {
      null -> {}
      is PlanDefinition.Action.Timing.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 25, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 26, choice.value)
      }
      is PlanDefinition.Action.Timing.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 27, AgeSerializer, choice.value)
      }
      is PlanDefinition.Action.Timing.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 28, PeriodSerializer, choice.value)
      }
      is PlanDefinition.Action.Timing.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 29, DurationSerializer, choice.value)
      }
      is PlanDefinition.Action.Timing.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 30, RangeSerializer, choice.value)
      }
      is PlanDefinition.Action.Timing.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 31, TimingSerializer, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32,
      PlanDefinitionActionParticipantSerializer.listSerializer,
      value.participant,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      33,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 34, value.groupingBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 35, value.groupingBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 36, value.selectionBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 37, value.selectionBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 38, value.requiredBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 39, value.requiredBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 40, value.precheckBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 41, value.precheckBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 42, value.cardinalityBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 43, value.cardinalityBehavior)
    when (val choice = value.definition) {
      null -> {}
      is PlanDefinition.Action.Definition.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 44, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 45, choice.value)
      }
      is PlanDefinition.Action.Definition.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 46, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 47, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 48, value.transform?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 49, value.transform)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50,
      PlanDefinitionActionDynamicValueSerializer.listSerializer,
      value.dynamicValue,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      51,
      PlanDefinitionActionSerializer.listSerializer,
      value.action,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PlanDefinitionActionConditionSerializer :
  FhirSerializer<PlanDefinition.Action.Condition> {
  override val descriptor: SerialDescriptor = buildDescriptor("Condition", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PlanDefinition.Action.Condition>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("kind")
    b.optionalElement("expression", ExpressionSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Condition {
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
    return PlanDefinition.Action.Condition(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      kind = required(Enumeration.of(kind, _kind), "PlanDefinition.Action.Condition", "kind"),
      expression = expression,
    )
  }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Condition) {
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

internal object PlanDefinitionActionRelatedActionSerializer :
  FhirSerializer<PlanDefinition.Action.RelatedAction> {
  override val descriptor: SerialDescriptor = buildDescriptor("RelatedAction", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PlanDefinition.Action.RelatedAction>> =
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

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.RelatedAction {
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
    return PlanDefinition.Action.RelatedAction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      actionId =
        required(Id.of(actionId, _actionId), "PlanDefinition.Action.RelatedAction", "actionId"),
      relationship =
        required(
          Enumeration.of(relationship, _relationship),
          "PlanDefinition.Action.RelatedAction",
          "relationship",
        ),
      offset = PlanDefinition.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.RelatedAction) {
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
      is PlanDefinition.Action.RelatedAction.Offset.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, DurationSerializer, choice.value)
      }
      is PlanDefinition.Action.RelatedAction.Offset.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, RangeSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PlanDefinitionActionParticipantSerializer :
  FhirSerializer<PlanDefinition.Action.Participant> {
  override val descriptor: SerialDescriptor = buildDescriptor("Participant", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PlanDefinition.Action.Participant>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Participant {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: ActionParticipantType? = null
    var _type: Element? = null
    var role: CodeableConcept? = null
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
        5 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PlanDefinition.Action.Participant(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(Enumeration.of(type, _type), "PlanDefinition.Action.Participant", "type"),
      role = role,
    )
  }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Participant) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.role,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PlanDefinitionActionDynamicValueSerializer :
  FhirSerializer<PlanDefinition.Action.DynamicValue> {
  override val descriptor: SerialDescriptor = buildDescriptor("DynamicValue", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PlanDefinition.Action.DynamicValue>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("path")
    b.optionalElement("expression", ExpressionSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.DynamicValue {
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
    return PlanDefinition.Action.DynamicValue(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      path = R4String.of(path, _path),
      expression = expression,
    )
  }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.DynamicValue) {
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

internal object PlanDefinitionSerializer : FhirResourceSerializer<PlanDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("PlanDefinition")

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
    b.strPrim("url")
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("version")
    b.strPrim("name")
    b.strPrim("title")
    b.strPrim("subtitle")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("status")
    b.boolPrim("experimental")
    b.optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("subjectReference", ReferenceSerializer.descriptor)
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("usage")
    b.strPrim("copyright")
    b.strPrim("approvalDate")
    b.strPrim("lastReviewDate")
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("topic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.strPrimList("library")
    b.optionalElement("goal", PlanDefinitionGoalSerializer.listSerializer.descriptor)
    b.optionalElement("action", PlanDefinitionActionSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var type: CodeableConcept? = null
    var status: PublicationStatus? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: FhirDateTime? = null
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
    var approvalDate: FhirDate? = null
    var _approvalDate: Element? = null
    var lastReviewDate: FhirDate? = null
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
    var action: List<PlanDefinition.Action>? = null
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
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> subtitle = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _subtitle =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        22 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        23 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          subjectCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          subjectReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        28 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        29 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        33 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        36 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        37 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> usage = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _usage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 ->
          approvalDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        44 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 ->
          lastReviewDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        46 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        48 ->
          topic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        49 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        50 ->
          editor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        51 ->
          reviewer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        52 ->
          endorser =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        53 ->
          relatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        54 ->
          library =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        55 ->
          _library =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        56 ->
          goal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionGoalSerializer.listSerializer,
              null,
            )
        57 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PlanDefinitionActionSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val library_ =
      List(maxSize(library, _library)) { index ->
        entryRequired(
          Canonical.of(at(library, index), at(_library, index)),
          "PlanDefinition",
          "library",
        )
      }
    return PlanDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = Uri.of(url, _url),
      identifier = listOrEmpty(identifier),
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      subtitle = R4String.of(subtitle, _subtitle),
      type = type,
      status = required(Enumeration.of(status, _status), "PlanDefinition", "status"),
      experimental = R4Boolean.of(experimental, _experimental),
      subject = PlanDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(date, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4String.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(approvalDate, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      topic = listOrEmpty(topic),
      author = listOrEmpty(author),
      editor = listOrEmpty(editor),
      reviewer = listOrEmpty(reviewer),
      endorser = listOrEmpty(endorser),
      relatedArtifact = listOrEmpty(relatedArtifact),
      library = library_,
      goal = listOrEmpty(goal),
      action = listOrEmpty(action),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PlanDefinition,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.subtitle?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.subtitle)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    when (val choice = value.subject) {
      null -> {}
      is PlanDefinition.Subject.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is PlanDefinition.Subject.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          27 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      35 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      36 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.usage?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.usage)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      45 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      47 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      48 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.topic,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      49 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.author,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.editor,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      51 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.reviewer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      52 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.endorser,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      53 + descriptorOffset,
      RelatedArtifactSerializer.listSerializer,
      value.relatedArtifact,
    )
    if (!value.library.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        54 + descriptorOffset,
        stringNullableListSerializer,
        value.library.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 55 + descriptorOffset, value.library)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      56 + descriptorOffset,
      PlanDefinitionGoalSerializer.listSerializer,
      value.goal,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      57 + descriptorOffset,
      PlanDefinitionActionSerializer.listSerializer,
      value.action,
    )
  }
}
