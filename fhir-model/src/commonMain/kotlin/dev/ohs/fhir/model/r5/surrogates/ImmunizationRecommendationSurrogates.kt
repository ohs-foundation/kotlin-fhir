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

import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.ImmunizationRecommendation
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
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
internal data class ImmunizationRecommendationRecommendationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var vaccineCode: List<CodeableConcept>? = null,
  public var targetDisease: List<CodeableConcept>? = null,
  public var contraindicatedVaccineCode: List<CodeableConcept>? = null,
  public var forecastStatus: CodeableConcept,
  public var forecastReason: List<CodeableConcept>? = null,
  public var dateCriterion: List<ImmunizationRecommendation.Recommendation.DateCriterion>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var series: KotlinString? = null,
  public var _series: Element? = null,
  public var doseNumber: KotlinString? = null,
  public var _doseNumber: Element? = null,
  public var seriesDoses: KotlinString? = null,
  public var _seriesDoses: Element? = null,
  public var supportingImmunization: List<Reference>? = null,
  public var supportingPatientInformation: List<Reference>? = null,
) {
  public fun toModel(): ImmunizationRecommendation.Recommendation =
    ImmunizationRecommendation.Recommendation(
      id = this@ImmunizationRecommendationRecommendationSurrogate.id,
      extension = this@ImmunizationRecommendationRecommendationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ImmunizationRecommendationRecommendationSurrogate.modifierExtension ?: listOf(),
      vaccineCode = this@ImmunizationRecommendationRecommendationSurrogate.vaccineCode ?: listOf(),
      targetDisease =
        this@ImmunizationRecommendationRecommendationSurrogate.targetDisease ?: listOf(),
      contraindicatedVaccineCode =
        this@ImmunizationRecommendationRecommendationSurrogate.contraindicatedVaccineCode
          ?: listOf(),
      forecastStatus = this@ImmunizationRecommendationRecommendationSurrogate.forecastStatus,
      forecastReason =
        this@ImmunizationRecommendationRecommendationSurrogate.forecastReason ?: listOf(),
      dateCriterion =
        this@ImmunizationRecommendationRecommendationSurrogate.dateCriterion ?: listOf(),
      description =
        Markdown.of(
          this@ImmunizationRecommendationRecommendationSurrogate.description,
          this@ImmunizationRecommendationRecommendationSurrogate._description,
        ),
      series =
        R5String.of(
          this@ImmunizationRecommendationRecommendationSurrogate.series,
          this@ImmunizationRecommendationRecommendationSurrogate._series,
        ),
      doseNumber =
        R5String.of(
          this@ImmunizationRecommendationRecommendationSurrogate.doseNumber,
          this@ImmunizationRecommendationRecommendationSurrogate._doseNumber,
        ),
      seriesDoses =
        R5String.of(
          this@ImmunizationRecommendationRecommendationSurrogate.seriesDoses,
          this@ImmunizationRecommendationRecommendationSurrogate._seriesDoses,
        ),
      supportingImmunization =
        this@ImmunizationRecommendationRecommendationSurrogate.supportingImmunization ?: listOf(),
      supportingPatientInformation =
        this@ImmunizationRecommendationRecommendationSurrogate.supportingPatientInformation
          ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ImmunizationRecommendation.Recommendation
    ): ImmunizationRecommendationRecommendationSurrogate =
      with(model) {
        ImmunizationRecommendationRecommendationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          vaccineCode = this@with.vaccineCode.takeIf { it.isNotEmpty() },
          targetDisease = this@with.targetDisease.takeIf { it.isNotEmpty() },
          contraindicatedVaccineCode =
            this@with.contraindicatedVaccineCode.takeIf { it.isNotEmpty() },
          forecastStatus = this@with.forecastStatus,
          forecastReason = this@with.forecastReason.takeIf { it.isNotEmpty() },
          dateCriterion = this@with.dateCriterion.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          series = this@with.series?.value,
          _series = this@with.series?.toElement(),
          doseNumber = this@with.doseNumber?.value,
          _doseNumber = this@with.doseNumber?.toElement(),
          seriesDoses = this@with.seriesDoses?.value,
          _seriesDoses = this@with.seriesDoses?.toElement(),
          supportingImmunization = this@with.supportingImmunization.takeIf { it.isNotEmpty() },
          supportingPatientInformation =
            this@with.supportingPatientInformation.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ImmunizationRecommendationRecommendationDateCriterionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): ImmunizationRecommendation.Recommendation.DateCriterion =
    ImmunizationRecommendation.Recommendation.DateCriterion(
      id = this@ImmunizationRecommendationRecommendationDateCriterionSurrogate.id,
      extension =
        this@ImmunizationRecommendationRecommendationDateCriterionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ImmunizationRecommendationRecommendationDateCriterionSurrogate.modifierExtension
          ?: listOf(),
      code = this@ImmunizationRecommendationRecommendationDateCriterionSurrogate.code,
      `value` =
        DateTime.of(
          FhirDateTime.fromString(
            this@ImmunizationRecommendationRecommendationDateCriterionSurrogate.`value`
          ),
          this@ImmunizationRecommendationRecommendationDateCriterionSurrogate._value,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: ImmunizationRecommendation.Recommendation.DateCriterion
    ): ImmunizationRecommendationRecommendationDateCriterionSurrogate =
      with(model) {
        ImmunizationRecommendationRecommendationDateCriterionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          `value` = this@with.`value`.value?.toString(),
          _value = this@with.`value`.toElement(),
        )
      }
  }
}

@Serializable
internal data class ImmunizationRecommendationSurrogate(
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
  public var patient: Reference,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var authority: Reference? = null,
  public var recommendation: List<ImmunizationRecommendation.Recommendation>? = null,
) {
  public fun toModel(): ImmunizationRecommendation =
    ImmunizationRecommendation(
      id = this@ImmunizationRecommendationSurrogate.id,
      meta = this@ImmunizationRecommendationSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ImmunizationRecommendationSurrogate.implicitRules,
          this@ImmunizationRecommendationSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@ImmunizationRecommendationSurrogate.language,
          this@ImmunizationRecommendationSurrogate._language,
        ),
      text = this@ImmunizationRecommendationSurrogate.text,
      contained = this@ImmunizationRecommendationSurrogate.contained ?: listOf(),
      extension = this@ImmunizationRecommendationSurrogate.extension ?: listOf(),
      modifierExtension = this@ImmunizationRecommendationSurrogate.modifierExtension ?: listOf(),
      identifier = this@ImmunizationRecommendationSurrogate.identifier ?: listOf(),
      patient = this@ImmunizationRecommendationSurrogate.patient,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ImmunizationRecommendationSurrogate.date),
          this@ImmunizationRecommendationSurrogate._date,
        )!!,
      authority = this@ImmunizationRecommendationSurrogate.authority,
      recommendation = this@ImmunizationRecommendationSurrogate.recommendation ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ImmunizationRecommendation): ImmunizationRecommendationSurrogate =
      with(model) {
        ImmunizationRecommendationSurrogate(
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
          patient = this@with.patient,
          date = this@with.date.value?.toString(),
          _date = this@with.date.toElement(),
          authority = this@with.authority,
          recommendation = this@with.recommendation.takeIf { it.isNotEmpty() },
        )
      }
  }
}
