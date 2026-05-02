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
import com.google.fhir.model.r4b.ContactPoint
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Endpoint
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.Url
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class EndpointSurrogate(
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
  public var connectionType: Coding,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var managingOrganization: Reference? = null,
  public var contact: List<ContactPoint>? = null,
  public var period: Period? = null,
  public var payloadType: List<CodeableConcept>? = null,
  public var payloadMimeType: List<KotlinString?>? = null,
  public var _payloadMimeType: List<Element?>? = null,
  public var address: KotlinString? = null,
  public var _address: Element? = null,
  public var `header`: List<KotlinString?>? = null,
  public var _header: List<Element?>? = null,
) {
  public fun toModel(): Endpoint =
    Endpoint(
      id = this@EndpointSurrogate.id,
      meta = this@EndpointSurrogate.meta,
      implicitRules =
        Uri.of(this@EndpointSurrogate.implicitRules, this@EndpointSurrogate._implicitRules),
      language = Code.of(this@EndpointSurrogate.language, this@EndpointSurrogate._language),
      text = this@EndpointSurrogate.text,
      contained = this@EndpointSurrogate.contained ?: listOf(),
      extension = this@EndpointSurrogate.extension ?: listOf(),
      modifierExtension = this@EndpointSurrogate.modifierExtension ?: listOf(),
      identifier = this@EndpointSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          Endpoint.EndpointStatus.fromCode(this@EndpointSurrogate.status!!),
          this@EndpointSurrogate._status,
        ),
      connectionType = this@EndpointSurrogate.connectionType,
      name = R4bString.of(this@EndpointSurrogate.name, this@EndpointSurrogate._name),
      managingOrganization = this@EndpointSurrogate.managingOrganization,
      contact = this@EndpointSurrogate.contact ?: listOf(),
      period = this@EndpointSurrogate.period,
      payloadType = this@EndpointSurrogate.payloadType ?: listOf(),
      payloadMimeType =
        if (
          this@EndpointSurrogate.payloadMimeType == null &&
            this@EndpointSurrogate._payloadMimeType == null
        ) {
          listOf()
        } else {
          (this@EndpointSurrogate.payloadMimeType
              ?: List(this@EndpointSurrogate._payloadMimeType!!.size) { null })
            .zip(
              this@EndpointSurrogate._payloadMimeType
                ?: List(this@EndpointSurrogate.payloadMimeType!!.size) { null }
            )
            .map { (value, element) -> Code.of(value, element)!! }
            .toList()
        },
      address = Url.of(this@EndpointSurrogate.address, this@EndpointSurrogate._address)!!,
      `header` =
        if (this@EndpointSurrogate.`header` == null && this@EndpointSurrogate._header == null) {
          listOf()
        } else {
          (this@EndpointSurrogate.`header` ?: List(this@EndpointSurrogate._header!!.size) { null })
            .zip(
              this@EndpointSurrogate._header
                ?: List(this@EndpointSurrogate.`header`!!.size) { null }
            )
            .map { (value, element) -> R4bString.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(model: Endpoint): EndpointSurrogate =
      with(model) {
        EndpointSurrogate(
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
          connectionType = this@with.connectionType,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          managingOrganization = this@with.managingOrganization,
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          period = this@with.period,
          payloadType = this@with.payloadType.takeIf { it.isNotEmpty() },
          payloadMimeType =
            this@with.payloadMimeType
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _payloadMimeType =
            this@with.payloadMimeType
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          address = this@with.address.value,
          _address = this@with.address.toElement(),
          `header` =
            this@with.`header`.map { it.value }.toList().takeUnless { it.all { it == null } },
          _header =
            this@with.`header`
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}
