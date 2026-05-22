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
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MolecularSequence] resource type. */
public object MolecularSequenceSearchParam {
  public val Chromosome: SearchParam<MolecularSequence, CodeableConcept> =
    SimpleSearchParam<MolecularSequence, CodeableConcept>(
      name = "chromosome",
      type = SearchParamType.fromCode("token"),
      expression = "MolecularSequence.referenceSeq.chromosome",
      extractor = { resource -> listOfNotNull(resource.referenceSeq?.chromosome) },
    )

  public val ChromosomeVariantCoordinate:
    SearchParam<MolecularSequence, MolecularSequence.Variant> =
    SimpleSearchParam<MolecularSequence, MolecularSequence.Variant>(
      name = "chromosome-variant-coordinate",
      type = SearchParamType.fromCode("composite"),
      expression = "MolecularSequence.variant",
      extractor = { resource -> resource.variant },
    )

  public val ChromosomeWindowCoordinate:
    SearchParam<MolecularSequence, MolecularSequence.ReferenceSeq> =
    SimpleSearchParam<MolecularSequence, MolecularSequence.ReferenceSeq>(
      name = "chromosome-window-coordinate",
      type = SearchParamType.fromCode("composite"),
      expression = "MolecularSequence.referenceSeq",
      extractor = { resource -> listOfNotNull(resource.referenceSeq) },
    )

  public val Identifier: SearchParam<MolecularSequence, Identifier> =
    SimpleSearchParam<MolecularSequence, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MolecularSequence.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<MolecularSequence, Reference> =
    SimpleSearchParam<MolecularSequence, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MolecularSequence.patient",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource -> listOfNotNull(resource.patient) },
    )

  public val Referenceseqid: SearchParam<MolecularSequence, CodeableConcept> =
    SimpleSearchParam<MolecularSequence, CodeableConcept>(
      name = "referenceseqid",
      type = SearchParamType.fromCode("token"),
      expression = "MolecularSequence.referenceSeq.referenceSeqId",
      extractor = { resource -> listOfNotNull(resource.referenceSeq?.referenceSeqId) },
    )

  public val ReferenceseqidVariantCoordinate:
    SearchParam<MolecularSequence, MolecularSequence.Variant> =
    SimpleSearchParam<MolecularSequence, MolecularSequence.Variant>(
      name = "referenceseqid-variant-coordinate",
      type = SearchParamType.fromCode("composite"),
      expression = "MolecularSequence.variant",
      extractor = { resource -> resource.variant },
    )

  public val ReferenceseqidWindowCoordinate:
    SearchParam<MolecularSequence, MolecularSequence.ReferenceSeq> =
    SimpleSearchParam<MolecularSequence, MolecularSequence.ReferenceSeq>(
      name = "referenceseqid-window-coordinate",
      type = SearchParamType.fromCode("composite"),
      expression = "MolecularSequence.referenceSeq",
      extractor = { resource -> listOfNotNull(resource.referenceSeq) },
    )

  public val Type: SearchParam<MolecularSequence, Any> =
    SimpleSearchParam<MolecularSequence, Any>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "MolecularSequence.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val VariantEnd: SearchParam<MolecularSequence, Integer> =
    SimpleSearchParam<MolecularSequence, Integer>(
      name = "variant-end",
      type = SearchParamType.fromCode("number"),
      expression = "MolecularSequence.variant.end",
      extractor = { resource -> resource.variant.mapNotNull { it.end } },
    )

  public val VariantStart: SearchParam<MolecularSequence, Integer> =
    SimpleSearchParam<MolecularSequence, Integer>(
      name = "variant-start",
      type = SearchParamType.fromCode("number"),
      expression = "MolecularSequence.variant.start",
      extractor = { resource -> resource.variant.mapNotNull { it.start } },
    )

  public val WindowEnd: SearchParam<MolecularSequence, Integer> =
    SimpleSearchParam<MolecularSequence, Integer>(
      name = "window-end",
      type = SearchParamType.fromCode("number"),
      expression = "MolecularSequence.referenceSeq.windowEnd",
      extractor = { resource -> listOfNotNull(resource.referenceSeq?.windowEnd) },
    )

  public val WindowStart: SearchParam<MolecularSequence, Integer> =
    SimpleSearchParam<MolecularSequence, Integer>(
      name = "window-start",
      type = SearchParamType.fromCode("number"),
      expression = "MolecularSequence.referenceSeq.windowStart",
      extractor = { resource -> listOfNotNull(resource.referenceSeq?.windowStart) },
    )

  /** All search parameters for the MolecularSequence resource type. */
  public val ALL: List<SearchParam<MolecularSequence, *>> =
    listOf(
      Chromosome,
      ChromosomeVariantCoordinate,
      ChromosomeWindowCoordinate,
      Identifier,
      Patient,
      Referenceseqid,
      ReferenceseqidVariantCoordinate,
      ReferenceseqidWindowCoordinate,
      Type,
      VariantEnd,
      VariantStart,
      WindowEnd,
      WindowStart,
    )
}
