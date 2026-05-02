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
import com.google.fhir.model.r4b.MedicationDispense
import com.google.fhir.model.r4b.surrogates.MedicationDispenseMedicationSurrogate
import com.google.fhir.model.r4b.surrogates.MedicationDispensePerformerSurrogate
import com.google.fhir.model.r4b.surrogates.MedicationDispenseStatusReasonSurrogate
import com.google.fhir.model.r4b.surrogates.MedicationDispenseSubstitutionSurrogate
import com.google.fhir.model.r4b.surrogates.MedicationDispenseSurrogate
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

public object MedicationDispensePerformerSerializer : KSerializer<MedicationDispense.Performer> {
  internal val surrogateSerializer: KSerializer<MedicationDispensePerformerSurrogate> by lazy {
    MedicationDispensePerformerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.Performer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Performer) {
    surrogateSerializer.serialize(encoder, MedicationDispensePerformerSurrogate.fromModel(value))
  }
}

public object MedicationDispenseSubstitutionSerializer :
  KSerializer<MedicationDispense.Substitution> {
  internal val surrogateSerializer: KSerializer<MedicationDispenseSubstitutionSurrogate> by lazy {
    MedicationDispenseSubstitutionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Substitution", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.Substitution =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Substitution) {
    surrogateSerializer.serialize(encoder, MedicationDispenseSubstitutionSurrogate.fromModel(value))
  }
}

public object MedicationDispenseStatusReasonSerializer :
  KSerializer<MedicationDispense.StatusReason> {
  internal val surrogateSerializer: KSerializer<MedicationDispenseStatusReasonSurrogate> by lazy {
    MedicationDispenseStatusReasonSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StatusReason", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.StatusReason =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.StatusReason) {
    surrogateSerializer.serialize(encoder, MedicationDispenseStatusReasonSurrogate.fromModel(value))
  }
}

public object MedicationDispenseMedicationSerializer : KSerializer<MedicationDispense.Medication> {
  internal val surrogateSerializer: KSerializer<MedicationDispenseMedicationSurrogate> by lazy {
    MedicationDispenseMedicationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Medication", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.Medication =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Medication) {
    surrogateSerializer.serialize(encoder, MedicationDispenseMedicationSurrogate.fromModel(value))
  }
}

public object MedicationDispenseSerializer : KSerializer<MedicationDispense> {
  internal val surrogateSerializer: KSerializer<MedicationDispenseSurrogate> by lazy {
    MedicationDispenseSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("statusReason", "medication")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicationDispense", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense {
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

  override fun serialize(encoder: Encoder, `value`: MedicationDispense) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MedicationDispenseSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
