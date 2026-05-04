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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Medication.Ingredient) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Medication.Ingredient {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
    var isActive: KotlinBoolean? = null
    var _isActive: Element? = null
    var strength: Ratio? = null
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
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        4 ->
          itemReference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.itemReferenceSer, null)
        5 -> isActive = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _isActive =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.isActiveSer, null)
        7 ->
          strength = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + __i)
      }
    }
    return Medication.Ingredient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = Medication.Ingredient.Item.from(itemCodeableConcept, itemReference)!!,
      isActive = R4bBoolean.of(isActive, _isActive),
      strength = strength,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Medication.Ingredient) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.item) {
      null -> {}
      is Medication.Ingredient.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.itemCodeableConceptSer, __d.value)
      }
      is Medication.Ingredient.Item.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.itemReferenceSer, __d.value)
      }
    }
    ((value.isActive?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.isActive?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.isActiveSer, it)
    }
    (value.strength)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.strengthSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Medication.Batch) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Medication.Batch {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var lotNumber: KotlinString? = null
    var _lotNumber: Element? = null
    var expirationDate: KotlinString? = null
    var _expirationDate: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> lotNumber = decoder.decodeStringElement(__desc, 3)
        4 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.lotNumberSer, null)
        5 -> expirationDate = decoder.decodeStringElement(__desc, 5)
        6 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.lotNumberSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Batch: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Medication.Batch) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.lotNumberSer, it)
    }
    ((value.expirationDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.lotNumberSer, it)
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("manufacturer", Reference.serializer().descriptor, isOptional = true)
      element("form", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", Ratio.serializer().descriptor, isOptional = true)
      element(
        "ingredient",
        listSerialDescriptor(lazyDescriptor { Medication.Ingredient.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "batch",
        lazyDescriptor { Medication.Batch.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Medication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Medication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Medication {
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
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> code = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.codeSer, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.manufacturerSer, null)
        16 -> form = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.codeSer, null)
        17 ->
          amount = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.amountSer, null)
        18 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.ingredientSer, null)
        19 -> batch = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.batchSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Medication: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Medication) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Medication")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.codeSer, it) }
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.manufacturerSer, it)
    }
    (value.form)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.codeSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.amountSer, it) }
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.ingredientSer, value.ingredient)
    (value.batch)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.batchSer, it) }
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
