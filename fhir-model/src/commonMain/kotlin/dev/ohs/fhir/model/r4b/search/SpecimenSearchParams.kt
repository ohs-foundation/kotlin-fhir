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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Specimen
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Specimen] resource type. */
public object SpecimenSearchParams {
  public val Accession: SearchParam<Specimen, Identifier> =
    SimpleSearchParam<Specimen, Identifier>(
      name = "accession",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.accessionIdentifier",
      extractor = { resource -> listOfNotNull(resource.accessionIdentifier) },
    )

  public val Bodysite: SearchParam<Specimen, CodeableConcept> =
    SimpleSearchParam<Specimen, CodeableConcept>(
      name = "bodysite",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.collection.bodySite",
      extractor = { resource -> listOfNotNull(resource.collection?.bodySite) },
    )

  public val Collected: SearchParam<Specimen, Specimen.Collection.Collected> =
    SimpleSearchParam<Specimen, Specimen.Collection.Collected>(
      name = "collected",
      type = SearchParamType.fromCode("date"),
      expression = "Specimen.collection.collected",
      extractor = { resource -> listOfNotNull(resource.collection?.collected) },
    )

  public val Collector: SearchParam<Specimen, Reference> =
    SimpleSearchParam<Specimen, Reference>(
      name = "collector",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.collection.collector",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.collection?.collector) },
    )

  public val Container: SearchParam<Specimen, CodeableConcept> =
    SimpleSearchParam<Specimen, CodeableConcept>(
      name = "container",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.container.type",
      extractor = { resource -> resource.container.mapNotNull { it.type } },
    )

  public val ContainerId: SearchParam<Specimen, Identifier> =
    SimpleSearchParam<Specimen, Identifier>(
      name = "container-id",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.container.identifier",
      extractor = { resource -> resource.container.flatMap { it.identifier } },
    )

  public val Identifier: SearchParam<Specimen, Identifier> =
    SimpleSearchParam<Specimen, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Parent: SearchParam<Specimen, Reference> =
    SimpleSearchParam<Specimen, Reference>(
      name = "parent",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.parent",
      target = listOf(Specimen::class),
      extractor = { resource -> resource.parent },
    )

  public val Patient: SearchParam<Specimen, Reference> =
    SimpleSearchParam<Specimen, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Status: SearchParam<Specimen, Any> =
    SimpleSearchParam<Specimen, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Subject: SearchParam<Specimen, Reference> =
    SimpleSearchParam<Specimen, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.subject",
      target =
        listOf(
          Group::class,
          Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          Substance::class,
          Location::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val Type: SearchParam<Specimen, CodeableConcept> =
    SimpleSearchParam<Specimen, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

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
}
