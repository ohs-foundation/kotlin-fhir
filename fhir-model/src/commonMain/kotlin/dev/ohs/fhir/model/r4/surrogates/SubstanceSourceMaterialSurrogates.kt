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
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.SubstanceSourceMaterial
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubstanceSourceMaterialFractionDescriptionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var fraction: KotlinString? = null,
  public var _fraction: Element? = null,
  public var materialType: CodeableConcept? = null,
) {
  public fun toModel(): SubstanceSourceMaterial.FractionDescription =
    SubstanceSourceMaterial.FractionDescription(
      id = this@SubstanceSourceMaterialFractionDescriptionSurrogate.id,
      extension = this@SubstanceSourceMaterialFractionDescriptionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSourceMaterialFractionDescriptionSurrogate.modifierExtension ?: listOf(),
      fraction =
        R4String.of(
          this@SubstanceSourceMaterialFractionDescriptionSurrogate.fraction,
          this@SubstanceSourceMaterialFractionDescriptionSurrogate._fraction,
        ),
      materialType = this@SubstanceSourceMaterialFractionDescriptionSurrogate.materialType,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSourceMaterial.FractionDescription
    ): SubstanceSourceMaterialFractionDescriptionSurrogate =
      with(model) {
        SubstanceSourceMaterialFractionDescriptionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          fraction = this@with.fraction?.value,
          _fraction = this@with.fraction?.toElement(),
          materialType = this@with.materialType,
        )
      }
  }
}

@Serializable
internal data class SubstanceSourceMaterialOrganismSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var family: CodeableConcept? = null,
  public var genus: CodeableConcept? = null,
  public var species: CodeableConcept? = null,
  public var intraspecificType: CodeableConcept? = null,
  public var intraspecificDescription: KotlinString? = null,
  public var _intraspecificDescription: Element? = null,
  public var author: List<SubstanceSourceMaterial.Organism.Author>? = null,
  public var hybrid: SubstanceSourceMaterial.Organism.Hybrid? = null,
  public var organismGeneral: SubstanceSourceMaterial.Organism.OrganismGeneral? = null,
) {
  public fun toModel(): SubstanceSourceMaterial.Organism =
    SubstanceSourceMaterial.Organism(
      id = this@SubstanceSourceMaterialOrganismSurrogate.id,
      extension = this@SubstanceSourceMaterialOrganismSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSourceMaterialOrganismSurrogate.modifierExtension ?: listOf(),
      family = this@SubstanceSourceMaterialOrganismSurrogate.family,
      genus = this@SubstanceSourceMaterialOrganismSurrogate.genus,
      species = this@SubstanceSourceMaterialOrganismSurrogate.species,
      intraspecificType = this@SubstanceSourceMaterialOrganismSurrogate.intraspecificType,
      intraspecificDescription =
        R4String.of(
          this@SubstanceSourceMaterialOrganismSurrogate.intraspecificDescription,
          this@SubstanceSourceMaterialOrganismSurrogate._intraspecificDescription,
        ),
      author = this@SubstanceSourceMaterialOrganismSurrogate.author ?: listOf(),
      hybrid = this@SubstanceSourceMaterialOrganismSurrogate.hybrid,
      organismGeneral = this@SubstanceSourceMaterialOrganismSurrogate.organismGeneral,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSourceMaterial.Organism
    ): SubstanceSourceMaterialOrganismSurrogate =
      with(model) {
        SubstanceSourceMaterialOrganismSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          family = this@with.family,
          genus = this@with.genus,
          species = this@with.species,
          intraspecificType = this@with.intraspecificType,
          intraspecificDescription = this@with.intraspecificDescription?.value,
          _intraspecificDescription = this@with.intraspecificDescription?.toElement(),
          author = this@with.author.takeIf { it.isNotEmpty() },
          hybrid = this@with.hybrid,
          organismGeneral = this@with.organismGeneral,
        )
      }
  }
}

