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

import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Coding
import com.google.fhir.model.r4b.Duration
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Encounter
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.PositiveInt
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class EncounterStatusHistorySurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var status: String? = null,
  public var _status: Element? = null,
  public var period: Period,
) {
  public fun toModel(): Encounter.StatusHistory =
    Encounter.StatusHistory(
      id = this@EncounterStatusHistorySurrogate.id,
      extension = this@EncounterStatusHistorySurrogate.extension ?: listOf(),
      modifierExtension = this@EncounterStatusHistorySurrogate.modifierExtension ?: listOf(),
      status =
        Enumeration.of(
          Encounter.EncounterStatus.fromCode(this@EncounterStatusHistorySurrogate.status!!),
          this@EncounterStatusHistorySurrogate._status,
        ),
      period = this@EncounterStatusHistorySurrogate.period,
    )

  public companion object {
    public fun fromModel(model: Encounter.StatusHistory): EncounterStatusHistorySurrogate =
      with(model) {
        EncounterStatusHistorySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class EncounterClassHistorySurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `class`: Coding,
  public var period: Period,
) {
  public fun toModel(): Encounter.ClassHistory =
    Encounter.ClassHistory(
      id = this@EncounterClassHistorySurrogate.id,
      extension = this@EncounterClassHistorySurrogate.extension ?: listOf(),
      modifierExtension = this@EncounterClassHistorySurrogate.modifierExtension ?: listOf(),
      `class` = this@EncounterClassHistorySurrogate.`class`,
      period = this@EncounterClassHistorySurrogate.period,
    )

  public companion object {
    public fun fromModel(model: Encounter.ClassHistory): EncounterClassHistorySurrogate =
      with(model) {
        EncounterClassHistorySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `class` = this@with.`class`,
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class EncounterParticipantSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: List<CodeableConcept>? = null,
  public var period: Period? = null,
  public var individual: Reference? = null,
) {
  public fun toModel(): Encounter.Participant =
    Encounter.Participant(
      id = this@EncounterParticipantSurrogate.id,
      extension = this@EncounterParticipantSurrogate.extension ?: listOf(),
      modifierExtension = this@EncounterParticipantSurrogate.modifierExtension ?: listOf(),
      type = this@EncounterParticipantSurrogate.type ?: listOf(),
      period = this@EncounterParticipantSurrogate.period,
      individual = this@EncounterParticipantSurrogate.individual,
    )

  public companion object {
    public fun fromModel(model: Encounter.Participant): EncounterParticipantSurrogate =
      with(model) {
        EncounterParticipantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.takeIf { it.isNotEmpty() },
          period = this@with.period,
          individual = this@with.individual,
        )
      }
  }
}

@Serializable
internal data class EncounterDiagnosisSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var condition: Reference,
  public var use: CodeableConcept? = null,
  public var rank: Int? = null,
  public var _rank: Element? = null,
) {
  public fun toModel(): Encounter.Diagnosis =
    Encounter.Diagnosis(
      id = this@EncounterDiagnosisSurrogate.id,
      extension = this@EncounterDiagnosisSurrogate.extension ?: listOf(),
      modifierExtension = this@EncounterDiagnosisSurrogate.modifierExtension ?: listOf(),
      condition = this@EncounterDiagnosisSurrogate.condition,
      use = this@EncounterDiagnosisSurrogate.use,
      rank =
        PositiveInt.of(
          this@EncounterDiagnosisSurrogate.rank,
          this@EncounterDiagnosisSurrogate._rank,
        ),
    )

  public companion object {
    public fun fromModel(model: Encounter.Diagnosis): EncounterDiagnosisSurrogate =
      with(model) {
        EncounterDiagnosisSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          condition = this@with.condition,
          use = this@with.use,
          rank = this@with.rank?.value,
          _rank = this@with.rank?.toElement(),
        )
      }
  }
}

@Serializable
internal data class EncounterHospitalizationSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var preAdmissionIdentifier: Identifier? = null,
  public var origin: Reference? = null,
  public var admitSource: CodeableConcept? = null,
  public var reAdmission: CodeableConcept? = null,
  public var dietPreference: List<CodeableConcept>? = null,
  public var specialCourtesy: List<CodeableConcept>? = null,
  public var specialArrangement: List<CodeableConcept>? = null,
  public var destination: Reference? = null,
  public var dischargeDisposition: CodeableConcept? = null,
) {
  public fun toModel(): Encounter.Hospitalization =
    Encounter.Hospitalization(
      id = this@EncounterHospitalizationSurrogate.id,
      extension = this@EncounterHospitalizationSurrogate.extension ?: listOf(),
      modifierExtension = this@EncounterHospitalizationSurrogate.modifierExtension ?: listOf(),
      preAdmissionIdentifier = this@EncounterHospitalizationSurrogate.preAdmissionIdentifier,
      origin = this@EncounterHospitalizationSurrogate.origin,
      admitSource = this@EncounterHospitalizationSurrogate.admitSource,
      reAdmission = this@EncounterHospitalizationSurrogate.reAdmission,
      dietPreference = this@EncounterHospitalizationSurrogate.dietPreference ?: listOf(),
      specialCourtesy = this@EncounterHospitalizationSurrogate.specialCourtesy ?: listOf(),
      specialArrangement = this@EncounterHospitalizationSurrogate.specialArrangement ?: listOf(),
      destination = this@EncounterHospitalizationSurrogate.destination,
      dischargeDisposition = this@EncounterHospitalizationSurrogate.dischargeDisposition,
    )

  public companion object {
    public fun fromModel(model: Encounter.Hospitalization): EncounterHospitalizationSurrogate =
      with(model) {
        EncounterHospitalizationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          preAdmissionIdentifier = this@with.preAdmissionIdentifier,
          origin = this@with.origin,
          admitSource = this@with.admitSource,
          reAdmission = this@with.reAdmission,
          dietPreference = this@with.dietPreference.takeIf { it.isNotEmpty() },
          specialCourtesy = this@with.specialCourtesy.takeIf { it.isNotEmpty() },
          specialArrangement = this@with.specialArrangement.takeIf { it.isNotEmpty() },
          destination = this@with.destination,
          dischargeDisposition = this@with.dischargeDisposition,
        )
      }
  }
}

