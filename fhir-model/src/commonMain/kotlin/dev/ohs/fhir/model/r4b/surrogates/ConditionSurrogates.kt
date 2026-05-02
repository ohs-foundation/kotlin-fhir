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
import com.google.fhir.model.r4b.Annotation
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Condition
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Range
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ConditionStageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var summary: CodeableConcept? = null,
  public var assessment: List<Reference>? = null,
  public var type: CodeableConcept? = null,
) {
  public fun toModel(): Condition.Stage =
    Condition.Stage(
      id = this@ConditionStageSurrogate.id,
      extension = this@ConditionStageSurrogate.extension ?: listOf(),
      modifierExtension = this@ConditionStageSurrogate.modifierExtension ?: listOf(),
      summary = this@ConditionStageSurrogate.summary,
      assessment = this@ConditionStageSurrogate.assessment ?: listOf(),
      type = this@ConditionStageSurrogate.type,
    )

  public companion object {
    public fun fromModel(model: Condition.Stage): ConditionStageSurrogate =
      with(model) {
        ConditionStageSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          summary = this@with.summary,
          assessment = this@with.assessment.takeIf { it.isNotEmpty() },
          type = this@with.type,
        )
      }
  }
}

@Serializable
internal data class ConditionEvidenceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: List<CodeableConcept>? = null,
  public var detail: List<Reference>? = null,
) {
  public fun toModel(): Condition.Evidence =
    Condition.Evidence(
      id = this@ConditionEvidenceSurrogate.id,
      extension = this@ConditionEvidenceSurrogate.extension ?: listOf(),
      modifierExtension = this@ConditionEvidenceSurrogate.modifierExtension ?: listOf(),
      code = this@ConditionEvidenceSurrogate.code ?: listOf(),
      detail = this@ConditionEvidenceSurrogate.detail ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Condition.Evidence): ConditionEvidenceSurrogate =
      with(model) {
        ConditionEvidenceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.takeIf { it.isNotEmpty() },
          detail = this@with.detail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ConditionOnsetSurrogate(
  public var onsetDateTime: KotlinString? = null,
  public var _onsetDateTime: Element? = null,
  public var onsetAge: Age? = null,
  public var onsetPeriod: Period? = null,
  public var onsetRange: Range? = null,
  public var onsetString: KotlinString? = null,
  public var _onsetString: Element? = null,
) {
  public fun toModel(): Condition.Onset =
    Condition.Onset.from(
      DateTime.of(
        FhirDateTime.fromString(this@ConditionOnsetSurrogate.onsetDateTime),
        this@ConditionOnsetSurrogate._onsetDateTime,
      ),
      this@ConditionOnsetSurrogate.onsetAge,
      this@ConditionOnsetSurrogate.onsetPeriod,
      this@ConditionOnsetSurrogate.onsetRange,
      R4bString.of(
        this@ConditionOnsetSurrogate.onsetString,
        this@ConditionOnsetSurrogate._onsetString,
      ),
    )!!

  public companion object {
    public fun fromModel(model: Condition.Onset): ConditionOnsetSurrogate =
      with(model) {
        ConditionOnsetSurrogate(
          onsetDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _onsetDateTime = this@with.asDateTime()?.value?.toElement(),
          onsetAge = this@with.asAge()?.value,
          onsetPeriod = this@with.asPeriod()?.value,
          onsetRange = this@with.asRange()?.value,
          onsetString = this@with.asString()?.value?.value,
          _onsetString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ConditionAbatementSurrogate(
  public var abatementDateTime: KotlinString? = null,
  public var _abatementDateTime: Element? = null,
  public var abatementAge: Age? = null,
  public var abatementPeriod: Period? = null,
  public var abatementRange: Range? = null,
  public var abatementString: KotlinString? = null,
  public var _abatementString: Element? = null,
) {
  public fun toModel(): Condition.Abatement =
    Condition.Abatement.from(
      DateTime.of(
        FhirDateTime.fromString(this@ConditionAbatementSurrogate.abatementDateTime),
        this@ConditionAbatementSurrogate._abatementDateTime,
      ),
      this@ConditionAbatementSurrogate.abatementAge,
      this@ConditionAbatementSurrogate.abatementPeriod,
      this@ConditionAbatementSurrogate.abatementRange,
      R4bString.of(
        this@ConditionAbatementSurrogate.abatementString,
        this@ConditionAbatementSurrogate._abatementString,
      ),
    )!!

  public companion object {
    public fun fromModel(model: Condition.Abatement): ConditionAbatementSurrogate =
      with(model) {
        ConditionAbatementSurrogate(
          abatementDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _abatementDateTime = this@with.asDateTime()?.value?.toElement(),
          abatementAge = this@with.asAge()?.value,
          abatementPeriod = this@with.asPeriod()?.value,
          abatementRange = this@with.asRange()?.value,
          abatementString = this@with.asString()?.value?.value,
          _abatementString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ConditionSurrogate(
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
  public var clinicalStatus: CodeableConcept? = null,
  public var verificationStatus: CodeableConcept? = null,
  public var category: List<CodeableConcept>? = null,
  public var severity: CodeableConcept? = null,
  public var code: CodeableConcept? = null,
  public var bodySite: List<CodeableConcept>? = null,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var onset: Condition.Onset? = null,
  public var abatement: Condition.Abatement? = null,
  public var recordedDate: KotlinString? = null,
  public var _recordedDate: Element? = null,
  public var recorder: Reference? = null,
  public var asserter: Reference? = null,
  public var stage: List<Condition.Stage>? = null,
  public var evidence: List<Condition.Evidence>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): Condition =
    Condition(
      id = this@ConditionSurrogate.id,
      meta = this@ConditionSurrogate.meta,
      implicitRules =
        Uri.of(this@ConditionSurrogate.implicitRules, this@ConditionSurrogate._implicitRules),
      language = Code.of(this@ConditionSurrogate.language, this@ConditionSurrogate._language),
      text = this@ConditionSurrogate.text,
      contained = this@ConditionSurrogate.contained ?: listOf(),
      extension = this@ConditionSurrogate.extension ?: listOf(),
      modifierExtension = this@ConditionSurrogate.modifierExtension ?: listOf(),
      identifier = this@ConditionSurrogate.identifier ?: listOf(),
      clinicalStatus = this@ConditionSurrogate.clinicalStatus,
      verificationStatus = this@ConditionSurrogate.verificationStatus,
      category = this@ConditionSurrogate.category ?: listOf(),
      severity = this@ConditionSurrogate.severity,
      code = this@ConditionSurrogate.code,
      bodySite = this@ConditionSurrogate.bodySite ?: listOf(),
      subject = this@ConditionSurrogate.subject,
      encounter = this@ConditionSurrogate.encounter,
      onset = this@ConditionSurrogate.onset,
      abatement = this@ConditionSurrogate.abatement,
      recordedDate =
        DateTime.of(
          FhirDateTime.fromString(this@ConditionSurrogate.recordedDate),
          this@ConditionSurrogate._recordedDate,
        ),
      recorder = this@ConditionSurrogate.recorder,
      asserter = this@ConditionSurrogate.asserter,
      stage = this@ConditionSurrogate.stage ?: listOf(),
      evidence = this@ConditionSurrogate.evidence ?: listOf(),
      note = this@ConditionSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Condition): ConditionSurrogate =
      with(model) {
        ConditionSurrogate(
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
          clinicalStatus = this@with.clinicalStatus,
          verificationStatus = this@with.verificationStatus,
          category = this@with.category.takeIf { it.isNotEmpty() },
          severity = this@with.severity,
          code = this@with.code,
          bodySite = this@with.bodySite.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          encounter = this@with.encounter,
          onset = this@with.onset,
          abatement = this@with.abatement,
          recordedDate = this@with.recordedDate?.value?.toString(),
          _recordedDate = this@with.recordedDate?.toElement(),
          recorder = this@with.recorder,
          asserter = this@with.asserter,
          stage = this@with.stage.takeIf { it.isNotEmpty() },
          evidence = this@with.evidence.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
