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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
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
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("collector", ReferenceSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.descriptor)
      optionalElement("collectedDateTime", KotlinString.serializer().descriptor)
      optionalElement("_collectedDateTime", ElementSerializer.descriptor)
      optionalElement("collectedPeriod", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<BiologicallyDerivedProduct.Collection>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Collection =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var collector: Reference? = null
      var source: Reference? = null
      var collectedDateTime: KotlinString? = null
      var _collectedDateTime: Element? = null
      var collectedPeriod: Period? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            collector = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> source = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 -> collectedDateTime = decodeStringElement(descriptor, i)
          6 ->
            _collectedDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            collectedPeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Collection: " + i)
        }
      }
      BiologicallyDerivedProduct.Collection(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        collector = collector,
        source = source,
        collected =
          BiologicallyDerivedProduct.Collection.Collected.from(
            DateTime.of(
              if (collectedDateTime != null) FhirDateTime.fromString(collectedDateTime) else null,
              _collectedDateTime,
            ),
            collectedPeriod,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Collection) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.collector)
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.source)
      when (val choice = value.collected) {
        null -> {}
        is BiologicallyDerivedProduct.Collection.Collected.DateTime -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is BiologicallyDerivedProduct.Collection.Collected.Period -> {
          encodeSerializableElement(descriptor, 7, PeriodSerializer, choice.value)
        }
      }
    }
  }
}

internal object BiologicallyDerivedProductPropertySerializer :
  KSerializer<BiologicallyDerivedProduct.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valuePeriod", PeriodSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueRatio", RatioSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<BiologicallyDerivedProduct.Property>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Property =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> valueBoolean = decodeBooleanElement(descriptor, i)
          5 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> valueInteger = decodeIntElement(descriptor, i)
          7 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          10 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          11 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          12 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          13 -> valueString = decodeStringElement(descriptor, i)
          14 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Property: " + i)
        }
      }
      BiologicallyDerivedProduct.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on BiologicallyDerivedProduct.Property"
            ),
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
          )
            ?: throw SerializationException(
              "Missing required property 'value' on BiologicallyDerivedProduct.Property"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Property) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        is BiologicallyDerivedProduct.Property.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is BiologicallyDerivedProduct.Property.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, choice.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Period -> {
          encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Quantity -> {
          encodeSerializableElement(descriptor, 10, QuantitySerializer, choice.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Range -> {
          encodeSerializableElement(descriptor, 11, RangeSerializer, choice.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Ratio -> {
          encodeSerializableElement(descriptor, 12, RatioSerializer, choice.value)
        }
        is BiologicallyDerivedProduct.Property.Value.String -> {
          encodeStringIfNotNull(descriptor, 13, choice.value.value)
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
        is BiologicallyDerivedProduct.Property.Value.Attachment -> {
          encodeSerializableElement(descriptor, 15, AttachmentSerializer, choice.value)
        }
      }
    }
  }
}

internal object BiologicallyDerivedProductSerializer :
  FhirResourceSerializer<BiologicallyDerivedProduct> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("BiologicallyDerivedProduct")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("productCategory", CodingSerializer.descriptor)
    b.optionalElement("productCode", CodeableConceptSerializer.descriptor)
    b.optionalElement("parent", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("biologicalSourceEvent", IdentifierSerializer.descriptor)
    b.optionalElement("processingFacility", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("division", KotlinString.serializer().descriptor)
    b.optionalElement("_division", ElementSerializer.descriptor)
    b.optionalElement("productStatus", CodingSerializer.descriptor)
    b.optionalElement("expirationDate", KotlinString.serializer().descriptor)
    b.optionalElement("_expirationDate", ElementSerializer.descriptor)
    b.optionalElement("collection", BiologicallyDerivedProductCollectionSerializer.descriptor)
    b.optionalElement("storageTempRequirements", RangeSerializer.descriptor)
    b.optionalElement(
      "property",
      BiologicallyDerivedProductPropertySerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          productCategory =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        11 ->
          productCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          parent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        13 ->
          request =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        14 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        15 ->
          biologicalSourceEvent =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        16 ->
          processingFacility =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 -> division = decoder.decodeStringElement(descriptor, i)
        18 ->
          _division =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          productStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        20 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        21 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          collection =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BiologicallyDerivedProductCollectionSerializer,
              null,
            )
        23 ->
          storageTempRequirements =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        24 ->
          `property` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BiologicallyDerivedProductPropertySerializer.listSerializer,
              null,
            )
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
      expirationDate =
        DateTime.of(
          if (expirationDate != null) FhirDateTime.fromString(expirationDate) else null,
          _expirationDate,
        ),
      collection = collection,
      storageTempRequirements = storageTempRequirements,
      `property` = `property` ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: BiologicallyDerivedProduct,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      CodingSerializer,
      value.productCategory,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.productCode,
    )
    if (value.parent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.parent,
      )
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.request,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      IdentifierSerializer,
      value.biologicalSourceEvent,
    )
    if (value.processingFacility.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.processingFacility,
      )
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.division?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.division)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      CodingSerializer,
      value.productStatus,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.expirationDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.expirationDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      BiologicallyDerivedProductCollectionSerializer,
      value.collection,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      RangeSerializer,
      value.storageTempRequirements,
    )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        BiologicallyDerivedProductPropertySerializer.listSerializer,
        value.`property`,
      )
  }
}
