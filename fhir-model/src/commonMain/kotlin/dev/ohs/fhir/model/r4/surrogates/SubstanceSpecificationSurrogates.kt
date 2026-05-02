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

import com.google.fhir.model.r4.Attachment
import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Range
import com.google.fhir.model.r4.Ratio
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.SubstanceSpecification
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubstanceSpecificationMoietySurrogate(
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
  public var amount: SubstanceSpecification.Moiety.Amount? = null,
) {
  public fun toModel(): SubstanceSpecification.Moiety =
    SubstanceSpecification.Moiety(
      id = this@SubstanceSpecificationMoietySurrogate.id,
      extension = this@SubstanceSpecificationMoietySurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceSpecificationMoietySurrogate.modifierExtension ?: listOf(),
      role = this@SubstanceSpecificationMoietySurrogate.role,
      identifier = this@SubstanceSpecificationMoietySurrogate.identifier,
      name =
        R4String.of(
          this@SubstanceSpecificationMoietySurrogate.name,
          this@SubstanceSpecificationMoietySurrogate._name,
        ),
      stereochemistry = this@SubstanceSpecificationMoietySurrogate.stereochemistry,
      opticalActivity = this@SubstanceSpecificationMoietySurrogate.opticalActivity,
      molecularFormula =
        R4String.of(
          this@SubstanceSpecificationMoietySurrogate.molecularFormula,
          this@SubstanceSpecificationMoietySurrogate._molecularFormula,
        ),
      amount = this@SubstanceSpecificationMoietySurrogate.amount,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Moiety
    ): SubstanceSpecificationMoietySurrogate =
      with(model) {
        SubstanceSpecificationMoietySurrogate(
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
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept? = null,
  public var code: CodeableConcept? = null,
  public var parameters: KotlinString? = null,
  public var _parameters: Element? = null,
  public var definingSubstance: SubstanceSpecification.Property.DefiningSubstance? = null,
  public var amount: SubstanceSpecification.Property.Amount? = null,
) {
  public fun toModel(): SubstanceSpecification.Property =
    SubstanceSpecification.Property(
      id = this@SubstanceSpecificationPropertySurrogate.id,
      extension = this@SubstanceSpecificationPropertySurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSpecificationPropertySurrogate.modifierExtension ?: listOf(),
      category = this@SubstanceSpecificationPropertySurrogate.category,
      code = this@SubstanceSpecificationPropertySurrogate.code,
      parameters =
        R4String.of(
          this@SubstanceSpecificationPropertySurrogate.parameters,
          this@SubstanceSpecificationPropertySurrogate._parameters,
        ),
      definingSubstance = this@SubstanceSpecificationPropertySurrogate.definingSubstance,
      amount = this@SubstanceSpecificationPropertySurrogate.amount,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Property
    ): SubstanceSpecificationPropertySurrogate =
      with(model) {
        SubstanceSpecificationPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          code = this@with.code,
          parameters = this@with.parameters?.value,
          _parameters = this@with.parameters?.toElement(),
          definingSubstance = this@with.definingSubstance,
          amount = this@with.amount,
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationStructureSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var stereochemistry: CodeableConcept? = null,
  public var opticalActivity: CodeableConcept? = null,
  public var molecularFormula: KotlinString? = null,
  public var _molecularFormula: Element? = null,
  public var molecularFormulaByMoiety: KotlinString? = null,
  public var _molecularFormulaByMoiety: Element? = null,
  public var isotope: List<SubstanceSpecification.Structure.Isotope>? = null,
  public var molecularWeight: SubstanceSpecification.Structure.Isotope.MolecularWeight? = null,
  public var source: List<Reference>? = null,
  public var representation: List<SubstanceSpecification.Structure.Representation>? = null,
) {
  public fun toModel(): SubstanceSpecification.Structure =
    SubstanceSpecification.Structure(
      id = this@SubstanceSpecificationStructureSurrogate.id,
      extension = this@SubstanceSpecificationStructureSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSpecificationStructureSurrogate.modifierExtension ?: listOf(),
      stereochemistry = this@SubstanceSpecificationStructureSurrogate.stereochemistry,
      opticalActivity = this@SubstanceSpecificationStructureSurrogate.opticalActivity,
      molecularFormula =
        R4String.of(
          this@SubstanceSpecificationStructureSurrogate.molecularFormula,
          this@SubstanceSpecificationStructureSurrogate._molecularFormula,
        ),
      molecularFormulaByMoiety =
        R4String.of(
          this@SubstanceSpecificationStructureSurrogate.molecularFormulaByMoiety,
          this@SubstanceSpecificationStructureSurrogate._molecularFormulaByMoiety,
        ),
      isotope = this@SubstanceSpecificationStructureSurrogate.isotope ?: listOf(),
      molecularWeight = this@SubstanceSpecificationStructureSurrogate.molecularWeight,
      source = this@SubstanceSpecificationStructureSurrogate.source ?: listOf(),
      representation = this@SubstanceSpecificationStructureSurrogate.representation ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Structure
    ): SubstanceSpecificationStructureSurrogate =
      with(model) {
        SubstanceSpecificationStructureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          stereochemistry = this@with.stereochemistry,
          opticalActivity = this@with.opticalActivity,
          molecularFormula = this@with.molecularFormula?.value,
          _molecularFormula = this@with.molecularFormula?.toElement(),
          molecularFormulaByMoiety = this@with.molecularFormulaByMoiety?.value,
          _molecularFormulaByMoiety = this@with.molecularFormulaByMoiety?.toElement(),
          isotope = this@with.isotope.takeIf { it.isNotEmpty() },
          molecularWeight = this@with.molecularWeight,
          source = this@with.source.takeIf { it.isNotEmpty() },
          representation = this@with.representation.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationStructureIsotopeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier? = null,
  public var name: CodeableConcept? = null,
  public var substitution: CodeableConcept? = null,
  public var halfLife: Quantity? = null,
  public var molecularWeight: SubstanceSpecification.Structure.Isotope.MolecularWeight? = null,
) {
  public fun toModel(): SubstanceSpecification.Structure.Isotope =
    SubstanceSpecification.Structure.Isotope(
      id = this@SubstanceSpecificationStructureIsotopeSurrogate.id,
      extension = this@SubstanceSpecificationStructureIsotopeSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSpecificationStructureIsotopeSurrogate.modifierExtension ?: listOf(),
      identifier = this@SubstanceSpecificationStructureIsotopeSurrogate.identifier,
      name = this@SubstanceSpecificationStructureIsotopeSurrogate.name,
      substitution = this@SubstanceSpecificationStructureIsotopeSurrogate.substitution,
      halfLife = this@SubstanceSpecificationStructureIsotopeSurrogate.halfLife,
      molecularWeight = this@SubstanceSpecificationStructureIsotopeSurrogate.molecularWeight,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Structure.Isotope
    ): SubstanceSpecificationStructureIsotopeSurrogate =
      with(model) {
        SubstanceSpecificationStructureIsotopeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier,
          name = this@with.name,
          substitution = this@with.substitution,
          halfLife = this@with.halfLife,
          molecularWeight = this@with.molecularWeight,
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var method: CodeableConcept? = null,
  public var type: CodeableConcept? = null,
  public var amount: Quantity? = null,
) {
  public fun toModel(): SubstanceSpecification.Structure.Isotope.MolecularWeight =
    SubstanceSpecification.Structure.Isotope.MolecularWeight(
      id = this@SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate.id,
      extension =
        this@SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate.modifierExtension
          ?: listOf(),
      method = this@SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate.method,
      type = this@SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate.type,
      amount = this@SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate.amount,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Structure.Isotope.MolecularWeight
    ): SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate =
      with(model) {
        SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate(
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
internal data class SubstanceSpecificationStructureRepresentationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var representation: KotlinString? = null,
  public var _representation: Element? = null,
  public var attachment: Attachment? = null,
) {
  public fun toModel(): SubstanceSpecification.Structure.Representation =
    SubstanceSpecification.Structure.Representation(
      id = this@SubstanceSpecificationStructureRepresentationSurrogate.id,
      extension = this@SubstanceSpecificationStructureRepresentationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSpecificationStructureRepresentationSurrogate.modifierExtension ?: listOf(),
      type = this@SubstanceSpecificationStructureRepresentationSurrogate.type,
      representation =
        R4String.of(
          this@SubstanceSpecificationStructureRepresentationSurrogate.representation,
          this@SubstanceSpecificationStructureRepresentationSurrogate._representation,
        ),
      attachment = this@SubstanceSpecificationStructureRepresentationSurrogate.attachment,
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Structure.Representation
    ): SubstanceSpecificationStructureRepresentationSurrogate =
      with(model) {
        SubstanceSpecificationStructureRepresentationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          representation = this@with.representation?.value,
          _representation = this@with.representation?.toElement(),
          attachment = this@with.attachment,
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationCodeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var status: CodeableConcept? = null,
  public var statusDate: KotlinString? = null,
  public var _statusDate: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceSpecification.Code =
    SubstanceSpecification.Code(
      id = this@SubstanceSpecificationCodeSurrogate.id,
      extension = this@SubstanceSpecificationCodeSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceSpecificationCodeSurrogate.modifierExtension ?: listOf(),
      code = this@SubstanceSpecificationCodeSurrogate.code,
      status = this@SubstanceSpecificationCodeSurrogate.status,
      statusDate =
        DateTime.of(
          FhirDateTime.fromString(this@SubstanceSpecificationCodeSurrogate.statusDate),
          this@SubstanceSpecificationCodeSurrogate._statusDate,
        ),
      comment =
        R4String.of(
          this@SubstanceSpecificationCodeSurrogate.comment,
          this@SubstanceSpecificationCodeSurrogate._comment,
        ),
      source = this@SubstanceSpecificationCodeSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubstanceSpecification.Code): SubstanceSpecificationCodeSurrogate =
      with(model) {
        SubstanceSpecificationCodeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          status = this@with.status,
          statusDate = this@with.statusDate?.value?.toString(),
          _statusDate = this@with.statusDate?.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationNameSurrogate(
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
  public var synonym: List<SubstanceSpecification.Name>? = null,
  public var translation: List<SubstanceSpecification.Name>? = null,
  public var official: List<SubstanceSpecification.Name.Official>? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceSpecification.Name =
    SubstanceSpecification.Name(
      id = this@SubstanceSpecificationNameSurrogate.id,
      extension = this@SubstanceSpecificationNameSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceSpecificationNameSurrogate.modifierExtension ?: listOf(),
      name =
        R4String.of(
          this@SubstanceSpecificationNameSurrogate.name,
          this@SubstanceSpecificationNameSurrogate._name,
        )!!,
      type = this@SubstanceSpecificationNameSurrogate.type,
      status = this@SubstanceSpecificationNameSurrogate.status,
      preferred =
        R4Boolean.of(
          this@SubstanceSpecificationNameSurrogate.preferred,
          this@SubstanceSpecificationNameSurrogate._preferred,
        ),
      language = this@SubstanceSpecificationNameSurrogate.language ?: listOf(),
      domain = this@SubstanceSpecificationNameSurrogate.domain ?: listOf(),
      jurisdiction = this@SubstanceSpecificationNameSurrogate.jurisdiction ?: listOf(),
      synonym = this@SubstanceSpecificationNameSurrogate.synonym ?: listOf(),
      translation = this@SubstanceSpecificationNameSurrogate.translation ?: listOf(),
      official = this@SubstanceSpecificationNameSurrogate.official ?: listOf(),
      source = this@SubstanceSpecificationNameSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubstanceSpecification.Name): SubstanceSpecificationNameSurrogate =
      with(model) {
        SubstanceSpecificationNameSurrogate(
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
internal data class SubstanceSpecificationNameOfficialSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var authority: CodeableConcept? = null,
  public var status: CodeableConcept? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
) {
  public fun toModel(): SubstanceSpecification.Name.Official =
    SubstanceSpecification.Name.Official(
      id = this@SubstanceSpecificationNameOfficialSurrogate.id,
      extension = this@SubstanceSpecificationNameOfficialSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSpecificationNameOfficialSurrogate.modifierExtension ?: listOf(),
      authority = this@SubstanceSpecificationNameOfficialSurrogate.authority,
      status = this@SubstanceSpecificationNameOfficialSurrogate.status,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@SubstanceSpecificationNameOfficialSurrogate.date),
          this@SubstanceSpecificationNameOfficialSurrogate._date,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Name.Official
    ): SubstanceSpecificationNameOfficialSurrogate =
      with(model) {
        SubstanceSpecificationNameOfficialSurrogate(
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
internal data class SubstanceSpecificationRelationshipSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var substance: SubstanceSpecification.Relationship.Substance? = null,
  public var relationship: CodeableConcept? = null,
  public var isDefining: KotlinBoolean? = null,
  public var _isDefining: Element? = null,
  public var amount: SubstanceSpecification.Relationship.Amount? = null,
  public var amountRatioLowLimit: Ratio? = null,
  public var amountType: CodeableConcept? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): SubstanceSpecification.Relationship =
    SubstanceSpecification.Relationship(
      id = this@SubstanceSpecificationRelationshipSurrogate.id,
      extension = this@SubstanceSpecificationRelationshipSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceSpecificationRelationshipSurrogate.modifierExtension ?: listOf(),
      substance = this@SubstanceSpecificationRelationshipSurrogate.substance,
      relationship = this@SubstanceSpecificationRelationshipSurrogate.relationship,
      isDefining =
        R4Boolean.of(
          this@SubstanceSpecificationRelationshipSurrogate.isDefining,
          this@SubstanceSpecificationRelationshipSurrogate._isDefining,
        ),
      amount = this@SubstanceSpecificationRelationshipSurrogate.amount,
      amountRatioLowLimit = this@SubstanceSpecificationRelationshipSurrogate.amountRatioLowLimit,
      amountType = this@SubstanceSpecificationRelationshipSurrogate.amountType,
      source = this@SubstanceSpecificationRelationshipSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Relationship
    ): SubstanceSpecificationRelationshipSurrogate =
      with(model) {
        SubstanceSpecificationRelationshipSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          substance = this@with.substance,
          relationship = this@with.relationship,
          isDefining = this@with.isDefining?.value,
          _isDefining = this@with.isDefining?.toElement(),
          amount = this@with.amount,
          amountRatioLowLimit = this@with.amountRatioLowLimit,
          amountType = this@with.amountType,
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationMoietyAmountSurrogate(
  public var amountQuantity: Quantity? = null,
  public var amountString: KotlinString? = null,
  public var _amountString: Element? = null,
) {
  public fun toModel(): SubstanceSpecification.Moiety.Amount =
    SubstanceSpecification.Moiety.Amount.from(
      this@SubstanceSpecificationMoietyAmountSurrogate.amountQuantity,
      R4String.of(
        this@SubstanceSpecificationMoietyAmountSurrogate.amountString,
        this@SubstanceSpecificationMoietyAmountSurrogate._amountString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Moiety.Amount
    ): SubstanceSpecificationMoietyAmountSurrogate =
      with(model) {
        SubstanceSpecificationMoietyAmountSurrogate(
          amountQuantity = this@with.asQuantity()?.value,
          amountString = this@with.asString()?.value?.value,
          _amountString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationPropertyDefiningSubstanceSurrogate(
  public var definingSubstanceReference: Reference? = null,
  public var definingSubstanceCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): SubstanceSpecification.Property.DefiningSubstance =
    SubstanceSpecification.Property.DefiningSubstance.from(
      this@SubstanceSpecificationPropertyDefiningSubstanceSurrogate.definingSubstanceReference,
      this@SubstanceSpecificationPropertyDefiningSubstanceSurrogate.definingSubstanceCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Property.DefiningSubstance
    ): SubstanceSpecificationPropertyDefiningSubstanceSurrogate =
      with(model) {
        SubstanceSpecificationPropertyDefiningSubstanceSurrogate(
          definingSubstanceReference = this@with.asReference()?.value,
          definingSubstanceCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationPropertyAmountSurrogate(
  public var amountQuantity: Quantity? = null,
  public var amountString: KotlinString? = null,
  public var _amountString: Element? = null,
) {
  public fun toModel(): SubstanceSpecification.Property.Amount =
    SubstanceSpecification.Property.Amount.from(
      this@SubstanceSpecificationPropertyAmountSurrogate.amountQuantity,
      R4String.of(
        this@SubstanceSpecificationPropertyAmountSurrogate.amountString,
        this@SubstanceSpecificationPropertyAmountSurrogate._amountString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Property.Amount
    ): SubstanceSpecificationPropertyAmountSurrogate =
      with(model) {
        SubstanceSpecificationPropertyAmountSurrogate(
          amountQuantity = this@with.asQuantity()?.value,
          amountString = this@with.asString()?.value?.value,
          _amountString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationRelationshipSubstanceSurrogate(
  public var substanceReference: Reference? = null,
  public var substanceCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): SubstanceSpecification.Relationship.Substance =
    SubstanceSpecification.Relationship.Substance.from(
      this@SubstanceSpecificationRelationshipSubstanceSurrogate.substanceReference,
      this@SubstanceSpecificationRelationshipSubstanceSurrogate.substanceCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Relationship.Substance
    ): SubstanceSpecificationRelationshipSubstanceSurrogate =
      with(model) {
        SubstanceSpecificationRelationshipSubstanceSurrogate(
          substanceReference = this@with.asReference()?.value,
          substanceCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationRelationshipAmountSurrogate(
  public var amountQuantity: Quantity? = null,
  public var amountRange: Range? = null,
  public var amountRatio: Ratio? = null,
  public var amountString: KotlinString? = null,
  public var _amountString: Element? = null,
) {
  public fun toModel(): SubstanceSpecification.Relationship.Amount =
    SubstanceSpecification.Relationship.Amount.from(
      this@SubstanceSpecificationRelationshipAmountSurrogate.amountQuantity,
      this@SubstanceSpecificationRelationshipAmountSurrogate.amountRange,
      this@SubstanceSpecificationRelationshipAmountSurrogate.amountRatio,
      R4String.of(
        this@SubstanceSpecificationRelationshipAmountSurrogate.amountString,
        this@SubstanceSpecificationRelationshipAmountSurrogate._amountString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: SubstanceSpecification.Relationship.Amount
    ): SubstanceSpecificationRelationshipAmountSurrogate =
      with(model) {
        SubstanceSpecificationRelationshipAmountSurrogate(
          amountQuantity = this@with.asQuantity()?.value,
          amountRange = this@with.asRange()?.value,
          amountRatio = this@with.asRatio()?.value,
          amountString = this@with.asString()?.value?.value,
          _amountString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceSpecificationSurrogate(
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
  public var identifier: Identifier? = null,
  public var type: CodeableConcept? = null,
  public var status: CodeableConcept? = null,
  public var domain: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var source: List<Reference>? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
  public var moiety: List<SubstanceSpecification.Moiety>? = null,
  public var `property`: List<SubstanceSpecification.Property>? = null,
  public var referenceInformation: Reference? = null,
  public var structure: SubstanceSpecification.Structure? = null,
  public var code: List<SubstanceSpecification.Code>? = null,
  public var name: List<SubstanceSpecification.Name>? = null,
  public var molecularWeight: List<SubstanceSpecification.Structure.Isotope.MolecularWeight>? =
    null,
  public var relationship: List<SubstanceSpecification.Relationship>? = null,
  public var nucleicAcid: Reference? = null,
  public var polymer: Reference? = null,
  public var protein: Reference? = null,
  public var sourceMaterial: Reference? = null,
) {
  public fun toModel(): SubstanceSpecification =
    SubstanceSpecification(
      id = this@SubstanceSpecificationSurrogate.id,
      meta = this@SubstanceSpecificationSurrogate.meta,
      implicitRules =
        Uri.of(
          this@SubstanceSpecificationSurrogate.implicitRules,
          this@SubstanceSpecificationSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@SubstanceSpecificationSurrogate.language,
          this@SubstanceSpecificationSurrogate._language,
        ),
      text = this@SubstanceSpecificationSurrogate.text,
      contained = this@SubstanceSpecificationSurrogate.contained ?: listOf(),
      extension = this@SubstanceSpecificationSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceSpecificationSurrogate.modifierExtension ?: listOf(),
      identifier = this@SubstanceSpecificationSurrogate.identifier,
      type = this@SubstanceSpecificationSurrogate.type,
      status = this@SubstanceSpecificationSurrogate.status,
      domain = this@SubstanceSpecificationSurrogate.domain,
      description =
        R4String.of(
          this@SubstanceSpecificationSurrogate.description,
          this@SubstanceSpecificationSurrogate._description,
        ),
      source = this@SubstanceSpecificationSurrogate.source ?: listOf(),
      comment =
        R4String.of(
          this@SubstanceSpecificationSurrogate.comment,
          this@SubstanceSpecificationSurrogate._comment,
        ),
      moiety = this@SubstanceSpecificationSurrogate.moiety ?: listOf(),
      `property` = this@SubstanceSpecificationSurrogate.`property` ?: listOf(),
      referenceInformation = this@SubstanceSpecificationSurrogate.referenceInformation,
      structure = this@SubstanceSpecificationSurrogate.structure,
      code = this@SubstanceSpecificationSurrogate.code ?: listOf(),
      name = this@SubstanceSpecificationSurrogate.name ?: listOf(),
      molecularWeight = this@SubstanceSpecificationSurrogate.molecularWeight ?: listOf(),
      relationship = this@SubstanceSpecificationSurrogate.relationship ?: listOf(),
      nucleicAcid = this@SubstanceSpecificationSurrogate.nucleicAcid,
      polymer = this@SubstanceSpecificationSurrogate.polymer,
      protein = this@SubstanceSpecificationSurrogate.protein,
      sourceMaterial = this@SubstanceSpecificationSurrogate.sourceMaterial,
    )

  public companion object {
    public fun fromModel(model: SubstanceSpecification): SubstanceSpecificationSurrogate =
      with(model) {
        SubstanceSpecificationSurrogate(
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
          identifier = this@with.identifier,
          type = this@with.type,
          status = this@with.status,
          domain = this@with.domain,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          source = this@with.source.takeIf { it.isNotEmpty() },
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
          moiety = this@with.moiety.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          referenceInformation = this@with.referenceInformation,
          structure = this@with.structure,
          code = this@with.code.takeIf { it.isNotEmpty() },
          name = this@with.name.takeIf { it.isNotEmpty() },
          molecularWeight = this@with.molecularWeight.takeIf { it.isNotEmpty() },
          relationship = this@with.relationship.takeIf { it.isNotEmpty() },
          nucleicAcid = this@with.nucleicAcid,
          polymer = this@with.polymer,
          protein = this@with.protein,
          sourceMaterial = this@with.sourceMaterial,
        )
      }
  }
}
