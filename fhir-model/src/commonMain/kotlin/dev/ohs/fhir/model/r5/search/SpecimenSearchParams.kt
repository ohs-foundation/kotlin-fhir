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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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

  public val Bodysite: SearchParam<Specimen, Reference> =
    SimpleSearchParam<Specimen, Reference>(
      name = "bodysite",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.collection.bodySite.reference",
      target = listOf(BodyStructure::class),
      extractor = { resource -> listOfNotNull(resource.collection?.bodySite?.reference) },
    )

  public val Collected: SearchParam<Specimen, Any> =
    SimpleSearchParam<Specimen, Any>(
      name = "collected",
      type = SearchParamType.fromCode("date"),
      expression = "Specimen.collection.collected.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val Collector: SearchParam<Specimen, Reference> =
    SimpleSearchParam<Specimen, Reference>(
      name = "collector",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.collection.collector",
      target =
        listOf(
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.collection?.collector) },
    )

  public val ContainerDevice: SearchParam<Specimen, Reference> =
    SimpleSearchParam<Specimen, Reference>(
      name = "container-device",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.container.device.where(resolve() is Device)",
      target = listOf(Device::class),
      extractor = { resource ->
        resource.container
          .map { it.device }
          .filter { it.reference?.value?.toString()?.contains("Device/") == true }
      },
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
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Procedure: SearchParam<Specimen, Reference> =
    SimpleSearchParam<Specimen, Reference>(
      name = "procedure",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.collection.procedure",
      target = listOf(dev.ohs.fhir.model.r5.Procedure::class),
      extractor = { resource -> listOfNotNull(resource.collection?.procedure) },
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
          Device::class,
          Group::class,
          BiologicallyDerivedProduct::class,
          Substance::class,
          Location::class,
          dev.ohs.fhir.model.r5.Patient::class,
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
      ContainerDevice,
      Identifier,
      Parent,
      Patient,
      Procedure,
      Status,
      Subject,
      Type,
    )
}
