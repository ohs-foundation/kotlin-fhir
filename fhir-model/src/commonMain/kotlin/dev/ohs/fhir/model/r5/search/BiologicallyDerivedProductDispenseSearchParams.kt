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
import dev.ohs.fhir.model.r5.BiologicallyDerivedProductDispense
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [BiologicallyDerivedProductDispense] resource type. */
public object BiologicallyDerivedProductDispenseSearchParams {
  public val identifier: SearchParam<BiologicallyDerivedProductDispense, Identifier> =
    SimpleSearchParam<BiologicallyDerivedProductDispense, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProductDispense.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<BiologicallyDerivedProductDispense, Reference> =
    SimpleSearchParam<BiologicallyDerivedProductDispense, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "BiologicallyDerivedProductDispense.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val performer: SearchParam<BiologicallyDerivedProductDispense, Reference> =
    SimpleSearchParam<BiologicallyDerivedProductDispense, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "BiologicallyDerivedProductDispense.performer.actor",
      target = listOf(Practitioner::class),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val product: SearchParam<BiologicallyDerivedProductDispense, Reference> =
    SimpleSearchParam<BiologicallyDerivedProductDispense, Reference>(
      name = "product",
      type = SearchParamType.fromCode("reference"),
      expression = "BiologicallyDerivedProductDispense.product",
      target = listOf(BiologicallyDerivedProduct::class),
      extractor = { resource -> listOf(resource.product) },
    )

  public val status: SearchParam<BiologicallyDerivedProductDispense, Any> =
    SimpleSearchParam<BiologicallyDerivedProductDispense, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "BiologicallyDerivedProductDispense.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the BiologicallyDerivedProductDispense resource type. */
  public val all: List<SearchParam<BiologicallyDerivedProductDispense, *>> =
    listOf(identifier, patient, performer, product, status)
}
