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

/** Search parameters for the [Flag] resource type. */
public sealed class FlagSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Flag): List<T>

  public data object Author : FlagSearchParam<Reference>() {
    public override val paramName: String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Flag.author"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "Device", "Patient", "PractitionerRole")

    public override fun extract(resource: Flag): List<Reference> = listOfNotNull(resource.author)
  }

  public data object Date : FlagSearchParam<Period>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Flag.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Flag): List<Period> = listOfNotNull(resource.period)
  }

  public data object Encounter : FlagSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Flag.encounter"

    public override val target: List<String> = listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: Flag): List<Reference> = listOfNotNull(resource.encounter)
  }

  public data object Identifier : FlagSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Flag.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Flag): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Patient : FlagSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Flag.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: Flag): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Subject : FlagSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Flag.subject"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Group",
        "Organization",
        "Medication",
        "Patient",
        "PlanDefinition",
        "Procedure",
        "Location",
      )

    public override fun extract(resource: Flag): List<Reference> = listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the Flag resource type. */
    public val ALL: List<FlagSearchParam<*>> =
      listOf(Author, Date, Encounter, Identifier, Patient, Subject)
  }
}
