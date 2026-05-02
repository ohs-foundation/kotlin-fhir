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

import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Availability
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.ExtendedContactDetail
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.HealthcareService
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
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
internal data class HealthcareServiceEligibilitySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
) {
  public fun toModel(): HealthcareService.Eligibility =
    HealthcareService.Eligibility(
      id = this@HealthcareServiceEligibilitySurrogate.id,
      extension = this@HealthcareServiceEligibilitySurrogate.extension ?: listOf(),
      modifierExtension = this@HealthcareServiceEligibilitySurrogate.modifierExtension ?: listOf(),
      code = this@HealthcareServiceEligibilitySurrogate.code,
      comment =
        Markdown.of(
          this@HealthcareServiceEligibilitySurrogate.comment,
          this@HealthcareServiceEligibilitySurrogate._comment,
        ),
    )

  public companion object {
    public fun fromModel(
      model: HealthcareService.Eligibility
    ): HealthcareServiceEligibilitySurrogate =
      with(model) {
        HealthcareServiceEligibilitySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
        )
      }
  }
}

@Serializable
internal data class HealthcareServiceSurrogate(
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
  public var providedBy: Reference? = null,
  public var offeredIn: List<Reference>? = null,
  public var category: List<CodeableConcept>? = null,
  public var type: List<CodeableConcept>? = null,
  public var specialty: List<CodeableConcept>? = null,
  public var location: List<Reference>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
  public var extraDetails: KotlinString? = null,
  public var _extraDetails: Element? = null,
  public var photo: Attachment? = null,
  public var contact: List<ExtendedContactDetail>? = null,
  public var coverageArea: List<Reference>? = null,
  public var serviceProvisionCode: List<CodeableConcept>? = null,
  public var eligibility: List<HealthcareService.Eligibility>? = null,
  public var program: List<CodeableConcept>? = null,
  public var characteristic: List<CodeableConcept>? = null,
  public var communication: List<CodeableConcept>? = null,
  public var referralMethod: List<CodeableConcept>? = null,
  public var appointmentRequired: KotlinBoolean? = null,
  public var _appointmentRequired: Element? = null,
  public var availability: List<Availability>? = null,
  public var endpoint: List<Reference>? = null,
) {
  public fun toModel(): HealthcareService =
    HealthcareService(
      id = this@HealthcareServiceSurrogate.id,
      meta = this@HealthcareServiceSurrogate.meta,
      implicitRules =
        Uri.of(
          this@HealthcareServiceSurrogate.implicitRules,
          this@HealthcareServiceSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@HealthcareServiceSurrogate.language,
          this@HealthcareServiceSurrogate._language,
        ),
      text = this@HealthcareServiceSurrogate.text,
      contained = this@HealthcareServiceSurrogate.contained ?: listOf(),
      extension = this@HealthcareServiceSurrogate.extension ?: listOf(),
      modifierExtension = this@HealthcareServiceSurrogate.modifierExtension ?: listOf(),
      identifier = this@HealthcareServiceSurrogate.identifier ?: listOf(),
      active =
        R5Boolean.of(
          this@HealthcareServiceSurrogate.active,
          this@HealthcareServiceSurrogate._active,
        ),
      providedBy = this@HealthcareServiceSurrogate.providedBy,
      offeredIn = this@HealthcareServiceSurrogate.offeredIn ?: listOf(),
      category = this@HealthcareServiceSurrogate.category ?: listOf(),
      type = this@HealthcareServiceSurrogate.type ?: listOf(),
      specialty = this@HealthcareServiceSurrogate.specialty ?: listOf(),
      location = this@HealthcareServiceSurrogate.location ?: listOf(),
      name =
        R5String.of(this@HealthcareServiceSurrogate.name, this@HealthcareServiceSurrogate._name),
      comment =
        Markdown.of(
          this@HealthcareServiceSurrogate.comment,
          this@HealthcareServiceSurrogate._comment,
        ),
      extraDetails =
        Markdown.of(
          this@HealthcareServiceSurrogate.extraDetails,
          this@HealthcareServiceSurrogate._extraDetails,
        ),
      photo = this@HealthcareServiceSurrogate.photo,
      contact = this@HealthcareServiceSurrogate.contact ?: listOf(),
      coverageArea = this@HealthcareServiceSurrogate.coverageArea ?: listOf(),
      serviceProvisionCode = this@HealthcareServiceSurrogate.serviceProvisionCode ?: listOf(),
      eligibility = this@HealthcareServiceSurrogate.eligibility ?: listOf(),
      program = this@HealthcareServiceSurrogate.program ?: listOf(),
      characteristic = this@HealthcareServiceSurrogate.characteristic ?: listOf(),
      communication = this@HealthcareServiceSurrogate.communication ?: listOf(),
      referralMethod = this@HealthcareServiceSurrogate.referralMethod ?: listOf(),
      appointmentRequired =
        R5Boolean.of(
          this@HealthcareServiceSurrogate.appointmentRequired,
          this@HealthcareServiceSurrogate._appointmentRequired,
        ),
      availability = this@HealthcareServiceSurrogate.availability ?: listOf(),
      endpoint = this@HealthcareServiceSurrogate.endpoint ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: HealthcareService): HealthcareServiceSurrogate =
      with(model) {
        HealthcareServiceSurrogate(
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
          providedBy = this@with.providedBy,
          offeredIn = this@with.offeredIn.takeIf { it.isNotEmpty() },
          category = this@with.category.takeIf { it.isNotEmpty() },
          type = this@with.type.takeIf { it.isNotEmpty() },
          specialty = this@with.specialty.takeIf { it.isNotEmpty() },
          location = this@with.location.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
          extraDetails = this@with.extraDetails?.value,
          _extraDetails = this@with.extraDetails?.toElement(),
          photo = this@with.photo,
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          coverageArea = this@with.coverageArea.takeIf { it.isNotEmpty() },
          serviceProvisionCode = this@with.serviceProvisionCode.takeIf { it.isNotEmpty() },
          eligibility = this@with.eligibility.takeIf { it.isNotEmpty() },
          program = this@with.program.takeIf { it.isNotEmpty() },
          characteristic = this@with.characteristic.takeIf { it.isNotEmpty() },
          communication = this@with.communication.takeIf { it.isNotEmpty() },
          referralMethod = this@with.referralMethod.takeIf { it.isNotEmpty() },
          appointmentRequired = this@with.appointmentRequired?.value,
          _appointmentRequired = this@with.appointmentRequired?.toElement(),
          availability = this@with.availability.takeIf { it.isNotEmpty() },
          endpoint = this@with.endpoint.takeIf { it.isNotEmpty() },
        )
      }
  }
}
