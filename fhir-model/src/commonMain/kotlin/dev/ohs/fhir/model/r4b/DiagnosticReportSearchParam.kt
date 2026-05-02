/*
 * Copyright 2026 Open Health Stack Foundation
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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DiagnosticReport] resource type. */
public sealed class DiagnosticReportSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DiagnosticReport): List<T>

  public data object AssessedCondition : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "assessed-condition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "DiagnosticReport.extension('http://hl7.org/fhir/StructureDefinition/DiagnosticReport-geneticsAssessedCondition')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object BasedOn : DiagnosticReportSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.basedOn"

    public override val target: List<String> =
      listOf(
        "CarePlan",
        "MedicationRequest",
        "NutritionOrder",
        "ServiceRequest",
        "ImmunizationRecommendation",
      )

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.basedOn
  }

  public data object Category : DiagnosticReportSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<CodeableConcept> =
      resource.category
  }

  public data object Code : DiagnosticReportSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object Conclusion : DiagnosticReportSearchParam<CodeableConcept>() {
    public override val paramName: String = "conclusion"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.conclusionCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<CodeableConcept> =
      resource.conclusionCode
  }

  public data object Date : DiagnosticReportSearchParam<DiagnosticReport.Effective>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DiagnosticReport.effective"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<DiagnosticReport.Effective> =
      listOfNotNull(resource.effective)
  }

  public data object Encounter : DiagnosticReportSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : DiagnosticReportSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: DiagnosticReport
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Issued : DiagnosticReportSearchParam<Instant>() {
    public override val paramName: String = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DiagnosticReport.issued"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Instant> =
      listOfNotNull(resource.issued)
  }

  public data object Media : DiagnosticReportSearchParam<Reference>() {
    public override val paramName: String = "media"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.media.link"

    public override val target: List<String> = listOf("Media")

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      resource.media.map { it.link }
  }

  public data object Patient : DiagnosticReportSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : DiagnosticReportSearchParam<Reference>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.performer"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "CareTeam", "PractitionerRole")

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.performer
  }

  public data object Result : DiagnosticReportSearchParam<Reference>() {
    public override val paramName: String = "result"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.result"

    public override val target: List<String> = listOf("Observation")

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.result
  }

  public data object ResultsInterpreter : DiagnosticReportSearchParam<Reference>() {
    public override val paramName: String = "results-interpreter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.resultsInterpreter"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "CareTeam", "PractitionerRole")

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      resource.resultsInterpreter
  }

  public data object Specimen : DiagnosticReportSearchParam<Reference>() {
    public override val paramName: String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.specimen"

    public override val target: List<String> = listOf("Specimen")

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.specimen
  }

  public data object Status : DiagnosticReportSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = listOf(resource.status)
  }

  public data object Subject : DiagnosticReportSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.subject"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Group",
        "Organization",
        "Device",
        "Medication",
        "Patient",
        "Procedure",
        "Substance",
        "Location",
      )

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public companion object {
    /** All search parameters for the DiagnosticReport resource type. */
    public val ALL: List<DiagnosticReportSearchParam<*>> =
      listOf(
        AssessedCondition,
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
        Subject,
      )
  }
}
