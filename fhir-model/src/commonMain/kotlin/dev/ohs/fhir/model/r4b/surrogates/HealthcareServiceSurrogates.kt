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

import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.ContactPoint
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.HealthcareService
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Time
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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
internal data class HealthcareServiceAvailableTimeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var daysOfWeek: List<KotlinString?>? = null,
  public var _daysOfWeek: List<Element?>? = null,
  public var allDay: KotlinBoolean? = null,
  public var _allDay: Element? = null,
  public var availableStartTime: LocalTime? = null,
  public var _availableStartTime: Element? = null,
  public var availableEndTime: LocalTime? = null,
  public var _availableEndTime: Element? = null,
) {
  public fun toModel(): HealthcareService.AvailableTime =
    HealthcareService.AvailableTime(
      id = this@HealthcareServiceAvailableTimeSurrogate.id,
      extension = this@HealthcareServiceAvailableTimeSurrogate.extension ?: listOf(),
      modifierExtension =
        this@HealthcareServiceAvailableTimeSurrogate.modifierExtension ?: listOf(),
      daysOfWeek =
        if (
          this@HealthcareServiceAvailableTimeSurrogate.daysOfWeek == null &&
            this@HealthcareServiceAvailableTimeSurrogate._daysOfWeek == null
        ) {
          listOf()
        } else {
          (this@HealthcareServiceAvailableTimeSurrogate.daysOfWeek
              ?: List(this@HealthcareServiceAvailableTimeSurrogate._daysOfWeek!!.size) { null })
            .zip(
              this@HealthcareServiceAvailableTimeSurrogate._daysOfWeek
                ?: List(this@HealthcareServiceAvailableTimeSurrogate.daysOfWeek!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(value.let { HealthcareService.DaysOfWeek.fromCode(it!!) }, element)
            }
            .toList()
        },
      allDay =
        R4bBoolean.of(
          this@HealthcareServiceAvailableTimeSurrogate.allDay,
          this@HealthcareServiceAvailableTimeSurrogate._allDay,
        ),
      availableStartTime =
        Time.of(
          this@HealthcareServiceAvailableTimeSurrogate.availableStartTime,
          this@HealthcareServiceAvailableTimeSurrogate._availableStartTime,
        ),
      availableEndTime =
        Time.of(
          this@HealthcareServiceAvailableTimeSurrogate.availableEndTime,
          this@HealthcareServiceAvailableTimeSurrogate._availableEndTime,
        ),
    )

  public companion object {
    public fun fromModel(
      model: HealthcareService.AvailableTime
    ): HealthcareServiceAvailableTimeSurrogate =
      with(model) {
        HealthcareServiceAvailableTimeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          daysOfWeek =
            this@with.daysOfWeek
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _daysOfWeek =
            this@with.daysOfWeek
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          allDay = this@with.allDay?.value,
          _allDay = this@with.allDay?.toElement(),
          availableStartTime = this@with.availableStartTime?.value,
          _availableStartTime = this@with.availableStartTime?.toElement(),
          availableEndTime = this@with.availableEndTime?.value,
          _availableEndTime = this@with.availableEndTime?.toElement(),
        )
      }
  }
}

