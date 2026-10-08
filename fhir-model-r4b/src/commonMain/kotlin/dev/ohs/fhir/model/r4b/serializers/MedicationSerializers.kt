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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.MedicationStatusCodes
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

internal object MedicationIngredientSerializer : KSerializer<Medication.Ingredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Ingredient") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("itemReference", ReferenceSerializer.descriptor)
      optionalElement("isActive", KotlinBoolean.serializer().descriptor)
      optionalElement("_isActive", ElementSerializer.descriptor)
      optionalElement("strength", RatioSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Medication.Ingredient>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Medication.Ingredient {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
    var isActive: KotlinBoolean? = null
    var _isActive: Element? = null
    var strength: Ratio? = null
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
          itemCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          itemReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        5 -> isActive = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _isActive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          strength =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Medication.Ingredient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item =
        Medication.Ingredient.Item.from(itemCodeableConcept, itemReference)
          ?: throw SerializationException(
            "Missing required property 'item' on Medication.Ingredient"
          ),
      isActive = R4bBoolean.of(isActive, _isActive),
      strength = strength,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Medication.Ingredient) {
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
    when (val choice = value.item) {
      is Medication.Ingredient.Item.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Medication.Ingredient.Item.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.isActive?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.isActive)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, RatioSerializer, value.strength)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicationBatchSerializer : KSerializer<Medication.Batch> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Batch") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("lotNumber", KotlinString.serializer().descriptor)
      optionalElement("_lotNumber", ElementSerializer.descriptor)
      optionalElement("expirationDate", KotlinString.serializer().descriptor)
      optionalElement("_expirationDate", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Medication.Batch>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Medication.Batch {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var lotNumber: KotlinString? = null
    var _lotNumber: Element? = null
    var expirationDate: KotlinString? = null
    var _expirationDate: Element? = null
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
        3 -> lotNumber = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _lotNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> expirationDate = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _expirationDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Batch: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Medication.Batch(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      lotNumber = R4bString.of(lotNumber, _lotNumber),
      expirationDate =
        DateTime.of(
          if (expirationDate != null) FhirDateTime.fromString(expirationDate) else null,
          _expirationDate,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Medication.Batch) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.lotNumber?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.lotNumber)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.expirationDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.expirationDate)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicationSerializer : FhirResourceSerializer<Medication> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Medication")

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
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.descriptor)
    b.optionalElement("form", CodeableConceptSerializer.descriptor)
    b.optionalElement("amount", RatioSerializer.descriptor)
    b.optionalElement("ingredient", MedicationIngredientSerializer.listSerializer.descriptor)
    b.optionalElement("batch", MedicationBatchSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Medication {
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
    var code: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var manufacturer: Reference? = null
    var form: CodeableConcept? = null
    var amount: Ratio? = null
    var ingredient: List<Medication.Ingredient>? = null
    var batch: Medication.Batch? = null
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
        11 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        15 ->
          form =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        17 ->
          ingredient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationIngredientSerializer.listSerializer,
              null,
            )
        18 ->
          batch =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationBatchSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Medication: " + i)
      }
    }
    return Medication(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      code = code,
      status =
        Enumeration.of(
          if (status != null) MedicationStatusCodes.fromCode(status) else null,
          _status,
        ),
      manufacturer = manufacturer,
      form = form,
      amount = amount,
      ingredient = ingredient ?: listOf(),
      batch = batch,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Medication,
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
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.status?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.form,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      RatioSerializer,
      value.amount,
    )
    if (value.ingredient.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        MedicationIngredientSerializer.listSerializer,
        value.ingredient,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      MedicationBatchSerializer,
      value.batch,
    )
  }
}
