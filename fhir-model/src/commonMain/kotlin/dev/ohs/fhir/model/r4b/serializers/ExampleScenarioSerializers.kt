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

import com.google.fhir.model.r4b.ExampleScenario
import com.google.fhir.model.r4b.surrogates.ExampleScenarioActorSurrogate
import com.google.fhir.model.r4b.surrogates.ExampleScenarioInstanceContainedInstanceSurrogate
import com.google.fhir.model.r4b.surrogates.ExampleScenarioInstanceSurrogate
import com.google.fhir.model.r4b.surrogates.ExampleScenarioInstanceVersionSurrogate
import com.google.fhir.model.r4b.surrogates.ExampleScenarioProcessStepAlternativeSurrogate
import com.google.fhir.model.r4b.surrogates.ExampleScenarioProcessStepOperationSurrogate
import com.google.fhir.model.r4b.surrogates.ExampleScenarioProcessStepSurrogate
import com.google.fhir.model.r4b.surrogates.ExampleScenarioProcessSurrogate
import com.google.fhir.model.r4b.surrogates.ExampleScenarioSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ExampleScenarioActorSerializer : KSerializer<ExampleScenario.Actor> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioActorSurrogate> by lazy {
    ExampleScenarioActorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Actor", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Actor =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Actor) {
    surrogateSerializer.serialize(encoder, ExampleScenarioActorSurrogate.fromModel(value))
  }
}

public object ExampleScenarioInstanceSerializer : KSerializer<ExampleScenario.Instance> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioInstanceSurrogate> by lazy {
    ExampleScenarioInstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Instance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance) {
    surrogateSerializer.serialize(encoder, ExampleScenarioInstanceSurrogate.fromModel(value))
  }
}

public object ExampleScenarioInstanceVersionSerializer :
  KSerializer<ExampleScenario.Instance.Version> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioInstanceVersionSurrogate> by lazy {
    ExampleScenarioInstanceVersionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Version", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.Version =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.Version) {
    surrogateSerializer.serialize(encoder, ExampleScenarioInstanceVersionSurrogate.fromModel(value))
  }
}

public object ExampleScenarioInstanceContainedInstanceSerializer :
  KSerializer<ExampleScenario.Instance.ContainedInstance> {
  internal val surrogateSerializer:
    KSerializer<ExampleScenarioInstanceContainedInstanceSurrogate> by lazy {
    ExampleScenarioInstanceContainedInstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ContainedInstance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.ContainedInstance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.ContainedInstance) {
    surrogateSerializer.serialize(
      encoder,
      ExampleScenarioInstanceContainedInstanceSurrogate.fromModel(value),
    )
  }
}

public object ExampleScenarioProcessSerializer : KSerializer<ExampleScenario.Process> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioProcessSurrogate> by lazy {
    ExampleScenarioProcessSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Process", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process) {
    surrogateSerializer.serialize(encoder, ExampleScenarioProcessSurrogate.fromModel(value))
  }
}

public object ExampleScenarioProcessStepSerializer : KSerializer<ExampleScenario.Process.Step> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioProcessStepSurrogate> by lazy {
    ExampleScenarioProcessStepSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Step", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step) {
    surrogateSerializer.serialize(encoder, ExampleScenarioProcessStepSurrogate.fromModel(value))
  }
}

public object ExampleScenarioProcessStepOperationSerializer :
  KSerializer<ExampleScenario.Process.Step.Operation> {
  internal val surrogateSerializer:
    KSerializer<ExampleScenarioProcessStepOperationSurrogate> by lazy {
    ExampleScenarioProcessStepOperationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Operation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Operation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step.Operation) {
    surrogateSerializer.serialize(
      encoder,
      ExampleScenarioProcessStepOperationSurrogate.fromModel(value),
    )
  }
}

public object ExampleScenarioProcessStepAlternativeSerializer :
  KSerializer<ExampleScenario.Process.Step.Alternative> {
  internal val surrogateSerializer:
    KSerializer<ExampleScenarioProcessStepAlternativeSurrogate> by lazy {
    ExampleScenarioProcessStepAlternativeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Alternative", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Alternative =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step.Alternative) {
    surrogateSerializer.serialize(
      encoder,
      ExampleScenarioProcessStepAlternativeSurrogate.fromModel(value),
    )
  }
}

public object ExampleScenarioSerializer : KSerializer<ExampleScenario> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioSurrogate> by lazy {
    ExampleScenarioSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ExampleScenario", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario) {
    surrogateSerializer.serialize(encoder, ExampleScenarioSurrogate.fromModel(value))
  }
}
