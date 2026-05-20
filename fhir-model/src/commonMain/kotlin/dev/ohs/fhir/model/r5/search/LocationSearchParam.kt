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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Location] resource type. */
public sealed class LocationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Location): List<T>

  public data object Address : LocationSearchParam<dev.ohs.fhir.model.r5.Address>() {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<dev.ohs.fhir.model.r5.Address> =
      listOfNotNull(resource.address)
  }

  public data object AddressCity : LocationSearchParam<R5String>() {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address.city"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R5String> =
      listOfNotNull(resource.address?.city)
  }

  public data object AddressCountry : LocationSearchParam<R5String>() {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address.country"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R5String> =
      listOfNotNull(resource.address?.country)
  }

  public data object AddressPostalcode : LocationSearchParam<R5String>() {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address.postalCode"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R5String> =
      listOfNotNull(resource.address?.postalCode)
  }

  public data object AddressState : LocationSearchParam<R5String>() {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.address.state"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R5String> =
      listOfNotNull(resource.address?.state)
  }

  public data object AddressUse : LocationSearchParam<Any>() {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.address.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<Any> =
      listOfNotNull(resource.address?.use)
  }

  public data object Characteristic : LocationSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.characteristic"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<CodeableConcept> = resource.characteristic
  }

  public data object Contains : LocationSearchParam<Any>() {
    public override val paramName: KotlinString = "contains"

    public override val type: SearchParamType = SearchParamType.fromCode("special")

    public override val expression: KotlinString =
      "Location.extension('http://hl7.org/fhir/StructureDefinition/location-boundary-geojson').value"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Endpoint : LocationSearchParam<Reference>() {
    public override val paramName: KotlinString = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Location.endpoint"

    public override val target: List<KotlinString> = listOf("Endpoint")

    public override fun extract(resource: Location): List<Reference> = resource.endpoint
  }

  public data object Identifier : LocationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : LocationSearchParam<R5String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Location.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<R5String> = listOfNotNull(resource.name)
  }

  public data object Near : LocationSearchParam<Location.Position>() {
    public override val paramName: KotlinString = "near"

    public override val type: SearchParamType = SearchParamType.fromCode("special")

    public override val expression: KotlinString = "Location.position"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<Location.Position> =
      listOfNotNull(resource.position)
  }

  public data object OperationalStatus : LocationSearchParam<Coding>() {
    public override val paramName: KotlinString = "operational-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.operationalStatus"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<Coding> =
      listOfNotNull(resource.operationalStatus)
  }

  public data object Organization : LocationSearchParam<Reference>() {
    public override val paramName: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Location.managingOrganization"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Location): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object Partof : LocationSearchParam<Reference>() {
    public override val paramName: KotlinString = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Location.partOf"

    public override val target: List<KotlinString> = listOf("Location")

    public override fun extract(resource: Location): List<Reference> =
      listOfNotNull(resource.partOf)
  }

  public data object Status : LocationSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Location): List<Any> = listOfNotNull(resource.status)
  }

  public data object Type : LocationSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Location.type"

    public override val target: List<KotlinString> = emptyList()

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
