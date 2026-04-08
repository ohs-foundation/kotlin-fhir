/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SupplyDelivery] resource type. */
public sealed class SupplyDeliverySearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: SupplyDelivery): List<T>

  public data object Identifier : SupplyDeliverySearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyDelivery.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SupplyDelivery): List<Any> = emptyList()
  }

  public data object Patient : SupplyDeliverySearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyDelivery.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: SupplyDelivery): List<Any> = emptyList()
  }

  public data object Receiver : SupplyDeliverySearchParam<Any>() {
    public override val paramName: String = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyDelivery.receiver"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: SupplyDelivery): List<Any> = emptyList()
  }

  public data object Status : SupplyDeliverySearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyDelivery.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SupplyDelivery): List<Any> = emptyList()
  }

  public data object Supplier : SupplyDeliverySearchParam<Any>() {
    public override val paramName: String = "supplier"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyDelivery.supplier"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: SupplyDelivery): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the SupplyDelivery resource type. */
    public val ALL: List<SupplyDeliverySearchParam<*>> =
      listOf(Identifier, Patient, Receiver, Status, Supplier)
  }
}
