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

import com.google.fhir.model.r5.Consent
import com.google.fhir.model.r5.surrogates.ConsentPolicyBasisSurrogate
import com.google.fhir.model.r5.surrogates.ConsentProvisionActorSurrogate
import com.google.fhir.model.r5.surrogates.ConsentProvisionDataSurrogate
import com.google.fhir.model.r5.surrogates.ConsentProvisionSurrogate
import com.google.fhir.model.r5.surrogates.ConsentSurrogate
import com.google.fhir.model.r5.surrogates.ConsentVerificationSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ConsentPolicyBasisSerializer : KSerializer<Consent.PolicyBasis> {
  internal val surrogateSerializer: KSerializer<ConsentPolicyBasisSurrogate> by lazy {
    ConsentPolicyBasisSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PolicyBasis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.PolicyBasis =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.PolicyBasis) {
    surrogateSerializer.serialize(encoder, ConsentPolicyBasisSurrogate.fromModel(value))
  }
}

public object ConsentVerificationSerializer : KSerializer<Consent.Verification> {
  internal val surrogateSerializer: KSerializer<ConsentVerificationSurrogate> by lazy {
    ConsentVerificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Verification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Verification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Verification) {
    surrogateSerializer.serialize(encoder, ConsentVerificationSurrogate.fromModel(value))
  }
}

public object ConsentProvisionSerializer : KSerializer<Consent.Provision> {
  internal val surrogateSerializer: KSerializer<ConsentProvisionSurrogate> by lazy {
    ConsentProvisionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Provision", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Provision =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Provision) {
    surrogateSerializer.serialize(encoder, ConsentProvisionSurrogate.fromModel(value))
  }
}

public object ConsentProvisionActorSerializer : KSerializer<Consent.Provision.Actor> {
  internal val surrogateSerializer: KSerializer<ConsentProvisionActorSurrogate> by lazy {
    ConsentProvisionActorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Actor", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Provision.Actor =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Actor) {
    surrogateSerializer.serialize(encoder, ConsentProvisionActorSurrogate.fromModel(value))
  }
}

public object ConsentProvisionDataSerializer : KSerializer<Consent.Provision.Data> {
  internal val surrogateSerializer: KSerializer<ConsentProvisionDataSurrogate> by lazy {
    ConsentProvisionDataSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Data", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent.Provision.Data =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Data) {
    surrogateSerializer.serialize(encoder, ConsentProvisionDataSurrogate.fromModel(value))
  }
}

public object ConsentSerializer : KSerializer<Consent> {
  internal val surrogateSerializer: KSerializer<ConsentSurrogate> by lazy {
    ConsentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Consent", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Consent =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Consent) {
    surrogateSerializer.serialize(encoder, ConsentSurrogate.fromModel(value))
  }
}
