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

import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.MarketingStatus
import com.google.fhir.model.r4.MedicinalProductPackaged
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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MedicinalProductPackagedBatchIdentifierSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var outerPackaging: Identifier,
  public var immediatePackaging: Identifier? = null,
) {
  public fun toModel(): MedicinalProductPackaged.BatchIdentifier =
    MedicinalProductPackaged.BatchIdentifier(
      id = this@MedicinalProductPackagedBatchIdentifierSurrogate.id,
      extension = this@MedicinalProductPackagedBatchIdentifierSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductPackagedBatchIdentifierSurrogate.modifierExtension ?: listOf(),
      outerPackaging = this@MedicinalProductPackagedBatchIdentifierSurrogate.outerPackaging,
      immediatePackaging = this@MedicinalProductPackagedBatchIdentifierSurrogate.immediatePackaging,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductPackaged.BatchIdentifier
    ): MedicinalProductPackagedBatchIdentifierSurrogate =
      with(model) {
        MedicinalProductPackagedBatchIdentifierSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          outerPackaging = this@with.outerPackaging,
          immediatePackaging = this@with.immediatePackaging,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductPackagedPackageItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var type: CodeableConcept,
  public var quantity: Quantity,
  public var material: List<CodeableConcept>? = null,
  public var alternateMaterial: List<CodeableConcept>? = null,
  public var device: List<Reference>? = null,
  public var manufacturedItem: List<Reference>? = null,
  public var packageItem: List<MedicinalProductPackaged.PackageItem>? = null,
  public var physicalCharacteristics: ProdCharacteristic? = null,
  public var otherCharacteristics: List<CodeableConcept>? = null,
  public var shelfLifeStorage: List<ProductShelfLife>? = null,
  public var manufacturer: List<Reference>? = null,
) {
  public fun toModel(): MedicinalProductPackaged.PackageItem =
    MedicinalProductPackaged.PackageItem(
      id = this@MedicinalProductPackagedPackageItemSurrogate.id,
      extension = this@MedicinalProductPackagedPackageItemSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductPackagedPackageItemSurrogate.modifierExtension ?: listOf(),
      identifier = this@MedicinalProductPackagedPackageItemSurrogate.identifier ?: listOf(),
      type = this@MedicinalProductPackagedPackageItemSurrogate.type,
      quantity = this@MedicinalProductPackagedPackageItemSurrogate.quantity,
      material = this@MedicinalProductPackagedPackageItemSurrogate.material ?: listOf(),
      alternateMaterial =
        this@MedicinalProductPackagedPackageItemSurrogate.alternateMaterial ?: listOf(),
      device = this@MedicinalProductPackagedPackageItemSurrogate.device ?: listOf(),
      manufacturedItem =
        this@MedicinalProductPackagedPackageItemSurrogate.manufacturedItem ?: listOf(),
      packageItem = this@MedicinalProductPackagedPackageItemSurrogate.packageItem ?: listOf(),
      physicalCharacteristics =
        this@MedicinalProductPackagedPackageItemSurrogate.physicalCharacteristics,
      otherCharacteristics =
        this@MedicinalProductPackagedPackageItemSurrogate.otherCharacteristics ?: listOf(),
      shelfLifeStorage =
        this@MedicinalProductPackagedPackageItemSurrogate.shelfLifeStorage ?: listOf(),
      manufacturer = this@MedicinalProductPackagedPackageItemSurrogate.manufacturer ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductPackaged.PackageItem
    ): MedicinalProductPackagedPackageItemSurrogate =
      with(model) {
        MedicinalProductPackagedPackageItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          type = this@with.type,
          quantity = this@with.quantity,
          material = this@with.material.takeIf { it.isNotEmpty() },
          alternateMaterial = this@with.alternateMaterial.takeIf { it.isNotEmpty() },
          device = this@with.device.takeIf { it.isNotEmpty() },
          manufacturedItem = this@with.manufacturedItem.takeIf { it.isNotEmpty() },
          packageItem = this@with.packageItem.takeIf { it.isNotEmpty() },
          physicalCharacteristics = this@with.physicalCharacteristics,
          otherCharacteristics = this@with.otherCharacteristics.takeIf { it.isNotEmpty() },
          shelfLifeStorage = this@with.shelfLifeStorage.takeIf { it.isNotEmpty() },
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicinalProductPackagedSurrogate(
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
  public var subject: List<Reference>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var legalStatusOfSupply: CodeableConcept? = null,
  public var marketingStatus: List<MarketingStatus>? = null,
  public var marketingAuthorization: Reference? = null,
  public var manufacturer: List<Reference>? = null,
  public var batchIdentifier: List<MedicinalProductPackaged.BatchIdentifier>? = null,
  public var packageItem: List<MedicinalProductPackaged.PackageItem>? = null,
) {
  public fun toModel(): MedicinalProductPackaged =
    MedicinalProductPackaged(
      id = this@MedicinalProductPackagedSurrogate.id,
      meta = this@MedicinalProductPackagedSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicinalProductPackagedSurrogate.implicitRules,
          this@MedicinalProductPackagedSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MedicinalProductPackagedSurrogate.language,
          this@MedicinalProductPackagedSurrogate._language,
        ),
      text = this@MedicinalProductPackagedSurrogate.text,
      contained = this@MedicinalProductPackagedSurrogate.contained ?: listOf(),
      extension = this@MedicinalProductPackagedSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicinalProductPackagedSurrogate.modifierExtension ?: listOf(),
      identifier = this@MedicinalProductPackagedSurrogate.identifier ?: listOf(),
      subject = this@MedicinalProductPackagedSurrogate.subject ?: listOf(),
      description =
        R4String.of(
          this@MedicinalProductPackagedSurrogate.description,
          this@MedicinalProductPackagedSurrogate._description,
        ),
      legalStatusOfSupply = this@MedicinalProductPackagedSurrogate.legalStatusOfSupply,
      marketingStatus = this@MedicinalProductPackagedSurrogate.marketingStatus ?: listOf(),
      marketingAuthorization = this@MedicinalProductPackagedSurrogate.marketingAuthorization,
      manufacturer = this@MedicinalProductPackagedSurrogate.manufacturer ?: listOf(),
      batchIdentifier = this@MedicinalProductPackagedSurrogate.batchIdentifier ?: listOf(),
      packageItem = this@MedicinalProductPackagedSurrogate.packageItem ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MedicinalProductPackaged): MedicinalProductPackagedSurrogate =
      with(model) {
        MedicinalProductPackagedSurrogate(
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
          subject = this@with.subject.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          legalStatusOfSupply = this@with.legalStatusOfSupply,
          marketingStatus = this@with.marketingStatus.takeIf { it.isNotEmpty() },
          marketingAuthorization = this@with.marketingAuthorization,
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
          batchIdentifier = this@with.batchIdentifier.takeIf { it.isNotEmpty() },
          packageItem = this@with.packageItem.takeIf { it.isNotEmpty() },
        )
      }
  }
}
