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

import com.google.fhir.model.r4.MeasureReport
import com.google.fhir.model.r4.surrogates.MeasureReportGroupPopulationSurrogate
import com.google.fhir.model.r4.surrogates.MeasureReportGroupStratifierStratumComponentSurrogate
import com.google.fhir.model.r4.surrogates.MeasureReportGroupStratifierStratumPopulationSurrogate
import com.google.fhir.model.r4.surrogates.MeasureReportGroupStratifierStratumSurrogate
import com.google.fhir.model.r4.surrogates.MeasureReportGroupStratifierSurrogate
import com.google.fhir.model.r4.surrogates.MeasureReportGroupSurrogate
import com.google.fhir.model.r4.surrogates.MeasureReportSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object MeasureReportGroupSerializer : KSerializer<MeasureReport.Group> {
  internal val surrogateSerializer: KSerializer<MeasureReportGroupSurrogate> by lazy {
    MeasureReportGroupSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Group", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group) {
    surrogateSerializer.serialize(encoder, MeasureReportGroupSurrogate.fromModel(value))
  }
}

public object MeasureReportGroupPopulationSerializer : KSerializer<MeasureReport.Group.Population> {
  internal val surrogateSerializer: KSerializer<MeasureReportGroupPopulationSurrogate> by lazy {
    MeasureReportGroupPopulationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Population", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Population =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Population) {
    surrogateSerializer.serialize(encoder, MeasureReportGroupPopulationSurrogate.fromModel(value))
  }
}

public object MeasureReportGroupStratifierSerializer : KSerializer<MeasureReport.Group.Stratifier> {
  internal val surrogateSerializer: KSerializer<MeasureReportGroupStratifierSurrogate> by lazy {
    MeasureReportGroupStratifierSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Stratifier", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier) {
    surrogateSerializer.serialize(encoder, MeasureReportGroupStratifierSurrogate.fromModel(value))
  }
}

public object MeasureReportGroupStratifierStratumSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum> {
  internal val surrogateSerializer:
    KSerializer<MeasureReportGroupStratifierStratumSurrogate> by lazy {
    MeasureReportGroupStratifierStratumSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Stratum", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier.Stratum) {
    surrogateSerializer.serialize(
      encoder,
      MeasureReportGroupStratifierStratumSurrogate.fromModel(value),
    )
  }
}

public object MeasureReportGroupStratifierStratumComponentSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Component> {
  internal val surrogateSerializer:
    KSerializer<MeasureReportGroupStratifierStratumComponentSurrogate> by lazy {
    MeasureReportGroupStratifierStratumComponentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Component", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Component =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MeasureReportGroupStratifierStratumComponentSurrogate.fromModel(value),
    )
  }
}

public object MeasureReportGroupStratifierStratumPopulationSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Population> {
  internal val surrogateSerializer:
    KSerializer<MeasureReportGroupStratifierStratumPopulationSurrogate> by lazy {
    MeasureReportGroupStratifierStratumPopulationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Population", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Population =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MeasureReportGroupStratifierStratumPopulationSurrogate.fromModel(value),
    )
  }
}

public object MeasureReportSerializer : KSerializer<MeasureReport> {
  internal val surrogateSerializer: KSerializer<MeasureReportSurrogate> by lazy {
    MeasureReportSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MeasureReport", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport) {
    surrogateSerializer.serialize(encoder, MeasureReportSurrogate.fromModel(value))
  }
}
