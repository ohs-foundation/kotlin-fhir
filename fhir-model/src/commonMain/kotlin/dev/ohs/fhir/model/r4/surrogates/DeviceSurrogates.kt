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

import com.google.fhir.model.r4.Annotation
import com.google.fhir.model.r4.Base64Binary
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.ContactPoint
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Device
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class DeviceUdiCarrierSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var deviceIdentifier: KotlinString? = null,
  public var _deviceIdentifier: Element? = null,
  public var issuer: KotlinString? = null,
  public var _issuer: Element? = null,
  public var jurisdiction: KotlinString? = null,
  public var _jurisdiction: Element? = null,
  public var carrierAIDC: KotlinString? = null,
  public var _carrierAIDC: Element? = null,
  public var carrierHRF: KotlinString? = null,
  public var _carrierHRF: Element? = null,
  public var entryType: KotlinString? = null,
  public var _entryType: Element? = null,
) {
  public fun toModel(): Device.UdiCarrier =
    Device.UdiCarrier(
      id = this@DeviceUdiCarrierSurrogate.id,
      extension = this@DeviceUdiCarrierSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceUdiCarrierSurrogate.modifierExtension ?: listOf(),
      deviceIdentifier =
        R4String.of(
          this@DeviceUdiCarrierSurrogate.deviceIdentifier,
          this@DeviceUdiCarrierSurrogate._deviceIdentifier,
        ),
      issuer =
        Uri.of(this@DeviceUdiCarrierSurrogate.issuer, this@DeviceUdiCarrierSurrogate._issuer),
      jurisdiction =
        Uri.of(
          this@DeviceUdiCarrierSurrogate.jurisdiction,
          this@DeviceUdiCarrierSurrogate._jurisdiction,
        ),
      carrierAIDC =
        Base64Binary.of(
          this@DeviceUdiCarrierSurrogate.carrierAIDC,
          this@DeviceUdiCarrierSurrogate._carrierAIDC,
        ),
      carrierHRF =
        R4String.of(
          this@DeviceUdiCarrierSurrogate.carrierHRF,
          this@DeviceUdiCarrierSurrogate._carrierHRF,
        ),
      entryType =
        this@DeviceUdiCarrierSurrogate.entryType?.let {
          Enumeration.of(
            Device.UDIEntryType.fromCode(it),
            this@DeviceUdiCarrierSurrogate._entryType,
          )
        },
    )

  public companion object {
    public fun fromModel(model: Device.UdiCarrier): DeviceUdiCarrierSurrogate =
      with(model) {
        DeviceUdiCarrierSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          deviceIdentifier = this@with.deviceIdentifier?.value,
          _deviceIdentifier = this@with.deviceIdentifier?.toElement(),
          issuer = this@with.issuer?.value,
          _issuer = this@with.issuer?.toElement(),
          jurisdiction = this@with.jurisdiction?.value,
          _jurisdiction = this@with.jurisdiction?.toElement(),
          carrierAIDC = this@with.carrierAIDC?.value,
          _carrierAIDC = this@with.carrierAIDC?.toElement(),
          carrierHRF = this@with.carrierHRF?.value,
          _carrierHRF = this@with.carrierHRF?.toElement(),
          entryType = this@with.entryType?.value?.getCode(),
          _entryType = this@with.entryType?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceDeviceNameSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
) {
  public fun toModel(): Device.DeviceName =
    Device.DeviceName(
      id = this@DeviceDeviceNameSurrogate.id,
      extension = this@DeviceDeviceNameSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDeviceNameSurrogate.modifierExtension ?: listOf(),
      name =
        R4String.of(this@DeviceDeviceNameSurrogate.name, this@DeviceDeviceNameSurrogate._name)!!,
      type =
        Enumeration.of(
          Device.DeviceNameType.fromCode(this@DeviceDeviceNameSurrogate.type!!),
          this@DeviceDeviceNameSurrogate._type,
        ),
    )

  public companion object {
    public fun fromModel(model: Device.DeviceName): DeviceDeviceNameSurrogate =
      with(model) {
        DeviceDeviceNameSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceSpecializationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var systemType: CodeableConcept,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
) {
  public fun toModel(): Device.Specialization =
    Device.Specialization(
      id = this@DeviceSpecializationSurrogate.id,
      extension = this@DeviceSpecializationSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceSpecializationSurrogate.modifierExtension ?: listOf(),
      systemType = this@DeviceSpecializationSurrogate.systemType,
      version =
        R4String.of(
          this@DeviceSpecializationSurrogate.version,
          this@DeviceSpecializationSurrogate._version,
        ),
    )

  public companion object {
    public fun fromModel(model: Device.Specialization): DeviceSpecializationSurrogate =
      with(model) {
        DeviceSpecializationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          systemType = this@with.systemType,
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceVersionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var component: Identifier? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): Device.Version =
    Device.Version(
      id = this@DeviceVersionSurrogate.id,
      extension = this@DeviceVersionSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceVersionSurrogate.modifierExtension ?: listOf(),
      type = this@DeviceVersionSurrogate.type,
      component = this@DeviceVersionSurrogate.component,
      `value` =
        R4String.of(this@DeviceVersionSurrogate.`value`, this@DeviceVersionSurrogate._value)!!,
    )

  public companion object {
    public fun fromModel(model: Device.Version): DeviceVersionSurrogate =
      with(model) {
        DeviceVersionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          component = this@with.component,
          `value` = this@with.`value`.value,
          _value = this@with.`value`.toElement(),
        )
      }
  }
}

@Serializable
internal data class DevicePropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var valueQuantity: List<Quantity>? = null,
  public var valueCode: List<CodeableConcept>? = null,
) {
  public fun toModel(): Device.Property =
    Device.Property(
      id = this@DevicePropertySurrogate.id,
      extension = this@DevicePropertySurrogate.extension ?: listOf(),
      modifierExtension = this@DevicePropertySurrogate.modifierExtension ?: listOf(),
      type = this@DevicePropertySurrogate.type,
      valueQuantity = this@DevicePropertySurrogate.valueQuantity ?: listOf(),
      valueCode = this@DevicePropertySurrogate.valueCode ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Device.Property): DevicePropertySurrogate =
      with(model) {
        DevicePropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          valueQuantity = this@with.valueQuantity.takeIf { it.isNotEmpty() },
          valueCode = this@with.valueCode.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DeviceSurrogate(
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
  public var definition: Reference? = null,
  public var udiCarrier: List<Device.UdiCarrier>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: List<CodeableConcept>? = null,
  public var distinctIdentifier: KotlinString? = null,
  public var _distinctIdentifier: Element? = null,
  public var manufacturer: KotlinString? = null,
  public var _manufacturer: Element? = null,
  public var manufactureDate: KotlinString? = null,
  public var _manufactureDate: Element? = null,
  public var expirationDate: KotlinString? = null,
  public var _expirationDate: Element? = null,
  public var lotNumber: KotlinString? = null,
  public var _lotNumber: Element? = null,
  public var serialNumber: KotlinString? = null,
  public var _serialNumber: Element? = null,
  public var deviceName: List<Device.DeviceName>? = null,
  public var modelNumber: KotlinString? = null,
  public var _modelNumber: Element? = null,
  public var partNumber: KotlinString? = null,
  public var _partNumber: Element? = null,
  public var type: CodeableConcept? = null,
  public var specialization: List<Device.Specialization>? = null,
  public var version: List<Device.Version>? = null,
  public var `property`: List<Device.Property>? = null,
  public var patient: Reference? = null,
  public var owner: Reference? = null,
  public var contact: List<ContactPoint>? = null,
  public var location: Reference? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var note: List<Annotation>? = null,
  public var safety: List<CodeableConcept>? = null,
  public var parent: Reference? = null,
) {
  public fun toModel(): Device =
    Device(
      id = this@DeviceSurrogate.id,
      meta = this@DeviceSurrogate.meta,
      implicitRules =
        Uri.of(this@DeviceSurrogate.implicitRules, this@DeviceSurrogate._implicitRules),
      language = Code.of(this@DeviceSurrogate.language, this@DeviceSurrogate._language),
      text = this@DeviceSurrogate.text,
      contained = this@DeviceSurrogate.contained ?: listOf(),
      extension = this@DeviceSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceSurrogate.modifierExtension ?: listOf(),
      identifier = this@DeviceSurrogate.identifier ?: listOf(),
      definition = this@DeviceSurrogate.definition,
      udiCarrier = this@DeviceSurrogate.udiCarrier ?: listOf(),
      status =
        this@DeviceSurrogate.status?.let {
          Enumeration.of(Device.FHIRDeviceStatus.fromCode(it), this@DeviceSurrogate._status)
        },
      statusReason = this@DeviceSurrogate.statusReason ?: listOf(),
      distinctIdentifier =
        R4String.of(
          this@DeviceSurrogate.distinctIdentifier,
          this@DeviceSurrogate._distinctIdentifier,
        ),
      manufacturer =
        R4String.of(this@DeviceSurrogate.manufacturer, this@DeviceSurrogate._manufacturer),
      manufactureDate =
        DateTime.of(
          FhirDateTime.fromString(this@DeviceSurrogate.manufactureDate),
          this@DeviceSurrogate._manufactureDate,
        ),
      expirationDate =
        DateTime.of(
          FhirDateTime.fromString(this@DeviceSurrogate.expirationDate),
          this@DeviceSurrogate._expirationDate,
        ),
      lotNumber = R4String.of(this@DeviceSurrogate.lotNumber, this@DeviceSurrogate._lotNumber),
      serialNumber =
        R4String.of(this@DeviceSurrogate.serialNumber, this@DeviceSurrogate._serialNumber),
      deviceName = this@DeviceSurrogate.deviceName ?: listOf(),
      modelNumber =
        R4String.of(this@DeviceSurrogate.modelNumber, this@DeviceSurrogate._modelNumber),
      partNumber = R4String.of(this@DeviceSurrogate.partNumber, this@DeviceSurrogate._partNumber),
      type = this@DeviceSurrogate.type,
      specialization = this@DeviceSurrogate.specialization ?: listOf(),
      version = this@DeviceSurrogate.version ?: listOf(),
      `property` = this@DeviceSurrogate.`property` ?: listOf(),
      patient = this@DeviceSurrogate.patient,
      owner = this@DeviceSurrogate.owner,
      contact = this@DeviceSurrogate.contact ?: listOf(),
      location = this@DeviceSurrogate.location,
      url = Uri.of(this@DeviceSurrogate.url, this@DeviceSurrogate._url),
      note = this@DeviceSurrogate.note ?: listOf(),
      safety = this@DeviceSurrogate.safety ?: listOf(),
      parent = this@DeviceSurrogate.parent,
    )

  public companion object {
    public fun fromModel(model: Device): DeviceSurrogate =
      with(model) {
        DeviceSurrogate(
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
          definition = this@with.definition,
          udiCarrier = this@with.udiCarrier.takeIf { it.isNotEmpty() },
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          statusReason = this@with.statusReason.takeIf { it.isNotEmpty() },
          distinctIdentifier = this@with.distinctIdentifier?.value,
          _distinctIdentifier = this@with.distinctIdentifier?.toElement(),
          manufacturer = this@with.manufacturer?.value,
          _manufacturer = this@with.manufacturer?.toElement(),
          manufactureDate = this@with.manufactureDate?.value?.toString(),
          _manufactureDate = this@with.manufactureDate?.toElement(),
          expirationDate = this@with.expirationDate?.value?.toString(),
          _expirationDate = this@with.expirationDate?.toElement(),
          lotNumber = this@with.lotNumber?.value,
          _lotNumber = this@with.lotNumber?.toElement(),
          serialNumber = this@with.serialNumber?.value,
          _serialNumber = this@with.serialNumber?.toElement(),
          deviceName = this@with.deviceName.takeIf { it.isNotEmpty() },
          modelNumber = this@with.modelNumber?.value,
          _modelNumber = this@with.modelNumber?.toElement(),
          partNumber = this@with.partNumber?.value,
          _partNumber = this@with.partNumber?.toElement(),
          type = this@with.type,
          specialization = this@with.specialization.takeIf { it.isNotEmpty() },
          version = this@with.version.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          patient = this@with.patient,
          owner = this@with.owner,
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          location = this@with.location,
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          safety = this@with.safety.takeIf { it.isNotEmpty() },
          parent = this@with.parent,
        )
      }
  }
}
