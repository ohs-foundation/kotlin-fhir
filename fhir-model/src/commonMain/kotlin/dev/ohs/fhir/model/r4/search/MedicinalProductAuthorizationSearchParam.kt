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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicinalProduct
import dev.ohs.fhir.model.r4.MedicinalProductAuthorization
import dev.ohs.fhir.model.r4.MedicinalProductPackaged
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductAuthorization] resource type. */
public object MedicinalProductAuthorizationSearchParam {
  public val Country: SearchParam<MedicinalProductAuthorization, CodeableConcept> =
    SimpleSearchParam<MedicinalProductAuthorization, CodeableConcept>(
      name = "country",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductAuthorization.country",
      extractor = { resource -> resource.country },
    )

  public val Holder: SearchParam<MedicinalProductAuthorization, Reference> =
    SimpleSearchParam<MedicinalProductAuthorization, Reference>(
      name = "holder",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicinalProductAuthorization.holder",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.holder) },
    )

  public val Identifier: SearchParam<MedicinalProductAuthorization, Identifier> =
    SimpleSearchParam<MedicinalProductAuthorization, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductAuthorization.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Status: SearchParam<MedicinalProductAuthorization, CodeableConcept> =
    SimpleSearchParam<MedicinalProductAuthorization, CodeableConcept>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductAuthorization.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Subject: SearchParam<MedicinalProductAuthorization, Reference> =
    SimpleSearchParam<MedicinalProductAuthorization, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicinalProductAuthorization.subject",
      target = listOf(MedicinalProductPackaged::class, MedicinalProduct::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /** All search parameters for the MedicinalProductAuthorization resource type. */
  public val ALL: List<SearchParam<MedicinalProductAuthorization, *>> =
    listOf(Country, Holder, Identifier, Status, Subject)
}
