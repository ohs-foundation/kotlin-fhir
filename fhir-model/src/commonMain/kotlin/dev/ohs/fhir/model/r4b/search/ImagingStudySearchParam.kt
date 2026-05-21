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

import dev.ohs.fhir.model.r4b.Appointment
import dev.ohs.fhir.model.r4b.AppointmentResponse
import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CareTeam
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.ImagingStudy
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Task
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [ImagingStudy] resource type. */
public object ImagingStudySearchParam {
  /** All search parameters for the ImagingStudy resource type. */
  public val ALL: List<SearchParam<ImagingStudy, *>> =
    listOf(
      Basedon,
      Bodysite,
      DicomClass,
      Encounter,
      Endpoint,
      Identifier,
      Instance,
      Interpreter,
      Modality,
      Patient,
      Performer,
      Reason,
      Referrer,
      Series,
      Started,
      Status,
      Subject,
    )

  public data object Basedon : SearchParam<ImagingStudy, Reference> {
    public override val paramName: String = "basedon"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Appointment::class,
        AppointmentResponse::class,
        CarePlan::class,
        Task::class,
        ServiceRequest::class,
      )

    public override fun extract(resource: ImagingStudy): List<Reference> = resource.basedOn
  }

  public data object Bodysite : SearchParam<ImagingStudy, Coding> {
    public override val paramName: String = "bodysite"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.bodySite"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Coding> =
      resource.series.mapNotNull { it.bodySite }
  }

  public data object DicomClass : SearchParam<ImagingStudy, Coding> {
    public override val paramName: String = "dicom-class"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.instance.sopClass"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Coding> =
      resource.series.flatMap { it.instance }.map { it.sopClass }
  }

  public data object Encounter : SearchParam<ImagingStudy, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Encounter::class)

    public override fun extract(resource: ImagingStudy): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Endpoint : SearchParam<ImagingStudy, Reference> {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.endpoint"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Endpoint::class)

    public override fun extract(resource: ImagingStudy): List<Reference> = resource.endpoint
  }

  public data object Identifier : SearchParam<ImagingStudy, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingStudy): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Instance : SearchParam<ImagingStudy, Id> {
    public override val paramName: String = "instance"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.instance.uid"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Id> =
      resource.series.flatMap { it.instance }.map { it.uid }
  }

  public data object Interpreter : SearchParam<ImagingStudy, Reference> {
    public override val paramName: String = "interpreter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.interpreter"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, PractitionerRole::class)

    public override fun extract(resource: ImagingStudy): List<Reference> = resource.interpreter
  }

  public data object Modality : SearchParam<ImagingStudy, Coding> {
    public override val paramName: String = "modality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.modality"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Coding> =
      resource.series.map { it.modality }
  }

  public data object Patient : SearchParam<ImagingStudy, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: ImagingStudy): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<ImagingStudy, Reference> {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.series.performer.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        CareTeam::class,
        Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: ImagingStudy): List<Reference> =
      resource.series.flatMap { it.performer }.map { it.actor }
  }

  public data object Reason : SearchParam<ImagingStudy, CodeableConcept> {
    public override val paramName: String = "reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.reasonCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingStudy): List<CodeableConcept> = resource.reasonCode
  }

  public data object Referrer : SearchParam<ImagingStudy, Reference> {
    public override val paramName: String = "referrer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.referrer"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, PractitionerRole::class)

    public override fun extract(resource: ImagingStudy): List<Reference> =
      listOfNotNull(resource.referrer)
  }

  public data object Series : SearchParam<ImagingStudy, Id> {
    public override val paramName: String = "series"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.uid"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Id> = resource.series.map { it.uid }
  }

  public data object Started : SearchParam<ImagingStudy, DateTime> {
    public override val paramName: String = "started"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ImagingStudy.started"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingStudy): List<DateTime> =
      listOfNotNull(resource.started)
  }

  public data object Status : SearchParam<ImagingStudy, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<ImagingStudy, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, Device::class, dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: ImagingStudy): List<Reference> = listOf(resource.subject)
  }
}
