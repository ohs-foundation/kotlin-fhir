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
import com.google.fhir.model.r5.Person
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
internal data class PersonCommunicationSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var language: CodeableConcept,
  public var preferred: KotlinBoolean? = null,
  public var _preferred: Element? = null,
) {
  public fun toModel(): Person.Communication =
    Person.Communication(
      id = this@PersonCommunicationSurrogate.id,
      extension = this@PersonCommunicationSurrogate.extension ?: listOf(),
      modifierExtension = this@PersonCommunicationSurrogate.modifierExtension ?: listOf(),
      language = this@PersonCommunicationSurrogate.language,
      preferred =
        R5Boolean.of(
          this@PersonCommunicationSurrogate.preferred,
          this@PersonCommunicationSurrogate._preferred,
        ),
    )

  public companion object {
    public fun fromModel(model: Person.Communication): PersonCommunicationSurrogate =
      with(model) {
        PersonCommunicationSurrogate(
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
internal data class PersonLinkSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var target: Reference,
  public var assurance: String? = null,
  public var _assurance: Element? = null,
) {
  public fun toModel(): Person.Link =
    Person.Link(
      id = this@PersonLinkSurrogate.id,
      extension = this@PersonLinkSurrogate.extension ?: listOf(),
      modifierExtension = this@PersonLinkSurrogate.modifierExtension ?: listOf(),
      target = this@PersonLinkSurrogate.target,
      assurance =
        this@PersonLinkSurrogate.assurance?.let {
          Enumeration.of(
            Person.IdentityAssuranceLevel.fromCode(it),
            this@PersonLinkSurrogate._assurance,
          )
        },
    )

  public companion object {
    public fun fromModel(model: Person.Link): PersonLinkSurrogate =
      with(model) {
        PersonLinkSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          target = this@with.target,
          assurance = this@with.assurance?.value?.getCode(),
          _assurance = this@with.assurance?.toElement(),
        )
      }
  }
}

@Serializable
internal data class PersonDeceasedSurrogate(
  public var deceasedBoolean: KotlinBoolean? = null,
  public var _deceasedBoolean: Element? = null,
  public var deceasedDateTime: String? = null,
  public var _deceasedDateTime: Element? = null,
) {
  public fun toModel(): Person.Deceased =
    Person.Deceased.from(
      R5Boolean.of(
        this@PersonDeceasedSurrogate.deceasedBoolean,
        this@PersonDeceasedSurrogate._deceasedBoolean,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@PersonDeceasedSurrogate.deceasedDateTime),
        this@PersonDeceasedSurrogate._deceasedDateTime,
      ),
    )!!

  public companion object {
    public fun fromModel(model: Person.Deceased): PersonDeceasedSurrogate =
      with(model) {
        PersonDeceasedSurrogate(
          deceasedBoolean = this@with.asBoolean()?.value?.value,
          _deceasedBoolean = this@with.asBoolean()?.value?.toElement(),
          deceasedDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _deceasedDateTime = this@with.asDateTime()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class PersonSurrogate(
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
  public var deceased: Person.Deceased? = null,
  public var address: List<Address>? = null,
  public var maritalStatus: CodeableConcept? = null,
  public var photo: List<Attachment>? = null,
  public var communication: List<Person.Communication>? = null,
  public var managingOrganization: Reference? = null,
  public var link: List<Person.Link>? = null,
) {
  public fun toModel(): Person =
    Person(
      id = this@PersonSurrogate.id,
      meta = this@PersonSurrogate.meta,
      implicitRules =
        Uri.of(this@PersonSurrogate.implicitRules, this@PersonSurrogate._implicitRules),
      language = Code.of(this@PersonSurrogate.language, this@PersonSurrogate._language),
      text = this@PersonSurrogate.text,
      contained = this@PersonSurrogate.contained ?: listOf(),
      extension = this@PersonSurrogate.extension ?: listOf(),
      modifierExtension = this@PersonSurrogate.modifierExtension ?: listOf(),
      identifier = this@PersonSurrogate.identifier ?: listOf(),
      active = R5Boolean.of(this@PersonSurrogate.active, this@PersonSurrogate._active),
      name = this@PersonSurrogate.name ?: listOf(),
      telecom = this@PersonSurrogate.telecom ?: listOf(),
      gender =
        this@PersonSurrogate.gender?.let {
          Enumeration.of(AdministrativeGender.fromCode(it), this@PersonSurrogate._gender)
        },
      birthDate =
        Date.of(
          FhirDate.fromString(this@PersonSurrogate.birthDate),
          this@PersonSurrogate._birthDate,
        ),
      deceased = this@PersonSurrogate.deceased,
      address = this@PersonSurrogate.address ?: listOf(),
      maritalStatus = this@PersonSurrogate.maritalStatus,
      photo = this@PersonSurrogate.photo ?: listOf(),
      communication = this@PersonSurrogate.communication ?: listOf(),
      managingOrganization = this@PersonSurrogate.managingOrganization,
      link = this@PersonSurrogate.link ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Person): PersonSurrogate =
      with(model) {
        PersonSurrogate(
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
          maritalStatus = this@with.maritalStatus,
          photo = this@with.photo.takeIf { it.isNotEmpty() },
          communication = this@with.communication.takeIf { it.isNotEmpty() },
          managingOrganization = this@with.managingOrganization,
          link = this@with.link.takeIf { it.isNotEmpty() },
        )
      }
  }
}
