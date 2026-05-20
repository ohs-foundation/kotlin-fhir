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

import dev.ohs.fhir.model.r4.BodyStructure
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [BodyStructure] resource type. */
public object BodyStructureSearchParam {
  /** All search parameters for the BodyStructure resource type. */
  public val ALL: List<SearchParam<BodyStructure, *>> =
    listOf(Identifier, Location, Morphology, Patient)

  public data object Identifier : SearchParam<BodyStructure, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BodyStructure.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BodyStructure): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Location : SearchParam<BodyStructure, CodeableConcept> {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BodyStructure.location"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BodyStructure): List<CodeableConcept> =
      listOfNotNull(resource.location)
  }

  public data object Morphology : SearchParam<BodyStructure, CodeableConcept> {
    public override val paramName: String = "morphology"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "BodyStructure.morphology"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: BodyStructure): List<CodeableConcept> =
      listOfNotNull(resource.morphology)
  }

  public data object Patient : SearchParam<BodyStructure, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "BodyStructure.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: BodyStructure): List<Reference> = listOf(resource.patient)
  }
}
