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

import com.google.fhir.model.r5.Organization
import com.google.fhir.model.r5.surrogates.OrganizationQualificationSurrogate
import com.google.fhir.model.r5.surrogates.OrganizationSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object OrganizationQualificationSerializer : KSerializer<Organization.Qualification> {
  internal val surrogateSerializer: KSerializer<OrganizationQualificationSurrogate> by lazy {
    OrganizationQualificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Qualification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Organization.Qualification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Organization.Qualification) {
    surrogateSerializer.serialize(encoder, OrganizationQualificationSurrogate.fromModel(value))
  }
}

public object OrganizationSerializer : KSerializer<Organization> {
  internal val surrogateSerializer: KSerializer<OrganizationSurrogate> by lazy {
    OrganizationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Organization", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Organization =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Organization) {
    surrogateSerializer.serialize(encoder, OrganizationSurrogate.fromModel(value))
  }
}
