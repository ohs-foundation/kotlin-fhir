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

import com.google.fhir.model.r4.Base64Binary
import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Dosage
import com.google.fhir.model.r4.Duration
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Markdown
import com.google.fhir.model.r4.MedicationKnowledge
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Money
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Ratio
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
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
internal data class MedicationKnowledgeRelatedMedicationKnowledgeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var reference: List<Reference>? = null,
) {
  public fun toModel(): MedicationKnowledge.RelatedMedicationKnowledge =
    MedicationKnowledge.RelatedMedicationKnowledge(
      id = this@MedicationKnowledgeRelatedMedicationKnowledgeSurrogate.id,
      extension = this@MedicationKnowledgeRelatedMedicationKnowledgeSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeRelatedMedicationKnowledgeSurrogate.modifierExtension ?: listOf(),
      type = this@MedicationKnowledgeRelatedMedicationKnowledgeSurrogate.type,
      reference = this@MedicationKnowledgeRelatedMedicationKnowledgeSurrogate.reference ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.RelatedMedicationKnowledge
    ): MedicationKnowledgeRelatedMedicationKnowledgeSurrogate =
      with(model) {
        MedicationKnowledgeRelatedMedicationKnowledgeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          reference = this@with.reference.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeMonographSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var source: Reference? = null,
) {
  public fun toModel(): MedicationKnowledge.Monograph =
    MedicationKnowledge.Monograph(
      id = this@MedicationKnowledgeMonographSurrogate.id,
      extension = this@MedicationKnowledgeMonographSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationKnowledgeMonographSurrogate.modifierExtension ?: listOf(),
      type = this@MedicationKnowledgeMonographSurrogate.type,
      source = this@MedicationKnowledgeMonographSurrogate.source,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Monograph
    ): MedicationKnowledgeMonographSurrogate =
      with(model) {
        MedicationKnowledgeMonographSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          source = this@with.source,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeIngredientSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: MedicationKnowledge.Ingredient.Item,
  public var isActive: KotlinBoolean? = null,
  public var _isActive: Element? = null,
  public var strength: Ratio? = null,
) {
  public fun toModel(): MedicationKnowledge.Ingredient =
    MedicationKnowledge.Ingredient(
      id = this@MedicationKnowledgeIngredientSurrogate.id,
      extension = this@MedicationKnowledgeIngredientSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationKnowledgeIngredientSurrogate.modifierExtension ?: listOf(),
      item = this@MedicationKnowledgeIngredientSurrogate.item,
      isActive =
        R4Boolean.of(
          this@MedicationKnowledgeIngredientSurrogate.isActive,
          this@MedicationKnowledgeIngredientSurrogate._isActive,
        ),
      strength = this@MedicationKnowledgeIngredientSurrogate.strength,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Ingredient
    ): MedicationKnowledgeIngredientSurrogate =
      with(model) {
        MedicationKnowledgeIngredientSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
          isActive = this@with.isActive?.value,
          _isActive = this@with.isActive?.toElement(),
          strength = this@with.strength,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeCostSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var source: KotlinString? = null,
  public var _source: Element? = null,
  public var cost: Money,
) {
  public fun toModel(): MedicationKnowledge.Cost =
    MedicationKnowledge.Cost(
      id = this@MedicationKnowledgeCostSurrogate.id,
      extension = this@MedicationKnowledgeCostSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationKnowledgeCostSurrogate.modifierExtension ?: listOf(),
      type = this@MedicationKnowledgeCostSurrogate.type,
      source =
        R4String.of(
          this@MedicationKnowledgeCostSurrogate.source,
          this@MedicationKnowledgeCostSurrogate._source,
        ),
      cost = this@MedicationKnowledgeCostSurrogate.cost,
    )

  public companion object {
    public fun fromModel(model: MedicationKnowledge.Cost): MedicationKnowledgeCostSurrogate =
      with(model) {
        MedicationKnowledgeCostSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          source = this@with.source?.value,
          _source = this@with.source?.toElement(),
          cost = this@with.cost,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeMonitoringProgramSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
) {
  public fun toModel(): MedicationKnowledge.MonitoringProgram =
    MedicationKnowledge.MonitoringProgram(
      id = this@MedicationKnowledgeMonitoringProgramSurrogate.id,
      extension = this@MedicationKnowledgeMonitoringProgramSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeMonitoringProgramSurrogate.modifierExtension ?: listOf(),
      type = this@MedicationKnowledgeMonitoringProgramSurrogate.type,
      name =
        R4String.of(
          this@MedicationKnowledgeMonitoringProgramSurrogate.name,
          this@MedicationKnowledgeMonitoringProgramSurrogate._name,
        ),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.MonitoringProgram
    ): MedicationKnowledgeMonitoringProgramSurrogate =
      with(model) {
        MedicationKnowledgeMonitoringProgramSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeAdministrationGuidelinesSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var dosage: List<MedicationKnowledge.AdministrationGuidelines.Dosage>? = null,
  public var indication: MedicationKnowledge.AdministrationGuidelines.Indication? = null,
  public var patientCharacteristics:
    List<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics>? =
    null,
) {
  public fun toModel(): MedicationKnowledge.AdministrationGuidelines =
    MedicationKnowledge.AdministrationGuidelines(
      id = this@MedicationKnowledgeAdministrationGuidelinesSurrogate.id,
      extension = this@MedicationKnowledgeAdministrationGuidelinesSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeAdministrationGuidelinesSurrogate.modifierExtension ?: listOf(),
      dosage = this@MedicationKnowledgeAdministrationGuidelinesSurrogate.dosage ?: listOf(),
      indication = this@MedicationKnowledgeAdministrationGuidelinesSurrogate.indication,
      patientCharacteristics =
        this@MedicationKnowledgeAdministrationGuidelinesSurrogate.patientCharacteristics ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.AdministrationGuidelines
    ): MedicationKnowledgeAdministrationGuidelinesSurrogate =
      with(model) {
        MedicationKnowledgeAdministrationGuidelinesSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          dosage = this@with.dosage.takeIf { it.isNotEmpty() },
          indication = this@with.indication,
          patientCharacteristics = this@with.patientCharacteristics.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeAdministrationGuidelinesDosageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var dosage: List<Dosage>? = null,
) {
  public fun toModel(): MedicationKnowledge.AdministrationGuidelines.Dosage =
    MedicationKnowledge.AdministrationGuidelines.Dosage(
      id = this@MedicationKnowledgeAdministrationGuidelinesDosageSurrogate.id,
      extension =
        this@MedicationKnowledgeAdministrationGuidelinesDosageSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeAdministrationGuidelinesDosageSurrogate.modifierExtension
          ?: listOf(),
      type = this@MedicationKnowledgeAdministrationGuidelinesDosageSurrogate.type,
      dosage = this@MedicationKnowledgeAdministrationGuidelinesDosageSurrogate.dosage ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.AdministrationGuidelines.Dosage
    ): MedicationKnowledgeAdministrationGuidelinesDosageSurrogate =
      with(model) {
        MedicationKnowledgeAdministrationGuidelinesDosageSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          dosage = this@with.dosage.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var characteristic:
    MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic,
  public var `value`: List<KotlinString?>? = null,
  public var _value: List<Element?>? = null,
) {
  public fun toModel(): MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics =
    MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics(
      id = this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate.id,
      extension =
        this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate.extension
          ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate
          .modifierExtension ?: listOf(),
      characteristic =
        this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate
          .characteristic,
      `value` =
        if (
          this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate.`value` ==
            null &&
            this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate
              ._value == null
        ) {
          listOf()
        } else {
          (this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate.`value`
              ?: List(
                this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate
                  ._value!!
                  .size
              ) {
                null
              })
            .zip(
              this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate._value
                ?: List(
                  this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate
                    .`value`!!
                    .size
                ) {
                  null
                }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics
    ): MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate =
      with(model) {
        MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          characteristic = this@with.characteristic,
          `value` =
            this@with.`value`.map { it.value }.toList().takeUnless { it.all { it == null } },
          _value =
            this@with.`value`
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeMedicineClassificationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var classification: List<CodeableConcept>? = null,
) {
  public fun toModel(): MedicationKnowledge.MedicineClassification =
    MedicationKnowledge.MedicineClassification(
      id = this@MedicationKnowledgeMedicineClassificationSurrogate.id,
      extension = this@MedicationKnowledgeMedicineClassificationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeMedicineClassificationSurrogate.modifierExtension ?: listOf(),
      type = this@MedicationKnowledgeMedicineClassificationSurrogate.type,
      classification =
        this@MedicationKnowledgeMedicineClassificationSurrogate.classification ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.MedicineClassification
    ): MedicationKnowledgeMedicineClassificationSurrogate =
      with(model) {
        MedicationKnowledgeMedicineClassificationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          classification = this@with.classification.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgePackagingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var quantity: Quantity? = null,
) {
  public fun toModel(): MedicationKnowledge.Packaging =
    MedicationKnowledge.Packaging(
      id = this@MedicationKnowledgePackagingSurrogate.id,
      extension = this@MedicationKnowledgePackagingSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationKnowledgePackagingSurrogate.modifierExtension ?: listOf(),
      type = this@MedicationKnowledgePackagingSurrogate.type,
      quantity = this@MedicationKnowledgePackagingSurrogate.quantity,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Packaging
    ): MedicationKnowledgePackagingSurrogate =
      with(model) {
        MedicationKnowledgePackagingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          quantity = this@with.quantity,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeDrugCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var `value`: MedicationKnowledge.DrugCharacteristic.Value? = null,
) {
  public fun toModel(): MedicationKnowledge.DrugCharacteristic =
    MedicationKnowledge.DrugCharacteristic(
      id = this@MedicationKnowledgeDrugCharacteristicSurrogate.id,
      extension = this@MedicationKnowledgeDrugCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeDrugCharacteristicSurrogate.modifierExtension ?: listOf(),
      type = this@MedicationKnowledgeDrugCharacteristicSurrogate.type,
      `value` = this@MedicationKnowledgeDrugCharacteristicSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.DrugCharacteristic
    ): MedicationKnowledgeDrugCharacteristicSurrogate =
      with(model) {
        MedicationKnowledgeDrugCharacteristicSurrogate(
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
internal data class MedicationKnowledgeRegulatorySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var regulatoryAuthority: Reference,
  public var substitution: List<MedicationKnowledge.Regulatory.Substitution>? = null,
  public var schedule: List<MedicationKnowledge.Regulatory.Schedule>? = null,
  public var maxDispense: MedicationKnowledge.Regulatory.MaxDispense? = null,
) {
  public fun toModel(): MedicationKnowledge.Regulatory =
    MedicationKnowledge.Regulatory(
      id = this@MedicationKnowledgeRegulatorySurrogate.id,
      extension = this@MedicationKnowledgeRegulatorySurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationKnowledgeRegulatorySurrogate.modifierExtension ?: listOf(),
      regulatoryAuthority = this@MedicationKnowledgeRegulatorySurrogate.regulatoryAuthority,
      substitution = this@MedicationKnowledgeRegulatorySurrogate.substitution ?: listOf(),
      schedule = this@MedicationKnowledgeRegulatorySurrogate.schedule ?: listOf(),
      maxDispense = this@MedicationKnowledgeRegulatorySurrogate.maxDispense,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Regulatory
    ): MedicationKnowledgeRegulatorySurrogate =
      with(model) {
        MedicationKnowledgeRegulatorySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          regulatoryAuthority = this@with.regulatoryAuthority,
          substitution = this@with.substitution.takeIf { it.isNotEmpty() },
          schedule = this@with.schedule.takeIf { it.isNotEmpty() },
          maxDispense = this@with.maxDispense,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeRegulatorySubstitutionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var allowed: KotlinBoolean? = null,
  public var _allowed: Element? = null,
) {
  public fun toModel(): MedicationKnowledge.Regulatory.Substitution =
    MedicationKnowledge.Regulatory.Substitution(
      id = this@MedicationKnowledgeRegulatorySubstitutionSurrogate.id,
      extension = this@MedicationKnowledgeRegulatorySubstitutionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeRegulatorySubstitutionSurrogate.modifierExtension ?: listOf(),
      type = this@MedicationKnowledgeRegulatorySubstitutionSurrogate.type,
      allowed =
        R4Boolean.of(
          this@MedicationKnowledgeRegulatorySubstitutionSurrogate.allowed,
          this@MedicationKnowledgeRegulatorySubstitutionSurrogate._allowed,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Regulatory.Substitution
    ): MedicationKnowledgeRegulatorySubstitutionSurrogate =
      with(model) {
        MedicationKnowledgeRegulatorySubstitutionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          allowed = this@with.allowed.value,
          _allowed = this@with.allowed.toElement(),
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeRegulatoryScheduleSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var schedule: CodeableConcept,
) {
  public fun toModel(): MedicationKnowledge.Regulatory.Schedule =
    MedicationKnowledge.Regulatory.Schedule(
      id = this@MedicationKnowledgeRegulatoryScheduleSurrogate.id,
      extension = this@MedicationKnowledgeRegulatoryScheduleSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeRegulatoryScheduleSurrogate.modifierExtension ?: listOf(),
      schedule = this@MedicationKnowledgeRegulatoryScheduleSurrogate.schedule,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Regulatory.Schedule
    ): MedicationKnowledgeRegulatoryScheduleSurrogate =
      with(model) {
        MedicationKnowledgeRegulatoryScheduleSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          schedule = this@with.schedule,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeRegulatoryMaxDispenseSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var quantity: Quantity,
  public var period: Duration? = null,
) {
  public fun toModel(): MedicationKnowledge.Regulatory.MaxDispense =
    MedicationKnowledge.Regulatory.MaxDispense(
      id = this@MedicationKnowledgeRegulatoryMaxDispenseSurrogate.id,
      extension = this@MedicationKnowledgeRegulatoryMaxDispenseSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeRegulatoryMaxDispenseSurrogate.modifierExtension ?: listOf(),
      quantity = this@MedicationKnowledgeRegulatoryMaxDispenseSurrogate.quantity,
      period = this@MedicationKnowledgeRegulatoryMaxDispenseSurrogate.period,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Regulatory.MaxDispense
    ): MedicationKnowledgeRegulatoryMaxDispenseSurrogate =
      with(model) {
        MedicationKnowledgeRegulatoryMaxDispenseSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeKineticsSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var areaUnderCurve: List<Quantity>? = null,
  public var lethalDose50: List<Quantity>? = null,
  public var halfLifePeriod: Duration? = null,
) {
  public fun toModel(): MedicationKnowledge.Kinetics =
    MedicationKnowledge.Kinetics(
      id = this@MedicationKnowledgeKineticsSurrogate.id,
      extension = this@MedicationKnowledgeKineticsSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationKnowledgeKineticsSurrogate.modifierExtension ?: listOf(),
      areaUnderCurve = this@MedicationKnowledgeKineticsSurrogate.areaUnderCurve ?: listOf(),
      lethalDose50 = this@MedicationKnowledgeKineticsSurrogate.lethalDose50 ?: listOf(),
      halfLifePeriod = this@MedicationKnowledgeKineticsSurrogate.halfLifePeriod,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Kinetics
    ): MedicationKnowledgeKineticsSurrogate =
      with(model) {
        MedicationKnowledgeKineticsSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          areaUnderCurve = this@with.areaUnderCurve.takeIf { it.isNotEmpty() },
          lethalDose50 = this@with.lethalDose50.takeIf { it.isNotEmpty() },
          halfLifePeriod = this@with.halfLifePeriod,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeIngredientItemSurrogate(
  public var itemCodeableConcept: CodeableConcept? = null,
  public var itemReference: Reference? = null,
) {
  public fun toModel(): MedicationKnowledge.Ingredient.Item =
    MedicationKnowledge.Ingredient.Item.from(
      this@MedicationKnowledgeIngredientItemSurrogate.itemCodeableConcept,
      this@MedicationKnowledgeIngredientItemSurrogate.itemReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Ingredient.Item
    ): MedicationKnowledgeIngredientItemSurrogate =
      with(model) {
        MedicationKnowledgeIngredientItemSurrogate(
          itemCodeableConcept = this@with.asCodeableConcept()?.value,
          itemReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeAdministrationGuidelinesIndicationSurrogate(
  public var indicationCodeableConcept: CodeableConcept? = null,
  public var indicationReference: Reference? = null,
) {
  public fun toModel(): MedicationKnowledge.AdministrationGuidelines.Indication =
    MedicationKnowledge.AdministrationGuidelines.Indication.from(
      this@MedicationKnowledgeAdministrationGuidelinesIndicationSurrogate.indicationCodeableConcept,
      this@MedicationKnowledgeAdministrationGuidelinesIndicationSurrogate.indicationReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.AdministrationGuidelines.Indication
    ): MedicationKnowledgeAdministrationGuidelinesIndicationSurrogate =
      with(model) {
        MedicationKnowledgeAdministrationGuidelinesIndicationSurrogate(
          indicationCodeableConcept = this@with.asCodeableConcept()?.value,
          indicationReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsCharacteristicSurrogate(
  public var characteristicCodeableConcept: CodeableConcept? = null,
  public var characteristicQuantity: Quantity? = null,
) {
  public fun toModel():
    MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic =
    MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.from(
      this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsCharacteristicSurrogate
        .characteristicCodeableConcept,
      this@MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsCharacteristicSurrogate
        .characteristicQuantity,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic
    ): MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsCharacteristicSurrogate =
      with(model) {
        MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsCharacteristicSurrogate(
          characteristicCodeableConcept = this@with.asCodeableConcept()?.value,
          characteristicQuantity = this@with.asQuantity()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeDrugCharacteristicValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueQuantity: Quantity? = null,
  public var valueBase64Binary: KotlinString? = null,
  public var _valueBase64Binary: Element? = null,
) {
  public fun toModel(): MedicationKnowledge.DrugCharacteristic.Value =
    MedicationKnowledge.DrugCharacteristic.Value.from(
      this@MedicationKnowledgeDrugCharacteristicValueSurrogate.valueCodeableConcept,
      R4String.of(
        this@MedicationKnowledgeDrugCharacteristicValueSurrogate.valueString,
        this@MedicationKnowledgeDrugCharacteristicValueSurrogate._valueString,
      ),
      this@MedicationKnowledgeDrugCharacteristicValueSurrogate.valueQuantity,
      Base64Binary.of(
        this@MedicationKnowledgeDrugCharacteristicValueSurrogate.valueBase64Binary,
        this@MedicationKnowledgeDrugCharacteristicValueSurrogate._valueBase64Binary,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.DrugCharacteristic.Value
    ): MedicationKnowledgeDrugCharacteristicValueSurrogate =
      with(model) {
        MedicationKnowledgeDrugCharacteristicValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueQuantity = this@with.asQuantity()?.value,
          valueBase64Binary = this@with.asBase64Binary()?.value?.value,
          _valueBase64Binary = this@with.asBase64Binary()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeSurrogate(
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
  public var code: CodeableConcept? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var manufacturer: Reference? = null,
  public var doseForm: CodeableConcept? = null,
  public var amount: Quantity? = null,
  public var synonym: List<KotlinString?>? = null,
  public var _synonym: List<Element?>? = null,
  public var relatedMedicationKnowledge: List<MedicationKnowledge.RelatedMedicationKnowledge>? =
    null,
  public var associatedMedication: List<Reference>? = null,
  public var productType: List<CodeableConcept>? = null,
  public var monograph: List<MedicationKnowledge.Monograph>? = null,
  public var ingredient: List<MedicationKnowledge.Ingredient>? = null,
  public var preparationInstruction: KotlinString? = null,
  public var _preparationInstruction: Element? = null,
  public var intendedRoute: List<CodeableConcept>? = null,
  public var cost: List<MedicationKnowledge.Cost>? = null,
  public var monitoringProgram: List<MedicationKnowledge.MonitoringProgram>? = null,
  public var administrationGuidelines: List<MedicationKnowledge.AdministrationGuidelines>? = null,
  public var medicineClassification: List<MedicationKnowledge.MedicineClassification>? = null,
  public var packaging: MedicationKnowledge.Packaging? = null,
  public var drugCharacteristic: List<MedicationKnowledge.DrugCharacteristic>? = null,
  public var contraindication: List<Reference>? = null,
  public var regulatory: List<MedicationKnowledge.Regulatory>? = null,
  public var kinetics: List<MedicationKnowledge.Kinetics>? = null,
) {
  public fun toModel(): MedicationKnowledge =
    MedicationKnowledge(
      id = this@MedicationKnowledgeSurrogate.id,
      meta = this@MedicationKnowledgeSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicationKnowledgeSurrogate.implicitRules,
          this@MedicationKnowledgeSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MedicationKnowledgeSurrogate.language,
          this@MedicationKnowledgeSurrogate._language,
        ),
      text = this@MedicationKnowledgeSurrogate.text,
      contained = this@MedicationKnowledgeSurrogate.contained ?: listOf(),
      extension = this@MedicationKnowledgeSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationKnowledgeSurrogate.modifierExtension ?: listOf(),
      code = this@MedicationKnowledgeSurrogate.code,
      status =
        this@MedicationKnowledgeSurrogate.status?.let {
          Enumeration.of(
            MedicationKnowledge.MedicationKnowledgeStatusCodes.fromCode(it),
            this@MedicationKnowledgeSurrogate._status,
          )
        },
      manufacturer = this@MedicationKnowledgeSurrogate.manufacturer,
      doseForm = this@MedicationKnowledgeSurrogate.doseForm,
      amount = this@MedicationKnowledgeSurrogate.amount,
      synonym =
        if (
          this@MedicationKnowledgeSurrogate.synonym == null &&
            this@MedicationKnowledgeSurrogate._synonym == null
        ) {
          listOf()
        } else {
          (this@MedicationKnowledgeSurrogate.synonym
              ?: List(this@MedicationKnowledgeSurrogate._synonym!!.size) { null })
            .zip(
              this@MedicationKnowledgeSurrogate._synonym
                ?: List(this@MedicationKnowledgeSurrogate.synonym!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      relatedMedicationKnowledge =
        this@MedicationKnowledgeSurrogate.relatedMedicationKnowledge ?: listOf(),
      associatedMedication = this@MedicationKnowledgeSurrogate.associatedMedication ?: listOf(),
      productType = this@MedicationKnowledgeSurrogate.productType ?: listOf(),
      monograph = this@MedicationKnowledgeSurrogate.monograph ?: listOf(),
      ingredient = this@MedicationKnowledgeSurrogate.ingredient ?: listOf(),
      preparationInstruction =
        Markdown.of(
          this@MedicationKnowledgeSurrogate.preparationInstruction,
          this@MedicationKnowledgeSurrogate._preparationInstruction,
        ),
      intendedRoute = this@MedicationKnowledgeSurrogate.intendedRoute ?: listOf(),
      cost = this@MedicationKnowledgeSurrogate.cost ?: listOf(),
      monitoringProgram = this@MedicationKnowledgeSurrogate.monitoringProgram ?: listOf(),
      administrationGuidelines =
        this@MedicationKnowledgeSurrogate.administrationGuidelines ?: listOf(),
      medicineClassification = this@MedicationKnowledgeSurrogate.medicineClassification ?: listOf(),
      packaging = this@MedicationKnowledgeSurrogate.packaging,
      drugCharacteristic = this@MedicationKnowledgeSurrogate.drugCharacteristic ?: listOf(),
      contraindication = this@MedicationKnowledgeSurrogate.contraindication ?: listOf(),
      regulatory = this@MedicationKnowledgeSurrogate.regulatory ?: listOf(),
      kinetics = this@MedicationKnowledgeSurrogate.kinetics ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MedicationKnowledge): MedicationKnowledgeSurrogate =
      with(model) {
        MedicationKnowledgeSurrogate(
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
          code = this@with.code,
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          manufacturer = this@with.manufacturer,
          doseForm = this@with.doseForm,
          amount = this@with.amount,
          synonym =
            this@with.synonym.map { it.value }.toList().takeUnless { it.all { it == null } },
          _synonym =
            this@with.synonym
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          relatedMedicationKnowledge =
            this@with.relatedMedicationKnowledge.takeIf { it.isNotEmpty() },
          associatedMedication = this@with.associatedMedication.takeIf { it.isNotEmpty() },
          productType = this@with.productType.takeIf { it.isNotEmpty() },
          monograph = this@with.monograph.takeIf { it.isNotEmpty() },
          ingredient = this@with.ingredient.takeIf { it.isNotEmpty() },
          preparationInstruction = this@with.preparationInstruction?.value,
          _preparationInstruction = this@with.preparationInstruction?.toElement(),
          intendedRoute = this@with.intendedRoute.takeIf { it.isNotEmpty() },
          cost = this@with.cost.takeIf { it.isNotEmpty() },
          monitoringProgram = this@with.monitoringProgram.takeIf { it.isNotEmpty() },
          administrationGuidelines = this@with.administrationGuidelines.takeIf { it.isNotEmpty() },
          medicineClassification = this@with.medicineClassification.takeIf { it.isNotEmpty() },
          packaging = this@with.packaging,
          drugCharacteristic = this@with.drugCharacteristic.takeIf { it.isNotEmpty() },
          contraindication = this@with.contraindication.takeIf { it.isNotEmpty() },
          regulatory = this@with.regulatory.takeIf { it.isNotEmpty() },
          kinetics = this@with.kinetics.takeIf { it.isNotEmpty() },
        )
      }
  }
}
