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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.ObservationDefinition
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
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
import kotlinx.serialization.builtins.nullable
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
      element("context", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "appliesTo",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("gender", KotlinString.serializer().descriptor, isOptional = true)
      element("_gender", Element.serializer().descriptor, isOptional = true)
      element("age", Range.serializer().descriptor, isOptional = true)
      element("gestationalAge", Range.serializer().descriptor, isOptional = true)
      element("condition", KotlinString.serializer().descriptor, isOptional = true)
      element("_condition", Element.serializer().descriptor, isOptional = true)
      element("rangeCategory", KotlinString.serializer().descriptor, isOptional = true)
      element("_rangeCategory", Element.serializer().descriptor, isOptional = true)
      element("range", Range.serializer().descriptor, isOptional = true)
      element("validCodedValueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_validCodedValueSet", Element.serializer().descriptor, isOptional = true)
      element("normalCodedValueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_normalCodedValueSet", Element.serializer().descriptor, isOptional = true)
      element("abnormalCodedValueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_abnormalCodedValueSet", Element.serializer().descriptor, isOptional = true)
      element("criticalCodedValueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_criticalCodedValueSet", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ObservationDefinition.QualifiedValue =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QualifiedValue) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ObservationDefinition.QualifiedValue {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contextSer, null)
        4 ->
          appliesTo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.appliesToSer, null)
        5 -> gender = decoder.decodeStringElement(descriptor, i)
        6 ->
          _gender =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genderSer, null)
        7 -> age = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ageSer, null)
        8 ->
          gestationalAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ageSer, null)
        9 -> condition = decoder.decodeStringElement(descriptor, i)
        10 ->
          _condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genderSer, null)
        11 -> rangeCategory = decoder.decodeStringElement(descriptor, i)
        12 ->
          _rangeCategory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genderSer, null)
        13 -> range = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ageSer, null)
        14 -> validCodedValueSet = decoder.decodeStringElement(descriptor, i)
        15 ->
          _validCodedValueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genderSer, null)
        16 -> normalCodedValueSet = decoder.decodeStringElement(descriptor, i)
        17 ->
          _normalCodedValueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genderSer, null)
        18 -> abnormalCodedValueSet = decoder.decodeStringElement(descriptor, i)
        19 ->
          _abnormalCodedValueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genderSer, null)
        20 -> criticalCodedValueSet = decoder.decodeStringElement(descriptor, i)
        21 ->
          _criticalCodedValueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genderSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding QualifiedValue: " + i)
      }
    }
    return ObservationDefinition.QualifiedValue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      context = context,
      appliesTo = appliesTo ?: listOf(),
      gender = gender?.let { Enumeration.of(AdministrativeGender.fromCode(it), _gender) },
      age = age,
      gestationalAge = gestationalAge,
      condition = R5String.of(condition, _condition),
      rangeCategory =
        rangeCategory?.let {
          Enumeration.of(
            ObservationDefinition.ObservationRangeCategory.fromCode(it),
            _rangeCategory,
          )
        },
      range = range,
      validCodedValueSet = Canonical.of(validCodedValueSet, _validCodedValueSet),
      normalCodedValueSet = Canonical.of(normalCodedValueSet, _normalCodedValueSet),
      abnormalCodedValueSet = Canonical.of(abnormalCodedValueSet, _abnormalCodedValueSet),
      criticalCodedValueSet = Canonical.of(criticalCodedValueSet, _criticalCodedValueSet),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ObservationDefinition.QualifiedValue,
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
    (value.context)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.contextSer, it)
    }
    if (value.appliesTo.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.appliesToSer, value.appliesTo)
    ((value.gender?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.genderSer, it)
    }
    (value.age)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.ageSer, it) }
    (value.gestationalAge)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.ageSer, it)
    }
    ((value.condition?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.condition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.genderSer, it)
    }
    ((value.rangeCategory?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11, it)
    }
    (value.rangeCategory?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.genderSer, it)
    }
    (value.range)?.let { encoder.encodeSerializableElement(descriptor, 13, Hoisted.ageSer, it) }
    ((value.validCodedValueSet?.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
    (value.validCodedValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.genderSer, it)
    }
    ((value.normalCodedValueSet?.value))?.let { encoder.encodeStringElement(descriptor, 16, it) }
    (value.normalCodedValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.genderSer, it)
    }
    ((value.abnormalCodedValueSet?.value))?.let { encoder.encodeStringElement(descriptor, 18, it) }
    (value.abnormalCodedValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.genderSer, it)
    }
    ((value.criticalCodedValueSet?.value))?.let { encoder.encodeStringElement(descriptor, 20, it) }
    (value.criticalCodedValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.genderSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contextSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val appliesToSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.contextSer)

    public val genderSer: KSerializer<Element> = Element.serializer()

    public val ageSer: KSerializer<Range> = Range.serializer()
  }
}

