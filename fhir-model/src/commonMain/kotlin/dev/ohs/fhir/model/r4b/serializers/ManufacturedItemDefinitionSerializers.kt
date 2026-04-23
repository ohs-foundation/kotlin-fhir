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

import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ManufacturedItemDefinition
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String
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

internal object ManufacturedItemDefinitionPropertySerializer :
  KSerializer<ManufacturedItemDefinition.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueDate", String.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ManufacturedItemDefinition.Property {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueDate: String? = null
    var _valueDate: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueAttachment: Attachment? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueQuantitySer, null)
        6 -> valueDate = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueDateSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, 8)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueDateSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return ManufacturedItemDefinition.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        ManufacturedItemDefinition.Property.Value.from(
          valueCodeableConcept,
          valueQuantity,
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueAttachment,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ManufacturedItemDefinition.Property,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is ManufacturedItemDefinition.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, __d.value)
      }
      is ManufacturedItemDefinition.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueQuantitySer, __d.value)
      }
      is ManufacturedItemDefinition.Property.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueDateSer, it)
        }
      }
      is ManufacturedItemDefinition.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueDateSer, it)
        }
      }
      is ManufacturedItemDefinition.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueDateSer: KSerializer<Element> = Element.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object ManufacturedItemDefinitionPropertyValueSerializer :
  KSerializer<ManufacturedItemDefinition.Property.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ManufacturedItemDefinition.Property.Value") {
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueDate", String.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Property.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ManufacturedItemDefinition.Property.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is ManufacturedItemDefinition.Property.Value.Quantity -> {
          encodeSerializableElement(__desc, 1, Hoisted.valueQuantitySer, __d.value)
        }
        is ManufacturedItemDefinition.Property.Value.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is ManufacturedItemDefinition.Property.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is ManufacturedItemDefinition.Property.Value.Attachment -> {
          encodeSerializableElement(__desc, 6, Hoisted.valueAttachmentSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Property.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): ManufacturedItemDefinition.Property.Value {
    val __desc = descriptor
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueDate: String? = null
    var _valueDate: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueAttachment: Attachment? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        1 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.valueQuantitySer, null)
        2 -> valueDate = decoder.decodeStringElement(__desc, 2)
        3 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> valueBoolean = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ManufacturedItemDefinition.Property.Value: " + __i
          )
      }
    }
    return ManufacturedItemDefinition.Property.Value.from(
      valueCodeableConcept,
      valueQuantity,
      Date.of(FhirDate.fromString(valueDate), _valueDate),
      R4bBoolean.of(valueBoolean, _valueBoolean),
      valueAttachment,
    )!!
  }

  private object Hoisted {
    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object ManufacturedItemDefinitionSerializer : KSerializer<ManufacturedItemDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ManufacturedItemDefinition") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
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
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("manufacturedDoseForm", CodeableConcept.serializer().descriptor, isOptional = true)
      element("unitOfPresentation", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "manufacturer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "ingredient",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(
          lazyDescriptor { ManufacturedItemDefinition.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ManufacturedItemDefinition {
    val __desc = descriptor
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
    var status: String? = null
    var _status: Element? = null
    var manufacturedDoseForm: CodeableConcept? = null
    var unitOfPresentation: CodeableConcept? = null
    var manufacturer: List<Reference>? = null
    var ingredient: List<CodeableConcept>? = null
    var `property`: List<ManufacturedItemDefinition.Property>? = null
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          manufacturedDoseForm =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.manufacturedDoseFormSer,
              null,
            )
        15 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.manufacturedDoseFormSer,
              null,
            )
        16 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.manufacturerSer, null)
        17 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.ingredientSer, null)
        18 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.propertySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ManufacturedItemDefinition: " + __i
          )
      }
    }
    return ManufacturedItemDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      manufacturedDoseForm = manufacturedDoseForm!!,
      unitOfPresentation = unitOfPresentation,
      manufacturer = manufacturer ?: listOf(),
      ingredient = ingredient ?: listOf(),
      `property` = `property` ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ManufacturedItemDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ManufacturedItemDefinition")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.manufacturedDoseForm)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.manufacturedDoseFormSer, it)
    }
    (value.unitOfPresentation)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.manufacturedDoseFormSer, it)
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.manufacturerSer, value.manufacturer)
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.ingredientSer, value.ingredient)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.propertySer, value.`property`)
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

    public val manufacturedDoseFormSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val manufacturerSerInner: KSerializer<Reference> = Reference.serializer()

    public val manufacturerSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.manufacturerSerInner)

    public val ingredientSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.manufacturedDoseFormSer)

    public val propertySerInner: KSerializer<ManufacturedItemDefinition.Property> =
      ManufacturedItemDefinition.Property.serializer()

    public val propertySer: KSerializer<List<ManufacturedItemDefinition.Property>> =
      ListSerializer(Hoisted.propertySerInner)
  }
}
