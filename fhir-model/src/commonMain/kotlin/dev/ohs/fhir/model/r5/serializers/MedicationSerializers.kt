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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
      element("item", CodeableReference.serializer().descriptor, isOptional = true)
      element("isActive", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isActive", Element.serializer().descriptor, isOptional = true)
      element("strengthRatio", Ratio.serializer().descriptor, isOptional = true)
      element("strengthCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("strengthQuantity", Quantity.serializer().descriptor, isOptional = true)
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
    var item: CodeableReference? = null
    var isActive: KotlinBoolean? = null
    var _isActive: Element? = null
    var strengthRatio: Ratio? = null
    var strengthCodeableConcept: CodeableConcept? = null
    var strengthQuantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> item = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.itemSer, null)
        4 -> isActive = decoder.decodeBooleanElement(__desc, __i)
        5 ->
          _isActive =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.isActiveSer, null)
        6 ->
          strengthRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.strengthRatioSer, null)
        7 ->
          strengthCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.strengthCodeableConceptSer,
              null,
            )
        8 ->
          strengthQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.strengthQuantitySer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + __i)
      }
    }
    return Medication.Ingredient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = item!!,
      isActive = R5Boolean.of(isActive, _isActive),
      strength =
        Medication.Ingredient.Strength.from(
          strengthRatio,
          strengthCodeableConcept,
          strengthQuantity,
        ),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Medication.Ingredient) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.item)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.itemSer, it) }
    ((value.isActive?.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.isActive?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.isActiveSer, it)
    }
    when (val __d = value.strength) {
      null -> {}
      is Medication.Ingredient.Strength.Ratio -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.strengthRatioSer, __d.value)
      }
      is Medication.Ingredient.Strength.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.strengthCodeableConceptSer, __d.value)
      }
      is Medication.Ingredient.Strength.Quantity -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.strengthQuantitySer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val isActiveSer: KSerializer<Element> = Element.serializer()

    public val strengthRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val strengthCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val strengthQuantitySer: KSerializer<Quantity> = Quantity.serializer()
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> lotNumber = decoder.decodeStringElement(__desc, __i)
        4 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lotNumberSer, null)
        5 -> expirationDate = decoder.decodeStringElement(__desc, __i)
        6 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lotNumberSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Batch: " + __i)
      }
    }
    return Medication.Batch(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      lotNumber = R5String.of(lotNumber, _lotNumber),
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
    b.element("marketingAuthorizationHolder", Reference.serializer().descriptor, isOptional = true)
    b.element("doseForm", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("totalVolume", Quantity.serializer().descriptor, isOptional = true)
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
    b.element("definition", Reference.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Medication =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Medication) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Medication")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Medication {
    val __desc = desc
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
    var marketingAuthorizationHolder: Reference? = null
    var doseForm: CodeableConcept? = null
    var totalVolume: Quantity? = null
    var ingredient: List<Medication.Ingredient>? = null
    var batch: Medication.Batch? = null
    var definition: Reference? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        12 -> status = decoder.decodeStringElement(__desc, __i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 ->
          marketingAuthorizationHolder =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.marketingAuthorizationHolderSer,
              null,
            )
        15 ->
          doseForm = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        16 ->
          totalVolume =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.totalVolumeSer, null)
        17 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ingredientSer, null)
        18 -> batch = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.batchSer, null)
        19 ->
          definition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.marketingAuthorizationHolderSer,
              null,
            )
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
      marketingAuthorizationHolder = marketingAuthorizationHolder,
      doseForm = doseForm,
      totalVolume = totalVolume,
      ingredient = ingredient ?: listOf(),
      batch = batch,
      definition = definition,
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Medication,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.codeSer, it) }
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.marketingAuthorizationHolder)?.let {
      encoder.encodeSerializableElement(
        __desc,
        14 + __off,
        Hoisted.marketingAuthorizationHolderSer,
        it,
      )
    }
    (value.doseForm)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.codeSer, it)
    }
    (value.totalVolume)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.totalVolumeSer, it)
    }
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.ingredientSer, value.ingredient)
    (value.batch)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.batchSer, it)
    }
    (value.definition)?.let {
      encoder.encodeSerializableElement(
        __desc,
        19 + __off,
        Hoisted.marketingAuthorizationHolderSer,
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val marketingAuthorizationHolderSer: KSerializer<Reference> = Reference.serializer()

    public val totalVolumeSer: KSerializer<Quantity> = Quantity.serializer()

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
      MedicationSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Medication =
    decoder.decodeStructure(descriptor) {
      MedicationSerializer.deserializeJson(this, descriptor, 0)
    }
}
