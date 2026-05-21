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

import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.VisionPrescription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [VisionPrescription] resource type. */
public object VisionPrescriptionSearchParam {
  /** All search parameters for the VisionPrescription resource type. */
  public val ALL: List<SearchParam<VisionPrescription, *>> =
    listOf(Datewritten, Encounter, Identifier, Patient, Prescriber, Status)

  public data object Datewritten : SearchParam<VisionPrescription, DateTime> {
    public override val paramName: String = "datewritten"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "VisionPrescription.dateWritten"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: VisionPrescription): List<DateTime> =
      listOf(resource.dateWritten)
  }

  public data object Encounter : SearchParam<VisionPrescription, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VisionPrescription.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Encounter::class, EpisodeOfCare::class)

    public override fun extract(resource: VisionPrescription): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier :
    SearchParam<VisionPrescription, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "VisionPrescription.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: VisionPrescription
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Patient : SearchParam<VisionPrescription, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VisionPrescription.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

    public override fun extract(resource: VisionPrescription): List<Reference> =
      listOf(resource.patient)
  }

  public data object Prescriber : SearchParam<VisionPrescription, Reference> {
    public override val paramName: String = "prescriber"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VisionPrescription.prescriber"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, PractitionerRole::class)

    public override fun extract(resource: VisionPrescription): List<Reference> =
      listOf(resource.prescriber)
  }

  public data object Status : SearchParam<VisionPrescription, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "VisionPrescription.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: VisionPrescription): List<Any> = listOf(resource.status)
  }
}
