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

import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.ValueSet
import com.google.fhir.model.r4.surrogates.ValueSetComposeIncludeConceptDesignationSurrogate
import com.google.fhir.model.r4.surrogates.ValueSetComposeIncludeConceptSurrogate
import com.google.fhir.model.r4.surrogates.ValueSetComposeIncludeFilterSurrogate
import com.google.fhir.model.r4.surrogates.ValueSetComposeIncludeSurrogate
import com.google.fhir.model.r4.surrogates.ValueSetComposeSurrogate
import com.google.fhir.model.r4.surrogates.ValueSetExpansionContainsSurrogate
import com.google.fhir.model.r4.surrogates.ValueSetExpansionParameterSurrogate
import com.google.fhir.model.r4.surrogates.ValueSetExpansionParameterValueSurrogate
import com.google.fhir.model.r4.surrogates.ValueSetExpansionSurrogate
import com.google.fhir.model.r4.surrogates.ValueSetSurrogate
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

public object ValueSetComposeSerializer : KSerializer<ValueSet.Compose> {
  internal val surrogateSerializer: KSerializer<ValueSetComposeSurrogate> by lazy {
    ValueSetComposeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Compose", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Compose =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose) {
    surrogateSerializer.serialize(encoder, ValueSetComposeSurrogate.fromModel(value))
  }
}

public object ValueSetComposeIncludeSerializer : KSerializer<ValueSet.Compose.Include> {
  internal val surrogateSerializer: KSerializer<ValueSetComposeIncludeSurrogate> by lazy {
    ValueSetComposeIncludeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Include", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include) {
    surrogateSerializer.serialize(encoder, ValueSetComposeIncludeSurrogate.fromModel(value))
  }
}

public object ValueSetComposeIncludeConceptSerializer :
  KSerializer<ValueSet.Compose.Include.Concept> {
  internal val surrogateSerializer: KSerializer<ValueSetComposeIncludeConceptSurrogate> by lazy {
    ValueSetComposeIncludeConceptSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Concept", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Concept =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept) {
    surrogateSerializer.serialize(encoder, ValueSetComposeIncludeConceptSurrogate.fromModel(value))
  }
}

public object ValueSetComposeIncludeConceptDesignationSerializer :
  KSerializer<ValueSet.Compose.Include.Concept.Designation> {
  internal val surrogateSerializer:
    KSerializer<ValueSetComposeIncludeConceptDesignationSurrogate> by lazy {
    ValueSetComposeIncludeConceptDesignationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Designation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Concept.Designation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Concept.Designation) {
    surrogateSerializer.serialize(
      encoder,
      ValueSetComposeIncludeConceptDesignationSurrogate.fromModel(value),
    )
  }
}

public object ValueSetComposeIncludeFilterSerializer :
  KSerializer<ValueSet.Compose.Include.Filter> {
  internal val surrogateSerializer: KSerializer<ValueSetComposeIncludeFilterSurrogate> by lazy {
    ValueSetComposeIncludeFilterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Filter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Compose.Include.Filter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Compose.Include.Filter) {
    surrogateSerializer.serialize(encoder, ValueSetComposeIncludeFilterSurrogate.fromModel(value))
  }
}

public object ValueSetExpansionSerializer : KSerializer<ValueSet.Expansion> {
  internal val surrogateSerializer: KSerializer<ValueSetExpansionSurrogate> by lazy {
    ValueSetExpansionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Expansion", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion) {
    surrogateSerializer.serialize(encoder, ValueSetExpansionSurrogate.fromModel(value))
  }
}

public object ValueSetExpansionParameterSerializer : KSerializer<ValueSet.Expansion.Parameter> {
  internal val surrogateSerializer: KSerializer<ValueSetExpansionParameterSurrogate> by lazy {
    ValueSetExpansionParameterSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Parameter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Parameter {
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

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Parameter) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ValueSetExpansionParameterSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ValueSetExpansionContainsSerializer : KSerializer<ValueSet.Expansion.Contains> {
  internal val surrogateSerializer: KSerializer<ValueSetExpansionContainsSurrogate> by lazy {
    ValueSetExpansionContainsSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Contains", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Contains) {
    surrogateSerializer.serialize(encoder, ValueSetExpansionContainsSurrogate.fromModel(value))
  }
}

public object ValueSetExpansionParameterValueSerializer :
  KSerializer<ValueSet.Expansion.Parameter.Value> {
  internal val surrogateSerializer: KSerializer<ValueSetExpansionParameterValueSurrogate> by lazy {
    ValueSetExpansionParameterValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Parameter.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Parameter.Value) {
    surrogateSerializer.serialize(
      encoder,
      ValueSetExpansionParameterValueSurrogate.fromModel(value),
    )
  }
}

public object ValueSetSerializer : KSerializer<ValueSet> {
  internal val surrogateSerializer: KSerializer<ValueSetSurrogate> by lazy {
    ValueSetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ValueSet", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet) {
    surrogateSerializer.serialize(encoder, ValueSetSurrogate.fromModel(value))
  }
}
