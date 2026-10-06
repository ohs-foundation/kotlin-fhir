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

import dev.ohs.fhir.model.r4.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object BiologicallyDerivedProductProcessingSerializer :
  KSerializer<BiologicallyDerivedProduct.Processing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Processing") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("procedure", CodeableConceptSerializer.descriptor)
      optionalElement("additive", ReferenceSerializer.descriptor)
      optionalElement("timeDateTime", KotlinString.serializer().descriptor)
      optionalElement("_timeDateTime", ElementSerializer.descriptor)
      optionalElement("timePeriod", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<BiologicallyDerivedProduct.Processing>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Processing =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var procedure: CodeableConcept? = null
      var additive: Reference? = null
      var timeDateTime: KotlinString? = null
      var _timeDateTime: Element? = null
      var timePeriod: Period? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            procedure =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            additive = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 -> timeDateTime = decodeStringElement(descriptor, i)
          8 ->
            _timeDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> timePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Processing: " + i)
        }
      }
      BiologicallyDerivedProduct.Processing(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4String.of(description, _description),
        procedure = procedure,
        additive = additive,
        time =
          BiologicallyDerivedProduct.Processing.Time.from(
            DateTime.of(
              if (timeDateTime != null) FhirDateTime.fromString(timeDateTime) else null,
              _timeDateTime,
            ),
            timePeriod,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Processing) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.procedure)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.additive)
      when (val choice = value.time) {
        null -> {}
        is BiologicallyDerivedProduct.Processing.Time.DateTime -> {
          encodeStringIfNotNull(descriptor, 7, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is BiologicallyDerivedProduct.Processing.Time.Period -> {
          encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
        }
      }
    }
  }
}

internal object BiologicallyDerivedProductManipulationSerializer :
  KSerializer<BiologicallyDerivedProduct.Manipulation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Manipulation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("timeDateTime", KotlinString.serializer().descriptor)
      optionalElement("_timeDateTime", ElementSerializer.descriptor)
      optionalElement("timePeriod", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<BiologicallyDerivedProduct.Manipulation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Manipulation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var timeDateTime: KotlinString? = null
      var _timeDateTime: Element? = null
      var timePeriod: Period? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> timeDateTime = decodeStringElement(descriptor, i)
          6 ->
            _timeDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> timePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Manipulation: " + i)
        }
      }
      BiologicallyDerivedProduct.Manipulation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4String.of(description, _description),
        time =
          BiologicallyDerivedProduct.Manipulation.Time.from(
            DateTime.of(
              if (timeDateTime != null) FhirDateTime.fromString(timeDateTime) else null,
              _timeDateTime,
            ),
            timePeriod,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Manipulation) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      when (val choice = value.time) {
        null -> {}
        is BiologicallyDerivedProduct.Manipulation.Time.DateTime -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is BiologicallyDerivedProduct.Manipulation.Time.Period -> {
          encodeSerializableElement(descriptor, 7, PeriodSerializer, choice.value)
        }
      }
    }
  }
}

