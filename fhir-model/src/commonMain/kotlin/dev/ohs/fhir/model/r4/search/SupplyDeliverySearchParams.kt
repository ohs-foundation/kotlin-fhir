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

import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.SupplyDelivery
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SupplyDelivery] resource type. */
public object SupplyDeliverySearchParams {
  public val identifier: SearchParam<SupplyDelivery, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "SupplyDelivery.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<SupplyDelivery, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyDelivery.patient",
      target = listOf(Patient::class, Group::class),
      extractor = { resource -> listOfNotNull(resource.patient) },
    )

  public val `receiver`: SearchParam<SupplyDelivery, Reference> =
    SearchParam(
      name = "receiver",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyDelivery.receiver",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> resource.`receiver` },
    )

  public val status: SearchParam<SupplyDelivery, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "SupplyDelivery.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val supplier: SearchParam<SupplyDelivery, Reference> =
    SearchParam(
      name = "supplier",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyDelivery.supplier",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.supplier) },
    )

  /** All search parameters for the SupplyDelivery resource type. */
  public val all: List<SearchParam<SupplyDelivery, *>> =
    listOf(identifier, patient, `receiver`, status, supplier)
}
