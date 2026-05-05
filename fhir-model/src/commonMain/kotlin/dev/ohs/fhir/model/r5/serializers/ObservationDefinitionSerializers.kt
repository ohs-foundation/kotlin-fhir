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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QualifiedValue) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ObservationDefinition.QualifiedValue {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          context = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.contextSer, null)
        4 ->
          appliesTo =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.appliesToSer, null)
        5 -> gender = decoder.decodeStringElement(__desc, 5)
        6 -> _gender = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.genderSer, null)
        7 -> age = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.ageSer, null)
        8 ->
          gestationalAge =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.ageSer, null)
        9 -> condition = decoder.decodeStringElement(__desc, 9)
        10 ->
          _condition =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.genderSer, null)
        11 -> rangeCategory = decoder.decodeStringElement(__desc, 11)
        12 ->
          _rangeCategory =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.genderSer, null)
        13 -> range = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.ageSer, null)
        14 -> validCodedValueSet = decoder.decodeStringElement(__desc, 14)
        15 ->
          _validCodedValueSet =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.genderSer, null)
        16 -> normalCodedValueSet = decoder.decodeStringElement(__desc, 16)
        17 ->
          _normalCodedValueSet =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.genderSer, null)
        18 -> abnormalCodedValueSet = decoder.decodeStringElement(__desc, 18)
        19 ->
          _abnormalCodedValueSet =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.genderSer, null)
        20 -> criticalCodedValueSet = decoder.decodeStringElement(__desc, 20)
        21 ->
          _criticalCodedValueSet =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.genderSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding QualifiedValue: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ObservationDefinition.QualifiedValue,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.context)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.contextSer, it) }
    if (value.appliesTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.appliesToSer, value.appliesTo)
    ((value.gender?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.genderSer, it)
    }
    (value.age)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.ageSer, it) }
    (value.gestationalAge)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.ageSer, it) }
    ((value.condition?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.condition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.genderSer, it)
    }
    ((value.rangeCategory?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.rangeCategory?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.genderSer, it)
    }
    (value.range)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.ageSer, it) }
    ((value.validCodedValueSet?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.validCodedValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.genderSer, it)
    }
    ((value.normalCodedValueSet?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.normalCodedValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.genderSer, it)
    }
    ((value.abnormalCodedValueSet?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.abnormalCodedValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.genderSer, it)
    }
    ((value.criticalCodedValueSet?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.criticalCodedValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.genderSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.Component) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ObservationDefinition.Component {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var permittedDataType: List<KotlinString?>? = null
    var _permittedDataType: List<Element?>? = null
    var permittedUnit: List<Coding>? = null
    var qualifiedValue: List<ObservationDefinition.QualifiedValue>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          permittedDataType =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.permittedDataTypeSer, null)
        5 ->
          _permittedDataType =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.permittedDataTypeSer2,
              null,
            )
        6 ->
          permittedUnit =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.permittedUnitSer, null)
        7 ->
          qualifiedValue =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.qualifiedValueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + __i)
      }
    }
    return ObservationDefinition.Component(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      permittedDataType =
        (kotlin.collections.List(
          maxOf(permittedDataType?.size ?: 0, _permittedDataType?.size ?: 0)
        ) { __i ->
          Enumeration.of(
            ObservationDefinition.ObservationDataType.fromCode(permittedDataType?.getOrNull(__i)!!),
            _permittedDataType?.getOrNull(__i),
          )
        }),
      permittedUnit = permittedUnit ?: listOf(),
      qualifiedValue = qualifiedValue ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ObservationDefinition.Component) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.permittedDataType.map { it.value?.getCode() }.takeUnless { it.all { it == null } })
      ?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.permittedDataTypeSer, it) }
    (value.permittedDataType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.permittedDataTypeSer2, it)
    }
    if (value.permittedUnit.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.permittedUnitSer, value.permittedUnit)
    if (value.qualifiedValue.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.qualifiedValueSer, value.qualifiedValue)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ObservationDefinition")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ObservationDefinition {
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
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 16)
        17 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        19 -> name = decoder.decodeStringElement(__desc, 19)
        20 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> title = decoder.decodeStringElement(__desc, 21)
        22 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> status = decoder.decodeStringElement(__desc, 23)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> experimental = decoder.decodeBooleanElement(__desc, 25)
        26 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> date = decoder.decodeStringElement(__desc, 27)
        28 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> publisher = decoder.decodeStringElement(__desc, 29)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.contactSer, null)
        32 -> description = decoder.decodeStringElement(__desc, 32)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.useContextSer, null)
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.jurisdictionSer, null)
        36 -> purpose = decoder.decodeStringElement(__desc, 36)
        37 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> copyright = decoder.decodeStringElement(__desc, 38)
        39 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> copyrightLabel = decoder.decodeStringElement(__desc, 40)
        41 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 -> approvalDate = decoder.decodeStringElement(__desc, 42)
        43 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 -> lastReviewDate = decoder.decodeStringElement(__desc, 44)
        45 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.effectivePeriodSer, null)
        47 ->
          derivedFromCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              47,
              Hoisted.derivedFromCanonicalSer,
              null,
            )
        48 ->
          _derivedFromCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              48,
              Hoisted.derivedFromCanonicalSer2,
              null,
            )
        49 ->
          derivedFromUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              49,
              Hoisted.derivedFromCanonicalSer,
              null,
            )
        50 ->
          _derivedFromUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              50,
              Hoisted.derivedFromCanonicalSer2,
              null,
            )
        51 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.jurisdictionSer, null)
        52 ->
          performerType =
            decoder.decodeNullableSerializableElement(
              __desc,
              52,
              Hoisted.jurisdictionSerInner,
              null,
            )
        53 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.jurisdictionSer, null)
        54 ->
          code =
            decoder.decodeNullableSerializableElement(
              __desc,
              54,
              Hoisted.jurisdictionSerInner,
              null,
            )
        55 ->
          permittedDataType =
            decoder.decodeNullableSerializableElement(
              __desc,
              55,
              Hoisted.derivedFromCanonicalSer,
              null,
            )
        56 ->
          _permittedDataType =
            decoder.decodeNullableSerializableElement(
              __desc,
              56,
              Hoisted.derivedFromCanonicalSer2,
              null,
            )
        57 -> multipleResultsAllowed = decoder.decodeBooleanElement(__desc, 57)
        58 ->
          _multipleResultsAllowed =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.implicitRulesSer, null)
        59 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              __desc,
              59,
              Hoisted.jurisdictionSerInner,
              null,
            )
        60 ->
          method =
            decoder.decodeNullableSerializableElement(
              __desc,
              60,
              Hoisted.jurisdictionSerInner,
              null,
            )
        61 ->
          specimen =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.specimenSer, null)
        62 ->
          device = decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.specimenSer, null)
        63 -> preferredReportName = decoder.decodeStringElement(__desc, 63)
        64 ->
          _preferredReportName =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.implicitRulesSer, null)
        65 ->
          permittedUnit =
            decoder.decodeNullableSerializableElement(__desc, 65, Hoisted.permittedUnitSer, null)
        66 ->
          qualifiedValue =
            decoder.decodeNullableSerializableElement(__desc, 66, Hoisted.qualifiedValueSer, null)
        67 ->
          hasMember =
            decoder.decodeNullableSerializableElement(__desc, 67, Hoisted.specimenSer, null)
        68 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, 68, Hoisted.componentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ObservationDefinition: " + __i)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      effectivePeriod = effectivePeriod,
      derivedFromCanonical =
        (kotlin.collections.List(
          maxOf(derivedFromCanonical?.size ?: 0, _derivedFromCanonical?.size ?: 0)
        ) { __i ->
          Canonical.of(
            derivedFromCanonical?.getOrNull(__i)?.let { it },
            _derivedFromCanonical?.getOrNull(__i),
          )!!
        }),
      derivedFromUri =
        (kotlin.collections.List(maxOf(derivedFromUri?.size ?: 0, _derivedFromUri?.size ?: 0)) { __i
          ->
          Uri.of(derivedFromUri?.getOrNull(__i)?.let { it }, _derivedFromUri?.getOrNull(__i))!!
        }),
      subject = subject ?: listOf(),
      performerType = performerType,
      category = category ?: listOf(),
      code = code!!,
      permittedDataType =
        (kotlin.collections.List(
          maxOf(permittedDataType?.size ?: 0, _permittedDataType?.size ?: 0)
        ) { __i ->
          Enumeration.of(
            ObservationDefinition.ObservationDataType.fromCode(permittedDataType?.getOrNull(__i)!!),
            _permittedDataType?.getOrNull(__i),
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

  internal fun serializeJson(encoder: CompositeEncoder, `value`: ObservationDefinition) {
    val __desc = descriptor
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is ObservationDefinition.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is ObservationDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.versionAlgorithmCodingSer, __d.value)
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 25, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.copyrightLabel?.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 42, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 44, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.effectivePeriodSer, it)
    }
    (value.derivedFromCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.derivedFromCanonicalSer, it)
    }
    (value.derivedFromCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.derivedFromCanonicalSer2, it)
    }
    (value.derivedFromUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.derivedFromCanonicalSer, it)
    }
    (value.derivedFromUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 50, Hoisted.derivedFromCanonicalSer2, it)
    }
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.jurisdictionSer, value.subject)
    (value.performerType)?.let {
      encoder.encodeSerializableElement(__desc, 52, Hoisted.jurisdictionSerInner, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.jurisdictionSer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 54, Hoisted.jurisdictionSerInner, it)
    }
    (value.permittedDataType.map { it.value?.getCode() }.takeUnless { it.all { it == null } })
      ?.let { encoder.encodeSerializableElement(__desc, 55, Hoisted.derivedFromCanonicalSer, it) }
    (value.permittedDataType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 56, Hoisted.derivedFromCanonicalSer2, it)
    }
    ((value.multipleResultsAllowed?.value))?.let { encoder.encodeBooleanElement(__desc, 57, it) }
    (value.multipleResultsAllowed?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 58, Hoisted.implicitRulesSer, it)
    }
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(__desc, 59, Hoisted.jurisdictionSerInner, it)
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(__desc, 60, Hoisted.jurisdictionSerInner, it)
    }
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 61, Hoisted.specimenSer, value.specimen)
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 62, Hoisted.specimenSer, value.device)
    ((value.preferredReportName?.value))?.let { encoder.encodeStringElement(__desc, 63, it) }
    (value.preferredReportName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 64, Hoisted.implicitRulesSer, it)
    }
    if (value.permittedUnit.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 65, Hoisted.permittedUnitSer, value.permittedUnit)
    if (value.qualifiedValue.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 66, Hoisted.qualifiedValueSer, value.qualifiedValue)
    if (value.hasMember.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 67, Hoisted.specimenSer, value.hasMember)
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 68, Hoisted.componentSer, value.component)
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
      ObservationDefinitionSerializer.serializeJson(this, value)
    }
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition =
    decoder.decodeStructure(descriptor) { ObservationDefinitionSerializer.deserializeJson(this) }
}
