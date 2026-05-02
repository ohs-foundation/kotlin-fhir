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

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Base64Binary
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Dosage
import com.google.fhir.model.r5.Duration
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.MedicationKnowledge
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Money
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Ratio
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
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
internal data class MedicationKnowledgeCostSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var effectiveDate: List<Period>? = null,
  public var type: CodeableConcept,
  public var source: KotlinString? = null,
  public var _source: Element? = null,
  public var cost: MedicationKnowledge.Cost.Cost,
) {
  public fun toModel(): MedicationKnowledge.Cost =
    MedicationKnowledge.Cost(
      id = this@MedicationKnowledgeCostSurrogate.id,
      extension = this@MedicationKnowledgeCostSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationKnowledgeCostSurrogate.modifierExtension ?: listOf(),
      effectiveDate = this@MedicationKnowledgeCostSurrogate.effectiveDate ?: listOf(),
      type = this@MedicationKnowledgeCostSurrogate.type,
      source =
        R5String.of(
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
          effectiveDate = this@with.effectiveDate.takeIf { it.isNotEmpty() },
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
        R5String.of(
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
internal data class MedicationKnowledgeIndicationGuidelineSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var indication: List<CodeableReference>? = null,
  public var dosingGuideline: List<MedicationKnowledge.IndicationGuideline.DosingGuideline>? = null,
) {
  public fun toModel(): MedicationKnowledge.IndicationGuideline =
    MedicationKnowledge.IndicationGuideline(
      id = this@MedicationKnowledgeIndicationGuidelineSurrogate.id,
      extension = this@MedicationKnowledgeIndicationGuidelineSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeIndicationGuidelineSurrogate.modifierExtension ?: listOf(),
      indication = this@MedicationKnowledgeIndicationGuidelineSurrogate.indication ?: listOf(),
      dosingGuideline =
        this@MedicationKnowledgeIndicationGuidelineSurrogate.dosingGuideline ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.IndicationGuideline
    ): MedicationKnowledgeIndicationGuidelineSurrogate =
      with(model) {
        MedicationKnowledgeIndicationGuidelineSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          indication = this@with.indication.takeIf { it.isNotEmpty() },
          dosingGuideline = this@with.dosingGuideline.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var treatmentIntent: CodeableConcept? = null,
  public var dosage: List<MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage>? = null,
  public var administrationTreatment: CodeableConcept? = null,
  public var patientCharacteristic:
    List<MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic>? =
    null,
) {
  public fun toModel(): MedicationKnowledge.IndicationGuideline.DosingGuideline =
    MedicationKnowledge.IndicationGuideline.DosingGuideline(
      id = this@MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate.id,
      extension =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate.modifierExtension
          ?: listOf(),
      treatmentIntent =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate.treatmentIntent,
      dosage =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate.dosage ?: listOf(),
      administrationTreatment =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate.administrationTreatment,
      patientCharacteristic =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate.patientCharacteristic
          ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.IndicationGuideline.DosingGuideline
    ): MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate =
      with(model) {
        MedicationKnowledgeIndicationGuidelineDosingGuidelineSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          treatmentIntent = this@with.treatmentIntent,
          dosage = this@with.dosage.takeIf { it.isNotEmpty() },
          administrationTreatment = this@with.administrationTreatment,
          patientCharacteristic = this@with.patientCharacteristic.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var dosage: List<Dosage>? = null,
) {
  public fun toModel(): MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage =
    MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage(
      id = this@MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSurrogate.id,
      extension =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSurrogate.extension
          ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSurrogate.modifierExtension
          ?: listOf(),
      type = this@MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSurrogate.type,
      dosage =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSurrogate.dosage ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage
    ): MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSurrogate =
      with(model) {
        MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSurrogate(
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
internal data class MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`:
    MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value? =
    null,
) {
  public fun toModel():
    MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic =
    MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic(
      id =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSurrogate.id,
      extension =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSurrogate
          .extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSurrogate
          .modifierExtension ?: listOf(),
      type =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSurrogate
          .type,
      `value` =
        this@MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSurrogate
          .`value`,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic
    ): MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSurrogate =
      with(model) {
        MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSurrogate(
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
internal data class MedicationKnowledgeMedicineClassificationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var source: MedicationKnowledge.MedicineClassification.Source? = null,
  public var classification: List<CodeableConcept>? = null,
) {
  public fun toModel(): MedicationKnowledge.MedicineClassification =
    MedicationKnowledge.MedicineClassification(
      id = this@MedicationKnowledgeMedicineClassificationSurrogate.id,
      extension = this@MedicationKnowledgeMedicineClassificationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeMedicineClassificationSurrogate.modifierExtension ?: listOf(),
      type = this@MedicationKnowledgeMedicineClassificationSurrogate.type,
      source = this@MedicationKnowledgeMedicineClassificationSurrogate.source,
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
          source = this@with.source,
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
  public var cost: List<MedicationKnowledge.Cost>? = null,
  public var packagedProduct: Reference? = null,
) {
  public fun toModel(): MedicationKnowledge.Packaging =
    MedicationKnowledge.Packaging(
      id = this@MedicationKnowledgePackagingSurrogate.id,
      extension = this@MedicationKnowledgePackagingSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicationKnowledgePackagingSurrogate.modifierExtension ?: listOf(),
      cost = this@MedicationKnowledgePackagingSurrogate.cost ?: listOf(),
      packagedProduct = this@MedicationKnowledgePackagingSurrogate.packagedProduct,
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
          cost = this@with.cost.takeIf { it.isNotEmpty() },
          packagedProduct = this@with.packagedProduct,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeStorageGuidelineSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var reference: KotlinString? = null,
  public var _reference: Element? = null,
  public var note: List<Annotation>? = null,
  public var stabilityDuration: Duration? = null,
  public var environmentalSetting:
    List<MedicationKnowledge.StorageGuideline.EnvironmentalSetting>? =
    null,
) {
  public fun toModel(): MedicationKnowledge.StorageGuideline =
    MedicationKnowledge.StorageGuideline(
      id = this@MedicationKnowledgeStorageGuidelineSurrogate.id,
      extension = this@MedicationKnowledgeStorageGuidelineSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeStorageGuidelineSurrogate.modifierExtension ?: listOf(),
      reference =
        Uri.of(
          this@MedicationKnowledgeStorageGuidelineSurrogate.reference,
          this@MedicationKnowledgeStorageGuidelineSurrogate._reference,
        ),
      note = this@MedicationKnowledgeStorageGuidelineSurrogate.note ?: listOf(),
      stabilityDuration = this@MedicationKnowledgeStorageGuidelineSurrogate.stabilityDuration,
      environmentalSetting =
        this@MedicationKnowledgeStorageGuidelineSurrogate.environmentalSetting ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.StorageGuideline
    ): MedicationKnowledgeStorageGuidelineSurrogate =
      with(model) {
        MedicationKnowledgeStorageGuidelineSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          reference = this@with.reference?.value,
          _reference = this@with.reference?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          stabilityDuration = this@with.stabilityDuration,
          environmentalSetting = this@with.environmentalSetting.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeStorageGuidelineEnvironmentalSettingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value,
) {
  public fun toModel(): MedicationKnowledge.StorageGuideline.EnvironmentalSetting =
    MedicationKnowledge.StorageGuideline.EnvironmentalSetting(
      id = this@MedicationKnowledgeStorageGuidelineEnvironmentalSettingSurrogate.id,
      extension =
        this@MedicationKnowledgeStorageGuidelineEnvironmentalSettingSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeStorageGuidelineEnvironmentalSettingSurrogate.modifierExtension
          ?: listOf(),
      type = this@MedicationKnowledgeStorageGuidelineEnvironmentalSettingSurrogate.type,
      `value` = this@MedicationKnowledgeStorageGuidelineEnvironmentalSettingSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.StorageGuideline.EnvironmentalSetting
    ): MedicationKnowledgeStorageGuidelineEnvironmentalSettingSurrogate =
      with(model) {
        MedicationKnowledgeStorageGuidelineEnvironmentalSettingSurrogate(
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
  public var schedule: List<CodeableConcept>? = null,
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
        R5Boolean.of(
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
internal data class MedicationKnowledgeDefinitionalSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var definition: List<Reference>? = null,
  public var doseForm: CodeableConcept? = null,
  public var intendedRoute: List<CodeableConcept>? = null,
  public var ingredient: List<MedicationKnowledge.Definitional.Ingredient>? = null,
  public var drugCharacteristic: List<MedicationKnowledge.Definitional.DrugCharacteristic>? = null,
) {
  public fun toModel(): MedicationKnowledge.Definitional =
    MedicationKnowledge.Definitional(
      id = this@MedicationKnowledgeDefinitionalSurrogate.id,
      extension = this@MedicationKnowledgeDefinitionalSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeDefinitionalSurrogate.modifierExtension ?: listOf(),
      definition = this@MedicationKnowledgeDefinitionalSurrogate.definition ?: listOf(),
      doseForm = this@MedicationKnowledgeDefinitionalSurrogate.doseForm,
      intendedRoute = this@MedicationKnowledgeDefinitionalSurrogate.intendedRoute ?: listOf(),
      ingredient = this@MedicationKnowledgeDefinitionalSurrogate.ingredient ?: listOf(),
      drugCharacteristic =
        this@MedicationKnowledgeDefinitionalSurrogate.drugCharacteristic ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Definitional
    ): MedicationKnowledgeDefinitionalSurrogate =
      with(model) {
        MedicationKnowledgeDefinitionalSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          definition = this@with.definition.takeIf { it.isNotEmpty() },
          doseForm = this@with.doseForm,
          intendedRoute = this@with.intendedRoute.takeIf { it.isNotEmpty() },
          ingredient = this@with.ingredient.takeIf { it.isNotEmpty() },
          drugCharacteristic = this@with.drugCharacteristic.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeDefinitionalIngredientSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: CodeableReference,
  public var type: CodeableConcept? = null,
  public var strength: MedicationKnowledge.Definitional.Ingredient.Strength? = null,
) {
  public fun toModel(): MedicationKnowledge.Definitional.Ingredient =
    MedicationKnowledge.Definitional.Ingredient(
      id = this@MedicationKnowledgeDefinitionalIngredientSurrogate.id,
      extension = this@MedicationKnowledgeDefinitionalIngredientSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeDefinitionalIngredientSurrogate.modifierExtension ?: listOf(),
      item = this@MedicationKnowledgeDefinitionalIngredientSurrogate.item,
      type = this@MedicationKnowledgeDefinitionalIngredientSurrogate.type,
      strength = this@MedicationKnowledgeDefinitionalIngredientSurrogate.strength,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Definitional.Ingredient
    ): MedicationKnowledgeDefinitionalIngredientSurrogate =
      with(model) {
        MedicationKnowledgeDefinitionalIngredientSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
          type = this@with.type,
          strength = this@with.strength,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeDefinitionalDrugCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var `value`: MedicationKnowledge.Definitional.DrugCharacteristic.Value? = null,
) {
  public fun toModel(): MedicationKnowledge.Definitional.DrugCharacteristic =
    MedicationKnowledge.Definitional.DrugCharacteristic(
      id = this@MedicationKnowledgeDefinitionalDrugCharacteristicSurrogate.id,
      extension =
        this@MedicationKnowledgeDefinitionalDrugCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicationKnowledgeDefinitionalDrugCharacteristicSurrogate.modifierExtension
          ?: listOf(),
      type = this@MedicationKnowledgeDefinitionalDrugCharacteristicSurrogate.type,
      `value` = this@MedicationKnowledgeDefinitionalDrugCharacteristicSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Definitional.DrugCharacteristic
    ): MedicationKnowledgeDefinitionalDrugCharacteristicSurrogate =
      with(model) {
        MedicationKnowledgeDefinitionalDrugCharacteristicSurrogate(
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
internal data class MedicationKnowledgeCostCostSurrogate(
  public var costMoney: Money? = null,
  public var costCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): MedicationKnowledge.Cost.Cost =
    MedicationKnowledge.Cost.Cost.from(
      this@MedicationKnowledgeCostCostSurrogate.costMoney,
      this@MedicationKnowledgeCostCostSurrogate.costCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Cost.Cost
    ): MedicationKnowledgeCostCostSurrogate =
      with(model) {
        MedicationKnowledgeCostCostSurrogate(
          costMoney = this@with.asMoney()?.value,
          costCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
) {
  public fun toModel():
    MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value =
    MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value.from(
      this@MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicValueSurrogate
        .valueCodeableConcept,
      this@MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicValueSurrogate
        .valueQuantity,
      this@MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicValueSurrogate
        .valueRange,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value
    ): MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicValueSurrogate =
      with(model) {
        MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeMedicineClassificationSourceSurrogate(
  public var sourceString: KotlinString? = null,
  public var _sourceString: Element? = null,
  public var sourceUri: KotlinString? = null,
  public var _sourceUri: Element? = null,
) {
  public fun toModel(): MedicationKnowledge.MedicineClassification.Source =
    MedicationKnowledge.MedicineClassification.Source.from(
      R5String.of(
        this@MedicationKnowledgeMedicineClassificationSourceSurrogate.sourceString,
        this@MedicationKnowledgeMedicineClassificationSourceSurrogate._sourceString,
      ),
      Uri.of(
        this@MedicationKnowledgeMedicineClassificationSourceSurrogate.sourceUri,
        this@MedicationKnowledgeMedicineClassificationSourceSurrogate._sourceUri,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.MedicineClassification.Source
    ): MedicationKnowledgeMedicineClassificationSourceSurrogate =
      with(model) {
        MedicationKnowledgeMedicineClassificationSourceSurrogate(
          sourceString = this@with.asString()?.value?.value,
          _sourceString = this@with.asString()?.value?.toElement(),
          sourceUri = this@with.asUri()?.value?.value,
          _sourceUri = this@with.asUri()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeStorageGuidelineEnvironmentalSettingValueSurrogate(
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value =
    MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value.from(
      this@MedicationKnowledgeStorageGuidelineEnvironmentalSettingValueSurrogate.valueQuantity,
      this@MedicationKnowledgeStorageGuidelineEnvironmentalSettingValueSurrogate.valueRange,
      this@MedicationKnowledgeStorageGuidelineEnvironmentalSettingValueSurrogate
        .valueCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value
    ): MedicationKnowledgeStorageGuidelineEnvironmentalSettingValueSurrogate =
      with(model) {
        MedicationKnowledgeStorageGuidelineEnvironmentalSettingValueSurrogate(
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeDefinitionalIngredientStrengthSurrogate(
  public var strengthRatio: Ratio? = null,
  public var strengthCodeableConcept: CodeableConcept? = null,
  public var strengthQuantity: Quantity? = null,
) {
  public fun toModel(): MedicationKnowledge.Definitional.Ingredient.Strength =
    MedicationKnowledge.Definitional.Ingredient.Strength.from(
      this@MedicationKnowledgeDefinitionalIngredientStrengthSurrogate.strengthRatio,
      this@MedicationKnowledgeDefinitionalIngredientStrengthSurrogate.strengthCodeableConcept,
      this@MedicationKnowledgeDefinitionalIngredientStrengthSurrogate.strengthQuantity,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Definitional.Ingredient.Strength
    ): MedicationKnowledgeDefinitionalIngredientStrengthSurrogate =
      with(model) {
        MedicationKnowledgeDefinitionalIngredientStrengthSurrogate(
          strengthRatio = this@with.asRatio()?.value,
          strengthCodeableConcept = this@with.asCodeableConcept()?.value,
          strengthQuantity = this@with.asQuantity()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueQuantity: Quantity? = null,
  public var valueBase64Binary: KotlinString? = null,
  public var _valueBase64Binary: Element? = null,
  public var valueAttachment: Attachment? = null,
) {
  public fun toModel(): MedicationKnowledge.Definitional.DrugCharacteristic.Value =
    MedicationKnowledge.Definitional.DrugCharacteristic.Value.from(
      this@MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate.valueCodeableConcept,
      R5String.of(
        this@MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate.valueString,
        this@MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate._valueString,
      ),
      this@MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate.valueQuantity,
      Base64Binary.of(
        this@MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate.valueBase64Binary,
        this@MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate._valueBase64Binary,
      ),
      this@MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate.valueAttachment,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicationKnowledge.Definitional.DrugCharacteristic.Value
    ): MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate =
      with(model) {
        MedicationKnowledgeDefinitionalDrugCharacteristicValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueQuantity = this@with.asQuantity()?.value,
          valueBase64Binary = this@with.asBase64Binary()?.value?.value,
          _valueBase64Binary = this@with.asBase64Binary()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
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
  public var identifier: List<Identifier>? = null,
  public var code: CodeableConcept? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var author: Reference? = null,
  public var intendedJurisdiction: List<CodeableConcept>? = null,
  public var name: List<KotlinString?>? = null,
  public var _name: List<Element?>? = null,
  public var relatedMedicationKnowledge: List<MedicationKnowledge.RelatedMedicationKnowledge>? =
    null,
  public var associatedMedication: List<Reference>? = null,
  public var productType: List<CodeableConcept>? = null,
  public var monograph: List<MedicationKnowledge.Monograph>? = null,
  public var preparationInstruction: KotlinString? = null,
  public var _preparationInstruction: Element? = null,
  public var cost: List<MedicationKnowledge.Cost>? = null,
  public var monitoringProgram: List<MedicationKnowledge.MonitoringProgram>? = null,
  public var indicationGuideline: List<MedicationKnowledge.IndicationGuideline>? = null,
  public var medicineClassification: List<MedicationKnowledge.MedicineClassification>? = null,
  public var packaging: List<MedicationKnowledge.Packaging>? = null,
  public var clinicalUseIssue: List<Reference>? = null,
  public var storageGuideline: List<MedicationKnowledge.StorageGuideline>? = null,
  public var regulatory: List<MedicationKnowledge.Regulatory>? = null,
  public var definitional: MedicationKnowledge.Definitional? = null,
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
      identifier = this@MedicationKnowledgeSurrogate.identifier ?: listOf(),
      code = this@MedicationKnowledgeSurrogate.code,
      status =
        this@MedicationKnowledgeSurrogate.status?.let {
          Enumeration.of(
            MedicationKnowledge.MedicationKnowledgeStatusCodes.fromCode(it),
            this@MedicationKnowledgeSurrogate._status,
          )
        },
      author = this@MedicationKnowledgeSurrogate.author,
      intendedJurisdiction = this@MedicationKnowledgeSurrogate.intendedJurisdiction ?: listOf(),
      name =
        if (
          this@MedicationKnowledgeSurrogate.name == null &&
            this@MedicationKnowledgeSurrogate._name == null
        ) {
          listOf()
        } else {
          (this@MedicationKnowledgeSurrogate.name
              ?: List(this@MedicationKnowledgeSurrogate._name!!.size) { null })
            .zip(
              this@MedicationKnowledgeSurrogate._name
                ?: List(this@MedicationKnowledgeSurrogate.name!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      relatedMedicationKnowledge =
        this@MedicationKnowledgeSurrogate.relatedMedicationKnowledge ?: listOf(),
      associatedMedication = this@MedicationKnowledgeSurrogate.associatedMedication ?: listOf(),
      productType = this@MedicationKnowledgeSurrogate.productType ?: listOf(),
      monograph = this@MedicationKnowledgeSurrogate.monograph ?: listOf(),
      preparationInstruction =
        Markdown.of(
          this@MedicationKnowledgeSurrogate.preparationInstruction,
          this@MedicationKnowledgeSurrogate._preparationInstruction,
        ),
      cost = this@MedicationKnowledgeSurrogate.cost ?: listOf(),
      monitoringProgram = this@MedicationKnowledgeSurrogate.monitoringProgram ?: listOf(),
      indicationGuideline = this@MedicationKnowledgeSurrogate.indicationGuideline ?: listOf(),
      medicineClassification = this@MedicationKnowledgeSurrogate.medicineClassification ?: listOf(),
      packaging = this@MedicationKnowledgeSurrogate.packaging ?: listOf(),
      clinicalUseIssue = this@MedicationKnowledgeSurrogate.clinicalUseIssue ?: listOf(),
      storageGuideline = this@MedicationKnowledgeSurrogate.storageGuideline ?: listOf(),
      regulatory = this@MedicationKnowledgeSurrogate.regulatory ?: listOf(),
      definitional = this@MedicationKnowledgeSurrogate.definitional,
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
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          code = this@with.code,
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          author = this@with.author,
          intendedJurisdiction = this@with.intendedJurisdiction.takeIf { it.isNotEmpty() },
          name = this@with.name.map { it.value }.toList().takeUnless { it.all { it == null } },
          _name =
            this@with.name
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          relatedMedicationKnowledge =
            this@with.relatedMedicationKnowledge.takeIf { it.isNotEmpty() },
          associatedMedication = this@with.associatedMedication.takeIf { it.isNotEmpty() },
          productType = this@with.productType.takeIf { it.isNotEmpty() },
          monograph = this@with.monograph.takeIf { it.isNotEmpty() },
          preparationInstruction = this@with.preparationInstruction?.value,
          _preparationInstruction = this@with.preparationInstruction?.toElement(),
          cost = this@with.cost.takeIf { it.isNotEmpty() },
          monitoringProgram = this@with.monitoringProgram.takeIf { it.isNotEmpty() },
          indicationGuideline = this@with.indicationGuideline.takeIf { it.isNotEmpty() },
          medicineClassification = this@with.medicineClassification.takeIf { it.isNotEmpty() },
          packaging = this@with.packaging.takeIf { it.isNotEmpty() },
          clinicalUseIssue = this@with.clinicalUseIssue.takeIf { it.isNotEmpty() },
          storageGuideline = this@with.storageGuideline.takeIf { it.isNotEmpty() },
          regulatory = this@with.regulatory.takeIf { it.isNotEmpty() },
          definitional = this@with.definitional,
        )
      }
  }
}
