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
import com.google.fhir.model.r4.MedicinalProductAuthorization
import com.google.fhir.model.r4.surrogates.MedicinalProductAuthorizationJurisdictionalAuthorizationSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductAuthorizationProcedureDateSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductAuthorizationProcedureSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductAuthorizationSurrogate
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

public object MedicinalProductAuthorizationJurisdictionalAuthorizationSerializer :
  KSerializer<MedicinalProductAuthorization.JurisdictionalAuthorization> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductAuthorizationJurisdictionalAuthorizationSurrogate> by lazy {
    MedicinalProductAuthorizationJurisdictionalAuthorizationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("JurisdictionalAuthorization", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductAuthorization.JurisdictionalAuthorization =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductAuthorization.JurisdictionalAuthorization,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductAuthorizationJurisdictionalAuthorizationSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductAuthorizationProcedureSerializer :
  KSerializer<MedicinalProductAuthorization.Procedure> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductAuthorizationProcedureSurrogate> by lazy {
    MedicinalProductAuthorizationProcedureSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("date")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Procedure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductAuthorization.Procedure {
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

  override fun serialize(encoder: Encoder, `value`: MedicinalProductAuthorization.Procedure) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MedicinalProductAuthorizationProcedureSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MedicinalProductAuthorizationProcedureDateSerializer :
  KSerializer<MedicinalProductAuthorization.Procedure.Date> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductAuthorizationProcedureDateSurrogate> by lazy {
    MedicinalProductAuthorizationProcedureDateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Date", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductAuthorization.Procedure.Date =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductAuthorization.Procedure.Date) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductAuthorizationProcedureDateSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductAuthorizationSerializer : KSerializer<MedicinalProductAuthorization> {
  internal val surrogateSerializer: KSerializer<MedicinalProductAuthorizationSurrogate> by lazy {
    MedicinalProductAuthorizationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicinalProductAuthorization", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductAuthorization =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductAuthorization) {
    surrogateSerializer.serialize(encoder, MedicinalProductAuthorizationSurrogate.fromModel(value))
  }
}
