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

import com.google.fhir.model.r5.DeviceAssociation
import com.google.fhir.model.r5.surrogates.DeviceAssociationOperationSurrogate
import com.google.fhir.model.r5.surrogates.DeviceAssociationSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object DeviceAssociationOperationSerializer : KSerializer<DeviceAssociation.Operation> {
  internal val surrogateSerializer: KSerializer<DeviceAssociationOperationSurrogate> by lazy {
    DeviceAssociationOperationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Operation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceAssociation.Operation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceAssociation.Operation) {
    surrogateSerializer.serialize(encoder, DeviceAssociationOperationSurrogate.fromModel(value))
  }
}

public object DeviceAssociationSerializer : KSerializer<DeviceAssociation> {
  internal val surrogateSerializer: KSerializer<DeviceAssociationSurrogate> by lazy {
    DeviceAssociationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DeviceAssociation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceAssociation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceAssociation) {
    surrogateSerializer.serialize(encoder, DeviceAssociationSurrogate.fromModel(value))
  }
}
