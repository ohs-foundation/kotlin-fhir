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

/** Search parameters for the [RegulatedAuthorization] resource type. */
public sealed class RegulatedAuthorizationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: RegulatedAuthorization): List<T>

  public data object Case : RegulatedAuthorizationSearchParam<Any>() {
    public override val paramName: String = "case"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.case.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<Any> = emptyList()
  }

  public data object CaseType : RegulatedAuthorizationSearchParam<Any>() {
    public override val paramName: String = "case-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.case.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<Any> = emptyList()
  }

  public data object Holder : RegulatedAuthorizationSearchParam<Any>() {
    public override val paramName: String = "holder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RegulatedAuthorization.holder"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: RegulatedAuthorization): List<Any> = emptyList()
  }

  public data object Identifier : RegulatedAuthorizationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<Any> = emptyList()
  }

  public data object Region : RegulatedAuthorizationSearchParam<Any>() {
    public override val paramName: String = "region"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.region"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<Any> = emptyList()
  }

  public data object Status : RegulatedAuthorizationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<Any> = emptyList()
  }

  public data object Subject : RegulatedAuthorizationSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RegulatedAuthorization.subject"

    public override val target: List<String> =
      listOf(
        "SubstanceDefinition",
        "Organization",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ResearchStudy",
        "Practitioner",
        "MedicinalProductDefinition",
        "NutritionProduct",
        "DeviceDefinition",
        "ObservationDefinition",
        "PlanDefinition",
        "ActivityDefinition",
        "Location",
      )

    public override fun extract(resource: RegulatedAuthorization): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the RegulatedAuthorization resource type. */
    public val ALL: List<RegulatedAuthorizationSearchParam<*>> =
      listOf(Case, CaseType, Holder, Identifier, Region, Status, Subject)
  }
}
