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
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.MolecularSequence
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [MolecularSequence] resource type. */
public object MolecularSequenceSearchParam {
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

  public data object Chromosome : SearchParam<MolecularSequence, CodeableConcept> {
    public override val paramName: String = "chromosome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MolecularSequence.referenceSeq.chromosome"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<CodeableConcept> =
      listOfNotNull(resource.referenceSeq?.chromosome)
  }

  public data object ChromosomeVariantCoordinate :
    SearchParam<MolecularSequence, MolecularSequence.Variant> {
    public override val paramName: String = "chromosome-variant-coordinate"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "MolecularSequence.variant"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<MolecularSequence.Variant> =
      resource.variant
  }

  public data object ChromosomeWindowCoordinate :
    SearchParam<MolecularSequence, MolecularSequence.ReferenceSeq> {
    public override val paramName: String = "chromosome-window-coordinate"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "MolecularSequence.referenceSeq"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<MolecularSequence.ReferenceSeq> =
      listOfNotNull(resource.referenceSeq)
  }

  public data object Identifier :
    SearchParam<MolecularSequence, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MolecularSequence.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MolecularSequence
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Patient : SearchParam<MolecularSequence, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MolecularSequence.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: MolecularSequence): List<Reference> =
      listOfNotNull(resource.patient)
  }

  public data object Referenceseqid : SearchParam<MolecularSequence, CodeableConcept> {
    public override val paramName: String = "referenceseqid"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MolecularSequence.referenceSeq.referenceSeqId"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<CodeableConcept> =
      listOfNotNull(resource.referenceSeq?.referenceSeqId)
  }

  public data object ReferenceseqidVariantCoordinate :
    SearchParam<MolecularSequence, MolecularSequence.Variant> {
    public override val paramName: String = "referenceseqid-variant-coordinate"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "MolecularSequence.variant"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<MolecularSequence.Variant> =
      resource.variant
  }

  public data object ReferenceseqidWindowCoordinate :
    SearchParam<MolecularSequence, MolecularSequence.ReferenceSeq> {
    public override val paramName: String = "referenceseqid-window-coordinate"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "MolecularSequence.referenceSeq"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<MolecularSequence.ReferenceSeq> =
      listOfNotNull(resource.referenceSeq)
  }

  public data object Type : SearchParam<MolecularSequence, Any> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MolecularSequence.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<Any> =
      listOfNotNull(resource.type)
  }

  public data object VariantEnd : SearchParam<MolecularSequence, Integer> {
    public override val paramName: String = "variant-end"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "MolecularSequence.variant.end"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<Integer> =
      resource.variant.mapNotNull { it.end }
  }

  public data object VariantStart : SearchParam<MolecularSequence, Integer> {
    public override val paramName: String = "variant-start"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "MolecularSequence.variant.start"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<Integer> =
      resource.variant.mapNotNull { it.start }
  }

  public data object WindowEnd : SearchParam<MolecularSequence, Integer> {
    public override val paramName: String = "window-end"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "MolecularSequence.referenceSeq.windowEnd"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<Integer> =
      listOfNotNull(resource.referenceSeq?.windowEnd)
  }

  public data object WindowStart : SearchParam<MolecularSequence, Integer> {
    public override val paramName: String = "window-start"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "MolecularSequence.referenceSeq.windowStart"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MolecularSequence): List<Integer> =
      listOfNotNull(resource.referenceSeq?.windowStart)
  }
}
