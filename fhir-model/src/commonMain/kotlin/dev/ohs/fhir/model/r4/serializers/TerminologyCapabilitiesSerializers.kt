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

import com.google.fhir.model.r4.TerminologyCapabilities
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesClosureSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesCodeSystemSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesCodeSystemVersionFilterSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesCodeSystemVersionSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesExpansionParameterSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesExpansionSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesImplementationSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesSoftwareSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesTranslationSurrogate
import com.google.fhir.model.r4.surrogates.TerminologyCapabilitiesValidateCodeSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object TerminologyCapabilitiesSoftwareSerializer :
  KSerializer<TerminologyCapabilities.Software> {
  internal val surrogateSerializer: KSerializer<TerminologyCapabilitiesSoftwareSurrogate> by lazy {
    TerminologyCapabilitiesSoftwareSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Software", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Software =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Software) {
    surrogateSerializer.serialize(
      encoder,
      TerminologyCapabilitiesSoftwareSurrogate.fromModel(value),
    )
  }
}

public object TerminologyCapabilitiesImplementationSerializer :
  KSerializer<TerminologyCapabilities.Implementation> {
  internal val surrogateSerializer:
    KSerializer<TerminologyCapabilitiesImplementationSurrogate> by lazy {
    TerminologyCapabilitiesImplementationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Implementation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Implementation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Implementation) {
    surrogateSerializer.serialize(
      encoder,
      TerminologyCapabilitiesImplementationSurrogate.fromModel(value),
    )
  }
}

public object TerminologyCapabilitiesCodeSystemSerializer :
  KSerializer<TerminologyCapabilities.CodeSystem> {
  internal val surrogateSerializer:
    KSerializer<TerminologyCapabilitiesCodeSystemSurrogate> by lazy {
    TerminologyCapabilitiesCodeSystemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CodeSystem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem) {
    surrogateSerializer.serialize(
      encoder,
      TerminologyCapabilitiesCodeSystemSurrogate.fromModel(value),
    )
  }
}

public object TerminologyCapabilitiesCodeSystemVersionSerializer :
  KSerializer<TerminologyCapabilities.CodeSystem.Version> {
  internal val surrogateSerializer:
    KSerializer<TerminologyCapabilitiesCodeSystemVersionSurrogate> by lazy {
    TerminologyCapabilitiesCodeSystemVersionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Version", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem.Version) {
    surrogateSerializer.serialize(
      encoder,
      TerminologyCapabilitiesCodeSystemVersionSurrogate.fromModel(value),
    )
  }
}

public object TerminologyCapabilitiesCodeSystemVersionFilterSerializer :
  KSerializer<TerminologyCapabilities.CodeSystem.Version.Filter> {
  internal val surrogateSerializer:
    KSerializer<TerminologyCapabilitiesCodeSystemVersionFilterSurrogate> by lazy {
    TerminologyCapabilitiesCodeSystemVersionFilterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Filter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version.Filter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: TerminologyCapabilities.CodeSystem.Version.Filter,
  ) {
    surrogateSerializer.serialize(
      encoder,
      TerminologyCapabilitiesCodeSystemVersionFilterSurrogate.fromModel(value),
    )
  }
}

public object TerminologyCapabilitiesExpansionSerializer :
  KSerializer<TerminologyCapabilities.Expansion> {
  internal val surrogateSerializer: KSerializer<TerminologyCapabilitiesExpansionSurrogate> by lazy {
    TerminologyCapabilitiesExpansionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Expansion", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion) {
    surrogateSerializer.serialize(
      encoder,
      TerminologyCapabilitiesExpansionSurrogate.fromModel(value),
    )
  }
}

public object TerminologyCapabilitiesExpansionParameterSerializer :
  KSerializer<TerminologyCapabilities.Expansion.Parameter> {
  internal val surrogateSerializer:
    KSerializer<TerminologyCapabilitiesExpansionParameterSurrogate> by lazy {
    TerminologyCapabilitiesExpansionParameterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Parameter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion.Parameter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion.Parameter) {
    surrogateSerializer.serialize(
      encoder,
      TerminologyCapabilitiesExpansionParameterSurrogate.fromModel(value),
    )
  }
}

public object TerminologyCapabilitiesValidateCodeSerializer :
  KSerializer<TerminologyCapabilities.ValidateCode> {
  internal val surrogateSerializer:
    KSerializer<TerminologyCapabilitiesValidateCodeSurrogate> by lazy {
    TerminologyCapabilitiesValidateCodeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ValidateCode", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.ValidateCode =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.ValidateCode) {
    surrogateSerializer.serialize(
      encoder,
      TerminologyCapabilitiesValidateCodeSurrogate.fromModel(value),
    )
  }
}

public object TerminologyCapabilitiesTranslationSerializer :
  KSerializer<TerminologyCapabilities.Translation> {
  internal val surrogateSerializer:
    KSerializer<TerminologyCapabilitiesTranslationSurrogate> by lazy {
    TerminologyCapabilitiesTranslationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Translation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Translation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Translation) {
    surrogateSerializer.serialize(
      encoder,
      TerminologyCapabilitiesTranslationSurrogate.fromModel(value),
    )
  }
}

public object TerminologyCapabilitiesClosureSerializer :
  KSerializer<TerminologyCapabilities.Closure> {
  internal val surrogateSerializer: KSerializer<TerminologyCapabilitiesClosureSurrogate> by lazy {
    TerminologyCapabilitiesClosureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Closure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Closure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Closure) {
    surrogateSerializer.serialize(encoder, TerminologyCapabilitiesClosureSurrogate.fromModel(value))
  }
}

public object TerminologyCapabilitiesSerializer : KSerializer<TerminologyCapabilities> {
  internal val surrogateSerializer: KSerializer<TerminologyCapabilitiesSurrogate> by lazy {
    TerminologyCapabilitiesSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TerminologyCapabilities", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities) {
    surrogateSerializer.serialize(encoder, TerminologyCapabilitiesSurrogate.fromModel(value))
  }
}
