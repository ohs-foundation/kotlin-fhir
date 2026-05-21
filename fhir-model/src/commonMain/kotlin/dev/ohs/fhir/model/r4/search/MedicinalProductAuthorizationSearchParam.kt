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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.MedicinalProduct
import dev.ohs.fhir.model.r4.MedicinalProductAuthorization
import dev.ohs.fhir.model.r4.MedicinalProductPackaged
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [MedicinalProductAuthorization] resource type. */
public object MedicinalProductAuthorizationSearchParam {
  /** All search parameters for the MedicinalProductAuthorization resource type. */
  public val ALL: List<SearchParam<MedicinalProductAuthorization, *>> =
    listOf(Country, Holder, Identifier, Status, Subject)

  public data object Country : SearchParam<MedicinalProductAuthorization, CodeableConcept> {
    public override val name: String = "country"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductAuthorization.country"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductAuthorization): List<CodeableConcept> =
      resource.country
  }

  public data object Holder : SearchParam<MedicinalProductAuthorization, Reference> {
    public override val name: String = "holder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicinalProductAuthorization.holder"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: MedicinalProductAuthorization): List<Reference> =
      listOfNotNull(resource.holder)
  }

  public data object Identifier :
    SearchParam<MedicinalProductAuthorization, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductAuthorization.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicinalProductAuthorization
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Status : SearchParam<MedicinalProductAuthorization, CodeableConcept> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductAuthorization.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductAuthorization): List<CodeableConcept> =
      listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<MedicinalProductAuthorization, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicinalProductAuthorization.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(MedicinalProductPackaged::class, MedicinalProduct::class)

    public override fun extract(resource: MedicinalProductAuthorization): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
