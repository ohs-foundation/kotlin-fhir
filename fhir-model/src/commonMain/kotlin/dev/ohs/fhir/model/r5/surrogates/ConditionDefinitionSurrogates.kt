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

import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ConditionDefinition
import com.google.fhir.model.r5.ContactDetail
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ConditionDefinitionObservationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept? = null,
  public var code: CodeableConcept? = null,
) {
  public fun toModel(): ConditionDefinition.Observation =
    ConditionDefinition.Observation(
      id = this@ConditionDefinitionObservationSurrogate.id,
      extension = this@ConditionDefinitionObservationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ConditionDefinitionObservationSurrogate.modifierExtension ?: listOf(),
      category = this@ConditionDefinitionObservationSurrogate.category,
      code = this@ConditionDefinitionObservationSurrogate.code,
    )

  public companion object {
    public fun fromModel(
      model: ConditionDefinition.Observation
    ): ConditionDefinitionObservationSurrogate =
      with(model) {
        ConditionDefinitionObservationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          code = this@with.code,
        )
      }
  }
}

@Serializable
internal data class ConditionDefinitionMedicationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept? = null,
  public var code: CodeableConcept? = null,
) {
  public fun toModel(): ConditionDefinition.Medication =
    ConditionDefinition.Medication(
      id = this@ConditionDefinitionMedicationSurrogate.id,
      extension = this@ConditionDefinitionMedicationSurrogate.extension ?: listOf(),
      modifierExtension = this@ConditionDefinitionMedicationSurrogate.modifierExtension ?: listOf(),
      category = this@ConditionDefinitionMedicationSurrogate.category,
      code = this@ConditionDefinitionMedicationSurrogate.code,
    )

  public companion object {
    public fun fromModel(
      model: ConditionDefinition.Medication
    ): ConditionDefinitionMedicationSurrogate =
      with(model) {
        ConditionDefinitionMedicationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          code = this@with.code,
        )
      }
  }
}

@Serializable
internal data class ConditionDefinitionPreconditionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var code: CodeableConcept,
  public var `value`: ConditionDefinition.Precondition.Value? = null,
) {
  public fun toModel(): ConditionDefinition.Precondition =
    ConditionDefinition.Precondition(
      id = this@ConditionDefinitionPreconditionSurrogate.id,
      extension = this@ConditionDefinitionPreconditionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ConditionDefinitionPreconditionSurrogate.modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          ConditionDefinition.ConditionPreconditionType.fromCode(
            this@ConditionDefinitionPreconditionSurrogate.type!!
          ),
          this@ConditionDefinitionPreconditionSurrogate._type,
        ),
      code = this@ConditionDefinitionPreconditionSurrogate.code,
      `value` = this@ConditionDefinitionPreconditionSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: ConditionDefinition.Precondition
    ): ConditionDefinitionPreconditionSurrogate =
      with(model) {
        ConditionDefinitionPreconditionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          code = this@with.code,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class ConditionDefinitionQuestionnaireSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var reference: Reference,
) {
  public fun toModel(): ConditionDefinition.Questionnaire =
    ConditionDefinition.Questionnaire(
      id = this@ConditionDefinitionQuestionnaireSurrogate.id,
      extension = this@ConditionDefinitionQuestionnaireSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ConditionDefinitionQuestionnaireSurrogate.modifierExtension ?: listOf(),
      purpose =
        Enumeration.of(
          ConditionDefinition.ConditionQuestionnairePurpose.fromCode(
            this@ConditionDefinitionQuestionnaireSurrogate.purpose!!
          ),
          this@ConditionDefinitionQuestionnaireSurrogate._purpose,
        ),
      reference = this@ConditionDefinitionQuestionnaireSurrogate.reference,
    )

  public companion object {
    public fun fromModel(
      model: ConditionDefinition.Questionnaire
    ): ConditionDefinitionQuestionnaireSurrogate =
      with(model) {
        ConditionDefinitionQuestionnaireSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          purpose = this@with.purpose.value?.getCode(),
          _purpose = this@with.purpose.toElement(),
          reference = this@with.reference,
        )
      }
  }
}

