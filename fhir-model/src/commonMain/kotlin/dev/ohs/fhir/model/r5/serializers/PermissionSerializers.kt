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

import com.google.fhir.model.r5.Permission
import com.google.fhir.model.r5.surrogates.PermissionJustificationSurrogate
import com.google.fhir.model.r5.surrogates.PermissionRuleActivitySurrogate
import com.google.fhir.model.r5.surrogates.PermissionRuleDataResourceSurrogate
import com.google.fhir.model.r5.surrogates.PermissionRuleDataSurrogate
import com.google.fhir.model.r5.surrogates.PermissionRuleSurrogate
import com.google.fhir.model.r5.surrogates.PermissionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object PermissionJustificationSerializer : KSerializer<Permission.Justification> {
  internal val surrogateSerializer: KSerializer<PermissionJustificationSurrogate> by lazy {
    PermissionJustificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Justification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Permission.Justification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Permission.Justification) {
    surrogateSerializer.serialize(encoder, PermissionJustificationSurrogate.fromModel(value))
  }
}

public object PermissionRuleSerializer : KSerializer<Permission.Rule> {
  internal val surrogateSerializer: KSerializer<PermissionRuleSurrogate> by lazy {
    PermissionRuleSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Rule", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Permission.Rule =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Permission.Rule) {
    surrogateSerializer.serialize(encoder, PermissionRuleSurrogate.fromModel(value))
  }
}

public object PermissionRuleDataSerializer : KSerializer<Permission.Rule.Data> {
  internal val surrogateSerializer: KSerializer<PermissionRuleDataSurrogate> by lazy {
    PermissionRuleDataSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Data", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Permission.Rule.Data =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Data) {
    surrogateSerializer.serialize(encoder, PermissionRuleDataSurrogate.fromModel(value))
  }
}

public object PermissionRuleDataResourceSerializer : KSerializer<Permission.Rule.Data.Resource> {
  internal val surrogateSerializer: KSerializer<PermissionRuleDataResourceSurrogate> by lazy {
    PermissionRuleDataResourceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Resource", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Permission.Rule.Data.Resource =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Data.Resource) {
    surrogateSerializer.serialize(encoder, PermissionRuleDataResourceSurrogate.fromModel(value))
  }
}

public object PermissionRuleActivitySerializer : KSerializer<Permission.Rule.Activity> {
  internal val surrogateSerializer: KSerializer<PermissionRuleActivitySurrogate> by lazy {
    PermissionRuleActivitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Activity", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Permission.Rule.Activity =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Activity) {
    surrogateSerializer.serialize(encoder, PermissionRuleActivitySurrogate.fromModel(value))
  }
}

public object PermissionSerializer : KSerializer<Permission> {
  internal val surrogateSerializer: KSerializer<PermissionSurrogate> by lazy {
    PermissionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Permission", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Permission =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Permission) {
    surrogateSerializer.serialize(encoder, PermissionSurrogate.fromModel(value))
  }
}