@Serializable
internal data class SubstanceSourceMaterialOrganismAuthorSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var authorType: CodeableConcept? = null,
  public var authorDescription: KotlinString? = null,
  public var _authorDescription: Element? = null,
) {
  public fun toModel(): SubstanceSourceMaterial.Organism.Author =
    SubstanceSourceMaterial.Organism.Author(
      id = this@SubstanceSourceMaterialOrganismAuthorSurrogate.id,
      extension = this@SubstanceSourceMaterialOrganismAuthorSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSourceMaterialOrganismAuthorSurrogate.modifierExtension ?: listOf(),
      authorType = this@SubstanceSourceMaterialOrganismAuthorSurrogate.authorType,
      authorDescription =
        R4String.of(
          this@SubstanceSourceMaterialOrganismAuthorSurrogate.authorDescription,
          this@SubstanceSourceMaterialOrganismAuthorSurrogate._authorDescription,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSourceMaterial.Organism.Author
    ): SubstanceSourceMaterialOrganismAuthorSurrogate =
      with(model) {
        SubstanceSourceMaterialOrganismAuthorSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          authorType = this@with.authorType,
          authorDescription = this@with.authorDescription?.value,
          _authorDescription = this@with.authorDescription?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceSourceMaterialOrganismHybridSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var maternalOrganismId: KotlinString? = null,
  public var _maternalOrganismId: Element? = null,
  public var maternalOrganismName: KotlinString? = null,
  public var _maternalOrganismName: Element? = null,
  public var paternalOrganismId: KotlinString? = null,
  public var _paternalOrganismId: Element? = null,
  public var paternalOrganismName: KotlinString? = null,
  public var _paternalOrganismName: Element? = null,
  public var hybridType: CodeableConcept? = null,
) {
  public fun toModel(): SubstanceSourceMaterial.Organism.Hybrid =
    SubstanceSourceMaterial.Organism.Hybrid(
      id = this@SubstanceSourceMaterialOrganismHybridSurrogate.id,
      extension = this@SubstanceSourceMaterialOrganismHybridSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSourceMaterialOrganismHybridSurrogate.modifierExtension ?: listOf(),
      maternalOrganismId =
        R4String.of(
          this@SubstanceSourceMaterialOrganismHybridSurrogate.maternalOrganismId,
          this@SubstanceSourceMaterialOrganismHybridSurrogate._maternalOrganismId,
        ),
      maternalOrganismName =
        R4String.of(
          this@SubstanceSourceMaterialOrganismHybridSurrogate.maternalOrganismName,
          this@SubstanceSourceMaterialOrganismHybridSurrogate._maternalOrganismName,
        ),
      paternalOrganismId =
        R4String.of(
          this@SubstanceSourceMaterialOrganismHybridSurrogate.paternalOrganismId,
          this@SubstanceSourceMaterialOrganismHybridSurrogate._paternalOrganismId,
        ),
      paternalOrganismName =
        R4String.of(
          this@SubstanceSourceMaterialOrganismHybridSurrogate.paternalOrganismName,
          this@SubstanceSourceMaterialOrganismHybridSurrogate._paternalOrganismName,
        ),
      hybridType = this@SubstanceSourceMaterialOrganismHybridSurrogate.hybridType,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSourceMaterial.Organism.Hybrid
    ): SubstanceSourceMaterialOrganismHybridSurrogate =
      with(model) {
        SubstanceSourceMaterialOrganismHybridSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          maternalOrganismId = this@with.maternalOrganismId?.value,
          _maternalOrganismId = this@with.maternalOrganismId?.toElement(),
          maternalOrganismName = this@with.maternalOrganismName?.value,
          _maternalOrganismName = this@with.maternalOrganismName?.toElement(),
          paternalOrganismId = this@with.paternalOrganismId?.value,
          _paternalOrganismId = this@with.paternalOrganismId?.toElement(),
          paternalOrganismName = this@with.paternalOrganismName?.value,
          _paternalOrganismName = this@with.paternalOrganismName?.toElement(),
          hybridType = this@with.hybridType,
        )
      }
  }
}

