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
import com.google.fhir.model.r5.RegulatedAuthorization
import com.google.fhir.model.r5.surrogates.RegulatedAuthorizationCaseDateSurrogate
import com.google.fhir.model.r5.surrogates.RegulatedAuthorizationCaseSurrogate
import com.google.fhir.model.r5.surrogates.RegulatedAuthorizationSurrogate
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

public object RegulatedAuthorizationCaseSerializer : KSerializer<RegulatedAuthorization.Case> {
  internal val surrogateSerializer: KSerializer<RegulatedAuthorizationCaseSurrogate> by lazy {
    RegulatedAuthorizationCaseSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("date")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Case", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RegulatedAuthorization.Case {
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

  override fun serialize(encoder: Encoder, `value`: RegulatedAuthorization.Case) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = RegulatedAuthorizationCaseSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object RegulatedAuthorizationCaseDateSerializer :
  KSerializer<RegulatedAuthorization.Case.Date> {
  internal val surrogateSerializer: KSerializer<RegulatedAuthorizationCaseDateSurrogate> by lazy {
    RegulatedAuthorizationCaseDateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Date", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RegulatedAuthorization.Case.Date =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RegulatedAuthorization.Case.Date) {
    surrogateSerializer.serialize(encoder, RegulatedAuthorizationCaseDateSurrogate.fromModel(value))
  }
}

public object RegulatedAuthorizationSerializer : KSerializer<RegulatedAuthorization> {
  internal val surrogateSerializer: KSerializer<RegulatedAuthorizationSurrogate> by lazy {
    RegulatedAuthorizationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RegulatedAuthorization", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RegulatedAuthorization =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RegulatedAuthorization) {
    surrogateSerializer.serialize(encoder, RegulatedAuthorizationSurrogate.fromModel(value))
  }
}