@Serializable
internal data class HealthcareServiceNotAvailableSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var during: Period? = null,
) {
  public fun toModel(): HealthcareService.NotAvailable =
    HealthcareService.NotAvailable(
      id = this@HealthcareServiceNotAvailableSurrogate.id,
      extension = this@HealthcareServiceNotAvailableSurrogate.extension ?: listOf(),
      modifierExtension = this@HealthcareServiceNotAvailableSurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@HealthcareServiceNotAvailableSurrogate.description,
          this@HealthcareServiceNotAvailableSurrogate._description,
        )!!,
      during = this@HealthcareServiceNotAvailableSurrogate.during,
    )

  public companion object {
    public fun fromModel(
      model: HealthcareService.NotAvailable
    ): HealthcareServiceNotAvailableSurrogate =
      with(model) {
        HealthcareServiceNotAvailableSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description.value,
          _description = this@with.description.toElement(),
          during = this@with.during,
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
  public var telecom: List<ContactPoint>? = null,
  public var coverageArea: List<Reference>? = null,
  public var serviceProvisionCode: List<CodeableConcept>? = null,
  public var eligibility: List<HealthcareService.Eligibility>? = null,
  public var program: List<CodeableConcept>? = null,
  public var characteristic: List<CodeableConcept>? = null,
  public var communication: List<CodeableConcept>? = null,
  public var referralMethod: List<CodeableConcept>? = null,
  public var appointmentRequired: KotlinBoolean? = null,
  public var _appointmentRequired: Element? = null,
  public var availableTime: List<HealthcareService.AvailableTime>? = null,
  public var notAvailable: List<HealthcareService.NotAvailable>? = null,
  public var availabilityExceptions: KotlinString? = null,
  public var _availabilityExceptions: Element? = null,
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
        R4bBoolean.of(
          this@HealthcareServiceSurrogate.active,
          this@HealthcareServiceSurrogate._active,
        ),
      providedBy = this@HealthcareServiceSurrogate.providedBy,
      category = this@HealthcareServiceSurrogate.category ?: listOf(),
      type = this@HealthcareServiceSurrogate.type ?: listOf(),
      specialty = this@HealthcareServiceSurrogate.specialty ?: listOf(),
      location = this@HealthcareServiceSurrogate.location ?: listOf(),
      name =
        R4bString.of(this@HealthcareServiceSurrogate.name, this@HealthcareServiceSurrogate._name),
      comment =
        R4bString.of(
          this@HealthcareServiceSurrogate.comment,
          this@HealthcareServiceSurrogate._comment,
        ),
      extraDetails =
        Markdown.of(
          this@HealthcareServiceSurrogate.extraDetails,
          this@HealthcareServiceSurrogate._extraDetails,
        ),
      photo = this@HealthcareServiceSurrogate.photo,
      telecom = this@HealthcareServiceSurrogate.telecom ?: listOf(),
      coverageArea = this@HealthcareServiceSurrogate.coverageArea ?: listOf(),
      serviceProvisionCode = this@HealthcareServiceSurrogate.serviceProvisionCode ?: listOf(),
      eligibility = this@HealthcareServiceSurrogate.eligibility ?: listOf(),
      program = this@HealthcareServiceSurrogate.program ?: listOf(),
      characteristic = this@HealthcareServiceSurrogate.characteristic ?: listOf(),
      communication = this@HealthcareServiceSurrogate.communication ?: listOf(),
      referralMethod = this@HealthcareServiceSurrogate.referralMethod ?: listOf(),
      appointmentRequired =
        R4bBoolean.of(
          this@HealthcareServiceSurrogate.appointmentRequired,
          this@HealthcareServiceSurrogate._appointmentRequired,
        ),
      availableTime = this@HealthcareServiceSurrogate.availableTime ?: listOf(),
      notAvailable = this@HealthcareServiceSurrogate.notAvailable ?: listOf(),
      availabilityExceptions =
        R4bString.of(
          this@HealthcareServiceSurrogate.availabilityExceptions,
          this@HealthcareServiceSurrogate._availabilityExceptions,
        ),
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
          telecom = this@with.telecom.takeIf { it.isNotEmpty() },
          coverageArea = this@with.coverageArea.takeIf { it.isNotEmpty() },
          serviceProvisionCode = this@with.serviceProvisionCode.takeIf { it.isNotEmpty() },
          eligibility = this@with.eligibility.takeIf { it.isNotEmpty() },
          program = this@with.program.takeIf { it.isNotEmpty() },
          characteristic = this@with.characteristic.takeIf { it.isNotEmpty() },
          communication = this@with.communication.takeIf { it.isNotEmpty() },
          referralMethod = this@with.referralMethod.takeIf { it.isNotEmpty() },
          appointmentRequired = this@with.appointmentRequired?.value,
          _appointmentRequired = this@with.appointmentRequired?.toElement(),
          availableTime = this@with.availableTime.takeIf { it.isNotEmpty() },
          notAvailable = this@with.notAvailable.takeIf { it.isNotEmpty() },
          availabilityExceptions = this@with.availabilityExceptions?.value,
          _availabilityExceptions = this@with.availabilityExceptions?.toElement(),
          endpoint = this@with.endpoint.takeIf { it.isNotEmpty() },
        )
      }
  }
}
