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
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Location] resource type. */
public object LocationSearchParam {
  /** All search parameters for the Location resource type. */
  public val ALL: List<SearchParam<Location, *>> =
    listOf(
      Address,
      AddressCity,
      AddressCountry,
      AddressPostalcode,
      AddressState,
      AddressUse,
      Endpoint,
      Identifier,
      Name,
      Near,
      OperationalStatus,
      Organization,
      Partof,
      Status,
      Type,
    )

  public data object Address : SearchParam<Location, dev.ohs.fhir.model.r4b.Address> {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<dev.ohs.fhir.model.r4b.Address> =
      listOfNotNull(resource.address)
  }

  public data object AddressCity : SearchParam<Location, R4bString> {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address.city"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R4bString> =
      listOfNotNull(resource.address?.city)
  }

  public data object AddressCountry : SearchParam<Location, R4bString> {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address.country"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R4bString> =
      listOfNotNull(resource.address?.country)
  }

  public data object AddressPostalcode : SearchParam<Location, R4bString> {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address.postalCode"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R4bString> =
      listOfNotNull(resource.address?.postalCode)
  }

  public data object AddressState : SearchParam<Location, R4bString> {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address.state"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R4bString> =
      listOfNotNull(resource.address?.state)
  }

  public data object AddressUse : SearchParam<Location, Any> {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.address.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<Any> =
      listOfNotNull(resource.address?.use)
  }

  public data object Endpoint : SearchParam<Location, Reference> {
    public override val paramName: KotlinString = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Location.endpoint"

    public override val target: List<KotlinString> = listOf("Endpoint")

    public override fun extract(resource: Location): List<Reference> = resource.endpoint
  }

  public data object Identifier : SearchParam<Location, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<Location, R4bString> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R4bString> = listOfNotNull(resource.name)
  }

  public data object Near : SearchParam<Location, Location.Position> {
    public override val paramName: KotlinString = "near"

    public override val type: SearchParamType = SearchParamType.fromCode("special")

    public override val expression: KotlinString = "Location.position"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<Location.Position> =
      listOfNotNull(resource.position)
  }

  public data object OperationalStatus : SearchParam<Location, Coding> {
    public override val paramName: KotlinString = "operational-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.operationalStatus"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<Coding> =
      listOfNotNull(resource.operationalStatus)
  }

  public data object Organization : SearchParam<Location, Reference> {
    public override val paramName: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Location.managingOrganization"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Location): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object Partof : SearchParam<Location, Reference> {
    public override val paramName: KotlinString = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Location.partOf"

    public override val target: List<KotlinString> = listOf("Location")

    public override fun extract(resource: Location): List<Reference> =
      listOfNotNull(resource.partOf)
  }

  public data object Status : SearchParam<Location, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<Any> = listOfNotNull(resource.status)
  }

  public data object Type : SearchParam<Location, CodeableConcept> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<CodeableConcept> = resource.type
  }
}
