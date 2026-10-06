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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.ObservationDefinition
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.AdministrativeGender
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

internal object ObservationDefinitionQuantitativeDetailsSerializer :
  KSerializer<ObservationDefinition.QuantitativeDetails> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QuantitativeDetails") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("customaryUnit", CodeableConceptSerializer.descriptor)
      optionalElement("unit", CodeableConceptSerializer.descriptor)
      optionalElement("conversionFactor", FhirDecimalSerializer.descriptor)
      optionalElement("_conversionFactor", ElementSerializer.descriptor)
      optionalElement("decimalPrecision", Int.serializer().descriptor)
      optionalElement("_decimalPrecision", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ObservationDefinition.QuantitativeDetails>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ObservationDefinition.QuantitativeDetails =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var customaryUnit: CodeableConcept? = null
      var unit: CodeableConcept? = null
      var conversionFactor: FhirDecimal? = null
      var _conversionFactor: Element? = null
      var decimalPrecision: Int? = null
      var _decimalPrecision: Element? = null
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
            customaryUnit =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            unit = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            conversionFactor =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          6 ->
            _conversionFactor =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> decimalPrecision = decodeIntElement(descriptor, i)
          8 ->
            _decimalPrecision =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding QuantitativeDetails: " + i)
        }
      }
      ObservationDefinition.QuantitativeDetails(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        customaryUnit = customaryUnit,
        unit = unit,
        conversionFactor = Decimal.of(conversionFactor, _conversionFactor),
        decimalPrecision = Integer.of(decimalPrecision, _decimalPrecision),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QuantitativeDetails) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.customaryUnit)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.unit)
      encodeSerializableIfNotNull(
        descriptor,
        5,
        FhirDecimalSerializer,
        value.conversionFactor?.value,
      )
      encodeElementIfNotNull(descriptor, 6, value.conversionFactor)
      encodeIntIfNotNull(descriptor, 7, value.decimalPrecision?.value)
      encodeElementIfNotNull(descriptor, 8, value.decimalPrecision)
    }
  }
}

internal object ObservationDefinitionQualifiedIntervalSerializer :
  KSerializer<ObservationDefinition.QualifiedInterval> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QualifiedInterval") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", KotlinString.serializer().descriptor)
      optionalElement("_category", ElementSerializer.descriptor)
      optionalElement("range", RangeSerializer.descriptor)
      optionalElement("context", CodeableConceptSerializer.descriptor)
      optionalElement("appliesTo", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("gender", KotlinString.serializer().descriptor)
      optionalElement("_gender", ElementSerializer.descriptor)
      optionalElement("age", RangeSerializer.descriptor)
      optionalElement("gestationalAge", RangeSerializer.descriptor)
      optionalElement("condition", KotlinString.serializer().descriptor)
      optionalElement("_condition", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ObservationDefinition.QualifiedInterval>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ObservationDefinition.QualifiedInterval =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: KotlinString? = null
      var _category: Element? = null
      var range: Range? = null
      var context: CodeableConcept? = null
      var appliesTo: List<CodeableConcept>? = null
      var gender: KotlinString? = null
      var _gender: Element? = null
      var age: Range? = null
      var gestationalAge: Range? = null
      var condition: KotlinString? = null
      var _condition: Element? = null
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
          3 -> category = decodeStringElement(descriptor, i)
          4 -> _category = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> range = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          6 ->
            context =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            appliesTo =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 -> gender = decodeStringElement(descriptor, i)
          9 -> _gender = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> age = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          11 ->
            gestationalAge = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          12 -> condition = decodeStringElement(descriptor, i)
          13 ->
            _condition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding QualifiedInterval: " + i)
        }
      }
      ObservationDefinition.QualifiedInterval(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        category =
          Enumeration.of(
            if (category != null) ObservationDefinition.ObservationRangeCategory.fromCode(category)
            else null,
            _category,
          ),
        range = range,
        context = context,
        appliesTo = appliesTo ?: listOf(),
        gender =
          Enumeration.of(
            if (gender != null) AdministrativeGender.fromCode(gender) else null,
            _gender,
          ),
        age = age,
        gestationalAge = gestationalAge,
        condition = R4String.of(condition, _condition),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QualifiedInterval) {
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
      encodeStringIfNotNull(descriptor, 3, value.category?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.category)
      encodeSerializableIfNotNull(descriptor, 5, RangeSerializer, value.range)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.context)
      if (value.appliesTo.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.appliesTo,
        )
      encodeStringIfNotNull(descriptor, 8, value.gender?.value?.code)
      encodeElementIfNotNull(descriptor, 9, value.gender)
      encodeSerializableIfNotNull(descriptor, 10, RangeSerializer, value.age)
      encodeSerializableIfNotNull(descriptor, 11, RangeSerializer, value.gestationalAge)
      encodeStringIfNotNull(descriptor, 12, value.condition?.value)
      encodeElementIfNotNull(descriptor, 13, value.condition)
    }
  }
}

