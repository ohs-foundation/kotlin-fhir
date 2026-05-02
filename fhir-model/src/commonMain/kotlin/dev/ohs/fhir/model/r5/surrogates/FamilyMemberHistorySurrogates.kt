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

import com.google.fhir.model.r5.Age
import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FamilyMemberHistory
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Range
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
internal data class FamilyMemberHistoryParticipantSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var function: CodeableConcept? = null,
  public var actor: Reference,
) {
  public fun toModel(): FamilyMemberHistory.Participant =
    FamilyMemberHistory.Participant(
      id = this@FamilyMemberHistoryParticipantSurrogate.id,
      extension = this@FamilyMemberHistoryParticipantSurrogate.extension ?: listOf(),
      modifierExtension =
        this@FamilyMemberHistoryParticipantSurrogate.modifierExtension ?: listOf(),
      function = this@FamilyMemberHistoryParticipantSurrogate.function,
      actor = this@FamilyMemberHistoryParticipantSurrogate.actor,
    )

  public companion object {
    public fun fromModel(
      model: FamilyMemberHistory.Participant
    ): FamilyMemberHistoryParticipantSurrogate =
      with(model) {
        FamilyMemberHistoryParticipantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          function = this@with.function,
          actor = this@with.actor,
        )
      }
  }
}