@Serializable
internal data class SubstanceSourceMaterialOrganismOrganismGeneralSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var kingdom: CodeableConcept? = null,
  public var phylum: CodeableConcept? = null,
  public var `class`: CodeableConcept? = null,
  public var order: CodeableConcept? = null,
) {
  public fun toModel(): SubstanceSourceMaterial.Organism.OrganismGeneral =
    SubstanceSourceMaterial.Organism.OrganismGeneral(
      id = this@SubstanceSourceMaterialOrganismOrganismGeneralSurrogate.id,
      extension =
        this@SubstanceSourceMaterialOrganismOrganismGeneralSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSourceMaterialOrganismOrganismGeneralSurrogate.modifierExtension ?: listOf(),
      kingdom = this@SubstanceSourceMaterialOrganismOrganismGeneralSurrogate.kingdom,
      phylum = this@SubstanceSourceMaterialOrganismOrganismGeneralSurrogate.phylum,
      `class` = this@SubstanceSourceMaterialOrganismOrganismGeneralSurrogate.`class`,
      order = this@SubstanceSourceMaterialOrganismOrganismGeneralSurrogate.order,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSourceMaterial.Organism.OrganismGeneral
    ): SubstanceSourceMaterialOrganismOrganismGeneralSurrogate =
      with(model) {
        SubstanceSourceMaterialOrganismOrganismGeneralSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          kingdom = this@with.kingdom,
          phylum = this@with.phylum,
          `class` = this@with.`class`,
          order = this@with.order,
        )
      }
  }
}

@Serializable
internal data class SubstanceSourceMaterialPartDescriptionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var part: CodeableConcept? = null,
  public var partLocation: CodeableConcept? = null,
) {
  public fun toModel(): SubstanceSourceMaterial.PartDescription =
    SubstanceSourceMaterial.PartDescription(
      id = this@SubstanceSourceMaterialPartDescriptionSurrogate.id,
      extension = this@SubstanceSourceMaterialPartDescriptionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSourceMaterialPartDescriptionSurrogate.modifierExtension ?: listOf(),
      part = this@SubstanceSourceMaterialPartDescriptionSurrogate.part,
      partLocation = this@SubstanceSourceMaterialPartDescriptionSurrogate.partLocation,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSourceMaterial.PartDescription
    ): SubstanceSourceMaterialPartDescriptionSurrogate =
      with(model) {
        SubstanceSourceMaterialPartDescriptionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          part = this@with.part,
          partLocation = this@with.partLocation,
        )
      }
  }
}

