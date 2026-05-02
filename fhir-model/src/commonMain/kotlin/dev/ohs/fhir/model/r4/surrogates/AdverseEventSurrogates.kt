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

import com.google.fhir.model.r4.AdverseEvent
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class AdverseEventSuspectEntitySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var instance: Reference,
  public var causality: List<AdverseEvent.SuspectEntity.Causality>? = null,
) {
  public fun toModel(): AdverseEvent.SuspectEntity =
    AdverseEvent.SuspectEntity(
      id = this@AdverseEventSuspectEntitySurrogate.id,
      extension = this@AdverseEventSuspectEntitySurrogate.extension ?: listOf(),
      modifierExtension = this@AdverseEventSuspectEntitySurrogate.modifierExtension ?: listOf(),
      instance = this@AdverseEventSuspectEntitySurrogate.instance,
      causality = this@AdverseEventSuspectEntitySurrogate.causality ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: AdverseEvent.SuspectEntity): AdverseEventSuspectEntitySurrogate =
      with(model) {
        AdverseEventSuspectEntitySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          instance = this@with.instance,
          causality = this@with.causality.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class AdverseEventSuspectEntityCausalitySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var assessment: CodeableConcept? = null,
  public var productRelatedness: KotlinString? = null,
  public var _productRelatedness: Element? = null,
  public var author: Reference? = null,
  public var method: CodeableConcept? = null,
) {
  public fun toModel(): AdverseEvent.SuspectEntity.Causality =
    AdverseEvent.SuspectEntity.Causality(
      id = this@AdverseEventSuspectEntityCausalitySurrogate.id,
      extension = this@AdverseEventSuspectEntityCausalitySurrogate.extension ?: listOf(),
      modifierExtension =
        this@AdverseEventSuspectEntityCausalitySurrogate.modifierExtension ?: listOf(),
      assessment = this@AdverseEventSuspectEntityCausalitySurrogate.assessment,
      productRelatedness =
        R4String.of(
          this@AdverseEventSuspectEntityCausalitySurrogate.productRelatedness,
          this@AdverseEventSuspectEntityCausalitySurrogate._productRelatedness,
        ),
      author = this@AdverseEventSuspectEntityCausalitySurrogate.author,
      method = this@AdverseEventSuspectEntityCausalitySurrogate.method,
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
          assessment = this@with.assessment,
          productRelatedness = this@with.productRelatedness?.value,
          _productRelatedness = this@with.productRelatedness?.toElement(),
          author = this@with.author,
          method = this@with.method,
        )
      }
  }
}

@Serializable
internal data class AdverseEventSurrogate(
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
  public var identifier: Identifier? = null,
  public var actuality: KotlinString? = null,
  public var _actuality: Element? = null,
  public var category: List<CodeableConcept>? = null,
  public var event: CodeableConcept? = null,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var detected: KotlinString? = null,
  public var _detected: Element? = null,
  public var recordedDate: KotlinString? = null,
  public var _recordedDate: Element? = null,
  public var resultingCondition: List<Reference>? = null,
  public var location: Reference? = null,
  public var seriousness: CodeableConcept? = null,
  public var severity: CodeableConcept? = null,
  public var outcome: CodeableConcept? = null,
  public var recorder: Reference? = null,
  public var contributor: List<Reference>? = null,
  public var suspectEntity: List<AdverseEvent.SuspectEntity>? = null,
  public var subjectMedicalHistory: List<Reference>? = null,
  public var referenceDocument: List<Reference>? = null,
  public var study: List<Reference>? = null,
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
      identifier = this@AdverseEventSurrogate.identifier,
      actuality =
        Enumeration.of(
          AdverseEvent.AdverseEventActuality.fromCode(this@AdverseEventSurrogate.actuality!!),
          this@AdverseEventSurrogate._actuality,
        ),
      category = this@AdverseEventSurrogate.category ?: listOf(),
      event = this@AdverseEventSurrogate.event,
      subject = this@AdverseEventSurrogate.subject,
      encounter = this@AdverseEventSurrogate.encounter,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@AdverseEventSurrogate.date),
          this@AdverseEventSurrogate._date,
        ),
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
      resultingCondition = this@AdverseEventSurrogate.resultingCondition ?: listOf(),
      location = this@AdverseEventSurrogate.location,
      seriousness = this@AdverseEventSurrogate.seriousness,
      severity = this@AdverseEventSurrogate.severity,
      outcome = this@AdverseEventSurrogate.outcome,
      recorder = this@AdverseEventSurrogate.recorder,
      contributor = this@AdverseEventSurrogate.contributor ?: listOf(),
      suspectEntity = this@AdverseEventSurrogate.suspectEntity ?: listOf(),
      subjectMedicalHistory = this@AdverseEventSurrogate.subjectMedicalHistory ?: listOf(),
      referenceDocument = this@AdverseEventSurrogate.referenceDocument ?: listOf(),
      study = this@AdverseEventSurrogate.study ?: listOf(),
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
          identifier = this@with.identifier,
          actuality = this@with.actuality.value?.getCode(),
          _actuality = this@with.actuality.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          event = this@with.event,
          subject = this@with.subject,
          encounter = this@with.encounter,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          detected = this@with.detected?.value?.toString(),
          _detected = this@with.detected?.toElement(),
          recordedDate = this@with.recordedDate?.value?.toString(),
          _recordedDate = this@with.recordedDate?.toElement(),
          resultingCondition = this@with.resultingCondition.takeIf { it.isNotEmpty() },
          location = this@with.location,
          seriousness = this@with.seriousness,
          severity = this@with.severity,
          outcome = this@with.outcome,
          recorder = this@with.recorder,
          contributor = this@with.contributor.takeIf { it.isNotEmpty() },
          suspectEntity = this@with.suspectEntity.takeIf { it.isNotEmpty() },
          subjectMedicalHistory = this@with.subjectMedicalHistory.takeIf { it.isNotEmpty() },
          referenceDocument = this@with.referenceDocument.takeIf { it.isNotEmpty() },
          study = this@with.study.takeIf { it.isNotEmpty() },
        )
      }
  }
}
