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
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [BiologicallyDerivedProductDispense] resource type. */
public object BiologicallyDerivedProductDispenseSearchParam {
  /** All search parameters for the BiologicallyDerivedProductDispense resource type. */
  public val ALL: List<SearchParam<BiologicallyDerivedProductDispense, *>> =
    listOf(Identifier, Patient, Performer, Product, Status)

  public data object Identifier :
    SearchParam<BiologicallyDerivedProductDispense, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BiologicallyDerivedProductDispense.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: BiologicallyDerivedProductDispense
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Patient : SearchParam<BiologicallyDerivedProductDispense, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "BiologicallyDerivedProductDispense.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: BiologicallyDerivedProductDispense): List<Reference> =
      listOf(resource.patient)
  }

  public data object Performer : SearchParam<BiologicallyDerivedProductDispense, Reference> {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "BiologicallyDerivedProductDispense.performer.actor"

    public override val target: List<KClass<out Resource>> = listOf(Practitioner::class)

    public override fun extract(resource: BiologicallyDerivedProductDispense): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object Product : SearchParam<BiologicallyDerivedProductDispense, Reference> {
    public override val paramName: String = "product"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "BiologicallyDerivedProductDispense.product"

    public override val target: List<KClass<out Resource>> =
      listOf(BiologicallyDerivedProduct::class)

    public override fun extract(resource: BiologicallyDerivedProductDispense): List<Reference> =
      listOf(resource.product)
  }

  public data object Status : SearchParam<BiologicallyDerivedProductDispense, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BiologicallyDerivedProductDispense.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: BiologicallyDerivedProductDispense): List<Any> =
      listOf(resource.status)
  }
}
