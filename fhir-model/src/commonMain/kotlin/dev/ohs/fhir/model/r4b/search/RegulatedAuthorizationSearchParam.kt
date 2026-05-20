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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RegulatedAuthorization
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RegulatedAuthorization] resource type. */
public sealed class RegulatedAuthorizationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: RegulatedAuthorization): List<T>

  public data object Case : RegulatedAuthorizationSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "case"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.case.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: RegulatedAuthorization
    ): List<dev.ohs.fhir.model.r4b.Identifier> = listOfNotNull(resource.case?.identifier)
  }

  public data object CaseType : RegulatedAuthorizationSearchParam<CodeableConcept>() {
    public override val paramName: String = "case-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.case.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<CodeableConcept> =
      listOfNotNull(resource.case?.type)
  }

  public data object Holder : RegulatedAuthorizationSearchParam<Reference>() {
    public override val paramName: String = "holder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RegulatedAuthorization.holder"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: RegulatedAuthorization): List<Reference> =
      listOfNotNull(resource.holder)
  }

  public data object Identifier :
    RegulatedAuthorizationSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: RegulatedAuthorization
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Region : RegulatedAuthorizationSearchParam<CodeableConcept>() {
    public override val paramName: String = "region"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.region"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<CodeableConcept> =
      resource.region
  }

  public data object Status : RegulatedAuthorizationSearchParam<CodeableConcept>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<CodeableConcept> =
      listOfNotNull(resource.status)
  }

  public data object Subject : RegulatedAuthorizationSearchParam<Reference>() {
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

    public override fun extract(resource: RegulatedAuthorization): List<Reference> =
      resource.subject
  }

  public companion object {
    /** All search parameters for the RegulatedAuthorization resource type. */
    public val ALL: List<RegulatedAuthorizationSearchParam<*>> =
      listOf(Case, CaseType, Holder, Identifier, Region, Status, Subject)
  }
}
