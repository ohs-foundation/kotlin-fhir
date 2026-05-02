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

import com.google.fhir.model.r4.Consent
import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.surrogates.ConsentPolicySurrogate
import com.google.fhir.model.r4.surrogates.ConsentProvisionActorSurrogate
import com.google.fhir.model.r4.surrogates.ConsentProvisionDataSurrogate
import com.google.fhir.model.r4.surrogates.ConsentProvisionSurrogate
import com.google.fhir.model.r4.surrogates.ConsentSourceSurrogate
import com.google.fhir.model.r4.surrogates.ConsentSurrogate
import com.google.fhir.model.r4.surrogates.ConsentVerificationSurrogate
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

public object ConsentPolicySerializer : KSerializer<Consent.Policy> {
  internal val surrogateSerializer: KSerializer<ConsentPolicySurrogate> by lazy {
    ConsentPolicySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Policy", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Policy =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Policy) {
    surrogateSerializer.serialize(encoder, ConsentPolicySurrogate.fromModel(value))
  }
}

public object ConsentVerificationSerializer : KSerializer<Consent.Verification> {
  internal val surrogateSerializer: KSerializer<ConsentVerificationSurrogate> by lazy {
    ConsentVerificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Verification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Verification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Verification) {
    surrogateSerializer.serialize(encoder, ConsentVerificationSurrogate.fromModel(value))
  }
}

public object ConsentProvisionSerializer : KSerializer<Consent.Provision> {
  internal val surrogateSerializer: KSerializer<ConsentProvisionSurrogate> by lazy {
    ConsentProvisionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Provision", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Provision =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Provision) {
    surrogateSerializer.serialize(encoder, ConsentProvisionSurrogate.fromModel(value))
  }
}

public object ConsentProvisionActorSerializer : KSerializer<Consent.Provision.Actor> {
  internal val surrogateSerializer: KSerializer<ConsentProvisionActorSurrogate> by lazy {
    ConsentProvisionActorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Actor", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Provision.Actor =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Actor) {
    surrogateSerializer.serialize(encoder, ConsentProvisionActorSurrogate.fromModel(value))
  }
}

public object ConsentProvisionDataSerializer : KSerializer<Consent.Provision.Data> {
  internal val surrogateSerializer: KSerializer<ConsentProvisionDataSurrogate> by lazy {
    ConsentProvisionDataSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Data", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Provision.Data =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Data) {
    surrogateSerializer.serialize(encoder, ConsentProvisionDataSurrogate.fromModel(value))
  }
}

public object ConsentSourceSerializer : KSerializer<Consent.Source> {
  internal val surrogateSerializer: KSerializer<ConsentSourceSurrogate> by lazy {
    ConsentSourceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Source", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Source =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Source) {
    surrogateSerializer.serialize(encoder, ConsentSourceSurrogate.fromModel(value))
  }
}

public object ConsentSerializer : KSerializer<Consent> {
  internal val surrogateSerializer: KSerializer<ConsentSurrogate> by lazy {
    ConsentSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("source")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Consent", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent {
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

  override fun serialize(encoder: Encoder, `value`: Consent) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ConsentSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
