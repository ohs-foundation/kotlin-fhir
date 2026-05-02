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

import com.google.fhir.model.r5.AdverseEvent
import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class AdverseEventParticipantSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var function: CodeableConcept? = null,
  public var actor: Reference,
) {
  public fun toModel(): AdverseEvent.Participant =
    AdverseEvent.Participant(
      id = this@AdverseEventParticipantSurrogate.id,
      extension = this@AdverseEventParticipantSurrogate.extension ?: listOf(),
      modifierExtension = this@AdverseEventParticipantSurrogate.modifierExtension ?: listOf(),
      function = this@AdverseEventParticipantSurrogate.function,
      actor = this@AdverseEventParticipantSurrogate.actor,
    )

  public companion object {
    public fun fromModel(model: AdverseEvent.Participant): AdverseEventParticipantSurrogate =
      with(model) {
        AdverseEventParticipantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          function = this@with.function,
          actor = this@with.actor,
        )
      }
  }
}

@Serializable
internal data class AdverseEventSuspectEntitySurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var instance: AdverseEvent.SuspectEntity.Instance,
  public var causality: AdverseEvent.SuspectEntity.Causality? = null,
) {
  public fun toModel(): AdverseEvent.SuspectEntity =
    AdverseEvent.SuspectEntity(
      id = this@AdverseEventSuspectEntitySurrogate.id,
      extension = this@AdverseEventSuspectEntitySurrogate.extension ?: listOf(),
      modifierExtension = this@AdverseEventSuspectEntitySurrogate.modifierExtension ?: listOf(),
      instance = this@AdverseEventSuspectEntitySurrogate.instance,
      causality = this@AdverseEventSuspectEntitySurrogate.causality,
    )

  public companion object {
    public fun fromModel(model: AdverseEvent.SuspectEntity): AdverseEventSuspectEntitySurrogate =
      with(model) {
        AdverseEventSuspectEntitySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          instance = this@with.instance,
          causality = this@with.causality,
        )
      }
  }
}

@Serializable
internal data class AdverseEventSuspectEntityCausalitySurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var assessmentMethod: CodeableConcept? = null,
  public var entityRelatedness: CodeableConcept? = null,
  public var author: Reference? = null,
) {
  public fun toModel(): AdverseEvent.SuspectEntity.Causality =
    AdverseEvent.SuspectEntity.Causality(
      id = this@AdverseEventSuspectEntityCausalitySurrogate.id,
      extension = this@AdverseEventSuspectEntityCausalitySurrogate.extension ?: listOf(),
      modifierExtension =
        this@AdverseEventSuspectEntityCausalitySurrogate.modifierExtension ?: listOf(),
      assessmentMethod = this@AdverseEventSuspectEntityCausalitySurrogate.assessmentMethod,
      entityRelatedness = this@AdverseEventSuspectEntityCausalitySurrogate.entityRelatedness,
      author = this@AdverseEventSuspectEntityCausalitySurrogate.author,
    )

  public companion object {
    public fun fromModel(
      model: AdverseEvent.SuspectEntity.Causality
    ): AdverseEventSuspectEntityCausalitySurrogate =
      with(model) {
        AdverseEventSuspectEntityCausalitySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          assessmentMethod = this@with.assessmentMethod,
          entityRelatedness = this@with.entityRelatedness,
          author = this@with.author,
        )
      }
  }
}

@Serializable
internal data class AdverseEventContributingFactorSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: AdverseEvent.ContributingFactor.Item,
) {
  public fun toModel(): AdverseEvent.ContributingFactor =
    AdverseEvent.ContributingFactor(
      id = this@AdverseEventContributingFactorSurrogate.id,
      extension = this@AdverseEventContributingFactorSurrogate.extension ?: listOf(),
      modifierExtension =
        this@AdverseEventContributingFactorSurrogate.modifierExtension ?: listOf(),
      item = this@AdverseEventContributingFactorSurrogate.item,
    )

  public companion object {
    public fun fromModel(
      model: AdverseEvent.ContributingFactor
    ): AdverseEventContributingFactorSurrogate =
      with(model) {
        AdverseEventContributingFactorSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
        )
      }
  }
}

