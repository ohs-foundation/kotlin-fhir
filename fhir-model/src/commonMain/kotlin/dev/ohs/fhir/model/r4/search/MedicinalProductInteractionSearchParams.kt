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

import dev.ohs.fhir.model.r4.Medication
import dev.ohs.fhir.model.r4.MedicinalProduct
import dev.ohs.fhir.model.r4.MedicinalProductInteraction
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Substance
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductInteraction] resource type. */
public object MedicinalProductInteractionSearchParams {
  public val subject: SearchParam<MedicinalProductInteraction, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicinalProductInteraction.subject",
      target = listOf(Medication::class, Substance::class, MedicinalProduct::class),
      extractor = { resource -> resource.subject },
    )

  /** All search parameters for the MedicinalProductInteraction resource type. */
  public val all: List<SearchParam<MedicinalProductInteraction, *>> = listOf(subject)
}
