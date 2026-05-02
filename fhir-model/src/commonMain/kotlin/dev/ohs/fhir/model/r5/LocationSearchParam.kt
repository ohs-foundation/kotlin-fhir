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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Location] resource type. */
public sealed class LocationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Location): List<T>

  public data object Address : LocationSearchParam<dev.ohs.fhir.model.r5.Address>() {
    public override val paramName: kotlin.String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Location.address"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<dev.ohs.fhir.model.r5.Address> =
      listOfNotNull(resource.address)
  }

  public data object AddressCity : LocationSearchParam<String>() {
    public override val paramName: kotlin.String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Location.address.city"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<String> =
      listOfNotNull(resource.address?.city)
  }

  public data object AddressCountry : LocationSearchParam<String>() {
    public override val paramName: kotlin.String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Location.address.country"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<String> =
      listOfNotNull(resource.address?.country)
  }

  public data object AddressPostalcode : LocationSearchParam<String>() {
    public override val paramName: kotlin.String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Location.address.postalCode"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<String> =
      listOfNotNull(resource.address?.postalCode)
  }

  public data object AddressState : LocationSearchParam<String>() {
    public override val paramName: kotlin.String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Location.address.state"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<String> =
      listOfNotNull(resource.address?.state)
  }

  public data object AddressUse : LocationSearchParam<Any>() {
    public override val paramName: kotlin.String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Location.address.use"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<Any> =
      listOfNotNull(resource.address?.use)
  }

  public data object Characteristic : LocationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Location.characteristic"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<CodeableConcept> = resource.characteristic
  }

  public data object Contains : LocationSearchParam<Any>() {
    public override val paramName: kotlin.String = "contains"

    public override val type: SearchParamType = SearchParamType.fromCode("special")

    public override val expression: kotlin.String =
      "Location.extension('http://hl7.org/fhir/StructureDefinition/location-boundary-geojson').value"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Endpoint : LocationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Location.endpoint"

    public override val target: List<kotlin.String> = listOf("Endpoint")

    public override fun extract(resource: Location): List<Reference> = resource.endpoint
  }

  public data object Identifier : LocationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Location.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : LocationSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Location.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<String> = listOfNotNull(resource.name)
  }

  public data object Near : LocationSearchParam<Location.Position>() {
    public override val paramName: kotlin.String = "near"

    public override val type: SearchParamType = SearchParamType.fromCode("special")

    public override val expression: kotlin.String = "Location.position"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<Location.Position> =
      listOfNotNull(resource.position)
  }

  public data object OperationalStatus : LocationSearchParam<Coding>() {
    public override val paramName: kotlin.String = "operational-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Location.operationalStatus"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<Coding> =
      listOfNotNull(resource.operationalStatus)
  }

  public data object Organization : LocationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Location.managingOrganization"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: Location): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object Partof : LocationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Location.partOf"

    public override val target: List<kotlin.String> = listOf("Location")

    public override fun extract(resource: Location): List<Reference> =
      listOfNotNull(resource.partOf)
  }

  public data object Status : LocationSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Location.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<Any> = listOfNotNull(resource.status)
  }

  public data object Type : LocationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Location.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Location): List<CodeableConcept> = resource.type
  }

  public companion object {
    /** All search parameters for the Location resource type. */
    public val ALL: List<LocationSearchParam<*>> =
      listOf(
        Address,
        AddressCity,
        AddressCountry,
        AddressPostalcode,
        AddressState,
        AddressUse,
        Characteristic,
        Contains,
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
  }
}
