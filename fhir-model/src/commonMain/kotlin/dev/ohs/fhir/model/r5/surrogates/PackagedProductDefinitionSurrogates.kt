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
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.MarketingStatus
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.PackagedProductDefinition
import com.google.fhir.model.r5.ProductShelfLife
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class PackagedProductDefinitionLegalStatusOfSupplySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var jurisdiction: CodeableConcept? = null,
) {
  public fun toModel(): PackagedProductDefinition.LegalStatusOfSupply =
    PackagedProductDefinition.LegalStatusOfSupply(
      id = this@PackagedProductDefinitionLegalStatusOfSupplySurrogate.id,
      extension = this@PackagedProductDefinitionLegalStatusOfSupplySurrogate.extension ?: listOf(),
      modifierExtension =
        this@PackagedProductDefinitionLegalStatusOfSupplySurrogate.modifierExtension ?: listOf(),
      code = this@PackagedProductDefinitionLegalStatusOfSupplySurrogate.code,
      jurisdiction = this@PackagedProductDefinitionLegalStatusOfSupplySurrogate.jurisdiction,
    )

  public companion object {
    public fun fromModel(
      model: PackagedProductDefinition.LegalStatusOfSupply
    ): PackagedProductDefinitionLegalStatusOfSupplySurrogate =
      with(model) {
        PackagedProductDefinitionLegalStatusOfSupplySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          jurisdiction = this@with.jurisdiction,
        )
      }
  }
}

