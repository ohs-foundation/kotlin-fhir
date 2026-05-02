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

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.Age
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.DataRequirement
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Duration
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Expression
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Id
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.PlanDefinition
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Range
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.RelatedArtifact
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Timing
import com.google.fhir.model.r4b.TriggerDefinition
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class PlanDefinitionGoalSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept? = null,
  public var description: CodeableConcept,
  public var priority: CodeableConcept? = null,
  public var start: CodeableConcept? = null,
  public var addresses: List<CodeableConcept>? = null,
  public var documentation: List<RelatedArtifact>? = null,
  public var target: List<PlanDefinition.Goal.Target>? = null,
) {
  public fun toModel(): PlanDefinition.Goal =
    PlanDefinition.Goal(
      id = this@PlanDefinitionGoalSurrogate.id,
      extension = this@PlanDefinitionGoalSurrogate.extension ?: listOf(),
      modifierExtension = this@PlanDefinitionGoalSurrogate.modifierExtension ?: listOf(),
      category = this@PlanDefinitionGoalSurrogate.category,
      description = this@PlanDefinitionGoalSurrogate.description,
      priority = this@PlanDefinitionGoalSurrogate.priority,
      start = this@PlanDefinitionGoalSurrogate.start,
      addresses = this@PlanDefinitionGoalSurrogate.addresses ?: listOf(),
      documentation = this@PlanDefinitionGoalSurrogate.documentation ?: listOf(),
      target = this@PlanDefinitionGoalSurrogate.target ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: PlanDefinition.Goal): PlanDefinitionGoalSurrogate =
      with(model) {
        PlanDefinitionGoalSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          description = this@with.description,
          priority = this@with.priority,
          start = this@with.start,
          addresses = this@with.addresses.takeIf { it.isNotEmpty() },
          documentation = this@with.documentation.takeIf { it.isNotEmpty() },
          target = this@with.target.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class PlanDefinitionGoalTargetSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var measure: CodeableConcept? = null,
  public var detail: PlanDefinition.Goal.Target.Detail? = null,
  public var due: Duration? = null,
) {
  public fun toModel(): PlanDefinition.Goal.Target =
    PlanDefinition.Goal.Target(
      id = this@PlanDefinitionGoalTargetSurrogate.id,
      extension = this@PlanDefinitionGoalTargetSurrogate.extension ?: listOf(),
      modifierExtension = this@PlanDefinitionGoalTargetSurrogate.modifierExtension ?: listOf(),
      measure = this@PlanDefinitionGoalTargetSurrogate.measure,
      detail = this@PlanDefinitionGoalTargetSurrogate.detail,
      due = this@PlanDefinitionGoalTargetSurrogate.due,
    )

  public companion object {
    public fun fromModel(model: PlanDefinition.Goal.Target): PlanDefinitionGoalTargetSurrogate =
      with(model) {
        PlanDefinitionGoalTargetSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          measure = this@with.measure,
          detail = this@with.detail,
          due = this@with.due,
        )
      }
  }
}

