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
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [BodyStructure] resource type. */
public sealed class BodyStructureSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: BodyStructure): List<T>

  public data object Excluded_structure : BodyStructureSearchParam<Any>() {
    public override val paramName: String = "excluded_structure"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BodyStructure.excludedStructure.structure"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BodyStructure): List<Any> = emptyList()
  }

  public data object Identifier : BodyStructureSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BodyStructure.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BodyStructure): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Included_structure : BodyStructureSearchParam<CodeableConcept>() {
    public override val paramName: String = "included_structure"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BodyStructure.includedStructure.structure"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BodyStructure): List<CodeableConcept> =
      resource.includedStructure.map { it.structure }
  }

  public data object Morphology : BodyStructureSearchParam<CodeableConcept>() {
    public override val paramName: String = "morphology"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BodyStructure.morphology"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BodyStructure): List<CodeableConcept> =
      listOfNotNull(resource.morphology)
  }

  public data object Patient : BodyStructureSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "BodyStructure.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: BodyStructure): List<Reference> = listOf(resource.patient)
  }

  public companion object {
    /** All search parameters for the BodyStructure resource type. */
    public val ALL: List<BodyStructureSearchParam<*>> =
      listOf(Excluded_structure, Identifier, Included_structure, Morphology, Patient)
  }
}
