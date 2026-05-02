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
import com.google.fhir.model.r5.Task
import com.google.fhir.model.r5.surrogates.TaskInputSurrogate
import com.google.fhir.model.r5.surrogates.TaskInputValueSurrogate
import com.google.fhir.model.r5.surrogates.TaskOutputSurrogate
import com.google.fhir.model.r5.surrogates.TaskOutputValueSurrogate
import com.google.fhir.model.r5.surrogates.TaskPerformerSurrogate
import com.google.fhir.model.r5.surrogates.TaskRestrictionSurrogate
import com.google.fhir.model.r5.surrogates.TaskSurrogate
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

public object TaskPerformerSerializer : KSerializer<Task.Performer> {
  internal val surrogateSerializer: KSerializer<TaskPerformerSurrogate> by lazy {
    TaskPerformerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Performer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Task.Performer) {
    surrogateSerializer.serialize(encoder, TaskPerformerSurrogate.fromModel(value))
  }
}

public object TaskRestrictionSerializer : KSerializer<Task.Restriction> {
  internal val surrogateSerializer: KSerializer<TaskRestrictionSurrogate> by lazy {
    TaskRestrictionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Restriction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Restriction =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Task.Restriction) {
    surrogateSerializer.serialize(encoder, TaskRestrictionSurrogate.fromModel(value))
  }
}

public object TaskInputSerializer : KSerializer<Task.Input> {
  internal val surrogateSerializer: KSerializer<TaskInputSurrogate> by lazy {
    TaskInputSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Input", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Input {
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

  override fun serialize(encoder: Encoder, `value`: Task.Input) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TaskInputSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object TaskOutputSerializer : KSerializer<Task.Output> {
  internal val surrogateSerializer: KSerializer<TaskOutputSurrogate> by lazy {
    TaskOutputSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Output", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Output {
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

  override fun serialize(encoder: Encoder, `value`: Task.Output) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TaskOutputSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object TaskInputValueSerializer : KSerializer<Task.Input.Value> {
  internal val surrogateSerializer: KSerializer<TaskInputValueSurrogate> by lazy {
    TaskInputValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Input.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Task.Input.Value) {
    surrogateSerializer.serialize(encoder, TaskInputValueSurrogate.fromModel(value))
  }
}

public object TaskOutputValueSerializer : KSerializer<Task.Output.Value> {
  internal val surrogateSerializer: KSerializer<TaskOutputValueSurrogate> by lazy {
    TaskOutputValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task.Output.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Task.Output.Value) {
    surrogateSerializer.serialize(encoder, TaskOutputValueSurrogate.fromModel(value))
  }
}

public object TaskSerializer : KSerializer<Task> {
  internal val surrogateSerializer: KSerializer<TaskSurrogate> by lazy {
    TaskSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Task", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Task =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Task) {
    surrogateSerializer.serialize(encoder, TaskSurrogate.fromModel(value))
  }
}
