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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Specimen
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Specimen] resource type. */
public object SpecimenSearchParam {
  /** All search parameters for the Specimen resource type. */
  public val ALL: List<SearchParam<Specimen, *>> =
    listOf(
      Accession,
      Bodysite,
      Collected,
      Collector,
      Container,
      ContainerId,
      Identifier,
      Parent,
      Patient,
      Status,
      Subject,
      Type,
    )

  public data object Accession : SearchParam<Specimen, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "accession"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.accessionIdentifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<dev.ohs.fhir.model.r4b.Identifier> =
      listOfNotNull(resource.accessionIdentifier)
  }

  public data object Bodysite : SearchParam<Specimen, CodeableConcept> {
    public override val paramName: String = "bodysite"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.collection.bodySite"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<CodeableConcept> =
      listOfNotNull(resource.collection?.bodySite)
  }

  public data object Collected : SearchParam<Specimen, Specimen.Collection.Collected> {
    public override val paramName: String = "collected"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Specimen.collection.collected"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<Specimen.Collection.Collected> =
      listOfNotNull(resource.collection?.collected)
  }

  public data object Collector : SearchParam<Specimen, Reference> {
    public override val paramName: String = "collector"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.collection.collector"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, PractitionerRole::class)

    public override fun extract(resource: Specimen): List<Reference> =
      listOfNotNull(resource.collection?.collector)
  }

  public data object Container : SearchParam<Specimen, CodeableConcept> {
    public override val paramName: String = "container"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.container.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<CodeableConcept> =
      resource.container.mapNotNull { it.type }
  }

  public data object ContainerId : SearchParam<Specimen, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "container-id"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.container.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.container.flatMap { it.identifier }
  }

  public data object Identifier : SearchParam<Specimen, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Parent : SearchParam<Specimen, Reference> {
    public override val paramName: String = "parent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.parent"

    public override val target: List<KClass<out Resource>> = listOf(Specimen::class)

    public override fun extract(resource: Specimen): List<Reference> = resource.parent
  }

  public data object Patient : SearchParam<Specimen, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: Specimen): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Status : SearchParam<Specimen, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<Any> = listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<Specimen, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Group::class,
        Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        Substance::class,
        Location::class,
      )

    public override fun extract(resource: Specimen): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : SearchParam<Specimen, CodeableConcept> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }
}
