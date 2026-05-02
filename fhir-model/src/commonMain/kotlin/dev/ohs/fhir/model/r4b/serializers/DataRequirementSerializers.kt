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

import com.google.fhir.model.r4b.DataRequirement
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.DataRequirementCodeFilterSurrogate
import com.google.fhir.model.r4b.surrogates.DataRequirementDateFilterSurrogate
import com.google.fhir.model.r4b.surrogates.DataRequirementDateFilterValueSurrogate
import com.google.fhir.model.r4b.surrogates.DataRequirementSortSurrogate
import com.google.fhir.model.r4b.surrogates.DataRequirementSubjectSurrogate
import com.google.fhir.model.r4b.surrogates.DataRequirementSurrogate
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

public object DataRequirementCodeFilterSerializer : KSerializer<DataRequirement.CodeFilter> {
  internal val surrogateSerializer: KSerializer<DataRequirementCodeFilterSurrogate> by lazy {
    DataRequirementCodeFilterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CodeFilter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DataRequirement.CodeFilter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DataRequirement.CodeFilter) {
    surrogateSerializer.serialize(encoder, DataRequirementCodeFilterSurrogate.fromModel(value))
  }
}

public object DataRequirementDateFilterSerializer : KSerializer<DataRequirement.DateFilter> {
  internal val surrogateSerializer: KSerializer<DataRequirementDateFilterSurrogate> by lazy {
    DataRequirementDateFilterSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DateFilter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DataRequirement.DateFilter {
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

  override fun serialize(encoder: Encoder, `value`: DataRequirement.DateFilter) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = DataRequirementDateFilterSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object DataRequirementSortSerializer : KSerializer<DataRequirement.Sort> {
  internal val surrogateSerializer: KSerializer<DataRequirementSortSurrogate> by lazy {
    DataRequirementSortSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Sort", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DataRequirement.Sort =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DataRequirement.Sort) {
    surrogateSerializer.serialize(encoder, DataRequirementSortSurrogate.fromModel(value))
  }
}

public object DataRequirementSubjectSerializer : KSerializer<DataRequirement.Subject> {
  internal val surrogateSerializer: KSerializer<DataRequirementSubjectSurrogate> by lazy {
    DataRequirementSubjectSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subject", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DataRequirement.Subject =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DataRequirement.Subject) {
    surrogateSerializer.serialize(encoder, DataRequirementSubjectSurrogate.fromModel(value))
  }
}

public object DataRequirementDateFilterValueSerializer :
  KSerializer<DataRequirement.DateFilter.Value> {
  internal val surrogateSerializer: KSerializer<DataRequirementDateFilterValueSurrogate> by lazy {
    DataRequirementDateFilterValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DataRequirement.DateFilter.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DataRequirement.DateFilter.Value) {
    surrogateSerializer.serialize(encoder, DataRequirementDateFilterValueSurrogate.fromModel(value))
  }
}

public object DataRequirementSerializer : KSerializer<DataRequirement> {
  internal val surrogateSerializer: KSerializer<DataRequirementSurrogate> by lazy {
    DataRequirementSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("subject")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DataRequirement", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DataRequirement {
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

  override fun serialize(encoder: Encoder, `value`: DataRequirement) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = DataRequirementSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
