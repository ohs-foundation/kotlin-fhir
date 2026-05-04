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

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MarketingStatus
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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

internal object ManufacturedItemDefinitionPropertySerializer :
  KSerializer<ManufacturedItemDefinition.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueMarkdown", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ManufacturedItemDefinition.Property {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueDate: KotlinString? = null
    var _valueDate: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueMarkdown: KotlinString? = null
    var _valueMarkdown: Element? = null
    var valueAttachment: Attachment? = null
    var valueReference: Reference? = null
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
        10 -> valueMarkdown = decoder.decodeStringElement(__desc, 10)
        11 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueDateSer, null)
        12 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valueAttachmentSer, null)
        13 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.valueReferenceSer, null)
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
          R5Boolean.of(valueBoolean, _valueBoolean),
          Markdown.of(valueMarkdown, _valueMarkdown),
          valueAttachment,
          valueReference,
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
      is ManufacturedItemDefinition.Property.Value.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueDateSer, it)
        }
      }
      is ManufacturedItemDefinition.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.valueAttachmentSer, __d.value)
      }
      is ManufacturedItemDefinition.Property.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 13, Hoisted.valueReferenceSer, __d.value)
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

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ManufacturedItemDefinitionComponentSerializer :
  KSerializer<ManufacturedItemDefinition.Component> {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "function",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("amount", listSerialDescriptor(Quantity.serializer().descriptor), isOptional = true)
      element(
        "constituent",
        listSerialDescriptor(
          lazyDescriptor {
            ManufacturedItemDefinition.Component.Constituent.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(
          lazyDescriptor { ManufacturedItemDefinition.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "component",
        listSerialDescriptor(
          lazyDescriptor { ManufacturedItemDefinition.Component.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Component =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Component) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ManufacturedItemDefinition.Component {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var function: List<CodeableConcept>? = null
    var amount: List<Quantity>? = null
    var constituent: List<ManufacturedItemDefinition.Component.Constituent>? = null
    var `property`: List<ManufacturedItemDefinition.Property>? = null
    var component: List<ManufacturedItemDefinition.Component>? = null
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
          function = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.functionSer, null)
        5 -> amount = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.amountSer, null)
        6 ->
          constituent =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.constituentSer, null)
        7 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.propertySer, null)
        8 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.componentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + __i)
      }
    }
    return ManufacturedItemDefinition.Component(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      function = function ?: listOf(),
      amount = amount ?: listOf(),
      constituent = constituent ?: listOf(),
      `property` = `property` ?: listOf(),
      component = component ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ManufacturedItemDefinition.Component,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    if (value.function.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.functionSer, value.function)
    if (value.amount.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.amountSer, value.amount)
    if (value.constituent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.constituentSer, value.constituent)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.propertySer, value.`property`)
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.componentSer, value.component)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val functionSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val amountSerInner: KSerializer<Quantity> = Quantity.serializer()

    public val amountSer: KSerializer<List<Quantity>> = ListSerializer(Hoisted.amountSerInner)

    public val constituentSerInner: KSerializer<ManufacturedItemDefinition.Component.Constituent> =
      ManufacturedItemDefinition.Component.Constituent.serializer()

    public val constituentSer: KSerializer<List<ManufacturedItemDefinition.Component.Constituent>> =
      ListSerializer(Hoisted.constituentSerInner)

    public val propertySerInner: KSerializer<ManufacturedItemDefinition.Property> =
      ManufacturedItemDefinition.Property.serializer()

    public val propertySer: KSerializer<List<ManufacturedItemDefinition.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val componentSerInner: KSerializer<ManufacturedItemDefinition.Component> =
      ManufacturedItemDefinition.Component.serializer()

    public val componentSer: KSerializer<List<ManufacturedItemDefinition.Component>> =
      ListSerializer(Hoisted.componentSerInner)
  }
}

