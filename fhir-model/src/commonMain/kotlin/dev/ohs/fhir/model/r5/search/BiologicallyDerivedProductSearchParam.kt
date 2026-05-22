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
public object BiologicallyDerivedProductSearchParam {
  public val BiologicalSourceEvent: SearchParam<BiologicallyDerivedProduct, Identifier> =
    SimpleSearchParam<BiologicallyDerivedProduct, Identifier>(
      name = "biological-source-event",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.biologicalSourceEvent",
      extractor = { resource -> listOfNotNull(resource.biologicalSourceEvent) },
    )

  public val Code: SearchParam<BiologicallyDerivedProduct, CodeableConcept> =
    SimpleSearchParam<BiologicallyDerivedProduct, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.productCode",
      extractor = { resource -> listOfNotNull(resource.productCode) },
    )

  public val Collector: SearchParam<BiologicallyDerivedProduct, Reference> =
    SimpleSearchParam<BiologicallyDerivedProduct, Reference>(
      name = "collector",
      type = SearchParamType.fromCode("reference"),
      expression = "BiologicallyDerivedProduct.collection.collector",
      target = listOf(PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.collection?.collector) },
    )

  public val Identifier: SearchParam<BiologicallyDerivedProduct, Identifier> =
    SimpleSearchParam<BiologicallyDerivedProduct, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ProductCategory: SearchParam<BiologicallyDerivedProduct, Coding> =
    SimpleSearchParam<BiologicallyDerivedProduct, Coding>(
      name = "product-category",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.productCategory",
      extractor = { resource -> listOfNotNull(resource.productCategory) },
    )

  public val ProductStatus: SearchParam<BiologicallyDerivedProduct, Coding> =
    SimpleSearchParam<BiologicallyDerivedProduct, Coding>(
      name = "product-status",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.productStatus",
      extractor = { resource -> listOfNotNull(resource.productStatus) },
    )

  public val Request: SearchParam<BiologicallyDerivedProduct, Reference> =
    SimpleSearchParam<BiologicallyDerivedProduct, Reference>(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "BiologicallyDerivedProduct.request",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.request },
    )

  public val SerialNumber: SearchParam<BiologicallyDerivedProduct, Identifier> =
    SimpleSearchParam<BiologicallyDerivedProduct, Identifier>(
      name = "serial-number",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProduct.identifier",
      extractor = { resource -> resource.identifier },
    )

  /** All search parameters for the BiologicallyDerivedProduct resource type. */
  public val ALL: List<SearchParam<BiologicallyDerivedProduct, *>> =
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
