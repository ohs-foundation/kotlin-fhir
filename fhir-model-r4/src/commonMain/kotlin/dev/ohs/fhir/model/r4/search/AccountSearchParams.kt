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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Account
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
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
  public val identifier: SearchParam<Account, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Account.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<Account, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "Account.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val owner: SearchParam<Account, Reference> =
    SearchParam(
      name = "owner",
      type = SearchParamType.Reference,
      expression = "Account.owner",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.owner) },
    )

  public val patient: SearchParam<Account, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Account.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        resource.subject.filter { it.reference?.value?.toString()?.contains("Patient/") == true }
      },
    )

  public val period: SearchParam<Account, Period> =
    SearchParam(
      name = "period",
      type = SearchParamType.Date,
      expression = "Account.servicePeriod",
      extractor = { resource -> listOfNotNull(resource.servicePeriod) },
    )

  public val status: SearchParam<Account, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Account.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Account, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
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
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "Account.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Account, *>> = listOf()

  /**
   * Supported search parameters for the Account resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Account, *>> =
    listOf(identifier, name, owner, patient, period, status, subject, type)
}
