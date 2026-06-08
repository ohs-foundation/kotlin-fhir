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
import dev.ohs.fhir.model.r4.MedicinalProductIndication
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductIndication] resource type. */
public object MedicinalProductIndicationSearchParams {
  public val subject: SearchParam<MedicinalProductIndication, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "MedicinalProductIndication.subject",
      target = listOf(Medication::class, MedicinalProduct::class),
      extractor = { resource -> resource.subject },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<MedicinalProductIndication, *>> = listOf()

  /**
   * Supported search parameters for the MedicinalProductIndication resource type. Iterating `all`
   * and calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded
   * from this list.
   */
  public val all: List<SearchParam<MedicinalProductIndication, *>> = listOf(subject)
}
