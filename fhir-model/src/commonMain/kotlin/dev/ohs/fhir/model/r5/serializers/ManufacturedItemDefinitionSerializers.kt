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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        6 -> valueDate = decoder.decodeStringElement(__desc, __i)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDateSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDateSer, null)
        10 -> valueMarkdown = decoder.decodeStringElement(__desc, __i)
        11 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDateSer, null)
        12 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAttachmentSer, null)
        13 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueReferenceSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          function =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.functionSer, null)
        5 ->
          amount = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.amountSer, null)
        6 ->
          constituent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.constituentSer, null)
        7 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        8 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.componentSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          amount = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.amountSer, null)
        4 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
        5 ->
          function =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
        6 ->
          hasIngredient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.hasIngredientSer, null)
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("manufacturedDoseForm", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("unitOfPresentation", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "manufacturer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "marketingStatus",
      listSerialDescriptor(MarketingStatus.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "ingredient",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "property",
      listSerialDescriptor(
        lazyDescriptor { ManufacturedItemDefinition.Property.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "component",
      listSerialDescriptor(
        lazyDescriptor { ManufacturedItemDefinition.Component.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ManufacturedItemDefinition")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): ManufacturedItemDefinition {
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
        11 -> status = decoder.decodeStringElement(__desc, __i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 -> name = decoder.decodeStringElement(__desc, __i)
        14 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 ->
          manufacturedDoseForm =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.manufacturedDoseFormSer,
              null,
            )
        16 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.manufacturedDoseFormSer,
              null,
            )
        17 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.manufacturerSer, null)
        18 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.marketingStatusSer, null)
        19 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ingredientSer, null)
        20 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        21 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.componentSer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: ManufacturedItemDefinition,
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.manufacturedDoseForm)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.manufacturedDoseFormSer, it)
    }
    (value.unitOfPresentation)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.manufacturedDoseFormSer, it)
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        17 + __off,
        Hoisted.manufacturerSer,
        value.manufacturer,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        18 + __off,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.ingredientSer, value.ingredient)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.propertySer, value.`property`)
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.componentSer, value.component)
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

internal object ManufacturedItemDefinitionPolymorphicSerializer :
  KSerializer<ManufacturedItemDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ManufacturedItemDefinition") {
      ManufacturedItemDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition) {
    encoder.encodeStructure(descriptor) {
      ManufacturedItemDefinitionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition =
    decoder.decodeStructure(descriptor) {
      ManufacturedItemDefinitionSerializer.deserializeJson(this, descriptor, 0)
    }
}