@Serializable
internal data class PackagedProductDefinitionPackagingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var type: CodeableConcept? = null,
  public var componentPart: KotlinBoolean? = null,
  public var _componentPart: Element? = null,
  public var quantity: Int? = null,
  public var _quantity: Element? = null,
  public var material: List<CodeableConcept>? = null,
  public var alternateMaterial: List<CodeableConcept>? = null,
  public var shelfLifeStorage: List<ProductShelfLife>? = null,
  public var manufacturer: List<Reference>? = null,
  public var `property`: List<PackagedProductDefinition.Packaging.Property>? = null,
  public var containedItem: List<PackagedProductDefinition.Packaging.ContainedItem>? = null,
  public var packaging: List<PackagedProductDefinition.Packaging>? = null,
) {
  public fun toModel(): PackagedProductDefinition.Packaging =
    PackagedProductDefinition.Packaging(
      id = this@PackagedProductDefinitionPackagingSurrogate.id,
      extension = this@PackagedProductDefinitionPackagingSurrogate.extension ?: listOf(),
      modifierExtension =
        this@PackagedProductDefinitionPackagingSurrogate.modifierExtension ?: listOf(),
      identifier = this@PackagedProductDefinitionPackagingSurrogate.identifier ?: listOf(),
      type = this@PackagedProductDefinitionPackagingSurrogate.type,
      componentPart =
        R5Boolean.of(
          this@PackagedProductDefinitionPackagingSurrogate.componentPart,
          this@PackagedProductDefinitionPackagingSurrogate._componentPart,
        ),
      quantity =
        Integer.of(
          this@PackagedProductDefinitionPackagingSurrogate.quantity,
          this@PackagedProductDefinitionPackagingSurrogate._quantity,
        ),
      material = this@PackagedProductDefinitionPackagingSurrogate.material ?: listOf(),
      alternateMaterial =
        this@PackagedProductDefinitionPackagingSurrogate.alternateMaterial ?: listOf(),
      shelfLifeStorage =
        this@PackagedProductDefinitionPackagingSurrogate.shelfLifeStorage ?: listOf(),
      manufacturer = this@PackagedProductDefinitionPackagingSurrogate.manufacturer ?: listOf(),
      `property` = this@PackagedProductDefinitionPackagingSurrogate.`property` ?: listOf(),
      containedItem = this@PackagedProductDefinitionPackagingSurrogate.containedItem ?: listOf(),
      packaging = this@PackagedProductDefinitionPackagingSurrogate.packaging ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: PackagedProductDefinition.Packaging
    ): PackagedProductDefinitionPackagingSurrogate =
      with(model) {
        PackagedProductDefinitionPackagingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          type = this@with.type,
          componentPart = this@with.componentPart?.value,
          _componentPart = this@with.componentPart?.toElement(),
          quantity = this@with.quantity?.value,
          _quantity = this@with.quantity?.toElement(),
          material = this@with.material.takeIf { it.isNotEmpty() },
          alternateMaterial = this@with.alternateMaterial.takeIf { it.isNotEmpty() },
          shelfLifeStorage = this@with.shelfLifeStorage.takeIf { it.isNotEmpty() },
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          containedItem = this@with.containedItem.takeIf { it.isNotEmpty() },
          packaging = this@with.packaging.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class PackagedProductDefinitionPackagingPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: PackagedProductDefinition.Packaging.Property.Value? = null,
) {
  public fun toModel(): PackagedProductDefinition.Packaging.Property =
    PackagedProductDefinition.Packaging.Property(
      id = this@PackagedProductDefinitionPackagingPropertySurrogate.id,
      extension = this@PackagedProductDefinitionPackagingPropertySurrogate.extension ?: listOf(),
      modifierExtension =
        this@PackagedProductDefinitionPackagingPropertySurrogate.modifierExtension ?: listOf(),
      type = this@PackagedProductDefinitionPackagingPropertySurrogate.type,
      `value` = this@PackagedProductDefinitionPackagingPropertySurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: PackagedProductDefinition.Packaging.Property
    ): PackagedProductDefinitionPackagingPropertySurrogate =
      with(model) {
        PackagedProductDefinitionPackagingPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class PackagedProductDefinitionPackagingContainedItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: CodeableReference,
  public var amount: Quantity? = null,
) {
  public fun toModel(): PackagedProductDefinition.Packaging.ContainedItem =
    PackagedProductDefinition.Packaging.ContainedItem(
      id = this@PackagedProductDefinitionPackagingContainedItemSurrogate.id,
      extension =
        this@PackagedProductDefinitionPackagingContainedItemSurrogate.extension ?: listOf(),
      modifierExtension =
        this@PackagedProductDefinitionPackagingContainedItemSurrogate.modifierExtension ?: listOf(),
      item = this@PackagedProductDefinitionPackagingContainedItemSurrogate.item,
      amount = this@PackagedProductDefinitionPackagingContainedItemSurrogate.amount,
    )

  public companion object {
    public fun fromModel(
      model: PackagedProductDefinition.Packaging.ContainedItem
    ): PackagedProductDefinitionPackagingContainedItemSurrogate =
      with(model) {
        PackagedProductDefinitionPackagingContainedItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
          amount = this@with.amount,
        )
      }
  }
}

@Serializable
internal data class PackagedProductDefinitionPackagingPropertyValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueAttachment: Attachment? = null,
) {
  public fun toModel(): PackagedProductDefinition.Packaging.Property.Value =
    PackagedProductDefinition.Packaging.Property.Value.from(
      this@PackagedProductDefinitionPackagingPropertyValueSurrogate.valueCodeableConcept,
      this@PackagedProductDefinitionPackagingPropertyValueSurrogate.valueQuantity,
      Date.of(
        FhirDate.fromString(
          this@PackagedProductDefinitionPackagingPropertyValueSurrogate.valueDate
        ),
        this@PackagedProductDefinitionPackagingPropertyValueSurrogate._valueDate,
      ),
      R5Boolean.of(
        this@PackagedProductDefinitionPackagingPropertyValueSurrogate.valueBoolean,
        this@PackagedProductDefinitionPackagingPropertyValueSurrogate._valueBoolean,
      ),
      this@PackagedProductDefinitionPackagingPropertyValueSurrogate.valueAttachment,
    )!!

  public companion object {
    public fun fromModel(
      model: PackagedProductDefinition.Packaging.Property.Value
    ): PackagedProductDefinitionPackagingPropertyValueSurrogate =
      with(model) {
        PackagedProductDefinitionPackagingPropertyValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
        )
      }
  }
}

