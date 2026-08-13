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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Property) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ManufacturedItemDefinition.Property {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        6 -> valueDate = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDateSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDateSer, null)
        10 -> valueMarkdown = decoder.decodeStringElement(descriptor, i)
        11 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDateSer, null)
        12 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        13 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    return ManufacturedItemDefinition.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on ManufacturedItemDefinition.Property"
          ),
      `value` =
        ManufacturedItemDefinition.Property.Value.from(
          valueCodeableConcept,
          valueQuantity,
          Date.of(valueDate?.let { FhirDate.fromString(it) }, _valueDate),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Markdown.of(valueMarkdown, _valueMarkdown),
          valueAttachment,
          valueReference,
        ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ManufacturedItemDefinition.Property,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.`value`) {
      null -> {}
      is ManufacturedItemDefinition.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, choice.value)
      }
      is ManufacturedItemDefinition.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueQuantitySer, choice.value)
      }
      is ManufacturedItemDefinition.Property.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueDateSer, it)
        }
      }
      is ManufacturedItemDefinition.Property.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueDateSer, it)
        }
      }
      is ManufacturedItemDefinition.Property.Value.Markdown -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueDateSer, it)
        }
      }
      is ManufacturedItemDefinition.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueAttachmentSer, choice.value)
      }
      is ManufacturedItemDefinition.Property.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 13, Hoisted.valueReferenceSer, choice.value)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Component) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ManufacturedItemDefinition.Component {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          function =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.functionSer, null)
        5 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        6 ->
          constituent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.constituentSer, null)
        7 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        8 ->
          component =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.componentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + i)
      }
    }
    return ManufacturedItemDefinition.Component(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on ManufacturedItemDefinition.Component"
          ),
      function = function ?: listOf(),
      amount = amount ?: listOf(),
      constituent = constituent ?: listOf(),
      `property` = `property` ?: listOf(),
      component = component ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ManufacturedItemDefinition.Component,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    if (value.function.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.functionSer, value.function)
    if (value.amount.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.amountSer, value.amount)
    if (value.constituent.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.constituentSer, value.constituent)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.propertySer, value.`property`)
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.componentSer, value.component)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: ManufacturedItemDefinition.Component.Constituent,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ManufacturedItemDefinition.Component.Constituent {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var amount: List<Quantity>? = null
    var location: List<CodeableConcept>? = null
    var function: List<CodeableConcept>? = null
    var hasIngredient: List<CodeableReference>? = null
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
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        4 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        5 ->
          function =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        6 ->
          hasIngredient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.hasIngredientSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Constituent: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ManufacturedItemDefinition.Component.Constituent,
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
    if (value.amount.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.amountSer, value.amount)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.locationSer, value.location)
    if (value.function.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.locationSer, value.function)
    if (value.hasIngredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        Hoisted.hasIngredientSer,
        value.hasIngredient,
      )
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ManufacturedItemDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ManufacturedItemDefinition {
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> name = decoder.decodeStringElement(descriptor, i)
        14 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          manufacturedDoseForm =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.manufacturedDoseFormSer,
              null,
            )
        16 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.manufacturedDoseFormSer,
              null,
            )
        17 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.manufacturerSer, null)
        18 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.marketingStatusSer,
              null,
            )
        19 ->
          ingredient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ingredientSer, null)
        20 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        21 ->
          component =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.componentSer, null)
        else ->
          throw SerializationException("Unexpected index decoding ManufacturedItemDefinition: " + i)
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
      status =
        Enumeration.of(
          PublicationStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on ManufacturedItemDefinition"
              )
          ),
          _status,
        ),
      name = R5String.of(name, _name),
      manufacturedDoseForm =
        manufacturedDoseForm
          ?: throw SerializationException(
            "Missing required property 'manufacturedDoseForm' on ManufacturedItemDefinition"
          ),
      unitOfPresentation = unitOfPresentation,
      manufacturer = manufacturer ?: listOf(),
      marketingStatus = marketingStatus ?: listOf(),
      ingredient = ingredient ?: listOf(),
      `property` = `property` ?: listOf(),
      component = component ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ManufacturedItemDefinition,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      Hoisted.manufacturedDoseFormSer,
      value.manufacturedDoseForm,
    )
    (value.unitOfPresentation)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.manufacturedDoseFormSer,
        it,
      )
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.manufacturerSer,
        value.manufacturer,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.ingredientSer,
        value.ingredient,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.propertySer,
        value.`property`,
      )
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.componentSer,
        value.component,
      )
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
      ManufacturedItemDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition =
    decoder.decodeStructure(descriptor) {
      ManufacturedItemDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
