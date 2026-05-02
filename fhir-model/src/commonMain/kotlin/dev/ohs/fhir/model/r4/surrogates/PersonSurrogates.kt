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

import com.google.fhir.model.r4.Address
import com.google.fhir.model.r4.Attachment
import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.ContactPoint
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDate
import com.google.fhir.model.r4.HumanName
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Person
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.AdministrativeGender
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

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
  public var name: List<HumanName>? = null,
  public var telecom: List<ContactPoint>? = null,
  public var gender: String? = null,
  public var _gender: Element? = null,
  public var birthDate: String? = null,
  public var _birthDate: Element? = null,
  public var address: List<Address>? = null,
  public var photo: Attachment? = null,
  public var managingOrganization: Reference? = null,
  public var active: KotlinBoolean? = null,
  public var _active: Element? = null,
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
      address = this@PersonSurrogate.address ?: listOf(),
      photo = this@PersonSurrogate.photo,
      managingOrganization = this@PersonSurrogate.managingOrganization,
      active = R4Boolean.of(this@PersonSurrogate.active, this@PersonSurrogate._active),
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
          name = this@with.name.takeIf { it.isNotEmpty() },
          telecom = this@with.telecom.takeIf { it.isNotEmpty() },
          gender = this@with.gender?.value?.getCode(),
          _gender = this@with.gender?.toElement(),
          birthDate = this@with.birthDate?.value?.toString(),
          _birthDate = this@with.birthDate?.toElement(),
          address = this@with.address.takeIf { it.isNotEmpty() },
          photo = this@with.photo,
          managingOrganization = this@with.managingOrganization,
          active = this@with.active?.value,
          _active = this@with.active?.toElement(),
          link = this@with.link.takeIf { it.isNotEmpty() },
        )
      }
  }
}
