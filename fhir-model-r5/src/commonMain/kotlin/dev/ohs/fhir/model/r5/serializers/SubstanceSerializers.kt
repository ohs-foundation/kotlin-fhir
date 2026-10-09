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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.FHIRSubstanceStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object SubstanceIngredientSerializer : FhirSerializer<Substance.Ingredient> {
  override val descriptor: SerialDescriptor = buildDescriptor("Ingredient", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Substance.Ingredient>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("quantity", RatioSerializer.descriptor)
    b.optionalElement("substanceCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("substanceReference", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Substance.Ingredient {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var quantity: Ratio? = null
    var substanceCodeableConcept: CodeableConcept? = null
    var substanceReference: Reference? = null
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
          quantity =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        4 ->
          substanceCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          substanceReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Substance.Ingredient(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      quantity = quantity,
      substance =
        required(
          Substance.Ingredient.Substance.from(substanceCodeableConcept, substanceReference),
          "Substance.Ingredient",
          "substance",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Substance.Ingredient) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, RatioSerializer, value.quantity)
    when (val choice = value.substance) {
      is Substance.Ingredient.Substance.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Substance.Ingredient.Substance.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSerializer : FhirResourceSerializer<Substance> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Substance")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.boolPrim("instance")
    b.strPrim("status")
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableReferenceSerializer.descriptor)
    b.strPrim("description")
    b.strPrim("expiry")
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("ingredient", SubstanceIngredientSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Substance {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var instance: KotlinBoolean? = null
    var _instance: Element? = null
    var status: FHIRSubstanceStatus? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableReference? = null
    var description: String? = null
    var _description: Element? = null
    var expiry: FhirDateTime? = null
    var _expiry: Element? = null
    var quantity: Quantity? = null
    var ingredient: List<Substance.Ingredient>? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> instance = compositeDecoder.decodeBooleanElement(descriptor, i)
        12 ->
          _instance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          status = FHIRSubstanceStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        17 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> expiry = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        20 ->
          _expiry =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        22 ->
          ingredient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceIngredientSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Substance(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      instance = required(R5Boolean.of(instance, _instance), "Substance", "instance"),
      status = Enumeration.of(status, _status),
      category = listOrEmpty(category),
      code = required(code, "Substance", "code"),
      description = Markdown.of(description, _description),
      expiry = DateTime.of(expiry, _expiry),
      quantity = quantity,
      ingredient = listOrEmpty(ingredient),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Substance,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 11 + descriptorOffset, value.instance.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.instance)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.status?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      CodeableReferenceSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.description)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.expiry?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.expiry)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      SubstanceIngredientSerializer.listSerializer,
      value.ingredient,
    )
  }
}
