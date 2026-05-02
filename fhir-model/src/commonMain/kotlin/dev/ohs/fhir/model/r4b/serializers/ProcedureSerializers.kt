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
import com.google.fhir.model.r4.Procedure
import com.google.fhir.model.r4.surrogates.ProcedureFocalDeviceSurrogate
import com.google.fhir.model.r4.surrogates.ProcedurePerformedSurrogate
import com.google.fhir.model.r4.surrogates.ProcedurePerformerSurrogate
import com.google.fhir.model.r4.surrogates.ProcedureSurrogate
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

public object ProcedurePerformerSerializer : KSerializer<Procedure.Performer> {
  internal val surrogateSerializer: KSerializer<ProcedurePerformerSurrogate> by lazy {
    ProcedurePerformerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Procedure.Performer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Procedure.Performer) {
    surrogateSerializer.serialize(encoder, ProcedurePerformerSurrogate.fromModel(value))
  }
}

public object ProcedureFocalDeviceSerializer : KSerializer<Procedure.FocalDevice> {
  internal val surrogateSerializer: KSerializer<ProcedureFocalDeviceSurrogate> by lazy {
    ProcedureFocalDeviceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("FocalDevice", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Procedure.FocalDevice =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Procedure.FocalDevice) {
    surrogateSerializer.serialize(encoder, ProcedureFocalDeviceSurrogate.fromModel(value))
  }
}

public object ProcedurePerformedSerializer : KSerializer<Procedure.Performed> {
  internal val surrogateSerializer: KSerializer<ProcedurePerformedSurrogate> by lazy {
    ProcedurePerformedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performed", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Procedure.Performed =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Procedure.Performed) {
    surrogateSerializer.serialize(encoder, ProcedurePerformedSurrogate.fromModel(value))
  }
}

public object ProcedureSerializer : KSerializer<Procedure> {
  internal val surrogateSerializer: KSerializer<ProcedureSurrogate> by lazy {
    ProcedureSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("performed")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Procedure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Procedure {
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

  override fun serialize(encoder: Encoder, `value`: Procedure) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ProcedureSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
