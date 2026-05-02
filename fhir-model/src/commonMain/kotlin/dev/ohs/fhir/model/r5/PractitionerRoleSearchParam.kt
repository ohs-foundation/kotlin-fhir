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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PractitionerRole] resource type. */
public sealed class PractitionerRoleSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: PractitionerRole): List<T>

  public data object Active : PractitionerRoleSearchParam<Boolean>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Characteristic : PractitionerRoleSearchParam<CodeableConcept>() {
    public override val paramName: String = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.characteristic"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<CodeableConcept> =
      resource.characteristic
  }

  public data object Communication : PractitionerRoleSearchParam<CodeableConcept>() {
    public override val paramName: String = "communication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.communication"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<CodeableConcept> =
      resource.communication
  }

  public data object Date : PractitionerRoleSearchParam<Period>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "PractitionerRole.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Email : PractitionerRoleSearchParam<ContactPoint>() {
    public override val paramName: String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "PractitionerRole.contact.telecom.where(system='email')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<ContactPoint> =
      resource.contact.flatMap { it.telecom }.filter { it.system?.value?.toString() == "email" }
  }

  public data object Endpoint : PractitionerRoleSearchParam<Reference>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: PractitionerRole): List<Reference> = resource.endpoint
  }

  public data object Identifier : PractitionerRoleSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: PractitionerRole
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Location : PractitionerRoleSearchParam<Reference>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: PractitionerRole): List<Reference> = resource.location
  }

  public data object Organization : PractitionerRoleSearchParam<Reference>() {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.organization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: PractitionerRole): List<Reference> =
      listOfNotNull(resource.organization)
  }

  public data object Phone : PractitionerRoleSearchParam<ContactPoint>() {
    public override val paramName: String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "PractitionerRole.contact.telecom.where(system='phone')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<ContactPoint> =
      resource.contact.flatMap { it.telecom }.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Practitioner : PractitionerRoleSearchParam<Reference>() {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.practitioner"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: PractitionerRole): List<Reference> =
      listOfNotNull(resource.practitioner)
  }

  public data object Role : PractitionerRoleSearchParam<CodeableConcept>() {
    public override val paramName: String = "role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<CodeableConcept> = resource.code
  }

  public data object Service : PractitionerRoleSearchParam<Reference>() {
    public override val paramName: String = "service"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PractitionerRole.healthcareService"

    public override val target: List<String> = listOf("HealthcareService")

    public override fun extract(resource: PractitionerRole): List<Reference> =
      resource.healthcareService
  }

  public data object Specialty : PractitionerRoleSearchParam<CodeableConcept>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<CodeableConcept> =
      resource.specialty
  }

  public data object Telecom : PractitionerRoleSearchParam<ContactPoint>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PractitionerRole.contact.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PractitionerRole): List<ContactPoint> =
      resource.contact.flatMap { it.telecom }
  }

  public companion object {
    /** All search parameters for the PractitionerRole resource type. */
    public val ALL: List<PractitionerRoleSearchParam<*>> =
      listOf(
        Active,
        Characteristic,
        Communication,
        Date,
        Email,
        Endpoint,
        Identifier,
        Location,
        Organization,
        Phone,
        Practitioner,
        Role,
        Service,
        Specialty,
        Telecom,
      )
  }
}
