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

import com.google.fhir.model.r4.DiagnosticReport
import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.surrogates.DiagnosticReportEffectiveSurrogate
import com.google.fhir.model.r4.surrogates.DiagnosticReportMediaSurrogate
import com.google.fhir.model.r4.surrogates.DiagnosticReportSurrogate
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

public object DiagnosticReportMediaSerializer : KSerializer<DiagnosticReport.Media> {
  internal val surrogateSerializer: KSerializer<DiagnosticReportMediaSurrogate> by lazy {
    DiagnosticReportMediaSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Media", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DiagnosticReport.Media =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DiagnosticReport.Media) {
    surrogateSerializer.serialize(encoder, DiagnosticReportMediaSurrogate.fromModel(value))
  }
}

public object DiagnosticReportEffectiveSerializer : KSerializer<DiagnosticReport.Effective> {
  internal val surrogateSerializer: KSerializer<DiagnosticReportEffectiveSurrogate> by lazy {
    DiagnosticReportEffectiveSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Effective", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DiagnosticReport.Effective =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DiagnosticReport.Effective) {
    surrogateSerializer.serialize(encoder, DiagnosticReportEffectiveSurrogate.fromModel(value))
  }
}

public object DiagnosticReportSerializer : KSerializer<DiagnosticReport> {
  internal val surrogateSerializer: KSerializer<DiagnosticReportSurrogate> by lazy {
    DiagnosticReportSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("effective")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DiagnosticReport", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DiagnosticReport {
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

  override fun serialize(encoder: Encoder, `value`: DiagnosticReport) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = DiagnosticReportSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
