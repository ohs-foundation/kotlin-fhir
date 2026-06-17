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
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Collection) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): BiologicallyDerivedProduct.Collection {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var collector: Reference? = null
    var source: Reference? = null
    var collectedDateTime: KotlinString? = null
    var _collectedDateTime: Element? = null
    var collectedPeriod: Period? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          collector =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.collectorSer, null)
        4 ->
          source =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.collectorSer, null)
        5 -> collectedDateTime = decoder.decodeStringElement(descriptor, i)
        6 ->
          _collectedDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.collectedDateTimeSer,
              null,
            )
        7 ->
          collectedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.collectedPeriodSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Collection: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProduct.Collection,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.collector)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.collectorSer, it)
    }
    (value.source)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.collectorSer, it)
    }
    when (val choice = value.collected) {
      null -> {}
      is BiologicallyDerivedProduct.Collection.Collected.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.collectedDateTimeSer, it)
        }
      }
      is BiologicallyDerivedProduct.Collection.Collected.Period -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.collectedPeriodSer, choice.value)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Property) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): BiologicallyDerivedProduct.Property {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        6 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        7 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        8 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        9 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        10 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        11 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        12 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        13 -> valueString = decoder.decodeStringElement(descriptor, i)
        14 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        15 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProduct.Property,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.`value`) {
      is BiologicallyDerivedProduct.Property.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueBooleanSer, it)
        }
      }
      is BiologicallyDerivedProduct.Property.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueBooleanSer, it)
        }
      }
      is BiologicallyDerivedProduct.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, choice.value)
      }
      is BiologicallyDerivedProduct.Property.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.valuePeriodSer, choice.value)
      }
      is BiologicallyDerivedProduct.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueQuantitySer, choice.value)
      }
      is BiologicallyDerivedProduct.Property.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueRangeSer, choice.value)
      }
      is BiologicallyDerivedProduct.Property.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueRatioSer, choice.value)
      }
      is BiologicallyDerivedProduct.Property.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.valueBooleanSer, it)
        }
      }
      is BiologicallyDerivedProduct.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 15, Hoisted.valueAttachmentSer, choice.value)
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

internal object BiologicallyDerivedProductSerializer : KSerializer<BiologicallyDerivedProduct> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BiologicallyDerivedProduct") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("productCategory", Coding.serializer().descriptor, isOptional = true)
    b.element("productCode", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("parent", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("request", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("biologicalSourceEvent", Identifier.serializer().descriptor, isOptional = true)
    b.element(
      "processingFacility",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("division", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_division", Element.serializer().descriptor, isOptional = true)
    b.element("productStatus", Coding.serializer().descriptor, isOptional = true)
    b.element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_expirationDate", Element.serializer().descriptor, isOptional = true)
    b.element(
      "collection",
      lazyDescriptor { BiologicallyDerivedProduct.Collection.serializer().descriptor },
      isOptional = true,
    )
    b.element("storageTempRequirements", Range.serializer().descriptor, isOptional = true)
    b.element(
      "property",
      listSerialDescriptor(
        lazyDescriptor { BiologicallyDerivedProduct.Property.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "BiologicallyDerivedProduct")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): BiologicallyDerivedProduct {
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          productCategory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.productCategorySer,
              null,
            )
        11 ->
          productCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.productCodeSer, null)
        12 ->
          parent = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parentSer, null)
        13 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parentSer, null)
        14 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        15 ->
          biologicalSourceEvent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        16 ->
          processingFacility =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parentSer, null)
        17 -> division = decoder.decodeStringElement(descriptor, i)
        18 ->
          _division =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          productStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.productCategorySer,
              null,
            )
        20 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        21 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 ->
          collection =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.collectionSer, null)
        23 ->
          storageTempRequirements =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.storageTempRequirementsSer,
              null,
            )
        24 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        else ->
          throw SerializationException("Unexpected index decoding BiologicallyDerivedProduct: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: BiologicallyDerivedProduct,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.productCategory)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.productCategorySer,
        it,
      )
    }
    (value.productCode)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.productCodeSer,
        it,
      )
    }
    if (value.parent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.parentSer,
        value.parent,
      )
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.parentSer,
        value.request,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    (value.biologicalSourceEvent)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    if (value.processingFacility.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.parentSer,
        value.processingFacility,
      )
    ((value.division?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.division?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.productStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.productCategorySer,
        it,
      )
    }
    ((value.expirationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.collection)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.collectionSer,
        it,
      )
    }
    (value.storageTempRequirements)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.storageTempRequirementsSer,
        it,
      )
    }
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.propertySer,
        value.`property`,
      )
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

internal object BiologicallyDerivedProductPolymorphicSerializer :
  KSerializer<BiologicallyDerivedProduct> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BiologicallyDerivedProduct") {
      BiologicallyDerivedProductSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct) {
    encoder.encodeStructure(descriptor) {
      BiologicallyDerivedProductSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct =
    decoder.decodeStructure(descriptor) {
      BiologicallyDerivedProductSerializer.deserializeInternal(this, descriptor, 0)
    }
}
