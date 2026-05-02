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

import com.google.fhir.model.r5.Availability
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Time
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class AvailabilityAvailableTimeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var daysOfWeek: List<KotlinString?>? = null,
  public var _daysOfWeek: List<Element?>? = null,
  public var allDay: KotlinBoolean? = null,
  public var _allDay: Element? = null,
  public var availableStartTime: LocalTime? = null,
  public var _availableStartTime: Element? = null,
  public var availableEndTime: LocalTime? = null,
  public var _availableEndTime: Element? = null,
) {
  public fun toModel(): Availability.AvailableTime =
    Availability.AvailableTime(
      id = this@AvailabilityAvailableTimeSurrogate.id,
      extension = this@AvailabilityAvailableTimeSurrogate.extension ?: listOf(),
      daysOfWeek =
        if (
          this@AvailabilityAvailableTimeSurrogate.daysOfWeek == null &&
            this@AvailabilityAvailableTimeSurrogate._daysOfWeek == null
        ) {
          listOf()
        } else {
          (this@AvailabilityAvailableTimeSurrogate.daysOfWeek
              ?: List(this@AvailabilityAvailableTimeSurrogate._daysOfWeek!!.size) { null })
            .zip(
              this@AvailabilityAvailableTimeSurrogate._daysOfWeek
                ?: List(this@AvailabilityAvailableTimeSurrogate.daysOfWeek!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(value.let { Availability.DaysOfWeek.fromCode(it!!) }, element)
            }
            .toList()
        },
      allDay =
        R5Boolean.of(
          this@AvailabilityAvailableTimeSurrogate.allDay,
          this@AvailabilityAvailableTimeSurrogate._allDay,
        ),
      availableStartTime =
        Time.of(
          this@AvailabilityAvailableTimeSurrogate.availableStartTime,
          this@AvailabilityAvailableTimeSurrogate._availableStartTime,
        ),
      availableEndTime =
        Time.of(
          this@AvailabilityAvailableTimeSurrogate.availableEndTime,
          this@AvailabilityAvailableTimeSurrogate._availableEndTime,
        ),
    )

  public companion object {
    public fun fromModel(model: Availability.AvailableTime): AvailabilityAvailableTimeSurrogate =
      with(model) {
        AvailabilityAvailableTimeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
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
internal data class AvailabilityNotAvailableTimeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var during: Period? = null,
) {
  public fun toModel(): Availability.NotAvailableTime =
    Availability.NotAvailableTime(
      id = this@AvailabilityNotAvailableTimeSurrogate.id,
      extension = this@AvailabilityNotAvailableTimeSurrogate.extension ?: listOf(),
      description =
        R5String.of(
          this@AvailabilityNotAvailableTimeSurrogate.description,
          this@AvailabilityNotAvailableTimeSurrogate._description,
        ),
      during = this@AvailabilityNotAvailableTimeSurrogate.during,
    )

  public companion object {
    public fun fromModel(
      model: Availability.NotAvailableTime
    ): AvailabilityNotAvailableTimeSurrogate =
      with(model) {
        AvailabilityNotAvailableTimeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          during = this@with.during,
        )
      }
  }
}

@Serializable
internal data class AvailabilitySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var availableTime: List<Availability.AvailableTime>? = null,
  public var notAvailableTime: List<Availability.NotAvailableTime>? = null,
) {
  public fun toModel(): Availability =
    Availability(
      id = this@AvailabilitySurrogate.id,
      extension = this@AvailabilitySurrogate.extension ?: listOf(),
      availableTime = this@AvailabilitySurrogate.availableTime ?: listOf(),
      notAvailableTime = this@AvailabilitySurrogate.notAvailableTime ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Availability): AvailabilitySurrogate =
      with(model) {
        AvailabilitySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          availableTime = this@with.availableTime.takeIf { it.isNotEmpty() },
          notAvailableTime = this@with.notAvailableTime.takeIf { it.isNotEmpty() },
        )
      }
  }
}
