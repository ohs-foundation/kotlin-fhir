/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImagingStudy] resource type. */
public sealed class ImagingStudySearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ImagingStudy): List<T>

  public data object Basedon : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "basedon"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.basedOn"

    public override val target: List<String> =
      listOf("Appointment", "AppointmentResponse", "CarePlan", "Task", "ServiceRequest")

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Bodysite : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "bodysite"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.bodySite"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object DicomClass : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "dicom-class"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.instance.sopClass"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Encounter : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Endpoint : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Identifier : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Instance : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "instance"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.instance.uid"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Interpreter : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "interpreter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.interpreter"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Modality : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "modality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.modality"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Patient : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Performer : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.series.performer.actor"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "CareTeam",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Reason : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.reasonCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Referrer : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "referrer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.referrer"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Series : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "series"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.series.uid"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Started : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "started"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ImagingStudy.started"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Status : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingStudy.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public data object Subject : ImagingStudySearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingStudy.subject"

    public override val target: List<String> = listOf("Group", "Device", "Patient")

    public override fun extract(resource: ImagingStudy): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the ImagingStudy resource type. */
    public val ALL: List<ImagingStudySearchParam<*>> =
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
  }
}
