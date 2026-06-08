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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.MolecularSequence
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MolecularSequence] resource type. */
public object MolecularSequenceSearchParams {
  public val chromosome: SearchParam<MolecularSequence, CodeableConcept> =
    SearchParam(
      name = "chromosome",
      type = SearchParamType.Token,
      expression = "MolecularSequence.referenceSeq.chromosome",
      extractor = { resource -> listOfNotNull(resource.referenceSeq?.chromosome) },
    )

  public val chromosomeVariantCoordinate:
    SearchParam<MolecularSequence, MolecularSequence.Variant> =
    SearchParam(
      name = "chromosome-variant-coordinate",
      type = SearchParamType.Composite,
      expression = "MolecularSequence.variant",
      extractor = { resource -> resource.variant },
    )

  public val chromosomeWindowCoordinate:
    SearchParam<MolecularSequence, MolecularSequence.ReferenceSeq> =
    SearchParam(
      name = "chromosome-window-coordinate",
      type = SearchParamType.Composite,
      expression = "MolecularSequence.referenceSeq",
      extractor = { resource -> listOfNotNull(resource.referenceSeq) },
    )

  public val identifier: SearchParam<MolecularSequence, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "MolecularSequence.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<MolecularSequence, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "MolecularSequence.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOfNotNull(resource.patient) },
    )

  public val referenceseqid: SearchParam<MolecularSequence, CodeableConcept> =
    SearchParam(
      name = "referenceseqid",
      type = SearchParamType.Token,
      expression = "MolecularSequence.referenceSeq.referenceSeqId",
      extractor = { resource -> listOfNotNull(resource.referenceSeq?.referenceSeqId) },
    )

  public val referenceseqidVariantCoordinate:
    SearchParam<MolecularSequence, MolecularSequence.Variant> =
    SearchParam(
      name = "referenceseqid-variant-coordinate",
      type = SearchParamType.Composite,
      expression = "MolecularSequence.variant",
      extractor = { resource -> resource.variant },
    )

  public val referenceseqidWindowCoordinate:
    SearchParam<MolecularSequence, MolecularSequence.ReferenceSeq> =
    SearchParam(
      name = "referenceseqid-window-coordinate",
      type = SearchParamType.Composite,
      expression = "MolecularSequence.referenceSeq",
      extractor = { resource -> listOfNotNull(resource.referenceSeq) },
    )

  public val type: SearchParam<MolecularSequence, Any> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "MolecularSequence.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val variantEnd: SearchParam<MolecularSequence, Integer> =
    SearchParam(
      name = "variant-end",
      type = SearchParamType.Number,
      expression = "MolecularSequence.variant.end",
      extractor = { resource -> resource.variant.mapNotNull { it.end } },
    )

  public val variantStart: SearchParam<MolecularSequence, Integer> =
    SearchParam(
      name = "variant-start",
      type = SearchParamType.Number,
      expression = "MolecularSequence.variant.start",
      extractor = { resource -> resource.variant.mapNotNull { it.start } },
    )

  public val windowEnd: SearchParam<MolecularSequence, Integer> =
    SearchParam(
      name = "window-end",
      type = SearchParamType.Number,
      expression = "MolecularSequence.referenceSeq.windowEnd",
      extractor = { resource -> listOfNotNull(resource.referenceSeq?.windowEnd) },
    )

  public val windowStart: SearchParam<MolecularSequence, Integer> =
    SearchParam(
      name = "window-start",
      type = SearchParamType.Number,
      expression = "MolecularSequence.referenceSeq.windowStart",
      extractor = { resource -> listOfNotNull(resource.referenceSeq?.windowStart) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<MolecularSequence, *>> = listOf()

  /**
   * Supported search parameters for the MolecularSequence resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<MolecularSequence, *>> =
    listOf(
      chromosome,
      chromosomeVariantCoordinate,
      chromosomeWindowCoordinate,
      identifier,
      patient,
      referenceseqid,
      referenceseqidVariantCoordinate,
      referenceseqidWindowCoordinate,
      type,
      variantEnd,
      variantStart,
      windowEnd,
      windowStart,
    )
}
