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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CareTeam
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DiagnosticReport
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.ImmunizationRecommendation
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.NutritionOrder
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

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
    public override val name: String = "assessed-condition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "DiagnosticReport.extension('http://hl7.org/fhir/StructureDefinition/DiagnosticReport-geneticsAssessedCondition')"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = emptyList()
  }

  public data object BasedOn : SearchParam<DiagnosticReport, Reference> {
    public override val name: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(
        CarePlan::class,
        MedicationRequest::class,
        NutritionOrder::class,
        ServiceRequest::class,
        ImmunizationRecommendation::class,
      )

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.basedOn
  }

  public data object Category : SearchParam<DiagnosticReport, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<CodeableConcept> =
      resource.category
  }

  public data object Code : SearchParam<DiagnosticReport, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<CodeableConcept> =
      listOf(resource.code)
  }

  public data object Conclusion : SearchParam<DiagnosticReport, CodeableConcept> {
    public override val name: String = "conclusion"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.conclusionCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<CodeableConcept> =
      resource.conclusionCode
  }

  public data object Date : SearchParam<DiagnosticReport, DiagnosticReport.Effective> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DiagnosticReport.effective"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<DiagnosticReport.Effective> =
      listOfNotNull(resource.effective)
  }

  public data object Encounter : SearchParam<DiagnosticReport, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Encounter::class)

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<DiagnosticReport, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: DiagnosticReport
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Issued : SearchParam<DiagnosticReport, Instant> {
    public override val name: String = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "DiagnosticReport.issued"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Instant> =
      listOfNotNull(resource.issued)
  }

  public data object Media : SearchParam<DiagnosticReport, Reference> {
    public override val name: String = "media"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.media.link"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Media::class)

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      resource.media.map { it.link }
  }

  public data object Patient : SearchParam<DiagnosticReport, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<DiagnosticReport, Reference> {
    public override val name: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.performer"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, CareTeam::class, PractitionerRole::class)

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.performer
  }

  public data object Result : SearchParam<DiagnosticReport, Reference> {
    public override val name: String = "result"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.result"

    public override val target: List<KClass<out Resource>> = listOf(Observation::class)

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.result
  }

  public data object ResultsInterpreter : SearchParam<DiagnosticReport, Reference> {
    public override val name: String = "results-interpreter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.resultsInterpreter"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, CareTeam::class, PractitionerRole::class)

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      resource.resultsInterpreter
  }

  public data object Specimen : SearchParam<DiagnosticReport, Reference> {
    public override val name: String = "specimen"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.specimen"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Specimen::class)

    public override fun extract(resource: DiagnosticReport): List<Reference> = resource.specimen
  }

  public data object Status : SearchParam<DiagnosticReport, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DiagnosticReport.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DiagnosticReport): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<DiagnosticReport, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DiagnosticReport.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Group::class,
        Organization::class,
        Device::class,
        Medication::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        Procedure::class,
        Substance::class,
        Location::class,
      )

    public override fun extract(resource: DiagnosticReport): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
