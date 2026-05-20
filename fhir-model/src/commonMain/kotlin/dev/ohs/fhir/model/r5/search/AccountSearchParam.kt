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
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Account] resource type. */
public sealed class AccountSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Account): List<T>

  public data object Guarantor : AccountSearchParam<Reference>() {
    public override val paramName: KotlinString = "guarantor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Account.guarantor.party"

    public override val target: List<KotlinString> =
      listOf("Organization", "RelatedPerson", "Patient")

    public override fun extract(resource: Account): List<Reference> =
      resource.guarantor.map { it.party }
  }

  public data object Identifier : AccountSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Account.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : AccountSearchParam<R5String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Account.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<R5String> = listOfNotNull(resource.name)
  }

  public data object Owner : AccountSearchParam<Reference>() {
    public override val paramName: KotlinString = "owner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Account.owner"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Account): List<Reference> = listOfNotNull(resource.owner)
  }

  public data object Patient : AccountSearchParam<Reference>() {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Account.subject.where(resolve() is Patient)"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: Account): List<Reference> =
      resource.subject.filter { it.reference?.value?.toString()?.contains("Patient/") == true }
  }

  public data object Period : AccountSearchParam<dev.ohs.fhir.model.r5.Period>() {
    public override val paramName: KotlinString = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Account.servicePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<dev.ohs.fhir.model.r5.Period> =
      listOfNotNull(resource.servicePeriod)
  }

  public data object Relatedaccount : AccountSearchParam<Reference>() {
    public override val paramName: KotlinString = "relatedaccount"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Account.relatedAccount.account"

    public override val target: List<KotlinString> = listOf("Account")

    public override fun extract(resource: Account): List<Reference> =
      resource.relatedAccount.map { it.account }
  }

  public data object Status : AccountSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Account.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<Any> = listOf(resource.status)
  }

  public data object Subject : AccountSearchParam<Reference>() {
    public override val paramName: KotlinString = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Account.subject"

    public override val target: List<KotlinString> =
      listOf(
        "HealthcareService",
        "Device",
        "Organization",
        "PractitionerRole",
        "Practitioner",
        "Location",
        "Patient",
      )

    public override fun extract(resource: Account): List<Reference> = resource.subject
  }

  public data object Type : AccountSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Account.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Account): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public companion object {
    /** All search parameters for the Account resource type. */
    public val ALL: List<AccountSearchParam<*>> =
      listOf(
        Guarantor,
        Identifier,
        Name,
        Owner,
        Patient,
        Period,
        Relatedaccount,
        Status,
        Subject,
        Type,
      )
  }
}