internal object ManufacturedItemDefinitionComponentConstituentSerializer :
  KSerializer<ManufacturedItemDefinition.Component.Constituent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Constituent") {
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
      element("amount", listSerialDescriptor(Quantity.serializer().descriptor), isOptional = true)
      element(
        "location",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "function",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "hasIngredient",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Component.Constituent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: ManufacturedItemDefinition.Component.Constituent,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ManufacturedItemDefinition.Component.Constituent {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var amount: List<Quantity>? = null
    var location: List<CodeableConcept>? = null
    var function: List<CodeableConcept>? = null
    var hasIngredient: List<CodeableReference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> amount = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.amountSer, null)
        4 ->
          location = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.locationSer, null)
        5 ->
          function = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.locationSer, null)
        6 ->
          hasIngredient =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.hasIngredientSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Constituent: " + __i)
      }
    }
    return ManufacturedItemDefinition.Component.Constituent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      amount = amount ?: listOf(),
      location = location ?: listOf(),
      function = function ?: listOf(),
      hasIngredient = hasIngredient ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ManufacturedItemDefinition.Component.Constituent,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.amount.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.amountSer, value.amount)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.locationSer, value.location)
    if (value.function.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.locationSer, value.function)
    if (value.hasIngredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.hasIngredientSer, value.hasIngredient)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val amountSerInner: KSerializer<Quantity> = Quantity.serializer()

    public val amountSer: KSerializer<List<Quantity>> = ListSerializer(Hoisted.amountSerInner)

    public val locationSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val locationSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.locationSerInner)

    public val hasIngredientSerInner: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val hasIngredientSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.hasIngredientSerInner)
  }
}

internal object ManufacturedItemDefinitionSerializer : KSerializer<ManufacturedItemDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ManufacturedItemDefinition") {
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("manufacturedDoseForm", CodeableConcept.serializer().descriptor, isOptional = true)
      element("unitOfPresentation", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "manufacturer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "marketingStatus",
        listSerialDescriptor(MarketingStatus.serializer().descriptor),
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
      element(
        "component",
        listSerialDescriptor(
          lazyDescriptor { ManufacturedItemDefinition.Component.serializer().descriptor }
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
    var status: KotlinString? = null
    var _status: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var manufacturedDoseForm: CodeableConcept? = null
    var unitOfPresentation: CodeableConcept? = null
    var manufacturer: List<Reference>? = null
    var marketingStatus: List<MarketingStatus>? = null
    var ingredient: List<CodeableConcept>? = null
    var `property`: List<ManufacturedItemDefinition.Property>? = null
    var component: List<ManufacturedItemDefinition.Component>? = null
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
        14 -> name = decoder.decodeStringElement(__desc, 14)
        15 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          manufacturedDoseForm =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.manufacturedDoseFormSer,
              null,
            )
        17 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.manufacturedDoseFormSer,
              null,
            )
        18 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.manufacturerSer, null)
        19 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.marketingStatusSer, null)
        20 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.ingredientSer, null)
        21 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.propertySer, null)
        22 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.componentSer, null)
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
      name = R5String.of(name, _name),
      manufacturedDoseForm = manufacturedDoseForm!!,
      unitOfPresentation = unitOfPresentation,
      manufacturer = manufacturer ?: listOf(),
      marketingStatus = marketingStatus ?: listOf(),
      ingredient = ingredient ?: listOf(),
      `property` = `property` ?: listOf(),
      component = component ?: listOf(),
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
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    (value.manufacturedDoseForm)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.manufacturedDoseFormSer, it)
    }
    (value.unitOfPresentation)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.manufacturedDoseFormSer, it)
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.manufacturerSer, value.manufacturer)
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.ingredientSer, value.ingredient)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.propertySer, value.`property`)
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.componentSer, value.component)
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

    public val marketingStatusSerInner: KSerializer<MarketingStatus> = MarketingStatus.serializer()

    public val marketingStatusSer: KSerializer<List<MarketingStatus>> =
      ListSerializer(Hoisted.marketingStatusSerInner)

    public val ingredientSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.manufacturedDoseFormSer)

    public val propertySerInner: KSerializer<ManufacturedItemDefinition.Property> =
      ManufacturedItemDefinition.Property.serializer()

    public val propertySer: KSerializer<List<ManufacturedItemDefinition.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val componentSerInner: KSerializer<ManufacturedItemDefinition.Component> =
      ManufacturedItemDefinition.Component.serializer()

    public val componentSer: KSerializer<List<ManufacturedItemDefinition.Component>> =
      ListSerializer(Hoisted.componentSerInner)
  }
}
