/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Account] resource type. */
public sealed class AccountSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Account): List<T>

  public data object Identifier : AccountSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Account.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Account): List<Any> = emptyList()
  }

  public data object Name : AccountSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Account.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Account): List<Any> = emptyList()
  }

  public data object Owner : AccountSearchParam<Any>() {
    public override val paramName: String = "owner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Account.owner"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Account): List<Any> = emptyList()
  }

  public data object Patient : AccountSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Account.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Account): List<Any> = emptyList()
  }

  public data object Period : AccountSearchParam<Any>() {
    public override val paramName: String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Account.servicePeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Account): List<Any> = emptyList()
  }

  public data object Status : AccountSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Account.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Account): List<Any> = emptyList()
  }

  public data object Subject : AccountSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Account.subject"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "HealthcareService",
        "PractitionerRole",
        "Location",
      )

    public override fun extract(resource: Account): List<Any> = emptyList()
  }

  public data object Type : AccountSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Account.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Account): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Account resource type. */
    public val ALL: List<AccountSearchParam<*>> =
      listOf(Identifier, Name, Owner, Patient, Period, Status, Subject, Type)
  }
}
