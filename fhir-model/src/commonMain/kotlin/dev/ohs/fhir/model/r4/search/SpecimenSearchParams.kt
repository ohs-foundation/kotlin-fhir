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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Specimen
import dev.ohs.fhir.model.r4.Substance
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Specimen] resource type. */
public object SpecimenSearchParams {
  public val accession: SearchParam<Specimen, Identifier> =
    SearchParam(
      name = "accession",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.accessionIdentifier",
      extractor = { resource -> listOfNotNull(resource.accessionIdentifier) },
    )

  public val bodysite: SearchParam<Specimen, CodeableConcept> =
    SearchParam(
      name = "bodysite",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.collection.bodySite",
      extractor = { resource -> listOfNotNull(resource.collection?.bodySite) },
    )

  public val collected: SearchParam<Specimen, Specimen.Collection.Collected> =
    SearchParam(
      name = "collected",
      type = SearchParamType.fromCode("date"),
      expression = "Specimen.collection.collected",
      extractor = { resource -> listOfNotNull(resource.collection?.collected) },
    )

  public val collector: SearchParam<Specimen, Reference> =
    SearchParam(
      name = "collector",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.collection.collector",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.collection?.collector) },
    )

  public val container: SearchParam<Specimen, CodeableConcept> =
    SearchParam(
      name = "container",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.container.type",
      extractor = { resource -> resource.container.mapNotNull { it.type } },
    )

  public val containerId: SearchParam<Specimen, Identifier> =
    SearchParam(
      name = "container-id",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.container.identifier",
      extractor = { resource -> resource.container.flatMap { it.identifier } },
    )

  public val identifier: SearchParam<Specimen, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val parent: SearchParam<Specimen, Reference> =
    SearchParam(
      name = "parent",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.parent",
      target = listOf(Specimen::class),
      extractor = { resource -> resource.parent },
    )

  public val patient: SearchParam<Specimen, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val status: SearchParam<Specimen, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val subject: SearchParam<Specimen, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.subject",
      target =
        listOf(Group::class, Device::class, Patient::class, Substance::class, Location::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val type: SearchParam<Specimen, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /** All search parameters for the Specimen resource type. */
  public val all: List<SearchParam<Specimen, *>> =
    listOf(
      accession,
      bodysite,
      collected,
      collector,
      container,
      containerId,
      identifier,
      parent,
      patient,
      status,
      subject,
      type,
    )
}
