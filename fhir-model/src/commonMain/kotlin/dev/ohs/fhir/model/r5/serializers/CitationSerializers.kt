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

import com.google.fhir.model.r5.Citation
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactAbstractSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactClassificationSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactContributorshipEntrySurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactContributorshipSummarySurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactContributorshipSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactPartSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactPublicationFormPublishedInSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactPublicationFormSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactRelatesToSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactStatusDateSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactTitleSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactVersionSurrogate
import com.google.fhir.model.r5.surrogates.CitationCitedArtifactWebLocationSurrogate
import com.google.fhir.model.r5.surrogates.CitationClassificationSurrogate
import com.google.fhir.model.r5.surrogates.CitationStatusDateSurrogate
import com.google.fhir.model.r5.surrogates.CitationSummarySurrogate
import com.google.fhir.model.r5.surrogates.CitationSurrogate
import com.google.fhir.model.r5.surrogates.CitationVersionAlgorithmSurrogate
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

public object CitationSummarySerializer : KSerializer<Citation.Summary> {
  internal val surrogateSerializer: KSerializer<CitationSummarySurrogate> by lazy {
    CitationSummarySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Summary", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.Summary =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.Summary) {
    surrogateSerializer.serialize(encoder, CitationSummarySurrogate.fromModel(value))
  }
}

public object CitationClassificationSerializer : KSerializer<Citation.Classification> {
  internal val surrogateSerializer: KSerializer<CitationClassificationSurrogate> by lazy {
    CitationClassificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Classification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.Classification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.Classification) {
    surrogateSerializer.serialize(encoder, CitationClassificationSurrogate.fromModel(value))
  }
}

public object CitationStatusDateSerializer : KSerializer<Citation.StatusDate> {
  internal val surrogateSerializer: KSerializer<CitationStatusDateSurrogate> by lazy {
    CitationStatusDateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StatusDate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.StatusDate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.StatusDate) {
    surrogateSerializer.serialize(encoder, CitationStatusDateSurrogate.fromModel(value))
  }
}

public object CitationCitedArtifactSerializer : KSerializer<Citation.CitedArtifact> {
  internal val surrogateSerializer: KSerializer<CitationCitedArtifactSurrogate> by lazy {
    CitationCitedArtifactSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CitedArtifact", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact) {
    surrogateSerializer.serialize(encoder, CitationCitedArtifactSurrogate.fromModel(value))
  }
}

public object CitationCitedArtifactVersionSerializer : KSerializer<Citation.CitedArtifact.Version> {
  internal val surrogateSerializer: KSerializer<CitationCitedArtifactVersionSurrogate> by lazy {
    CitationCitedArtifactVersionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Version", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Version =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Version) {
    surrogateSerializer.serialize(encoder, CitationCitedArtifactVersionSurrogate.fromModel(value))
  }
}

public object CitationCitedArtifactStatusDateSerializer :
  KSerializer<Citation.CitedArtifact.StatusDate> {
  internal val surrogateSerializer: KSerializer<CitationCitedArtifactStatusDateSurrogate> by lazy {
    CitationCitedArtifactStatusDateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StatusDate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.StatusDate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.StatusDate) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactStatusDateSurrogate.fromModel(value),
    )
  }
}

public object CitationCitedArtifactTitleSerializer : KSerializer<Citation.CitedArtifact.Title> {
  internal val surrogateSerializer: KSerializer<CitationCitedArtifactTitleSurrogate> by lazy {
    CitationCitedArtifactTitleSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Title", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Title =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Title) {
    surrogateSerializer.serialize(encoder, CitationCitedArtifactTitleSurrogate.fromModel(value))
  }
}

public object CitationCitedArtifactAbstractSerializer :
  KSerializer<Citation.CitedArtifact.Abstract> {
  internal val surrogateSerializer: KSerializer<CitationCitedArtifactAbstractSurrogate> by lazy {
    CitationCitedArtifactAbstractSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Abstract", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Abstract =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Abstract) {
    surrogateSerializer.serialize(encoder, CitationCitedArtifactAbstractSurrogate.fromModel(value))
  }
}

