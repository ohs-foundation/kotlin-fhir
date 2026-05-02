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

import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.InventoryItem
import com.google.fhir.model.r5.surrogates.InventoryItemAssociationSurrogate
import com.google.fhir.model.r5.surrogates.InventoryItemCharacteristicSurrogate
import com.google.fhir.model.r5.surrogates.InventoryItemCharacteristicValueSurrogate
import com.google.fhir.model.r5.surrogates.InventoryItemDescriptionSurrogate
import com.google.fhir.model.r5.surrogates.InventoryItemInstanceSurrogate
import com.google.fhir.model.r5.surrogates.InventoryItemNameSurrogate
import com.google.fhir.model.r5.surrogates.InventoryItemResponsibleOrganizationSurrogate
import com.google.fhir.model.r5.surrogates.InventoryItemSurrogate
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

public object InventoryItemNameSerializer : KSerializer<InventoryItem.Name> {
  internal val surrogateSerializer: KSerializer<InventoryItemNameSurrogate> by lazy {
    InventoryItemNameSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Name", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryItem.Name =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Name) {
    surrogateSerializer.serialize(encoder, InventoryItemNameSurrogate.fromModel(value))
  }
}

public object InventoryItemResponsibleOrganizationSerializer :
  KSerializer<InventoryItem.ResponsibleOrganization> {
  internal val surrogateSerializer:
    KSerializer<InventoryItemResponsibleOrganizationSurrogate> by lazy {
    InventoryItemResponsibleOrganizationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ResponsibleOrganization", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryItem.ResponsibleOrganization =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryItem.ResponsibleOrganization) {
    surrogateSerializer.serialize(
      encoder,
      InventoryItemResponsibleOrganizationSurrogate.fromModel(value),
    )
  }
}

public object InventoryItemDescriptionSerializer : KSerializer<InventoryItem.Description> {
  internal val surrogateSerializer: KSerializer<InventoryItemDescriptionSurrogate> by lazy {
    InventoryItemDescriptionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Description", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryItem.Description =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Description) {
    surrogateSerializer.serialize(encoder, InventoryItemDescriptionSurrogate.fromModel(value))
  }
}

public object InventoryItemAssociationSerializer : KSerializer<InventoryItem.Association> {
  internal val surrogateSerializer: KSerializer<InventoryItemAssociationSurrogate> by lazy {
    InventoryItemAssociationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Association", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryItem.Association =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Association) {
    surrogateSerializer.serialize(encoder, InventoryItemAssociationSurrogate.fromModel(value))
  }
}

public object InventoryItemCharacteristicSerializer : KSerializer<InventoryItem.Characteristic> {
  internal val surrogateSerializer: KSerializer<InventoryItemCharacteristicSurrogate> by lazy {
    InventoryItemCharacteristicSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Characteristic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryItem.Characteristic {
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

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Characteristic) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = InventoryItemCharacteristicSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object InventoryItemInstanceSerializer : KSerializer<InventoryItem.Instance> {
  internal val surrogateSerializer: KSerializer<InventoryItemInstanceSurrogate> by lazy {
    InventoryItemInstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Instance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryItem.Instance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Instance) {
    surrogateSerializer.serialize(encoder, InventoryItemInstanceSurrogate.fromModel(value))
  }
}

public object InventoryItemCharacteristicValueSerializer :
  KSerializer<InventoryItem.Characteristic.Value> {
  internal val surrogateSerializer: KSerializer<InventoryItemCharacteristicValueSurrogate> by lazy {
    InventoryItemCharacteristicValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryItem.Characteristic.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Characteristic.Value) {
    surrogateSerializer.serialize(
      encoder,
      InventoryItemCharacteristicValueSurrogate.fromModel(value),
    )
  }
}

public object InventoryItemSerializer : KSerializer<InventoryItem> {
  internal val surrogateSerializer: KSerializer<InventoryItemSurrogate> by lazy {
    InventoryItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("InventoryItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryItem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryItem) {
    surrogateSerializer.serialize(encoder, InventoryItemSurrogate.fromModel(value))
  }
}
