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

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DiagnosticReport
import dev.ohs.fhir.model.r4b.DocumentReference
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Measure
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.OperationDefinition
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Questionnaire
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
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
      Status,
      Subject,
    )

  public data object BasedOn : SearchParam<Procedure, Reference> {
    public override val name: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(CarePlan::class, ServiceRequest::class)

    public override fun extract(resource: Procedure): List<Reference> = resource.basedOn
  }

  public data object Category : SearchParam<Procedure, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<CodeableConcept> =
      listOfNotNull(resource.category)
  }

  public data object Code : SearchParam<Procedure, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Date : SearchParam<Procedure, Procedure.Performed> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Procedure.performed"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<Procedure.Performed> =
      listOfNotNull(resource.performed)
  }

  public data object Encounter : SearchParam<Procedure, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Encounter::class)

    public override fun extract(resource: Procedure): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<Procedure, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<Procedure, Canonical> {
    public override val name: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.instantiatesCanonical"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Questionnaire::class,
        Measure::class,
        PlanDefinition::class,
        OperationDefinition::class,
        ActivityDefinition::class,
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
      listOf(dev.ohs.fhir.model.r4b.Location::class)

    public override fun extract(resource: Procedure): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object PartOf : SearchParam<Procedure, Reference> {
    public override val name: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.partOf"

    public override val target: List<KClass<out Resource>> =
      listOf(Observation::class, Procedure::class, MedicationAdministration::class)

    public override fun extract(resource: Procedure): List<Reference> = resource.partOf
  }

  public data object Patient : SearchParam<Procedure, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

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
        Practitioner::class,
        Organization::class,
        Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: Procedure): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object ReasonCode : SearchParam<Procedure, CodeableConcept> {
    public override val name: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.reasonCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Procedure): List<CodeableConcept> = resource.reasonCode
  }

  public data object ReasonReference : SearchParam<Procedure, Reference> {
    public override val name: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.reasonReference"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Condition::class,
        Observation::class,
        Procedure::class,
        DiagnosticReport::class,
        DocumentReference::class,
      )

    public override fun extract(resource: Procedure): List<Reference> = resource.reasonReference
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
      listOf(Group::class, dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: Procedure): List<Reference> = listOf(resource.subject)
  }
}
