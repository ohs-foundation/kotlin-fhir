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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.MonetaryComponent
import dev.ohs.fhir.model.r5.Money
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object MonetaryComponentSerializer : KSerializer<MonetaryComponent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MonetaryComponent") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("type", String.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MonetaryComponent =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MonetaryComponent) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MonetaryComponent {
    var id: String? = null
    var extension: List<Extension>? = null
    var type: String? = null
    var _type: Element? = null
    var code: CodeableConcept? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var amount: Money? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(descriptor, i)
        3 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        6 ->
          _factor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MonetaryComponent: " + i)
      }
    }
    return MonetaryComponent(
      id = id,
      extension = extension ?: listOf(),
      type = Enumeration.of(MonetaryComponent.PriceComponentType.fromCode(type!!), _type),
      code = code,
      factor = Decimal.of(factor, _factor),
      amount = amount,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MonetaryComponent) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it) }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 5, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()
  }
}
