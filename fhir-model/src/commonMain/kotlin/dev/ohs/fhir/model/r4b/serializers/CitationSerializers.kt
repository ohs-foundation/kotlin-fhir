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

import com.google.fhir.model.r4b.Citation
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactAbstractSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactClassificationSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactClassificationWhoClassifiedSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactContributorshipEntrySurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactContributorshipSummarySurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactContributorshipSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactPartSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactPublicationFormPublishedInSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactPublicationFormSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactRelatesToSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactRelatesToTargetSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactStatusDateSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactTitleSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactVersionSurrogate
import com.google.fhir.model.r4b.surrogates.CitationCitedArtifactWebLocationSurrogate
import com.google.fhir.model.r4b.surrogates.CitationClassificationSurrogate
import com.google.fhir.model.r4b.surrogates.CitationRelatesToSurrogate
import com.google.fhir.model.r4b.surrogates.CitationRelatesToTargetSurrogate
import com.google.fhir.model.r4b.surrogates.CitationStatusDateSurrogate
import com.google.fhir.model.r4b.surrogates.CitationSummarySurrogate
import com.google.fhir.model.r4b.surrogates.CitationSurrogate
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

public object CitationRelatesToSerializer : KSerializer<Citation.RelatesTo> {
  internal val surrogateSerializer: KSerializer<CitationRelatesToSurrogate> by lazy {
    CitationRelatesToSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("target")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatesTo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.RelatesTo {
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

  override fun serialize(encoder: Encoder, `value`: Citation.RelatesTo) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CitationRelatesToSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
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

  private val multiChoiceProperties: List<String> = listOf("target")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatesTo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.RelatesTo {
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

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.RelatesTo) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CitationCitedArtifactRelatesToSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
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

public object CitationCitedArtifactPublicationFormPeriodicReleaseSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm.PeriodicRelease> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate> by lazy {
    CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PeriodicRelease", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.PublicationForm.PeriodicRelease =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.PublicationForm.PeriodicRelease,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate.fromModel(value),
    )
  }
}

public object CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication> {
  internal val surrogateSerializer:
    KSerializer<
      CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate
    > by lazy {
    CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DateOfPublication", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.fromModel(value),
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

public object CitationCitedArtifactClassificationWhoClassifiedSerializer :
  KSerializer<Citation.CitedArtifact.Classification.WhoClassified> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactClassificationWhoClassifiedSurrogate> by lazy {
    CitationCitedArtifactClassificationWhoClassifiedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("WhoClassified", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Classification.WhoClassified =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Classification.WhoClassified,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactClassificationWhoClassifiedSurrogate.fromModel(value),
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

public object CitationCitedArtifactContributorshipEntryAffiliationInfoSerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate> by lazy {
    CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AffiliationInfo", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate.fromModel(value),
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

public object CitationRelatesToTargetSerializer : KSerializer<Citation.RelatesTo.Target> {
  internal val surrogateSerializer: KSerializer<CitationRelatesToTargetSurrogate> by lazy {
    CitationRelatesToTargetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Target", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.RelatesTo.Target =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.RelatesTo.Target) {
    surrogateSerializer.serialize(encoder, CitationRelatesToTargetSurrogate.fromModel(value))
  }
}

public object CitationCitedArtifactRelatesToTargetSerializer :
  KSerializer<Citation.CitedArtifact.RelatesTo.Target> {
  internal val surrogateSerializer:
    KSerializer<CitationCitedArtifactRelatesToTargetSurrogate> by lazy {
    CitationCitedArtifactRelatesToTargetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Target", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.RelatesTo.Target =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.RelatesTo.Target) {
    surrogateSerializer.serialize(
      encoder,
      CitationCitedArtifactRelatesToTargetSurrogate.fromModel(value),
    )
  }
}

public object CitationSerializer : KSerializer<Citation> {
  internal val surrogateSerializer: KSerializer<CitationSurrogate> by lazy {
    CitationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Citation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Citation) {
    surrogateSerializer.serialize(encoder, CitationSurrogate.fromModel(value))
  }
}