internal object ObservationDefinitionComponentSerializer :
  KSerializer<ObservationDefinition.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "permittedDataType",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_permittedDataType",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "permittedUnit",
        listSerialDescriptor(Coding.serializer().descriptor),
        isOptional = true,
      )
      element(
        "qualifiedValue",
        listSerialDescriptor(
          lazyDescriptor { ObservationDefinition.QualifiedValue.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ObservationDefinition.Component =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.Component) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ObservationDefinition.Component {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var permittedDataType: List<KotlinString?>? = null
    var _permittedDataType: List<Element?>? = null
    var permittedUnit: List<Coding>? = null
    var qualifiedValue: List<ObservationDefinition.QualifiedValue>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.permittedDataTypeSer,
              null,
            )
        5 ->
          _permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.permittedDataTypeSer2,
              null,
            )
        6 ->
          permittedUnit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.permittedUnitSer, null)
        7 ->
          qualifiedValue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.qualifiedValueSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + i)
      }
    }
    return ObservationDefinition.Component(
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
            ObservationDefinition.ObservationDataType.fromCode(
              permittedDataType?.getOrNull(index)!!
            ),
            _permittedDataType?.getOrNull(index),
          )
        }),
      permittedUnit = permittedUnit ?: listOf(),
      qualifiedValue = qualifiedValue ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ObservationDefinition.Component,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    (value.permittedDataType.map { it.value?.getCode() }.takeUnless { it.all { it == null } })
      ?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.permittedDataTypeSer, it) }
    (value.permittedDataType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.permittedDataTypeSer2, it)
    }
    if (value.permittedUnit.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        Hoisted.permittedUnitSer,
        value.permittedUnit,
      )
    if (value.qualifiedValue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        Hoisted.qualifiedValueSer,
        value.qualifiedValue,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val permittedDataTypeSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val permittedDataTypeSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.permittedDataTypeSerInner).nullable)

    public val permittedDataTypeSerInner2: KSerializer<Element> = Element.serializer()

    public val permittedDataTypeSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.permittedDataTypeSerInner2).nullable)

    public val permittedUnitSerInner: KSerializer<Coding> = Coding.serializer()

    public val permittedUnitSer: KSerializer<List<Coding>> =
      ListSerializer(Hoisted.permittedUnitSerInner)

    public val qualifiedValueSerInner: KSerializer<ObservationDefinition.QualifiedValue> =
      ObservationDefinition.QualifiedValue.serializer()

    public val qualifiedValueSer: KSerializer<List<ObservationDefinition.QualifiedValue>> =
      ListSerializer(Hoisted.qualifiedValueSerInner)
  }
}

