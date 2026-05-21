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

import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.BodyStructure
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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
      ContainerDevice,
      Identifier,
      Parent,
      Patient,
      Procedure,
      Status,
      Subject,
      Type,
    )

  public data object Accession : SearchParam<Specimen, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "accession"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.accessionIdentifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<dev.ohs.fhir.model.r5.Identifier> =
      listOfNotNull(resource.accessionIdentifier)
  }

  public data object Bodysite : SearchParam<Specimen, Reference> {
    public override val name: String = "bodysite"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.collection.bodySite.reference"

    public override val target: List<KClass<out Resource>> = listOf(BodyStructure::class)

    public override fun extract(resource: Specimen): List<Reference> =
      listOfNotNull(resource.collection?.bodySite?.reference)
  }

  public data object Collected : SearchParam<Specimen, Any> {
    public override val name: String = "collected"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Specimen.collection.collected.ofType(dateTime)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<Any> = emptyList()
  }

  public data object Collector : SearchParam<Specimen, Reference> {
    public override val name: String = "collector"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.collection.collector"

    public override val target: List<KClass<out Resource>> =
      listOf(
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: Specimen): List<Reference> =
      listOfNotNull(resource.collection?.collector)
  }

  public data object ContainerDevice : SearchParam<Specimen, Reference> {
    public override val name: String = "container-device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.container.device.where(resolve() is Device)"

    public override val target: List<KClass<out Resource>> = listOf(Device::class)

    public override fun extract(resource: Specimen): List<Reference> =
      resource.container
        .map { it.device }
        .filter { it.reference?.value?.toString()?.contains("Device/") == true }
  }

  public data object Identifier : SearchParam<Specimen, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Parent : SearchParam<Specimen, Reference> {
    public override val name: String = "parent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.parent"

    public override val target: List<KClass<out Resource>> = listOf(Specimen::class)

    public override fun extract(resource: Specimen): List<Reference> = resource.parent
  }

  public data object Patient : SearchParam<Specimen, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: Specimen): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Procedure : SearchParam<Specimen, Reference> {
    public override val name: String = "procedure"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.collection.procedure"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Procedure::class)

    public override fun extract(resource: Specimen): List<Reference> =
      listOfNotNull(resource.collection?.procedure)
  }

  public data object Status : SearchParam<Specimen, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<Any> = listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<Specimen, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Specimen.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Device::class,
        Group::class,
        BiologicallyDerivedProduct::class,
        Substance::class,
        Location::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: Specimen): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : SearchParam<Specimen, CodeableConcept> {
    public override val name: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Specimen.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Specimen): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }
}
