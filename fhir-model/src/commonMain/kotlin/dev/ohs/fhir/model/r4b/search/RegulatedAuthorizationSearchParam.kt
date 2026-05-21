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

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DeviceDefinition
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.NutritionProduct
import dev.ohs.fhir.model.r4b.ObservationDefinition
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.PackagedProductDefinition
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RegulatedAuthorization
import dev.ohs.fhir.model.r4b.ResearchStudy
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.SubstanceDefinition
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [RegulatedAuthorization] resource type. */
public object RegulatedAuthorizationSearchParam {
  /** All search parameters for the RegulatedAuthorization resource type. */
  public val ALL: List<SearchParam<RegulatedAuthorization, *>> =
    listOf(Case, CaseType, Holder, Identifier, Region, Status, Subject)

  public data object Case : SearchParam<RegulatedAuthorization, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "case"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.case.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: RegulatedAuthorization
    ): List<dev.ohs.fhir.model.r4b.Identifier> = listOfNotNull(resource.case?.identifier)
  }

  public data object CaseType : SearchParam<RegulatedAuthorization, CodeableConcept> {
    public override val name: String = "case-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.case.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<CodeableConcept> =
      listOfNotNull(resource.case?.type)
  }

  public data object Holder : SearchParam<RegulatedAuthorization, Reference> {
    public override val name: String = "holder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RegulatedAuthorization.holder"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: RegulatedAuthorization): List<Reference> =
      listOfNotNull(resource.holder)
  }

  public data object Identifier :
    SearchParam<RegulatedAuthorization, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: RegulatedAuthorization
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Region : SearchParam<RegulatedAuthorization, CodeableConcept> {
    public override val name: String = "region"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.region"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<CodeableConcept> =
      resource.region
  }

  public data object Status : SearchParam<RegulatedAuthorization, CodeableConcept> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RegulatedAuthorization.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RegulatedAuthorization): List<CodeableConcept> =
      listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<RegulatedAuthorization, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RegulatedAuthorization.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        SubstanceDefinition::class,
        Organization::class,
        BiologicallyDerivedProduct::class,
        PackagedProductDefinition::class,
        ResearchStudy::class,
        Practitioner::class,
        MedicinalProductDefinition::class,
        NutritionProduct::class,
        DeviceDefinition::class,
        ObservationDefinition::class,
        PlanDefinition::class,
        ActivityDefinition::class,
        Location::class,
      )

    public override fun extract(resource: RegulatedAuthorization): List<Reference> =
      resource.subject
  }
}
