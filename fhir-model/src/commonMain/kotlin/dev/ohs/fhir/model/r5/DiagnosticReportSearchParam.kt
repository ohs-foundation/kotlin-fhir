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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DiagnosticReport] resource type. */
public sealed class DiagnosticReportSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DiagnosticReport): List<T>

  public data object BasedOn : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.basedOn"

    public override val target: List<String> =
      listOf(
        "ServiceRequest",
        "CarePlan",
        "MedicationRequest",
        "ImmunizationRecommendation",
        "NutritionOrder",
      )

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Category : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Code : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Conclusion : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "conclusion"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.conclusionCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Date : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DiagnosticReport.effective.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Encounter : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Identifier : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Issued : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DiagnosticReport.issued"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Media : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "media"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.media.link"

    public override val target: List<String> = listOf("DocumentReference")

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Patient : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Performer : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.performer"

    public override val target: List<String> =
      listOf("Organization", "CareTeam", "PractitionerRole", "Practitioner")

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Result : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "result"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.result"

    public override val target: List<String> = listOf("Observation")

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object ResultsInterpreter : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "results-interpreter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.resultsInterpreter"

    public override val target: List<String> =
      listOf("Organization", "CareTeam", "PractitionerRole", "Practitioner")

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Specimen : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.specimen"

    public override val target: List<String> = listOf("Specimen")

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Status : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Study : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "study"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.study"

    public override val target: List<String> = listOf("ImagingStudy", "GenomicStudy")

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object Subject : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.subject"

    public override val target: List<String> =
      listOf(
        "Device",
        "Organization",
        "Group",
        "Practitioner",
        "BiologicallyDerivedProduct",
        "Substance",
        "Location",
        "Patient",
        "Medication",
      )

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the DiagnosticReport resource type. */
    public val ALL: List<DiagnosticReportSearchParam<*>> =
      listOf(
        BasedOn,
        Category,
        Code,
        Conclusion,
        Date,
        Encounter,
        Identifier,
        Issued,
        Media,
        Patient,
        Performer,
        Result,
        ResultsInterpreter,
        Specimen,
        Status,
        Study,
        Subject,
      )
  }
}