internal object BiologicallyDerivedProductStorageSerializer :
  KSerializer<BiologicallyDerivedProduct.Storage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Storage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("temperature", FhirDecimalSerializer.descriptor)
      optionalElement("_temperature", ElementSerializer.descriptor)
      optionalElement("scale", KotlinString.serializer().descriptor)
      optionalElement("_scale", ElementSerializer.descriptor)
      optionalElement("duration", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<BiologicallyDerivedProduct.Storage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Storage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var temperature: FhirDecimal? = null
      var _temperature: Element? = null
      var scale: KotlinString? = null
      var _scale: Element? = null
      var duration: Period? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            temperature =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          6 ->
            _temperature = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> scale = decodeStringElement(descriptor, i)
          8 -> _scale = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> duration = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Storage: " + i)
        }
      }
      BiologicallyDerivedProduct.Storage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4String.of(description, _description),
        temperature = Decimal.of(temperature, _temperature),
        scale =
          Enumeration.of(
            if (scale != null)
              BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.fromCode(scale)
            else null,
            _scale,
          ),
        duration = duration,
      )
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Storage) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeSerializableIfNotNull(descriptor, 5, FhirDecimalSerializer, value.temperature?.value)
      encodeElementIfNotNull(descriptor, 6, value.temperature)
      encodeStringIfNotNull(descriptor, 7, value.scale?.value?.code)
      encodeElementIfNotNull(descriptor, 8, value.scale)
      encodeSerializableIfNotNull(descriptor, 9, PeriodSerializer, value.duration)
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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("productCategory", KotlinString.serializer().descriptor)
    b.optionalElement("_productCategory", ElementSerializer.descriptor)
    b.optionalElement("productCode", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("quantity", Int.serializer().descriptor)
    b.optionalElement("_quantity", ElementSerializer.descriptor)
    b.optionalElement("parent", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("collection", BiologicallyDerivedProductCollectionSerializer.descriptor)
    b.optionalElement(
      "processing",
      BiologicallyDerivedProductProcessingSerializer.listSerializer.descriptor,
    )
    b.optionalElement("manipulation", BiologicallyDerivedProductManipulationSerializer.descriptor)
    b.optionalElement(
      "storage",
      BiologicallyDerivedProductStorageSerializer.listSerializer.descriptor,
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
    var identifier: List<Identifier>? = null
    var productCategory: KotlinString? = null
    var _productCategory: Element? = null
    var productCode: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var request: List<Reference>? = null
    var quantity: Int? = null
    var _quantity: Element? = null
    var parent: List<Reference>? = null
    var collection: BiologicallyDerivedProduct.Collection? = null
    var processing: List<BiologicallyDerivedProduct.Processing>? = null
    var manipulation: BiologicallyDerivedProduct.Manipulation? = null
    var storage: List<BiologicallyDerivedProduct.Storage>? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> productCategory = decoder.decodeStringElement(descriptor, i)
        12 ->
          _productCategory =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          productCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 -> status = decoder.decodeStringElement(descriptor, i)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          request =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 -> quantity = decoder.decodeIntElement(descriptor, i)
        18 ->
          _quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          parent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          collection =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BiologicallyDerivedProductCollectionSerializer,
              null,
            )
        21 ->
          processing =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BiologicallyDerivedProductProcessingSerializer.listSerializer,
              null,
            )
        22 ->
          manipulation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BiologicallyDerivedProductManipulationSerializer,
              null,
            )
        23 ->
          storage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BiologicallyDerivedProductStorageSerializer.listSerializer,
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
      identifier = identifier ?: listOf(),
      productCategory =
        Enumeration.of(
          if (productCategory != null)
            BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.fromCode(productCategory)
          else null,
          _productCategory,
        ),
      productCode = productCode,
      status =
        Enumeration.of(
          if (status != null)
            BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.fromCode(status)
          else null,
          _status,
        ),
      request = request ?: listOf(),
      quantity = Integer.of(quantity, _quantity),
      parent = parent ?: listOf(),
      collection = collection,
      processing = processing ?: listOf(),
      manipulation = manipulation,
      storage = storage ?: listOf(),
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.productCategory?.value?.code,
    )
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.productCategory)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.productCode,
    )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.status)
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.request,
      )
    encoder.encodeIntIfNotNull(descriptor, 17 + descriptorOffset, value.quantity?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.quantity)
    if (value.parent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.parent,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      BiologicallyDerivedProductCollectionSerializer,
      value.collection,
    )
    if (value.processing.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        BiologicallyDerivedProductProcessingSerializer.listSerializer,
        value.processing,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      BiologicallyDerivedProductManipulationSerializer,
      value.manipulation,
    )
    if (value.storage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        BiologicallyDerivedProductStorageSerializer.listSerializer,
        value.storage,
      )
  }
}