@Serializable
internal data class FamilyMemberHistoryConditionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var outcome: CodeableConcept? = null,
  public var contributedToDeath: KotlinBoolean? = null,
  public var _contributedToDeath: Element? = null,
  public var onset: FamilyMemberHistory.Condition.Onset? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): FamilyMemberHistory.Condition =
    FamilyMemberHistory.Condition(
      id = this@FamilyMemberHistoryConditionSurrogate.id,
      extension = this@FamilyMemberHistoryConditionSurrogate.extension ?: listOf(),
      modifierExtension = this@FamilyMemberHistoryConditionSurrogate.modifierExtension ?: listOf(),
      code = this@FamilyMemberHistoryConditionSurrogate.code,
      outcome = this@FamilyMemberHistoryConditionSurrogate.outcome,
      contributedToDeath =
        R5Boolean.of(
          this@FamilyMemberHistoryConditionSurrogate.contributedToDeath,
          this@FamilyMemberHistoryConditionSurrogate._contributedToDeath,
        ),
      onset = this@FamilyMemberHistoryConditionSurrogate.onset,
      note = this@FamilyMemberHistoryConditionSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: FamilyMemberHistory.Condition
    ): FamilyMemberHistoryConditionSurrogate =
      with(model) {
        FamilyMemberHistoryConditionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          outcome = this@with.outcome,
          contributedToDeath = this@with.contributedToDeath?.value,
          _contributedToDeath = this@with.contributedToDeath?.toElement(),
          onset = this@with.onset,
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class FamilyMemberHistoryProcedureSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var outcome: CodeableConcept? = null,
  public var contributedToDeath: KotlinBoolean? = null,
  public var _contributedToDeath: Element? = null,
  public var performed: FamilyMemberHistory.Procedure.Performed? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): FamilyMemberHistory.Procedure =
    FamilyMemberHistory.Procedure(
      id = this@FamilyMemberHistoryProcedureSurrogate.id,
      extension = this@FamilyMemberHistoryProcedureSurrogate.extension ?: listOf(),
      modifierExtension = this@FamilyMemberHistoryProcedureSurrogate.modifierExtension ?: listOf(),
      code = this@FamilyMemberHistoryProcedureSurrogate.code,
      outcome = this@FamilyMemberHistoryProcedureSurrogate.outcome,
      contributedToDeath =
        R5Boolean.of(
          this@FamilyMemberHistoryProcedureSurrogate.contributedToDeath,
          this@FamilyMemberHistoryProcedureSurrogate._contributedToDeath,
        ),
      performed = this@FamilyMemberHistoryProcedureSurrogate.performed,
      note = this@FamilyMemberHistoryProcedureSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: FamilyMemberHistory.Procedure
    ): FamilyMemberHistoryProcedureSurrogate =
      with(model) {
        FamilyMemberHistoryProcedureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          outcome = this@with.outcome,
          contributedToDeath = this@with.contributedToDeath?.value,
          _contributedToDeath = this@with.contributedToDeath?.toElement(),
          performed = this@with.performed,
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class FamilyMemberHistoryBornSurrogate(
  public var bornPeriod: Period? = null,
  public var bornDate: KotlinString? = null,
  public var _bornDate: Element? = null,
  public var bornString: KotlinString? = null,
  public var _bornString: Element? = null,
) {
  public fun toModel(): FamilyMemberHistory.Born =
    FamilyMemberHistory.Born.from(
      this@FamilyMemberHistoryBornSurrogate.bornPeriod,
      Date.of(
        FhirDate.fromString(this@FamilyMemberHistoryBornSurrogate.bornDate),
        this@FamilyMemberHistoryBornSurrogate._bornDate,
      ),
      R5String.of(
        this@FamilyMemberHistoryBornSurrogate.bornString,
        this@FamilyMemberHistoryBornSurrogate._bornString,
      ),
    )!!

  public companion object {
    public fun fromModel(model: FamilyMemberHistory.Born): FamilyMemberHistoryBornSurrogate =
      with(model) {
        FamilyMemberHistoryBornSurrogate(
          bornPeriod = this@with.asPeriod()?.value,
          bornDate = this@with.asDate()?.value?.value?.toString(),
          _bornDate = this@with.asDate()?.value?.toElement(),
          bornString = this@with.asString()?.value?.value,
          _bornString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class FamilyMemberHistoryAgeSurrogate(
  public var ageAge: Age? = null,
  public var ageRange: Range? = null,
  public var ageString: KotlinString? = null,
  public var _ageString: Element? = null,
) {
  public fun toModel(): FamilyMemberHistory.Age =
    FamilyMemberHistory.Age.from(
      this@FamilyMemberHistoryAgeSurrogate.ageAge,
      this@FamilyMemberHistoryAgeSurrogate.ageRange,
      R5String.of(
        this@FamilyMemberHistoryAgeSurrogate.ageString,
        this@FamilyMemberHistoryAgeSurrogate._ageString,
      ),
    )!!

  public companion object {
    public fun fromModel(model: FamilyMemberHistory.Age): FamilyMemberHistoryAgeSurrogate =
      with(model) {
        FamilyMemberHistoryAgeSurrogate(
          ageAge = this@with.asAge()?.value,
          ageRange = this@with.asRange()?.value,
          ageString = this@with.asString()?.value?.value,
          _ageString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class FamilyMemberHistoryDeceasedSurrogate(
  public var deceasedBoolean: KotlinBoolean? = null,
  public var _deceasedBoolean: Element? = null,
  public var deceasedAge: Age? = null,
  public var deceasedRange: Range? = null,
  public var deceasedDate: KotlinString? = null,
  public var _deceasedDate: Element? = null,
  public var deceasedString: KotlinString? = null,
  public var _deceasedString: Element? = null,
) {
  public fun toModel(): FamilyMemberHistory.Deceased =
    FamilyMemberHistory.Deceased.from(
      R5Boolean.of(
        this@FamilyMemberHistoryDeceasedSurrogate.deceasedBoolean,
        this@FamilyMemberHistoryDeceasedSurrogate._deceasedBoolean,
      ),
      this@FamilyMemberHistoryDeceasedSurrogate.deceasedAge,
      this@FamilyMemberHistoryDeceasedSurrogate.deceasedRange,
      Date.of(
        FhirDate.fromString(this@FamilyMemberHistoryDeceasedSurrogate.deceasedDate),
        this@FamilyMemberHistoryDeceasedSurrogate._deceasedDate,
      ),
      R5String.of(
        this@FamilyMemberHistoryDeceasedSurrogate.deceasedString,
        this@FamilyMemberHistoryDeceasedSurrogate._deceasedString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: FamilyMemberHistory.Deceased
    ): FamilyMemberHistoryDeceasedSurrogate =
      with(model) {
        FamilyMemberHistoryDeceasedSurrogate(
          deceasedBoolean = this@with.asBoolean()?.value?.value,
          _deceasedBoolean = this@with.asBoolean()?.value?.toElement(),
          deceasedAge = this@with.asAge()?.value,
          deceasedRange = this@with.asRange()?.value,
          deceasedDate = this@with.asDate()?.value?.value?.toString(),
          _deceasedDate = this@with.asDate()?.value?.toElement(),
          deceasedString = this@with.asString()?.value?.value,
          _deceasedString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class FamilyMemberHistoryConditionOnsetSurrogate(
  public var onsetAge: Age? = null,
  public var onsetRange: Range? = null,
  public var onsetPeriod: Period? = null,
  public var onsetString: KotlinString? = null,
  public var _onsetString: Element? = null,
) {
  public fun toModel(): FamilyMemberHistory.Condition.Onset =
    FamilyMemberHistory.Condition.Onset.from(
      this@FamilyMemberHistoryConditionOnsetSurrogate.onsetAge,
      this@FamilyMemberHistoryConditionOnsetSurrogate.onsetRange,
      this@FamilyMemberHistoryConditionOnsetSurrogate.onsetPeriod,
      R5String.of(
        this@FamilyMemberHistoryConditionOnsetSurrogate.onsetString,
        this@FamilyMemberHistoryConditionOnsetSurrogate._onsetString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: FamilyMemberHistory.Condition.Onset
    ): FamilyMemberHistoryConditionOnsetSurrogate =
      with(model) {
        FamilyMemberHistoryConditionOnsetSurrogate(
          onsetAge = this@with.asAge()?.value,
          onsetRange = this@with.asRange()?.value,
          onsetPeriod = this@with.asPeriod()?.value,
          onsetString = this@with.asString()?.value?.value,
          _onsetString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class FamilyMemberHistoryProcedurePerformedSurrogate(
  public var performedAge: Age? = null,
  public var performedRange: Range? = null,
  public var performedPeriod: Period? = null,
  public var performedString: KotlinString? = null,
  public var _performedString: Element? = null,
  public var performedDateTime: KotlinString? = null,
  public var _performedDateTime: Element? = null,
) {
  public fun toModel(): FamilyMemberHistory.Procedure.Performed =
    FamilyMemberHistory.Procedure.Performed.from(
      this@FamilyMemberHistoryProcedurePerformedSurrogate.performedAge,
      this@FamilyMemberHistoryProcedurePerformedSurrogate.performedRange,
      this@FamilyMemberHistoryProcedurePerformedSurrogate.performedPeriod,
      R5String.of(
        this@FamilyMemberHistoryProcedurePerformedSurrogate.performedString,
        this@FamilyMemberHistoryProcedurePerformedSurrogate._performedString,
      ),
      DateTime.of(
        FhirDateTime.fromString(
          this@FamilyMemberHistoryProcedurePerformedSurrogate.performedDateTime
        ),
        this@FamilyMemberHistoryProcedurePerformedSurrogate._performedDateTime,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: FamilyMemberHistory.Procedure.Performed
    ): FamilyMemberHistoryProcedurePerformedSurrogate =
      with(model) {
        FamilyMemberHistoryProcedurePerformedSurrogate(
          performedAge = this@with.asAge()?.value,
          performedRange = this@with.asRange()?.value,
          performedPeriod = this@with.asPeriod()?.value,
          performedString = this@with.asString()?.value?.value,
          _performedString = this@with.asString()?.value?.toElement(),
          performedDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _performedDateTime = this@with.asDateTime()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class FamilyMemberHistorySurrogate(
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
  public var instantiatesCanonical: List<KotlinString?>? = null,
  public var _instantiatesCanonical: List<Element?>? = null,
  public var instantiatesUri: List<KotlinString?>? = null,
  public var _instantiatesUri: List<Element?>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var dataAbsentReason: CodeableConcept? = null,
  public var patient: Reference,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var participant: List<FamilyMemberHistory.Participant>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var relationship: CodeableConcept,
  public var sex: CodeableConcept? = null,
  public var born: FamilyMemberHistory.Born? = null,
  public var age: FamilyMemberHistory.Age? = null,
  public var estimatedAge: KotlinBoolean? = null,
  public var _estimatedAge: Element? = null,
  public var deceased: FamilyMemberHistory.Deceased? = null,
  public var reason: List<CodeableReference>? = null,
  public var note: List<Annotation>? = null,
  public var condition: List<FamilyMemberHistory.Condition>? = null,
  public var procedure: List<FamilyMemberHistory.Procedure>? = null,
) {
  public fun toModel(): FamilyMemberHistory =
    FamilyMemberHistory(
      id = this@FamilyMemberHistorySurrogate.id,
      meta = this@FamilyMemberHistorySurrogate.meta,
      implicitRules =
        Uri.of(
          this@FamilyMemberHistorySurrogate.implicitRules,
          this@FamilyMemberHistorySurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@FamilyMemberHistorySurrogate.language,
          this@FamilyMemberHistorySurrogate._language,
        ),
      text = this@FamilyMemberHistorySurrogate.text,
      contained = this@FamilyMemberHistorySurrogate.contained ?: listOf(),
      extension = this@FamilyMemberHistorySurrogate.extension ?: listOf(),
      modifierExtension = this@FamilyMemberHistorySurrogate.modifierExtension ?: listOf(),
      identifier = this@FamilyMemberHistorySurrogate.identifier ?: listOf(),
      instantiatesCanonical =
        if (
          this@FamilyMemberHistorySurrogate.instantiatesCanonical == null &&
            this@FamilyMemberHistorySurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@FamilyMemberHistorySurrogate.instantiatesCanonical
              ?: List(this@FamilyMemberHistorySurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@FamilyMemberHistorySurrogate._instantiatesCanonical
                ?: List(this@FamilyMemberHistorySurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@FamilyMemberHistorySurrogate.instantiatesUri == null &&
            this@FamilyMemberHistorySurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@FamilyMemberHistorySurrogate.instantiatesUri
              ?: List(this@FamilyMemberHistorySurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@FamilyMemberHistorySurrogate._instantiatesUri
                ?: List(this@FamilyMemberHistorySurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      status =
        Enumeration.of(
          FamilyMemberHistory.FamilyHistoryStatus.fromCode(
            this@FamilyMemberHistorySurrogate.status!!
          ),
          this@FamilyMemberHistorySurrogate._status,
        ),
      dataAbsentReason = this@FamilyMemberHistorySurrogate.dataAbsentReason,
      patient = this@FamilyMemberHistorySurrogate.patient,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@FamilyMemberHistorySurrogate.date),
          this@FamilyMemberHistorySurrogate._date,
        ),
      participant = this@FamilyMemberHistorySurrogate.participant ?: listOf(),
      name =
        R5String.of(
          this@FamilyMemberHistorySurrogate.name,
          this@FamilyMemberHistorySurrogate._name,
        ),
      relationship = this@FamilyMemberHistorySurrogate.relationship,
      sex = this@FamilyMemberHistorySurrogate.sex,
      born = this@FamilyMemberHistorySurrogate.born,
      age = this@FamilyMemberHistorySurrogate.age,
      estimatedAge =
        R5Boolean.of(
          this@FamilyMemberHistorySurrogate.estimatedAge,
          this@FamilyMemberHistorySurrogate._estimatedAge,
        ),
      deceased = this@FamilyMemberHistorySurrogate.deceased,
      reason = this@FamilyMemberHistorySurrogate.reason ?: listOf(),
      note = this@FamilyMemberHistorySurrogate.note ?: listOf(),
      condition = this@FamilyMemberHistorySurrogate.condition ?: listOf(),
      procedure = this@FamilyMemberHistorySurrogate.procedure ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: FamilyMemberHistory): FamilyMemberHistorySurrogate =
      with(model) {
        FamilyMemberHistorySurrogate(
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
          instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          instantiatesUri =
            this@with.instantiatesUri
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesUri =
            this@with.instantiatesUri
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          dataAbsentReason = this@with.dataAbsentReason,
          patient = this@with.patient,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          participant = this@with.participant.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          relationship = this@with.relationship,
          sex = this@with.sex,
          born = this@with.born,
          age = this@with.age,
          estimatedAge = this@with.estimatedAge?.value,
          _estimatedAge = this@with.estimatedAge?.toElement(),
          deceased = this@with.deceased,
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          condition = this@with.condition.takeIf { it.isNotEmpty() },
          procedure = this@with.procedure.takeIf { it.isNotEmpty() },
        )
      }
  }
}
