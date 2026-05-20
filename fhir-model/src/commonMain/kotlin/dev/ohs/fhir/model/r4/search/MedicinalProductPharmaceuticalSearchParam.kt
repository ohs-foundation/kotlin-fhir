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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.MedicinalProductPharmaceutical
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductPharmaceutical] resource type. */
public sealed class MedicinalProductPharmaceuticalSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicinalProductPharmaceutical): List<T>

  public data object Identifier :
    MedicinalProductPharmaceuticalSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductPharmaceutical.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: MedicinalProductPharmaceutical
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Route : MedicinalProductPharmaceuticalSearchParam<CodeableConcept>() {
    public override val paramName: String = "route"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "MedicinalProductPharmaceutical.routeOfAdministration.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductPharmaceutical): List<CodeableConcept> =
      resource.routeOfAdministration.map { it.code }
  }

  public data object TargetSpecies : MedicinalProductPharmaceuticalSearchParam<CodeableConcept>() {
    public override val paramName: String = "target-species"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "MedicinalProductPharmaceutical.routeOfAdministration.targetSpecies.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductPharmaceutical): List<CodeableConcept> =
      resource.routeOfAdministration.flatMap { it.targetSpecies }.map { it.code }
  }

  public companion object {
    /** All search parameters for the MedicinalProductPharmaceutical resource type. */
    public val ALL: List<MedicinalProductPharmaceuticalSearchParam<*>> =
      listOf(Identifier, Route, TargetSpecies)
  }
}
