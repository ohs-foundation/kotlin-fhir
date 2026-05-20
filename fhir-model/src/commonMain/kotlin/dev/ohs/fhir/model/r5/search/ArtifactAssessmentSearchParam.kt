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

import dev.ohs.fhir.model.r5.ArtifactAssessment
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ArtifactAssessment] resource type. */
public object ArtifactAssessmentSearchParam {
  /** All search parameters for the ArtifactAssessment resource type. */
  public val ALL: List<SearchParam<ArtifactAssessment, *>> = listOf(Date, Identifier)

  public data object Date : SearchParam<ArtifactAssessment, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ArtifactAssessment.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ArtifactAssessment): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Identifier :
    SearchParam<ArtifactAssessment, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ArtifactAssessment.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ArtifactAssessment
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }
}