@Serializable
internal data class PlanDefinitionActionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
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
  public var reason: List<CodeableConcept>? = null,
  public var documentation: List<RelatedArtifact>? = null,
  public var goalId: List<KotlinString?>? = null,
  public var _goalId: List<Element?>? = null,
  public var subject: PlanDefinition.Action.Subject? = null,
  public var trigger: List<TriggerDefinition>? = null,
  public var condition: List<PlanDefinition.Action.Condition>? = null,
  public var input: List<DataRequirement>? = null,
  public var output: List<DataRequirement>? = null,
  public var relatedAction: List<PlanDefinition.Action.RelatedAction>? = null,
  public var timing: PlanDefinition.Action.Timing? = null,
  public var participant: List<PlanDefinition.Action.Participant>? = null,
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
  public var definition: PlanDefinition.Action.Definition? = null,
  public var transform: KotlinString? = null,
  public var _transform: Element? = null,
  public var dynamicValue: List<PlanDefinition.Action.DynamicValue>? = null,
  public var action: List<PlanDefinition.Action>? = null,
) {
  public fun toModel(): PlanDefinition.Action =
    PlanDefinition.Action(
      id = this@PlanDefinitionActionSurrogate.id,
      extension = this@PlanDefinitionActionSurrogate.extension ?: listOf(),
      modifierExtension = this@PlanDefinitionActionSurrogate.modifierExtension ?: listOf(),
      prefix =
        R4bString.of(
          this@PlanDefinitionActionSurrogate.prefix,
          this@PlanDefinitionActionSurrogate._prefix,
        ),
      title =
        R4bString.of(
          this@PlanDefinitionActionSurrogate.title,
          this@PlanDefinitionActionSurrogate._title,
        ),
      description =
        R4bString.of(
          this@PlanDefinitionActionSurrogate.description,
          this@PlanDefinitionActionSurrogate._description,
        ),
      textEquivalent =
        R4bString.of(
          this@PlanDefinitionActionSurrogate.textEquivalent,
          this@PlanDefinitionActionSurrogate._textEquivalent,
        ),
      priority =
        this@PlanDefinitionActionSurrogate.priority?.let {
          Enumeration.of(
            PlanDefinition.RequestPriority.fromCode(it),
            this@PlanDefinitionActionSurrogate._priority,
          )
        },
      code = this@PlanDefinitionActionSurrogate.code ?: listOf(),
      reason = this@PlanDefinitionActionSurrogate.reason ?: listOf(),
      documentation = this@PlanDefinitionActionSurrogate.documentation ?: listOf(),
      goalId =
        if (
          this@PlanDefinitionActionSurrogate.goalId == null &&
            this@PlanDefinitionActionSurrogate._goalId == null
        ) {
          listOf()
        } else {
          (this@PlanDefinitionActionSurrogate.goalId
              ?: List(this@PlanDefinitionActionSurrogate._goalId!!.size) { null })
            .zip(
              this@PlanDefinitionActionSurrogate._goalId
                ?: List(this@PlanDefinitionActionSurrogate.goalId!!.size) { null }
            )
            .map { (value, element) -> Id.of(value, element)!! }
            .toList()
        },
      subject = this@PlanDefinitionActionSurrogate.subject,
      trigger = this@PlanDefinitionActionSurrogate.trigger ?: listOf(),
      condition = this@PlanDefinitionActionSurrogate.condition ?: listOf(),
      input = this@PlanDefinitionActionSurrogate.input ?: listOf(),
      output = this@PlanDefinitionActionSurrogate.output ?: listOf(),
      relatedAction = this@PlanDefinitionActionSurrogate.relatedAction ?: listOf(),
      timing = this@PlanDefinitionActionSurrogate.timing,
      participant = this@PlanDefinitionActionSurrogate.participant ?: listOf(),
      type = this@PlanDefinitionActionSurrogate.type,
      groupingBehavior =
        this@PlanDefinitionActionSurrogate.groupingBehavior?.let {
          Enumeration.of(
            PlanDefinition.ActionGroupingBehavior.fromCode(it),
            this@PlanDefinitionActionSurrogate._groupingBehavior,
          )
        },
      selectionBehavior =
        this@PlanDefinitionActionSurrogate.selectionBehavior?.let {
          Enumeration.of(
            PlanDefinition.ActionSelectionBehavior.fromCode(it),
            this@PlanDefinitionActionSurrogate._selectionBehavior,
          )
        },
      requiredBehavior =
        this@PlanDefinitionActionSurrogate.requiredBehavior?.let {
          Enumeration.of(
            PlanDefinition.ActionRequiredBehavior.fromCode(it),
            this@PlanDefinitionActionSurrogate._requiredBehavior,
          )
        },
      precheckBehavior =
        this@PlanDefinitionActionSurrogate.precheckBehavior?.let {
          Enumeration.of(
            PlanDefinition.ActionPrecheckBehavior.fromCode(it),
            this@PlanDefinitionActionSurrogate._precheckBehavior,
          )
        },
      cardinalityBehavior =
        this@PlanDefinitionActionSurrogate.cardinalityBehavior?.let {
          Enumeration.of(
            PlanDefinition.ActionCardinalityBehavior.fromCode(it),
            this@PlanDefinitionActionSurrogate._cardinalityBehavior,
          )
        },
      definition = this@PlanDefinitionActionSurrogate.definition,
      transform =
        Canonical.of(
          this@PlanDefinitionActionSurrogate.transform,
          this@PlanDefinitionActionSurrogate._transform,
        ),
      dynamicValue = this@PlanDefinitionActionSurrogate.dynamicValue ?: listOf(),
      action = this@PlanDefinitionActionSurrogate.action ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: PlanDefinition.Action): PlanDefinitionActionSurrogate =
      with(model) {
        PlanDefinitionActionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
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
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          documentation = this@with.documentation.takeIf { it.isNotEmpty() },
          goalId = this@with.goalId.map { it.value }.toList().takeUnless { it.all { it == null } },
          _goalId =
            this@with.goalId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          subject = this@with.subject,
          trigger = this@with.trigger.takeIf { it.isNotEmpty() },
          condition = this@with.condition.takeIf { it.isNotEmpty() },
          input = this@with.input.takeIf { it.isNotEmpty() },
          output = this@with.output.takeIf { it.isNotEmpty() },
          relatedAction = this@with.relatedAction.takeIf { it.isNotEmpty() },
          timing = this@with.timing,
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
internal data class PlanDefinitionActionConditionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var kind: KotlinString? = null,
  public var _kind: Element? = null,
  public var expression: Expression? = null,
) {
  public fun toModel(): PlanDefinition.Action.Condition =
    PlanDefinition.Action.Condition(
      id = this@PlanDefinitionActionConditionSurrogate.id,
      extension = this@PlanDefinitionActionConditionSurrogate.extension ?: listOf(),
      modifierExtension = this@PlanDefinitionActionConditionSurrogate.modifierExtension ?: listOf(),
      kind =
        Enumeration.of(
          PlanDefinition.ActionConditionKind.fromCode(
            this@PlanDefinitionActionConditionSurrogate.kind!!
          ),
          this@PlanDefinitionActionConditionSurrogate._kind,
        ),
      expression = this@PlanDefinitionActionConditionSurrogate.expression,
    )

  public companion object {
    public fun fromModel(
      model: PlanDefinition.Action.Condition
    ): PlanDefinitionActionConditionSurrogate =
      with(model) {
        PlanDefinitionActionConditionSurrogate(
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
internal data class PlanDefinitionActionRelatedActionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var actionId: KotlinString? = null,
  public var _actionId: Element? = null,
  public var relationship: KotlinString? = null,
  public var _relationship: Element? = null,
  public var offset: PlanDefinition.Action.RelatedAction.Offset? = null,
) {
  public fun toModel(): PlanDefinition.Action.RelatedAction =
    PlanDefinition.Action.RelatedAction(
      id = this@PlanDefinitionActionRelatedActionSurrogate.id,
      extension = this@PlanDefinitionActionRelatedActionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@PlanDefinitionActionRelatedActionSurrogate.modifierExtension ?: listOf(),
      actionId =
        Id.of(
          this@PlanDefinitionActionRelatedActionSurrogate.actionId,
          this@PlanDefinitionActionRelatedActionSurrogate._actionId,
        )!!,
      relationship =
        Enumeration.of(
          PlanDefinition.ActionRelationshipType.fromCode(
            this@PlanDefinitionActionRelatedActionSurrogate.relationship!!
          ),
          this@PlanDefinitionActionRelatedActionSurrogate._relationship,
        ),
      offset = this@PlanDefinitionActionRelatedActionSurrogate.offset,
    )

  public companion object {
    public fun fromModel(
      model: PlanDefinition.Action.RelatedAction
    ): PlanDefinitionActionRelatedActionSurrogate =
      with(model) {
        PlanDefinitionActionRelatedActionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          actionId = this@with.actionId.value,
          _actionId = this@with.actionId.toElement(),
          relationship = this@with.relationship.value?.getCode(),
          _relationship = this@with.relationship.toElement(),
          offset = this@with.offset,
        )
      }
  }
}

@Serializable
internal data class PlanDefinitionActionParticipantSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var role: CodeableConcept? = null,
) {
  public fun toModel(): PlanDefinition.Action.Participant =
    PlanDefinition.Action.Participant(
      id = this@PlanDefinitionActionParticipantSurrogate.id,
      extension = this@PlanDefinitionActionParticipantSurrogate.extension ?: listOf(),
      modifierExtension =
        this@PlanDefinitionActionParticipantSurrogate.modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          PlanDefinition.ActionParticipantType.fromCode(
            this@PlanDefinitionActionParticipantSurrogate.type!!
          ),
          this@PlanDefinitionActionParticipantSurrogate._type,
        ),
      role = this@PlanDefinitionActionParticipantSurrogate.role,
    )

  public companion object {
    public fun fromModel(
      model: PlanDefinition.Action.Participant
    ): PlanDefinitionActionParticipantSurrogate =
      with(model) {
        PlanDefinitionActionParticipantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          role = this@with.role,
        )
      }
  }
}

