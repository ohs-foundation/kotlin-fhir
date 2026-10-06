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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MarketingStatus
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueDate", KotlinString.serializer().descriptor)
      optionalElement("_valueDate", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueMarkdown", KotlinString.serializer().descriptor)
      optionalElement("_valueMarkdown", ElementSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ManufacturedItemDefinition.Property>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Property =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> valueDate = decodeStringElement(descriptor, i)
          7 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueBoolean = decodeBooleanElement(descriptor, i)
          9 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> valueMarkdown = decodeStringElement(descriptor, i)
          11 ->
            _valueMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          13 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Property: " + i)
        }
      }
      ManufacturedItemDefinition.Property(
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
            Date.of(if (valueDate != null) FhirDate.fromString(valueDate) else null, _valueDate),
            R5Boolean.of(valueBoolean, _valueBoolean),
            Markdown.of(valueMarkdown, _valueMarkdown),
            valueAttachment,
            valueReference,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Property) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        null -> {}
        is ManufacturedItemDefinition.Property.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is ManufacturedItemDefinition.Property.Value.Quantity -> {
          encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
        }
        is ManufacturedItemDefinition.Property.Value.Date -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is ManufacturedItemDefinition.Property.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is ManufacturedItemDefinition.Property.Value.Markdown -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is ManufacturedItemDefinition.Property.Value.Attachment -> {
          encodeSerializableElement(descriptor, 12, AttachmentSerializer, choice.value)
        }
        is ManufacturedItemDefinition.Property.Value.Reference -> {
          encodeSerializableElement(descriptor, 13, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object ManufacturedItemDefinitionComponentSerializer :
  KSerializer<ManufacturedItemDefinition.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("amount", QuantitySerializer.listSerializer.descriptor)
      optionalElement(
        "constituent",
        ManufacturedItemDefinitionComponentConstituentSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "property",
        listSerialDescriptor(
          lazyDescriptor { ManufacturedItemDefinitionPropertySerializer.descriptor }
        ),
      )
      optionalElement(
        "component",
        listSerialDescriptor(
          lazyDescriptor { ManufacturedItemDefinitionComponentSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<ManufacturedItemDefinition.Component>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Component =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            function =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 ->
            amount =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuantitySerializer.listSerializer,
                null,
              )
          6 ->
            constituent =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ManufacturedItemDefinitionComponentConstituentSerializer.listSerializer,
                null,
              )
          7 ->
            `property` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ManufacturedItemDefinitionPropertySerializer.listSerializer,
                null,
              )
          8 ->
            component =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ManufacturedItemDefinitionComponentSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Component: " + i)
        }
      }
      ManufacturedItemDefinition.Component(
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

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Component) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      if (value.function.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.function,
        )
      if (value.amount.isNotEmpty())
        encodeSerializableElement(descriptor, 5, QuantitySerializer.listSerializer, value.amount)
      if (value.constituent.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ManufacturedItemDefinitionComponentConstituentSerializer.listSerializer,
          value.constituent,
        )
      if (value.`property`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          ManufacturedItemDefinitionPropertySerializer.listSerializer,
          value.`property`,
        )
      if (value.component.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          ManufacturedItemDefinitionComponentSerializer.listSerializer,
          value.component,
        )
    }
  }
}

internal object ManufacturedItemDefinitionComponentConstituentSerializer :
  KSerializer<ManufacturedItemDefinition.Component.Constituent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Constituent") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("amount", QuantitySerializer.listSerializer.descriptor)
      optionalElement("location", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("hasIngredient", CodeableReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ManufacturedItemDefinition.Component.Constituent>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Component.Constituent =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var amount: List<Quantity>? = null
      var location: List<CodeableConcept>? = null
      var function: List<CodeableConcept>? = null
      var hasIngredient: List<CodeableReference>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            amount =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuantitySerializer.listSerializer,
                null,
              )
          4 ->
            location =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 ->
            function =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 ->
            hasIngredient =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Constituent: " + i)
        }
      }
      ManufacturedItemDefinition.Component.Constituent(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        amount = amount ?: listOf(),
        location = location ?: listOf(),
        function = function ?: listOf(),
        hasIngredient = hasIngredient ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: ManufacturedItemDefinition.Component.Constituent,
  ) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      if (value.amount.isNotEmpty())
        encodeSerializableElement(descriptor, 3, QuantitySerializer.listSerializer, value.amount)
      if (value.location.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.location,
        )
      if (value.function.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.function,
        )
      if (value.hasIngredient.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodeableReferenceSerializer.listSerializer,
          value.hasIngredient,
        )
    }
  }
}

internal object ManufacturedItemDefinitionSerializer :
  FhirResourceSerializer<ManufacturedItemDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ManufacturedItemDefinition")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("manufacturedDoseForm", CodeableConceptSerializer.descriptor)
    b.optionalElement("unitOfPresentation", CodeableConceptSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("marketingStatus", MarketingStatusSerializer.listSerializer.descriptor)
    b.optionalElement("ingredient", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "property",
      ManufacturedItemDefinitionPropertySerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "component",
      ManufacturedItemDefinitionComponentSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> name = decoder.decodeStringElement(descriptor, i)
        14 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          manufacturedDoseForm =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MarketingStatusSerializer.listSerializer,
              null,
            )
        19 ->
          ingredient =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          `property` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ManufacturedItemDefinitionPropertySerializer.listSerializer,
              null,
            )
        21 ->
          component =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ManufacturedItemDefinitionComponentSerializer.listSerializer,
              null,
            )
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
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on ManufacturedItemDefinition"
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ManufacturedItemDefinition,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.name)
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.manufacturedDoseForm,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.unitOfPresentation,
    )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.manufacturer,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        MarketingStatusSerializer.listSerializer,
        value.marketingStatus,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.ingredient,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ManufacturedItemDefinitionPropertySerializer.listSerializer,
        value.`property`,
      )
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ManufacturedItemDefinitionComponentSerializer.listSerializer,
        value.component,
      )
  }
}
