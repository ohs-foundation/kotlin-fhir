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

import dev.ohs.fhir.model.r4.CareTeam
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [CareTeam] resource type. */
public object CareTeamSearchParam {
  /** All search parameters for the CareTeam resource type. */
  public val ALL: List<SearchParam<CareTeam, *>> =
    listOf(Category, Date, Encounter, Identifier, Participant, Patient, Status, Subject)

  public data object Category : SearchParam<CareTeam, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CareTeam.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CareTeam): List<CodeableConcept> = resource.category
  }

  public data object Date : SearchParam<CareTeam, Period> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CareTeam.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CareTeam): List<Period> = listOfNotNull(resource.period)
  }

  public data object Encounter : SearchParam<CareTeam, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Encounter::class)

    public override fun extract(resource: CareTeam): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<CareTeam, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CareTeam.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CareTeam): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Participant : SearchParam<CareTeam, Reference> {
    public override val name: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.participant.member"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        CareTeam::class,
        dev.ohs.fhir.model.r4.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: CareTeam): List<Reference> =
      resource.participant.mapNotNull { it.member }
  }

  public data object Patient : SearchParam<CareTeam, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

    public override fun extract(resource: CareTeam): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Status : SearchParam<CareTeam, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CareTeam.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<CareTeam, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: CareTeam): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