@Serializable
internal data class SubstanceSourceMaterialSurrogate(
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
  public var sourceMaterialClass: CodeableConcept? = null,
  public var sourceMaterialType: CodeableConcept? = null,
  public var sourceMaterialState: CodeableConcept? = null,
  public var organismId: Identifier? = null,
  public var organismName: KotlinString? = null,
  public var _organismName: Element? = null,
  public var parentSubstanceId: List<Identifier>? = null,
  public var parentSubstanceName: List<KotlinString?>? = null,
  public var _parentSubstanceName: List<Element?>? = null,
  public var countryOfOrigin: List<CodeableConcept>? = null,
  public var geographicalLocation: List<KotlinString?>? = null,
  public var _geographicalLocation: List<Element?>? = null,
  public var developmentStage: CodeableConcept? = null,
  public var fractionDescription: List<SubstanceSourceMaterial.FractionDescription>? = null,
  public var organism: SubstanceSourceMaterial.Organism? = null,
  public var partDescription: List<SubstanceSourceMaterial.PartDescription>? = null,
) {
  public fun toModel(): SubstanceSourceMaterial =
    SubstanceSourceMaterial(
      id = this@SubstanceSourceMaterialSurrogate.id,
      meta = this@SubstanceSourceMaterialSurrogate.meta,
      implicitRules =
        Uri.of(
          this@SubstanceSourceMaterialSurrogate.implicitRules,
          this@SubstanceSourceMaterialSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@SubstanceSourceMaterialSurrogate.language,
          this@SubstanceSourceMaterialSurrogate._language,
        ),
      text = this@SubstanceSourceMaterialSurrogate.text,
      contained = this@SubstanceSourceMaterialSurrogate.contained ?: listOf(),
      extension = this@SubstanceSourceMaterialSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceSourceMaterialSurrogate.modifierExtension ?: listOf(),
      sourceMaterialClass = this@SubstanceSourceMaterialSurrogate.sourceMaterialClass,
      sourceMaterialType = this@SubstanceSourceMaterialSurrogate.sourceMaterialType,
      sourceMaterialState = this@SubstanceSourceMaterialSurrogate.sourceMaterialState,
      organismId = this@SubstanceSourceMaterialSurrogate.organismId,
      organismName =
        R4String.of(
          this@SubstanceSourceMaterialSurrogate.organismName,
          this@SubstanceSourceMaterialSurrogate._organismName,
        ),
      parentSubstanceId = this@SubstanceSourceMaterialSurrogate.parentSubstanceId ?: listOf(),
      parentSubstanceName =
        if (
          this@SubstanceSourceMaterialSurrogate.parentSubstanceName == null &&
            this@SubstanceSourceMaterialSurrogate._parentSubstanceName == null
        ) {
          listOf()
        } else {
          (this@SubstanceSourceMaterialSurrogate.parentSubstanceName
              ?: List(this@SubstanceSourceMaterialSurrogate._parentSubstanceName!!.size) { null })
            .zip(
              this@SubstanceSourceMaterialSurrogate._parentSubstanceName
                ?: List(this@SubstanceSourceMaterialSurrogate.parentSubstanceName!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      countryOfOrigin = this@SubstanceSourceMaterialSurrogate.countryOfOrigin ?: listOf(),
      geographicalLocation =
        if (
          this@SubstanceSourceMaterialSurrogate.geographicalLocation == null &&
            this@SubstanceSourceMaterialSurrogate._geographicalLocation == null
        ) {
          listOf()
        } else {
          (this@SubstanceSourceMaterialSurrogate.geographicalLocation
              ?: List(this@SubstanceSourceMaterialSurrogate._geographicalLocation!!.size) { null })
            .zip(
              this@SubstanceSourceMaterialSurrogate._geographicalLocation
                ?: List(this@SubstanceSourceMaterialSurrogate.geographicalLocation!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      developmentStage = this@SubstanceSourceMaterialSurrogate.developmentStage,
      fractionDescription = this@SubstanceSourceMaterialSurrogate.fractionDescription ?: listOf(),
      organism = this@SubstanceSourceMaterialSurrogate.organism,
      partDescription = this@SubstanceSourceMaterialSurrogate.partDescription ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubstanceSourceMaterial): SubstanceSourceMaterialSurrogate =
      with(model) {
        SubstanceSourceMaterialSurrogate(
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
          sourceMaterialClass = this@with.sourceMaterialClass,
          sourceMaterialType = this@with.sourceMaterialType,
          sourceMaterialState = this@with.sourceMaterialState,
          organismId = this@with.organismId,
          organismName = this@with.organismName?.value,
          _organismName = this@with.organismName?.toElement(),
          parentSubstanceId = this@with.parentSubstanceId.takeIf { it.isNotEmpty() },
          parentSubstanceName =
            this@with.parentSubstanceName
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _parentSubstanceName =
            this@with.parentSubstanceName
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          countryOfOrigin = this@with.countryOfOrigin.takeIf { it.isNotEmpty() },
          geographicalLocation =
            this@with.geographicalLocation
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _geographicalLocation =
            this@with.geographicalLocation
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          developmentStage = this@with.developmentStage,
          fractionDescription = this@with.fractionDescription.takeIf { it.isNotEmpty() },
          organism = this@with.organism,
          partDescription = this@with.partDescription.takeIf { it.isNotEmpty() },
        )
      }
  }
}
