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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductInteraction] resource type. */
public sealed class MedicinalProductInteractionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicinalProductInteraction): List<T>

  public data object Subject : MedicinalProductInteractionSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicinalProductInteraction.subject"

    public override val target: List<String> = listOf("Medication", "Substance", "MedicinalProduct")

    public override fun extract(resource: MedicinalProductInteraction): List<Reference> =
      resource.subject
  }

  public companion object {
    /** All search parameters for the MedicinalProductInteraction resource type. */
    public val ALL: List<MedicinalProductInteractionSearchParam<*>> = listOf(Subject)
  }
}
