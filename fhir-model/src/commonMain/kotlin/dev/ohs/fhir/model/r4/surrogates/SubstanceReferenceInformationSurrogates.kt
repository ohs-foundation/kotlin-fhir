/*
 * Copyright 2026 Google LLC
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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4.surrogates

import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Range
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.SubstanceReferenceInformation
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubstanceReferenceInformationGeneSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var geneSequenceOrigin: CodeableConcept? = null,
  public var gene: CodeableConcept? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceReferenceInformation.Gene =
    SubstanceReferenceInformation.Gene(
      id = this@SubstanceReferenceInformationGeneSurrogate.id,
      extension = this@SubstanceReferenceInformationGeneSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceReferenceInformationGeneSurrogate.modifierExtension ?: listOf(),
      geneSequenceOrigin = this@SubstanceReferenceInformationGeneSurrogate.geneSequenceOrigin,
      gene = this@SubstanceReferenceInformationGeneSurrogate.gene,
      source = this@SubstanceReferenceInformationGeneSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceReferenceInformation.Gene
    ): SubstanceReferenceInformationGeneSurrogate =
      with(model) {
        SubstanceReferenceInformationGeneSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          geneSequenceOrigin = this@with.geneSequenceOrigin,
          gene = this@with.gene,
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceReferenceInformationGeneElementSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var element: Identifier? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceReferenceInformation.GeneElement =
    SubstanceReferenceInformation.GeneElement(
      id = this@SubstanceReferenceInformationGeneElementSurrogate.id,
      extension = this@SubstanceReferenceInformationGeneElementSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceReferenceInformationGeneElementSurrogate.modifierExtension ?: listOf(),
      type = this@SubstanceReferenceInformationGeneElementSurrogate.type,
      element = this@SubstanceReferenceInformationGeneElementSurrogate.element,
      source = this@SubstanceReferenceInformationGeneElementSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceReferenceInformation.GeneElement
    ): SubstanceReferenceInformationGeneElementSurrogate =
      with(model) {
        SubstanceReferenceInformationGeneElementSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          element = this@with.element,
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceReferenceInformationClassificationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var domain: CodeableConcept? = null,
  public var classification: CodeableConcept? = null,
  public var subtype: List<CodeableConcept>? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceReferenceInformation.Classification =
    SubstanceReferenceInformation.Classification(
      id = this@SubstanceReferenceInformationClassificationSurrogate.id,
      extension = this@SubstanceReferenceInformationClassificationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceReferenceInformationClassificationSurrogate.modifierExtension ?: listOf(),
      domain = this@SubstanceReferenceInformationClassificationSurrogate.domain,
      classification = this@SubstanceReferenceInformationClassificationSurrogate.classification,
      subtype = this@SubstanceReferenceInformationClassificationSurrogate.subtype ?: listOf(),
      source = this@SubstanceReferenceInformationClassificationSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceReferenceInformation.Classification
    ): SubstanceReferenceInformationClassificationSurrogate =
      with(model) {
        SubstanceReferenceInformationClassificationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          domain = this@with.domain,
          classification = this@with.classification,
          subtype = this@with.subtype.takeIf { it.isNotEmpty() },
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceReferenceInformationTargetSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var target: Identifier? = null,
  public var type: CodeableConcept? = null,
  public var interaction: CodeableConcept? = null,
  public var organism: CodeableConcept? = null,
  public var organismType: CodeableConcept? = null,
  public var amount: SubstanceReferenceInformation.Target.Amount? = null,
  public var amountType: CodeableConcept? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceReferenceInformation.Target =
    SubstanceReferenceInformation.Target(
      id = this@SubstanceReferenceInformationTargetSurrogate.id,
      extension = this@SubstanceReferenceInformationTargetSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceReferenceInformationTargetSurrogate.modifierExtension ?: listOf(),
      target = this@SubstanceReferenceInformationTargetSurrogate.target,
      type = this@SubstanceReferenceInformationTargetSurrogate.type,
      interaction = this@SubstanceReferenceInformationTargetSurrogate.interaction,
      organism = this@SubstanceReferenceInformationTargetSurrogate.organism,
      organismType = this@SubstanceReferenceInformationTargetSurrogate.organismType,
      amount = this@SubstanceReferenceInformationTargetSurrogate.amount,
      amountType = this@SubstanceReferenceInformationTargetSurrogate.amountType,
      source = this@SubstanceReferenceInformationTargetSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceReferenceInformation.Target
    ): SubstanceReferenceInformationTargetSurrogate =
      with(model) {
        SubstanceReferenceInformationTargetSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          target = this@with.target,
          type = this@with.type,
          interaction = this@with.interaction,
          organism = this@with.organism,
          organismType = this@with.organismType,
          amount = this@with.amount,
          amountType = this@with.amountType,
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceReferenceInformationTargetAmountSurrogate(
  public var amountQuantity: Quantity? = null,
  public var amountRange: Range? = null,
  public var amountString: KotlinString? = null,
  public var _amountString: Element? = null,
) {
  public fun toModel(): SubstanceReferenceInformation.Target.Amount =
    SubstanceReferenceInformation.Target.Amount.from(
      this@SubstanceReferenceInformationTargetAmountSurrogate.amountQuantity,
      this@SubstanceReferenceInformationTargetAmountSurrogate.amountRange,
      R4String.of(
        this@SubstanceReferenceInformationTargetAmountSurrogate.amountString,
        this@SubstanceReferenceInformationTargetAmountSurrogate._amountString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceReferenceInformation.Target.Amount
    ): SubstanceReferenceInformationTargetAmountSurrogate =
      with(model) {
        SubstanceReferenceInformationTargetAmountSurrogate(
          amountQuantity = this@with.asQuantity()?.value,
          amountRange = this@with.asRange()?.value,
          amountString = this@with.asString()?.value?.value,
          _amountString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceReferenceInformationSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
  public var gene: List<SubstanceReferenceInformation.Gene>? = null,
  public var geneElement: List<SubstanceReferenceInformation.GeneElement>? = null,
  public var classification: List<SubstanceReferenceInformation.Classification>? = null,
  public var target: List<SubstanceReferenceInformation.Target>? = null,
) {
  public fun toModel(): SubstanceReferenceInformation =
    SubstanceReferenceInformation(
      id = this@SubstanceReferenceInformationSurrogate.id,
      meta = this@SubstanceReferenceInformationSurrogate.meta,
      implicitRules =
        Uri.of(
          this@SubstanceReferenceInformationSurrogate.implicitRules,
          this@SubstanceReferenceInformationSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@SubstanceReferenceInformationSurrogate.language,
          this@SubstanceReferenceInformationSurrogate._language,
        ),
      text = this@SubstanceReferenceInformationSurrogate.text,
      contained = this@SubstanceReferenceInformationSurrogate.contained ?: listOf(),
      extension = this@SubstanceReferenceInformationSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceReferenceInformationSurrogate.modifierExtension ?: listOf(),
      comment =
        R4String.of(
          this@SubstanceReferenceInformationSurrogate.comment,
          this@SubstanceReferenceInformationSurrogate._comment,
        ),
      gene = this@SubstanceReferenceInformationSurrogate.gene ?: listOf(),
      geneElement = this@SubstanceReferenceInformationSurrogate.geneElement ?: listOf(),
      classification = this@SubstanceReferenceInformationSurrogate.classification ?: listOf(),
      target = this@SubstanceReferenceInformationSurrogate.target ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceReferenceInformation
    ): SubstanceReferenceInformationSurrogate =
      with(model) {
        SubstanceReferenceInformationSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
          gene = this@with.gene.takeIf { it.isNotEmpty() },
          geneElement = this@with.geneElement.takeIf { it.isNotEmpty() },
          classification = this@with.classification.takeIf { it.isNotEmpty() },
          target = this@with.target.takeIf { it.isNotEmpty() },
        )
      }
  }
}
