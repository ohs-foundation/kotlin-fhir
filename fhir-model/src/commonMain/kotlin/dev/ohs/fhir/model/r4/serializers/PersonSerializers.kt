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

import com.google.fhir.model.r4.Person
import com.google.fhir.model.r4.surrogates.PersonLinkSurrogate
import com.google.fhir.model.r4.surrogates.PersonSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object PersonLinkSerializer : KSerializer<Person.Link> {
  internal val surrogateSerializer: KSerializer<PersonLinkSurrogate> by lazy {
    PersonLinkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Link", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Person.Link =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Person.Link) {
    surrogateSerializer.serialize(encoder, PersonLinkSurrogate.fromModel(value))
  }
}

public object PersonSerializer : KSerializer<Person> {
  internal val surrogateSerializer: KSerializer<PersonSurrogate> by lazy {
    PersonSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Person", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Person =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Person) {
    surrogateSerializer.serialize(encoder, PersonSurrogate.fromModel(value))
  }
}