internal object ObservationDefinitionSerializer : FhirResourceSerializer<ObservationDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ObservationDefinition")

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
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("permittedDataType", stringNullableListSerializer.descriptor)
    b.optionalElement("_permittedDataType", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("multipleResultsAllowed", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_multipleResultsAllowed", ElementSerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.optionalElement("preferredReportName", KotlinString.serializer().descriptor)
    b.optionalElement("_preferredReportName", ElementSerializer.descriptor)
    b.optionalElement(
      "quantitativeDetails",
      ObservationDefinitionQuantitativeDetailsSerializer.descriptor,
    )
    b.optionalElement(
      "qualifiedInterval",
      ObservationDefinitionQualifiedIntervalSerializer.listSerializer.descriptor,
    )
    b.optionalElement("validCodedValueSet", ReferenceSerializer.descriptor)
    b.optionalElement("normalCodedValueSet", ReferenceSerializer.descriptor)
    b.optionalElement("abnormalCodedValueSet", ReferenceSerializer.descriptor)
    b.optionalElement("criticalCodedValueSet", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ObservationDefinition {
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
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var identifier: List<Identifier>? = null
    var permittedDataType: List<KotlinString?>? = null
    var _permittedDataType: List<Element?>? = null
    var multipleResultsAllowed: KotlinBoolean? = null
    var _multipleResultsAllowed: Element? = null
    var method: CodeableConcept? = null
    var preferredReportName: KotlinString? = null
    var _preferredReportName: Element? = null
    var quantitativeDetails: ObservationDefinition.QuantitativeDetails? = null
    var qualifiedInterval: List<ObservationDefinition.QualifiedInterval>? = null
    var validCodedValueSet: Reference? = null
    var normalCodedValueSet: Reference? = null
    var abnormalCodedValueSet: Reference? = null
    var criticalCodedValueSet: Reference? = null
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
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 ->
          permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 -> multipleResultsAllowed = decoder.decodeBooleanElement(descriptor, i)
        16 ->
          _multipleResultsAllowed =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 -> preferredReportName = decoder.decodeStringElement(descriptor, i)
        19 ->
          _preferredReportName =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          quantitativeDetails =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationDefinitionQuantitativeDetailsSerializer,
              null,
            )
        21 ->
          qualifiedInterval =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationDefinitionQualifiedIntervalSerializer.listSerializer,
              null,
            )
        22 ->
          validCodedValueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          normalCodedValueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          abnormalCodedValueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        25 ->
          criticalCodedValueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        else ->
          throw SerializationException("Unexpected index decoding ObservationDefinition: " + i)
      }
    }
    return ObservationDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category ?: listOf(),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on ObservationDefinition"
          ),
      identifier = identifier ?: listOf(),
      permittedDataType =
        (kotlin.collections.List(
          maxOf(permittedDataType?.size ?: 0, _permittedDataType?.size ?: 0)
        ) { index ->
          Enumeration.of(
            permittedDataType?.getOrNull(index)?.let {
              ObservationDefinition.ObservationDataType.fromCode(it)
            },
            _permittedDataType?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'permittedDataType' on ObservationDefinition has neither a value nor an id/extension"
            )
        }),
      multipleResultsAllowed = R4Boolean.of(multipleResultsAllowed, _multipleResultsAllowed),
      method = method,
      preferredReportName = R4String.of(preferredReportName, _preferredReportName),
      quantitativeDetails = quantitativeDetails,
      qualifiedInterval = qualifiedInterval ?: listOf(),
      validCodedValueSet = validCodedValueSet,
      normalCodedValueSet = normalCodedValueSet,
      abnormalCodedValueSet = abnormalCodedValueSet,
      criticalCodedValueSet = criticalCodedValueSet,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ObservationDefinition,
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.permittedDataType.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.permittedDataType.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.permittedDataType)
    }
    encoder.encodeBooleanIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.multipleResultsAllowed?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.multipleResultsAllowed)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.method,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.preferredReportName?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.preferredReportName)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ObservationDefinitionQuantitativeDetailsSerializer,
      value.quantitativeDetails,
    )
    if (value.qualifiedInterval.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ObservationDefinitionQualifiedIntervalSerializer.listSerializer,
        value.qualifiedInterval,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.validCodedValueSet,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.normalCodedValueSet,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.abnormalCodedValueSet,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.criticalCodedValueSet,
    )
  }
}
