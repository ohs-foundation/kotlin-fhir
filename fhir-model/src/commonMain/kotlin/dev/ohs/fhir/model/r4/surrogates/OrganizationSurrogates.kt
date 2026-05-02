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
import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.ContactPoint
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.HumanName
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Organization
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
internal data class OrganizationContactSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var purpose: CodeableConcept? = null,
  public var name: HumanName? = null,
  public var telecom: List<ContactPoint>? = null,
  public var address: Address? = null,
) {
  public fun toModel(): Organization.Contact =
    Organization.Contact(
      id = this@OrganizationContactSurrogate.id,
      extension = this@OrganizationContactSurrogate.extension ?: listOf(),
      modifierExtension = this@OrganizationContactSurrogate.modifierExtension ?: listOf(),
      purpose = this@OrganizationContactSurrogate.purpose,
      name = this@OrganizationContactSurrogate.name,
      telecom = this@OrganizationContactSurrogate.telecom ?: listOf(),
      address = this@OrganizationContactSurrogate.address,
    )

  public companion object {
    public fun fromModel(model: Organization.Contact): OrganizationContactSurrogate =
      with(model) {
        OrganizationContactSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          purpose = this@with.purpose,
          name = this@with.name,
          telecom = this@with.telecom.takeIf { it.isNotEmpty() },
          address = this@with.address,
        )
      }
  }
}

@Serializable
internal data class OrganizationSurrogate(
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
  public var active: KotlinBoolean? = null,
  public var _active: Element? = null,
  public var type: List<CodeableConcept>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var alias: List<KotlinString?>? = null,
  public var _alias: List<Element?>? = null,
  public var telecom: List<ContactPoint>? = null,
  public var address: List<Address>? = null,
  public var partOf: Reference? = null,
  public var contact: List<Organization.Contact>? = null,
  public var endpoint: List<Reference>? = null,
) {
  public fun toModel(): Organization =
    Organization(
      id = this@OrganizationSurrogate.id,
      meta = this@OrganizationSurrogate.meta,
      implicitRules =
        Uri.of(this@OrganizationSurrogate.implicitRules, this@OrganizationSurrogate._implicitRules),
      language = Code.of(this@OrganizationSurrogate.language, this@OrganizationSurrogate._language),
      text = this@OrganizationSurrogate.text,
      contained = this@OrganizationSurrogate.contained ?: listOf(),
      extension = this@OrganizationSurrogate.extension ?: listOf(),
      modifierExtension = this@OrganizationSurrogate.modifierExtension ?: listOf(),
      identifier = this@OrganizationSurrogate.identifier ?: listOf(),
      active = R4Boolean.of(this@OrganizationSurrogate.active, this@OrganizationSurrogate._active),
      type = this@OrganizationSurrogate.type ?: listOf(),
      name = R4String.of(this@OrganizationSurrogate.name, this@OrganizationSurrogate._name),
      alias =
        if (this@OrganizationSurrogate.alias == null && this@OrganizationSurrogate._alias == null) {
          listOf()
        } else {
          (this@OrganizationSurrogate.alias
              ?: List(this@OrganizationSurrogate._alias!!.size) { null })
            .zip(
              this@OrganizationSurrogate._alias
                ?: List(this@OrganizationSurrogate.alias!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      telecom = this@OrganizationSurrogate.telecom ?: listOf(),
      address = this@OrganizationSurrogate.address ?: listOf(),
      partOf = this@OrganizationSurrogate.partOf,
      contact = this@OrganizationSurrogate.contact ?: listOf(),
      endpoint = this@OrganizationSurrogate.endpoint ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Organization): OrganizationSurrogate =
      with(model) {
        OrganizationSurrogate(
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
          type = this@with.type.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          alias = this@with.alias.map { it.value }.toList().takeUnless { it.all { it == null } },
          _alias =
            this@with.alias
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          telecom = this@with.telecom.takeIf { it.isNotEmpty() },
          address = this@with.address.takeIf { it.isNotEmpty() },
          partOf = this@with.partOf,
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          endpoint = this@with.endpoint.takeIf { it.isNotEmpty() },
        )
      }
  }
}
