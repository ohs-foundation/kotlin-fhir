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

import dev.ohs.fhir.model.r5.ActivityDefinition
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Composition
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Measure
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.OperationDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Questionnaire
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Procedure] resource type. */
public object ProcedureSearchParam {
  /** All search parameters for the Procedure resource type. */
  public val ALL: List<SearchParam<Procedure, *>> =
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

  public data object BasedOn : SearchParam<Procedure, Reference> {
    public override val name: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(ServiceRequest::class, CarePlan::class)

    public override fun extract(resource: Procedure): List<Reference> = resource.basedOn
  }

  public data object Category : SearchParam<Procedure, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<CodeableConcept> = resource.category
  }

  public data object Code : SearchParam<Procedure, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Date : SearchParam<Procedure, Any> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Procedure.occurrence.ofType(dateTime)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Encounter : SearchParam<Procedure, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Encounter::class)

    public override fun extract(resource: Procedure): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<Procedure, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<Procedure, Canonical> {
    public override val name: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.instantiatesCanonical"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Measure::class,
        OperationDefinition::class,
        ActivityDefinition::class,
        PlanDefinition::class,
        Questionnaire::class,
      )

    public override fun extract(resource: Procedure): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : SearchParam<Procedure, Uri> {
    public override val name: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Procedure.instantiatesUri"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<Uri> = resource.instantiatesUri
  }

  public data object Location : SearchParam<Procedure, Reference> {
    public override val name: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Location::class)

    public override fun extract(resource: Procedure): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object PartOf : SearchParam<Procedure, Reference> {
    public override val name: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.partOf"

    public override val target: List<KClass<out Resource>> =
      listOf(Procedure::class, Observation::class, MedicationAdministration::class)

    public override fun extract(resource: Procedure): List<Reference> = resource.partOf
  }

  public data object Patient : SearchParam<Procedure, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: Procedure): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<Procedure, Reference> {
    public override val name: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.performer.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        HealthcareService::class,
        Organization::class,
        Device::class,
        CareTeam::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: Procedure): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object ReasonCode : SearchParam<Procedure, CodeableConcept> {
    public override val name: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.reason.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<CodeableConcept> =
      resource.reason.mapNotNull { it.concept }
  }

  public data object ReasonReference : SearchParam<Procedure, Reference> {
    public override val name: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.reason.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Procedure::class,
        DocumentReference::class,
        Observation::class,
        DiagnosticReport::class,
        Condition::class,
      )

    public override fun extract(resource: Procedure): List<Reference> =
      resource.reason.mapNotNull { it.reference }
  }

  public data object Report : SearchParam<Procedure, Reference> {
    public override val name: String = "report"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.report"

    public override val target: List<KClass<out Resource>> =
      listOf(Composition::class, DocumentReference::class, DiagnosticReport::class)

    public override fun extract(resource: Procedure): List<Reference> = resource.report
  }

  public data object Status : SearchParam<Procedure, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<Procedure, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Device::class,
        Organization::class,
        Group::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Location::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: Procedure): List<Reference> = listOf(resource.subject)
  }
}
