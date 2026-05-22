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
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.MedicationStatement
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.ResearchSubject
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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

  public val Code: SearchParam<AdverseEvent, CodeableConcept> =
    SimpleSearchParam<AdverseEvent, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Date: SearchParam<AdverseEvent, Any> =
    SimpleSearchParam<AdverseEvent, Any>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "AdverseEvent.occurrence.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val Identifier: SearchParam<AdverseEvent, Identifier> =
    SimpleSearchParam<AdverseEvent, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Location: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.location",
      target = listOf(dev.ohs.fhir.model.r5.Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val Patient: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Recorder: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "recorder",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.recorder",
      target =
        listOf(
          RelatedPerson::class,
          PractitionerRole::class,
          ResearchSubject::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.recorder) },
    )

  public val Resultingeffect: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
      name = "resultingeffect",
      type = SearchParamType.fromCode("reference"),
      expression = "AdverseEvent.resultingEffect",
      target = listOf(Observation::class, Condition::class),
      extractor = { resource -> resource.resultingEffect },
    )

  public val Seriousness: SearchParam<AdverseEvent, CodeableConcept> =
    SimpleSearchParam<AdverseEvent, CodeableConcept>(
      name = "seriousness",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.seriousness",
      extractor = { resource -> listOfNotNull(resource.seriousness) },
    )

  public val Status: SearchParam<AdverseEvent, Any> =
    SimpleSearchParam<AdverseEvent, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "AdverseEvent.status",
      extractor = { resource -> listOf(resource.status) },
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
      target =
        listOf(
          RelatedPerson::class,
          ResearchSubject::class,
          Group::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val Substance: SearchParam<AdverseEvent, Reference> =
    SimpleSearchParam<AdverseEvent, Reference>(
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
          dev.ohs.fhir.model.r5.Substance::class,
          Medication::class,
        ),
      extractor = { resource ->
        resource.suspectEntity.mapNotNull {
          (it.instance as? AdverseEvent.SuspectEntity.Instance.Reference)?.value
        }
      },
    )

  /** All search parameters for the AdverseEvent resource type. */
  public val ALL: List<SearchParam<AdverseEvent, *>> =
    listOf(
      Actuality,
      Category,
      Code,
      Date,
      Identifier,
      Location,
      Patient,
      Recorder,
      Resultingeffect,
      Seriousness,
      Status,
      Study,
      Subject,
      Substance,
    )
}
