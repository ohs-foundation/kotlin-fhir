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

import com.google.fhir.model.r5.Account
import com.google.fhir.model.r5.surrogates.AccountBalanceSurrogate
import com.google.fhir.model.r5.surrogates.AccountCoverageSurrogate
import com.google.fhir.model.r5.surrogates.AccountDiagnosisSurrogate
import com.google.fhir.model.r5.surrogates.AccountGuarantorSurrogate
import com.google.fhir.model.r5.surrogates.AccountProcedureSurrogate
import com.google.fhir.model.r5.surrogates.AccountRelatedAccountSurrogate
import com.google.fhir.model.r5.surrogates.AccountSurrogate
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

public object AccountDiagnosisSerializer : KSerializer<Account.Diagnosis> {
  internal val surrogateSerializer: KSerializer<AccountDiagnosisSurrogate> by lazy {
    AccountDiagnosisSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Diagnosis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Account.Diagnosis =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Account.Diagnosis) {
    surrogateSerializer.serialize(encoder, AccountDiagnosisSurrogate.fromModel(value))
  }
}

public object AccountProcedureSerializer : KSerializer<Account.Procedure> {
  internal val surrogateSerializer: KSerializer<AccountProcedureSurrogate> by lazy {
    AccountProcedureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Procedure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Account.Procedure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Account.Procedure) {
    surrogateSerializer.serialize(encoder, AccountProcedureSurrogate.fromModel(value))
  }
}

public object AccountRelatedAccountSerializer : KSerializer<Account.RelatedAccount> {
  internal val surrogateSerializer: KSerializer<AccountRelatedAccountSurrogate> by lazy {
    AccountRelatedAccountSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatedAccount", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Account.RelatedAccount =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Account.RelatedAccount) {
    surrogateSerializer.serialize(encoder, AccountRelatedAccountSurrogate.fromModel(value))
  }
}

public object AccountBalanceSerializer : KSerializer<Account.Balance> {
  internal val surrogateSerializer: KSerializer<AccountBalanceSurrogate> by lazy {
    AccountBalanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Balance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Account.Balance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Account.Balance) {
    surrogateSerializer.serialize(encoder, AccountBalanceSurrogate.fromModel(value))
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
