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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.serializers

import com.google.fhir.model.r5.DeviceDefinition
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.DeviceDefinitionChargeItemSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionClassificationSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionConformsToSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionCorrectiveActionSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionDeviceNameSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionGuidelineSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionHasPartSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionLinkSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionMaterialSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionPackagingDistributorSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionPackagingSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionPropertySurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionPropertyValueSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionRegulatoryIdentifierSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionUdiDeviceIdentifierSurrogate
import com.google.fhir.model.r5.surrogates.DeviceDefinitionVersionSurrogate
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

public object DeviceDefinitionUdiDeviceIdentifierSerializer :
  KSerializer<DeviceDefinition.UdiDeviceIdentifier> {
  internal val surrogateSerializer:
    KSerializer<DeviceDefinitionUdiDeviceIdentifierSurrogate> by lazy {
    DeviceDefinitionUdiDeviceIdentifierSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("UdiDeviceIdentifier", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.UdiDeviceIdentifier =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.UdiDeviceIdentifier) {
    surrogateSerializer.serialize(
      encoder,
      DeviceDefinitionUdiDeviceIdentifierSurrogate.fromModel(value),
    )
  }
}

public object DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer :
  KSerializer<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution> {
  internal val surrogateSerializer:
    KSerializer<DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate> by lazy {
    DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MarketDistribution", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): DeviceDefinition.UdiDeviceIdentifier.MarketDistribution =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: DeviceDefinition.UdiDeviceIdentifier.MarketDistribution,
  ) {
    surrogateSerializer.serialize(
      encoder,
      DeviceDefinitionUdiDeviceIdentifierMarketDistributionSurrogate.fromModel(value),
    )
  }
}

public object DeviceDefinitionRegulatoryIdentifierSerializer :
  KSerializer<DeviceDefinition.RegulatoryIdentifier> {
  internal val surrogateSerializer:
    KSerializer<DeviceDefinitionRegulatoryIdentifierSurrogate> by lazy {
    DeviceDefinitionRegulatoryIdentifierSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RegulatoryIdentifier", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.RegulatoryIdentifier =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.RegulatoryIdentifier) {
    surrogateSerializer.serialize(
      encoder,
      DeviceDefinitionRegulatoryIdentifierSurrogate.fromModel(value),
    )
  }
}

public object DeviceDefinitionDeviceNameSerializer : KSerializer<DeviceDefinition.DeviceName> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionDeviceNameSurrogate> by lazy {
    DeviceDefinitionDeviceNameSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DeviceName", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.DeviceName =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.DeviceName) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionDeviceNameSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionClassificationSerializer :
  KSerializer<DeviceDefinition.Classification> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionClassificationSurrogate> by lazy {
    DeviceDefinitionClassificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Classification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Classification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Classification) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionClassificationSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionConformsToSerializer : KSerializer<DeviceDefinition.ConformsTo> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionConformsToSurrogate> by lazy {
    DeviceDefinitionConformsToSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ConformsTo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.ConformsTo =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.ConformsTo) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionConformsToSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionHasPartSerializer : KSerializer<DeviceDefinition.HasPart> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionHasPartSurrogate> by lazy {
    DeviceDefinitionHasPartSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("HasPart", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.HasPart =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.HasPart) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionHasPartSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionPackagingSerializer : KSerializer<DeviceDefinition.Packaging> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionPackagingSurrogate> by lazy {
    DeviceDefinitionPackagingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Packaging", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Packaging =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Packaging) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionPackagingSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionPackagingDistributorSerializer :
  KSerializer<DeviceDefinition.Packaging.Distributor> {
  internal val surrogateSerializer:
    KSerializer<DeviceDefinitionPackagingDistributorSurrogate> by lazy {
    DeviceDefinitionPackagingDistributorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Distributor", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Packaging.Distributor =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Packaging.Distributor) {
    surrogateSerializer.serialize(
      encoder,
      DeviceDefinitionPackagingDistributorSurrogate.fromModel(value),
    )
  }
}

public object DeviceDefinitionVersionSerializer : KSerializer<DeviceDefinition.Version> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionVersionSurrogate> by lazy {
    DeviceDefinitionVersionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Version", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Version =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Version) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionVersionSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionPropertySerializer : KSerializer<DeviceDefinition.Property> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionPropertySurrogate> by lazy {
    DeviceDefinitionPropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Property {
    val jsonDecoder =
      decoder as? JsonDecoder ?: error("This serializer only supports JSON decoding")
    val oldJsonObject =
      JsonObject(
        jsonDecoder.decodeJsonElement().jsonObject.toMutableMap().apply { remove("resourceType") }
      )
    val unflattenedJsonObject = FhirJsonTransformer.unflatten(oldJsonObject, multiChoiceProperties)
    val surrogate =
      jsonDecoder.json.decodeFromJsonElement(surrogateSerializer, unflattenedJsonObject)
    return surrogate.toModel()
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Property) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = DeviceDefinitionPropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object DeviceDefinitionLinkSerializer : KSerializer<DeviceDefinition.Link> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionLinkSurrogate> by lazy {
    DeviceDefinitionLinkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Link", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Link =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Link) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionLinkSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionMaterialSerializer : KSerializer<DeviceDefinition.Material> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionMaterialSurrogate> by lazy {
    DeviceDefinitionMaterialSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Material", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Material =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Material) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionMaterialSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionGuidelineSerializer : KSerializer<DeviceDefinition.Guideline> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionGuidelineSurrogate> by lazy {
    DeviceDefinitionGuidelineSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Guideline", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Guideline =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Guideline) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionGuidelineSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionCorrectiveActionSerializer :
  KSerializer<DeviceDefinition.CorrectiveAction> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionCorrectiveActionSurrogate> by lazy {
    DeviceDefinitionCorrectiveActionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CorrectiveAction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.CorrectiveAction =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.CorrectiveAction) {
    surrogateSerializer.serialize(
      encoder,
      DeviceDefinitionCorrectiveActionSurrogate.fromModel(value),
    )
  }
}

public object DeviceDefinitionChargeItemSerializer : KSerializer<DeviceDefinition.ChargeItem> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionChargeItemSurrogate> by lazy {
    DeviceDefinitionChargeItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ChargeItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.ChargeItem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.ChargeItem) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionChargeItemSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionPropertyValueSerializer :
  KSerializer<DeviceDefinition.Property.Value> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionPropertyValueSurrogate> by lazy {
    DeviceDefinitionPropertyValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Property.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Property.Value) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionPropertyValueSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionSerializer : KSerializer<DeviceDefinition> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionSurrogate> by lazy {
    DeviceDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DeviceDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionSurrogate.fromModel(value))
  }
}
