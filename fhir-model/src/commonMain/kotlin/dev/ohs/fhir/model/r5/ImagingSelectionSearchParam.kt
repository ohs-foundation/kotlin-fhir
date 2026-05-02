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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImagingSelection] resource type. */
public sealed class ImagingSelectionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ImagingSelection): List<T>

  public data object BasedOn : ImagingSelectionSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.basedOn"

    public override val target: List<String> =
      listOf("Appointment", "ServiceRequest", "CarePlan", "Task", "AppointmentResponse")

    public override fun extract(resource: ImagingSelection): List<Reference> = resource.basedOn
  }

  public data object BodySite : ImagingSelectionSearchParam<CodeableConcept>() {
    public override val paramName: String = "body-site"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.bodySite.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingSelection): List<CodeableConcept> =
      listOfNotNull(resource.bodySite?.concept)
  }

  public data object BodyStructure : ImagingSelectionSearchParam<Reference>() {
    public override val paramName: String = "body-structure"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.bodySite.reference"

    public override val target: List<String> = listOf("BodyStructure")

    public override fun extract(resource: ImagingSelection): List<Reference> =
      listOfNotNull(resource.bodySite?.reference)
  }

  public data object Code : ImagingSelectionSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingSelection): List<Any> = listOf(resource.status)
  }

  public data object DerivedFrom : ImagingSelectionSearchParam<Reference>() {
    public override val paramName: String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.derivedFrom"

    public override val target: List<String> = listOf("ImagingStudy", "DocumentReference")

    public override fun extract(resource: ImagingSelection): List<Reference> = resource.derivedFrom
  }

  public data object Identifier : ImagingSelectionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ImagingSelection
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Issued : ImagingSelectionSearchParam<Instant>() {
    public override val paramName: String = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ImagingSelection.issued"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingSelection): List<Instant> =
      listOfNotNull(resource.issued)
  }

  public data object Patient : ImagingSelectionSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ImagingSelection): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Status : ImagingSelectionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingSelection): List<Any> = listOf(resource.status)
  }

  public data object StudyUid : ImagingSelectionSearchParam<Id>() {
    public override val paramName: String = "study-uid"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImagingSelection.studyUid"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImagingSelection): List<Id> =
      listOfNotNull(resource.studyUid)
  }

  public data object Subject : ImagingSelectionSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImagingSelection.subject"

    public override val target: List<String> =
      listOf(
        "Device",
        "Organization",
        "Procedure",
        "Group",
        "Practitioner",
        "Specimen",
        "Substance",
        "Location",
        "Patient",
        "Medication",
      )

    public override fun extract(resource: ImagingSelection): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public companion object {
    /** All search parameters for the ImagingSelection resource type. */
    public val ALL: List<ImagingSelectionSearchParam<*>> =
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
  }
}
