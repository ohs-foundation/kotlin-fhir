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

import dev.ohs.fhir.model.r4.Account
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Account] resource type. */
public object AccountSearchParams {
  public val Identifier: SearchParam<Account, Identifier> =
    SimpleSearchParam<Account, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Account.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<Account, String> =
    SimpleSearchParam<Account, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Account.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Owner: SearchParam<Account, Reference> =
    SimpleSearchParam<Account, Reference>(
      name = "owner",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.owner",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.owner) },
    )

  public val Patient: SearchParam<Account, Reference> =
    SimpleSearchParam<Account, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource ->
        resource.subject.filter { it.reference?.value?.toString()?.contains("Patient/") == true }
      },
    )

  public val Period: SearchParam<Account, Period> =
    SimpleSearchParam<Account, Period>(
      name = "period",
      type = SearchParamType.fromCode("date"),
      expression = "Account.servicePeriod",
      extractor = { resource -> listOfNotNull(resource.servicePeriod) },
    )

  public val Status: SearchParam<Account, Any> =
    SimpleSearchParam<Account, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Account.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<Account, Reference> =
    SimpleSearchParam<Account, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.subject",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
          HealthcareService::class,
          PractitionerRole::class,
          Location::class,
        ),
      extractor = { resource -> resource.subject },
    )

  public val Type: SearchParam<Account, CodeableConcept> =
    SimpleSearchParam<Account, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Account.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /** All search parameters for the Account resource type. */
  public val ALL: List<SearchParam<Account, *>> =
    listOf(Identifier, Name, Owner, Patient, Period, Status, Subject, Type)
}
