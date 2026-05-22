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

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.ObservationDefinition
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.AdministrativeGender
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QuantitativeDetails) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ObservationDefinition.QuantitativeDetails {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          customaryUnit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.customaryUnitSer, null)
        4 ->
          unit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.customaryUnitSer, null)
        5 ->
          conversionFactor =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        6 ->
          _conversionFactor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.conversionFactorSer,
              null,
            )
        7 -> decimalPrecision = decoder.decodeIntElement(descriptor, i)
        8 ->
          _decimalPrecision =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.conversionFactorSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding QuantitativeDetails: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ObservationDefinition.QuantitativeDetails,
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
    (value.customaryUnit)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.customaryUnitSer, it)
    }
    (value.unit)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.customaryUnitSer, it)
    }
    ((value.conversionFactor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 5, BigDecimalSerializer, it)
    }
    (value.conversionFactor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.conversionFactorSer, it)
    }
    ((value.decimalPrecision?.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.decimalPrecision?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.conversionFactorSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QualifiedInterval) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ObservationDefinition.QualifiedInterval {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> category = decoder.decodeStringElement(descriptor, i)
        4 ->
          _category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        5 ->
          range = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rangeSer, null)
        6 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contextSer, null)
        7 ->
          appliesTo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.appliesToSer, null)
        8 -> gender = decoder.decodeStringElement(descriptor, i)
        9 ->
          _gender =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        10 -> age = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rangeSer, null)
        11 ->
          gestationalAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rangeSer, null)
        12 -> condition = decoder.decodeStringElement(descriptor, i)
        13 ->
          _condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding QualifiedInterval: " + i)
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
      condition = R4bString.of(condition, _condition),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ObservationDefinition.QualifiedInterval,
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
    ((value.category?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.category?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.categorySer, it)
    }
    (value.range)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.rangeSer, it) }
    (value.context)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.contextSer, it)
    }
    if (value.appliesTo.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.appliesToSer, value.appliesTo)
    ((value.gender?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.categorySer, it)
    }
    (value.age)?.let { encoder.encodeSerializableElement(descriptor, 10, Hoisted.rangeSer, it) }
    (value.gestationalAge)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.rangeSer, it)
    }
    ((value.condition?.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.condition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.categorySer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

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
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        11 ->
          code =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 ->
          permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.permittedDataTypeSer,
              null,
            )
        14 ->
          _permittedDataType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.permittedDataTypeSer2,
              null,
            )
        15 -> multipleResultsAllowed = decoder.decodeBooleanElement(descriptor, i)
        16 ->
          _multipleResultsAllowed =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          method =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        18 -> preferredReportName = decoder.decodeStringElement(descriptor, i)
        19 ->
          _preferredReportName =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 ->
          quantitativeDetails =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.quantitativeDetailsSer,
              null,
            )
        21 ->
          qualifiedInterval =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.qualifiedIntervalSer,
              null,
            )
        22 ->
          validCodedValueSet =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.validCodedValueSetSer,
              null,
            )
        23 ->
          normalCodedValueSet =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.validCodedValueSetSer,
              null,
            )
        24 ->
          abnormalCodedValueSet =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.validCodedValueSetSer,
              null,
            )
        25 ->
          criticalCodedValueSet =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.validCodedValueSetSer,
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
      code = code!!,
      identifier = identifier ?: listOf(),
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
      multipleResultsAllowed = R4bBoolean.of(multipleResultsAllowed, _multipleResultsAllowed),
      method = method,
      preferredReportName = R4bString.of(preferredReportName, _preferredReportName),
      quantitativeDetails = quantitativeDetails,
      qualifiedInterval = qualifiedInterval ?: listOf(),
      validCodedValueSet = validCodedValueSet,
      normalCodedValueSet = normalCodedValueSet,
      abnormalCodedValueSet = abnormalCodedValueSet,
      criticalCodedValueSet = criticalCodedValueSet,
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    (value.code)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    (value.permittedDataType.map { it.value?.getCode() }.takeUnless { it.all { it == null } })
      ?.let {
        encoder.encodeSerializableElement(
          descriptor,
          13 + descriptorOffset,
          Hoisted.permittedDataTypeSer,
          it,
        )
      }
    (value.permittedDataType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.permittedDataTypeSer2,
        it,
      )
    }
    ((value.multipleResultsAllowed?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.multipleResultsAllowed?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    ((value.preferredReportName?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.preferredReportName?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.quantitativeDetails)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.quantitativeDetailsSer,
        it,
      )
    }
    if (value.qualifiedInterval.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.qualifiedIntervalSer,
        value.qualifiedInterval,
      )
    (value.validCodedValueSet)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.validCodedValueSetSer,
        it,
      )
    }
    (value.normalCodedValueSet)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.validCodedValueSetSer,
        it,
      )
    }
    (value.abnormalCodedValueSet)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.validCodedValueSetSer,
        it,
      )
    }
    (value.criticalCodedValueSet)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.validCodedValueSetSer,
        it,
      )
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
      ObservationDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition =
    decoder.decodeStructure(descriptor) {
      ObservationDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