internal object ObservationDefinitionSerializer : KSerializer<ObservationDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ObservationDefinition") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "derivedFromCanonical",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_derivedFromCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "derivedFromUri",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_derivedFromUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "subject",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("performerType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "permittedDataType",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_permittedDataType",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("multipleResultsAllowed", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_multipleResultsAllowed", Element.serializer().descriptor, isOptional = true)
    b.element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("method", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "specimen",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("device", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("preferredReportName", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_preferredReportName", Element.serializer().descriptor, isOptional = true)
    b.element(
      "permittedUnit",
      listSerialDescriptor(Coding.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "qualifiedValue",
      listSerialDescriptor(
        lazyDescriptor { ObservationDefinition.QualifiedValue.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "hasMember",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "component",
      listSerialDescriptor(
        lazyDescriptor { ObservationDefinition.Component.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ObservationDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        35 -> purpose = decoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 -> copyright = decoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        42 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        44 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        46 ->
          derivedFromCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.derivedFromCanonicalSer,
              null,
            )
        47 ->
          _derivedFromCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.derivedFromCanonicalSer2,
              null,
            )
        48 ->
          derivedFromUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.derivedFromCanonicalSer,
              null,
            )
        49 ->
          _derivedFromUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.derivedFromCanonicalSer2,
              null,
            )
        50 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        51 ->
          performerType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.jurisdictionSerInner,
              null,
            )
        52 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        53 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.jurisdictionSerInner,
              null,
            )
        54 ->
          permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.derivedFromCanonicalSer,
              null,
            )
        55 ->
          _permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.derivedFromCanonicalSer2,
              null,
            )
        56 -> multipleResultsAllowed = decoder.decodeBooleanElement(descriptor, i)
        57 ->
          _multipleResultsAllowed =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        58 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.jurisdictionSerInner,
              null,
            )
        59 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.jurisdictionSerInner,
              null,
            )
        60 ->
          specimen =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.specimenSer, null)
        61 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.specimenSer, null)
        62 -> preferredReportName = decoder.decodeStringElement(descriptor, i)
        63 ->
          _preferredReportName =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        64 ->
          permittedUnit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.permittedUnitSer, null)
        65 ->
          qualifiedValue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.qualifiedValueSer,
              null,
            )
        66 ->
          hasMember =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.specimenSer, null)
        67 ->
          component =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.componentSer, null)
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
        Enumeration.of(
          PublicationStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on ObservationDefinition"
              )
          ),
          _status,
        ),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(approvalDate?.let { FhirDate.fromString(it) }, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate?.let { FhirDate.fromString(it) }, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      derivedFromCanonical =
        (kotlin.collections.List(
          maxOf(derivedFromCanonical?.size ?: 0, _derivedFromCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            derivedFromCanonical?.getOrNull(index)?.let { it },
            _derivedFromCanonical?.getOrNull(index),
          )!!
        }),
      derivedFromUri =
        (kotlin.collections.List(maxOf(derivedFromUri?.size ?: 0, _derivedFromUri?.size ?: 0)) {
          index ->
          Uri.of(derivedFromUri?.getOrNull(index)?.let { it }, _derivedFromUri?.getOrNull(index))!!
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
            ObservationDefinition.ObservationDataType.fromCode(
              permittedDataType?.getOrNull(index)!!
            ),
            _permittedDataType?.getOrNull(index),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ObservationDefinition,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        it,
      )
    }
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is ObservationDefinition.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is ObservationDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.versionAlgorithmCodingSer,
          choice.value,
        )
      }
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    (value.derivedFromCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.derivedFromCanonicalSer,
        it,
      )
    }
    (value.derivedFromCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.derivedFromCanonicalSer2,
        it,
      )
    }
    (value.derivedFromUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.derivedFromCanonicalSer,
        it,
      )
    }
    (value.derivedFromUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.derivedFromCanonicalSer2,
        it,
      )
    }
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.subject,
      )
    (value.performerType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.jurisdictionSerInner,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      53 + descriptorOffset,
      Hoisted.jurisdictionSerInner,
      value.code,
    )
    (value.permittedDataType.map { it.value?.getCode() }.takeUnless { it.all { it == null } })
      ?.let {
        encoder.encodeSerializableElement(
          descriptor,
          54 + descriptorOffset,
          Hoisted.derivedFromCanonicalSer,
          it,
        )
      }
    (value.permittedDataType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.derivedFromCanonicalSer2,
        it,
      )
    }
    ((value.multipleResultsAllowed?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 56 + descriptorOffset, it)
    }
    (value.multipleResultsAllowed?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        Hoisted.jurisdictionSerInner,
        it,
      )
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        Hoisted.jurisdictionSerInner,
        it,
      )
    }
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        Hoisted.specimenSer,
        value.specimen,
      )
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        61 + descriptorOffset,
        Hoisted.specimenSer,
        value.device,
      )
    ((value.preferredReportName?.value))?.let {
      encoder.encodeStringElement(descriptor, 62 + descriptorOffset, it)
    }
    (value.preferredReportName?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.permittedUnit.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        64 + descriptorOffset,
        Hoisted.permittedUnitSer,
        value.permittedUnit,
      )
    if (value.qualifiedValue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        65 + descriptorOffset,
        Hoisted.qualifiedValueSer,
        value.qualifiedValue,
      )
    if (value.hasMember.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        66 + descriptorOffset,
        Hoisted.specimenSer,
        value.hasMember,
      )
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        67 + descriptorOffset,
        Hoisted.componentSer,
        value.component,
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

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val derivedFromCanonicalSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val derivedFromCanonicalSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.derivedFromCanonicalSerInner).nullable)

    public val derivedFromCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val specimenSerInner: KSerializer<Reference> = Reference.serializer()

    public val specimenSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.specimenSerInner)

    public val permittedUnitSer: KSerializer<List<Coding>> =
      ListSerializer(Hoisted.versionAlgorithmCodingSer)

    public val qualifiedValueSerInner: KSerializer<ObservationDefinition.QualifiedValue> =
      ObservationDefinition.QualifiedValue.serializer()

    public val qualifiedValueSer: KSerializer<List<ObservationDefinition.QualifiedValue>> =
      ListSerializer(Hoisted.qualifiedValueSerInner)

    public val componentSerInner: KSerializer<ObservationDefinition.Component> =
      ObservationDefinition.Component.serializer()

    public val componentSer: KSerializer<List<ObservationDefinition.Component>> =
      ListSerializer(Hoisted.componentSerInner)
  }
}

internal object ObservationDefinitionPolymorphicSerializer : KSerializer<ObservationDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ObservationDefinition") {
      ObservationDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition) {
    encoder.encodeStructure(descriptor) {
      ObservationDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition =
    decoder.decodeStructure(descriptor) {
      ObservationDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
