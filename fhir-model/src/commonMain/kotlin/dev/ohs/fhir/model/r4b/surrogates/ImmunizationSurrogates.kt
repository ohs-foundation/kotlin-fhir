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
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Immunization
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.PositiveInt
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ImmunizationPerformerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var function: CodeableConcept? = null,
  public var actor: Reference,
) {
  public fun toModel(): Immunization.Performer =
    Immunization.Performer(
      id = this@ImmunizationPerformerSurrogate.id,
      extension = this@ImmunizationPerformerSurrogate.extension ?: listOf(),
      modifierExtension = this@ImmunizationPerformerSurrogate.modifierExtension ?: listOf(),
      function = this@ImmunizationPerformerSurrogate.function,
      actor = this@ImmunizationPerformerSurrogate.actor,
    )

  public companion object {
    public fun fromModel(model: Immunization.Performer): ImmunizationPerformerSurrogate =
      with(model) {
        ImmunizationPerformerSurrogate(
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
internal data class ImmunizationEducationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var documentType: KotlinString? = null,
  public var _documentType: Element? = null,
  public var reference: KotlinString? = null,
  public var _reference: Element? = null,
  public var publicationDate: KotlinString? = null,
  public var _publicationDate: Element? = null,
  public var presentationDate: KotlinString? = null,
  public var _presentationDate: Element? = null,
) {
  public fun toModel(): Immunization.Education =
    Immunization.Education(
      id = this@ImmunizationEducationSurrogate.id,
      extension = this@ImmunizationEducationSurrogate.extension ?: listOf(),
      modifierExtension = this@ImmunizationEducationSurrogate.modifierExtension ?: listOf(),
      documentType =
        R4bString.of(
          this@ImmunizationEducationSurrogate.documentType,
          this@ImmunizationEducationSurrogate._documentType,
        ),
      reference =
        Uri.of(
          this@ImmunizationEducationSurrogate.reference,
          this@ImmunizationEducationSurrogate._reference,
        ),
      publicationDate =
        DateTime.of(
          FhirDateTime.fromString(this@ImmunizationEducationSurrogate.publicationDate),
          this@ImmunizationEducationSurrogate._publicationDate,
        ),
      presentationDate =
        DateTime.of(
          FhirDateTime.fromString(this@ImmunizationEducationSurrogate.presentationDate),
          this@ImmunizationEducationSurrogate._presentationDate,
        ),
    )

  public companion object {
    public fun fromModel(model: Immunization.Education): ImmunizationEducationSurrogate =
      with(model) {
        ImmunizationEducationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          documentType = this@with.documentType?.value,
          _documentType = this@with.documentType?.toElement(),
          reference = this@with.reference?.value,
          _reference = this@with.reference?.toElement(),
          publicationDate = this@with.publicationDate?.value?.toString(),
          _publicationDate = this@with.publicationDate?.toElement(),
          presentationDate = this@with.presentationDate?.value?.toString(),
          _presentationDate = this@with.presentationDate?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ImmunizationReactionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var detail: Reference? = null,
  public var reported: KotlinBoolean? = null,
  public var _reported: Element? = null,
) {
  public fun toModel(): Immunization.Reaction =
    Immunization.Reaction(
      id = this@ImmunizationReactionSurrogate.id,
      extension = this@ImmunizationReactionSurrogate.extension ?: listOf(),
      modifierExtension = this@ImmunizationReactionSurrogate.modifierExtension ?: listOf(),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ImmunizationReactionSurrogate.date),
          this@ImmunizationReactionSurrogate._date,
        ),
      detail = this@ImmunizationReactionSurrogate.detail,
      reported =
        R4bBoolean.of(
          this@ImmunizationReactionSurrogate.reported,
          this@ImmunizationReactionSurrogate._reported,
        ),
    )

  public companion object {
    public fun fromModel(model: Immunization.Reaction): ImmunizationReactionSurrogate =
      with(model) {
        ImmunizationReactionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          detail = this@with.detail,
          reported = this@with.reported?.value,
          _reported = this@with.reported?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ImmunizationProtocolAppliedSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var series: KotlinString? = null,
  public var _series: Element? = null,
  public var authority: Reference? = null,
  public var targetDisease: List<CodeableConcept>? = null,
  public var doseNumber: Immunization.ProtocolApplied.DoseNumber,
  public var seriesDoses: Immunization.ProtocolApplied.SeriesDoses? = null,
) {
  public fun toModel(): Immunization.ProtocolApplied =
    Immunization.ProtocolApplied(
      id = this@ImmunizationProtocolAppliedSurrogate.id,
      extension = this@ImmunizationProtocolAppliedSurrogate.extension ?: listOf(),
      modifierExtension = this@ImmunizationProtocolAppliedSurrogate.modifierExtension ?: listOf(),
      series =
        R4bString.of(
          this@ImmunizationProtocolAppliedSurrogate.series,
          this@ImmunizationProtocolAppliedSurrogate._series,
        ),
      authority = this@ImmunizationProtocolAppliedSurrogate.authority,
      targetDisease = this@ImmunizationProtocolAppliedSurrogate.targetDisease ?: listOf(),
      doseNumber = this@ImmunizationProtocolAppliedSurrogate.doseNumber,
      seriesDoses = this@ImmunizationProtocolAppliedSurrogate.seriesDoses,
    )

  public companion object {
    public fun fromModel(
      model: Immunization.ProtocolApplied
    ): ImmunizationProtocolAppliedSurrogate =
      with(model) {
        ImmunizationProtocolAppliedSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          series = this@with.series?.value,
          _series = this@with.series?.toElement(),
          authority = this@with.authority,
          targetDisease = this@with.targetDisease.takeIf { it.isNotEmpty() },
          doseNumber = this@with.doseNumber,
          seriesDoses = this@with.seriesDoses,
        )
      }
  }
}

@Serializable
internal data class ImmunizationOccurrenceSurrogate(
  public var occurrenceDateTime: KotlinString? = null,
  public var _occurrenceDateTime: Element? = null,
  public var occurrenceString: KotlinString? = null,
  public var _occurrenceString: Element? = null,
) {
  public fun toModel(): Immunization.Occurrence =
    Immunization.Occurrence.from(
      DateTime.of(
        FhirDateTime.fromString(this@ImmunizationOccurrenceSurrogate.occurrenceDateTime),
        this@ImmunizationOccurrenceSurrogate._occurrenceDateTime,
      ),
      R4bString.of(
        this@ImmunizationOccurrenceSurrogate.occurrenceString,
        this@ImmunizationOccurrenceSurrogate._occurrenceString,
      ),
    )!!

  public companion object {
    public fun fromModel(model: Immunization.Occurrence): ImmunizationOccurrenceSurrogate =
      with(model) {
        ImmunizationOccurrenceSurrogate(
          occurrenceDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _occurrenceDateTime = this@with.asDateTime()?.value?.toElement(),
          occurrenceString = this@with.asString()?.value?.value,
          _occurrenceString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ImmunizationProtocolAppliedDoseNumberSurrogate(
  public var doseNumberPositiveInt: Int? = null,
  public var _doseNumberPositiveInt: Element? = null,
  public var doseNumberString: KotlinString? = null,
  public var _doseNumberString: Element? = null,
) {
  public fun toModel(): Immunization.ProtocolApplied.DoseNumber =
    Immunization.ProtocolApplied.DoseNumber.from(
      PositiveInt.of(
        this@ImmunizationProtocolAppliedDoseNumberSurrogate.doseNumberPositiveInt,
        this@ImmunizationProtocolAppliedDoseNumberSurrogate._doseNumberPositiveInt,
      ),
      R4bString.of(
        this@ImmunizationProtocolAppliedDoseNumberSurrogate.doseNumberString,
        this@ImmunizationProtocolAppliedDoseNumberSurrogate._doseNumberString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: Immunization.ProtocolApplied.DoseNumber
    ): ImmunizationProtocolAppliedDoseNumberSurrogate =
      with(model) {
        ImmunizationProtocolAppliedDoseNumberSurrogate(
          doseNumberPositiveInt = this@with.asPositiveInt()?.value?.value,
          _doseNumberPositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          doseNumberString = this@with.asString()?.value?.value,
          _doseNumberString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ImmunizationProtocolAppliedSeriesDosesSurrogate(
  public var seriesDosesPositiveInt: Int? = null,
  public var _seriesDosesPositiveInt: Element? = null,
  public var seriesDosesString: KotlinString? = null,
  public var _seriesDosesString: Element? = null,
) {
  public fun toModel(): Immunization.ProtocolApplied.SeriesDoses =
    Immunization.ProtocolApplied.SeriesDoses.from(
      PositiveInt.of(
        this@ImmunizationProtocolAppliedSeriesDosesSurrogate.seriesDosesPositiveInt,
        this@ImmunizationProtocolAppliedSeriesDosesSurrogate._seriesDosesPositiveInt,
      ),
      R4bString.of(
        this@ImmunizationProtocolAppliedSeriesDosesSurrogate.seriesDosesString,
        this@ImmunizationProtocolAppliedSeriesDosesSurrogate._seriesDosesString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: Immunization.ProtocolApplied.SeriesDoses
    ): ImmunizationProtocolAppliedSeriesDosesSurrogate =
      with(model) {
        ImmunizationProtocolAppliedSeriesDosesSurrogate(
          seriesDosesPositiveInt = this@with.asPositiveInt()?.value?.value,
          _seriesDosesPositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          seriesDosesString = this@with.asString()?.value?.value,
          _seriesDosesString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ImmunizationSurrogate(
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
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: CodeableConcept? = null,
  public var vaccineCode: CodeableConcept,
  public var patient: Reference,
  public var encounter: Reference? = null,
  public var occurrence: Immunization.Occurrence,
  public var recorded: KotlinString? = null,
  public var _recorded: Element? = null,
  public var primarySource: KotlinBoolean? = null,
  public var _primarySource: Element? = null,
  public var reportOrigin: CodeableConcept? = null,
  public var location: Reference? = null,
  public var manufacturer: Reference? = null,
  public var lotNumber: KotlinString? = null,
  public var _lotNumber: Element? = null,
  public var expirationDate: KotlinString? = null,
  public var _expirationDate: Element? = null,
  public var site: CodeableConcept? = null,
  public var route: CodeableConcept? = null,
  public var doseQuantity: Quantity? = null,
  public var performer: List<Immunization.Performer>? = null,
  public var note: List<Annotation>? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var isSubpotent: KotlinBoolean? = null,
  public var _isSubpotent: Element? = null,
  public var subpotentReason: List<CodeableConcept>? = null,
  public var education: List<Immunization.Education>? = null,
  public var programEligibility: List<CodeableConcept>? = null,
  public var fundingSource: CodeableConcept? = null,
  public var reaction: List<Immunization.Reaction>? = null,
  public var protocolApplied: List<Immunization.ProtocolApplied>? = null,
) {
  public fun toModel(): Immunization =
    Immunization(
      id = this@ImmunizationSurrogate.id,
      meta = this@ImmunizationSurrogate.meta,
      implicitRules =
        Uri.of(this@ImmunizationSurrogate.implicitRules, this@ImmunizationSurrogate._implicitRules),
      language = Code.of(this@ImmunizationSurrogate.language, this@ImmunizationSurrogate._language),
      text = this@ImmunizationSurrogate.text,
      contained = this@ImmunizationSurrogate.contained ?: listOf(),
      extension = this@ImmunizationSurrogate.extension ?: listOf(),
      modifierExtension = this@ImmunizationSurrogate.modifierExtension ?: listOf(),
      identifier = this@ImmunizationSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          Immunization.ImmunizationStatusCodes.fromCode(this@ImmunizationSurrogate.status!!),
          this@ImmunizationSurrogate._status,
        ),
      statusReason = this@ImmunizationSurrogate.statusReason,
      vaccineCode = this@ImmunizationSurrogate.vaccineCode,
      patient = this@ImmunizationSurrogate.patient,
      encounter = this@ImmunizationSurrogate.encounter,
      occurrence = this@ImmunizationSurrogate.occurrence,
      recorded =
        DateTime.of(
          FhirDateTime.fromString(this@ImmunizationSurrogate.recorded),
          this@ImmunizationSurrogate._recorded,
        ),
      primarySource =
        R4bBoolean.of(
          this@ImmunizationSurrogate.primarySource,
          this@ImmunizationSurrogate._primarySource,
        ),
      reportOrigin = this@ImmunizationSurrogate.reportOrigin,
      location = this@ImmunizationSurrogate.location,
      manufacturer = this@ImmunizationSurrogate.manufacturer,
      lotNumber =
        R4bString.of(this@ImmunizationSurrogate.lotNumber, this@ImmunizationSurrogate._lotNumber),
      expirationDate =
        Date.of(
          FhirDate.fromString(this@ImmunizationSurrogate.expirationDate),
          this@ImmunizationSurrogate._expirationDate,
        ),
      site = this@ImmunizationSurrogate.site,
      route = this@ImmunizationSurrogate.route,
      doseQuantity = this@ImmunizationSurrogate.doseQuantity,
      performer = this@ImmunizationSurrogate.performer ?: listOf(),
      note = this@ImmunizationSurrogate.note ?: listOf(),
      reasonCode = this@ImmunizationSurrogate.reasonCode ?: listOf(),
      reasonReference = this@ImmunizationSurrogate.reasonReference ?: listOf(),
      isSubpotent =
        R4bBoolean.of(
          this@ImmunizationSurrogate.isSubpotent,
          this@ImmunizationSurrogate._isSubpotent,
        ),
      subpotentReason = this@ImmunizationSurrogate.subpotentReason ?: listOf(),
      education = this@ImmunizationSurrogate.education ?: listOf(),
      programEligibility = this@ImmunizationSurrogate.programEligibility ?: listOf(),
      fundingSource = this@ImmunizationSurrogate.fundingSource,
      reaction = this@ImmunizationSurrogate.reaction ?: listOf(),
      protocolApplied = this@ImmunizationSurrogate.protocolApplied ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Immunization): ImmunizationSurrogate =
      with(model) {
        ImmunizationSurrogate(
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
          statusReason = this@with.statusReason,
          vaccineCode = this@with.vaccineCode,
          patient = this@with.patient,
          encounter = this@with.encounter,
          occurrence = this@with.occurrence,
          recorded = this@with.recorded?.value?.toString(),
          _recorded = this@with.recorded?.toElement(),
          primarySource = this@with.primarySource?.value,
          _primarySource = this@with.primarySource?.toElement(),
          reportOrigin = this@with.reportOrigin,
          location = this@with.location,
          manufacturer = this@with.manufacturer,
          lotNumber = this@with.lotNumber?.value,
          _lotNumber = this@with.lotNumber?.toElement(),
          expirationDate = this@with.expirationDate?.value?.toString(),
          _expirationDate = this@with.expirationDate?.toElement(),
          site = this@with.site,
          route = this@with.route,
          doseQuantity = this@with.doseQuantity,
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          isSubpotent = this@with.isSubpotent?.value,
          _isSubpotent = this@with.isSubpotent?.toElement(),
          subpotentReason = this@with.subpotentReason.takeIf { it.isNotEmpty() },
          education = this@with.education.takeIf { it.isNotEmpty() },
          programEligibility = this@with.programEligibility.takeIf { it.isNotEmpty() },
          fundingSource = this@with.fundingSource,
          reaction = this@with.reaction.takeIf { it.isNotEmpty() },
          protocolApplied = this@with.protocolApplied.takeIf { it.isNotEmpty() },
        )
      }
  }
}
