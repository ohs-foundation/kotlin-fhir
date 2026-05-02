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
import com.google.fhir.model.r5.Person
import com.google.fhir.model.r5.surrogates.PersonCommunicationSurrogate
import com.google.fhir.model.r5.surrogates.PersonDeceasedSurrogate
import com.google.fhir.model.r5.surrogates.PersonLinkSurrogate
import com.google.fhir.model.r5.surrogates.PersonSurrogate
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

public object PersonCommunicationSerializer : KSerializer<Person.Communication> {
  internal val surrogateSerializer: KSerializer<PersonCommunicationSurrogate> by lazy {
    PersonCommunicationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Communication", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Person.Communication =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Person.Communication) {
    surrogateSerializer.serialize(encoder, PersonCommunicationSurrogate.fromModel(value))
  }
}

public object PersonLinkSerializer : KSerializer<Person.Link> {
  internal val surrogateSerializer: KSerializer<PersonLinkSurrogate> by lazy {
    PersonLinkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Link", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Person.Link =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Person.Link) {
    surrogateSerializer.serialize(encoder, PersonLinkSurrogate.fromModel(value))
  }
}

public object PersonDeceasedSerializer : KSerializer<Person.Deceased> {
  internal val surrogateSerializer: KSerializer<PersonDeceasedSurrogate> by lazy {
    PersonDeceasedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Deceased", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Person.Deceased =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Person.Deceased) {
    surrogateSerializer.serialize(encoder, PersonDeceasedSurrogate.fromModel(value))
  }
}

public object PersonSerializer : KSerializer<Person> {
  internal val surrogateSerializer: KSerializer<PersonSurrogate> by lazy {
    PersonSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("deceased")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Person", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Person {
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

  override fun serialize(encoder: Encoder, `value`: Person) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = PersonSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
