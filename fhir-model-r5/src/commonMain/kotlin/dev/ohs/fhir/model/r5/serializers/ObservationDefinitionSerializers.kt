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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.ObservationDefinition
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.AdministrativeGender
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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

internal object ObservationDefinitionQualifiedValueSerializer :
  KSerializer<ObservationDefinition.QualifiedValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QualifiedValue") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("context", CodeableConceptSerializer.descriptor)
      optionalElement("appliesTo", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("gender", KotlinString.serializer().descriptor)
      optionalElement("_gender", ElementSerializer.descriptor)
      optionalElement("age", RangeSerializer.descriptor)
      optionalElement("gestationalAge", RangeSerializer.descriptor)
      optionalElement("condition", KotlinString.serializer().descriptor)
      optionalElement("_condition", ElementSerializer.descriptor)
      optionalElement("rangeCategory", KotlinString.serializer().descriptor)
      optionalElement("_rangeCategory", ElementSerializer.descriptor)
      optionalElement("range", RangeSerializer.descriptor)
      optionalElement("validCodedValueSet", KotlinString.serializer().descriptor)
      optionalElement("_validCodedValueSet", ElementSerializer.descriptor)
      optionalElement("normalCodedValueSet", KotlinString.serializer().descriptor)
      optionalElement("_normalCodedValueSet", ElementSerializer.descriptor)
      optionalElement("abnormalCodedValueSet", KotlinString.serializer().descriptor)
      optionalElement("_abnormalCodedValueSet", ElementSerializer.descriptor)
      optionalElement("criticalCodedValueSet", KotlinString.serializer().descriptor)
      optionalElement("_criticalCodedValueSet", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ObservationDefinition.QualifiedValue>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ObservationDefinition.QualifiedValue =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var context: CodeableConcept? = null
      var appliesTo: List<CodeableConcept>? = null
      var gender: KotlinString? = null
      var _gender: Element? = null
      var age: Range? = null
      var gestationalAge: Range? = null
      var condition: KotlinString? = null
      var _condition: Element? = null
      var rangeCategory: KotlinString? = null
      var _rangeCategory: Element? = null
      var range: Range? = null
      var validCodedValueSet: KotlinString? = null
      var _validCodedValueSet: Element? = null
      var normalCodedValueSet: KotlinString? = null
      var _normalCodedValueSet: Element? = null
      var abnormalCodedValueSet: KotlinString? = null
      var _abnormalCodedValueSet: Element? = null
      var criticalCodedValueSet: KotlinString? = null
      var _criticalCodedValueSet: Element? = null
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
            context =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            appliesTo =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 -> gender = decodeStringElement(descriptor, i)
          6 -> _gender = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> age = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          8 ->
            gestationalAge = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          9 -> condition = decodeStringElement(descriptor, i)
          10 ->
            _condition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> rangeCategory = decodeStringElement(descriptor, i)
          12 ->
            _rangeCategory =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> range = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          14 -> validCodedValueSet = decodeStringElement(descriptor, i)
          15 ->
            _validCodedValueSet =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 -> normalCodedValueSet = decodeStringElement(descriptor, i)
          17 ->
            _normalCodedValueSet =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 -> abnormalCodedValueSet = decodeStringElement(descriptor, i)
          19 ->
            _abnormalCodedValueSet =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          20 -> criticalCodedValueSet = decodeStringElement(descriptor, i)
          21 ->
            _criticalCodedValueSet =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding QualifiedValue: " + i)
        }
      }
      ObservationDefinition.QualifiedValue(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        context = context,
        appliesTo = appliesTo ?: listOf(),
        gender =
          Enumeration.of(
            if (gender != null) AdministrativeGender.fromCode(gender) else null,
            _gender,
          ),
        age = age,
        gestationalAge = gestationalAge,
        condition = R5String.of(condition, _condition),
        rangeCategory =
          Enumeration.of(
            if (rangeCategory != null)
              ObservationDefinition.ObservationRangeCategory.fromCode(rangeCategory)
            else null,
            _rangeCategory,
          ),
        range = range,
        validCodedValueSet = Canonical.of(validCodedValueSet, _validCodedValueSet),
        normalCodedValueSet = Canonical.of(normalCodedValueSet, _normalCodedValueSet),
        abnormalCodedValueSet = Canonical.of(abnormalCodedValueSet, _abnormalCodedValueSet),
        criticalCodedValueSet = Canonical.of(criticalCodedValueSet, _criticalCodedValueSet),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QualifiedValue) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.context)
      if (value.appliesTo.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.appliesTo,
        )
      encodeStringIfNotNull(descriptor, 5, value.gender?.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.gender)
      encodeSerializableIfNotNull(descriptor, 7, RangeSerializer, value.age)
      encodeSerializableIfNotNull(descriptor, 8, RangeSerializer, value.gestationalAge)
      encodeStringIfNotNull(descriptor, 9, value.condition?.value)
      encodeElementIfNotNull(descriptor, 10, value.condition)
      encodeStringIfNotNull(descriptor, 11, value.rangeCategory?.value?.code)
      encodeElementIfNotNull(descriptor, 12, value.rangeCategory)
      encodeSerializableIfNotNull(descriptor, 13, RangeSerializer, value.range)
      encodeStringIfNotNull(descriptor, 14, value.validCodedValueSet?.value)
      encodeElementIfNotNull(descriptor, 15, value.validCodedValueSet)
      encodeStringIfNotNull(descriptor, 16, value.normalCodedValueSet?.value)
      encodeElementIfNotNull(descriptor, 17, value.normalCodedValueSet)
      encodeStringIfNotNull(descriptor, 18, value.abnormalCodedValueSet?.value)
      encodeElementIfNotNull(descriptor, 19, value.abnormalCodedValueSet)
      encodeStringIfNotNull(descriptor, 20, value.criticalCodedValueSet?.value)
      encodeElementIfNotNull(descriptor, 21, value.criticalCodedValueSet)
    }
  }
}

