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

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.Annotation
import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Ratio
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.SubstanceDefinition
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubstanceDefinitionMoietySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var role: CodeableConcept? = null,
  public var identifier: Identifier? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var stereochemistry: CodeableConcept? = null,
  public var opticalActivity: CodeableConcept? = null,
  public var molecularFormula: KotlinString? = null,
  public var _molecularFormula: Element? = null,
  public var amount: SubstanceDefinition.Moiety.Amount? = null,
  public var measurementType: CodeableConcept? = null,
) {
  public fun toModel(): SubstanceDefinition.Moiety =
    SubstanceDefinition.Moiety(
      id = this@SubstanceDefinitionMoietySurrogate.id,
      extension = this@SubstanceDefinitionMoietySurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceDefinitionMoietySurrogate.modifierExtension ?: listOf(),
      role = this@SubstanceDefinitionMoietySurrogate.role,
      identifier = this@SubstanceDefinitionMoietySurrogate.identifier,
      name =
        R4bString.of(
          this@SubstanceDefinitionMoietySurrogate.name,
          this@SubstanceDefinitionMoietySurrogate._name,
        ),
      stereochemistry = this@SubstanceDefinitionMoietySurrogate.stereochemistry,
      opticalActivity = this@SubstanceDefinitionMoietySurrogate.opticalActivity,
      molecularFormula =
        R4bString.of(
          this@SubstanceDefinitionMoietySurrogate.molecularFormula,
          this@SubstanceDefinitionMoietySurrogate._molecularFormula,
        ),
      amount = this@SubstanceDefinitionMoietySurrogate.amount,
      measurementType = this@SubstanceDefinitionMoietySurrogate.measurementType,
    )

  public companion object {
    public fun fromModel(model: SubstanceDefinition.Moiety): SubstanceDefinitionMoietySurrogate =
      with(model) {
        SubstanceDefinitionMoietySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          role = this@with.role,
          identifier = this@with.identifier,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          stereochemistry = this@with.stereochemistry,
          opticalActivity = this@with.opticalActivity,
          molecularFormula = this@with.molecularFormula?.value,
          _molecularFormula = this@with.molecularFormula?.toElement(),
          amount = this@with.amount,
          measurementType = this@with.measurementType,
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: SubstanceDefinition.Property.Value? = null,
) {
  public fun toModel(): SubstanceDefinition.Property =
    SubstanceDefinition.Property(
      id = this@SubstanceDefinitionPropertySurrogate.id,
      extension = this@SubstanceDefinitionPropertySurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceDefinitionPropertySurrogate.modifierExtension ?: listOf(),
      type = this@SubstanceDefinitionPropertySurrogate.type,
      `value` = this@SubstanceDefinitionPropertySurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.Property
    ): SubstanceDefinitionPropertySurrogate =
      with(model) {
        SubstanceDefinitionPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionMolecularWeightSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var method: CodeableConcept? = null,
  public var type: CodeableConcept? = null,
  public var amount: Quantity,
) {
  public fun toModel(): SubstanceDefinition.MolecularWeight =
    SubstanceDefinition.MolecularWeight(
      id = this@SubstanceDefinitionMolecularWeightSurrogate.id,
      extension = this@SubstanceDefinitionMolecularWeightSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceDefinitionMolecularWeightSurrogate.modifierExtension ?: listOf(),
      method = this@SubstanceDefinitionMolecularWeightSurrogate.method,
      type = this@SubstanceDefinitionMolecularWeightSurrogate.type,
      amount = this@SubstanceDefinitionMolecularWeightSurrogate.amount,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.MolecularWeight
    ): SubstanceDefinitionMolecularWeightSurrogate =
      with(model) {
        SubstanceDefinitionMolecularWeightSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          method = this@with.method,
          type = this@with.type,
          amount = this@with.amount,
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionStructureSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var stereochemistry: CodeableConcept? = null,
  public var opticalActivity: CodeableConcept? = null,
  public var molecularFormula: KotlinString? = null,
  public var _molecularFormula: Element? = null,
  public var molecularFormulaByMoiety: KotlinString? = null,
  public var _molecularFormulaByMoiety: Element? = null,
  public var molecularWeight: SubstanceDefinition.MolecularWeight? = null,
  public var technique: List<CodeableConcept>? = null,
  public var sourceDocument: List<Reference>? = null,
  public var representation: List<SubstanceDefinition.Structure.Representation>? = null,
) {
  public fun toModel(): SubstanceDefinition.Structure =
    SubstanceDefinition.Structure(
      id = this@SubstanceDefinitionStructureSurrogate.id,
      extension = this@SubstanceDefinitionStructureSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceDefinitionStructureSurrogate.modifierExtension ?: listOf(),
      stereochemistry = this@SubstanceDefinitionStructureSurrogate.stereochemistry,
      opticalActivity = this@SubstanceDefinitionStructureSurrogate.opticalActivity,
      molecularFormula =
        R4bString.of(
          this@SubstanceDefinitionStructureSurrogate.molecularFormula,
          this@SubstanceDefinitionStructureSurrogate._molecularFormula,
        ),
      molecularFormulaByMoiety =
        R4bString.of(
          this@SubstanceDefinitionStructureSurrogate.molecularFormulaByMoiety,
          this@SubstanceDefinitionStructureSurrogate._molecularFormulaByMoiety,
        ),
      molecularWeight = this@SubstanceDefinitionStructureSurrogate.molecularWeight,
      technique = this@SubstanceDefinitionStructureSurrogate.technique ?: listOf(),
      sourceDocument = this@SubstanceDefinitionStructureSurrogate.sourceDocument ?: listOf(),
      representation = this@SubstanceDefinitionStructureSurrogate.representation ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.Structure
    ): SubstanceDefinitionStructureSurrogate =
      with(model) {
        SubstanceDefinitionStructureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          stereochemistry = this@with.stereochemistry,
          opticalActivity = this@with.opticalActivity,
          molecularFormula = this@with.molecularFormula?.value,
          _molecularFormula = this@with.molecularFormula?.toElement(),
          molecularFormulaByMoiety = this@with.molecularFormulaByMoiety?.value,
          _molecularFormulaByMoiety = this@with.molecularFormulaByMoiety?.toElement(),
          molecularWeight = this@with.molecularWeight,
          technique = this@with.technique.takeIf { it.isNotEmpty() },
          sourceDocument = this@with.sourceDocument.takeIf { it.isNotEmpty() },
          representation = this@with.representation.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionStructureRepresentationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var representation: KotlinString? = null,
  public var _representation: Element? = null,
  public var format: CodeableConcept? = null,
  public var document: Reference? = null,
) {
  public fun toModel(): SubstanceDefinition.Structure.Representation =
    SubstanceDefinition.Structure.Representation(
      id = this@SubstanceDefinitionStructureRepresentationSurrogate.id,
      extension = this@SubstanceDefinitionStructureRepresentationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceDefinitionStructureRepresentationSurrogate.modifierExtension ?: listOf(),
      type = this@SubstanceDefinitionStructureRepresentationSurrogate.type,
      representation =
        R4bString.of(
          this@SubstanceDefinitionStructureRepresentationSurrogate.representation,
          this@SubstanceDefinitionStructureRepresentationSurrogate._representation,
        ),
      format = this@SubstanceDefinitionStructureRepresentationSurrogate.format,
      document = this@SubstanceDefinitionStructureRepresentationSurrogate.document,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.Structure.Representation
    ): SubstanceDefinitionStructureRepresentationSurrogate =
      with(model) {
        SubstanceDefinitionStructureRepresentationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          representation = this@with.representation?.value,
          _representation = this@with.representation?.toElement(),
          format = this@with.format,
          document = this@with.document,
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionCodeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var status: CodeableConcept? = null,
  public var statusDate: KotlinString? = null,
  public var _statusDate: Element? = null,
  public var note: List<Annotation>? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceDefinition.Code =
    SubstanceDefinition.Code(
      id = this@SubstanceDefinitionCodeSurrogate.id,
      extension = this@SubstanceDefinitionCodeSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceDefinitionCodeSurrogate.modifierExtension ?: listOf(),
      code = this@SubstanceDefinitionCodeSurrogate.code,
      status = this@SubstanceDefinitionCodeSurrogate.status,
      statusDate =
        DateTime.of(
          FhirDateTime.fromString(this@SubstanceDefinitionCodeSurrogate.statusDate),
          this@SubstanceDefinitionCodeSurrogate._statusDate,
        ),
      note = this@SubstanceDefinitionCodeSurrogate.note ?: listOf(),
      source = this@SubstanceDefinitionCodeSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubstanceDefinition.Code): SubstanceDefinitionCodeSurrogate =
      with(model) {
        SubstanceDefinitionCodeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          status = this@with.status,
          statusDate = this@with.statusDate?.value?.toString(),
          _statusDate = this@with.statusDate?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionNameSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var type: CodeableConcept? = null,
  public var status: CodeableConcept? = null,
  public var preferred: KotlinBoolean? = null,
  public var _preferred: Element? = null,
  public var language: List<CodeableConcept>? = null,
  public var domain: List<CodeableConcept>? = null,
  public var jurisdiction: List<CodeableConcept>? = null,
  public var synonym: List<SubstanceDefinition.Name>? = null,
  public var translation: List<SubstanceDefinition.Name>? = null,
  public var official: List<SubstanceDefinition.Name.Official>? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceDefinition.Name =
    SubstanceDefinition.Name(
      id = this@SubstanceDefinitionNameSurrogate.id,
      extension = this@SubstanceDefinitionNameSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceDefinitionNameSurrogate.modifierExtension ?: listOf(),
      name =
        R4bString.of(
          this@SubstanceDefinitionNameSurrogate.name,
          this@SubstanceDefinitionNameSurrogate._name,
        )!!,
      type = this@SubstanceDefinitionNameSurrogate.type,
      status = this@SubstanceDefinitionNameSurrogate.status,
      preferred =
        R4bBoolean.of(
          this@SubstanceDefinitionNameSurrogate.preferred,
          this@SubstanceDefinitionNameSurrogate._preferred,
        ),
      language = this@SubstanceDefinitionNameSurrogate.language ?: listOf(),
      domain = this@SubstanceDefinitionNameSurrogate.domain ?: listOf(),
      jurisdiction = this@SubstanceDefinitionNameSurrogate.jurisdiction ?: listOf(),
      synonym = this@SubstanceDefinitionNameSurrogate.synonym ?: listOf(),
      translation = this@SubstanceDefinitionNameSurrogate.translation ?: listOf(),
      official = this@SubstanceDefinitionNameSurrogate.official ?: listOf(),
      source = this@SubstanceDefinitionNameSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubstanceDefinition.Name): SubstanceDefinitionNameSurrogate =
      with(model) {
        SubstanceDefinitionNameSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          type = this@with.type,
          status = this@with.status,
          preferred = this@with.preferred?.value,
          _preferred = this@with.preferred?.toElement(),
          language = this@with.language.takeIf { it.isNotEmpty() },
          domain = this@with.domain.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
          synonym = this@with.synonym.takeIf { it.isNotEmpty() },
          translation = this@with.translation.takeIf { it.isNotEmpty() },
          official = this@with.official.takeIf { it.isNotEmpty() },
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionNameOfficialSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var authority: CodeableConcept? = null,
  public var status: CodeableConcept? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
) {
  public fun toModel(): SubstanceDefinition.Name.Official =
    SubstanceDefinition.Name.Official(
      id = this@SubstanceDefinitionNameOfficialSurrogate.id,
      extension = this@SubstanceDefinitionNameOfficialSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceDefinitionNameOfficialSurrogate.modifierExtension ?: listOf(),
      authority = this@SubstanceDefinitionNameOfficialSurrogate.authority,
      status = this@SubstanceDefinitionNameOfficialSurrogate.status,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@SubstanceDefinitionNameOfficialSurrogate.date),
          this@SubstanceDefinitionNameOfficialSurrogate._date,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.Name.Official
    ): SubstanceDefinitionNameOfficialSurrogate =
      with(model) {
        SubstanceDefinitionNameOfficialSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          authority = this@with.authority,
          status = this@with.status,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionRelationshipSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var substanceDefinition: SubstanceDefinition.Relationship.SubstanceDefinition? = null,
  public var type: CodeableConcept,
  public var isDefining: KotlinBoolean? = null,
  public var _isDefining: Element? = null,
  public var amount: SubstanceDefinition.Relationship.Amount? = null,
  public var ratioHighLimitAmount: Ratio? = null,
  public var comparator: CodeableConcept? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceDefinition.Relationship =
    SubstanceDefinition.Relationship(
      id = this@SubstanceDefinitionRelationshipSurrogate.id,
      extension = this@SubstanceDefinitionRelationshipSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceDefinitionRelationshipSurrogate.modifierExtension ?: listOf(),
      substanceDefinition = this@SubstanceDefinitionRelationshipSurrogate.substanceDefinition,
      type = this@SubstanceDefinitionRelationshipSurrogate.type,
      isDefining =
        R4bBoolean.of(
          this@SubstanceDefinitionRelationshipSurrogate.isDefining,
          this@SubstanceDefinitionRelationshipSurrogate._isDefining,
        ),
      amount = this@SubstanceDefinitionRelationshipSurrogate.amount,
      ratioHighLimitAmount = this@SubstanceDefinitionRelationshipSurrogate.ratioHighLimitAmount,
      comparator = this@SubstanceDefinitionRelationshipSurrogate.comparator,
      source = this@SubstanceDefinitionRelationshipSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.Relationship
    ): SubstanceDefinitionRelationshipSurrogate =
      with(model) {
        SubstanceDefinitionRelationshipSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          substanceDefinition = this@with.substanceDefinition,
          type = this@with.type,
          isDefining = this@with.isDefining?.value,
          _isDefining = this@with.isDefining?.toElement(),
          amount = this@with.amount,
          ratioHighLimitAmount = this@with.ratioHighLimitAmount,
          comparator = this@with.comparator,
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionSourceMaterialSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var genus: CodeableConcept? = null,
  public var species: CodeableConcept? = null,
  public var part: CodeableConcept? = null,
  public var countryOfOrigin: List<CodeableConcept>? = null,
) {
  public fun toModel(): SubstanceDefinition.SourceMaterial =
    SubstanceDefinition.SourceMaterial(
      id = this@SubstanceDefinitionSourceMaterialSurrogate.id,
      extension = this@SubstanceDefinitionSourceMaterialSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceDefinitionSourceMaterialSurrogate.modifierExtension ?: listOf(),
      type = this@SubstanceDefinitionSourceMaterialSurrogate.type,
      genus = this@SubstanceDefinitionSourceMaterialSurrogate.genus,
      species = this@SubstanceDefinitionSourceMaterialSurrogate.species,
      part = this@SubstanceDefinitionSourceMaterialSurrogate.part,
      countryOfOrigin = this@SubstanceDefinitionSourceMaterialSurrogate.countryOfOrigin ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.SourceMaterial
    ): SubstanceDefinitionSourceMaterialSurrogate =
      with(model) {
        SubstanceDefinitionSourceMaterialSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          genus = this@with.genus,
          species = this@with.species,
          part = this@with.part,
          countryOfOrigin = this@with.countryOfOrigin.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionMoietyAmountSurrogate(
  public var amountQuantity: Quantity? = null,
  public var amountString: KotlinString? = null,
  public var _amountString: Element? = null,
) {
  public fun toModel(): SubstanceDefinition.Moiety.Amount =
    SubstanceDefinition.Moiety.Amount.from(
      this@SubstanceDefinitionMoietyAmountSurrogate.amountQuantity,
      R4bString.of(
        this@SubstanceDefinitionMoietyAmountSurrogate.amountString,
        this@SubstanceDefinitionMoietyAmountSurrogate._amountString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.Moiety.Amount
    ): SubstanceDefinitionMoietyAmountSurrogate =
      with(model) {
        SubstanceDefinitionMoietyAmountSurrogate(
          amountQuantity = this@with.asQuantity()?.value,
          amountString = this@with.asString()?.value?.value,
          _amountString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionPropertyValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueAttachment: Attachment? = null,
) {
  public fun toModel(): SubstanceDefinition.Property.Value =
    SubstanceDefinition.Property.Value.from(
      this@SubstanceDefinitionPropertyValueSurrogate.valueCodeableConcept,
      this@SubstanceDefinitionPropertyValueSurrogate.valueQuantity,
      Date.of(
        FhirDate.fromString(this@SubstanceDefinitionPropertyValueSurrogate.valueDate),
        this@SubstanceDefinitionPropertyValueSurrogate._valueDate,
      ),
      R4bBoolean.of(
        this@SubstanceDefinitionPropertyValueSurrogate.valueBoolean,
        this@SubstanceDefinitionPropertyValueSurrogate._valueBoolean,
      ),
      this@SubstanceDefinitionPropertyValueSurrogate.valueAttachment,
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.Property.Value
    ): SubstanceDefinitionPropertyValueSurrogate =
      with(model) {
        SubstanceDefinitionPropertyValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionRelationshipSubstanceDefinitionSurrogate(
  public var substanceDefinitionReference: Reference? = null,
  public var substanceDefinitionCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): SubstanceDefinition.Relationship.SubstanceDefinition =
    SubstanceDefinition.Relationship.SubstanceDefinition.from(
      this@SubstanceDefinitionRelationshipSubstanceDefinitionSurrogate.substanceDefinitionReference,
      this@SubstanceDefinitionRelationshipSubstanceDefinitionSurrogate
        .substanceDefinitionCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.Relationship.SubstanceDefinition
    ): SubstanceDefinitionRelationshipSubstanceDefinitionSurrogate =
      with(model) {
        SubstanceDefinitionRelationshipSubstanceDefinitionSurrogate(
          substanceDefinitionReference = this@with.asReference()?.value,
          substanceDefinitionCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionRelationshipAmountSurrogate(
  public var amountQuantity: Quantity? = null,
  public var amountRatio: Ratio? = null,
  public var amountString: KotlinString? = null,
  public var _amountString: Element? = null,
) {
  public fun toModel(): SubstanceDefinition.Relationship.Amount =
    SubstanceDefinition.Relationship.Amount.from(
      this@SubstanceDefinitionRelationshipAmountSurrogate.amountQuantity,
      this@SubstanceDefinitionRelationshipAmountSurrogate.amountRatio,
      R4bString.of(
        this@SubstanceDefinitionRelationshipAmountSurrogate.amountString,
        this@SubstanceDefinitionRelationshipAmountSurrogate._amountString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceDefinition.Relationship.Amount
    ): SubstanceDefinitionRelationshipAmountSurrogate =
      with(model) {
        SubstanceDefinitionRelationshipAmountSurrogate(
          amountQuantity = this@with.asQuantity()?.value,
          amountRatio = this@with.asRatio()?.value,
          amountString = this@with.asString()?.value?.value,
          _amountString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceDefinitionSurrogate(
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
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var status: CodeableConcept? = null,
  public var classification: List<CodeableConcept>? = null,
  public var domain: CodeableConcept? = null,
  public var grade: List<CodeableConcept>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var informationSource: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var manufacturer: List<Reference>? = null,
  public var supplier: List<Reference>? = null,
  public var moiety: List<SubstanceDefinition.Moiety>? = null,
  public var `property`: List<SubstanceDefinition.Property>? = null,
  public var molecularWeight: List<SubstanceDefinition.MolecularWeight>? = null,
  public var structure: SubstanceDefinition.Structure? = null,
  public var code: List<SubstanceDefinition.Code>? = null,
  public var name: List<SubstanceDefinition.Name>? = null,
  public var relationship: List<SubstanceDefinition.Relationship>? = null,
  public var sourceMaterial: SubstanceDefinition.SourceMaterial? = null,
) {
  public fun toModel(): SubstanceDefinition =
    SubstanceDefinition(
      id = this@SubstanceDefinitionSurrogate.id,
      meta = this@SubstanceDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@SubstanceDefinitionSurrogate.implicitRules,
          this@SubstanceDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@SubstanceDefinitionSurrogate.language,
          this@SubstanceDefinitionSurrogate._language,
        ),
      text = this@SubstanceDefinitionSurrogate.text,
      contained = this@SubstanceDefinitionSurrogate.contained ?: listOf(),
      extension = this@SubstanceDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceDefinitionSurrogate.modifierExtension ?: listOf(),
      identifier = this@SubstanceDefinitionSurrogate.identifier ?: listOf(),
      version =
        R4bString.of(
          this@SubstanceDefinitionSurrogate.version,
          this@SubstanceDefinitionSurrogate._version,
        ),
      status = this@SubstanceDefinitionSurrogate.status,
      classification = this@SubstanceDefinitionSurrogate.classification ?: listOf(),
      domain = this@SubstanceDefinitionSurrogate.domain,
      grade = this@SubstanceDefinitionSurrogate.grade ?: listOf(),
      description =
        Markdown.of(
          this@SubstanceDefinitionSurrogate.description,
          this@SubstanceDefinitionSurrogate._description,
        ),
      informationSource = this@SubstanceDefinitionSurrogate.informationSource ?: listOf(),
      note = this@SubstanceDefinitionSurrogate.note ?: listOf(),
      manufacturer = this@SubstanceDefinitionSurrogate.manufacturer ?: listOf(),
      supplier = this@SubstanceDefinitionSurrogate.supplier ?: listOf(),
      moiety = this@SubstanceDefinitionSurrogate.moiety ?: listOf(),
      `property` = this@SubstanceDefinitionSurrogate.`property` ?: listOf(),
      molecularWeight = this@SubstanceDefinitionSurrogate.molecularWeight ?: listOf(),
      structure = this@SubstanceDefinitionSurrogate.structure,
      code = this@SubstanceDefinitionSurrogate.code ?: listOf(),
      name = this@SubstanceDefinitionSurrogate.name ?: listOf(),
      relationship = this@SubstanceDefinitionSurrogate.relationship ?: listOf(),
      sourceMaterial = this@SubstanceDefinitionSurrogate.sourceMaterial,
    )

  public companion object {
    public fun fromModel(model: SubstanceDefinition): SubstanceDefinitionSurrogate =
      with(model) {
        SubstanceDefinitionSurrogate(
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
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          status = this@with.status,
          classification = this@with.classification.takeIf { it.isNotEmpty() },
          domain = this@with.domain,
          grade = this@with.grade.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          informationSource = this@with.informationSource.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
          supplier = this@with.supplier.takeIf { it.isNotEmpty() },
          moiety = this@with.moiety.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          molecularWeight = this@with.molecularWeight.takeIf { it.isNotEmpty() },
          structure = this@with.structure,
          code = this@with.code.takeIf { it.isNotEmpty() },
          name = this@with.name.takeIf { it.isNotEmpty() },
          relationship = this@with.relationship.takeIf { it.isNotEmpty() },
          sourceMaterial = this@with.sourceMaterial,
        )
      }
  }
}
