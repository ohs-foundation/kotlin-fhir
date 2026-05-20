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
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Account] resource type. */
public object AccountSearchParam {
  /** All search parameters for the Account resource type. */
  public val ALL: List<SearchParam<Account, *>> =
    listOf(Identifier, Name, Owner, Patient, Period, Status, Subject, Type)

  public data object Identifier : SearchParam<Account, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Account.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<Account, R4String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Account.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<R4String> = listOfNotNull(resource.name)
  }

  public data object Owner : SearchParam<Account, Reference> {
    public override val paramName: KotlinString = "owner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Account.owner"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Account): List<Reference> = listOfNotNull(resource.owner)
  }

  public data object Patient : SearchParam<Account, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Account.subject.where(resolve() is Patient)"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: Account): List<Reference> =
      resource.subject.filter { it.reference?.value?.toString()?.contains("Patient/") == true }
  }

  public data object Period : SearchParam<Account, dev.ohs.fhir.model.r4.Period> {
    public override val paramName: KotlinString = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Account.servicePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<dev.ohs.fhir.model.r4.Period> =
      listOfNotNull(resource.servicePeriod)
  }

  public data object Status : SearchParam<Account, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Account.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<Account, Reference> {
    public override val paramName: KotlinString = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Account.subject"

    public override val target: List<KotlinString> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "HealthcareService",
        "PractitionerRole",
        "Location",
      )

    public override fun extract(resource: Account): List<Reference> = resource.subject
  }

  public data object Type : SearchParam<Account, CodeableConcept> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Account.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }
}