@Serializable
internal data class PackagedProductDefinitionSurrogate(
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
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var type: CodeableConcept? = null,
  public var packageFor: List<Reference>? = null,
  public var status: CodeableConcept? = null,
  public var statusDate: KotlinString? = null,
  public var _statusDate: Element? = null,
  public var containedItemQuantity: List<Quantity>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var legalStatusOfSupply: List<PackagedProductDefinition.LegalStatusOfSupply>? = null,
  public var marketingStatus: List<MarketingStatus>? = null,
  public var copackagedIndicator: KotlinBoolean? = null,
  public var _copackagedIndicator: Element? = null,
  public var manufacturer: List<Reference>? = null,
  public var attachedDocument: List<Reference>? = null,
  public var packaging: PackagedProductDefinition.Packaging? = null,
  public var characteristic: List<PackagedProductDefinition.Packaging.Property>? = null,
) {
  public fun toModel(): PackagedProductDefinition =
    PackagedProductDefinition(
      id = this@PackagedProductDefinitionSurrogate.id,
      meta = this@PackagedProductDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@PackagedProductDefinitionSurrogate.implicitRules,
          this@PackagedProductDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@PackagedProductDefinitionSurrogate.language,
          this@PackagedProductDefinitionSurrogate._language,
        ),
      text = this@PackagedProductDefinitionSurrogate.text,
      contained = this@PackagedProductDefinitionSurrogate.contained ?: listOf(),
      extension = this@PackagedProductDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@PackagedProductDefinitionSurrogate.modifierExtension ?: listOf(),
      identifier = this@PackagedProductDefinitionSurrogate.identifier ?: listOf(),
      name =
        R5String.of(
          this@PackagedProductDefinitionSurrogate.name,
          this@PackagedProductDefinitionSurrogate._name,
        ),
      type = this@PackagedProductDefinitionSurrogate.type,
      packageFor = this@PackagedProductDefinitionSurrogate.packageFor ?: listOf(),
      status = this@PackagedProductDefinitionSurrogate.status,
      statusDate =
        DateTime.of(
          FhirDateTime.fromString(this@PackagedProductDefinitionSurrogate.statusDate),
          this@PackagedProductDefinitionSurrogate._statusDate,
        ),
      containedItemQuantity =
        this@PackagedProductDefinitionSurrogate.containedItemQuantity ?: listOf(),
      description =
        Markdown.of(
          this@PackagedProductDefinitionSurrogate.description,
          this@PackagedProductDefinitionSurrogate._description,
        ),
      legalStatusOfSupply = this@PackagedProductDefinitionSurrogate.legalStatusOfSupply ?: listOf(),
      marketingStatus = this@PackagedProductDefinitionSurrogate.marketingStatus ?: listOf(),
      copackagedIndicator =
        R5Boolean.of(
          this@PackagedProductDefinitionSurrogate.copackagedIndicator,
          this@PackagedProductDefinitionSurrogate._copackagedIndicator,
        ),
      manufacturer = this@PackagedProductDefinitionSurrogate.manufacturer ?: listOf(),
      attachedDocument = this@PackagedProductDefinitionSurrogate.attachedDocument ?: listOf(),
      packaging = this@PackagedProductDefinitionSurrogate.packaging,
      characteristic = this@PackagedProductDefinitionSurrogate.characteristic ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: PackagedProductDefinition): PackagedProductDefinitionSurrogate =
      with(model) {
        PackagedProductDefinitionSurrogate(
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
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          type = this@with.type,
          packageFor = this@with.packageFor.takeIf { it.isNotEmpty() },
          status = this@with.status,
          statusDate = this@with.statusDate?.value?.toString(),
          _statusDate = this@with.statusDate?.toElement(),
          containedItemQuantity = this@with.containedItemQuantity.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          legalStatusOfSupply = this@with.legalStatusOfSupply.takeIf { it.isNotEmpty() },
          marketingStatus = this@with.marketingStatus.takeIf { it.isNotEmpty() },
          copackagedIndicator = this@with.copackagedIndicator?.value,
          _copackagedIndicator = this@with.copackagedIndicator?.toElement(),
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
          attachedDocument = this@with.attachedDocument.takeIf { it.isNotEmpty() },
          packaging = this@with.packaging,
          characteristic = this@with.characteristic.takeIf { it.isNotEmpty() },
        )
      }
  }
}
