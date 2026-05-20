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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.ImagingStudy
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImagingStudy] resource type. */
public sealed class ImagingStudySearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ImagingStudy): List<T>

  public data object BasedOn : ImagingStudySearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.basedOn"

    public override val target: List<String> =
      listOf("Appointment", "ServiceRequest", "CarePlan", "Task", "AppointmentResponse")

    public override fun extract(resource: ImagingStudy): List<Reference> = resource.basedOn
  }

  public data object BodySite : ImagingStudySearchParam<CodeableConcept>() {
    public override val paramName: String = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.bodySite.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<CodeableConcept> =
      resource.series.mapNotNull { it.bodySite }.mapNotNull { it.concept }
  }

  public data object BodyStructure : ImagingStudySearchParam<Reference>() {
    public override val paramName: String = "body-structure"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.series.bodySite.reference"

    public override val target: List<String> = listOf("BodyStructure")

    public override fun extract(resource: ImagingStudy): List<Reference> =
      resource.series.mapNotNull { it.bodySite }.mapNotNull { it.reference }
  }

  public data object DicomClass : ImagingStudySearchParam<Coding>() {
    public override val paramName: String = "dicom-class"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.instance.sopClass"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Coding> =
      resource.series.flatMap { it.instance }.map { it.sopClass }
  }

  public data object Encounter : ImagingStudySearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: ImagingStudy): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Endpoint : ImagingStudySearchParam<Reference>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: ImagingStudy): List<Reference> = resource.endpoint
  }

  public data object Identifier : ImagingStudySearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Instance : ImagingStudySearchParam<Id>() {
    public override val paramName: String = "instance"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.instance.uid"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Id> =
      resource.series.flatMap { it.instance }.map { it.uid }
  }

  public data object Modality : ImagingStudySearchParam<CodeableConcept>() {
    public override val paramName: String = "modality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.modality"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<CodeableConcept> =
      resource.series.map { it.modality }
  }

  public data object Patient : ImagingStudySearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ImagingStudy): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : ImagingStudySearchParam<Reference>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.series.performer.actor"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "Organization",
        "CareTeam",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: ImagingStudy): List<Reference> =
      resource.series.flatMap { it.performer }.map { it.actor }
  }

  public data object Reason : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = ""

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Referrer : ImagingStudySearchParam<Reference>() {
    public override val paramName: String = "referrer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.referrer"

    public override val target: List<String> = listOf("PractitionerRole", "Practitioner")

    public override fun extract(resource: ImagingStudy): List<Reference> =
      listOfNotNull(resource.referrer)
  }

  public data object Series : ImagingStudySearchParam<Id>() {
    public override val paramName: String = "series"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.uid"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Id> = resource.series.map { it.uid }
  }

  public data object Started : ImagingStudySearchParam<DateTime>() {
    public override val paramName: String = "started"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ImagingStudy.started"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<DateTime> =
      listOfNotNull(resource.started)
  }

  public data object Status : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = listOf(resource.status)
  }

  public data object Subject : ImagingStudySearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.subject"

    public override val target: List<String> = listOf("Device", "Group", "Patient")

    public override fun extract(resource: ImagingStudy): List<Reference> = listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the ImagingStudy resource type. */
    public val ALL: List<ImagingStudySearchParam<*>> =
      listOf(
        BasedOn,
        BodySite,
        BodyStructure,
        DicomClass,
        Encounter,
        Endpoint,
        Identifier,
        Instance,
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
  }
}
