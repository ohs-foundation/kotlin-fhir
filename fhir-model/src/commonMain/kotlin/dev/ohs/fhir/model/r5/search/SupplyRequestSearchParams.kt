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

import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.SupplyRequest
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SupplyRequest] resource type. */
public object SupplyRequestSearchParams {
  public val category: SearchParam<SupplyRequest, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "SupplyRequest.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val date: SearchParam<SupplyRequest, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "SupplyRequest.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val identifier: SearchParam<SupplyRequest, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "SupplyRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<SupplyRequest, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyRequest.deliverFor",
      target = listOf(Patient::class),
      extractor = { resource -> listOfNotNull(resource.deliverFor) },
    )

  public val requester: SearchParam<SupplyRequest, Reference> =
    SearchParam(
      name = "requester",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyRequest.requester",
      target =
        listOf(
          Organization::class,
          Device::class,
          CareTeam::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.requester) },
    )

  public val status: SearchParam<SupplyRequest, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "SupplyRequest.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val subject: SearchParam<SupplyRequest, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyRequest.deliverTo",
      target = listOf(Organization::class, RelatedPerson::class, Location::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.deliverTo) },
    )

  public val supplier: SearchParam<SupplyRequest, Reference> =
    SearchParam(
      name = "supplier",
      type = SearchParamType.fromCode("reference"),
      expression = "SupplyRequest.supplier",
      target = listOf(HealthcareService::class, Organization::class),
      extractor = { resource -> resource.supplier },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<SupplyRequest, *>> = listOf()

  /**
   * Supported search parameters for the SupplyRequest resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<SupplyRequest, *>> =
    listOf(category, date, identifier, patient, requester, status, subject, supplier)
}
