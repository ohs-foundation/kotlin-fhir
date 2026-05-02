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
import com.google.fhir.model.r5.MedicationAdministration
import com.google.fhir.model.r5.surrogates.MedicationAdministrationDosageRateSurrogate
import com.google.fhir.model.r5.surrogates.MedicationAdministrationDosageSurrogate
import com.google.fhir.model.r5.surrogates.MedicationAdministrationOccurenceSurrogate
import com.google.fhir.model.r5.surrogates.MedicationAdministrationPerformerSurrogate
import com.google.fhir.model.r5.surrogates.MedicationAdministrationSurrogate
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

public object MedicationAdministrationPerformerSerializer :
  KSerializer<MedicationAdministration.Performer> {
  internal val surrogateSerializer:
    KSerializer<MedicationAdministrationPerformerSurrogate> by lazy {
    MedicationAdministrationPerformerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration.Performer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Performer) {
    surrogateSerializer.serialize(
      encoder,
      MedicationAdministrationPerformerSurrogate.fromModel(value),
    )
  }
}

public object MedicationAdministrationDosageSerializer :
  KSerializer<MedicationAdministration.Dosage> {
  internal val surrogateSerializer: KSerializer<MedicationAdministrationDosageSurrogate> by lazy {
    MedicationAdministrationDosageSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("rate")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Dosage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration.Dosage {
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

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Dosage) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MedicationAdministrationDosageSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MedicationAdministrationOccurenceSerializer :
  KSerializer<MedicationAdministration.Occurence> {
  internal val surrogateSerializer:
    KSerializer<MedicationAdministrationOccurenceSurrogate> by lazy {
    MedicationAdministrationOccurenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration.Occurence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Occurence) {
    surrogateSerializer.serialize(
      encoder,
      MedicationAdministrationOccurenceSurrogate.fromModel(value),
    )
  }
}

public object MedicationAdministrationDosageRateSerializer :
  KSerializer<MedicationAdministration.Dosage.Rate> {
  internal val surrogateSerializer:
    KSerializer<MedicationAdministrationDosageRateSurrogate> by lazy {
    MedicationAdministrationDosageRateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Rate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration.Dosage.Rate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Dosage.Rate) {
    surrogateSerializer.serialize(
      encoder,
      MedicationAdministrationDosageRateSurrogate.fromModel(value),
    )
  }
}

public object MedicationAdministrationSerializer : KSerializer<MedicationAdministration> {
  internal val surrogateSerializer: KSerializer<MedicationAdministrationSurrogate> by lazy {
    MedicationAdministrationSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("occurence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicationAdministration", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration {
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

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MedicationAdministrationSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
