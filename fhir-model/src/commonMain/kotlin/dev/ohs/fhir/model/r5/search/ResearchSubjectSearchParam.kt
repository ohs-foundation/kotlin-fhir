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

import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.ResearchSubject
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [ResearchSubject] resource type. */
public object ResearchSubjectSearchParam {
  /** All search parameters for the ResearchSubject resource type. */
  public val ALL: List<SearchParam<ResearchSubject, *>> =
    listOf(Date, Identifier, Patient, Status, Study, Subject, Subject_state)

  public data object Date : SearchParam<ResearchSubject, Period> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ResearchSubject.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchSubject): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Identifier : SearchParam<ResearchSubject, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchSubject.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchSubject): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Patient : SearchParam<ResearchSubject, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchSubject.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: ResearchSubject): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Status : SearchParam<ResearchSubject, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchSubject.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchSubject): List<Any> = listOf(resource.status)
  }

  public data object Study : SearchParam<ResearchSubject, Reference> {
    public override val name: String = "study"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchSubject.study"

    public override val target: List<KClass<out Resource>> = listOf(ResearchStudy::class)

    public override fun extract(resource: ResearchSubject): List<Reference> = listOf(resource.study)
  }

  public data object Subject : SearchParam<ResearchSubject, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchSubject.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Device::class,
        Group::class,
        BiologicallyDerivedProduct::class,
        Specimen::class,
        Substance::class,
        dev.ohs.fhir.model.r5.Patient::class,
        Medication::class,
      )

    public override fun extract(resource: ResearchSubject): List<Reference> =
      listOf(resource.subject)
  }

  public data object Subject_state : SearchParam<ResearchSubject, CodeableConcept> {
    public override val name: String = "subject_state"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchSubject.progress.subjectState"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchSubject): List<CodeableConcept> =
      resource.progress.mapNotNull { it.subjectState }
  }
}
