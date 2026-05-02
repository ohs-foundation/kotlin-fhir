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
import com.google.fhir.model.r4.Coding
import com.google.fhir.model.r4.ContactPoint
import com.google.fhir.model.r4.Decimal
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Location
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Time
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Double
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class LocationPositionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var longitude: Double? = null,
  public var _longitude: Element? = null,
  public var latitude: Double? = null,
  public var _latitude: Element? = null,
  public var altitude: Double? = null,
  public var _altitude: Element? = null,
) {
  public fun toModel(): Location.Position =
    Location.Position(
      id = this@LocationPositionSurrogate.id,
      extension = this@LocationPositionSurrogate.extension ?: listOf(),
      modifierExtension = this@LocationPositionSurrogate.modifierExtension ?: listOf(),
      longitude =
        Decimal.of(
          this@LocationPositionSurrogate.longitude,
          this@LocationPositionSurrogate._longitude,
        )!!,
      latitude =
        Decimal.of(
          this@LocationPositionSurrogate.latitude,
          this@LocationPositionSurrogate._latitude,
        )!!,
      altitude =
        Decimal.of(
          this@LocationPositionSurrogate.altitude,
          this@LocationPositionSurrogate._altitude,
        ),
    )

  public companion object {
    public fun fromModel(model: Location.Position): LocationPositionSurrogate =
      with(model) {
        LocationPositionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          longitude = this@with.longitude.value?.toString()?.toDouble(),
          _longitude = this@with.longitude.toElement(),
          latitude = this@with.latitude.value?.toString()?.toDouble(),
          _latitude = this@with.latitude.toElement(),
          altitude = this@with.altitude?.value?.toString()?.toDouble(),
          _altitude = this@with.altitude?.toElement(),
        )
      }
  }
}

