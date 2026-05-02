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
import com.google.fhir.model.r4b.Immunization
import com.google.fhir.model.r4b.surrogates.ImmunizationEducationSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationOccurrenceSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationPerformerSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationProtocolAppliedDoseNumberSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationProtocolAppliedSeriesDosesSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationProtocolAppliedSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationReactionSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationSurrogate
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

public object ImmunizationPerformerSerializer : KSerializer<Immunization.Performer> {
  internal val surrogateSerializer: KSerializer<ImmunizationPerformerSurrogate> by lazy {
    ImmunizationPerformerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Immunization.Performer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Immunization.Performer) {
    surrogateSerializer.serialize(encoder, ImmunizationPerformerSurrogate.fromModel(value))
  }
}

public object ImmunizationEducationSerializer : KSerializer<Immunization.Education> {
  internal val surrogateSerializer: KSerializer<ImmunizationEducationSurrogate> by lazy {
    ImmunizationEducationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Education", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Immunization.Education =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Immunization.Education) {
    surrogateSerializer.serialize(encoder, ImmunizationEducationSurrogate.fromModel(value))
  }
}

public object ImmunizationReactionSerializer : KSerializer<Immunization.Reaction> {
  internal val surrogateSerializer: KSerializer<ImmunizationReactionSurrogate> by lazy {
    ImmunizationReactionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Reaction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Immunization.Reaction =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Immunization.Reaction) {
    surrogateSerializer.serialize(encoder, ImmunizationReactionSurrogate.fromModel(value))
  }
}

public object ImmunizationProtocolAppliedSerializer : KSerializer<Immunization.ProtocolApplied> {
  internal val surrogateSerializer: KSerializer<ImmunizationProtocolAppliedSurrogate> by lazy {
    ImmunizationProtocolAppliedSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("doseNumber", "seriesDoses")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ProtocolApplied", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Immunization.ProtocolApplied {
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

  override fun serialize(encoder: Encoder, `value`: Immunization.ProtocolApplied) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ImmunizationProtocolAppliedSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ImmunizationOccurrenceSerializer : KSerializer<Immunization.Occurrence> {
  internal val surrogateSerializer: KSerializer<ImmunizationOccurrenceSurrogate> by lazy {
    ImmunizationOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Immunization.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Immunization.Occurrence) {
    surrogateSerializer.serialize(encoder, ImmunizationOccurrenceSurrogate.fromModel(value))
  }
}

public object ImmunizationProtocolAppliedDoseNumberSerializer :
  KSerializer<Immunization.ProtocolApplied.DoseNumber> {
  internal val surrogateSerializer:
    KSerializer<ImmunizationProtocolAppliedDoseNumberSurrogate> by lazy {
    ImmunizationProtocolAppliedDoseNumberSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DoseNumber", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Immunization.ProtocolApplied.DoseNumber =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Immunization.ProtocolApplied.DoseNumber) {
    surrogateSerializer.serialize(
      encoder,
      ImmunizationProtocolAppliedDoseNumberSurrogate.fromModel(value),
    )
  }
}

public object ImmunizationProtocolAppliedSeriesDosesSerializer :
  KSerializer<Immunization.ProtocolApplied.SeriesDoses> {
  internal val surrogateSerializer:
    KSerializer<ImmunizationProtocolAppliedSeriesDosesSurrogate> by lazy {
    ImmunizationProtocolAppliedSeriesDosesSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SeriesDoses", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Immunization.ProtocolApplied.SeriesDoses =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Immunization.ProtocolApplied.SeriesDoses) {
    surrogateSerializer.serialize(
      encoder,
      ImmunizationProtocolAppliedSeriesDosesSurrogate.fromModel(value),
    )
  }
}

public object ImmunizationSerializer : KSerializer<Immunization> {
  internal val surrogateSerializer: KSerializer<ImmunizationSurrogate> by lazy {
    ImmunizationSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("occurrence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Immunization", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Immunization {
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

  override fun serialize(encoder: Encoder, `value`: Immunization) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ImmunizationSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
