/*
 * Copyright 2026 Open Health Stack Foundation
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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.IdentifierUse
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object IdentifierSerializer : FhirSerializer<Identifier> {
  override val descriptor: SerialDescriptor = buildDescriptor("Identifier", this)

  @JvmField internal val listSerializer: KSerializer<List<Identifier>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("use")
    b.optionalElement("type", lazyDescriptor(LazyDescriptorId.CodeableConceptSerializer))
    b.strPrim("system")
    b.strPrim("value")
    b.optionalElement("period", lazyDescriptor(LazyDescriptorId.PeriodSerializer))
    b.optionalElement("assigner", lazyDescriptor(LazyDescriptorId.ReferenceSerializer))
  }

  override fun deserialize(decoder: Decoder): Identifier {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var use: IdentifierUse? = null
    var _use: Element? = null
    var type: CodeableConcept? = null
    var system: KotlinString? = null
    var _system: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var period: Period? = null
    var assigner: Reference? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> use = IdentifierUse.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        3 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> system = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        10 ->
          assigner =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Identifier(
      id = id,
      extension = listOrEmpty(extension),
      use = Enumeration.of(use, _use),
      type = type,
      system = Uri.of(system, _system),
      `value` = R4String.of(`value`, _value),
      period = period,
      assigner = assigner,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Identifier) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.use?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.use)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.system?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.system)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.`value`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.`value`)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 9, PeriodSerializer, value.period)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      ReferenceSerializer,
      value.assigner,
    )
    compositeEncoder.endStructure(descriptor)
  }
}
