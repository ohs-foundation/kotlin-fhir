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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

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
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AdverseEvent] resource type. */
public object AdverseEventSearchParams {
  public val actuality: SearchParam<AdverseEvent, Any> =
    SearchParam(
      name = "actuality",
      type = SearchParamType.Token,
      expression = "AdverseEvent.actuality",
      extractor = { resource -> listOf(resource.actuality) },
    )

  public val category: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "AdverseEvent.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "AdverseEvent.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val date: SearchParam<AdverseEvent, Any> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "AdverseEvent.occurrence.ofType(dateTime)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'date' has expression 'AdverseEvent.occurrence.ofType(dateTime)' which is not yet supported."
        )
      },
    )

  public val identifier: SearchParam<AdverseEvent, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "AdverseEvent.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.Reference,
      expression = "AdverseEvent.location",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val patient: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "AdverseEvent.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val recorder: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "recorder",
      type = SearchParamType.Reference,
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
    SearchParam(
      name = "resultingeffect",
      type = SearchParamType.Reference,
      expression = "AdverseEvent.resultingEffect",
      target = listOf(Observation::class, Condition::class),
      extractor = { resource -> resource.resultingEffect },
    )

  public val seriousness: SearchParam<AdverseEvent, CodeableConcept> =
    SearchParam(
      name = "seriousness",
      type = SearchParamType.Token,
      expression = "AdverseEvent.seriousness",
      extractor = { resource -> listOfNotNull(resource.seriousness) },
    )

  public val status: SearchParam<AdverseEvent, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "AdverseEvent.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val study: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "study",
      type = SearchParamType.Reference,
      expression = "AdverseEvent.study",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> resource.study },
    )

  public val subject: SearchParam<AdverseEvent, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
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
    SearchParam(
      name = "substance",
      type = SearchParamType.Reference,
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

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<AdverseEvent, *>> = listOf(date)

  /**
   * Supported search parameters for the AdverseEvent resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<AdverseEvent, *>> =
    listOf(
      actuality,
      category,
      code,
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
