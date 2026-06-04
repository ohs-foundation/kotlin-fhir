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

import dev.ohs.fhir.model.r5.AdverseEvent
import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Immunization
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.MedicationStatement
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.ResearchSubject
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AdverseEvent] resource type. */
public object AdverseEventSearchParams {
  public val actuality: SearchParam<AdverseEvent, Any> =
    SearchParam<AdverseEvent, Any>(
      name = "actuality",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.actuality",
      extractor = { resource -> listOf(resource.actuality) },
    )

  public val category: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam<AdverseEvent, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam<AdverseEvent, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val date: SearchParam<AdverseEvent, Any> =
    SearchParam<AdverseEvent, Any>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "AdverseEvent.occurrence.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val identifier: SearchParam<AdverseEvent, Identifier> =
    SearchParam<AdverseEvent, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<AdverseEvent, Reference> =
    SearchParam<AdverseEvent, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.location",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val patient: SearchParam<AdverseEvent, Reference> =
    SearchParam<AdverseEvent, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val recorder: SearchParam<AdverseEvent, Reference> =
    SearchParam<AdverseEvent, Reference>(
      name = "recorder",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.recorder",
      target =
        listOf(
          RelatedPerson::class,
          PractitionerRole::class,
          ResearchSubject::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.recorder) },
    )

  public val resultingeffect: SearchParam<AdverseEvent, Reference> =
    SearchParam<AdverseEvent, Reference>(
      name = "resultingeffect",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.resultingEffect",
      target = listOf(Observation::class, Condition::class),
      extractor = { resource -> resource.resultingEffect },
    )

  public val seriousness: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam<AdverseEvent, CodeableConcept>(
      name = "seriousness",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.seriousness",
      extractor = { resource -> listOfNotNull(resource.seriousness) },
    )

  public val status: SearchParam<AdverseEvent, Any> =
    SearchParam<AdverseEvent, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val study: SearchParam<AdverseEvent, Reference> =
    SearchParam<AdverseEvent, Reference>(
      name = "study",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.study",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> resource.study },
    )

  public val subject: SearchParam<AdverseEvent, Reference> =
    SearchParam<AdverseEvent, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.subject",
      target =
        listOf(
          RelatedPerson::class,
          ResearchSubject::class,
          Group::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val substance: SearchParam<AdverseEvent, Reference> =
    SearchParam<AdverseEvent, Reference>(
      name = "substance",
      type = SearchParamType.fromCode("reference"),
      expression = "(AdverseEvent.suspectEntity.instance as Reference)",
      target =
        listOf(
          Device::class,
          Procedure::class,
          MedicationStatement::class,
          ResearchStudy::class,
          MedicationAdministration::class,
          BiologicallyDerivedProduct::class,
          Immunization::class,
          Substance::class,
          Medication::class,
        ),
      extractor = { resource ->
        resource.suspectEntity.mapNotNull {
          (it.instance as? AdverseEvent.SuspectEntity.Instance.Reference)?.value
        }
      },
    )

  /** All search parameters for the AdverseEvent resource type. */
  public val all: List<SearchParam<AdverseEvent, *>> =
    listOf(
      actuality,
      category,
      code,
      date,
      identifier,
      location,
      patient,
      recorder,
      resultingeffect,
      seriousness,
      status,
      study,
      subject,
      substance,
    )
}
