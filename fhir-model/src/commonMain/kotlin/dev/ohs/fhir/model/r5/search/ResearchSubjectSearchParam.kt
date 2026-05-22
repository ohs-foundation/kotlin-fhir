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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.ResearchSubject
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchSubject] resource type. */
public object ResearchSubjectSearchParam {
  public val Date: SearchParam<ResearchSubject, Period> =
    SimpleSearchParam<ResearchSubject, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ResearchSubject.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val Identifier: SearchParam<ResearchSubject, Identifier> =
    SimpleSearchParam<ResearchSubject, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchSubject.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<ResearchSubject, Reference> =
    SimpleSearchParam<ResearchSubject, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchSubject.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Status: SearchParam<ResearchSubject, Any> =
    SimpleSearchParam<ResearchSubject, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchSubject.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Study: SearchParam<ResearchSubject, Reference> =
    SimpleSearchParam<ResearchSubject, Reference>(
      name = "study",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchSubject.study",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> listOf(resource.study) },
    )

  public val Subject: SearchParam<ResearchSubject, Reference> =
    SimpleSearchParam<ResearchSubject, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchSubject.subject",
      target =
        listOf(
          Device::class,
          Group::class,
          BiologicallyDerivedProduct::class,
          Specimen::class,
          Substance::class,
          dev.ohs.fhir.model.r5.Patient::class,
          Medication::class,
        ),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val Subject_state: SearchParam<ResearchSubject, CodeableConcept> =
    SimpleSearchParam<ResearchSubject, CodeableConcept>(
      name = "subject_state",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchSubject.progress.subjectState",
      extractor = { resource -> resource.progress.mapNotNull { it.subjectState } },
    )

  /** All search parameters for the ResearchSubject resource type. */
  public val ALL: List<SearchParam<ResearchSubject, *>> =
    listOf(Date, Identifier, Patient, Status, Study, Subject, Subject_state)
}
