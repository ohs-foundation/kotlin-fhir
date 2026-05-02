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

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ContactPoint
import com.google.fhir.model.r5.DeviceDefinition
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.ProductShelfLife
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.RelatedArtifact
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
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
  public var marketDistribution: List<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution>? =
    null,
) {
  public fun toModel(): DeviceDefinition.UdiDeviceIdentifier =
    DeviceDefinition.UdiDeviceIdentifier(
      id = this@DeviceDefinitionUdiDeviceIdentifierSurrogate.id,
      extension = this@DeviceDefinitionUdiDeviceIdentifierSurrogate.extension ?: listOf(),
      modifierExtension =
        this@DeviceDefinitionUdiDeviceIdentifierSurrogate.modifierExtension ?: listOf(),
      deviceIdentifier =
        R5String.of(
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
      marketDistribution =
        this@DeviceDefinitionUdiDeviceIdentifierSurrogate.marketDistribution ?: listOf(),
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
          marketDistribution = this@with.marketDistribution.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var marketPeriod: Period,
  public var subJurisdiction: KotlinString? = null,
  public var _subJurisdiction: Element? = null,
) {
  public fun toModel(): DeviceDefinition.UdiDeviceIdentifier.MarketDistribution =
    DeviceDefinition.UdiDeviceIdentifier.MarketDistribution(
      id = this@DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate.id,
      extension =
        this@DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate.modifierExtension
          ?: listOf(),
      marketPeriod =
        this@DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate.marketPeriod,
      subJurisdiction =
        Uri.of(
          this@DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate.subJurisdiction,
          this@DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate._subJurisdiction,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: DeviceDefinition.UdiDeviceIdentifier.MarketDistribution
    ): DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate =
      with(model) {
        DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          marketPeriod = this@with.marketPeriod,
          subJurisdiction = this@with.subJurisdiction.value,
          _subJurisdiction = this@with.subJurisdiction.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionRegulatoryIdentifierSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var deviceIdentifier: KotlinString? = null,
  public var _deviceIdentifier: Element? = null,
  public var issuer: KotlinString? = null,
  public var _issuer: Element? = null,
  public var jurisdiction: KotlinString? = null,
  public var _jurisdiction: Element? = null,
) {
  public fun toModel(): DeviceDefinition.RegulatoryIdentifier =
    DeviceDefinition.RegulatoryIdentifier(
      id = this@DeviceDefinitionRegulatoryIdentifierSurrogate.id,
      extension = this@DeviceDefinitionRegulatoryIdentifierSurrogate.extension ?: listOf(),
      modifierExtension =
        this@DeviceDefinitionRegulatoryIdentifierSurrogate.modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          DeviceDefinition.DeviceDefinitionRegulatoryIdentifierType.fromCode(
            this@DeviceDefinitionRegulatoryIdentifierSurrogate.type!!
          ),
          this@DeviceDefinitionRegulatoryIdentifierSurrogate._type,
        ),
      deviceIdentifier =
        R5String.of(
          this@DeviceDefinitionRegulatoryIdentifierSurrogate.deviceIdentifier,
          this@DeviceDefinitionRegulatoryIdentifierSurrogate._deviceIdentifier,
        )!!,
      issuer =
        Uri.of(
          this@DeviceDefinitionRegulatoryIdentifierSurrogate.issuer,
          this@DeviceDefinitionRegulatoryIdentifierSurrogate._issuer,
        )!!,
      jurisdiction =
        Uri.of(
          this@DeviceDefinitionRegulatoryIdentifierSurrogate.jurisdiction,
          this@DeviceDefinitionRegulatoryIdentifierSurrogate._jurisdiction,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: DeviceDefinition.RegulatoryIdentifier
    ): DeviceDefinitionRegulatoryIdentifierSurrogate =
      with(model) {
        DeviceDefinitionRegulatoryIdentifierSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
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
        R5String.of(
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
internal data class DeviceDefinitionClassificationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var justification: List<RelatedArtifact>? = null,
) {
  public fun toModel(): DeviceDefinition.Classification =
    DeviceDefinition.Classification(
      id = this@DeviceDefinitionClassificationSurrogate.id,
      extension = this@DeviceDefinitionClassificationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@DeviceDefinitionClassificationSurrogate.modifierExtension ?: listOf(),
      type = this@DeviceDefinitionClassificationSurrogate.type,
      justification = this@DeviceDefinitionClassificationSurrogate.justification ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: DeviceDefinition.Classification
    ): DeviceDefinitionClassificationSurrogate =
      with(model) {
        DeviceDefinitionClassificationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          justification = this@with.justification.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionConformsToSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept? = null,
  public var specification: CodeableConcept,
  public var version: List<KotlinString?>? = null,
  public var _version: List<Element?>? = null,
  public var source: List<RelatedArtifact>? = null,
) {
  public fun toModel(): DeviceDefinition.ConformsTo =
    DeviceDefinition.ConformsTo(
      id = this@DeviceDefinitionConformsToSurrogate.id,
      extension = this@DeviceDefinitionConformsToSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionConformsToSurrogate.modifierExtension ?: listOf(),
      category = this@DeviceDefinitionConformsToSurrogate.category,
      specification = this@DeviceDefinitionConformsToSurrogate.specification,
      version =
        if (
          this@DeviceDefinitionConformsToSurrogate.version == null &&
            this@DeviceDefinitionConformsToSurrogate._version == null
        ) {
          listOf()
        } else {
          (this@DeviceDefinitionConformsToSurrogate.version
              ?: List(this@DeviceDefinitionConformsToSurrogate._version!!.size) { null })
            .zip(
              this@DeviceDefinitionConformsToSurrogate._version
                ?: List(this@DeviceDefinitionConformsToSurrogate.version!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      source = this@DeviceDefinitionConformsToSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.ConformsTo): DeviceDefinitionConformsToSurrogate =
      with(model) {
        DeviceDefinitionConformsToSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          specification = this@with.specification,
          version =
            this@with.version.map { it.value }.toList().takeUnless { it.all { it == null } },
          _version =
            this@with.version
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionHasPartSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var reference: Reference,
  public var count: Int? = null,
  public var _count: Element? = null,
) {
  public fun toModel(): DeviceDefinition.HasPart =
    DeviceDefinition.HasPart(
      id = this@DeviceDefinitionHasPartSurrogate.id,
      extension = this@DeviceDefinitionHasPartSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionHasPartSurrogate.modifierExtension ?: listOf(),
      reference = this@DeviceDefinitionHasPartSurrogate.reference,
      count =
        Integer.of(
          this@DeviceDefinitionHasPartSurrogate.count,
          this@DeviceDefinitionHasPartSurrogate._count,
        ),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.HasPart): DeviceDefinitionHasPartSurrogate =
      with(model) {
        DeviceDefinitionHasPartSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          reference = this@with.reference,
          count = this@with.count?.value,
          _count = this@with.count?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionPackagingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier? = null,
  public var type: CodeableConcept? = null,
  public var count: Int? = null,
  public var _count: Element? = null,
  public var distributor: List<DeviceDefinition.Packaging.Distributor>? = null,
  public var udiDeviceIdentifier: List<DeviceDefinition.UdiDeviceIdentifier>? = null,
  public var packaging: List<DeviceDefinition.Packaging>? = null,
) {
  public fun toModel(): DeviceDefinition.Packaging =
    DeviceDefinition.Packaging(
      id = this@DeviceDefinitionPackagingSurrogate.id,
      extension = this@DeviceDefinitionPackagingSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionPackagingSurrogate.modifierExtension ?: listOf(),
      identifier = this@DeviceDefinitionPackagingSurrogate.identifier,
      type = this@DeviceDefinitionPackagingSurrogate.type,
      count =
        Integer.of(
          this@DeviceDefinitionPackagingSurrogate.count,
          this@DeviceDefinitionPackagingSurrogate._count,
        ),
      distributor = this@DeviceDefinitionPackagingSurrogate.distributor ?: listOf(),
      udiDeviceIdentifier = this@DeviceDefinitionPackagingSurrogate.udiDeviceIdentifier ?: listOf(),
      packaging = this@DeviceDefinitionPackagingSurrogate.packaging ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.Packaging): DeviceDefinitionPackagingSurrogate =
      with(model) {
        DeviceDefinitionPackagingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier,
          type = this@with.type,
          count = this@with.count?.value,
          _count = this@with.count?.toElement(),
          distributor = this@with.distributor.takeIf { it.isNotEmpty() },
          udiDeviceIdentifier = this@with.udiDeviceIdentifier.takeIf { it.isNotEmpty() },
          packaging = this@with.packaging.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionPackagingDistributorSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var organizationReference: List<Reference>? = null,
) {
  public fun toModel(): DeviceDefinition.Packaging.Distributor =
    DeviceDefinition.Packaging.Distributor(
      id = this@DeviceDefinitionPackagingDistributorSurrogate.id,
      extension = this@DeviceDefinitionPackagingDistributorSurrogate.extension ?: listOf(),
      modifierExtension =
        this@DeviceDefinitionPackagingDistributorSurrogate.modifierExtension ?: listOf(),
      name =
        R5String.of(
          this@DeviceDefinitionPackagingDistributorSurrogate.name,
          this@DeviceDefinitionPackagingDistributorSurrogate._name,
        ),
      organizationReference =
        this@DeviceDefinitionPackagingDistributorSurrogate.organizationReference ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: DeviceDefinition.Packaging.Distributor
    ): DeviceDefinitionPackagingDistributorSurrogate =
      with(model) {
        DeviceDefinitionPackagingDistributorSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          organizationReference = this@with.organizationReference.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionVersionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var component: Identifier? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): DeviceDefinition.Version =
    DeviceDefinition.Version(
      id = this@DeviceDefinitionVersionSurrogate.id,
      extension = this@DeviceDefinitionVersionSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionVersionSurrogate.modifierExtension ?: listOf(),
      type = this@DeviceDefinitionVersionSurrogate.type,
      component = this@DeviceDefinitionVersionSurrogate.component,
      `value` =
        R5String.of(
          this@DeviceDefinitionVersionSurrogate.`value`,
          this@DeviceDefinitionVersionSurrogate._value,
        )!!,
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.Version): DeviceDefinitionVersionSurrogate =
      with(model) {
        DeviceDefinitionVersionSurrogate(
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
internal data class DeviceDefinitionPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: DeviceDefinition.Property.Value,
) {
  public fun toModel(): DeviceDefinition.Property =
    DeviceDefinition.Property(
      id = this@DeviceDefinitionPropertySurrogate.id,
      extension = this@DeviceDefinitionPropertySurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionPropertySurrogate.modifierExtension ?: listOf(),
      type = this@DeviceDefinitionPropertySurrogate.type,
      `value` = this@DeviceDefinitionPropertySurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.Property): DeviceDefinitionPropertySurrogate =
      with(model) {
        DeviceDefinitionPropertySurrogate(
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
internal data class DeviceDefinitionLinkSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var relation: Coding,
  public var relatedDevice: CodeableReference,
) {
  public fun toModel(): DeviceDefinition.Link =
    DeviceDefinition.Link(
      id = this@DeviceDefinitionLinkSurrogate.id,
      extension = this@DeviceDefinitionLinkSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionLinkSurrogate.modifierExtension ?: listOf(),
      relation = this@DeviceDefinitionLinkSurrogate.relation,
      relatedDevice = this@DeviceDefinitionLinkSurrogate.relatedDevice,
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.Link): DeviceDefinitionLinkSurrogate =
      with(model) {
        DeviceDefinitionLinkSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          relation = this@with.relation,
          relatedDevice = this@with.relatedDevice,
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
        R5Boolean.of(
          this@DeviceDefinitionMaterialSurrogate.alternate,
          this@DeviceDefinitionMaterialSurrogate._alternate,
        ),
      allergenicIndicator =
        R5Boolean.of(
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
internal data class DeviceDefinitionGuidelineSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var useContext: List<UsageContext>? = null,
  public var usageInstruction: KotlinString? = null,
  public var _usageInstruction: Element? = null,
  public var relatedArtifact: List<RelatedArtifact>? = null,
  public var indication: List<CodeableConcept>? = null,
  public var contraindication: List<CodeableConcept>? = null,
  public var warning: List<CodeableConcept>? = null,
  public var intendedUse: KotlinString? = null,
  public var _intendedUse: Element? = null,
) {
  public fun toModel(): DeviceDefinition.Guideline =
    DeviceDefinition.Guideline(
      id = this@DeviceDefinitionGuidelineSurrogate.id,
      extension = this@DeviceDefinitionGuidelineSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionGuidelineSurrogate.modifierExtension ?: listOf(),
      useContext = this@DeviceDefinitionGuidelineSurrogate.useContext ?: listOf(),
      usageInstruction =
        Markdown.of(
          this@DeviceDefinitionGuidelineSurrogate.usageInstruction,
          this@DeviceDefinitionGuidelineSurrogate._usageInstruction,
        ),
      relatedArtifact = this@DeviceDefinitionGuidelineSurrogate.relatedArtifact ?: listOf(),
      indication = this@DeviceDefinitionGuidelineSurrogate.indication ?: listOf(),
      contraindication = this@DeviceDefinitionGuidelineSurrogate.contraindication ?: listOf(),
      warning = this@DeviceDefinitionGuidelineSurrogate.warning ?: listOf(),
      intendedUse =
        R5String.of(
          this@DeviceDefinitionGuidelineSurrogate.intendedUse,
          this@DeviceDefinitionGuidelineSurrogate._intendedUse,
        ),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.Guideline): DeviceDefinitionGuidelineSurrogate =
      with(model) {
        DeviceDefinitionGuidelineSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          usageInstruction = this@with.usageInstruction?.value,
          _usageInstruction = this@with.usageInstruction?.toElement(),
          relatedArtifact = this@with.relatedArtifact.takeIf { it.isNotEmpty() },
          indication = this@with.indication.takeIf { it.isNotEmpty() },
          contraindication = this@with.contraindication.takeIf { it.isNotEmpty() },
          warning = this@with.warning.takeIf { it.isNotEmpty() },
          intendedUse = this@with.intendedUse?.value,
          _intendedUse = this@with.intendedUse?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionCorrectiveActionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var recall: KotlinBoolean? = null,
  public var _recall: Element? = null,
  public var scope: KotlinString? = null,
  public var _scope: Element? = null,
  public var period: Period,
) {
  public fun toModel(): DeviceDefinition.CorrectiveAction =
    DeviceDefinition.CorrectiveAction(
      id = this@DeviceDefinitionCorrectiveActionSurrogate.id,
      extension = this@DeviceDefinitionCorrectiveActionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@DeviceDefinitionCorrectiveActionSurrogate.modifierExtension ?: listOf(),
      recall =
        R5Boolean.of(
          this@DeviceDefinitionCorrectiveActionSurrogate.recall,
          this@DeviceDefinitionCorrectiveActionSurrogate._recall,
        )!!,
      scope =
        this@DeviceDefinitionCorrectiveActionSurrogate.scope?.let {
          Enumeration.of(
            DeviceDefinition.DeviceCorrectiveActionScope.fromCode(it),
            this@DeviceDefinitionCorrectiveActionSurrogate._scope,
          )
        },
      period = this@DeviceDefinitionCorrectiveActionSurrogate.period,
    )

  public companion object {
    public fun fromModel(
      model: DeviceDefinition.CorrectiveAction
    ): DeviceDefinitionCorrectiveActionSurrogate =
      with(model) {
        DeviceDefinitionCorrectiveActionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          recall = this@with.recall.value,
          _recall = this@with.recall.toElement(),
          scope = this@with.scope?.value?.getCode(),
          _scope = this@with.scope?.toElement(),
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionChargeItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var chargeItemCode: CodeableReference,
  public var count: Quantity,
  public var effectivePeriod: Period? = null,
  public var useContext: List<UsageContext>? = null,
) {
  public fun toModel(): DeviceDefinition.ChargeItem =
    DeviceDefinition.ChargeItem(
      id = this@DeviceDefinitionChargeItemSurrogate.id,
      extension = this@DeviceDefinitionChargeItemSurrogate.extension ?: listOf(),
      modifierExtension = this@DeviceDefinitionChargeItemSurrogate.modifierExtension ?: listOf(),
      chargeItemCode = this@DeviceDefinitionChargeItemSurrogate.chargeItemCode,
      count = this@DeviceDefinitionChargeItemSurrogate.count,
      effectivePeriod = this@DeviceDefinitionChargeItemSurrogate.effectivePeriod,
      useContext = this@DeviceDefinitionChargeItemSurrogate.useContext ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DeviceDefinition.ChargeItem): DeviceDefinitionChargeItemSurrogate =
      with(model) {
        DeviceDefinitionChargeItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          chargeItemCode = this@with.chargeItemCode,
          count = this@with.count,
          effectivePeriod = this@with.effectivePeriod,
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DeviceDefinitionPropertyValueSurrogate(
  public var valueQuantity: Quantity? = null,
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueRange: Range? = null,
  public var valueAttachment: Attachment? = null,
) {
  public fun toModel(): DeviceDefinition.Property.Value =
    DeviceDefinition.Property.Value.from(
      this@DeviceDefinitionPropertyValueSurrogate.valueQuantity,
      this@DeviceDefinitionPropertyValueSurrogate.valueCodeableConcept,
      R5String.of(
        this@DeviceDefinitionPropertyValueSurrogate.valueString,
        this@DeviceDefinitionPropertyValueSurrogate._valueString,
      ),
      R5Boolean.of(
        this@DeviceDefinitionPropertyValueSurrogate.valueBoolean,
        this@DeviceDefinitionPropertyValueSurrogate._valueBoolean,
      ),
      Integer.of(
        this@DeviceDefinitionPropertyValueSurrogate.valueInteger,
        this@DeviceDefinitionPropertyValueSurrogate._valueInteger,
      ),
      this@DeviceDefinitionPropertyValueSurrogate.valueRange,
      this@DeviceDefinitionPropertyValueSurrogate.valueAttachment,
    )!!

  public companion object {
    public fun fromModel(
      model: DeviceDefinition.Property.Value
    ): DeviceDefinitionPropertyValueSurrogate =
      with(model) {
        DeviceDefinitionPropertyValueSurrogate(
          valueQuantity = this@with.asQuantity()?.value,
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueRange = this@with.asRange()?.value,
          valueAttachment = this@with.asAttachment()?.value,
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
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var udiDeviceIdentifier: List<DeviceDefinition.UdiDeviceIdentifier>? = null,
  public var regulatoryIdentifier: List<DeviceDefinition.RegulatoryIdentifier>? = null,
  public var partNumber: KotlinString? = null,
  public var _partNumber: Element? = null,
  public var manufacturer: Reference? = null,
  public var deviceName: List<DeviceDefinition.DeviceName>? = null,
  public var modelNumber: KotlinString? = null,
  public var _modelNumber: Element? = null,
  public var classification: List<DeviceDefinition.Classification>? = null,
  public var conformsTo: List<DeviceDefinition.ConformsTo>? = null,
  public var hasPart: List<DeviceDefinition.HasPart>? = null,
  public var packaging: List<DeviceDefinition.Packaging>? = null,
  public var version: List<DeviceDefinition.Version>? = null,
  public var safety: List<CodeableConcept>? = null,
  public var shelfLifeStorage: List<ProductShelfLife>? = null,
  public var languageCode: List<CodeableConcept>? = null,
  public var `property`: List<DeviceDefinition.Property>? = null,
  public var owner: Reference? = null,
  public var contact: List<ContactPoint>? = null,
  public var link: List<DeviceDefinition.Link>? = null,
  public var note: List<Annotation>? = null,
  public var material: List<DeviceDefinition.Material>? = null,
  public var productionIdentifierInUDI: List<KotlinString?>? = null,
  public var _productionIdentifierInUDI: List<Element?>? = null,
  public var guideline: DeviceDefinition.Guideline? = null,
  public var correctiveAction: DeviceDefinition.CorrectiveAction? = null,
  public var chargeItem: List<DeviceDefinition.ChargeItem>? = null,
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
      description =
        Markdown.of(
          this@DeviceDefinitionSurrogate.description,
          this@DeviceDefinitionSurrogate._description,
        ),
      identifier = this@DeviceDefinitionSurrogate.identifier ?: listOf(),
      udiDeviceIdentifier = this@DeviceDefinitionSurrogate.udiDeviceIdentifier ?: listOf(),
      regulatoryIdentifier = this@DeviceDefinitionSurrogate.regulatoryIdentifier ?: listOf(),
      partNumber =
        R5String.of(
          this@DeviceDefinitionSurrogate.partNumber,
          this@DeviceDefinitionSurrogate._partNumber,
        ),
      manufacturer = this@DeviceDefinitionSurrogate.manufacturer,
      deviceName = this@DeviceDefinitionSurrogate.deviceName ?: listOf(),
      modelNumber =
        R5String.of(
          this@DeviceDefinitionSurrogate.modelNumber,
          this@DeviceDefinitionSurrogate._modelNumber,
        ),
      classification = this@DeviceDefinitionSurrogate.classification ?: listOf(),
      conformsTo = this@DeviceDefinitionSurrogate.conformsTo ?: listOf(),
      hasPart = this@DeviceDefinitionSurrogate.hasPart ?: listOf(),
      packaging = this@DeviceDefinitionSurrogate.packaging ?: listOf(),
      version = this@DeviceDefinitionSurrogate.version ?: listOf(),
      safety = this@DeviceDefinitionSurrogate.safety ?: listOf(),
      shelfLifeStorage = this@DeviceDefinitionSurrogate.shelfLifeStorage ?: listOf(),
      languageCode = this@DeviceDefinitionSurrogate.languageCode ?: listOf(),
      `property` = this@DeviceDefinitionSurrogate.`property` ?: listOf(),
      owner = this@DeviceDefinitionSurrogate.owner,
      contact = this@DeviceDefinitionSurrogate.contact ?: listOf(),
      link = this@DeviceDefinitionSurrogate.link ?: listOf(),
      note = this@DeviceDefinitionSurrogate.note ?: listOf(),
      material = this@DeviceDefinitionSurrogate.material ?: listOf(),
      productionIdentifierInUDI =
        if (
          this@DeviceDefinitionSurrogate.productionIdentifierInUDI == null &&
            this@DeviceDefinitionSurrogate._productionIdentifierInUDI == null
        ) {
          listOf()
        } else {
          (this@DeviceDefinitionSurrogate.productionIdentifierInUDI
              ?: List(this@DeviceDefinitionSurrogate._productionIdentifierInUDI!!.size) { null })
            .zip(
              this@DeviceDefinitionSurrogate._productionIdentifierInUDI
                ?: List(this@DeviceDefinitionSurrogate.productionIdentifierInUDI!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { DeviceDefinition.DeviceProductionIdentifierInUDI.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      guideline = this@DeviceDefinitionSurrogate.guideline,
      correctiveAction = this@DeviceDefinitionSurrogate.correctiveAction,
      chargeItem = this@DeviceDefinitionSurrogate.chargeItem ?: listOf(),
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
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          udiDeviceIdentifier = this@with.udiDeviceIdentifier.takeIf { it.isNotEmpty() },
          regulatoryIdentifier = this@with.regulatoryIdentifier.takeIf { it.isNotEmpty() },
          partNumber = this@with.partNumber?.value,
          _partNumber = this@with.partNumber?.toElement(),
          manufacturer = this@with.manufacturer,
          deviceName = this@with.deviceName.takeIf { it.isNotEmpty() },
          modelNumber = this@with.modelNumber?.value,
          _modelNumber = this@with.modelNumber?.toElement(),
          classification = this@with.classification.takeIf { it.isNotEmpty() },
          conformsTo = this@with.conformsTo.takeIf { it.isNotEmpty() },
          hasPart = this@with.hasPart.takeIf { it.isNotEmpty() },
          packaging = this@with.packaging.takeIf { it.isNotEmpty() },
          version = this@with.version.takeIf { it.isNotEmpty() },
          safety = this@with.safety.takeIf { it.isNotEmpty() },
          shelfLifeStorage = this@with.shelfLifeStorage.takeIf { it.isNotEmpty() },
          languageCode = this@with.languageCode.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          owner = this@with.owner,
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          link = this@with.link.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          material = this@with.material.takeIf { it.isNotEmpty() },
          productionIdentifierInUDI =
            this@with.productionIdentifierInUDI
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _productionIdentifierInUDI =
            this@with.productionIdentifierInUDI
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          guideline = this@with.guideline,
          correctiveAction = this@with.correctiveAction,
          chargeItem = this@with.chargeItem.takeIf { it.isNotEmpty() },
        )
      }
  }
}
