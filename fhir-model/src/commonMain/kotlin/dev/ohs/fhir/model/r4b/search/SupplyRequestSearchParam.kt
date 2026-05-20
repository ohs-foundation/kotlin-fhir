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
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.SupplyRequest
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SupplyRequest] resource type. */
public sealed class SupplyRequestSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: SupplyRequest): List<T>

  public data object Category : SupplyRequestSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyRequest.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SupplyRequest): List<CodeableConcept> =
      listOfNotNull(resource.category)
  }

  public data object Date : SupplyRequestSearchParam<DateTime>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "SupplyRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SupplyRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object Identifier : SupplyRequestSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SupplyRequest): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Requester : SupplyRequestSearchParam<Reference>() {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.requester"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: SupplyRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Status : SupplyRequestSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SupplyRequest): List<Any> = listOfNotNull(resource.status)
  }

  public data object Subject : SupplyRequestSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.deliverTo"

    public override val target: List<String> = listOf("Organization", "Patient", "Location")

    public override fun extract(resource: SupplyRequest): List<Reference> =
      listOfNotNull(resource.deliverTo)
  }

  public data object Supplier : SupplyRequestSearchParam<Reference>() {
    public override val paramName: String = "supplier"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.supplier"

    public override val target: List<String> = listOf("Organization", "HealthcareService")

    public override fun extract(resource: SupplyRequest): List<Reference> = resource.supplier
  }

  public companion object {
    /** All search parameters for the SupplyRequest resource type. */
    public val ALL: List<SupplyRequestSearchParam<*>> =
      listOf(Category, Date, Identifier, Requester, Status, Subject, Supplier)
  }
}
