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
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
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

  public val bodysite: SearchParam<Specimen, Reference> =
    SearchParam(
      name = "bodysite",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.collection.bodySite.reference",
      target = listOf(BodyStructure::class),
      extractor = { resource -> listOfNotNull(resource.collection?.bodySite?.reference) },
    )

  public val collected: SearchParam<Specimen, Any> =
    SearchParam(
      name = "collected",
      type = SearchParamType.fromCode("date"),
      expression = "Specimen.collection.collected.ofType(dateTime)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'collected' has expression 'Specimen.collection.collected.ofType(dateTime)' which is not yet supported."
        )
      },
    )

  public val collector: SearchParam<Specimen, Reference> =
    SearchParam(
      name = "collector",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.collection.collector",
      target =
        listOf(RelatedPerson::class, PractitionerRole::class, Practitioner::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.collection?.collector) },
    )

  public val containerDevice: SearchParam<Specimen, Reference> =
    SearchParam(
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

  public val procedure: SearchParam<Specimen, Reference> =
    SearchParam(
      name = "procedure",
      type = SearchParamType.fromCode("reference"),
      expression = "Specimen.collection.procedure",
      target = listOf(Procedure::class),
      extractor = { resource -> listOfNotNull(resource.collection?.procedure) },
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
        listOf(
          Device::class,
          Group::class,
          BiologicallyDerivedProduct::class,
          Substance::class,
          Location::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val type: SearchParam<Specimen, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Specimen.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Specimen, *>> = listOf(collected)

  /**
   * Supported search parameters for the Specimen resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Specimen, *>> =
    listOf(
      accession,
      bodysite,
      collector,
      containerDevice,
      identifier,
      parent,
      patient,
      procedure,
      status,
      subject,
      type,
    )
}
