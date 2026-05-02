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
import com.google.fhir.model.r4.MedicationStatement
import com.google.fhir.model.r4.surrogates.MedicationStatementEffectiveSurrogate
import com.google.fhir.model.r4.surrogates.MedicationStatementMedicationSurrogate
import com.google.fhir.model.r4.surrogates.MedicationStatementSurrogate
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

public object MedicationStatementMedicationSerializer :
  KSerializer<MedicationStatement.Medication> {
  internal val surrogateSerializer: KSerializer<MedicationStatementMedicationSurrogate> by lazy {
    MedicationStatementMedicationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Medication", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationStatement.Medication =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationStatement.Medication) {
    surrogateSerializer.serialize(encoder, MedicationStatementMedicationSurrogate.fromModel(value))
  }
}

public object MedicationStatementEffectiveSerializer : KSerializer<MedicationStatement.Effective> {
  internal val surrogateSerializer: KSerializer<MedicationStatementEffectiveSurrogate> by lazy {
    MedicationStatementEffectiveSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Effective", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationStatement.Effective =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationStatement.Effective) {
    surrogateSerializer.serialize(encoder, MedicationStatementEffectiveSurrogate.fromModel(value))
  }
}

public object MedicationStatementSerializer : KSerializer<MedicationStatement> {
  internal val surrogateSerializer: KSerializer<MedicationStatementSurrogate> by lazy {
    MedicationStatementSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("medication", "effective")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicationStatement", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationStatement {
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

  override fun serialize(encoder: Encoder, `value`: MedicationStatement) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MedicationStatementSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
