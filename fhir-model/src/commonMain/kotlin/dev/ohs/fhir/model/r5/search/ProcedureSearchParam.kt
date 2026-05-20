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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Procedure] resource type. */
public sealed class ProcedureSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Procedure): List<T>

  public data object BasedOn : ProcedureSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.basedOn"

    public override val target: List<String> = listOf("ServiceRequest", "CarePlan")

    public override fun extract(resource: Procedure): List<Reference> = resource.basedOn
  }

  public data object Category : ProcedureSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<CodeableConcept> = resource.category
  }

  public data object Code : ProcedureSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Date : ProcedureSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Procedure.occurrence.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Encounter : ProcedureSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Procedure): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : ProcedureSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : ProcedureSearchParam<Canonical>() {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.instantiatesCanonical"

    public override val target: List<String> =
      listOf(
        "Measure",
        "OperationDefinition",
        "ActivityDefinition",
        "PlanDefinition",
        "Questionnaire",
      )

    public override fun extract(resource: Procedure): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : ProcedureSearchParam<Uri>() {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Procedure.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Uri> = resource.instantiatesUri
  }

  public data object Location : ProcedureSearchParam<Reference>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Procedure): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object PartOf : ProcedureSearchParam<Reference>() {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.partOf"

    public override val target: List<String> =
      listOf("Procedure", "Observation", "MedicationAdministration")

    public override fun extract(resource: Procedure): List<Reference> = resource.partOf
  }

  public data object Patient : ProcedureSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Procedure): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : ProcedureSearchParam<Reference>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.performer.actor"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "Organization",
        "Device",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Procedure): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object ReasonCode : ProcedureSearchParam<CodeableConcept>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.reason.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<CodeableConcept> =
      resource.reason.mapNotNull { it.concept }
  }

  public data object ReasonReference : ProcedureSearchParam<Reference>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.reason.reference"

    public override val target: List<String> =
      listOf("Procedure", "DocumentReference", "Observation", "DiagnosticReport", "Condition")

    public override fun extract(resource: Procedure): List<Reference> =
      resource.reason.mapNotNull { it.reference }
  }

  public data object Report : ProcedureSearchParam<Reference>() {
    public override val paramName: String = "report"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.report"

    public override val target: List<String> =
      listOf("Composition", "DocumentReference", "DiagnosticReport")

    public override fun extract(resource: Procedure): List<Reference> = resource.report
  }

  public data object Status : ProcedureSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = listOf(resource.status)
  }

  public data object Subject : ProcedureSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.subject"

    public override val target: List<String> =
      listOf("Device", "Organization", "Group", "Practitioner", "Location", "Patient")

    public override fun extract(resource: Procedure): List<Reference> = listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the Procedure resource type. */
    public val ALL: List<ProcedureSearchParam<*>> =
      listOf(
        BasedOn,
        Category,
        Code,
        Date,
        Encounter,
        Identifier,
        InstantiatesCanonical,
        InstantiatesUri,
        Location,
        PartOf,
        Patient,
        Performer,
        ReasonCode,
        ReasonReference,
        Report,
        Status,
        Subject,
      )
  }
}
