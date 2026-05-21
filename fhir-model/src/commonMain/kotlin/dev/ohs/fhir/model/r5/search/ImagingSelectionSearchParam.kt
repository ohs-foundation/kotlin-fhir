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

import dev.ohs.fhir.model.r5.Appointment
import dev.ohs.fhir.model.r5.AppointmentResponse
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.ImagingSelection
import dev.ohs.fhir.model.r5.ImagingStudy
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.Task
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [ImagingSelection] resource type. */
public object ImagingSelectionSearchParam {
  /** All search parameters for the ImagingSelection resource type. */
  public val ALL: List<SearchParam<ImagingSelection, *>> =
    listOf(
      BasedOn,
      BodySite,
      BodyStructure,
      Code,
      DerivedFrom,
      Identifier,
      Issued,
      Patient,
      Status,
      StudyUid,
      Subject,
    )

  public data object BasedOn : SearchParam<ImagingSelection, Reference> {
    public override val name: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Appointment::class,
        ServiceRequest::class,
        CarePlan::class,
        Task::class,
        AppointmentResponse::class,
      )

    public override fun extract(resource: ImagingSelection): List<Reference> = resource.basedOn
  }

  public data object BodySite : SearchParam<ImagingSelection, CodeableConcept> {
    public override val name: String = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.bodySite.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingSelection): List<CodeableConcept> =
      listOfNotNull(resource.bodySite?.concept)
  }

  public data object BodyStructure : SearchParam<ImagingSelection, Reference> {
    public override val name: String = "body-structure"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.bodySite.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.BodyStructure::class)

    public override fun extract(resource: ImagingSelection): List<Reference> =
      listOfNotNull(resource.bodySite?.reference)
  }

  public data object Code : SearchParam<ImagingSelection, Any> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingSelection): List<Any> = listOf(resource.status)
  }

  public data object DerivedFrom : SearchParam<ImagingSelection, Reference> {
    public override val name: String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.derivedFrom"

    public override val target: List<KClass<out Resource>> =
      listOf(ImagingStudy::class, DocumentReference::class)

    public override fun extract(resource: ImagingSelection): List<Reference> = resource.derivedFrom
  }

  public data object Identifier : SearchParam<ImagingSelection, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: ImagingSelection
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Issued : SearchParam<ImagingSelection, Instant> {
    public override val name: String = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ImagingSelection.issued"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingSelection): List<Instant> =
      listOfNotNull(resource.issued)
  }

  public data object Patient : SearchParam<ImagingSelection, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: ImagingSelection): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Status : SearchParam<ImagingSelection, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingSelection): List<Any> = listOf(resource.status)
  }

  public data object StudyUid : SearchParam<ImagingSelection, Id> {
    public override val name: String = "study-uid"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.studyUid"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingSelection): List<Id> =
      listOfNotNull(resource.studyUid)
  }

  public data object Subject : SearchParam<ImagingSelection, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Device::class,
        Organization::class,
        Procedure::class,
        Group::class,
        Practitioner::class,
        Specimen::class,
        Substance::class,
        Location::class,
        dev.ohs.fhir.model.r5.Patient::class,
        Medication::class,
      )

    public override fun extract(resource: ImagingSelection): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