@Serializable
internal data class AdverseEventPreventiveActionSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: AdverseEvent.PreventiveAction.Item,
) {
  public fun toModel(): AdverseEvent.PreventiveAction =
    AdverseEvent.PreventiveAction(
      id = this@AdverseEventPreventiveActionSurrogate.id,
      extension = this@AdverseEventPreventiveActionSurrogate.extension ?: listOf(),
      modifierExtension = this@AdverseEventPreventiveActionSurrogate.modifierExtension ?: listOf(),
      item = this@AdverseEventPreventiveActionSurrogate.item,
    )

  public companion object {
    public fun fromModel(
      model: AdverseEvent.PreventiveAction
    ): AdverseEventPreventiveActionSurrogate =
      with(model) {
        AdverseEventPreventiveActionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
        )
      }
  }
}

@Serializable
internal data class AdverseEventMitigatingActionSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: AdverseEvent.MitigatingAction.Item,
) {
  public fun toModel(): AdverseEvent.MitigatingAction =
    AdverseEvent.MitigatingAction(
      id = this@AdverseEventMitigatingActionSurrogate.id,
      extension = this@AdverseEventMitigatingActionSurrogate.extension ?: listOf(),
      modifierExtension = this@AdverseEventMitigatingActionSurrogate.modifierExtension ?: listOf(),
      item = this@AdverseEventMitigatingActionSurrogate.item,
    )

  public companion object {
    public fun fromModel(
      model: AdverseEvent.MitigatingAction
    ): AdverseEventMitigatingActionSurrogate =
      with(model) {
        AdverseEventMitigatingActionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
        )
      }
  }
}

@Serializable
internal data class AdverseEventSupportingInfoSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: AdverseEvent.SupportingInfo.Item,
) {
  public fun toModel(): AdverseEvent.SupportingInfo =
    AdverseEvent.SupportingInfo(
      id = this@AdverseEventSupportingInfoSurrogate.id,
      extension = this@AdverseEventSupportingInfoSurrogate.extension ?: listOf(),
      modifierExtension = this@AdverseEventSupportingInfoSurrogate.modifierExtension ?: listOf(),
      item = this@AdverseEventSupportingInfoSurrogate.item,
    )

  public companion object {
    public fun fromModel(model: AdverseEvent.SupportingInfo): AdverseEventSupportingInfoSurrogate =
      with(model) {
        AdverseEventSupportingInfoSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
        )
      }
  }
}

