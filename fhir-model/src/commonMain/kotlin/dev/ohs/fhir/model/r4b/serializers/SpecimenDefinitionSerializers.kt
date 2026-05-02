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

import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.SpecimenDefinition
import com.google.fhir.model.r4b.surrogates.SpecimenDefinitionSurrogate
import com.google.fhir.model.r4b.surrogates.SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSurrogate
import com.google.fhir.model.r4b.surrogates.SpecimenDefinitionTypeTestedContainerAdditiveSurrogate
import com.google.fhir.model.r4b.surrogates.SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate
import com.google.fhir.model.r4b.surrogates.SpecimenDefinitionTypeTestedContainerSurrogate
import com.google.fhir.model.r4b.surrogates.SpecimenDefinitionTypeTestedHandlingSurrogate
import com.google.fhir.model.r4b.surrogates.SpecimenDefinitionTypeTestedSurrogate
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

public object SpecimenDefinitionTypeTestedSerializer : KSerializer<SpecimenDefinition.TypeTested> {
  internal val surrogateSerializer: KSerializer<SpecimenDefinitionTypeTestedSurrogate> by lazy {
    SpecimenDefinitionTypeTestedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TypeTested", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested) {
    surrogateSerializer.serialize(encoder, SpecimenDefinitionTypeTestedSurrogate.fromModel(value))
  }
}

public object SpecimenDefinitionTypeTestedContainerSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Container> {
  internal val surrogateSerializer:
    KSerializer<SpecimenDefinitionTypeTestedContainerSurrogate> by lazy {
    SpecimenDefinitionTypeTestedContainerSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("minimumVolume")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Container", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container {
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

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Container) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SpecimenDefinitionTypeTestedContainerSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SpecimenDefinitionTypeTestedContainerAdditiveSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Container.Additive> {
  internal val surrogateSerializer:
    KSerializer<SpecimenDefinitionTypeTestedContainerAdditiveSurrogate> by lazy {
    SpecimenDefinitionTypeTestedContainerAdditiveSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("additive")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Additive", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Container.Additive {
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
    `value`: SpecimenDefinition.TypeTested.Container.Additive,
  ) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SpecimenDefinitionTypeTestedContainerAdditiveSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SpecimenDefinitionTypeTestedHandlingSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Handling> {
  internal val surrogateSerializer:
    KSerializer<SpecimenDefinitionTypeTestedHandlingSurrogate> by lazy {
    SpecimenDefinitionTypeTestedHandlingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Handling", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition.TypeTested.Handling =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition.TypeTested.Handling) {
    surrogateSerializer.serialize(
      encoder,
      SpecimenDefinitionTypeTestedHandlingSurrogate.fromModel(value),
    )
  }
}

public object SpecimenDefinitionTypeTestedContainerMinimumVolumeSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Container.MinimumVolume> {
  internal val surrogateSerializer:
    KSerializer<SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate> by lazy {
    SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MinimumVolume", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): SpecimenDefinition.TypeTested.Container.MinimumVolume =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SpecimenDefinition.TypeTested.Container.MinimumVolume,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate.fromModel(value),
    )
  }
}

public object SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSerializer :
  KSerializer<SpecimenDefinition.TypeTested.Container.Additive.Additive> {
  internal val surrogateSerializer:
    KSerializer<SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSurrogate> by lazy {
    SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Additive", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): SpecimenDefinition.TypeTested.Container.Additive.Additive =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SpecimenDefinition.TypeTested.Container.Additive.Additive,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSurrogate.fromModel(value),
    )
  }
}

public object SpecimenDefinitionSerializer : KSerializer<SpecimenDefinition> {
  internal val surrogateSerializer: KSerializer<SpecimenDefinitionSurrogate> by lazy {
    SpecimenDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SpecimenDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SpecimenDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SpecimenDefinition) {
    surrogateSerializer.serialize(encoder, SpecimenDefinitionSurrogate.fromModel(value))
  }
}
