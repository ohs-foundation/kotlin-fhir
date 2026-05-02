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
import com.google.fhir.model.r5.Transport
import com.google.fhir.model.r5.surrogates.TransportInputSurrogate
import com.google.fhir.model.r5.surrogates.TransportInputValueSurrogate
import com.google.fhir.model.r5.surrogates.TransportOutputSurrogate
import com.google.fhir.model.r5.surrogates.TransportOutputValueSurrogate
import com.google.fhir.model.r5.surrogates.TransportRestrictionSurrogate
import com.google.fhir.model.r5.surrogates.TransportSurrogate
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

public object TransportRestrictionSerializer : KSerializer<Transport.Restriction> {
  internal val surrogateSerializer: KSerializer<TransportRestrictionSurrogate> by lazy {
    TransportRestrictionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Restriction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Transport.Restriction =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Transport.Restriction) {
    surrogateSerializer.serialize(encoder, TransportRestrictionSurrogate.fromModel(value))
  }
}

public object TransportInputSerializer : KSerializer<Transport.Input> {
  internal val surrogateSerializer: KSerializer<TransportInputSurrogate> by lazy {
    TransportInputSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Input", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Transport.Input {
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

  override fun serialize(encoder: Encoder, `value`: Transport.Input) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TransportInputSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object TransportOutputSerializer : KSerializer<Transport.Output> {
  internal val surrogateSerializer: KSerializer<TransportOutputSurrogate> by lazy {
    TransportOutputSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Output", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Transport.Output {
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

  override fun serialize(encoder: Encoder, `value`: Transport.Output) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TransportOutputSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object TransportInputValueSerializer : KSerializer<Transport.Input.Value> {
  internal val surrogateSerializer: KSerializer<TransportInputValueSurrogate> by lazy {
    TransportInputValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Transport.Input.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Transport.Input.Value) {
    surrogateSerializer.serialize(encoder, TransportInputValueSurrogate.fromModel(value))
  }
}

public object TransportOutputValueSerializer : KSerializer<Transport.Output.Value> {
  internal val surrogateSerializer: KSerializer<TransportOutputValueSurrogate> by lazy {
    TransportOutputValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Transport.Output.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Transport.Output.Value) {
    surrogateSerializer.serialize(encoder, TransportOutputValueSurrogate.fromModel(value))
  }
}

public object TransportSerializer : KSerializer<Transport> {
  internal val surrogateSerializer: KSerializer<TransportSurrogate> by lazy {
    TransportSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Transport", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Transport =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Transport) {
    surrogateSerializer.serialize(encoder, TransportSurrogate.fromModel(value))
  }
}
