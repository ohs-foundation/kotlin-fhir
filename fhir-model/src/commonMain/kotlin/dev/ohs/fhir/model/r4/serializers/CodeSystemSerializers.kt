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

import com.google.fhir.model.r4b.CodeSystem
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.CodeSystemConceptDesignationSurrogate
import com.google.fhir.model.r4b.surrogates.CodeSystemConceptPropertySurrogate
import com.google.fhir.model.r4b.surrogates.CodeSystemConceptPropertyValueSurrogate
import com.google.fhir.model.r4b.surrogates.CodeSystemConceptSurrogate
import com.google.fhir.model.r4b.surrogates.CodeSystemFilterSurrogate
import com.google.fhir.model.r4b.surrogates.CodeSystemPropertySurrogate
import com.google.fhir.model.r4b.surrogates.CodeSystemSurrogate
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

public object CodeSystemFilterSerializer : KSerializer<CodeSystem.Filter> {
  internal val surrogateSerializer: KSerializer<CodeSystemFilterSurrogate> by lazy {
    CodeSystemFilterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Filter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CodeSystem.Filter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Filter) {
    surrogateSerializer.serialize(encoder, CodeSystemFilterSurrogate.fromModel(value))
  }
}

public object CodeSystemPropertySerializer : KSerializer<CodeSystem.Property> {
  internal val surrogateSerializer: KSerializer<CodeSystemPropertySurrogate> by lazy {
    CodeSystemPropertySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CodeSystem.Property =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Property) {
    surrogateSerializer.serialize(encoder, CodeSystemPropertySurrogate.fromModel(value))
  }
}

public object CodeSystemConceptSerializer : KSerializer<CodeSystem.Concept> {
  internal val surrogateSerializer: KSerializer<CodeSystemConceptSurrogate> by lazy {
    CodeSystemConceptSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Concept", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CodeSystem.Concept =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept) {
    surrogateSerializer.serialize(encoder, CodeSystemConceptSurrogate.fromModel(value))
  }
}

public object CodeSystemConceptDesignationSerializer : KSerializer<CodeSystem.Concept.Designation> {
  internal val surrogateSerializer: KSerializer<CodeSystemConceptDesignationSurrogate> by lazy {
    CodeSystemConceptDesignationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Designation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CodeSystem.Concept.Designation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept.Designation) {
    surrogateSerializer.serialize(encoder, CodeSystemConceptDesignationSurrogate.fromModel(value))
  }
}

public object CodeSystemConceptPropertySerializer : KSerializer<CodeSystem.Concept.Property> {
  internal val surrogateSerializer: KSerializer<CodeSystemConceptPropertySurrogate> by lazy {
    CodeSystemConceptPropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CodeSystem.Concept.Property {
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

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept.Property) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CodeSystemConceptPropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object CodeSystemConceptPropertyValueSerializer :
  KSerializer<CodeSystem.Concept.Property.Value> {
  internal val surrogateSerializer: KSerializer<CodeSystemConceptPropertyValueSurrogate> by lazy {
    CodeSystemConceptPropertyValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CodeSystem.Concept.Property.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept.Property.Value) {
    surrogateSerializer.serialize(encoder, CodeSystemConceptPropertyValueSurrogate.fromModel(value))
  }
}

public object CodeSystemSerializer : KSerializer<CodeSystem> {
  internal val surrogateSerializer: KSerializer<CodeSystemSurrogate> by lazy {
    CodeSystemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CodeSystem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CodeSystem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CodeSystem) {
    surrogateSerializer.serialize(encoder, CodeSystemSurrogate.fromModel(value))
  }
}
