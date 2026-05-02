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

package com.google.fhir.model.r4.serializers

import com.google.fhir.model.r4.DeviceRequest
import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.surrogates.DeviceRequestCodeSurrogate
import com.google.fhir.model.r4.surrogates.DeviceRequestOccurrenceSurrogate
import com.google.fhir.model.r4.surrogates.DeviceRequestParameterSurrogate
import com.google.fhir.model.r4.surrogates.DeviceRequestParameterValueSurrogate
import com.google.fhir.model.r4.surrogates.DeviceRequestSurrogate
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

public object DeviceRequestParameterSerializer : KSerializer<DeviceRequest.Parameter> {
  internal val surrogateSerializer: KSerializer<DeviceRequestParameterSurrogate> by lazy {
    DeviceRequestParameterSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Parameter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceRequest.Parameter {
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

  override fun serialize(encoder: Encoder, `value`: DeviceRequest.Parameter) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = DeviceRequestParameterSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object DeviceRequestCodeSerializer : KSerializer<DeviceRequest.Code> {
  internal val surrogateSerializer: KSerializer<DeviceRequestCodeSurrogate> by lazy {
    DeviceRequestCodeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Code", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceRequest.Code =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceRequest.Code) {
    surrogateSerializer.serialize(encoder, DeviceRequestCodeSurrogate.fromModel(value))
  }
}

public object DeviceRequestParameterValueSerializer : KSerializer<DeviceRequest.Parameter.Value> {
  internal val surrogateSerializer: KSerializer<DeviceRequestParameterValueSurrogate> by lazy {
    DeviceRequestParameterValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceRequest.Parameter.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceRequest.Parameter.Value) {
    surrogateSerializer.serialize(encoder, DeviceRequestParameterValueSurrogate.fromModel(value))
  }
}

public object DeviceRequestOccurrenceSerializer : KSerializer<DeviceRequest.Occurrence> {
  internal val surrogateSerializer: KSerializer<DeviceRequestOccurrenceSurrogate> by lazy {
    DeviceRequestOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceRequest.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceRequest.Occurrence) {
    surrogateSerializer.serialize(encoder, DeviceRequestOccurrenceSurrogate.fromModel(value))
  }
}

public object DeviceRequestSerializer : KSerializer<DeviceRequest> {
  internal val surrogateSerializer: KSerializer<DeviceRequestSurrogate> by lazy {
    DeviceRequestSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("code", "occurrence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DeviceRequest", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceRequest {
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

  override fun serialize(encoder: Encoder, `value`: DeviceRequest) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = DeviceRequestSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
