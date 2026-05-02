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

package com.google.fhir.model.r4b.serializers

import com.google.fhir.model.r4b.ActivityDefinition
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.ActivityDefinitionDynamicValueSurrogate
import com.google.fhir.model.r4b.surrogates.ActivityDefinitionParticipantSurrogate
import com.google.fhir.model.r4b.surrogates.ActivityDefinitionProductSurrogate
import com.google.fhir.model.r4b.surrogates.ActivityDefinitionSubjectSurrogate
import com.google.fhir.model.r4b.surrogates.ActivityDefinitionSurrogate
import com.google.fhir.model.r4b.surrogates.ActivityDefinitionTimingSurrogate
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

public object ActivityDefinitionParticipantSerializer :
  KSerializer<ActivityDefinition.Participant> {
  internal val surrogateSerializer: KSerializer<ActivityDefinitionParticipantSurrogate> by lazy {
    ActivityDefinitionParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Participant) {
    surrogateSerializer.serialize(encoder, ActivityDefinitionParticipantSurrogate.fromModel(value))
  }
}

public object ActivityDefinitionDynamicValueSerializer :
  KSerializer<ActivityDefinition.DynamicValue> {
  internal val surrogateSerializer: KSerializer<ActivityDefinitionDynamicValueSurrogate> by lazy {
    ActivityDefinitionDynamicValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DynamicValue", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition.DynamicValue =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.DynamicValue) {
    surrogateSerializer.serialize(encoder, ActivityDefinitionDynamicValueSurrogate.fromModel(value))
  }
}

public object ActivityDefinitionSubjectSerializer : KSerializer<ActivityDefinition.Subject> {
  internal val surrogateSerializer: KSerializer<ActivityDefinitionSubjectSurrogate> by lazy {
    ActivityDefinitionSubjectSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subject", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition.Subject =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Subject) {
    surrogateSerializer.serialize(encoder, ActivityDefinitionSubjectSurrogate.fromModel(value))
  }
}

public object ActivityDefinitionTimingSerializer : KSerializer<ActivityDefinition.Timing> {
  internal val surrogateSerializer: KSerializer<ActivityDefinitionTimingSurrogate> by lazy {
    ActivityDefinitionTimingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Timing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition.Timing =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Timing) {
    surrogateSerializer.serialize(encoder, ActivityDefinitionTimingSurrogate.fromModel(value))
  }
}

public object ActivityDefinitionProductSerializer : KSerializer<ActivityDefinition.Product> {
  internal val surrogateSerializer: KSerializer<ActivityDefinitionProductSurrogate> by lazy {
    ActivityDefinitionProductSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Product", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition.Product =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Product) {
    surrogateSerializer.serialize(encoder, ActivityDefinitionProductSurrogate.fromModel(value))
  }
}

public object ActivityDefinitionSerializer : KSerializer<ActivityDefinition> {
  internal val surrogateSerializer: KSerializer<ActivityDefinitionSurrogate> by lazy {
    ActivityDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("subject", "timing", "product")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ActivityDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition {
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

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ActivityDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
