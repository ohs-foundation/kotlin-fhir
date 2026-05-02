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

import com.google.fhir.model.r5.Address
import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.ContactPoint
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.HumanName
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Practitioner
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.AdministrativeGender
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class PractitionerQualificationSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var code: CodeableConcept,
  public var period: Period? = null,
  public var issuer: Reference? = null,
) {
  public fun toModel(): Practitioner.Qualification =
    Practitioner.Qualification(
      id = this@PractitionerQualificationSurrogate.id,
      extension = this@PractitionerQualificationSurrogate.extension ?: listOf(),
      modifierExtension = this@PractitionerQualificationSurrogate.modifierExtension ?: listOf(),
      identifier = this@PractitionerQualificationSurrogate.identifier ?: listOf(),
      code = this@PractitionerQualificationSurrogate.code,
      period = this@PractitionerQualificationSurrogate.period,
      issuer = this@PractitionerQualificationSurrogate.issuer,
    )

  public companion object {
    public fun fromModel(model: Practitioner.Qualification): PractitionerQualificationSurrogate =
      with(model) {
        PractitionerQualificationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          code = this@with.code,
          period = this@with.period,
          issuer = this@with.issuer,
        )
      }
  }
}

@Serializable
internal data class PractitionerCommunicationSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var language: CodeableConcept,
  public var preferred: KotlinBoolean? = null,
  public var _preferred: Element? = null,
) {
  public fun toModel(): Practitioner.Communication =
    Practitioner.Communication(
      id = this@PractitionerCommunicationSurrogate.id,
      extension = this@PractitionerCommunicationSurrogate.extension ?: listOf(),
      modifierExtension = this@PractitionerCommunicationSurrogate.modifierExtension ?: listOf(),
      language = this@PractitionerCommunicationSurrogate.language,
      preferred =
        R5Boolean.of(
          this@PractitionerCommunicationSurrogate.preferred,
          this@PractitionerCommunicationSurrogate._preferred,
        ),
    )

  public companion object {
    public fun fromModel(model: Practitioner.Communication): PractitionerCommunicationSurrogate =
      with(model) {
        PractitionerCommunicationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          language = this@with.language,
          preferred = this@with.preferred?.value,
          _preferred = this@with.preferred?.toElement(),
        )
      }
  }
}

@Serializable
internal data class PractitionerDeceasedSurrogate(
  public var deceasedBoolean: KotlinBoolean? = null,
  public var _deceasedBoolean: Element? = null,
  public var deceasedDateTime: String? = null,
  public var _deceasedDateTime: Element? = null,
) {
  public fun toModel(): Practitioner.Deceased =
    Practitioner.Deceased.from(
      R5Boolean.of(
        this@PractitionerDeceasedSurrogate.deceasedBoolean,
        this@PractitionerDeceasedSurrogate._deceasedBoolean,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@PractitionerDeceasedSurrogate.deceasedDateTime),
        this@PractitionerDeceasedSurrogate._deceasedDateTime,
      ),
    )!!

  public companion object {
    public fun fromModel(model: Practitioner.Deceased): PractitionerDeceasedSurrogate =
      with(model) {
        PractitionerDeceasedSurrogate(
          deceasedBoolean = this@with.asBoolean()?.value?.value,
          _deceasedBoolean = this@with.asBoolean()?.value?.toElement(),
          deceasedDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _deceasedDateTime = this@with.asDateTime()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class PractitionerSurrogate(
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
  public var active: KotlinBoolean? = null,
  public var _active: Element? = null,
  public var name: List<HumanName>? = null,
  public var telecom: List<ContactPoint>? = null,
  public var gender: String? = null,
  public var _gender: Element? = null,
  public var birthDate: String? = null,
  public var _birthDate: Element? = null,
  public var deceased: Practitioner.Deceased? = null,
  public var address: List<Address>? = null,
  public var photo: List<Attachment>? = null,
  public var qualification: List<Practitioner.Qualification>? = null,
  public var communication: List<Practitioner.Communication>? = null,
) {
  public fun toModel(): Practitioner =
    Practitioner(
      id = this@PractitionerSurrogate.id,
      meta = this@PractitionerSurrogate.meta,
      implicitRules =
        Uri.of(this@PractitionerSurrogate.implicitRules, this@PractitionerSurrogate._implicitRules),
      language = Code.of(this@PractitionerSurrogate.language, this@PractitionerSurrogate._language),
      text = this@PractitionerSurrogate.text,
      contained = this@PractitionerSurrogate.contained ?: listOf(),
      extension = this@PractitionerSurrogate.extension ?: listOf(),
      modifierExtension = this@PractitionerSurrogate.modifierExtension ?: listOf(),
      identifier = this@PractitionerSurrogate.identifier ?: listOf(),
      active = R5Boolean.of(this@PractitionerSurrogate.active, this@PractitionerSurrogate._active),
      name = this@PractitionerSurrogate.name ?: listOf(),
      telecom = this@PractitionerSurrogate.telecom ?: listOf(),
      gender =
        this@PractitionerSurrogate.gender?.let {
          Enumeration.of(AdministrativeGender.fromCode(it), this@PractitionerSurrogate._gender)
        },
      birthDate =
        Date.of(
          FhirDate.fromString(this@PractitionerSurrogate.birthDate),
          this@PractitionerSurrogate._birthDate,
        ),
      deceased = this@PractitionerSurrogate.deceased,
      address = this@PractitionerSurrogate.address ?: listOf(),
      photo = this@PractitionerSurrogate.photo ?: listOf(),
      qualification = this@PractitionerSurrogate.qualification ?: listOf(),
      communication = this@PractitionerSurrogate.communication ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Practitioner): PractitionerSurrogate =
      with(model) {
        PractitionerSurrogate(
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
          active = this@with.active?.value,
          _active = this@with.active?.toElement(),
          name = this@with.name.takeIf { it.isNotEmpty() },
          telecom = this@with.telecom.takeIf { it.isNotEmpty() },
          gender = this@with.gender?.value?.getCode(),
          _gender = this@with.gender?.toElement(),
          birthDate = this@with.birthDate?.value?.toString(),
          _birthDate = this@with.birthDate?.toElement(),
          deceased = this@with.deceased,
          address = this@with.address.takeIf { it.isNotEmpty() },
          photo = this@with.photo.takeIf { it.isNotEmpty() },
          qualification = this@with.qualification.takeIf { it.isNotEmpty() },
          communication = this@with.communication.takeIf { it.isNotEmpty() },
        )
      }
  }
}
