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
import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.ContactPoint
import com.google.fhir.model.r4.DeviceDefinition
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.ProdCharacteristic
import com.google.fhir.model.r4.ProductShelfLife
import com.google.fhir.model.r4.Quantity
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
internal data class DeviceDefinitionUdiDeviceIdentifierSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var deviceIdentifier: KotlinString? = null,
  public var _deviceIdentifier: Element? = null,
  public var issuer: KotlinString? = null,
  public var _issuer: Element? = null,
  public var jurisdiction: KotlinString? = null,
  public var _jurisdiction: Element? = null,
) {
  public fun toModel(): DeviceDefinition.UdiDeviceIdentifier =
    DeviceDefinition.UdiDeviceIdentifier(
      id = this@DeviceDefinitionUdiDeviceIdentifierSurrogate.id,
      extension = this@DeviceDefinitionUdiDeviceIdentifierSurrogate.extension ?: listOf(),
      modifierExtension =
        this@DeviceDefinitionUdiDeviceIdentifierSurrogate.modifierExtension ?: listOf(),
      deviceIdentifier =
        R4String.of(
          this@DeviceDefinitionUdiDeviceIdentifierSurrogate.deviceIdentifier,
          this@DeviceDefinitionUdiDeviceIdentifierSurrogate._deviceIdentifier,
        )!!,
      issuer =
        Uri.of(
          this@DeviceDefinitionUdiDeviceIdentifierSurrogate.issuer,
          this@DeviceDefinitionUdiDeviceIdentifierSurrogate._issuer,
        )!!,
      jurisdiction =
        Uri.of(
          this@DeviceDefinitionUdiDeviceIdentifierSurrogate.jurisdiction,
          this@DeviceDefinitionUdiDeviceIdentifierSurrogate._jurisdiction,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: DeviceDefinition.UdiDeviceIdentifier
    ): DeviceDefinitionUdiDeviceIdentifierSurrogate =
      with(model) {
        DeviceDefinitionUdiDeviceIdentifierSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          deviceIdentifier = this@with.deviceIdentifier.value,
          _deviceIdentifier = this@with.deviceIdentifier.toElement(),
          issuer = this@with.issuer.value,
          _issuer = this@with.issuer.toElement(),
          jurisdiction = this@with.jurisdiction.value,
          _jurisdiction = this@with.jurisdiction.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionDeviceNameSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
) {
  public fun toModel(): DeviceDefinition.DeviceName =
    DeviceDefinition.DeviceName(
      id = this@DeviceDefinitionDeviceNameSurrogate.id,
      extension = this@DeviceDefinitionDeviceNameSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionDeviceNameSurrogate.modifierExtension ?: listOf(),
      name =
        R4String.of(
          this@DeviceDefinitionDeviceNameSurrogate.name,
          this@DeviceDefinitionDeviceNameSurrogate._name,
        )!!,
      type =
        Enumeration.of(
          DeviceDefinition.DeviceNameType.fromCode(this@DeviceDefinitionDeviceNameSurrogate.type!!),
          this@DeviceDefinitionDeviceNameSurrogate._type,
        ),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.DeviceName): DeviceDefinitionDeviceNameSurrogate =
      with(model) {
        DeviceDefinitionDeviceNameSurrogate(
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
internal data class DeviceDefinitionSpecializationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var systemType: KotlinString? = null,
  public var _systemType: Element? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
) {
  public fun toModel(): DeviceDefinition.Specialization =
    DeviceDefinition.Specialization(
      id = this@DeviceDefinitionSpecializationSurrogate.id,
      extension = this@DeviceDefinitionSpecializationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@DeviceDefinitionSpecializationSurrogate.modifierExtension ?: listOf(),
      systemType =
        R4String.of(
          this@DeviceDefinitionSpecializationSurrogate.systemType,
          this@DeviceDefinitionSpecializationSurrogate._systemType,
        )!!,
      version =
        R4String.of(
          this@DeviceDefinitionSpecializationSurrogate.version,
          this@DeviceDefinitionSpecializationSurrogate._version,
        ),
    )

  public companion object {
    public fun fromModel(
      model: DeviceDefinition.Specialization
    ): DeviceDefinitionSpecializationSurrogate =
      with(model) {
        DeviceDefinitionSpecializationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          systemType = this@with.systemType.value,
          _systemType = this@with.systemType.toElement(),
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionCapabilitySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var description: List<CodeableConcept>? = null,
) {
  public fun toModel(): DeviceDefinition.Capability =
    DeviceDefinition.Capability(
      id = this@DeviceDefinitionCapabilitySurrogate.id,
      extension = this@DeviceDefinitionCapabilitySurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionCapabilitySurrogate.modifierExtension ?: listOf(),
      type = this@DeviceDefinitionCapabilitySurrogate.type,
      description = this@DeviceDefinitionCapabilitySurrogate.description ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.Capability): DeviceDefinitionCapabilitySurrogate =
      with(model) {
        DeviceDefinitionCapabilitySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          description = this@with.description.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var valueQuantity: List<Quantity>? = null,
  public var valueCode: List<CodeableConcept>? = null,
) {
  public fun toModel(): DeviceDefinition.Property =
    DeviceDefinition.Property(
      id = this@DeviceDefinitionPropertySurrogate.id,
      extension = this@DeviceDefinitionPropertySurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionPropertySurrogate.modifierExtension ?: listOf(),
      type = this@DeviceDefinitionPropertySurrogate.type,
      valueQuantity = this@DeviceDefinitionPropertySurrogate.valueQuantity ?: listOf(),
      valueCode = this@DeviceDefinitionPropertySurrogate.valueCode ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.Property): DeviceDefinitionPropertySurrogate =
      with(model) {
        DeviceDefinitionPropertySurrogate(
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
internal data class DeviceDefinitionMaterialSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var substance: CodeableConcept,
  public var alternate: KotlinBoolean? = null,
  public var _alternate: Element? = null,
  public var allergenicIndicator: KotlinBoolean? = null,
  public var _allergenicIndicator: Element? = null,
) {
  public fun toModel(): DeviceDefinition.Material =
    DeviceDefinition.Material(
      id = this@DeviceDefinitionMaterialSurrogate.id,
      extension = this@DeviceDefinitionMaterialSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionMaterialSurrogate.modifierExtension ?: listOf(),
      substance = this@DeviceDefinitionMaterialSurrogate.substance,
      alternate =
        R4Boolean.of(
          this@DeviceDefinitionMaterialSurrogate.alternate,
          this@DeviceDefinitionMaterialSurrogate._alternate,
        ),
      allergenicIndicator =
        R4Boolean.of(
          this@DeviceDefinitionMaterialSurrogate.allergenicIndicator,
          this@DeviceDefinitionMaterialSurrogate._allergenicIndicator,
        ),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.Material): DeviceDefinitionMaterialSurrogate =
      with(model) {
        DeviceDefinitionMaterialSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          substance = this@with.substance,
          alternate = this@with.alternate?.value,
          _alternate = this@with.alternate?.toElement(),
          allergenicIndicator = this@with.allergenicIndicator?.value,
          _allergenicIndicator = this@with.allergenicIndicator?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionManufacturerSurrogate(
  public var manufacturerString: KotlinString? = null,
  public var _manufacturerString: Element? = null,
  public var manufacturerReference: Reference? = null,
) {
  public fun toModel(): DeviceDefinition.Manufacturer =
    DeviceDefinition.Manufacturer.from(
      R4String.of(
        this@DeviceDefinitionManufacturerSurrogate.manufacturerString,
        this@DeviceDefinitionManufacturerSurrogate._manufacturerString,
      ),
      this@DeviceDefinitionManufacturerSurrogate.manufacturerReference,
    )!!

  public companion object {
    public fun fromModel(
      model: DeviceDefinition.Manufacturer
    ): DeviceDefinitionManufacturerSurrogate =
      with(model) {
        DeviceDefinitionManufacturerSurrogate(
          manufacturerString = this@with.asString()?.value?.value,
          _manufacturerString = this@with.asString()?.value?.toElement(),
          manufacturerReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionSurrogate(
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
  public var udiDeviceIdentifier: List<DeviceDefinition.UdiDeviceIdentifier>? = null,
  public var manufacturer: DeviceDefinition.Manufacturer? = null,
  public var deviceName: List<DeviceDefinition.DeviceName>? = null,
  public var modelNumber: KotlinString? = null,
  public var _modelNumber: Element? = null,
  public var type: CodeableConcept? = null,
  public var specialization: List<DeviceDefinition.Specialization>? = null,
  public var version: List<KotlinString?>? = null,
  public var _version: List<Element?>? = null,
  public var safety: List<CodeableConcept>? = null,
  public var shelfLifeStorage: List<ProductShelfLife>? = null,
  public var physicalCharacteristics: ProdCharacteristic? = null,
  public var languageCode: List<CodeableConcept>? = null,
  public var capability: List<DeviceDefinition.Capability>? = null,
  public var `property`: List<DeviceDefinition.Property>? = null,
  public var owner: Reference? = null,
  public var contact: List<ContactPoint>? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var onlineInformation: KotlinString? = null,
  public var _onlineInformation: Element? = null,
  public var note: List<Annotation>? = null,
  public var quantity: Quantity? = null,
  public var parentDevice: Reference? = null,
  public var material: List<DeviceDefinition.Material>? = null,
) {
  public fun toModel(): DeviceDefinition =
    DeviceDefinition(
      id = this@DeviceDefinitionSurrogate.id,
      meta = this@DeviceDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@DeviceDefinitionSurrogate.implicitRules,
          this@DeviceDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(this@DeviceDefinitionSurrogate.language, this@DeviceDefinitionSurrogate._language),
      text = this@DeviceDefinitionSurrogate.text,
      contained = this@DeviceDefinitionSurrogate.contained ?: listOf(),
      extension = this@DeviceDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionSurrogate.modifierExtension ?: listOf(),
      identifier = this@DeviceDefinitionSurrogate.identifier ?: listOf(),
      udiDeviceIdentifier = this@DeviceDefinitionSurrogate.udiDeviceIdentifier ?: listOf(),
      manufacturer = this@DeviceDefinitionSurrogate.manufacturer,
      deviceName = this@DeviceDefinitionSurrogate.deviceName ?: listOf(),
      modelNumber =
        R4String.of(
          this@DeviceDefinitionSurrogate.modelNumber,
          this@DeviceDefinitionSurrogate._modelNumber,
        ),
      type = this@DeviceDefinitionSurrogate.type,
      specialization = this@DeviceDefinitionSurrogate.specialization ?: listOf(),
      version =
        if (
          this@DeviceDefinitionSurrogate.version == null &&
            this@DeviceDefinitionSurrogate._version == null
        ) {
          listOf()
        } else {
          (this@DeviceDefinitionSurrogate.version
              ?: List(this@DeviceDefinitionSurrogate._version!!.size) { null })
            .zip(
              this@DeviceDefinitionSurrogate._version
                ?: List(this@DeviceDefinitionSurrogate.version!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      safety = this@DeviceDefinitionSurrogate.safety ?: listOf(),
      shelfLifeStorage = this@DeviceDefinitionSurrogate.shelfLifeStorage ?: listOf(),
      physicalCharacteristics = this@DeviceDefinitionSurrogate.physicalCharacteristics,
      languageCode = this@DeviceDefinitionSurrogate.languageCode ?: listOf(),
      capability = this@DeviceDefinitionSurrogate.capability ?: listOf(),
      `property` = this@DeviceDefinitionSurrogate.`property` ?: listOf(),
      owner = this@DeviceDefinitionSurrogate.owner,
      contact = this@DeviceDefinitionSurrogate.contact ?: listOf(),
      url = Uri.of(this@DeviceDefinitionSurrogate.url, this@DeviceDefinitionSurrogate._url),
      onlineInformation =
        Uri.of(
          this@DeviceDefinitionSurrogate.onlineInformation,
          this@DeviceDefinitionSurrogate._onlineInformation,
        ),
      note = this@DeviceDefinitionSurrogate.note ?: listOf(),
      quantity = this@DeviceDefinitionSurrogate.quantity,
      parentDevice = this@DeviceDefinitionSurrogate.parentDevice,
      material = this@DeviceDefinitionSurrogate.material ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition): DeviceDefinitionSurrogate =
      with(model) {
        DeviceDefinitionSurrogate(
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
          udiDeviceIdentifier = this@with.udiDeviceIdentifier.takeIf { it.isNotEmpty() },
          manufacturer = this@with.manufacturer,
          deviceName = this@with.deviceName.takeIf { it.isNotEmpty() },
          modelNumber = this@with.modelNumber?.value,
          _modelNumber = this@with.modelNumber?.toElement(),
          type = this@with.type,
          specialization = this@with.specialization.takeIf { it.isNotEmpty() },
          version =
            this@with.version.map { it.value }.toList().takeUnless { it.all { it == null } },
          _version =
            this@with.version
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          safety = this@with.safety.takeIf { it.isNotEmpty() },
          shelfLifeStorage = this@with.shelfLifeStorage.takeIf { it.isNotEmpty() },
          physicalCharacteristics = this@with.physicalCharacteristics,
          languageCode = this@with.languageCode.takeIf { it.isNotEmpty() },
          capability = this@with.capability.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          owner = this@with.owner,
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          onlineInformation = this@with.onlineInformation?.value,
          _onlineInformation = this@with.onlineInformation?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          parentDevice = this@with.parentDevice,
          material = this@with.material.takeIf { it.isNotEmpty() },
        )
      }
  }
}
