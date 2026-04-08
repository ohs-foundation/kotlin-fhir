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

/** Search parameters for the [BiologicallyDerivedProduct] resource type. */
public sealed class BiologicallyDerivedProductSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: BiologicallyDerivedProduct): List<T>

  public data object BiologicalSourceEvent : BiologicallyDerivedProductSearchParam<Any>() {
    public override val paramName: String = "biological-source-event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BiologicallyDerivedProduct.biologicalSourceEvent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BiologicallyDerivedProduct): List<Any> = emptyList()
  }

  public data object Code : BiologicallyDerivedProductSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BiologicallyDerivedProduct.productCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BiologicallyDerivedProduct): List<Any> = emptyList()
  }

  public data object Collector : BiologicallyDerivedProductSearchParam<Any>() {
    public override val paramName: String = "collector"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "BiologicallyDerivedProduct.collection.collector"

    public override val target: List<String> = listOf("PractitionerRole", "Practitioner")

    public override fun extract(resource: BiologicallyDerivedProduct): List<Any> = emptyList()
  }

  public data object Identifier : BiologicallyDerivedProductSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BiologicallyDerivedProduct.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BiologicallyDerivedProduct): List<Any> = emptyList()
  }

  public data object ProductCategory : BiologicallyDerivedProductSearchParam<Any>() {
    public override val paramName: String = "product-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BiologicallyDerivedProduct.productCategory"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BiologicallyDerivedProduct): List<Any> = emptyList()
  }

  public data object ProductStatus : BiologicallyDerivedProductSearchParam<Any>() {
    public override val paramName: String = "product-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BiologicallyDerivedProduct.productStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BiologicallyDerivedProduct): List<Any> = emptyList()
  }

  public data object Request : BiologicallyDerivedProductSearchParam<Any>() {
    public override val paramName: String = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "BiologicallyDerivedProduct.request"

    public override val target: List<String> = listOf("ServiceRequest")

    public override fun extract(resource: BiologicallyDerivedProduct): List<Any> = emptyList()
  }

  public data object SerialNumber : BiologicallyDerivedProductSearchParam<Any>() {
    public override val paramName: String = "serial-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BiologicallyDerivedProduct.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BiologicallyDerivedProduct): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the BiologicallyDerivedProduct resource type. */
    public val ALL: List<BiologicallyDerivedProductSearchParam<*>> =
      listOf(
        BiologicalSourceEvent,
        Code,
        Collector,
        Identifier,
        ProductCategory,
        ProductStatus,
        Request,
        SerialNumber,
      )
  }
}
