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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.MedicationAdministration
import dev.ohs.fhir.model.r4.MedicationDispense
import dev.ohs.fhir.model.r4.MedicationStatement
import dev.ohs.fhir.model.r4.Observation
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Procedure
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [MedicationStatement] resource type. */
public object MedicationStatementSearchParam {
  /** All search parameters for the MedicationStatement resource type. */
  public val ALL: List<SearchParam<MedicationStatement, *>> =
    listOf(
      Category,
      Code,
      Context,
      Effective,
      Identifier,
      Medication,
      PartOf,
      Patient,
      Source,
      Status,
      Subject,
    )

  public data object Category : SearchParam<MedicationStatement, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationStatement.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationStatement): List<CodeableConcept> =
      listOfNotNull(resource.category)
  }

  public data object Code : SearchParam<MedicationStatement, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(MedicationStatement.medication as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationStatement): List<CodeableConcept> =
      listOfNotNull((resource.medication as? MedicationStatement.Medication.CodeableConcept)?.value)
  }

  public data object Context : SearchParam<MedicationStatement, Reference> {
    public override val name: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationStatement.context"

    public override val target: List<KClass<out Resource>> =
      listOf(EpisodeOfCare::class, Encounter::class)

    public override fun extract(resource: MedicationStatement): List<Reference> =
      listOfNotNull(resource.context)
  }

  public data object Effective : SearchParam<MedicationStatement, MedicationStatement.Effective> {
    public override val name: String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationStatement.effective"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationStatement
    ): List<MedicationStatement.Effective> = listOfNotNull(resource.effective)
  }

  public data object Identifier :
    SearchParam<MedicationStatement, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationStatement.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationStatement
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Medication : SearchParam<MedicationStatement, Reference> {
    public override val name: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(MedicationStatement.medication as Reference)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Medication::class)

    public override fun extract(resource: MedicationStatement): List<Reference> =
      listOfNotNull((resource.medication as? MedicationStatement.Medication.Reference)?.value)
  }

  public data object PartOf : SearchParam<MedicationStatement, Reference> {
    public override val name: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationStatement.partOf"

    public override val target: List<KClass<out Resource>> =
      listOf(
        MedicationDispense::class,
        Observation::class,
        MedicationAdministration::class,
        Procedure::class,
        MedicationStatement::class,
      )

    public override fun extract(resource: MedicationStatement): List<Reference> = resource.partOf
  }

  public data object Patient : SearchParam<MedicationStatement, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationStatement.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

    public override fun extract(resource: MedicationStatement): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Source : SearchParam<MedicationStatement, Reference> {
    public override val name: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationStatement.informationSource"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        dev.ohs.fhir.model.r4.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: MedicationStatement): List<Reference> =
      listOfNotNull(resource.informationSource)
  }

  public data object Status : SearchParam<MedicationStatement, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationStatement.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationStatement): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<MedicationStatement, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationStatement.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: MedicationStatement): List<Reference> =
      listOf(resource.subject)
  }
}