public object CitationCitedArtifactPartSerializer : KSerializer<Citation.CitedArtifact.Part> {
  internal val surrogateSerializer: KSerializer<CitationCitedArtifactPartSurrogate> by lazy {
    CitationCitedArtifactPartSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Part", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Part =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Part) {
    surrogateSerializer.serialize(encoder, CitationCitedArtifactPartSurrogate.fromModel(value))
  }
}

public object CitationCitedArtifactRelatesToSerializer :
  KSerializer<Citation.CitedArtifact.RelatesTo> {
  internal val surrogateSerializer: KSerializer<CitationCitedArtifactRelatesToSurrogate> by lazy {
    CitationCitedArtifactRelatesToSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatesTo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.RelatesTo =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.RelatesTo) {
    surrogateSerializer.serialize(encoder, CitationCitedArtifactRelatesToSurrogate.fromModel(value))
  }
}

public object CitationCitedArtifactPublicationFormSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactPublicationFormSurrogate> by lazy {
    CitationCitedArtifactPublicationFormSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PublicationForm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.PublicationForm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.PublicationForm) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactPublicationFormSurrogate.fromModel(value),
    )
  }
}

public object CitationCitedArtifactPublicationFormPublishedInSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm.PublishedIn> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactPublicationFormPublishedInSurrogate> by lazy {
    CitationCitedArtifactPublicationFormPublishedInSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PublishedIn", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.PublicationForm.PublishedIn =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.PublicationForm.PublishedIn,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactPublicationFormPublishedInSurrogate.fromModel(value),
    )
  }
}

public object CitationCitedArtifactWebLocationSerializer :
  KSerializer<Citation.CitedArtifact.WebLocation> {
  internal val surrogateSerializer: KSerializer<CitationCitedArtifactWebLocationSurrogate> by lazy {
    CitationCitedArtifactWebLocationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("WebLocation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.WebLocation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.WebLocation) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactWebLocationSurrogate.fromModel(value),
    )
  }
}

public object CitationCitedArtifactClassificationSerializer :
  KSerializer<Citation.CitedArtifact.Classification> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactClassificationSurrogate> by lazy {
    CitationCitedArtifactClassificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Classification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Classification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Classification) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactClassificationSurrogate.fromModel(value),
    )
  }
}

public object CitationCitedArtifactContributorshipSerializer :
  KSerializer<Citation.CitedArtifact.Contributorship> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactContributorshipSurrogate> by lazy {
    CitationCitedArtifactContributorshipSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Contributorship", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Contributorship) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactContributorshipSurrogate.fromModel(value),
    )
  }
}

public object CitationCitedArtifactContributorshipEntrySerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Entry> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactContributorshipEntrySurrogate> by lazy {
    CitationCitedArtifactContributorshipEntrySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Entry", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship.Entry =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Contributorship.Entry) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactContributorshipEntrySurrogate.fromModel(value),
    )
  }
}

public object CitationCitedArtifactContributorshipEntryContributionInstanceSerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate> by lazy {
    CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ContributionInstance", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.Contributorship.Entry.ContributionInstance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Entry.ContributionInstance,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate.fromModel(value),
    )
  }
}

public object CitationCitedArtifactContributorshipSummarySerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Summary> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactContributorshipSummarySurrogate> by lazy {
    CitationCitedArtifactContributorshipSummarySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Summary", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship.Summary =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Summary,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactContributorshipSummarySurrogate.fromModel(value),
    )
  }
}

public object CitationVersionAlgorithmSerializer : KSerializer<Citation.VersionAlgorithm> {
  internal val surrogateSerializer: KSerializer<CitationVersionAlgorithmSurrogate> by lazy {
    CitationVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.VersionAlgorithm) {
    surrogateSerializer.serialize(encoder, CitationVersionAlgorithmSurrogate.fromModel(value))
  }
}

public object CitationSerializer : KSerializer<Citation> {
  internal val surrogateSerializer: KSerializer<CitationSurrogate> by lazy {
    CitationSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Citation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation {
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

  override fun serialize(encoder: Encoder, `value`: Citation) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CitationSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
