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
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [AdverseEvent] resource type. */
public object AdverseEventSearchParam {
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

  public data object Actuality : SearchParam<AdverseEvent, Any> {
    public override val name: String = "actuality"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.actuality"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = listOf(resource.actuality)
  }

  public data object Category : SearchParam<AdverseEvent, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> = resource.category
  }

  public data object Code : SearchParam<AdverseEvent, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Date : SearchParam<AdverseEvent, Any> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "AdverseEvent.occurrence.ofType(dateTime)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = emptyList()
  }

  public data object Identifier : SearchParam<AdverseEvent, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Location : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Location::class)

    public override fun extract(resource: AdverseEvent): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object Patient : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: AdverseEvent): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Recorder : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "recorder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.recorder"

    public override val target: List<KClass<out Resource>> =
      listOf(
        RelatedPerson::class,
        PractitionerRole::class,
        ResearchSubject::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: AdverseEvent): List<Reference> =
      listOfNotNull(resource.recorder)
  }

  public data object Resultingeffect : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "resultingeffect"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.resultingEffect"

    public override val target: List<KClass<out Resource>> =
      listOf(Observation::class, Condition::class)

    public override fun extract(resource: AdverseEvent): List<Reference> = resource.resultingEffect
  }

  public data object Seriousness : SearchParam<AdverseEvent, CodeableConcept> {
    public override val name: String = "seriousness"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.seriousness"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<CodeableConcept> =
      listOfNotNull(resource.seriousness)
  }

  public data object Status : SearchParam<AdverseEvent, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "AdverseEvent.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: AdverseEvent): List<Any> = listOf(resource.status)
  }

  public data object Study : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "study"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.study"

    public override val target: List<KClass<out Resource>> = listOf(ResearchStudy::class)

    public override fun extract(resource: AdverseEvent): List<Reference> = resource.study
  }

  public data object Subject : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "AdverseEvent.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        RelatedPerson::class,
        ResearchSubject::class,
        Group::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: AdverseEvent): List<Reference> = listOf(resource.subject)
  }

  public data object Substance : SearchParam<AdverseEvent, Reference> {
    public override val name: String = "substance"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(AdverseEvent.suspectEntity.instance as Reference)"

    public override val target: List<KClass<out Resource>> =
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
      )

    public override fun extract(resource: AdverseEvent): List<Reference> =
      resource.suspectEntity.mapNotNull {
        (it.instance as? AdverseEvent.SuspectEntity.Instance.Reference)?.value
      }
  }
}
