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

import com.google.fhir.model.r5.ElementDefinition
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.ElementDefinitionBaseSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionBindingAdditionalSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionBindingSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionConstraintSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionDefaultValueSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionExampleSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionExampleValueSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionFixedSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionMappingSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionMaxValueSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionMinValueSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionPatternSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionSlicingDiscriminatorSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionSlicingSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionSurrogate
import com.google.fhir.model.r5.surrogates.ElementDefinitionTypeSurrogate
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

public object ElementDefinitionSlicingSerializer : KSerializer<ElementDefinition.Slicing> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionSlicingSurrogate> by lazy {
    ElementDefinitionSlicingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Slicing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Slicing =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Slicing) {
    surrogateSerializer.serialize(encoder, ElementDefinitionSlicingSurrogate.fromModel(value))
  }
}

public object ElementDefinitionSlicingDiscriminatorSerializer :
  KSerializer<ElementDefinition.Slicing.Discriminator> {
  internal val surrogateSerializer:
    KSerializer<ElementDefinitionSlicingDiscriminatorSurrogate> by lazy {
    ElementDefinitionSlicingDiscriminatorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Discriminator", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Slicing.Discriminator =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Slicing.Discriminator) {
    surrogateSerializer.serialize(
      encoder,
      ElementDefinitionSlicingDiscriminatorSurrogate.fromModel(value),
    )
  }
}

public object ElementDefinitionBaseSerializer : KSerializer<ElementDefinition.Base> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionBaseSurrogate> by lazy {
    ElementDefinitionBaseSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Base", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Base =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Base) {
    surrogateSerializer.serialize(encoder, ElementDefinitionBaseSurrogate.fromModel(value))
  }
}

public object ElementDefinitionTypeSerializer : KSerializer<ElementDefinition.Type> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionTypeSurrogate> by lazy {
    ElementDefinitionTypeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Type", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Type =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Type) {
    surrogateSerializer.serialize(encoder, ElementDefinitionTypeSurrogate.fromModel(value))
  }
}

public object ElementDefinitionExampleSerializer : KSerializer<ElementDefinition.Example> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionExampleSurrogate> by lazy {
    ElementDefinitionExampleSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Example", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Example {
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

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Example) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ElementDefinitionExampleSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ElementDefinitionConstraintSerializer : KSerializer<ElementDefinition.Constraint> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionConstraintSurrogate> by lazy {
    ElementDefinitionConstraintSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Constraint", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Constraint =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Constraint) {
    surrogateSerializer.serialize(encoder, ElementDefinitionConstraintSurrogate.fromModel(value))
  }
}

public object ElementDefinitionBindingSerializer : KSerializer<ElementDefinition.Binding> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionBindingSurrogate> by lazy {
    ElementDefinitionBindingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Binding", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Binding =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Binding) {
    surrogateSerializer.serialize(encoder, ElementDefinitionBindingSurrogate.fromModel(value))
  }
}

public object ElementDefinitionBindingAdditionalSerializer :
  KSerializer<ElementDefinition.Binding.Additional> {
  internal val surrogateSerializer:
    KSerializer<ElementDefinitionBindingAdditionalSurrogate> by lazy {
    ElementDefinitionBindingAdditionalSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Additional", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Binding.Additional =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Binding.Additional) {
    surrogateSerializer.serialize(
      encoder,
      ElementDefinitionBindingAdditionalSurrogate.fromModel(value),
    )
  }
}

public object ElementDefinitionMappingSerializer : KSerializer<ElementDefinition.Mapping> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionMappingSurrogate> by lazy {
    ElementDefinitionMappingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Mapping", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Mapping =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Mapping) {
    surrogateSerializer.serialize(encoder, ElementDefinitionMappingSurrogate.fromModel(value))
  }
}

public object ElementDefinitionDefaultValueSerializer :
  KSerializer<ElementDefinition.DefaultValue> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionDefaultValueSurrogate> by lazy {
    ElementDefinitionDefaultValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DefaultValue", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.DefaultValue =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.DefaultValue) {
    surrogateSerializer.serialize(encoder, ElementDefinitionDefaultValueSurrogate.fromModel(value))
  }
}

public object ElementDefinitionFixedSerializer : KSerializer<ElementDefinition.Fixed> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionFixedSurrogate> by lazy {
    ElementDefinitionFixedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Fixed", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Fixed =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Fixed) {
    surrogateSerializer.serialize(encoder, ElementDefinitionFixedSurrogate.fromModel(value))
  }
}

public object ElementDefinitionPatternSerializer : KSerializer<ElementDefinition.Pattern> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionPatternSurrogate> by lazy {
    ElementDefinitionPatternSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Pattern", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Pattern =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Pattern) {
    surrogateSerializer.serialize(encoder, ElementDefinitionPatternSurrogate.fromModel(value))
  }
}

public object ElementDefinitionExampleValueSerializer :
  KSerializer<ElementDefinition.Example.Value> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionExampleValueSurrogate> by lazy {
    ElementDefinitionExampleValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.Example.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.Example.Value) {
    surrogateSerializer.serialize(encoder, ElementDefinitionExampleValueSurrogate.fromModel(value))
  }
}

public object ElementDefinitionMinValueSerializer : KSerializer<ElementDefinition.MinValue> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionMinValueSurrogate> by lazy {
    ElementDefinitionMinValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MinValue", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.MinValue =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.MinValue) {
    surrogateSerializer.serialize(encoder, ElementDefinitionMinValueSurrogate.fromModel(value))
  }
}

public object ElementDefinitionMaxValueSerializer : KSerializer<ElementDefinition.MaxValue> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionMaxValueSurrogate> by lazy {
    ElementDefinitionMaxValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MaxValue", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition.MaxValue =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ElementDefinition.MaxValue) {
    surrogateSerializer.serialize(encoder, ElementDefinitionMaxValueSurrogate.fromModel(value))
  }
}

public object ElementDefinitionSerializer : KSerializer<ElementDefinition> {
  internal val surrogateSerializer: KSerializer<ElementDefinitionSurrogate> by lazy {
    ElementDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> =
    listOf("defaultValue", "fixed", "pattern", "minValue", "maxValue")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ElementDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ElementDefinition {
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

  override fun serialize(encoder: Encoder, `value`: ElementDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ElementDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
