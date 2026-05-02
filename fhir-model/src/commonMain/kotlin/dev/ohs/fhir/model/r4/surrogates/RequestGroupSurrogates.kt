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

package com.google.fhir.model.r4.surrogates

import com.google.fhir.model.r4.Age
import com.google.fhir.model.r4.Annotation
import com.google.fhir.model.r4.Canonical
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Duration
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Expression
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Id
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.Range
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.RelatedArtifact
import com.google.fhir.model.r4.RequestGroup
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Timing
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class RequestGroupActionSurrogate(
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
  public var documentation: List<RelatedArtifact>? = null,
  public var condition: List<RequestGroup.Action.Condition>? = null,
  public var relatedAction: List<RequestGroup.Action.RelatedAction>? = null,
  public var timing: RequestGroup.Action.Timing? = null,
  public var participant: List<Reference>? = null,
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
  public var action: List<RequestGroup.Action>? = null,
) {
  public fun toModel(): RequestGroup.Action =
    RequestGroup.Action(
      id = this@RequestGroupActionSurrogate.id,
      extension = this@RequestGroupActionSurrogate.extension ?: listOf(),
      modifierExtension = this@RequestGroupActionSurrogate.modifierExtension ?: listOf(),
      prefix =
        R4String.of(
          this@RequestGroupActionSurrogate.prefix,
          this@RequestGroupActionSurrogate._prefix,
        ),
      title =
        R4String.of(
          this@RequestGroupActionSurrogate.title,
          this@RequestGroupActionSurrogate._title,
        ),
      description =
        R4String.of(
          this@RequestGroupActionSurrogate.description,
          this@RequestGroupActionSurrogate._description,
        ),
      textEquivalent =
        R4String.of(
          this@RequestGroupActionSurrogate.textEquivalent,
          this@RequestGroupActionSurrogate._textEquivalent,
        ),
      priority =
        this@RequestGroupActionSurrogate.priority?.let {
          Enumeration.of(
            RequestGroup.RequestPriority.fromCode(it),
            this@RequestGroupActionSurrogate._priority,
          )
        },
      code = this@RequestGroupActionSurrogate.code ?: listOf(),
      documentation = this@RequestGroupActionSurrogate.documentation ?: listOf(),
      condition = this@RequestGroupActionSurrogate.condition ?: listOf(),
      relatedAction = this@RequestGroupActionSurrogate.relatedAction ?: listOf(),
      timing = this@RequestGroupActionSurrogate.timing,
      participant = this@RequestGroupActionSurrogate.participant ?: listOf(),
      type = this@RequestGroupActionSurrogate.type,
      groupingBehavior =
        this@RequestGroupActionSurrogate.groupingBehavior?.let {
          Enumeration.of(
            RequestGroup.ActionGroupingBehavior.fromCode(it),
            this@RequestGroupActionSurrogate._groupingBehavior,
          )
        },
      selectionBehavior =
        this@RequestGroupActionSurrogate.selectionBehavior?.let {
          Enumeration.of(
            RequestGroup.ActionSelectionBehavior.fromCode(it),
            this@RequestGroupActionSurrogate._selectionBehavior,
          )
        },
      requiredBehavior =
        this@RequestGroupActionSurrogate.requiredBehavior?.let {
          Enumeration.of(
            RequestGroup.ActionRequiredBehavior.fromCode(it),
            this@RequestGroupActionSurrogate._requiredBehavior,
          )
        },
      precheckBehavior =
        this@RequestGroupActionSurrogate.precheckBehavior?.let {
          Enumeration.of(
            RequestGroup.ActionPrecheckBehavior.fromCode(it),
            this@RequestGroupActionSurrogate._precheckBehavior,
          )
        },
      cardinalityBehavior =
        this@RequestGroupActionSurrogate.cardinalityBehavior?.let {
          Enumeration.of(
            RequestGroup.ActionCardinalityBehavior.fromCode(it),
            this@RequestGroupActionSurrogate._cardinalityBehavior,
          )
        },
      resource = this@RequestGroupActionSurrogate.resource,
      action = this@RequestGroupActionSurrogate.action ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: RequestGroup.Action): RequestGroupActionSurrogate =
      with(model) {
        RequestGroupActionSurrogate(
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
          documentation = this@with.documentation.takeIf { it.isNotEmpty() },
          condition = this@with.condition.takeIf { it.isNotEmpty() },
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
          resource = this@with.resource,
          action = this@with.action.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class RequestGroupActionConditionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var kind: KotlinString? = null,
  public var _kind: Element? = null,
  public var expression: Expression? = null,
) {
  public fun toModel(): RequestGroup.Action.Condition =
    RequestGroup.Action.Condition(
      id = this@RequestGroupActionConditionSurrogate.id,
      extension = this@RequestGroupActionConditionSurrogate.extension ?: listOf(),
      modifierExtension = this@RequestGroupActionConditionSurrogate.modifierExtension ?: listOf(),
      kind =
        Enumeration.of(
          RequestGroup.ActionConditionKind.fromCode(
            this@RequestGroupActionConditionSurrogate.kind!!
          ),
          this@RequestGroupActionConditionSurrogate._kind,
        ),
      expression = this@RequestGroupActionConditionSurrogate.expression,
    )

  public companion object {
    public fun fromModel(
      model: RequestGroup.Action.Condition
    ): RequestGroupActionConditionSurrogate =
      with(model) {
        RequestGroupActionConditionSurrogate(
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
internal data class RequestGroupActionRelatedActionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var actionId: KotlinString? = null,
  public var _actionId: Element? = null,
  public var relationship: KotlinString? = null,
  public var _relationship: Element? = null,
  public var offset: RequestGroup.Action.RelatedAction.Offset? = null,
) {
  public fun toModel(): RequestGroup.Action.RelatedAction =
    RequestGroup.Action.RelatedAction(
      id = this@RequestGroupActionRelatedActionSurrogate.id,
      extension = this@RequestGroupActionRelatedActionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@RequestGroupActionRelatedActionSurrogate.modifierExtension ?: listOf(),
      actionId =
        Id.of(
          this@RequestGroupActionRelatedActionSurrogate.actionId,
          this@RequestGroupActionRelatedActionSurrogate._actionId,
        )!!,
      relationship =
        Enumeration.of(
          RequestGroup.ActionRelationshipType.fromCode(
            this@RequestGroupActionRelatedActionSurrogate.relationship!!
          ),
          this@RequestGroupActionRelatedActionSurrogate._relationship,
        ),
      offset = this@RequestGroupActionRelatedActionSurrogate.offset,
    )

  public companion object {
    public fun fromModel(
      model: RequestGroup.Action.RelatedAction
    ): RequestGroupActionRelatedActionSurrogate =
      with(model) {
        RequestGroupActionRelatedActionSurrogate(
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
internal data class RequestGroupActionRelatedActionOffsetSurrogate(
  public var offsetDuration: Duration? = null,
  public var offsetRange: Range? = null,
) {
  public fun toModel(): RequestGroup.Action.RelatedAction.Offset =
    RequestGroup.Action.RelatedAction.Offset.from(
      this@RequestGroupActionRelatedActionOffsetSurrogate.offsetDuration,
      this@RequestGroupActionRelatedActionOffsetSurrogate.offsetRange,
    )!!

  public companion object {
    public fun fromModel(
      model: RequestGroup.Action.RelatedAction.Offset
    ): RequestGroupActionRelatedActionOffsetSurrogate =
      with(model) {
        RequestGroupActionRelatedActionOffsetSurrogate(
          offsetDuration = this@with.asDuration()?.value,
          offsetRange = this@with.asRange()?.value,
        )
      }
  }
}

@Serializable
internal data class RequestGroupActionTimingSurrogate(
  public var timingDateTime: KotlinString? = null,
  public var _timingDateTime: Element? = null,
  public var timingAge: Age? = null,
  public var timingPeriod: Period? = null,
  public var timingDuration: Duration? = null,
  public var timingRange: Range? = null,
  public var timingTiming: Timing? = null,
) {
  public fun toModel(): RequestGroup.Action.Timing =
    RequestGroup.Action.Timing.from(
      DateTime.of(
        FhirDateTime.fromString(this@RequestGroupActionTimingSurrogate.timingDateTime),
        this@RequestGroupActionTimingSurrogate._timingDateTime,
      ),
      this@RequestGroupActionTimingSurrogate.timingAge,
      this@RequestGroupActionTimingSurrogate.timingPeriod,
      this@RequestGroupActionTimingSurrogate.timingDuration,
      this@RequestGroupActionTimingSurrogate.timingRange,
      this@RequestGroupActionTimingSurrogate.timingTiming,
    )!!

  public companion object {
    public fun fromModel(model: RequestGroup.Action.Timing): RequestGroupActionTimingSurrogate =
      with(model) {
        RequestGroupActionTimingSurrogate(
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
internal data class RequestGroupSurrogate(
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
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var action: List<RequestGroup.Action>? = null,
) {
  public fun toModel(): RequestGroup =
    RequestGroup(
      id = this@RequestGroupSurrogate.id,
      meta = this@RequestGroupSurrogate.meta,
      implicitRules =
        Uri.of(this@RequestGroupSurrogate.implicitRules, this@RequestGroupSurrogate._implicitRules),
      language = Code.of(this@RequestGroupSurrogate.language, this@RequestGroupSurrogate._language),
      text = this@RequestGroupSurrogate.text,
      contained = this@RequestGroupSurrogate.contained ?: listOf(),
      extension = this@RequestGroupSurrogate.extension ?: listOf(),
      modifierExtension = this@RequestGroupSurrogate.modifierExtension ?: listOf(),
      identifier = this@RequestGroupSurrogate.identifier ?: listOf(),
      instantiatesCanonical =
        if (
          this@RequestGroupSurrogate.instantiatesCanonical == null &&
            this@RequestGroupSurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@RequestGroupSurrogate.instantiatesCanonical
              ?: List(this@RequestGroupSurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@RequestGroupSurrogate._instantiatesCanonical
                ?: List(this@RequestGroupSurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@RequestGroupSurrogate.instantiatesUri == null &&
            this@RequestGroupSurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@RequestGroupSurrogate.instantiatesUri
              ?: List(this@RequestGroupSurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@RequestGroupSurrogate._instantiatesUri
                ?: List(this@RequestGroupSurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      basedOn = this@RequestGroupSurrogate.basedOn ?: listOf(),
      replaces = this@RequestGroupSurrogate.replaces ?: listOf(),
      groupIdentifier = this@RequestGroupSurrogate.groupIdentifier,
      status =
        Enumeration.of(
          RequestGroup.RequestStatus.fromCode(this@RequestGroupSurrogate.status!!),
          this@RequestGroupSurrogate._status,
        ),
      intent =
        Enumeration.of(
          RequestGroup.RequestIntent.fromCode(this@RequestGroupSurrogate.intent!!),
          this@RequestGroupSurrogate._intent,
        ),
      priority =
        this@RequestGroupSurrogate.priority?.let {
          Enumeration.of(
            RequestGroup.RequestPriority.fromCode(it),
            this@RequestGroupSurrogate._priority,
          )
        },
      code = this@RequestGroupSurrogate.code,
      subject = this@RequestGroupSurrogate.subject,
      encounter = this@RequestGroupSurrogate.encounter,
      authoredOn =
        DateTime.of(
          FhirDateTime.fromString(this@RequestGroupSurrogate.authoredOn),
          this@RequestGroupSurrogate._authoredOn,
        ),
      author = this@RequestGroupSurrogate.author,
      reasonCode = this@RequestGroupSurrogate.reasonCode ?: listOf(),
      reasonReference = this@RequestGroupSurrogate.reasonReference ?: listOf(),
      note = this@RequestGroupSurrogate.note ?: listOf(),
      action = this@RequestGroupSurrogate.action ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: RequestGroup): RequestGroupSurrogate =
      with(model) {
        RequestGroupSurrogate(
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
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          action = this@with.action.takeIf { it.isNotEmpty() },
        )
      }
  }
}
