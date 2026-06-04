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
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.SupplyRequest
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SupplyRequest] resource type. */
public object SupplyRequestSearchParams {
  public val Category: SearchParam<SupplyRequest, CodeableConcept> =
    SimpleSearchParam<SupplyRequest, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "SupplyRequest.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val Date: SearchParam<SupplyRequest, DateTime> =
    SimpleSearchParam<SupplyRequest, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "SupplyRequest.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val Identifier: SearchParam<SupplyRequest, Identifier> =
    SimpleSearchParam<SupplyRequest, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "SupplyRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Requester: SearchParam<SupplyRequest, Reference> =
    SimpleSearchParam<SupplyRequest, Reference>(
      name = "requester",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyRequest.requester",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.requester) },
    )

  public val Status: SearchParam<SupplyRequest, Any> =
    SimpleSearchParam<SupplyRequest, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "SupplyRequest.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Subject: SearchParam<SupplyRequest, Reference> =
    SimpleSearchParam<SupplyRequest, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyRequest.deliverTo",
      target = listOf(Organization::class, Patient::class, Location::class),
      extractor = { resource -> listOfNotNull(resource.deliverTo) },
    )

  public val Supplier: SearchParam<SupplyRequest, Reference> =
    SimpleSearchParam<SupplyRequest, Reference>(
      name = "supplier",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyRequest.supplier",
      target = listOf(Organization::class, HealthcareService::class),
      extractor = { resource -> resource.supplier },
    )

  /** All search parameters for the SupplyRequest resource type. */
  public val ALL: List<SearchParam<SupplyRequest, *>> =
    listOf(Category, Date, Identifier, Requester, Status, Subject, Supplier)
}
