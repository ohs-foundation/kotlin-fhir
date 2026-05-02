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
import com.google.fhir.model.r5.CareTeam
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.ContactPoint
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Timing
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CareTeamParticipantSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var role: CodeableConcept? = null,
  public var member: Reference? = null,
  public var onBehalfOf: Reference? = null,
  public var coverage: CareTeam.Participant.Coverage? = null,
) {
  public fun toModel(): CareTeam.Participant =
    CareTeam.Participant(
      id = this@CareTeamParticipantSurrogate.id,
      extension = this@CareTeamParticipantSurrogate.extension ?: listOf(),
      modifierExtension = this@CareTeamParticipantSurrogate.modifierExtension ?: listOf(),
      role = this@CareTeamParticipantSurrogate.role,
      member = this@CareTeamParticipantSurrogate.member,
      onBehalfOf = this@CareTeamParticipantSurrogate.onBehalfOf,
      coverage = this@CareTeamParticipantSurrogate.coverage,
    )

  public companion object {
    public fun fromModel(model: CareTeam.Participant): CareTeamParticipantSurrogate =
      with(model) {
        CareTeamParticipantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          role = this@with.role,
          member = this@with.member,
          onBehalfOf = this@with.onBehalfOf,
          coverage = this@with.coverage,
        )
      }
  }
}

@Serializable
internal data class CareTeamParticipantCoverageSurrogate(
  public var coveragePeriod: Period? = null,
  public var coverageTiming: Timing? = null,
) {
  public fun toModel(): CareTeam.Participant.Coverage =
    CareTeam.Participant.Coverage.from(
      this@CareTeamParticipantCoverageSurrogate.coveragePeriod,
      this@CareTeamParticipantCoverageSurrogate.coverageTiming,
    )!!

  public companion object {
    public fun fromModel(
      model: CareTeam.Participant.Coverage
    ): CareTeamParticipantCoverageSurrogate =
      with(model) {
        CareTeamParticipantCoverageSurrogate(
          coveragePeriod = this@with.asPeriod()?.value,
          coverageTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class CareTeamSurrogate(
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
  public var category: List<CodeableConcept>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var subject: Reference? = null,
  public var period: Period? = null,
  public var participant: List<CareTeam.Participant>? = null,
  public var reason: List<CodeableReference>? = null,
  public var managingOrganization: List<Reference>? = null,
  public var telecom: List<ContactPoint>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): CareTeam =
    CareTeam(
      id = this@CareTeamSurrogate.id,
      meta = this@CareTeamSurrogate.meta,
      implicitRules =
        Uri.of(this@CareTeamSurrogate.implicitRules, this@CareTeamSurrogate._implicitRules),
      language = Code.of(this@CareTeamSurrogate.language, this@CareTeamSurrogate._language),
      text = this@CareTeamSurrogate.text,
      contained = this@CareTeamSurrogate.contained ?: listOf(),
      extension = this@CareTeamSurrogate.extension ?: listOf(),
      modifierExtension = this@CareTeamSurrogate.modifierExtension ?: listOf(),
      identifier = this@CareTeamSurrogate.identifier ?: listOf(),
      status =
        this@CareTeamSurrogate.status?.let {
          Enumeration.of(CareTeam.CareTeamStatus.fromCode(it), this@CareTeamSurrogate._status)
        },
      category = this@CareTeamSurrogate.category ?: listOf(),
      name = R5String.of(this@CareTeamSurrogate.name, this@CareTeamSurrogate._name),
      subject = this@CareTeamSurrogate.subject,
      period = this@CareTeamSurrogate.period,
      participant = this@CareTeamSurrogate.participant ?: listOf(),
      reason = this@CareTeamSurrogate.reason ?: listOf(),
      managingOrganization = this@CareTeamSurrogate.managingOrganization ?: listOf(),
      telecom = this@CareTeamSurrogate.telecom ?: listOf(),
      note = this@CareTeamSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: CareTeam): CareTeamSurrogate =
      with(model) {
        CareTeamSurrogate(
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
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          subject = this@with.subject,
          period = this@with.period,
          participant = this@with.participant.takeIf { it.isNotEmpty() },
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          managingOrganization = this@with.managingOrganization.takeIf { it.isNotEmpty() },
          telecom = this@with.telecom.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