@Serializable
internal data class PlanDefinitionActionDynamicValueSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var path: KotlinString? = null,
  public var _path: Element? = null,
  public var expression: Expression? = null,
) {
  public fun toModel(): PlanDefinition.Action.DynamicValue =
    PlanDefinition.Action.DynamicValue(
      id = this@PlanDefinitionActionDynamicValueSurrogate.id,
      extension = this@PlanDefinitionActionDynamicValueSurrogate.extension ?: listOf(),
      modifierExtension =
        this@PlanDefinitionActionDynamicValueSurrogate.modifierExtension ?: listOf(),
      path =
        R4bString.of(
          this@PlanDefinitionActionDynamicValueSurrogate.path,
          this@PlanDefinitionActionDynamicValueSurrogate._path,
        ),
      expression = this@PlanDefinitionActionDynamicValueSurrogate.expression,
    )

  public companion object {
    public fun fromModel(
      model: PlanDefinition.Action.DynamicValue
    ): PlanDefinitionActionDynamicValueSurrogate =
      with(model) {
        PlanDefinitionActionDynamicValueSurrogate(
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
internal data class PlanDefinitionSubjectSurrogate(
  public var subjectCodeableConcept: CodeableConcept? = null,
  public var subjectReference: Reference? = null,
  public var subjectCanonical: KotlinString? = null,
  public var _subjectCanonical: Element? = null,
) {
  public fun toModel(): PlanDefinition.Subject =
    PlanDefinition.Subject.from(
      this@PlanDefinitionSubjectSurrogate.subjectCodeableConcept,
      this@PlanDefinitionSubjectSurrogate.subjectReference,
      Canonical.of(
        this@PlanDefinitionSubjectSurrogate.subjectCanonical,
        this@PlanDefinitionSubjectSurrogate._subjectCanonical,
      ),
    )!!

  public companion object {
    public fun fromModel(model: PlanDefinition.Subject): PlanDefinitionSubjectSurrogate =
      with(model) {
        PlanDefinitionSubjectSurrogate(
          subjectCodeableConcept = this@with.asCodeableConcept()?.value,
          subjectReference = this@with.asReference()?.value,
          subjectCanonical = this@with.asCanonical()?.value?.value,
          _subjectCanonical = this@with.asCanonical()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class PlanDefinitionGoalTargetDetailSurrogate(
  public var detailQuantity: Quantity? = null,
  public var detailRange: Range? = null,
  public var detailCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): PlanDefinition.Goal.Target.Detail =
    PlanDefinition.Goal.Target.Detail.from(
      this@PlanDefinitionGoalTargetDetailSurrogate.detailQuantity,
      this@PlanDefinitionGoalTargetDetailSurrogate.detailRange,
      this@PlanDefinitionGoalTargetDetailSurrogate.detailCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: PlanDefinition.Goal.Target.Detail
    ): PlanDefinitionGoalTargetDetailSurrogate =
      with(model) {
        PlanDefinitionGoalTargetDetailSurrogate(
          detailQuantity = this@with.asQuantity()?.value,
          detailRange = this@with.asRange()?.value,
          detailCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class PlanDefinitionActionSubjectSurrogate(
  public var subjectCodeableConcept: CodeableConcept? = null,
  public var subjectReference: Reference? = null,
  public var subjectCanonical: KotlinString? = null,
  public var _subjectCanonical: Element? = null,
) {
  public fun toModel(): PlanDefinition.Action.Subject =
    PlanDefinition.Action.Subject.from(
      this@PlanDefinitionActionSubjectSurrogate.subjectCodeableConcept,
      this@PlanDefinitionActionSubjectSurrogate.subjectReference,
      Canonical.of(
        this@PlanDefinitionActionSubjectSurrogate.subjectCanonical,
        this@PlanDefinitionActionSubjectSurrogate._subjectCanonical,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: PlanDefinition.Action.Subject
    ): PlanDefinitionActionSubjectSurrogate =
      with(model) {
        PlanDefinitionActionSubjectSurrogate(
          subjectCodeableConcept = this@with.asCodeableConcept()?.value,
          subjectReference = this@with.asReference()?.value,
          subjectCanonical = this@with.asCanonical()?.value?.value,
          _subjectCanonical = this@with.asCanonical()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class PlanDefinitionActionRelatedActionOffsetSurrogate(
  public var offsetDuration: Duration? = null,
  public var offsetRange: Range? = null,
) {
  public fun toModel(): PlanDefinition.Action.RelatedAction.Offset =
    PlanDefinition.Action.RelatedAction.Offset.from(
      this@PlanDefinitionActionRelatedActionOffsetSurrogate.offsetDuration,
      this@PlanDefinitionActionRelatedActionOffsetSurrogate.offsetRange,
    )!!

  public companion object {
    public fun fromModel(
      model: PlanDefinition.Action.RelatedAction.Offset
    ): PlanDefinitionActionRelatedActionOffsetSurrogate =
      with(model) {
        PlanDefinitionActionRelatedActionOffsetSurrogate(
          offsetDuration = this@with.asDuration()?.value,
          offsetRange = this@with.asRange()?.value,
        )
      }
  }
}

@Serializable
internal data class PlanDefinitionActionTimingSurrogate(
  public var timingDateTime: KotlinString? = null,
  public var _timingDateTime: Element? = null,
  public var timingAge: Age? = null,
  public var timingPeriod: Period? = null,
  public var timingDuration: Duration? = null,
  public var timingRange: Range? = null,
  public var timingTiming: Timing? = null,
) {
  public fun toModel(): PlanDefinition.Action.Timing =
    PlanDefinition.Action.Timing.from(
      DateTime.of(
        FhirDateTime.fromString(this@PlanDefinitionActionTimingSurrogate.timingDateTime),
        this@PlanDefinitionActionTimingSurrogate._timingDateTime,
      ),
      this@PlanDefinitionActionTimingSurrogate.timingAge,
      this@PlanDefinitionActionTimingSurrogate.timingPeriod,
      this@PlanDefinitionActionTimingSurrogate.timingDuration,
      this@PlanDefinitionActionTimingSurrogate.timingRange,
      this@PlanDefinitionActionTimingSurrogate.timingTiming,
    )!!

  public companion object {
    public fun fromModel(model: PlanDefinition.Action.Timing): PlanDefinitionActionTimingSurrogate =
      with(model) {
        PlanDefinitionActionTimingSurrogate(
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
internal data class PlanDefinitionActionDefinitionSurrogate(
  public var definitionCanonical: KotlinString? = null,
  public var _definitionCanonical: Element? = null,
  public var definitionUri: KotlinString? = null,
  public var _definitionUri: Element? = null,
) {
  public fun toModel(): PlanDefinition.Action.Definition =
    PlanDefinition.Action.Definition.from(
      Canonical.of(
        this@PlanDefinitionActionDefinitionSurrogate.definitionCanonical,
        this@PlanDefinitionActionDefinitionSurrogate._definitionCanonical,
      ),
      Uri.of(
        this@PlanDefinitionActionDefinitionSurrogate.definitionUri,
        this@PlanDefinitionActionDefinitionSurrogate._definitionUri,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: PlanDefinition.Action.Definition
    ): PlanDefinitionActionDefinitionSurrogate =
      with(model) {
        PlanDefinitionActionDefinitionSurrogate(
          definitionCanonical = this@with.asCanonical()?.value?.value,
          _definitionCanonical = this@with.asCanonical()?.value?.toElement(),
          definitionUri = this@with.asUri()?.value?.value,
          _definitionUri = this@with.asUri()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class PlanDefinitionSurrogate(
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
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var subtitle: KotlinString? = null,
  public var _subtitle: Element? = null,
  public var type: CodeableConcept? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var experimental: KotlinBoolean? = null,
  public var _experimental: Element? = null,
  public var subject: PlanDefinition.Subject? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var jurisdiction: List<CodeableConcept>? = null,
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var usage: KotlinString? = null,
  public var _usage: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
  public var approvalDate: KotlinString? = null,
  public var _approvalDate: Element? = null,
  public var lastReviewDate: KotlinString? = null,
  public var _lastReviewDate: Element? = null,
  public var effectivePeriod: Period? = null,
  public var topic: List<CodeableConcept>? = null,
  public var author: List<ContactDetail>? = null,
  public var editor: List<ContactDetail>? = null,
  public var reviewer: List<ContactDetail>? = null,
  public var endorser: List<ContactDetail>? = null,
  public var relatedArtifact: List<RelatedArtifact>? = null,
  public var library: List<KotlinString?>? = null,
  public var _library: List<Element?>? = null,
  public var goal: List<PlanDefinition.Goal>? = null,
  public var action: List<PlanDefinition.Action>? = null,
) {
  public fun toModel(): PlanDefinition =
    PlanDefinition(
      id = this@PlanDefinitionSurrogate.id,
      meta = this@PlanDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@PlanDefinitionSurrogate.implicitRules,
          this@PlanDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(this@PlanDefinitionSurrogate.language, this@PlanDefinitionSurrogate._language),
      text = this@PlanDefinitionSurrogate.text,
      contained = this@PlanDefinitionSurrogate.contained ?: listOf(),
      extension = this@PlanDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@PlanDefinitionSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@PlanDefinitionSurrogate.url, this@PlanDefinitionSurrogate._url),
      identifier = this@PlanDefinitionSurrogate.identifier ?: listOf(),
      version =
        R4bString.of(this@PlanDefinitionSurrogate.version, this@PlanDefinitionSurrogate._version),
      name = R4bString.of(this@PlanDefinitionSurrogate.name, this@PlanDefinitionSurrogate._name),
      title = R4bString.of(this@PlanDefinitionSurrogate.title, this@PlanDefinitionSurrogate._title),
      subtitle =
        R4bString.of(this@PlanDefinitionSurrogate.subtitle, this@PlanDefinitionSurrogate._subtitle),
      type = this@PlanDefinitionSurrogate.type,
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@PlanDefinitionSurrogate.status!!),
          this@PlanDefinitionSurrogate._status,
        ),
      experimental =
        R4bBoolean.of(
          this@PlanDefinitionSurrogate.experimental,
          this@PlanDefinitionSurrogate._experimental,
        ),
      subject = this@PlanDefinitionSurrogate.subject,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@PlanDefinitionSurrogate.date),
          this@PlanDefinitionSurrogate._date,
        ),
      publisher =
        R4bString.of(
          this@PlanDefinitionSurrogate.publisher,
          this@PlanDefinitionSurrogate._publisher,
        ),
      contact = this@PlanDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@PlanDefinitionSurrogate.description,
          this@PlanDefinitionSurrogate._description,
        ),
      useContext = this@PlanDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@PlanDefinitionSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(this@PlanDefinitionSurrogate.purpose, this@PlanDefinitionSurrogate._purpose),
      usage = R4bString.of(this@PlanDefinitionSurrogate.usage, this@PlanDefinitionSurrogate._usage),
      copyright =
        Markdown.of(
          this@PlanDefinitionSurrogate.copyright,
          this@PlanDefinitionSurrogate._copyright,
        ),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@PlanDefinitionSurrogate.approvalDate),
          this@PlanDefinitionSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@PlanDefinitionSurrogate.lastReviewDate),
          this@PlanDefinitionSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@PlanDefinitionSurrogate.effectivePeriod,
      topic = this@PlanDefinitionSurrogate.topic ?: listOf(),
      author = this@PlanDefinitionSurrogate.author ?: listOf(),
      editor = this@PlanDefinitionSurrogate.editor ?: listOf(),
      reviewer = this@PlanDefinitionSurrogate.reviewer ?: listOf(),
      endorser = this@PlanDefinitionSurrogate.endorser ?: listOf(),
      relatedArtifact = this@PlanDefinitionSurrogate.relatedArtifact ?: listOf(),
      library =
        if (
          this@PlanDefinitionSurrogate.library == null &&
            this@PlanDefinitionSurrogate._library == null
        ) {
          listOf()
        } else {
          (this@PlanDefinitionSurrogate.library
              ?: List(this@PlanDefinitionSurrogate._library!!.size) { null })
            .zip(
              this@PlanDefinitionSurrogate._library
                ?: List(this@PlanDefinitionSurrogate.library!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      goal = this@PlanDefinitionSurrogate.goal ?: listOf(),
      action = this@PlanDefinitionSurrogate.action ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: PlanDefinition): PlanDefinitionSurrogate =
      with(model) {
        PlanDefinitionSurrogate(
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
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          subtitle = this@with.subtitle?.value,
          _subtitle = this@with.subtitle?.toElement(),
          type = this@with.type,
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          experimental = this@with.experimental?.value,
          _experimental = this@with.experimental?.toElement(),
          subject = this@with.subject,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          usage = this@with.usage?.value,
          _usage = this@with.usage?.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
          approvalDate = this@with.approvalDate?.value?.toString(),
          _approvalDate = this@with.approvalDate?.toElement(),
          lastReviewDate = this@with.lastReviewDate?.value?.toString(),
          _lastReviewDate = this@with.lastReviewDate?.toElement(),
          effectivePeriod = this@with.effectivePeriod,
          topic = this@with.topic.takeIf { it.isNotEmpty() },
          author = this@with.author.takeIf { it.isNotEmpty() },
          editor = this@with.editor.takeIf { it.isNotEmpty() },
          reviewer = this@with.reviewer.takeIf { it.isNotEmpty() },
          endorser = this@with.endorser.takeIf { it.isNotEmpty() },
          relatedArtifact = this@with.relatedArtifact.takeIf { it.isNotEmpty() },
          library =
            this@with.library.map { it.value }.toList().takeUnless { it.all { it == null } },
          _library =
            this@with.library
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          goal = this@with.goal.takeIf { it.isNotEmpty() },
          action = this@with.action.takeIf { it.isNotEmpty() },
        )
      }
  }
}
