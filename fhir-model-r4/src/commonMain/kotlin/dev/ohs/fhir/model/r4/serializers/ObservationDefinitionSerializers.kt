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

  override fun deserialize(decoder: Decoder): ObservationDefinition.QuantitativeDetails {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          customaryUnit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          unit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          conversionFactor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        6 ->
          _conversionFactor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> decimalPrecision = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _decimalPrecision =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding QuantitativeDetails: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ObservationDefinition.QuantitativeDetails(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.customaryUnit,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.unit,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      FhirDecimalSerializer,
      value.conversionFactor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.conversionFactor)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.decimalPrecision?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.decimalPrecision)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): ObservationDefinition.QualifiedInterval {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> category = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          range =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        6 ->
          context =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          appliesTo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 -> gender = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _gender =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          age =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        11 ->
          gestationalAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        12 -> condition = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding QualifiedInterval: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ObservationDefinition.QualifiedInterval(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.category?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.category)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, RangeSerializer, value.range)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.context,
    )
    if (value.appliesTo.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        CodeableConceptSerializer.listSerializer,
        value.appliesTo,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.gender?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.gender)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 10, RangeSerializer, value.age)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      RangeSerializer,
      value.gestationalAge,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.condition?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.condition)
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 ->
          permittedDataType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _permittedDataType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 -> multipleResultsAllowed = compositeDecoder.decodeBooleanElement(descriptor, i)
        16 ->
          _multipleResultsAllowed =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 -> preferredReportName = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _preferredReportName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          quantitativeDetails =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationDefinitionQuantitativeDetailsSerializer,
              null,
            )
        21 ->
          qualifiedInterval =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationDefinitionQualifiedIntervalSerializer.listSerializer,
              null,
            )
        22 ->
          validCodedValueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        23 ->
          normalCodedValueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          abnormalCodedValueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        25 ->
          criticalCodedValueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ObservationDefinition,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.category.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.permittedDataType.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.permittedDataType.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        14 + descriptorOffset,
        value.permittedDataType,
      )
    }
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.multipleResultsAllowed?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.multipleResultsAllowed,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.method,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.preferredReportName?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.preferredReportName,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ObservationDefinitionQuantitativeDetailsSerializer,
      value.quantitativeDetails,
    )
    if (value.qualifiedInterval.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ObservationDefinitionQualifiedIntervalSerializer.listSerializer,
        value.qualifiedInterval,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.validCodedValueSet,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.normalCodedValueSet,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.abnormalCodedValueSet,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.criticalCodedValueSet,
    )
  }
}