@Serializable
internal data class AdverseEventOccurrenceSurrogate(
  public var occurrenceDateTime: String? = null,
  public var _occurrenceDateTime: Element? = null,
  public var occurrencePeriod: Period? = null,
  public var occurrenceTiming: Timing? = null,
) {
  public fun toModel(): AdverseEvent.Occurrence =
    AdverseEvent.Occurrence.from(
      DateTime.of(
        FhirDateTime.fromString(this@AdverseEventOccurrenceSurrogate.occurrenceDateTime),
        this@AdverseEventOccurrenceSurrogate._occurrenceDateTime,
      ),
      this@AdverseEventOccurrenceSurrogate.occurrencePeriod,
      this@AdverseEventOccurrenceSurrogate.occurrenceTiming,
    )!!

  public companion object {
    public fun fromModel(model: AdverseEvent.Occurrence): AdverseEventOccurrenceSurrogate =
      with(model) {
        AdverseEventOccurrenceSurrogate(
          occurrenceDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _occurrenceDateTime = this@with.asDateTime()?.value?.toElement(),
          occurrencePeriod = this@with.asPeriod()?.value,
          occurrenceTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class AdverseEventSuspectEntityInstanceSurrogate(
  public var instanceCodeableConcept: CodeableConcept? = null,
  public var instanceReference: Reference? = null,
) {
  public fun toModel(): AdverseEvent.SuspectEntity.Instance =
    AdverseEvent.SuspectEntity.Instance.from(
      this@AdverseEventSuspectEntityInstanceSurrogate.instanceCodeableConcept,
      this@AdverseEventSuspectEntityInstanceSurrogate.instanceReference,
    )!!

  public companion object {
    public fun fromModel(
      model: AdverseEvent.SuspectEntity.Instance
    ): AdverseEventSuspectEntityInstanceSurrogate =
      with(model) {
        AdverseEventSuspectEntityInstanceSurrogate(
          instanceCodeableConcept = this@with.asCodeableConcept()?.value,
          instanceReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class AdverseEventContributingFactorItemSurrogate(
  public var itemReference: Reference? = null,
  public var itemCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): AdverseEvent.ContributingFactor.Item =
    AdverseEvent.ContributingFactor.Item.from(
      this@AdverseEventContributingFactorItemSurrogate.itemReference,
      this@AdverseEventContributingFactorItemSurrogate.itemCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: AdverseEvent.ContributingFactor.Item
    ): AdverseEventContributingFactorItemSurrogate =
      with(model) {
        AdverseEventContributingFactorItemSurrogate(
          itemReference = this@with.asReference()?.value,
          itemCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class AdverseEventPreventiveActionItemSurrogate(
  public var itemReference: Reference? = null,
  public var itemCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): AdverseEvent.PreventiveAction.Item =
    AdverseEvent.PreventiveAction.Item.from(
      this@AdverseEventPreventiveActionItemSurrogate.itemReference,
      this@AdverseEventPreventiveActionItemSurrogate.itemCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: AdverseEvent.PreventiveAction.Item
    ): AdverseEventPreventiveActionItemSurrogate =
      with(model) {
        AdverseEventPreventiveActionItemSurrogate(
          itemReference = this@with.asReference()?.value,
          itemCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class AdverseEventMitigatingActionItemSurrogate(
  public var itemReference: Reference? = null,
  public var itemCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): AdverseEvent.MitigatingAction.Item =
    AdverseEvent.MitigatingAction.Item.from(
      this@AdverseEventMitigatingActionItemSurrogate.itemReference,
      this@AdverseEventMitigatingActionItemSurrogate.itemCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: AdverseEvent.MitigatingAction.Item
    ): AdverseEventMitigatingActionItemSurrogate =
      with(model) {
        AdverseEventMitigatingActionItemSurrogate(
          itemReference = this@with.asReference()?.value,
          itemCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class AdverseEventSupportingInfoItemSurrogate(
  public var itemReference: Reference? = null,
  public var itemCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): AdverseEvent.SupportingInfo.Item =
    AdverseEvent.SupportingInfo.Item.from(
      this@AdverseEventSupportingInfoItemSurrogate.itemReference,
      this@AdverseEventSupportingInfoItemSurrogate.itemCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: AdverseEvent.SupportingInfo.Item
    ): AdverseEventSupportingInfoItemSurrogate =
      with(model) {
        AdverseEventSupportingInfoItemSurrogate(
          itemReference = this@with.asReference()?.value,
          itemCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class AdverseEventSurrogate(
  public var id: String? = null,
  public var meta: Meta? = null,
  public var implicitRules: String? = null,
  public var _implicitRules: Element? = null,
  public var language: String? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var status: String? = null,
  public var _status: Element? = null,
  public var actuality: String? = null,
  public var _actuality: Element? = null,
  public var category: List<CodeableConcept>? = null,
  public var code: CodeableConcept? = null,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var occurrence: AdverseEvent.Occurrence? = null,
  public var detected: String? = null,
  public var _detected: Element? = null,
  public var recordedDate: String? = null,
  public var _recordedDate: Element? = null,
  public var resultingEffect: List<Reference>? = null,
  public var location: Reference? = null,
  public var seriousness: CodeableConcept? = null,
  public var outcome: List<CodeableConcept>? = null,
  public var recorder: Reference? = null,
  public var participant: List<AdverseEvent.Participant>? = null,
  public var study: List<Reference>? = null,
  public var expectedInResearchStudy: KotlinBoolean? = null,
  public var _expectedInResearchStudy: Element? = null,
  public var suspectEntity: List<AdverseEvent.SuspectEntity>? = null,
  public var contributingFactor: List<AdverseEvent.ContributingFactor>? = null,
  public var preventiveAction: List<AdverseEvent.PreventiveAction>? = null,
  public var mitigatingAction: List<AdverseEvent.MitigatingAction>? = null,
  public var supportingInfo: List<AdverseEvent.SupportingInfo>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): AdverseEvent =
    AdverseEvent(
      id = this@AdverseEventSurrogate.id,
      meta = this@AdverseEventSurrogate.meta,
      implicitRules =
        Uri.of(this@AdverseEventSurrogate.implicitRules, this@AdverseEventSurrogate._implicitRules),
      language = Code.of(this@AdverseEventSurrogate.language, this@AdverseEventSurrogate._language),
      text = this@AdverseEventSurrogate.text,
      contained = this@AdverseEventSurrogate.contained ?: listOf(),
      extension = this@AdverseEventSurrogate.extension ?: listOf(),
      modifierExtension = this@AdverseEventSurrogate.modifierExtension ?: listOf(),
      identifier = this@AdverseEventSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          AdverseEvent.AdverseEventStatus.fromCode(this@AdverseEventSurrogate.status!!),
          this@AdverseEventSurrogate._status,
        ),
      actuality =
        Enumeration.of(
          AdverseEvent.AdverseEventActuality.fromCode(this@AdverseEventSurrogate.actuality!!),
          this@AdverseEventSurrogate._actuality,
        ),
      category = this@AdverseEventSurrogate.category ?: listOf(),
      code = this@AdverseEventSurrogate.code,
      subject = this@AdverseEventSurrogate.subject,
      encounter = this@AdverseEventSurrogate.encounter,
      occurrence = this@AdverseEventSurrogate.occurrence,
      detected =
        DateTime.of(
          FhirDateTime.fromString(this@AdverseEventSurrogate.detected),
          this@AdverseEventSurrogate._detected,
        ),
      recordedDate =
        DateTime.of(
          FhirDateTime.fromString(this@AdverseEventSurrogate.recordedDate),
          this@AdverseEventSurrogate._recordedDate,
        ),
      resultingEffect = this@AdverseEventSurrogate.resultingEffect ?: listOf(),
      location = this@AdverseEventSurrogate.location,
      seriousness = this@AdverseEventSurrogate.seriousness,
      outcome = this@AdverseEventSurrogate.outcome ?: listOf(),
      recorder = this@AdverseEventSurrogate.recorder,
      participant = this@AdverseEventSurrogate.participant ?: listOf(),
      study = this@AdverseEventSurrogate.study ?: listOf(),
      expectedInResearchStudy =
        R5Boolean.of(
          this@AdverseEventSurrogate.expectedInResearchStudy,
          this@AdverseEventSurrogate._expectedInResearchStudy,
        ),
      suspectEntity = this@AdverseEventSurrogate.suspectEntity ?: listOf(),
      contributingFactor = this@AdverseEventSurrogate.contributingFactor ?: listOf(),
      preventiveAction = this@AdverseEventSurrogate.preventiveAction ?: listOf(),
      mitigatingAction = this@AdverseEventSurrogate.mitigatingAction ?: listOf(),
      supportingInfo = this@AdverseEventSurrogate.supportingInfo ?: listOf(),
      note = this@AdverseEventSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: AdverseEvent): AdverseEventSurrogate =
      with(model) {
        AdverseEventSurrogate(
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
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          actuality = this@with.actuality.value?.getCode(),
          _actuality = this@with.actuality.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          code = this@with.code,
          subject = this@with.subject,
          encounter = this@with.encounter,
          occurrence = this@with.occurrence,
          detected = this@with.detected?.value?.toString(),
          _detected = this@with.detected?.toElement(),
          recordedDate = this@with.recordedDate?.value?.toString(),
          _recordedDate = this@with.recordedDate?.toElement(),
          resultingEffect = this@with.resultingEffect.takeIf { it.isNotEmpty() },
          location = this@with.location,
          seriousness = this@with.seriousness,
          outcome = this@with.outcome.takeIf { it.isNotEmpty() },
          recorder = this@with.recorder,
          participant = this@with.participant.takeIf { it.isNotEmpty() },
          study = this@with.study.takeIf { it.isNotEmpty() },
          expectedInResearchStudy = this@with.expectedInResearchStudy?.value,
          _expectedInResearchStudy = this@with.expectedInResearchStudy?.toElement(),
          suspectEntity = this@with.suspectEntity.takeIf { it.isNotEmpty() },
          contributingFactor = this@with.contributingFactor.takeIf { it.isNotEmpty() },
          preventiveAction = this@with.preventiveAction.takeIf { it.isNotEmpty() },
          mitigatingAction = this@with.mitigatingAction.takeIf { it.isNotEmpty() },
          supportingInfo = this@with.supportingInfo.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
