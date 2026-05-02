/*
 * Copyright 2026 Google LLC
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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Age
import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.DataRequirement
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Duration
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Expression
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Id
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.RelatedArtifact
import com.google.fhir.model.r5.RequestOrchestration
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class RequestOrchestrationActionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var linkId: KotlinString? = null,
  public var _linkId: Element? = null,
  public var prefix: KotlinString? = null,
  public var _prefix: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var textEquivalent: KotlinString? = null,
  public var _textEquivalent: Element? = null,
  public var priority: KotlinString? = null,
  public var _priority: Element? = null,
  public var code: List<CodeableConcept>? = null,
  public var documentation: List<RelatedArtifact>? = null,
  public var goal: List<Reference>? = null,
  public var condition: List<RequestOrchestration.Action.Condition>? = null,
  public var input: List<RequestOrchestration.Action.Input>? = null,
  public var output: List<RequestOrchestration.Action.Output>? = null,
  public var relatedAction: List<RequestOrchestration.Action.RelatedAction>? = null,
  public var timing: RequestOrchestration.Action.Timing? = null,
  public var location: CodeableReference? = null,
  public var participant: List<RequestOrchestration.Action.Participant>? = null,
  public var type: CodeableConcept? = null,
  public var groupingBehavior: KotlinString? = null,
  public var _groupingBehavior: Element? = null,
  public var selectionBehavior: KotlinString? = null,
  public var _selectionBehavior: Element? = null,
  public var requiredBehavior: KotlinString? = null,
  public var _requiredBehavior: Element? = null,
  public var precheckBehavior: KotlinString? = null,
  public var _precheckBehavior: Element? = null,
  public var cardinalityBehavior: KotlinString? = null,
  public var _cardinalityBehavior: Element? = null,
  public var resource: Reference? = null,
  public var definition: RequestOrchestration.Action.Definition? = null,
  public var transform: KotlinString? = null,
  public var _transform: Element? = null,
  public var dynamicValue: List<RequestOrchestration.Action.DynamicValue>? = null,
  public var action: List<RequestOrchestration.Action>? = null,
) {
  public fun toModel(): RequestOrchestration.Action =
    RequestOrchestration.Action(
      id = this@RequestOrchestrationActionSurrogate.id,
      extension = this@RequestOrchestrationActionSurrogate.extension ?: listOf(),
      modifierExtension = this@RequestOrchestrationActionSurrogate.modifierExtension ?: listOf(),
      linkId =
        R5String.of(
          this@RequestOrchestrationActionSurrogate.linkId,
          this@RequestOrchestrationActionSurrogate._linkId,
        ),
      prefix =
        R5String.of(
          this@RequestOrchestrationActionSurrogate.prefix,
          this@RequestOrchestrationActionSurrogate._prefix,
        ),
      title =
        R5String.of(
          this@RequestOrchestrationActionSurrogate.title,
          this@RequestOrchestrationActionSurrogate._title,
        ),
      description =
        Markdown.of(
          this@RequestOrchestrationActionSurrogate.description,
          this@RequestOrchestrationActionSurrogate._description,
        ),
      textEquivalent =
        Markdown.of(
          this@RequestOrchestrationActionSurrogate.textEquivalent,
          this@RequestOrchestrationActionSurrogate._textEquivalent,
        ),
      priority =
        this@RequestOrchestrationActionSurrogate.priority?.let {
          Enumeration.of(
            RequestOrchestration.RequestPriority.fromCode(it),
            this@RequestOrchestrationActionSurrogate._priority,
          )
        },
      code = this@RequestOrchestrationActionSurrogate.code ?: listOf(),
      documentation = this@RequestOrchestrationActionSurrogate.documentation ?: listOf(),
      goal = this@RequestOrchestrationActionSurrogate.goal ?: listOf(),
      condition = this@RequestOrchestrationActionSurrogate.condition ?: listOf(),
      input = this@RequestOrchestrationActionSurrogate.input ?: listOf(),
      output = this@RequestOrchestrationActionSurrogate.output ?: listOf(),
      relatedAction = this@RequestOrchestrationActionSurrogate.relatedAction ?: listOf(),
      timing = this@RequestOrchestrationActionSurrogate.timing,
      location = this@RequestOrchestrationActionSurrogate.location,
      participant = this@RequestOrchestrationActionSurrogate.participant ?: listOf(),
      type = this@RequestOrchestrationActionSurrogate.type,
      groupingBehavior =
        this@RequestOrchestrationActionSurrogate.groupingBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionGroupingBehavior.fromCode(it),
            this@RequestOrchestrationActionSurrogate._groupingBehavior,
          )
        },
      selectionBehavior =
        this@RequestOrchestrationActionSurrogate.selectionBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionSelectionBehavior.fromCode(it),
            this@RequestOrchestrationActionSurrogate._selectionBehavior,
          )
        },
      requiredBehavior =
        this@RequestOrchestrationActionSurrogate.requiredBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionRequiredBehavior.fromCode(it),
            this@RequestOrchestrationActionSurrogate._requiredBehavior,
          )
        },
      precheckBehavior =
        this@RequestOrchestrationActionSurrogate.precheckBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionPrecheckBehavior.fromCode(it),
            this@RequestOrchestrationActionSurrogate._precheckBehavior,
          )
        },
      cardinalityBehavior =
        this@RequestOrchestrationActionSurrogate.cardinalityBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionCardinalityBehavior.fromCode(it),
            this@RequestOrchestrationActionSurrogate._cardinalityBehavior,
          )
        },
      resource = this@RequestOrchestrationActionSurrogate.resource,
      definition = this@RequestOrchestrationActionSurrogate.definition,
      transform =
        Canonical.of(
          this@RequestOrchestrationActionSurrogate.transform,
          this@RequestOrchestrationActionSurrogate._transform,
        ),
      dynamicValue = this@RequestOrchestrationActionSurrogate.dynamicValue ?: listOf(),
      action = this@RequestOrchestrationActionSurrogate.action ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: RequestOrchestration.Action): RequestOrchestrationActionSurrogate =
      with(model) {
        RequestOrchestrationActionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          linkId = this@with.linkId?.value,
          _linkId = this@with.linkId?.toElement(),
          prefix = this@with.prefix?.value,
          _prefix = this@with.prefix?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          textEquivalent = this@with.textEquivalent?.value,
          _textEquivalent = this@with.textEquivalent?.toElement(),
          priority = this@with.priority?.value?.getCode(),
          _priority = this@with.priority?.toElement(),
          code = this@with.code.takeIf { it.isNotEmpty() },
          documentation = this@with.documentation.takeIf { it.isNotEmpty() },
          goal = this@with.goal.takeIf { it.isNotEmpty() },
          condition = this@with.condition.takeIf { it.isNotEmpty() },
          input = this@with.input.takeIf { it.isNotEmpty() },
          output = this@with.output.takeIf { it.isNotEmpty() },
          relatedAction = this@with.relatedAction.takeIf { it.isNotEmpty() },
          timing = this@with.timing,
          location = this@with.location,
          participant = this@with.participant.takeIf { it.isNotEmpty() },
          type = this@with.type,
          groupingBehavior = this@with.groupingBehavior?.value?.getCode(),
          _groupingBehavior = this@with.groupingBehavior?.toElement(),
          selectionBehavior = this@with.selectionBehavior?.value?.getCode(),
          _selectionBehavior = this@with.selectionBehavior?.toElement(),
          requiredBehavior = this@with.requiredBehavior?.value?.getCode(),
          _requiredBehavior = this@with.requiredBehavior?.toElement(),
          precheckBehavior = this@with.precheckBehavior?.value?.getCode(),
          _precheckBehavior = this@with.precheckBehavior?.toElement(),
          cardinalityBehavior = this@with.cardinalityBehavior?.value?.getCode(),
          _cardinalityBehavior = this@with.cardinalityBehavior?.toElement(),
          resource = this@with.resource,
          definition = this@with.definition,
          transform = this@with.transform?.value,
          _transform = this@with.transform?.toElement(),
          dynamicValue = this@with.dynamicValue.takeIf { it.isNotEmpty() },
          action = this@with.action.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionConditionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var kind: KotlinString? = null,
  public var _kind: Element? = null,
  public var expression: Expression? = null,
) {
  public fun toModel(): RequestOrchestration.Action.Condition =
    RequestOrchestration.Action.Condition(
      id = this@RequestOrchestrationActionConditionSurrogate.id,
      extension = this@RequestOrchestrationActionConditionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@RequestOrchestrationActionConditionSurrogate.modifierExtension ?: listOf(),
      kind =
        Enumeration.of(
          RequestOrchestration.ActionConditionKind.fromCode(
            this@RequestOrchestrationActionConditionSurrogate.kind!!
          ),
          this@RequestOrchestrationActionConditionSurrogate._kind,
        ),
      expression = this@RequestOrchestrationActionConditionSurrogate.expression,
    )

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.Condition
    ): RequestOrchestrationActionConditionSurrogate =
      with(model) {
        RequestOrchestrationActionConditionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          kind = this@with.kind.value?.getCode(),
          _kind = this@with.kind.toElement(),
          expression = this@with.expression,
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionInputSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var requirement: DataRequirement? = null,
  public var relatedData: KotlinString? = null,
  public var _relatedData: Element? = null,
) {
  public fun toModel(): RequestOrchestration.Action.Input =
    RequestOrchestration.Action.Input(
      id = this@RequestOrchestrationActionInputSurrogate.id,
      extension = this@RequestOrchestrationActionInputSurrogate.extension ?: listOf(),
      modifierExtension =
        this@RequestOrchestrationActionInputSurrogate.modifierExtension ?: listOf(),
      title =
        R5String.of(
          this@RequestOrchestrationActionInputSurrogate.title,
          this@RequestOrchestrationActionInputSurrogate._title,
        ),
      requirement = this@RequestOrchestrationActionInputSurrogate.requirement,
      relatedData =
        Id.of(
          this@RequestOrchestrationActionInputSurrogate.relatedData,
          this@RequestOrchestrationActionInputSurrogate._relatedData,
        ),
    )

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.Input
    ): RequestOrchestrationActionInputSurrogate =
      with(model) {
        RequestOrchestrationActionInputSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          requirement = this@with.requirement,
          relatedData = this@with.relatedData?.value,
          _relatedData = this@with.relatedData?.toElement(),
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionOutputSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var requirement: DataRequirement? = null,
  public var relatedData: KotlinString? = null,
  public var _relatedData: Element? = null,
) {
  public fun toModel(): RequestOrchestration.Action.Output =
    RequestOrchestration.Action.Output(
      id = this@RequestOrchestrationActionOutputSurrogate.id,
      extension = this@RequestOrchestrationActionOutputSurrogate.extension ?: listOf(),
      modifierExtension =
        this@RequestOrchestrationActionOutputSurrogate.modifierExtension ?: listOf(),
      title =
        R5String.of(
          this@RequestOrchestrationActionOutputSurrogate.title,
          this@RequestOrchestrationActionOutputSurrogate._title,
        ),
      requirement = this@RequestOrchestrationActionOutputSurrogate.requirement,
      relatedData =
        R5String.of(
          this@RequestOrchestrationActionOutputSurrogate.relatedData,
          this@RequestOrchestrationActionOutputSurrogate._relatedData,
        ),
    )

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.Output
    ): RequestOrchestrationActionOutputSurrogate =
      with(model) {
        RequestOrchestrationActionOutputSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          requirement = this@with.requirement,
          relatedData = this@with.relatedData?.value,
          _relatedData = this@with.relatedData?.toElement(),
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionRelatedActionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var targetId: KotlinString? = null,
  public var _targetId: Element? = null,
  public var relationship: KotlinString? = null,
  public var _relationship: Element? = null,
  public var endRelationship: KotlinString? = null,
  public var _endRelationship: Element? = null,
  public var offset: RequestOrchestration.Action.RelatedAction.Offset? = null,
) {
  public fun toModel(): RequestOrchestration.Action.RelatedAction =
    RequestOrchestration.Action.RelatedAction(
      id = this@RequestOrchestrationActionRelatedActionSurrogate.id,
      extension = this@RequestOrchestrationActionRelatedActionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@RequestOrchestrationActionRelatedActionSurrogate.modifierExtension ?: listOf(),
      targetId =
        Id.of(
          this@RequestOrchestrationActionRelatedActionSurrogate.targetId,
          this@RequestOrchestrationActionRelatedActionSurrogate._targetId,
        )!!,
      relationship =
        Enumeration.of(
          RequestOrchestration.ActionRelationshipType.fromCode(
            this@RequestOrchestrationActionRelatedActionSurrogate.relationship!!
          ),
          this@RequestOrchestrationActionRelatedActionSurrogate._relationship,
        ),
      endRelationship =
        this@RequestOrchestrationActionRelatedActionSurrogate.endRelationship?.let {
          Enumeration.of(
            RequestOrchestration.ActionRelationshipType.fromCode(it),
            this@RequestOrchestrationActionRelatedActionSurrogate._endRelationship,
          )
        },
      offset = this@RequestOrchestrationActionRelatedActionSurrogate.offset,
    )

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.RelatedAction
    ): RequestOrchestrationActionRelatedActionSurrogate =
      with(model) {
        RequestOrchestrationActionRelatedActionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          targetId = this@with.targetId.value,
          _targetId = this@with.targetId.toElement(),
          relationship = this@with.relationship.value?.getCode(),
          _relationship = this@with.relationship.toElement(),
          endRelationship = this@with.endRelationship?.value?.getCode(),
          _endRelationship = this@with.endRelationship?.toElement(),
          offset = this@with.offset,
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionParticipantSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var typeCanonical: KotlinString? = null,
  public var _typeCanonical: Element? = null,
  public var typeReference: Reference? = null,
  public var role: CodeableConcept? = null,
  public var function: CodeableConcept? = null,
  public var actor: RequestOrchestration.Action.Participant.Actor? = null,
) {
  public fun toModel(): RequestOrchestration.Action.Participant =
    RequestOrchestration.Action.Participant(
      id = this@RequestOrchestrationActionParticipantSurrogate.id,
      extension = this@RequestOrchestrationActionParticipantSurrogate.extension ?: listOf(),
      modifierExtension =
        this@RequestOrchestrationActionParticipantSurrogate.modifierExtension ?: listOf(),
      type =
        this@RequestOrchestrationActionParticipantSurrogate.type?.let {
          Enumeration.of(
            RequestOrchestration.ActionParticipantType.fromCode(it),
            this@RequestOrchestrationActionParticipantSurrogate._type,
          )
        },
      typeCanonical =
        Canonical.of(
          this@RequestOrchestrationActionParticipantSurrogate.typeCanonical,
          this@RequestOrchestrationActionParticipantSurrogate._typeCanonical,
        ),
      typeReference = this@RequestOrchestrationActionParticipantSurrogate.typeReference,
      role = this@RequestOrchestrationActionParticipantSurrogate.role,
      function = this@RequestOrchestrationActionParticipantSurrogate.function,
      actor = this@RequestOrchestrationActionParticipantSurrogate.actor,
    )

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.Participant
    ): RequestOrchestrationActionParticipantSurrogate =
      with(model) {
        RequestOrchestrationActionParticipantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type?.value?.getCode(),
          _type = this@with.type?.toElement(),
          typeCanonical = this@with.typeCanonical?.value,
          _typeCanonical = this@with.typeCanonical?.toElement(),
          typeReference = this@with.typeReference,
          role = this@with.role,
          function = this@with.function,
          actor = this@with.actor,
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionDynamicValueSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var path: KotlinString? = null,
  public var _path: Element? = null,
  public var expression: Expression? = null,
) {
  public fun toModel(): RequestOrchestration.Action.DynamicValue =
    RequestOrchestration.Action.DynamicValue(
      id = this@RequestOrchestrationActionDynamicValueSurrogate.id,
      extension = this@RequestOrchestrationActionDynamicValueSurrogate.extension ?: listOf(),
      modifierExtension =
        this@RequestOrchestrationActionDynamicValueSurrogate.modifierExtension ?: listOf(),
      path =
        R5String.of(
          this@RequestOrchestrationActionDynamicValueSurrogate.path,
          this@RequestOrchestrationActionDynamicValueSurrogate._path,
        ),
      expression = this@RequestOrchestrationActionDynamicValueSurrogate.expression,
    )

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.DynamicValue
    ): RequestOrchestrationActionDynamicValueSurrogate =
      with(model) {
        RequestOrchestrationActionDynamicValueSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          path = this@with.path?.value,
          _path = this@with.path?.toElement(),
          expression = this@with.expression,
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionRelatedActionOffsetSurrogate(
  public var offsetDuration: Duration? = null,
  public var offsetRange: Range? = null,
) {
  public fun toModel(): RequestOrchestration.Action.RelatedAction.Offset =
    RequestOrchestration.Action.RelatedAction.Offset.from(
      this@RequestOrchestrationActionRelatedActionOffsetSurrogate.offsetDuration,
      this@RequestOrchestrationActionRelatedActionOffsetSurrogate.offsetRange,
    )!!

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.RelatedAction.Offset
    ): RequestOrchestrationActionRelatedActionOffsetSurrogate =
      with(model) {
        RequestOrchestrationActionRelatedActionOffsetSurrogate(
          offsetDuration = this@with.asDuration()?.value,
          offsetRange = this@with.asRange()?.value,
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionTimingSurrogate(
  public var timingDateTime: KotlinString? = null,
  public var _timingDateTime: Element? = null,
  public var timingAge: Age? = null,
  public var timingPeriod: Period? = null,
  public var timingDuration: Duration? = null,
  public var timingRange: Range? = null,
  public var timingTiming: Timing? = null,
) {
  public fun toModel(): RequestOrchestration.Action.Timing =
    RequestOrchestration.Action.Timing.from(
      DateTime.of(
        FhirDateTime.fromString(this@RequestOrchestrationActionTimingSurrogate.timingDateTime),
        this@RequestOrchestrationActionTimingSurrogate._timingDateTime,
      ),
      this@RequestOrchestrationActionTimingSurrogate.timingAge,
      this@RequestOrchestrationActionTimingSurrogate.timingPeriod,
      this@RequestOrchestrationActionTimingSurrogate.timingDuration,
      this@RequestOrchestrationActionTimingSurrogate.timingRange,
      this@RequestOrchestrationActionTimingSurrogate.timingTiming,
    )!!

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.Timing
    ): RequestOrchestrationActionTimingSurrogate =
      with(model) {
        RequestOrchestrationActionTimingSurrogate(
          timingDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _timingDateTime = this@with.asDateTime()?.value?.toElement(),
          timingAge = this@with.asAge()?.value,
          timingPeriod = this@with.asPeriod()?.value,
          timingDuration = this@with.asDuration()?.value,
          timingRange = this@with.asRange()?.value,
          timingTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionParticipantActorSurrogate(
  public var actorCanonical: KotlinString? = null,
  public var _actorCanonical: Element? = null,
  public var actorReference: Reference? = null,
) {
  public fun toModel(): RequestOrchestration.Action.Participant.Actor =
    RequestOrchestration.Action.Participant.Actor.from(
      Canonical.of(
        this@RequestOrchestrationActionParticipantActorSurrogate.actorCanonical,
        this@RequestOrchestrationActionParticipantActorSurrogate._actorCanonical,
      ),
      this@RequestOrchestrationActionParticipantActorSurrogate.actorReference,
    )!!

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.Participant.Actor
    ): RequestOrchestrationActionParticipantActorSurrogate =
      with(model) {
        RequestOrchestrationActionParticipantActorSurrogate(
          actorCanonical = this@with.asCanonical()?.value?.value,
          _actorCanonical = this@with.asCanonical()?.value?.toElement(),
          actorReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationActionDefinitionSurrogate(
  public var definitionCanonical: KotlinString? = null,
  public var _definitionCanonical: Element? = null,
  public var definitionUri: KotlinString? = null,
  public var _definitionUri: Element? = null,
) {
  public fun toModel(): RequestOrchestration.Action.Definition =
    RequestOrchestration.Action.Definition.from(
      Canonical.of(
        this@RequestOrchestrationActionDefinitionSurrogate.definitionCanonical,
        this@RequestOrchestrationActionDefinitionSurrogate._definitionCanonical,
      ),
      Uri.of(
        this@RequestOrchestrationActionDefinitionSurrogate.definitionUri,
        this@RequestOrchestrationActionDefinitionSurrogate._definitionUri,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: RequestOrchestration.Action.Definition
    ): RequestOrchestrationActionDefinitionSurrogate =
      with(model) {
        RequestOrchestrationActionDefinitionSurrogate(
          definitionCanonical = this@with.asCanonical()?.value?.value,
          _definitionCanonical = this@with.asCanonical()?.value?.toElement(),
          definitionUri = this@with.asUri()?.value?.value,
          _definitionUri = this@with.asUri()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class RequestOrchestrationSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var instantiatesCanonical: List<KotlinString?>? = null,
  public var _instantiatesCanonical: List<Element?>? = null,
  public var instantiatesUri: List<KotlinString?>? = null,
  public var _instantiatesUri: List<Element?>? = null,
  public var basedOn: List<Reference>? = null,
  public var replaces: List<Reference>? = null,
  public var groupIdentifier: Identifier? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var intent: KotlinString? = null,
  public var _intent: Element? = null,
  public var priority: KotlinString? = null,
  public var _priority: Element? = null,
  public var code: CodeableConcept? = null,
  public var subject: Reference? = null,
  public var encounter: Reference? = null,
  public var authoredOn: KotlinString? = null,
  public var _authoredOn: Element? = null,
  public var author: Reference? = null,
  public var reason: List<CodeableReference>? = null,
  public var goal: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var action: List<RequestOrchestration.Action>? = null,
) {
  public fun toModel(): RequestOrchestration =
    RequestOrchestration(
      id = this@RequestOrchestrationSurrogate.id,
      meta = this@RequestOrchestrationSurrogate.meta,
      implicitRules =
        Uri.of(
          this@RequestOrchestrationSurrogate.implicitRules,
          this@RequestOrchestrationSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@RequestOrchestrationSurrogate.language,
          this@RequestOrchestrationSurrogate._language,
        ),
      text = this@RequestOrchestrationSurrogate.text,
      contained = this@RequestOrchestrationSurrogate.contained ?: listOf(),
      extension = this@RequestOrchestrationSurrogate.extension ?: listOf(),
      modifierExtension = this@RequestOrchestrationSurrogate.modifierExtension ?: listOf(),
      identifier = this@RequestOrchestrationSurrogate.identifier ?: listOf(),
      instantiatesCanonical =
        if (
          this@RequestOrchestrationSurrogate.instantiatesCanonical == null &&
            this@RequestOrchestrationSurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@RequestOrchestrationSurrogate.instantiatesCanonical
              ?: List(this@RequestOrchestrationSurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@RequestOrchestrationSurrogate._instantiatesCanonical
                ?: List(this@RequestOrchestrationSurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@RequestOrchestrationSurrogate.instantiatesUri == null &&
            this@RequestOrchestrationSurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@RequestOrchestrationSurrogate.instantiatesUri
              ?: List(this@RequestOrchestrationSurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@RequestOrchestrationSurrogate._instantiatesUri
                ?: List(this@RequestOrchestrationSurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      basedOn = this@RequestOrchestrationSurrogate.basedOn ?: listOf(),
      replaces = this@RequestOrchestrationSurrogate.replaces ?: listOf(),
      groupIdentifier = this@RequestOrchestrationSurrogate.groupIdentifier,
      status =
        Enumeration.of(
          RequestOrchestration.RequestStatus.fromCode(this@RequestOrchestrationSurrogate.status!!),
          this@RequestOrchestrationSurrogate._status,
        ),
      intent =
        Enumeration.of(
          RequestOrchestration.RequestIntent.fromCode(this@RequestOrchestrationSurrogate.intent!!),
          this@RequestOrchestrationSurrogate._intent,
        ),
      priority =
        this@RequestOrchestrationSurrogate.priority?.let {
          Enumeration.of(
            RequestOrchestration.RequestPriority.fromCode(it),
            this@RequestOrchestrationSurrogate._priority,
          )
        },
      code = this@RequestOrchestrationSurrogate.code,
      subject = this@RequestOrchestrationSurrogate.subject,
      encounter = this@RequestOrchestrationSurrogate.encounter,
      authoredOn =
        DateTime.of(
          FhirDateTime.fromString(this@RequestOrchestrationSurrogate.authoredOn),
          this@RequestOrchestrationSurrogate._authoredOn,
        ),
      author = this@RequestOrchestrationSurrogate.author,
      reason = this@RequestOrchestrationSurrogate.reason ?: listOf(),
      goal = this@RequestOrchestrationSurrogate.goal ?: listOf(),
      note = this@RequestOrchestrationSurrogate.note ?: listOf(),
      action = this@RequestOrchestrationSurrogate.action ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: RequestOrchestration): RequestOrchestrationSurrogate =
      with(model) {
        RequestOrchestrationSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          instantiatesUri =
            this@with.instantiatesUri
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesUri =
            this@with.instantiatesUri
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          replaces = this@with.replaces.takeIf { it.isNotEmpty() },
          groupIdentifier = this@with.groupIdentifier,
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          intent = this@with.intent.value?.getCode(),
          _intent = this@with.intent.toElement(),
          priority = this@with.priority?.value?.getCode(),
          _priority = this@with.priority?.toElement(),
          code = this@with.code,
          subject = this@with.subject,
          encounter = this@with.encounter,
          authoredOn = this@with.authoredOn?.value?.toString(),
          _authoredOn = this@with.authoredOn?.toElement(),
          author = this@with.author,
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          goal = this@with.goal.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          action = this@with.action.takeIf { it.isNotEmpty() },
        )
      }
  }
}