@Serializable
internal data class ConditionDefinitionPlanSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var role: CodeableConcept? = null,
  public var reference: Reference,
) {
  public fun toModel(): ConditionDefinition.Plan =
    ConditionDefinition.Plan(
      id = this@ConditionDefinitionPlanSurrogate.id,
      extension = this@ConditionDefinitionPlanSurrogate.extension ?: listOf(),
      modifierExtension = this@ConditionDefinitionPlanSurrogate.modifierExtension ?: listOf(),
      role = this@ConditionDefinitionPlanSurrogate.role,
      reference = this@ConditionDefinitionPlanSurrogate.reference,
    )

  public companion object {
    public fun fromModel(model: ConditionDefinition.Plan): ConditionDefinitionPlanSurrogate =
      with(model) {
        ConditionDefinitionPlanSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          role = this@with.role,
          reference = this@with.reference,
        )
      }
  }
}

@Serializable
internal data class ConditionDefinitionVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): ConditionDefinition.VersionAlgorithm =
    ConditionDefinition.VersionAlgorithm.from(
      R5String.of(
        this@ConditionDefinitionVersionAlgorithmSurrogate.versionAlgorithmString,
        this@ConditionDefinitionVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@ConditionDefinitionVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(
      model: ConditionDefinition.VersionAlgorithm
    ): ConditionDefinitionVersionAlgorithmSurrogate =
      with(model) {
        ConditionDefinitionVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class ConditionDefinitionPreconditionValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
) {
  public fun toModel(): ConditionDefinition.Precondition.Value =
    ConditionDefinition.Precondition.Value.from(
      this@ConditionDefinitionPreconditionValueSurrogate.valueCodeableConcept,
      this@ConditionDefinitionPreconditionValueSurrogate.valueQuantity,
    )!!

  public companion object {
    public fun fromModel(
      model: ConditionDefinition.Precondition.Value
    ): ConditionDefinitionPreconditionValueSurrogate =
      with(model) {
        ConditionDefinitionPreconditionValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
        )
      }
  }
}

@Serializable
internal data class ConditionDefinitionSurrogate(
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
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var versionAlgorithm: ConditionDefinition.VersionAlgorithm? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var subtitle: KotlinString? = null,
  public var _subtitle: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var experimental: KotlinBoolean? = null,
  public var _experimental: Element? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var jurisdiction: List<CodeableConcept>? = null,
  public var code: CodeableConcept,
  public var severity: CodeableConcept? = null,
  public var bodySite: CodeableConcept? = null,
  public var stage: CodeableConcept? = null,
  public var hasSeverity: KotlinBoolean? = null,
  public var _hasSeverity: Element? = null,
  public var hasBodySite: KotlinBoolean? = null,
  public var _hasBodySite: Element? = null,
  public var hasStage: KotlinBoolean? = null,
  public var _hasStage: Element? = null,
  public var definition: List<KotlinString?>? = null,
  public var _definition: List<Element?>? = null,
  public var observation: List<ConditionDefinition.Observation>? = null,
  public var medication: List<ConditionDefinition.Medication>? = null,
  public var precondition: List<ConditionDefinition.Precondition>? = null,
  public var team: List<Reference>? = null,
  public var questionnaire: List<ConditionDefinition.Questionnaire>? = null,
  public var plan: List<ConditionDefinition.Plan>? = null,
) {
  public fun toModel(): ConditionDefinition =
    ConditionDefinition(
      id = this@ConditionDefinitionSurrogate.id,
      meta = this@ConditionDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ConditionDefinitionSurrogate.implicitRules,
          this@ConditionDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@ConditionDefinitionSurrogate.language,
          this@ConditionDefinitionSurrogate._language,
        ),
      text = this@ConditionDefinitionSurrogate.text,
      contained = this@ConditionDefinitionSurrogate.contained ?: listOf(),
      extension = this@ConditionDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@ConditionDefinitionSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@ConditionDefinitionSurrogate.url, this@ConditionDefinitionSurrogate._url),
      identifier = this@ConditionDefinitionSurrogate.identifier ?: listOf(),
      version =
        R5String.of(
          this@ConditionDefinitionSurrogate.version,
          this@ConditionDefinitionSurrogate._version,
        ),
      versionAlgorithm = this@ConditionDefinitionSurrogate.versionAlgorithm,
      name =
        R5String.of(
          this@ConditionDefinitionSurrogate.name,
          this@ConditionDefinitionSurrogate._name,
        ),
      title =
        R5String.of(
          this@ConditionDefinitionSurrogate.title,
          this@ConditionDefinitionSurrogate._title,
        ),
      subtitle =
        R5String.of(
          this@ConditionDefinitionSurrogate.subtitle,
          this@ConditionDefinitionSurrogate._subtitle,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ConditionDefinitionSurrogate.status!!),
          this@ConditionDefinitionSurrogate._status,
        ),
      experimental =
        R5Boolean.of(
          this@ConditionDefinitionSurrogate.experimental,
          this@ConditionDefinitionSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ConditionDefinitionSurrogate.date),
          this@ConditionDefinitionSurrogate._date,
        ),
      publisher =
        R5String.of(
          this@ConditionDefinitionSurrogate.publisher,
          this@ConditionDefinitionSurrogate._publisher,
        ),
      contact = this@ConditionDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@ConditionDefinitionSurrogate.description,
          this@ConditionDefinitionSurrogate._description,
        ),
      useContext = this@ConditionDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@ConditionDefinitionSurrogate.jurisdiction ?: listOf(),
      code = this@ConditionDefinitionSurrogate.code,
      severity = this@ConditionDefinitionSurrogate.severity,
      bodySite = this@ConditionDefinitionSurrogate.bodySite,
      stage = this@ConditionDefinitionSurrogate.stage,
      hasSeverity =
        R5Boolean.of(
          this@ConditionDefinitionSurrogate.hasSeverity,
          this@ConditionDefinitionSurrogate._hasSeverity,
        ),
      hasBodySite =
        R5Boolean.of(
          this@ConditionDefinitionSurrogate.hasBodySite,
          this@ConditionDefinitionSurrogate._hasBodySite,
        ),
      hasStage =
        R5Boolean.of(
          this@ConditionDefinitionSurrogate.hasStage,
          this@ConditionDefinitionSurrogate._hasStage,
        ),
      definition =
        if (
          this@ConditionDefinitionSurrogate.definition == null &&
            this@ConditionDefinitionSurrogate._definition == null
        ) {
          listOf()
        } else {
          (this@ConditionDefinitionSurrogate.definition
              ?: List(this@ConditionDefinitionSurrogate._definition!!.size) { null })
            .zip(
              this@ConditionDefinitionSurrogate._definition
                ?: List(this@ConditionDefinitionSurrogate.definition!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      observation = this@ConditionDefinitionSurrogate.observation ?: listOf(),
      medication = this@ConditionDefinitionSurrogate.medication ?: listOf(),
      precondition = this@ConditionDefinitionSurrogate.precondition ?: listOf(),
      team = this@ConditionDefinitionSurrogate.team ?: listOf(),
      questionnaire = this@ConditionDefinitionSurrogate.questionnaire ?: listOf(),
      plan = this@ConditionDefinitionSurrogate.plan ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ConditionDefinition): ConditionDefinitionSurrogate =
      with(model) {
        ConditionDefinitionSurrogate(
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
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          versionAlgorithm = this@with.versionAlgorithm,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          subtitle = this@with.subtitle?.value,
          _subtitle = this@with.subtitle?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          experimental = this@with.experimental?.value,
          _experimental = this@with.experimental?.toElement(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
          code = this@with.code,
          severity = this@with.severity,
          bodySite = this@with.bodySite,
          stage = this@with.stage,
          hasSeverity = this@with.hasSeverity?.value,
          _hasSeverity = this@with.hasSeverity?.toElement(),
          hasBodySite = this@with.hasBodySite?.value,
          _hasBodySite = this@with.hasBodySite?.toElement(),
          hasStage = this@with.hasStage?.value,
          _hasStage = this@with.hasStage?.toElement(),
          definition =
            this@with.definition.map { it.value }.toList().takeUnless { it.all { it == null } },
          _definition =
            this@with.definition
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          observation = this@with.observation.takeIf { it.isNotEmpty() },
          medication = this@with.medication.takeIf { it.isNotEmpty() },
          precondition = this@with.precondition.takeIf { it.isNotEmpty() },
          team = this@with.team.takeIf { it.isNotEmpty() },
          questionnaire = this@with.questionnaire.takeIf { it.isNotEmpty() },
          plan = this@with.plan.takeIf { it.isNotEmpty() },
        )
      }
  }
}
