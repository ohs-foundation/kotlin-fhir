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

import dev.ohs.fhir.model.r4.AdverseEvent
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Condition
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Immunization
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Medication
import dev.ohs.fhir.model.r4.MedicationAdministration
import dev.ohs.fhir.model.r4.MedicationStatement
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Procedure
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.ResearchStudy
import dev.ohs.fhir.model.r4.Substance
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AdverseEvent] resource type. */
public object AdverseEventSearchParams {
  public val actuality: SearchParam<AdverseEvent, Any> =
    SearchParam(
      name = "actuality",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.actuality",
      extractor = { resource -> listOf(resource.actuality) },
    )

  public val category: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.category",
      extractor = { resource -> resource.category },
    )

  public val date: SearchParam<AdverseEvent, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "AdverseEvent.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val event: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam(
      name = "event",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.event",
      extractor = { resource -> listOfNotNull(resource.event) },
    )

  public val location: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.location",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val recorder: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "recorder",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.recorder",
      target =
        listOf(Practitioner::class, Patient::class, PractitionerRole::class, RelatedPerson::class),
      extractor = { resource -> listOfNotNull(resource.recorder) },
    )

  public val resultingcondition: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "resultingcondition",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.resultingCondition",
      target = listOf(Condition::class),
      extractor = { resource -> resource.resultingCondition },
    )

  public val seriousness: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam(
      name = "seriousness",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.seriousness",
      extractor = { resource -> listOfNotNull(resource.seriousness) },
    )

  public val severity: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam(
      name = "severity",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.severity",
      extractor = { resource -> listOfNotNull(resource.severity) },
    )

  public val study: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "study",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.study",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> resource.study },
    )

  public val subject: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.subject",
      target = listOf(Practitioner::class, Group::class, Patient::class, RelatedPerson::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val substance: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "substance",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.suspectEntity.instance",
      target =
        listOf(
          Immunization::class,
          Device::class,
          Medication::class,
          Procedure::class,
          Substance::class,
          MedicationAdministration::class,
          MedicationStatement::class,
        ),
      extractor = { resource -> resource.suspectEntity.map { it.instance } },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<AdverseEvent, *>> = listOf()

  /**
   * Supported search parameters for the AdverseEvent resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<AdverseEvent, *>> =
    listOf(
      actuality,
      category,
      date,
      event,
      location,
      recorder,
      resultingcondition,
      seriousness,
      severity,
      study,
      subject,
      substance,
    )
}
