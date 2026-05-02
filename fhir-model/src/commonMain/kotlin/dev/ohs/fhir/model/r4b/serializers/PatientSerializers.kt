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
import com.google.fhir.model.r5.Patient
import com.google.fhir.model.r5.surrogates.PatientCommunicationSurrogate
import com.google.fhir.model.r5.surrogates.PatientContactSurrogate
import com.google.fhir.model.r5.surrogates.PatientDeceasedSurrogate
import com.google.fhir.model.r5.surrogates.PatientLinkSurrogate
import com.google.fhir.model.r5.surrogates.PatientMultipleBirthSurrogate
import com.google.fhir.model.r5.surrogates.PatientSurrogate
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

public object PatientContactSerializer : KSerializer<Patient.Contact> {
  internal val surrogateSerializer: KSerializer<PatientContactSurrogate> by lazy {
    PatientContactSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Contact", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Patient.Contact =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Patient.Contact) {
    surrogateSerializer.serialize(encoder, PatientContactSurrogate.fromModel(value))
  }
}

public object PatientCommunicationSerializer : KSerializer<Patient.Communication> {
  internal val surrogateSerializer: KSerializer<PatientCommunicationSurrogate> by lazy {
    PatientCommunicationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Communication", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Patient.Communication =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Patient.Communication) {
    surrogateSerializer.serialize(encoder, PatientCommunicationSurrogate.fromModel(value))
  }
}

public object PatientLinkSerializer : KSerializer<Patient.Link> {
  internal val surrogateSerializer: KSerializer<PatientLinkSurrogate> by lazy {
    PatientLinkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Link", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Patient.Link =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Patient.Link) {
    surrogateSerializer.serialize(encoder, PatientLinkSurrogate.fromModel(value))
  }
}

public object PatientDeceasedSerializer : KSerializer<Patient.Deceased> {
  internal val surrogateSerializer: KSerializer<PatientDeceasedSurrogate> by lazy {
    PatientDeceasedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Deceased", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Patient.Deceased =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Patient.Deceased) {
    surrogateSerializer.serialize(encoder, PatientDeceasedSurrogate.fromModel(value))
  }
}

public object PatientMultipleBirthSerializer : KSerializer<Patient.MultipleBirth> {
  internal val surrogateSerializer: KSerializer<PatientMultipleBirthSurrogate> by lazy {
    PatientMultipleBirthSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MultipleBirth", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Patient.MultipleBirth =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Patient.MultipleBirth) {
    surrogateSerializer.serialize(encoder, PatientMultipleBirthSurrogate.fromModel(value))
  }
}

public object PatientSerializer : KSerializer<Patient> {
  internal val surrogateSerializer: KSerializer<PatientSurrogate> by lazy {
    PatientSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("deceased", "multipleBirth")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Patient", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Patient {
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

  override fun serialize(encoder: Encoder, `value`: Patient) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = PatientSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
