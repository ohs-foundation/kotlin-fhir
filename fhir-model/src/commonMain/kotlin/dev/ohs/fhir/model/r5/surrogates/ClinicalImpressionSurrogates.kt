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

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.ClinicalImpression
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
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
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ClinicalImpressionFindingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: CodeableReference? = null,
  public var basis: KotlinString? = null,
  public var _basis: Element? = null,
) {
  public fun toModel(): ClinicalImpression.Finding =
    ClinicalImpression.Finding(
      id = this@ClinicalImpressionFindingSurrogate.id,
      extension = this@ClinicalImpressionFindingSurrogate.extension ?: listOf(),
      modifierExtension = this@ClinicalImpressionFindingSurrogate.modifierExtension ?: listOf(),
      item = this@ClinicalImpressionFindingSurrogate.item,
      basis =
        R5String.of(
          this@ClinicalImpressionFindingSurrogate.basis,
          this@ClinicalImpressionFindingSurrogate._basis,
        ),
    )

  public companion object {
    public fun fromModel(model: ClinicalImpression.Finding): ClinicalImpressionFindingSurrogate =
      with(model) {
        ClinicalImpressionFindingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
          basis = this@with.basis?.value,
          _basis = this@with.basis?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ClinicalImpressionEffectiveSurrogate(
  public var effectiveDateTime: KotlinString? = null,
  public var _effectiveDateTime: Element? = null,
  public var effectivePeriod: Period? = null,
) {
  public fun toModel(): ClinicalImpression.Effective =
    ClinicalImpression.Effective.from(
      DateTime.of(
        FhirDateTime.fromString(this@ClinicalImpressionEffectiveSurrogate.effectiveDateTime),
        this@ClinicalImpressionEffectiveSurrogate._effectiveDateTime,
      ),
      this@ClinicalImpressionEffectiveSurrogate.effectivePeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: ClinicalImpression.Effective
    ): ClinicalImpressionEffectiveSurrogate =
      with(model) {
        ClinicalImpressionEffectiveSurrogate(
          effectiveDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _effectiveDateTime = this@with.asDateTime()?.value?.toElement(),
          effectivePeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class ClinicalImpressionSurrogate(
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
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var effective: ClinicalImpression.Effective? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var performer: Reference? = null,
  public var previous: Reference? = null,
  public var problem: List<Reference>? = null,
  public var changePattern: CodeableConcept? = null,
  public var protocol: List<KotlinString?>? = null,
  public var _protocol: List<Element?>? = null,
  public var summary: KotlinString? = null,
  public var _summary: Element? = null,
  public var finding: List<ClinicalImpression.Finding>? = null,
  public var prognosisCodeableConcept: List<CodeableConcept>? = null,
  public var prognosisReference: List<Reference>? = null,
  public var supportingInfo: List<Reference>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): ClinicalImpression =
    ClinicalImpression(
      id = this@ClinicalImpressionSurrogate.id,
      meta = this@ClinicalImpressionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ClinicalImpressionSurrogate.implicitRules,
          this@ClinicalImpressionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@ClinicalImpressionSurrogate.language,
          this@ClinicalImpressionSurrogate._language,
        ),
      text = this@ClinicalImpressionSurrogate.text,
      contained = this@ClinicalImpressionSurrogate.contained ?: listOf(),
      extension = this@ClinicalImpressionSurrogate.extension ?: listOf(),
      modifierExtension = this@ClinicalImpressionSurrogate.modifierExtension ?: listOf(),
      identifier = this@ClinicalImpressionSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          ClinicalImpression.EventStatus.fromCode(this@ClinicalImpressionSurrogate.status!!),
          this@ClinicalImpressionSurrogate._status,
        ),
      statusReason = this@ClinicalImpressionSurrogate.statusReason,
      description =
        R5String.of(
          this@ClinicalImpressionSurrogate.description,
          this@ClinicalImpressionSurrogate._description,
        ),
      subject = this@ClinicalImpressionSurrogate.subject,
      encounter = this@ClinicalImpressionSurrogate.encounter,
      effective = this@ClinicalImpressionSurrogate.effective,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ClinicalImpressionSurrogate.date),
          this@ClinicalImpressionSurrogate._date,
        ),
      performer = this@ClinicalImpressionSurrogate.performer,
      previous = this@ClinicalImpressionSurrogate.previous,
      problem = this@ClinicalImpressionSurrogate.problem ?: listOf(),
      changePattern = this@ClinicalImpressionSurrogate.changePattern,
      protocol =
        if (
          this@ClinicalImpressionSurrogate.protocol == null &&
            this@ClinicalImpressionSurrogate._protocol == null
        ) {
          listOf()
        } else {
          (this@ClinicalImpressionSurrogate.protocol
              ?: List(this@ClinicalImpressionSurrogate._protocol!!.size) { null })
            .zip(
              this@ClinicalImpressionSurrogate._protocol
                ?: List(this@ClinicalImpressionSurrogate.protocol!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      summary =
        R5String.of(
          this@ClinicalImpressionSurrogate.summary,
          this@ClinicalImpressionSurrogate._summary,
        ),
      finding = this@ClinicalImpressionSurrogate.finding ?: listOf(),
      prognosisCodeableConcept =
        this@ClinicalImpressionSurrogate.prognosisCodeableConcept ?: listOf(),
      prognosisReference = this@ClinicalImpressionSurrogate.prognosisReference ?: listOf(),
      supportingInfo = this@ClinicalImpressionSurrogate.supportingInfo ?: listOf(),
      note = this@ClinicalImpressionSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ClinicalImpression): ClinicalImpressionSurrogate =
      with(model) {
        ClinicalImpressionSurrogate(
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
          statusReason = this@with.statusReason,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          subject = this@with.subject,
          encounter = this@with.encounter,
          effective = this@with.effective,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          performer = this@with.performer,
          previous = this@with.previous,
          problem = this@with.problem.takeIf { it.isNotEmpty() },
          changePattern = this@with.changePattern,
          protocol =
            this@with.protocol.map { it.value }.toList().takeUnless { it.all { it == null } },
          _protocol =
            this@with.protocol
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          summary = this@with.summary?.value,
          _summary = this@with.summary?.toElement(),
          finding = this@with.finding.takeIf { it.isNotEmpty() },
          prognosisCodeableConcept = this@with.prognosisCodeableConcept.takeIf { it.isNotEmpty() },
          prognosisReference = this@with.prognosisReference.takeIf { it.isNotEmpty() },
          supportingInfo = this@with.supportingInfo.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
