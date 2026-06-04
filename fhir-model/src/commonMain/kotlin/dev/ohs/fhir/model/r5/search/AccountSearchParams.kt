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

import dev.ohs.fhir.model.r5.Account
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Account] resource type. */
public object AccountSearchParams {
  public val guarantor: SearchParam<Account, Reference> =
    SearchParam(
      name = "guarantor",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.guarantor.party",
      target = listOf(Organization::class, RelatedPerson::class, Patient::class),
      extractor = { resource -> resource.guarantor.map { it.party } },
    )

  public val identifier: SearchParam<Account, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Account.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<Account, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Account.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val owner: SearchParam<Account, Reference> =
    SearchParam(
      name = "owner",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.owner",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.owner) },
    )

  public val patient: SearchParam<Account, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        resource.subject.filter { it.reference?.value?.toString()?.contains("Patient/") == true }
      },
    )

  public val period: SearchParam<Account, Period> =
    SearchParam(
      name = "period",
      type = SearchParamType.fromCode("date"),
      expression = "Account.servicePeriod",
      extractor = { resource -> listOfNotNull(resource.servicePeriod) },
    )

  public val relatedaccount: SearchParam<Account, Reference> =
    SearchParam(
      name = "relatedaccount",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.relatedAccount.account",
      target = listOf(Account::class),
      extractor = { resource -> resource.relatedAccount.map { it.account } },
    )

  public val status: SearchParam<Account, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Account.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Account, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Account.subject",
      target =
        listOf(
          HealthcareService::class,
          Device::class,
          Organization::class,
          PractitionerRole::class,
          Practitioner::class,
          Location::class,
          Patient::class,
        ),
      extractor = { resource -> resource.subject },
    )

  public val type: SearchParam<Account, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Account.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /** All search parameters for the Account resource type. */
  public val all: List<SearchParam<Account, *>> =
    listOf(
      guarantor,
      identifier,
      name,
      owner,
      patient,
      period,
      relatedaccount,
      status,
      subject,
      type,
    )
}
