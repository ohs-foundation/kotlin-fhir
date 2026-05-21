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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.NutritionIntake
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [NutritionIntake] resource type. */
public object NutritionIntakeSearchParam {
  /** All search parameters for the NutritionIntake resource type. */
  public val ALL: List<SearchParam<NutritionIntake, *>> =
    listOf(Code, Date, Encounter, Identifier, Nutrition, Patient, Source, Status, Subject)

  public data object Code : SearchParam<NutritionIntake, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionIntake.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: NutritionIntake): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Date : SearchParam<NutritionIntake, Any> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "NutritionIntake.occurrence.ofType(dateTime)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: NutritionIntake): List<Any> = emptyList()
  }

  public data object Encounter : SearchParam<NutritionIntake, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionIntake.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Encounter::class)

    public override fun extract(resource: NutritionIntake): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<NutritionIntake, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionIntake.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: NutritionIntake): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Nutrition : SearchParam<NutritionIntake, CodeableConcept> {
    public override val name: String = "nutrition"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionIntake.consumedItem.nutritionProduct.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: NutritionIntake): List<CodeableConcept> =
      resource.consumedItem.map { it.nutritionProduct }.mapNotNull { it.concept }
  }

  public data object Patient : SearchParam<NutritionIntake, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionIntake.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: NutritionIntake): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Source : SearchParam<NutritionIntake, Reference> {
    public override val name: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(NutritionIntake.reported as Reference)"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Organization::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: NutritionIntake): List<Reference> =
      listOfNotNull((resource.reported as? NutritionIntake.Reported.Reference)?.value)
  }

  public data object Status : SearchParam<NutritionIntake, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionIntake.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: NutritionIntake): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<NutritionIntake, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "NutritionIntake.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: NutritionIntake): List<Reference> =
      listOf(resource.subject)
  }
}
