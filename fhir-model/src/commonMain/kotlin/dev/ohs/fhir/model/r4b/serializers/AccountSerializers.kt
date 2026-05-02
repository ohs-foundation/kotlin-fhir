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

import com.google.fhir.model.r4b.Account
import com.google.fhir.model.r4b.surrogates.AccountCoverageSurrogate
import com.google.fhir.model.r4b.surrogates.AccountGuarantorSurrogate
import com.google.fhir.model.r4b.surrogates.AccountSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object AccountCoverageSerializer : KSerializer<Account.Coverage> {
  internal val surrogateSerializer: KSerializer<AccountCoverageSurrogate> by lazy {
    AccountCoverageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Coverage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Account.Coverage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Account.Coverage) {
    surrogateSerializer.serialize(encoder, AccountCoverageSurrogate.fromModel(value))
  }
}

public object AccountGuarantorSerializer : KSerializer<Account.Guarantor> {
  internal val surrogateSerializer: KSerializer<AccountGuarantorSurrogate> by lazy {
    AccountGuarantorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Guarantor", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Account.Guarantor =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Account.Guarantor) {
    surrogateSerializer.serialize(encoder, AccountGuarantorSurrogate.fromModel(value))
  }
}

public object AccountSerializer : KSerializer<Account> {
  internal val surrogateSerializer: KSerializer<AccountSurrogate> by lazy {
    AccountSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Account", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Account =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Account) {
    surrogateSerializer.serialize(encoder, AccountSurrogate.fromModel(value))
  }
}
