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
import com.google.fhir.model.r5.MolecularSequence
import com.google.fhir.model.r5.surrogates.MolecularSequenceRelativeEditSurrogate
import com.google.fhir.model.r5.surrogates.MolecularSequenceRelativeStartingSequenceSequenceSurrogate
import com.google.fhir.model.r5.surrogates.MolecularSequenceRelativeStartingSequenceSurrogate
import com.google.fhir.model.r5.surrogates.MolecularSequenceRelativeSurrogate
import com.google.fhir.model.r5.surrogates.MolecularSequenceSurrogate
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

public object MolecularSequenceRelativeSerializer : KSerializer<MolecularSequence.Relative> {
  internal val surrogateSerializer: KSerializer<MolecularSequenceRelativeSurrogate> by lazy {
    MolecularSequenceRelativeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Relative", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative) {
    surrogateSerializer.serialize(encoder, MolecularSequenceRelativeSurrogate.fromModel(value))
  }
}

public object MolecularSequenceRelativeStartingSequenceSerializer :
  KSerializer<MolecularSequence.Relative.StartingSequence> {
  internal val surrogateSerializer:
    KSerializer<MolecularSequenceRelativeStartingSequenceSurrogate> by lazy {
    MolecularSequenceRelativeStartingSequenceSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("sequence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StartingSequence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative.StartingSequence {
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

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.StartingSequence) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MolecularSequenceRelativeStartingSequenceSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MolecularSequenceRelativeEditSerializer :
  KSerializer<MolecularSequence.Relative.Edit> {
  internal val surrogateSerializer: KSerializer<MolecularSequenceRelativeEditSurrogate> by lazy {
    MolecularSequenceRelativeEditSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Edit", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative.Edit =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.Edit) {
    surrogateSerializer.serialize(encoder, MolecularSequenceRelativeEditSurrogate.fromModel(value))
  }
}

public object MolecularSequenceRelativeStartingSequenceSequenceSerializer :
  KSerializer<MolecularSequence.Relative.StartingSequence.Sequence> {
  internal val surrogateSerializer:
    KSerializer<MolecularSequenceRelativeStartingSequenceSequenceSurrogate> by lazy {
    MolecularSequenceRelativeStartingSequenceSequenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Sequence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative.StartingSequence.Sequence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MolecularSequence.Relative.StartingSequence.Sequence,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MolecularSequenceRelativeStartingSequenceSequenceSurrogate.fromModel(value),
    )
  }
}

public object MolecularSequenceSerializer : KSerializer<MolecularSequence> {
  internal val surrogateSerializer: KSerializer<MolecularSequenceSurrogate> by lazy {
    MolecularSequenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MolecularSequence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence) {
    surrogateSerializer.serialize(encoder, MolecularSequenceSurrogate.fromModel(value))
  }
}
