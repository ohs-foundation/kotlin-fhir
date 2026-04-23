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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object BiologicallyDerivedProductCollectionSerializer :
  KSerializer<BiologicallyDerivedProduct.Collection> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Collection") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("collector", Reference.serializer().descriptor, isOptional = true)
      element("source", Reference.serializer().descriptor, isOptional = true)
      element("collectedDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_collectedDateTime", Element.serializer().descriptor, isOptional = true)
      element("collectedPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Collection =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Collection) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): BiologicallyDerivedProduct.Collection {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var collector: Reference? = null
    var source: Reference? = null
    var collectedDateTime: KotlinString? = null
    var _collectedDateTime: Element? = null
    var collectedPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          collector =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.collectorSer, null)
        4 ->
          source = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.collectorSer, null)
        5 -> collectedDateTime = decoder.decodeStringElement(__desc, 5)
        6 ->
          _collectedDateTime =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.collectedDateTimeSer, null)
        7 ->
          collectedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.collectedPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Collection: " + __i)
      }
    }
    return BiologicallyDerivedProduct.Collection(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      collector = collector,
      source = source,
      collected =
        BiologicallyDerivedProduct.Collection.Collected.from(
          DateTime.of(FhirDateTime.fromString(collectedDateTime), _collectedDateTime),
          collectedPeriod,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProduct.Collection,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.collector)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.collectorSer, it)
    }
    (value.source)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.collectorSer, it) }
    when (val __d = value.collected) {
      null -> {}
      is BiologicallyDerivedProduct.Collection.Collected.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.collectedDateTimeSer, it)
        }
      }
      is BiologicallyDerivedProduct.Collection.Collected.Period -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.collectedPeriodSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val collectorSer: KSerializer<Reference> = Reference.serializer()

    public val collectedDateTimeSer: KSerializer<Element> = Element.serializer()

    public val collectedPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object BiologicallyDerivedProductPropertySerializer :
  KSerializer<BiologicallyDerivedProduct.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valuePeriod", Period.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): BiologicallyDerivedProduct.Property {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valuePeriod: Period? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueRatio: Ratio? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueAttachment: Attachment? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> valueBoolean = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueBooleanSer, null)
        6 -> valueInteger = decoder.decodeIntElement(__desc, 6)
        7 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueBooleanSer, null)
        8 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.typeSer, null)
        9 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valuePeriodSer, null)
        10 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueQuantitySer, null)
        11 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueRangeSer, null)
        12 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valueRatioSer, null)
        13 -> valueString = decoder.decodeStringElement(__desc, 13)
        14 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.valueBooleanSer, null)
        15 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return BiologicallyDerivedProduct.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        BiologicallyDerivedProduct.Property.Value.from(
          R5Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          valueCodeableConcept,
          valuePeriod,
          valueQuantity,
          valueRange,
          valueRatio,
          R5String.of(valueString, _valueString),
          valueAttachment,
        )!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProduct.Property,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is BiologicallyDerivedProduct.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.valueBooleanSer, it)
        }
      }
      is BiologicallyDerivedProduct.Property.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueBooleanSer, it)
        }
      }
      is BiologicallyDerivedProduct.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, __d.value)
      }
      is BiologicallyDerivedProduct.Property.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.valuePeriodSer, __d.value)
      }
      is BiologicallyDerivedProduct.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.valueQuantitySer, __d.value)
      }
      is BiologicallyDerivedProduct.Property.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.valueRangeSer, __d.value)
      }
      is BiologicallyDerivedProduct.Property.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.valueRatioSer, __d.value)
      }
      is BiologicallyDerivedProduct.Property.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.valueBooleanSer, it)
        }
      }
      is BiologicallyDerivedProduct.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 15, Hoisted.valueAttachmentSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueBooleanSer: KSerializer<Element> = Element.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object BiologicallyDerivedProductCollectionCollectedSerializer :
  KSerializer<BiologicallyDerivedProduct.Collection.Collected> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BiologicallyDerivedProduct.Collection.Collected") {
      element("collectedDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_collectedDateTime", Element.serializer().descriptor, isOptional = true)
      element("collectedPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: BiologicallyDerivedProduct.Collection.Collected,
  ) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is BiologicallyDerivedProduct.Collection.Collected.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is BiologicallyDerivedProduct.Collection.Collected.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.collectedPeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Collection.Collected =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): BiologicallyDerivedProduct.Collection.Collected {
    val __desc = descriptor
    var collectedDateTime: KotlinString? = null
    var _collectedDateTime: Element? = null
    var collectedPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> collectedDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _collectedDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          collectedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.collectedPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding BiologicallyDerivedProduct.Collection.Collected: " + __i
          )
      }
    }
    return BiologicallyDerivedProduct.Collection.Collected.from(
      DateTime.of(FhirDateTime.fromString(collectedDateTime), _collectedDateTime),
      collectedPeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val collectedPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object BiologicallyDerivedProductPropertyValueSerializer :
  KSerializer<BiologicallyDerivedProduct.Property.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BiologicallyDerivedProduct.Property.Value") {
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valuePeriod", Period.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Property.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is BiologicallyDerivedProduct.Property.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is BiologicallyDerivedProduct.Property.Value.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is BiologicallyDerivedProduct.Property.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 4, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Period -> {
          encodeSerializableElement(__desc, 5, Hoisted.valuePeriodSer, __d.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Quantity -> {
          encodeSerializableElement(__desc, 6, Hoisted.valueQuantitySer, __d.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Range -> {
          encodeSerializableElement(__desc, 7, Hoisted.valueRangeSer, __d.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Ratio -> {
          encodeSerializableElement(__desc, 8, Hoisted.valueRatioSer, __d.value)
        }
        is BiologicallyDerivedProduct.Property.Value.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 9, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 10, Hoisted.elementSer, it)
          }
        }
        is BiologicallyDerivedProduct.Property.Value.Attachment -> {
          encodeSerializableElement(__desc, 11, Hoisted.valueAttachmentSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Property.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): BiologicallyDerivedProduct.Property.Value {
    val __desc = descriptor
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valuePeriod: Period? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueRatio: Ratio? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueAttachment: Attachment? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> valueBoolean = decoder.decodeBooleanElement(__desc, 0)
        1 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> valueInteger = decoder.decodeIntElement(__desc, 2)
        3 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        5 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valuePeriodSer, null)
        6 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueQuantitySer, null)
        7 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueRangeSer, null)
        8 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueRatioSer, null)
        9 -> valueString = decoder.decodeStringElement(__desc, 9)
        10 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.elementSer, null)
        11 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding BiologicallyDerivedProduct.Property.Value: " + __i
          )
      }
    }
    return BiologicallyDerivedProduct.Property.Value.from(
      R5Boolean.of(valueBoolean, _valueBoolean),
      Integer.of(valueInteger, _valueInteger),
      valueCodeableConcept,
      valuePeriod,
      valueQuantity,
      valueRange,
      valueRatio,
      R5String.of(valueString, _valueString),
      valueAttachment,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object BiologicallyDerivedProductSerializer : KSerializer<BiologicallyDerivedProduct> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BiologicallyDerivedProduct") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("productCategory", Coding.serializer().descriptor, isOptional = true)
      element("productCode", CodeableConcept.serializer().descriptor, isOptional = true)
      element("parent", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("request", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("biologicalSourceEvent", Identifier.serializer().descriptor, isOptional = true)
      element(
        "processingFacility",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("division", KotlinString.serializer().descriptor, isOptional = true)
      element("_division", Element.serializer().descriptor, isOptional = true)
      element("productStatus", Coding.serializer().descriptor, isOptional = true)
      element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_expirationDate", Element.serializer().descriptor, isOptional = true)
      element(
        "collection",
        lazyDescriptor { BiologicallyDerivedProduct.Collection.serializer().descriptor },
        isOptional = true,
      )
      element("storageTempRequirements", Range.serializer().descriptor, isOptional = true)
      element(
        "property",
        listSerialDescriptor(
          lazyDescriptor { BiologicallyDerivedProduct.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): BiologicallyDerivedProduct {
    val __desc = descriptor
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productCategory: Coding? = null
    var productCode: CodeableConcept? = null
    var parent: List<Reference>? = null
    var request: List<Reference>? = null
    var identifier: List<Identifier>? = null
    var biologicalSourceEvent: Identifier? = null
    var processingFacility: List<Reference>? = null
    var division: KotlinString? = null
    var _division: Element? = null
    var productStatus: Coding? = null
    var expirationDate: KotlinString? = null
    var _expirationDate: Element? = null
    var collection: BiologicallyDerivedProduct.Collection? = null
    var storageTempRequirements: Range? = null
    var `property`: List<BiologicallyDerivedProduct.Property>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          productCategory =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.productCategorySer, null)
        12 ->
          productCode =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.productCodeSer, null)
        13 ->
          parent = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.parentSer, null)
        14 ->
          request = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.parentSer, null)
        15 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.identifierSer, null)
        16 ->
          biologicalSourceEvent =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.identifierSerInner, null)
        17 ->
          processingFacility =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.parentSer, null)
        18 -> division = decoder.decodeStringElement(__desc, 18)
        19 ->
          _division =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          productStatus =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.productCategorySer, null)
        21 -> expirationDate = decoder.decodeStringElement(__desc, 21)
        22 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          collection =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.collectionSer, null)
        24 ->
          storageTempRequirements =
            decoder.decodeNullableSerializableElement(
              __desc,
              24,
              Hoisted.storageTempRequirementsSer,
              null,
            )
        25 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.propertySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding BiologicallyDerivedProduct: " + __i
          )
      }
    }
    return BiologicallyDerivedProduct(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productCategory = productCategory,
      productCode = productCode,
      parent = parent ?: listOf(),
      request = request ?: listOf(),
      identifier = identifier ?: listOf(),
      biologicalSourceEvent = biologicalSourceEvent,
      processingFacility = processingFacility ?: listOf(),
      division = R5String.of(division, _division),
      productStatus = productStatus,
      expirationDate = DateTime.of(FhirDateTime.fromString(expirationDate), _expirationDate),
      collection = collection,
      storageTempRequirements = storageTempRequirements,
      `property` = `property` ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: BiologicallyDerivedProduct) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "BiologicallyDerivedProduct")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    (value.productCategory)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.productCategorySer, it)
    }
    (value.productCode)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.productCodeSer, it)
    }
    if (value.parent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.parentSer, value.parent)
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.parentSer, value.request)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.identifierSer, value.identifier)
    (value.biologicalSourceEvent)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.identifierSerInner, it)
    }
    if (value.processingFacility.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.parentSer, value.processingFacility)
    ((value.division?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.division?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    (value.productStatus)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.productCategorySer, it)
    }
    ((value.expirationDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    (value.collection)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.collectionSer, it)
    }
    (value.storageTempRequirements)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.storageTempRequirementsSer, it)
    }
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.propertySer, value.`property`)
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productCategorySer: KSerializer<Coding> = Coding.serializer()

    public val productCodeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val parentSerInner: KSerializer<Reference> = Reference.serializer()

    public val parentSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.parentSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val collectionSer: KSerializer<BiologicallyDerivedProduct.Collection> =
      BiologicallyDerivedProduct.Collection.serializer()

    public val storageTempRequirementsSer: KSerializer<Range> = Range.serializer()

    public val propertySerInner: KSerializer<BiologicallyDerivedProduct.Property> =
      BiologicallyDerivedProduct.Property.serializer()

    public val propertySer: KSerializer<List<BiologicallyDerivedProduct.Property>> =
      ListSerializer(Hoisted.propertySerInner)
  }
}
