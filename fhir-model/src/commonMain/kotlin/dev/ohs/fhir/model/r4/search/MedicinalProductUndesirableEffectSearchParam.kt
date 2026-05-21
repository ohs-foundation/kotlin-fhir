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
import dev.ohs.fhir.model.r4.MedicinalProductUndesirableEffect
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [MedicinalProductUndesirableEffect] resource type. */
public object MedicinalProductUndesirableEffectSearchParam {
  /** All search parameters for the MedicinalProductUndesirableEffect resource type. */
  public val ALL: List<SearchParam<MedicinalProductUndesirableEffect, *>> = listOf(Subject)

  public data object Subject : SearchParam<MedicinalProductUndesirableEffect, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicinalProductUndesirableEffect.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Medication::class, MedicinalProduct::class)

    public override fun extract(resource: MedicinalProductUndesirableEffect): List<Reference> =
      resource.subject
  }
}
