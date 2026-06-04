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

import dev.ohs.fhir.model.r4b.Account
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Account] resource type. */
public object AccountSearchParams {
  public val identifier: SearchParam<Account, Identifier> =
    SearchParam<Account, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Account.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<Account, String> =
    SearchParam<Account, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Account.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val owner: SearchParam<Account, Reference> =
    SearchParam<Account, Reference>(
      name = "owner",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.owner",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.owner) },
    )

  public val patient: SearchParam<Account, Reference> =
    SearchParam<Account, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        resource.subject.filter { it.reference?.value?.toString()?.contains("Patient/") == true }
      },
    )

  public val period: SearchParam<Account, Period> =
    SearchParam<Account, Period>(
      name = "period",
      type = SearchParamType.fromCode("date"),
      expression = "Account.servicePeriod",
      extractor = { resource -> listOfNotNull(resource.servicePeriod) },
    )

  public val status: SearchParam<Account, Any> =
    SearchParam<Account, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Account.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Account, Reference> =
    SearchParam<Account, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.subject",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          Patient::class,
          HealthcareService::class,
          PractitionerRole::class,
          Location::class,
        ),
      extractor = { resource -> resource.subject },
    )

  public val type: SearchParam<Account, CodeableConcept> =
    SearchParam<Account, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Account.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /** All search parameters for the Account resource type. */
  public val all: List<SearchParam<Account, *>> =
    listOf(identifier, name, owner, patient, period, status, subject, type)
}