@Serializable
internal data class EncounterLocationSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var location: Reference,
  public var status: String? = null,
  public var _status: Element? = null,
  public var physicalType: CodeableConcept? = null,
  public var period: Period? = null,
) {
  public fun toModel(): Encounter.Location =
    Encounter.Location(
      id = this@EncounterLocationSurrogate.id,
      extension = this@EncounterLocationSurrogate.extension ?: listOf(),
      modifierExtension = this@EncounterLocationSurrogate.modifierExtension ?: listOf(),
      location = this@EncounterLocationSurrogate.location,
      status =
        this@EncounterLocationSurrogate.status?.let {
          Enumeration.of(
            Encounter.EncounterLocationStatus.fromCode(it),
            this@EncounterLocationSurrogate._status,
          )
        },
      physicalType = this@EncounterLocationSurrogate.physicalType,
      period = this@EncounterLocationSurrogate.period,
    )

  public companion object {
    public fun fromModel(model: Encounter.Location): EncounterLocationSurrogate =
      with(model) {
        EncounterLocationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          location = this@with.location,
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          physicalType = this@with.physicalType,
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class EncounterSurrogate(
  public var id: String? = null,
  public var meta: Meta? = null,
  public var implicitRules: String? = null,
  public var _implicitRules: Element? = null,
  public var language: String? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var status: String? = null,
  public var _status: Element? = null,
  public var statusHistory: List<Encounter.StatusHistory>? = null,
  public var `class`: Coding,
  public var classHistory: List<Encounter.ClassHistory>? = null,
  public var type: List<CodeableConcept>? = null,
  public var serviceType: CodeableConcept? = null,
  public var priority: CodeableConcept? = null,
  public var subject: Reference? = null,
  public var episodeOfCare: List<Reference>? = null,
  public var basedOn: List<Reference>? = null,
  public var participant: List<Encounter.Participant>? = null,
  public var appointment: List<Reference>? = null,
  public var period: Period? = null,
  public var length: Duration? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var diagnosis: List<Encounter.Diagnosis>? = null,
  public var account: List<Reference>? = null,
  public var hospitalization: Encounter.Hospitalization? = null,
  public var location: List<Encounter.Location>? = null,
  public var serviceProvider: Reference? = null,
  public var partOf: Reference? = null,
) {
  public fun toModel(): Encounter =
    Encounter(
      id = this@EncounterSurrogate.id,
      meta = this@EncounterSurrogate.meta,
      implicitRules =
        Uri.of(this@EncounterSurrogate.implicitRules, this@EncounterSurrogate._implicitRules),
      language = Code.of(this@EncounterSurrogate.language, this@EncounterSurrogate._language),
      text = this@EncounterSurrogate.text,
      contained = this@EncounterSurrogate.contained ?: listOf(),
      extension = this@EncounterSurrogate.extension ?: listOf(),
      modifierExtension = this@EncounterSurrogate.modifierExtension ?: listOf(),
      identifier = this@EncounterSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          Encounter.EncounterStatus.fromCode(this@EncounterSurrogate.status!!),
          this@EncounterSurrogate._status,
        ),
      statusHistory = this@EncounterSurrogate.statusHistory ?: listOf(),
      `class` = this@EncounterSurrogate.`class`,
      classHistory = this@EncounterSurrogate.classHistory ?: listOf(),
      type = this@EncounterSurrogate.type ?: listOf(),
      serviceType = this@EncounterSurrogate.serviceType,
      priority = this@EncounterSurrogate.priority,
      subject = this@EncounterSurrogate.subject,
      episodeOfCare = this@EncounterSurrogate.episodeOfCare ?: listOf(),
      basedOn = this@EncounterSurrogate.basedOn ?: listOf(),
      participant = this@EncounterSurrogate.participant ?: listOf(),
      appointment = this@EncounterSurrogate.appointment ?: listOf(),
      period = this@EncounterSurrogate.period,
      length = this@EncounterSurrogate.length,
      reasonCode = this@EncounterSurrogate.reasonCode ?: listOf(),
      reasonReference = this@EncounterSurrogate.reasonReference ?: listOf(),
      diagnosis = this@EncounterSurrogate.diagnosis ?: listOf(),
      account = this@EncounterSurrogate.account ?: listOf(),
      hospitalization = this@EncounterSurrogate.hospitalization,
      location = this@EncounterSurrogate.location ?: listOf(),
      serviceProvider = this@EncounterSurrogate.serviceProvider,
      partOf = this@EncounterSurrogate.partOf,
    )

  public companion object {
    public fun fromModel(model: Encounter): EncounterSurrogate =
      with(model) {
        EncounterSurrogate(
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
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          statusHistory = this@with.statusHistory.takeIf { it.isNotEmpty() },
          `class` = this@with.`class`,
          classHistory = this@with.classHistory.takeIf { it.isNotEmpty() },
          type = this@with.type.takeIf { it.isNotEmpty() },
          serviceType = this@with.serviceType,
          priority = this@with.priority,
          subject = this@with.subject,
          episodeOfCare = this@with.episodeOfCare.takeIf { it.isNotEmpty() },
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          participant = this@with.participant.takeIf { it.isNotEmpty() },
          appointment = this@with.appointment.takeIf { it.isNotEmpty() },
          period = this@with.period,
          length = this@with.length,
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          diagnosis = this@with.diagnosis.takeIf { it.isNotEmpty() },
          account = this@with.account.takeIf { it.isNotEmpty() },
          hospitalization = this@with.hospitalization,
          location = this@with.location.takeIf { it.isNotEmpty() },
          serviceProvider = this@with.serviceProvider,
          partOf = this@with.partOf,
        )
      }
  }
}
