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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.AdverseEvent
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Immunization
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.MedicationStatement
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.ResearchStudy
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AdverseEvent] resource type. */
public object AdverseEventSearchParam {
  public val Actuality: SearchParam<AdverseEvent, Any> =
    SimpleSearchParam<AdverseEvent, Any>(
      name = "actuality",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.actuality",
      extractor = { resource -> listOf(resource.actuality) },
    )

  public val Category: SearchParam<AdverseEvent, CodeableConcept> =
    SimpleSearchParam<AdverseEvent, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.category",
      extractor = { resource -> resource.category },
    )

  public val Date: SearchParam<AdverseEvent, DateTime> =
    SimpleSearchParam<AdverseEvent, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "AdverseEvent.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Event: SearchParam<AdverseEvent, CodeableConcept> =
    SimpleSearchParam<AdverseEvent, CodeableConcept>(
      name = "event",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.event",
      extractor = { resource -> listOfNotNull(resource.event) },
    )

  public val Location: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.location",
      target = listOf(dev.ohs.fhir.model.r4b.Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val Recorder: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "recorder",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.recorder",
      target =
        listOf(Practitioner::class, Patient::class, PractitionerRole::class, RelatedPerson::class),
      extractor = { resource -> listOfNotNull(resource.recorder) },
    )

  public val Resultingcondition: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "resultingcondition",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.resultingCondition",
      target = listOf(Condition::class),
      extractor = { resource -> resource.resultingCondition },
    )

  public val Seriousness: SearchParam<AdverseEvent, CodeableConcept> =
    SimpleSearchParam<AdverseEvent, CodeableConcept>(
      name = "seriousness",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.seriousness",
      extractor = { resource -> listOfNotNull(resource.seriousness) },
    )

  public val Severity: SearchParam<AdverseEvent, CodeableConcept> =
    SimpleSearchParam<AdverseEvent, CodeableConcept>(
      name = "severity",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.severity",
      extractor = { resource -> listOfNotNull(resource.severity) },
    )

  public val Study: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "study",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.study",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> resource.study },
    )

  public val Subject: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.subject",
      target = listOf(Practitioner::class, Group::class, Patient::class, RelatedPerson::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val Substance: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "substance",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.suspectEntity.instance",
      target =
        listOf(
          Immunization::class,
          Device::class,
          Medication::class,
          Procedure::class,
          dev.ohs.fhir.model.r4b.Substance::class,
          MedicationAdministration::class,
          MedicationStatement::class,
        ),
      extractor = { resource -> resource.suspectEntity.map { it.instance } },
    )

  /** All search parameters for the AdverseEvent resource type. */
  public val ALL: List<SearchParam<AdverseEvent, *>> =
    listOf(
      Actuality,
      Category,
      Date,
      Event,
      Location,
      Recorder,
      Resultingcondition,
      Seriousness,
      Severity,
      Study,
      Subject,
      Substance,
    )
}