@Serializable
internal data class LocationHoursOfOperationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var daysOfWeek: List<KotlinString?>? = null,
  public var _daysOfWeek: List<Element?>? = null,
  public var allDay: KotlinBoolean? = null,
  public var _allDay: Element? = null,
  public var openingTime: LocalTime? = null,
  public var _openingTime: Element? = null,
  public var closingTime: LocalTime? = null,
  public var _closingTime: Element? = null,
) {
  public fun toModel(): Location.HoursOfOperation =
    Location.HoursOfOperation(
      id = this@LocationHoursOfOperationSurrogate.id,
      extension = this@LocationHoursOfOperationSurrogate.extension ?: listOf(),
      modifierExtension = this@LocationHoursOfOperationSurrogate.modifierExtension ?: listOf(),
      daysOfWeek =
        if (
          this@LocationHoursOfOperationSurrogate.daysOfWeek == null &&
            this@LocationHoursOfOperationSurrogate._daysOfWeek == null
        ) {
          listOf()
        } else {
          (this@LocationHoursOfOperationSurrogate.daysOfWeek
              ?: List(this@LocationHoursOfOperationSurrogate._daysOfWeek!!.size) { null })
            .zip(
              this@LocationHoursOfOperationSurrogate._daysOfWeek
                ?: List(this@LocationHoursOfOperationSurrogate.daysOfWeek!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(value.let { Location.DaysOfWeek.fromCode(it!!) }, element)
            }
            .toList()
        },
      allDay =
        R4Boolean.of(
          this@LocationHoursOfOperationSurrogate.allDay,
          this@LocationHoursOfOperationSurrogate._allDay,
        ),
      openingTime =
        Time.of(
          this@LocationHoursOfOperationSurrogate.openingTime,
          this@LocationHoursOfOperationSurrogate._openingTime,
        ),
      closingTime =
        Time.of(
          this@LocationHoursOfOperationSurrogate.closingTime,
          this@LocationHoursOfOperationSurrogate._closingTime,
        ),
    )

  public companion object {
    public fun fromModel(model: Location.HoursOfOperation): LocationHoursOfOperationSurrogate =
      with(model) {
        LocationHoursOfOperationSurrogate(
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
          openingTime = this@with.openingTime?.value,
          _openingTime = this@with.openingTime?.toElement(),
          closingTime = this@with.closingTime?.value,
          _closingTime = this@with.closingTime?.toElement(),
        )
      }
  }
}

@Serializable
internal data class LocationSurrogate(
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
  public var operationalStatus: Coding? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var alias: List<KotlinString?>? = null,
  public var _alias: List<Element?>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var mode: KotlinString? = null,
  public var _mode: Element? = null,
  public var type: List<CodeableConcept>? = null,
  public var telecom: List<ContactPoint>? = null,
  public var address: Address? = null,
  public var physicalType: CodeableConcept? = null,
  public var position: Location.Position? = null,
  public var managingOrganization: Reference? = null,
  public var partOf: Reference? = null,
  public var hoursOfOperation: List<Location.HoursOfOperation>? = null,
  public var availabilityExceptions: KotlinString? = null,
  public var _availabilityExceptions: Element? = null,
  public var endpoint: List<Reference>? = null,
) {
  public fun toModel(): Location =
    Location(
      id = this@LocationSurrogate.id,
      meta = this@LocationSurrogate.meta,
      implicitRules =
        Uri.of(this@LocationSurrogate.implicitRules, this@LocationSurrogate._implicitRules),
      language = Code.of(this@LocationSurrogate.language, this@LocationSurrogate._language),
      text = this@LocationSurrogate.text,
      contained = this@LocationSurrogate.contained ?: listOf(),
      extension = this@LocationSurrogate.extension ?: listOf(),
      modifierExtension = this@LocationSurrogate.modifierExtension ?: listOf(),
      identifier = this@LocationSurrogate.identifier ?: listOf(),
      status =
        this@LocationSurrogate.status?.let {
          Enumeration.of(Location.LocationStatus.fromCode(it), this@LocationSurrogate._status)
        },
      operationalStatus = this@LocationSurrogate.operationalStatus,
      name = R4String.of(this@LocationSurrogate.name, this@LocationSurrogate._name),
      alias =
        if (this@LocationSurrogate.alias == null && this@LocationSurrogate._alias == null) {
          listOf()
        } else {
          (this@LocationSurrogate.alias ?: List(this@LocationSurrogate._alias!!.size) { null })
            .zip(
              this@LocationSurrogate._alias ?: List(this@LocationSurrogate.alias!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      description =
        R4String.of(this@LocationSurrogate.description, this@LocationSurrogate._description),
      mode =
        this@LocationSurrogate.mode?.let {
          Enumeration.of(Location.LocationMode.fromCode(it), this@LocationSurrogate._mode)
        },
      type = this@LocationSurrogate.type ?: listOf(),
      telecom = this@LocationSurrogate.telecom ?: listOf(),
      address = this@LocationSurrogate.address,
      physicalType = this@LocationSurrogate.physicalType,
      position = this@LocationSurrogate.position,
      managingOrganization = this@LocationSurrogate.managingOrganization,
      partOf = this@LocationSurrogate.partOf,
      hoursOfOperation = this@LocationSurrogate.hoursOfOperation ?: listOf(),
      availabilityExceptions =
        R4String.of(
          this@LocationSurrogate.availabilityExceptions,
          this@LocationSurrogate._availabilityExceptions,
        ),
      endpoint = this@LocationSurrogate.endpoint ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Location): LocationSurrogate =
      with(model) {
        LocationSurrogate(
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
          operationalStatus = this@with.operationalStatus,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          alias = this@with.alias.map { it.value }.toList().takeUnless { it.all { it == null } },
          _alias =
            this@with.alias
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          mode = this@with.mode?.value?.getCode(),
          _mode = this@with.mode?.toElement(),
          type = this@with.type.takeIf { it.isNotEmpty() },
          telecom = this@with.telecom.takeIf { it.isNotEmpty() },
          address = this@with.address,
          physicalType = this@with.physicalType,
          position = this@with.position,
          managingOrganization = this@with.managingOrganization,
          partOf = this@with.partOf,
          hoursOfOperation = this@with.hoursOfOperation.takeIf { it.isNotEmpty() },
          availabilityExceptions = this@with.availabilityExceptions?.value,
          _availabilityExceptions = this@with.availabilityExceptions?.toElement(),
          endpoint = this@with.endpoint.takeIf { it.isNotEmpty() },
        )
      }
  }
}
