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

import dev.ohs.fhir.model.r5.AllergyIntolerance
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [AllergyIntolerance] resource type. */
public object AllergyIntoleranceSearchParam {
  /** All search parameters for the AllergyIntolerance resource type. */
  public val ALL: List<SearchParam<AllergyIntolerance, *>> =
    listOf(
      Category,
      ClinicalStatus,
      Code,
      Criticality,
      Date,
      Identifier,
      LastDate,
      ManifestationCode,
      ManifestationReference,
      Participant,
      Patient,
      Route,
      Severity,
      Type,
      VerificationStatus,
    )

  public data object Category : SearchParam<AllergyIntolerance, Any> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> = resource.category
  }

  public data object ClinicalStatus : SearchParam<AllergyIntolerance, CodeableConcept> {
    public override val paramName: String = "clinical-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.clinicalStatus"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      listOfNotNull(resource.clinicalStatus)
  }

  public data object Code : SearchParam<AllergyIntolerance, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Criticality : SearchParam<AllergyIntolerance, Any> {
    public override val paramName: String = "criticality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.criticality"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> =
      listOfNotNull(resource.criticality)
  }

  public data object Date : SearchParam<AllergyIntolerance, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AllergyIntolerance.recordedDate"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<DateTime> =
      listOfNotNull(resource.recordedDate)
  }

  public data object Identifier :
    SearchParam<AllergyIntolerance, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: AllergyIntolerance
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object LastDate : SearchParam<AllergyIntolerance, DateTime> {
    public override val paramName: String = "last-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AllergyIntolerance.lastOccurrence"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<DateTime> =
      listOfNotNull(resource.lastOccurrence)
  }

  public data object ManifestationCode : SearchParam<AllergyIntolerance, CodeableConcept> {
    public override val paramName: String = "manifestation-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.reaction.manifestation.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      resource.reaction.flatMap { it.manifestation }.mapNotNull { it.concept }
  }

  public data object ManifestationReference : SearchParam<AllergyIntolerance, Reference> {
    public override val paramName: String = "manifestation-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AllergyIntolerance.reaction.manifestation.reference"

    public override val target: List<KClass<out Resource>> = listOf(Observation::class)

    public override fun extract(resource: AllergyIntolerance): List<Reference> =
      resource.reaction.flatMap { it.manifestation }.mapNotNull { it.reference }
  }

  public data object Participant : SearchParam<AllergyIntolerance, Reference> {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AllergyIntolerance.participant.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Device::class,
        Organization::class,
        CareTeam::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: AllergyIntolerance): List<Reference> =
      resource.participant.map { it.actor }
  }

  public data object Patient : SearchParam<AllergyIntolerance, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AllergyIntolerance.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: AllergyIntolerance): List<Reference> =
      listOf(resource.patient)
  }

  public data object Route : SearchParam<AllergyIntolerance, CodeableConcept> {
    public override val paramName: String = "route"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.reaction.exposureRoute"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      resource.reaction.mapNotNull { it.exposureRoute }
  }

  public data object Severity : SearchParam<AllergyIntolerance, Any> {
    public override val paramName: String = "severity"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.reaction.severity"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<Any> =
      resource.reaction.mapNotNull { it.severity }
  }

  public data object Type : SearchParam<AllergyIntolerance, CodeableConcept> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object VerificationStatus : SearchParam<AllergyIntolerance, CodeableConcept> {
    public override val paramName: String = "verification-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AllergyIntolerance.verificationStatus"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AllergyIntolerance): List<CodeableConcept> =
      listOfNotNull(resource.verificationStatus)
  }
}