internal object ObservationDefinitionComponentSerializer :
  KSerializer<ObservationDefinition.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("permittedDataType", stringNullableListSerializer.descriptor)
      optionalElement("_permittedDataType", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("permittedUnit", CodingSerializer.listSerializer.descriptor)
      optionalElement(
        "qualifiedValue",
        listSerialDescriptor(
          lazyDescriptor { ObservationDefinitionQualifiedValueSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<ObservationDefinition.Component>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ObservationDefinition.Component =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var permittedDataType: List<KotlinString?>? = null
      var _permittedDataType: List<Element?>? = null
      var permittedUnit: List<Coding>? = null
      var qualifiedValue: List<ObservationDefinition.QualifiedValue>? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            permittedDataType =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          5 ->
            _permittedDataType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          6 ->
            permittedUnit =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          7 ->
            qualifiedValue =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ObservationDefinitionQualifiedValueSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Component: " + i)
        }
      }
      ObservationDefinition.Component(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on ObservationDefinition.Component"
            ),
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
                "An entry of 'permittedDataType' on ObservationDefinition.Component has neither a value nor an id/extension"
              )
          }),
        permittedUnit = permittedUnit ?: listOf(),
        qualifiedValue = qualifiedValue ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.Component) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      if (value.permittedDataType.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          4,
          stringNullableListSerializer,
          value.permittedDataType.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 5, value.permittedDataType)
      }
      if (value.permittedUnit.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodingSerializer.listSerializer,
          value.permittedUnit,
        )
      if (value.qualifiedValue.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          ObservationDefinitionQualifiedValueSerializer.listSerializer,
          value.qualifiedValue,
        )
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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("derivedFromCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_derivedFromCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("derivedFromUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_derivedFromUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("subject", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("performerType", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("permittedDataType", stringNullableListSerializer.descriptor)
    b.optionalElement("_permittedDataType", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("multipleResultsAllowed", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_multipleResultsAllowed", ElementSerializer.descriptor)
    b.optionalElement("bodySite", CodeableConceptSerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.optionalElement("specimen", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("device", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("preferredReportName", KotlinString.serializer().descriptor)
    b.optionalElement("_preferredReportName", ElementSerializer.descriptor)
    b.optionalElement("permittedUnit", CodingSerializer.listSerializer.descriptor)
    b.optionalElement(
      "qualifiedValue",
      ObservationDefinitionQualifiedValueSerializer.listSerializer.descriptor,
    )
    b.optionalElement("hasMember", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "component",
      ObservationDefinitionComponentSerializer.listSerializer.descriptor,
    )
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: Identifier? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var derivedFromCanonical: List<KotlinString?>? = null
    var _derivedFromCanonical: List<Element?>? = null
    var derivedFromUri: List<KotlinString?>? = null
    var _derivedFromUri: List<Element?>? = null
    var subject: List<CodeableConcept>? = null
    var performerType: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var permittedDataType: List<KotlinString?>? = null
    var _permittedDataType: List<Element?>? = null
    var multipleResultsAllowed: KotlinBoolean? = null
    var _multipleResultsAllowed: Element? = null
    var bodySite: CodeableConcept? = null
    var method: CodeableConcept? = null
    var specimen: List<Reference>? = null
    var device: List<Reference>? = null
    var preferredReportName: KotlinString? = null
    var _preferredReportName: Element? = null
    var permittedUnit: List<Coding>? = null
    var qualifiedValue: List<ObservationDefinition.QualifiedValue>? = null
    var hasMember: List<Reference>? = null
    var component: List<ObservationDefinition.Component>? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> purpose = decoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> copyright = decoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        42 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        44 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        46 ->
          derivedFromCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        47 ->
          _derivedFromCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        48 ->
          derivedFromUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        49 ->
          _derivedFromUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        50 ->
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        51 ->
          performerType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        52 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        53 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        54 ->
          permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        55 ->
          _permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        56 -> multipleResultsAllowed = decoder.decodeBooleanElement(descriptor, i)
        57 ->
          _multipleResultsAllowed =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        58 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        59 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        60 ->
          specimen =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        61 ->
          device =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        62 -> preferredReportName = decoder.decodeStringElement(descriptor, i)
        63 ->
          _preferredReportName =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        64 ->
          permittedUnit =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        65 ->
          qualifiedValue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationDefinitionQualifiedValueSerializer.listSerializer,
              null,
            )
        66 ->
          hasMember =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        67 ->
          component =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationDefinitionComponentSerializer.listSerializer,
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
      url = Uri.of(url, _url),
      identifier = identifier,
      version = R5String.of(version, _version),
      versionAlgorithm =
        ObservationDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on ObservationDefinition"
          ),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
      effectivePeriod = effectivePeriod,
      derivedFromCanonical =
        (kotlin.collections.List(
          maxOf(derivedFromCanonical?.size ?: 0, _derivedFromCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            derivedFromCanonical?.getOrNull(index),
            _derivedFromCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'derivedFromCanonical' on ObservationDefinition has neither a value nor an id/extension"
            )
        }),
      derivedFromUri =
        (kotlin.collections.List(maxOf(derivedFromUri?.size ?: 0, _derivedFromUri?.size ?: 0)) {
          index ->
          Uri.of(derivedFromUri?.getOrNull(index), _derivedFromUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'derivedFromUri' on ObservationDefinition has neither a value nor an id/extension"
            )
        }),
      subject = subject ?: listOf(),
      performerType = performerType,
      category = category ?: listOf(),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on ObservationDefinition"
          ),
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
      multipleResultsAllowed = R5Boolean.of(multipleResultsAllowed, _multipleResultsAllowed),
      bodySite = bodySite,
      method = method,
      specimen = specimen ?: listOf(),
      device = device ?: listOf(),
      preferredReportName = R5String.of(preferredReportName, _preferredReportName),
      permittedUnit = permittedUnit ?: listOf(),
      qualifiedValue = qualifiedValue ?: listOf(),
      hasMember = hasMember ?: listOf(),
      component = component ?: listOf(),
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is ObservationDefinition.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is ObservationDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 24 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyrightLabel)
    encoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.derivedFromCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        46 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFromCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        47 + descriptorOffset,
        value.derivedFromCanonical,
      )
    }
    if (value.derivedFromUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        48 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFromUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 49 + descriptorOffset, value.derivedFromUri)
    }
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.subject,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      CodeableConceptSerializer,
      value.performerType,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      53 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    if (value.permittedDataType.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        54 + descriptorOffset,
        stringNullableListSerializer,
        value.permittedDataType.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 55 + descriptorOffset, value.permittedDataType)
    }
    encoder.encodeBooleanIfNotNull(
      descriptor,
      56 + descriptorOffset,
      value.multipleResultsAllowed?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 57 + descriptorOffset, value.multipleResultsAllowed)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      58 + descriptorOffset,
      CodeableConceptSerializer,
      value.bodySite,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      59 + descriptorOffset,
      CodeableConceptSerializer,
      value.method,
    )
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.specimen,
      )
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        61 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.device,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      62 + descriptorOffset,
      value.preferredReportName?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 63 + descriptorOffset, value.preferredReportName)
    if (value.permittedUnit.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        64 + descriptorOffset,
        CodingSerializer.listSerializer,
        value.permittedUnit,
      )
    if (value.qualifiedValue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        65 + descriptorOffset,
        ObservationDefinitionQualifiedValueSerializer.listSerializer,
        value.qualifiedValue,
      )
    if (value.hasMember.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        66 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.hasMember,
      )
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        67 + descriptorOffset,
        ObservationDefinitionComponentSerializer.listSerializer,
        value.component,
      )
  }
}
