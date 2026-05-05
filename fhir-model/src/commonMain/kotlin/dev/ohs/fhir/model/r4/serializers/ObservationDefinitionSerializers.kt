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

package dev.ohs.fhir.model.r4.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.ObservationDefinition
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.AdministrativeGender
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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

internal object ObservationDefinitionQuantitativeDetailsSerializer :
  KSerializer<ObservationDefinition.QuantitativeDetails> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QuantitativeDetails") {
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
      element("customaryUnit", CodeableConcept.serializer().descriptor, isOptional = true)
      element("unit", CodeableConcept.serializer().descriptor, isOptional = true)
      element("conversionFactor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_conversionFactor", Element.serializer().descriptor, isOptional = true)
      element("decimalPrecision", Int.serializer().descriptor, isOptional = true)
      element("_decimalPrecision", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ObservationDefinition.QuantitativeDetails =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QuantitativeDetails) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ObservationDefinition.QuantitativeDetails {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var customaryUnit: CodeableConcept? = null
    var unit: CodeableConcept? = null
    var conversionFactor: BigDecimal? = null
    var _conversionFactor: Element? = null
    var decimalPrecision: Int? = null
    var _decimalPrecision: Element? = null
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
          customaryUnit =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.customaryUnitSer, null)
        4 ->
          unit =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.customaryUnitSer, null)
        5 ->
          conversionFactor =
            decoder.decodeNullableSerializableElement(__desc, 5, BigDecimalSerializer, null)
        6 ->
          _conversionFactor =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.conversionFactorSer, null)
        7 -> decimalPrecision = decoder.decodeIntElement(__desc, 7)
        8 ->
          _decimalPrecision =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.conversionFactorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding QuantitativeDetails: " + __i)
      }
    }
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ObservationDefinition.QuantitativeDetails,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.customaryUnit)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.customaryUnitSer, it)
    }
    (value.unit)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.customaryUnitSer, it) }
    ((value.conversionFactor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 5, BigDecimalSerializer, it)
    }
    (value.conversionFactor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.conversionFactorSer, it)
    }
    ((value.decimalPrecision?.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.decimalPrecision?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.conversionFactorSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val customaryUnitSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val conversionFactorSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ObservationDefinitionQualifiedIntervalSerializer :
  KSerializer<ObservationDefinition.QualifiedInterval> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QualifiedInterval") {
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
      element("category", KotlinString.serializer().descriptor, isOptional = true)
      element("_category", Element.serializer().descriptor, isOptional = true)
      element("range", Range.serializer().descriptor, isOptional = true)
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
    }

  override fun deserialize(decoder: Decoder): ObservationDefinition.QualifiedInterval =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QualifiedInterval) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ObservationDefinition.QualifiedInterval {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> category = decoder.decodeStringElement(__desc, 3)
        4 ->
          _category =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.categorySer, null)
        5 -> range = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.rangeSer, null)
        6 ->
          context = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.contextSer, null)
        7 ->
          appliesTo =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.appliesToSer, null)
        8 -> gender = decoder.decodeStringElement(__desc, 8)
        9 ->
          _gender = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.categorySer, null)
        10 -> age = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.rangeSer, null)
        11 ->
          gestationalAge =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.rangeSer, null)
        12 -> condition = decoder.decodeStringElement(__desc, 12)
        13 ->
          _condition =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.categorySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding QualifiedInterval: " + __i)
      }
    }
    return ObservationDefinition.QualifiedInterval(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category =
        category?.let {
          Enumeration.of(ObservationDefinition.ObservationRangeCategory.fromCode(it), _category)
        },
      range = range,
      context = context,
      appliesTo = appliesTo ?: listOf(),
      gender = gender?.let { Enumeration.of(AdministrativeGender.fromCode(it), _gender) },
      age = age,
      gestationalAge = gestationalAge,
      condition = R4String.of(condition, _condition),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ObservationDefinition.QualifiedInterval,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.category?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.category?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.categorySer, it)
    }
    (value.range)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.rangeSer, it) }
    (value.context)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.contextSer, it) }
    if (value.appliesTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.appliesToSer, value.appliesTo)
    ((value.gender?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.categorySer, it)
    }
    (value.age)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.rangeSer, it) }
    (value.gestationalAge)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.rangeSer, it)
    }
    ((value.condition?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.condition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.categorySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<Element> = Element.serializer()

    public val rangeSer: KSerializer<Range> = Range.serializer()

    public val contextSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val appliesToSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.contextSer)
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
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
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
    b.element("method", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("preferredReportName", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_preferredReportName", Element.serializer().descriptor, isOptional = true)
    b.element(
      "quantitativeDetails",
      lazyDescriptor { ObservationDefinition.QuantitativeDetails.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "qualifiedInterval",
      listSerialDescriptor(
        lazyDescriptor { ObservationDefinition.QualifiedInterval.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("validCodedValueSet", Reference.serializer().descriptor, isOptional = true)
    b.element("normalCodedValueSet", Reference.serializer().descriptor, isOptional = true)
    b.element("abnormalCodedValueSet", Reference.serializer().descriptor, isOptional = true)
    b.element("criticalCodedValueSet", Reference.serializer().descriptor, isOptional = true)
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
          category =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.categorySer, null)
        12 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.categorySerInner, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 ->
          permittedDataType =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.permittedDataTypeSer,
              null,
            )
        15 ->
          _permittedDataType =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.permittedDataTypeSer2,
              null,
            )
        16 -> multipleResultsAllowed = decoder.decodeBooleanElement(__desc, 16)
        17 ->
          _multipleResultsAllowed =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          method =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.categorySerInner, null)
        19 -> preferredReportName = decoder.decodeStringElement(__desc, 19)
        20 ->
          _preferredReportName =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 ->
          quantitativeDetails =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.quantitativeDetailsSer,
              null,
            )
        22 ->
          qualifiedInterval =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
              Hoisted.qualifiedIntervalSer,
              null,
            )
        23 ->
          validCodedValueSet =
            decoder.decodeNullableSerializableElement(
              __desc,
              23,
              Hoisted.validCodedValueSetSer,
              null,
            )
        24 ->
          normalCodedValueSet =
            decoder.decodeNullableSerializableElement(
              __desc,
              24,
              Hoisted.validCodedValueSetSer,
              null,
            )
        25 ->
          abnormalCodedValueSet =
            decoder.decodeNullableSerializableElement(
              __desc,
              25,
              Hoisted.validCodedValueSetSer,
              null,
            )
        26 ->
          criticalCodedValueSet =
            decoder.decodeNullableSerializableElement(
              __desc,
              26,
              Hoisted.validCodedValueSetSer,
              null,
            )
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
      category = category ?: listOf(),
      code = code!!,
      identifier = identifier ?: listOf(),
      permittedDataType =
        (kotlin.collections.List(
          maxOf(permittedDataType?.size ?: 0, _permittedDataType?.size ?: 0)
        ) { __i ->
          Enumeration.of(
            ObservationDefinition.ObservationDataType.fromCode(permittedDataType?.getOrNull(__i)!!),
            _permittedDataType?.getOrNull(__i),
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.categorySer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.categorySerInner, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    (value.permittedDataType.map { it.value?.getCode() }.takeUnless { it.all { it == null } })
      ?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.permittedDataTypeSer, it) }
    (value.permittedDataType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.permittedDataTypeSer2, it)
    }
    ((value.multipleResultsAllowed?.value))?.let { encoder.encodeBooleanElement(__desc, 16, it) }
    (value.multipleResultsAllowed?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.categorySerInner, it)
    }
    ((value.preferredReportName?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.preferredReportName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    (value.quantitativeDetails)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.quantitativeDetailsSer, it)
    }
    if (value.qualifiedInterval.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22,
        Hoisted.qualifiedIntervalSer,
        value.qualifiedInterval,
      )
    (value.validCodedValueSet)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.validCodedValueSetSer, it)
    }
    (value.normalCodedValueSet)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.validCodedValueSetSer, it)
    }
    (value.abnormalCodedValueSet)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.validCodedValueSetSer, it)
    }
    (value.criticalCodedValueSet)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.validCodedValueSetSer, it)
    }
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

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val permittedDataTypeSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val permittedDataTypeSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.permittedDataTypeSerInner).nullable)

    public val permittedDataTypeSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val quantitativeDetailsSer: KSerializer<ObservationDefinition.QuantitativeDetails> =
      ObservationDefinition.QuantitativeDetails.serializer()

    public val qualifiedIntervalSerInner: KSerializer<ObservationDefinition.QualifiedInterval> =
      ObservationDefinition.QualifiedInterval.serializer()

    public val qualifiedIntervalSer: KSerializer<List<ObservationDefinition.QualifiedInterval>> =
      ListSerializer(Hoisted.qualifiedIntervalSerInner)

    public val validCodedValueSetSer: KSerializer<Reference> = Reference.serializer()
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
