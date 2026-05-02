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

import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.ImmunizationEvaluation
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.PositiveInt
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ImmunizationEvaluationDoseNumberSurrogate(
  public var doseNumberPositiveInt: Int? = null,
  public var _doseNumberPositiveInt: Element? = null,
  public var doseNumberString: KotlinString? = null,
  public var _doseNumberString: Element? = null,
) {
  public fun toModel(): ImmunizationEvaluation.DoseNumber =
    ImmunizationEvaluation.DoseNumber.from(
      PositiveInt.of(
        this@ImmunizationEvaluationDoseNumberSurrogate.doseNumberPositiveInt,
        this@ImmunizationEvaluationDoseNumberSurrogate._doseNumberPositiveInt,
      ),
      R4String.of(
        this@ImmunizationEvaluationDoseNumberSurrogate.doseNumberString,
        this@ImmunizationEvaluationDoseNumberSurrogate._doseNumberString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: ImmunizationEvaluation.DoseNumber
    ): ImmunizationEvaluationDoseNumberSurrogate =
      with(model) {
        ImmunizationEvaluationDoseNumberSurrogate(
          doseNumberPositiveInt = this@with.asPositiveInt()?.value?.value,
          _doseNumberPositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          doseNumberString = this@with.asString()?.value?.value,
          _doseNumberString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ImmunizationEvaluationSeriesDosesSurrogate(
  public var seriesDosesPositiveInt: Int? = null,
  public var _seriesDosesPositiveInt: Element? = null,
  public var seriesDosesString: KotlinString? = null,
  public var _seriesDosesString: Element? = null,
) {
  public fun toModel(): ImmunizationEvaluation.SeriesDoses =
    ImmunizationEvaluation.SeriesDoses.from(
      PositiveInt.of(
        this@ImmunizationEvaluationSeriesDosesSurrogate.seriesDosesPositiveInt,
        this@ImmunizationEvaluationSeriesDosesSurrogate._seriesDosesPositiveInt,
      ),
      R4String.of(
        this@ImmunizationEvaluationSeriesDosesSurrogate.seriesDosesString,
        this@ImmunizationEvaluationSeriesDosesSurrogate._seriesDosesString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: ImmunizationEvaluation.SeriesDoses
    ): ImmunizationEvaluationSeriesDosesSurrogate =
      with(model) {
        ImmunizationEvaluationSeriesDosesSurrogate(
          seriesDosesPositiveInt = this@with.asPositiveInt()?.value?.value,
          _seriesDosesPositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          seriesDosesString = this@with.asString()?.value?.value,
          _seriesDosesString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ImmunizationEvaluationSurrogate(
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
  public var patient: Reference,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var authority: Reference? = null,
  public var targetDisease: CodeableConcept,
  public var immunizationEvent: Reference,
  public var doseStatus: CodeableConcept,
  public var doseStatusReason: List<CodeableConcept>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var series: KotlinString? = null,
  public var _series: Element? = null,
  public var doseNumber: ImmunizationEvaluation.DoseNumber? = null,
  public var seriesDoses: ImmunizationEvaluation.SeriesDoses? = null,
) {
  public fun toModel(): ImmunizationEvaluation =
    ImmunizationEvaluation(
      id = this@ImmunizationEvaluationSurrogate.id,
      meta = this@ImmunizationEvaluationSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ImmunizationEvaluationSurrogate.implicitRules,
          this@ImmunizationEvaluationSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@ImmunizationEvaluationSurrogate.language,
          this@ImmunizationEvaluationSurrogate._language,
        ),
      text = this@ImmunizationEvaluationSurrogate.text,
      contained = this@ImmunizationEvaluationSurrogate.contained ?: listOf(),
      extension = this@ImmunizationEvaluationSurrogate.extension ?: listOf(),
      modifierExtension = this@ImmunizationEvaluationSurrogate.modifierExtension ?: listOf(),
      identifier = this@ImmunizationEvaluationSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          ImmunizationEvaluation.ImmunizationEvaluationStatusCodes.fromCode(
            this@ImmunizationEvaluationSurrogate.status!!
          ),
          this@ImmunizationEvaluationSurrogate._status,
        ),
      patient = this@ImmunizationEvaluationSurrogate.patient,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ImmunizationEvaluationSurrogate.date),
          this@ImmunizationEvaluationSurrogate._date,
        ),
      authority = this@ImmunizationEvaluationSurrogate.authority,
      targetDisease = this@ImmunizationEvaluationSurrogate.targetDisease,
      immunizationEvent = this@ImmunizationEvaluationSurrogate.immunizationEvent,
      doseStatus = this@ImmunizationEvaluationSurrogate.doseStatus,
      doseStatusReason = this@ImmunizationEvaluationSurrogate.doseStatusReason ?: listOf(),
      description =
        R4String.of(
          this@ImmunizationEvaluationSurrogate.description,
          this@ImmunizationEvaluationSurrogate._description,
        ),
      series =
        R4String.of(
          this@ImmunizationEvaluationSurrogate.series,
          this@ImmunizationEvaluationSurrogate._series,
        ),
      doseNumber = this@ImmunizationEvaluationSurrogate.doseNumber,
      seriesDoses = this@ImmunizationEvaluationSurrogate.seriesDoses,
    )

  public companion object {
    public fun fromModel(model: ImmunizationEvaluation): ImmunizationEvaluationSurrogate =
      with(model) {
        ImmunizationEvaluationSurrogate(
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
          patient = this@with.patient,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          authority = this@with.authority,
          targetDisease = this@with.targetDisease,
          immunizationEvent = this@with.immunizationEvent,
          doseStatus = this@with.doseStatus,
          doseStatusReason = this@with.doseStatusReason.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          series = this@with.series?.value,
          _series = this@with.series?.toElement(),
          doseNumber = this@with.doseNumber,
          seriesDoses = this@with.seriesDoses,
        )
      }
  }
}
