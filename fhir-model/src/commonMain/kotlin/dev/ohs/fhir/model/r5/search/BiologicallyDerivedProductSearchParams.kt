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

import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [BiologicallyDerivedProduct] resource type. */
public object BiologicallyDerivedProductSearchParams {
  public val biologicalSourceEvent: SearchParam<BiologicallyDerivedProduct, Identifier> =
    SearchParam(
      name = "biological-source-event",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.biologicalSourceEvent",
      extractor = { resource -> listOfNotNull(resource.biologicalSourceEvent) },
    )

  public val code: SearchParam<BiologicallyDerivedProduct, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.productCode",
      extractor = { resource -> listOfNotNull(resource.productCode) },
    )

  public val collector: SearchParam<BiologicallyDerivedProduct, Reference> =
    SearchParam(
      name = "collector",
      type = SearchParamType.fromCode("reference"),
      expression = "BiologicallyDerivedProduct.collection.collector",
      target = listOf(PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.collection?.collector) },
    )

  public val identifier: SearchParam<BiologicallyDerivedProduct, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val productCategory: SearchParam<BiologicallyDerivedProduct, Coding> =
    SearchParam(
      name = "product-category",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.productCategory",
      extractor = { resource -> listOfNotNull(resource.productCategory) },
    )

  public val productStatus: SearchParam<BiologicallyDerivedProduct, Coding> =
    SearchParam(
      name = "product-status",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.productStatus",
      extractor = { resource -> listOfNotNull(resource.productStatus) },
    )

  public val request: SearchParam<BiologicallyDerivedProduct, Reference> =
    SearchParam(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "BiologicallyDerivedProduct.request",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.request },
    )

  public val serialNumber: SearchParam<BiologicallyDerivedProduct, Identifier> =
    SearchParam(
      name = "serial-number",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.identifier",
      extractor = { resource -> resource.identifier },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<BiologicallyDerivedProduct, *>> = listOf()

  /**
   * Supported search parameters for the BiologicallyDerivedProduct resource type. Entries in
   * [unsupported] are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<BiologicallyDerivedProduct, *>> =
    listOf(
      biologicalSourceEvent,
      code,
      collector,
      identifier,
      productCategory,
      productStatus,
      request,
      serialNumber,
    ) - unsupported.toSet()
}
