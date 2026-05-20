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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DiagnosticReport
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DiagnosticReport] resource type. */
public object DiagnosticReportSearchParam {
  /** All search parameters for the DiagnosticReport resource type. */
  public val ALL: List<SearchParam<DiagnosticReport, *>> =
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

  public data object AssessedCondition : SearchParam<DiagnosticReport, Any> {
    public override val paramName: String = "assessed-condition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "DiagnosticReport.extension('http://hl7.org/fhir/StructureDefinition/DiagnosticReport-geneticsAssessedCondition')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object BasedOn : SearchParam<DiagnosticReport, Reference> {
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

  public data object Category : SearchParam<DiagnosticReport, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<CodeableConcept> =
      resource.category
  }

  public data object Code : SearchParam<DiagnosticReport, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object Conclusion : SearchParam<DiagnosticReport, CodeableConcept> {
    public override val paramName: String = "conclusion"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.conclusionCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<CodeableConcept> =
      resource.conclusionCode
  }

  public data object Date : SearchParam<DiagnosticReport, DiagnosticReport.Effective> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DiagnosticReport.effective"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<DiagnosticReport.Effective> =
      listOfNotNull(resource.effective)
  }

  public data object Encounter : SearchParam<DiagnosticReport, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.encounter"

    public override val target: List<String> = listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<DiagnosticReport, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: DiagnosticReport
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Issued : SearchParam<DiagnosticReport, Instant> {
    public override val paramName: String = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DiagnosticReport.issued"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Instant> =
      listOfNotNull(resource.issued)
  }

  public data object Media : SearchParam<DiagnosticReport, Reference> {
    public override val paramName: String = "media"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.media.link"

    public override val target: List<String> = listOf("Media")

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      resource.media.map { it.link }
  }

  public data object Patient : SearchParam<DiagnosticReport, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<DiagnosticReport, Reference> {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.performer"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "CareTeam", "PractitionerRole")

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.performer
  }

  public data object Result : SearchParam<DiagnosticReport, Reference> {
    public override val paramName: String = "result"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.result"

    public override val target: List<String> = listOf("Observation")

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.result
  }

  public data object ResultsInterpreter : SearchParam<DiagnosticReport, Reference> {
    public override val paramName: String = "results-interpreter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.resultsInterpreter"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "CareTeam", "PractitionerRole")

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      resource.resultsInterpreter
  }

  public data object Specimen : SearchParam<DiagnosticReport, Reference> {
    public override val paramName: String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.specimen"

    public override val target: List<String> = listOf("Specimen")

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.specimen
  }

  public data object Status : SearchParam<DiagnosticReport, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<DiagnosticReport, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.subject"

    public override val target: List<String> = listOf("Group", "Device", "Patient", "Location")

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
