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
import com.google.fhir.model.r5.ValueSet
import com.google.fhir.model.r5.surrogates.ValueSetComposeIncludeConceptDesignationSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetComposeIncludeConceptSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetComposeIncludeFilterSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetComposeIncludeSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetComposeSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetExpansionContainsPropertySubPropertySurrogate
import com.google.fhir.model.r5.surrogates.ValueSetExpansionContainsPropertySubPropertyValueSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetExpansionContainsPropertySurrogate
import com.google.fhir.model.r5.surrogates.ValueSetExpansionContainsPropertyValueSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetExpansionContainsSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetExpansionParameterSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetExpansionParameterValueSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetExpansionPropertySurrogate
import com.google.fhir.model.r5.surrogates.ValueSetExpansionSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetScopeSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetSurrogate
import com.google.fhir.model.r5.surrogates.ValueSetVersionAlgorithmSurrogate
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

public object ValueSetExpansionPropertySerializer : KSerializer<ValueSet.Expansion.Property> {
  internal val surrogateSerializer: KSerializer<ValueSetExpansionPropertySurrogate> by lazy {
    ValueSetExpansionPropertySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Property =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Property) {
    surrogateSerializer.serialize(encoder, ValueSetExpansionPropertySurrogate.fromModel(value))
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

public object ValueSetExpansionContainsPropertySerializer :
  KSerializer<ValueSet.Expansion.Contains.Property> {
  internal val surrogateSerializer:
    KSerializer<ValueSetExpansionContainsPropertySurrogate> by lazy {
    ValueSetExpansionContainsPropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains.Property {
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

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Contains.Property) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ValueSetExpansionContainsPropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ValueSetExpansionContainsPropertySubPropertySerializer :
  KSerializer<ValueSet.Expansion.Contains.Property.SubProperty> {
  internal val surrogateSerializer:
    KSerializer<ValueSetExpansionContainsPropertySubPropertySurrogate> by lazy {
    ValueSetExpansionContainsPropertySubPropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubProperty", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains.Property.SubProperty {
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

  override fun serialize(
    encoder: Encoder,
    `value`: ValueSet.Expansion.Contains.Property.SubProperty,
  ) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ValueSetExpansionContainsPropertySubPropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ValueSetScopeSerializer : KSerializer<ValueSet.Scope> {
  internal val surrogateSerializer: KSerializer<ValueSetScopeSurrogate> by lazy {
    ValueSetScopeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Scope", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Scope =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Scope) {
    surrogateSerializer.serialize(encoder, ValueSetScopeSurrogate.fromModel(value))
  }
}

public object ValueSetVersionAlgorithmSerializer : KSerializer<ValueSet.VersionAlgorithm> {
  internal val surrogateSerializer: KSerializer<ValueSetVersionAlgorithmSurrogate> by lazy {
    ValueSetVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.VersionAlgorithm) {
    surrogateSerializer.serialize(encoder, ValueSetVersionAlgorithmSurrogate.fromModel(value))
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

public object ValueSetExpansionContainsPropertyValueSerializer :
  KSerializer<ValueSet.Expansion.Contains.Property.Value> {
  internal val surrogateSerializer:
    KSerializer<ValueSetExpansionContainsPropertyValueSurrogate> by lazy {
    ValueSetExpansionContainsPropertyValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet.Expansion.Contains.Property.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ValueSet.Expansion.Contains.Property.Value) {
    surrogateSerializer.serialize(
      encoder,
      ValueSetExpansionContainsPropertyValueSurrogate.fromModel(value),
    )
  }
}

public object ValueSetExpansionContainsPropertySubPropertyValueSerializer :
  KSerializer<ValueSet.Expansion.Contains.Property.SubProperty.Value> {
  internal val surrogateSerializer:
    KSerializer<ValueSetExpansionContainsPropertySubPropertyValueSurrogate> by lazy {
    ValueSetExpansionContainsPropertySubPropertyValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): ValueSet.Expansion.Contains.Property.SubProperty.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ValueSet.Expansion.Contains.Property.SubProperty.Value,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ValueSetExpansionContainsPropertySubPropertyValueSurrogate.fromModel(value),
    )
  }
}

public object ValueSetSerializer : KSerializer<ValueSet> {
  internal val surrogateSerializer: KSerializer<ValueSetSurrogate> by lazy {
    ValueSetSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ValueSet", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ValueSet {
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

  override fun serialize(encoder: Encoder, `value`: ValueSet) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ValueSetSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
