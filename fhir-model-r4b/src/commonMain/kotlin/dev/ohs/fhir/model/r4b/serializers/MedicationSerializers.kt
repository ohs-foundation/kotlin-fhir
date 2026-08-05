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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object MedicationIngredientSerializer : KSerializer<Medication.Ingredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Ingredient") {
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
      element("itemCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("itemReference", Reference.serializer().descriptor, isOptional = true)
      element("isActive", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isActive", Element.serializer().descriptor, isOptional = true)
      element("strength", Ratio.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Medication.Ingredient =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Medication.Ingredient) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Medication.Ingredient {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
    var isActive: KotlinBoolean? = null
    var _isActive: Element? = null
    var strength: Ratio? = null
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
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        4 ->
          itemReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemReferenceSer, null)
        5 -> isActive = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _isActive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.isActiveSer, null)
        7 ->
          strength =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
      }
    }
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Medication.Ingredient) {
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
    when (val choice = value.item) {
      is Medication.Ingredient.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.itemCodeableConceptSer,
          choice.value,
        )
      }
      is Medication.Ingredient.Item.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.itemReferenceSer, choice.value)
      }
    }
    ((value.isActive?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.isActive?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.isActiveSer, it)
    }
    (value.strength)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.strengthSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val itemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val isActiveSer: KSerializer<Element> = Element.serializer()

    public val strengthSer: KSerializer<Ratio> = Ratio.serializer()
  }
}

internal object MedicationBatchSerializer : KSerializer<Medication.Batch> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Batch") {
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
      element("lotNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_lotNumber", Element.serializer().descriptor, isOptional = true)
      element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_expirationDate", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Medication.Batch =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Medication.Batch) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Medication.Batch {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var lotNumber: KotlinString? = null
    var _lotNumber: Element? = null
    var expirationDate: KotlinString? = null
    var _expirationDate: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> lotNumber = decoder.decodeStringElement(descriptor, i)
        4 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.lotNumberSer, null)
        5 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        6 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.lotNumberSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Batch: " + i)
      }
    }
    return Medication.Batch(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      lotNumber = R4bString.of(lotNumber, _lotNumber),
      expirationDate = DateTime.of(FhirDateTime.fromString(expirationDate), _expirationDate),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Medication.Batch) {
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
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.lotNumberSer, it)
    }
    ((value.expirationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 5, it)
    }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.lotNumberSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val lotNumberSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MedicationSerializer : KSerializer<Medication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Medication") {
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
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("manufacturer", Reference.serializer().descriptor, isOptional = true)
    b.element("form", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("amount", Ratio.serializer().descriptor, isOptional = true)
    b.element(
      "ingredient",
      listSerialDescriptor(lazyDescriptor { Medication.Ingredient.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "batch",
      lazyDescriptor { Medication.Batch.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Medication =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Medication) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Medication")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
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
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.manufacturerSer, null)
        15 -> form = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        16 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        17 ->
          ingredient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ingredientSer, null)
        18 ->
          batch = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.batchSer, null)
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
        status?.let { Enumeration.of(Medication.MedicationStatusCodes.fromCode(it), _status) },
      manufacturer = manufacturer,
      form = form,
      amount = amount,
      ingredient = ingredient ?: listOf(),
      batch = batch,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Medication,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    (value.code)?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, Hoisted.codeSer, it)
    }
    ((value.status?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.manufacturerSer,
        it,
      )
    }
    (value.form)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.codeSer, it)
    }
    (value.amount)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.amountSer, it)
    }
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.ingredientSer,
        value.ingredient,
      )
    (value.batch)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.batchSer, it)
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val manufacturerSer: KSerializer<Reference> = Reference.serializer()

    public val amountSer: KSerializer<Ratio> = Ratio.serializer()

    public val ingredientSerInner: KSerializer<Medication.Ingredient> =
      Medication.Ingredient.serializer()

    public val ingredientSer: KSerializer<List<Medication.Ingredient>> =
      ListSerializer(Hoisted.ingredientSerInner)

    public val batchSer: KSerializer<Medication.Batch> = Medication.Batch.serializer()
  }
}

internal object MedicationPolymorphicSerializer : KSerializer<Medication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Medication") { MedicationSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Medication) {
    encoder.encodeStructure(descriptor) {
      MedicationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Medication =
    decoder.decodeStructure(descriptor) {
      MedicationSerializer.deserializeInternal(this, descriptor, 0)
    }
}
