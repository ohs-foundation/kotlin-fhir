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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Count
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object DeviceUdiCarrierSerializer : KSerializer<Device.UdiCarrier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("UdiCarrier") {
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
      element("deviceIdentifier", KotlinString.serializer().descriptor, isOptional = true)
      element("_deviceIdentifier", Element.serializer().descriptor, isOptional = true)
      element("issuer", KotlinString.serializer().descriptor, isOptional = true)
      element("_issuer", Element.serializer().descriptor, isOptional = true)
      element("jurisdiction", KotlinString.serializer().descriptor, isOptional = true)
      element("_jurisdiction", Element.serializer().descriptor, isOptional = true)
      element("carrierAIDC", KotlinString.serializer().descriptor, isOptional = true)
      element("_carrierAIDC", Element.serializer().descriptor, isOptional = true)
      element("carrierHRF", KotlinString.serializer().descriptor, isOptional = true)
      element("_carrierHRF", Element.serializer().descriptor, isOptional = true)
      element("entryType", KotlinString.serializer().descriptor, isOptional = true)
      element("_entryType", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Device.UdiCarrier =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Device.UdiCarrier) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Device.UdiCarrier {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var deviceIdentifier: KotlinString? = null
    var _deviceIdentifier: Element? = null
    var issuer: KotlinString? = null
    var _issuer: Element? = null
    var jurisdiction: KotlinString? = null
    var _jurisdiction: Element? = null
    var carrierAIDC: KotlinString? = null
    var _carrierAIDC: Element? = null
    var carrierHRF: KotlinString? = null
    var _carrierHRF: Element? = null
    var entryType: KotlinString? = null
    var _entryType: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> deviceIdentifier = decoder.decodeStringElement(descriptor, i)
        4 ->
          _deviceIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        5 -> issuer = decoder.decodeStringElement(descriptor, i)
        6 ->
          _issuer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        7 -> jurisdiction = decoder.decodeStringElement(descriptor, i)
        8 ->
          _jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        9 -> carrierAIDC = decoder.decodeStringElement(descriptor, i)
        10 ->
          _carrierAIDC =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        11 -> carrierHRF = decoder.decodeStringElement(descriptor, i)
        12 ->
          _carrierHRF =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        13 -> entryType = decoder.decodeStringElement(descriptor, i)
        14 ->
          _entryType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding UdiCarrier: " + i)
      }
    }
    return Device.UdiCarrier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      deviceIdentifier =
        R5String.of(deviceIdentifier, _deviceIdentifier)
          ?: throw SerializationException(
            "Missing required property 'deviceIdentifier' on Device.UdiCarrier"
          ),
      issuer =
        Uri.of(issuer, _issuer)
          ?: throw SerializationException(
            "Missing required property 'issuer' on Device.UdiCarrier"
          ),
      jurisdiction = Uri.of(jurisdiction, _jurisdiction),
      carrierAIDC = Base64Binary.of(carrierAIDC, _carrierAIDC),
      carrierHRF = R5String.of(carrierHRF, _carrierHRF),
      entryType = Enumeration.of(entryType?.let { Device.UDIEntryType.fromCode(it) }, _entryType),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Device.UdiCarrier) {
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
    ((value.deviceIdentifier.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.deviceIdentifier.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.deviceIdentifierSer, it)
    }
    ((value.issuer.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.issuer.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.deviceIdentifierSer, it)
    }
    ((value.jurisdiction?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.jurisdiction?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.deviceIdentifierSer, it)
    }
    ((value.carrierAIDC?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.carrierAIDC?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.deviceIdentifierSer, it)
    }
    ((value.carrierHRF?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.carrierHRF?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.deviceIdentifierSer, it)
    }
    ((value.entryType?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.entryType?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.deviceIdentifierSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val deviceIdentifierSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceNameSerializer : KSerializer<Device.Name> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Name") {
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
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("display", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Device.Name =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Device.Name) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Device.Name {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var display: KotlinBoolean? = null
    var _display: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> `value` = decoder.decodeStringElement(descriptor, i)
        4 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        5 -> type = decoder.decodeStringElement(descriptor, i)
        6 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        7 -> display = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _display =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + i)
      }
    }
    return Device.Name(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        R5String.of(`value`, _value)
          ?: throw SerializationException("Missing required property 'value' on Device.Name"),
      type =
        Enumeration.of(type?.let { Device.DeviceNameType.fromCode(it) }, _type)
          ?: throw SerializationException("Missing required property 'type' on Device.Name"),
      display = R5Boolean.of(display, _display),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Device.Name) {
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
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceVersionSerializer : KSerializer<Device.Version> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Version") {
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
      element("component", Identifier.serializer().descriptor, isOptional = true)
      element("installDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_installDate", Element.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Device.Version =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Device.Version) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Device.Version {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var component: Identifier? = null
    var installDate: KotlinString? = null
    var _installDate: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
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
          component =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.componentSer, null)
        5 -> installDate = decoder.decodeStringElement(descriptor, i)
        6 ->
          _installDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.installDateSer, null)
        7 -> `value` = decoder.decodeStringElement(descriptor, i)
        8 ->
          _value =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.installDateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + i)
      }
    }
    return Device.Version(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      component = component,
      installDate = DateTime.of(FhirDateTime.fromString(installDate), _installDate),
      `value` =
        R5String.of(`value`, _value)
          ?: throw SerializationException("Missing required property 'value' on Device.Version"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Device.Version) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    (value.component)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.componentSer, it)
    }
    ((value.installDate?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.installDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.installDateSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.installDateSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val componentSer: KSerializer<Identifier> = Identifier.serializer()

    public val installDateSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceConformsToSerializer : KSerializer<Device.ConformsTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConformsTo") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("specification", CodeableConcept.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Device.ConformsTo =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Device.ConformsTo) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Device.ConformsTo {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var specification: CodeableConcept? = null
    var version: KotlinString? = null
    var _version: Element? = null
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
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          specification =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        5 -> version = decoder.decodeStringElement(descriptor, i)
        6 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ConformsTo: " + i)
      }
    }
    return Device.ConformsTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      specification =
        specification
          ?: throw SerializationException(
            "Missing required property 'specification' on Device.ConformsTo"
          ),
      version = R5String.of(version, _version),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Device.ConformsTo) {
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
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.categorySer, value.specification)
    ((value.version?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.versionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val versionSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DevicePropertySerializer : KSerializer<Device.Property> {
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
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Device.Property =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Device.Property) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Device.Property {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueRange: Range? = null
    var valueAttachment: Attachment? = null
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
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> valueString = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        10 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        12 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        13 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    return Device.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Device.Property"),
      `value` =
        Device.Property.Value.from(
          valueQuantity,
          valueCodeableConcept,
          R5String.of(valueString, _valueString),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          valueRange,
          valueAttachment,
        ) ?: throw SerializationException("Missing required property 'value' on Device.Property"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Device.Property) {
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
      is Device.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueQuantitySer, choice.value)
      }
      is Device.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, choice.value)
      }
      is Device.Property.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueStringSer, it)
        }
      }
      is Device.Property.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueStringSer, it)
        }
      }
      is Device.Property.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueStringSer, it)
        }
      }
      is Device.Property.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueRangeSer, choice.value)
      }
      is Device.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 13, Hoisted.valueAttachmentSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueStringSer: KSerializer<Element> = Element.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object DeviceSerializer : KSerializer<Device> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Device") {
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
    b.element("displayName", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_displayName", Element.serializer().descriptor, isOptional = true)
    b.element("definition", CodeableReference.serializer().descriptor, isOptional = true)
    b.element(
      "udiCarrier",
      listSerialDescriptor(lazyDescriptor { Device.UdiCarrier.serializer().descriptor }),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("availabilityStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("biologicalSourceEvent", Identifier.serializer().descriptor, isOptional = true)
    b.element("manufacturer", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_manufacturer", Element.serializer().descriptor, isOptional = true)
    b.element("manufactureDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_manufactureDate", Element.serializer().descriptor, isOptional = true)
    b.element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_expirationDate", Element.serializer().descriptor, isOptional = true)
    b.element("lotNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lotNumber", Element.serializer().descriptor, isOptional = true)
    b.element("serialNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_serialNumber", Element.serializer().descriptor, isOptional = true)
    b.element(
      "name",
      listSerialDescriptor(lazyDescriptor { Device.Name.serializer().descriptor }),
      isOptional = true,
    )
    b.element("modelNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_modelNumber", Element.serializer().descriptor, isOptional = true)
    b.element("partNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_partNumber", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "type",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "version",
      listSerialDescriptor(lazyDescriptor { Device.Version.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "conformsTo",
      listSerialDescriptor(lazyDescriptor { Device.ConformsTo.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "property",
      listSerialDescriptor(lazyDescriptor { Device.Property.serializer().descriptor }),
      isOptional = true,
    )
    b.element("mode", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("cycle", Count.serializer().descriptor, isOptional = true)
    b.element("duration", Duration.serializer().descriptor, isOptional = true)
    b.element("owner", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactPoint.serializer().descriptor),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "endpoint",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "gateway",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "safety",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("parent", Reference.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Device =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Device) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Device")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Device {
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
    var displayName: KotlinString? = null
    var _displayName: Element? = null
    var definition: CodeableReference? = null
    var udiCarrier: List<Device.UdiCarrier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var availabilityStatus: CodeableConcept? = null
    var biologicalSourceEvent: Identifier? = null
    var manufacturer: KotlinString? = null
    var _manufacturer: Element? = null
    var manufactureDate: KotlinString? = null
    var _manufactureDate: Element? = null
    var expirationDate: KotlinString? = null
    var _expirationDate: Element? = null
    var lotNumber: KotlinString? = null
    var _lotNumber: Element? = null
    var serialNumber: KotlinString? = null
    var _serialNumber: Element? = null
    var name: List<Device.Name>? = null
    var modelNumber: KotlinString? = null
    var _modelNumber: Element? = null
    var partNumber: KotlinString? = null
    var _partNumber: Element? = null
    var category: List<CodeableConcept>? = null
    var type: List<CodeableConcept>? = null
    var version: List<Device.Version>? = null
    var conformsTo: List<Device.ConformsTo>? = null
    var `property`: List<Device.Property>? = null
    var mode: CodeableConcept? = null
    var cycle: Count? = null
    var duration: Duration? = null
    var owner: Reference? = null
    var contact: List<ContactPoint>? = null
    var location: Reference? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var endpoint: List<Reference>? = null
    var gateway: List<CodeableReference>? = null
    var note: List<Annotation>? = null
    var safety: List<CodeableConcept>? = null
    var parent: Reference? = null
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
        11 -> displayName = decoder.decodeStringElement(descriptor, i)
        12 ->
          _displayName =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.definitionSer, null)
        14 ->
          udiCarrier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.udiCarrierSer, null)
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          availabilityStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.availabilityStatusSer,
              null,
            )
        18 ->
          biologicalSourceEvent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        19 -> manufacturer = decoder.decodeStringElement(descriptor, i)
        20 ->
          _manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> manufactureDate = decoder.decodeStringElement(descriptor, i)
        22 ->
          _manufactureDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        24 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> lotNumber = decoder.decodeStringElement(descriptor, i)
        26 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> serialNumber = decoder.decodeStringElement(descriptor, i)
        28 ->
          _serialNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 -> name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        30 -> modelNumber = decoder.decodeStringElement(descriptor, i)
        31 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 -> partNumber = decoder.decodeStringElement(descriptor, i)
        33 ->
          _partNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        35 ->
          type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        36 ->
          version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionSer, null)
        37 ->
          conformsTo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conformsToSer, null)
        38 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        39 ->
          mode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.availabilityStatusSer,
              null,
            )
        40 ->
          cycle = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.cycleSer, null)
        41 ->
          duration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.durationSer, null)
        42 ->
          owner = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ownerSer, null)
        43 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        44 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ownerSer, null)
        45 -> url = decoder.decodeStringElement(descriptor, i)
        46 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        47 ->
          endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointSer, null)
        48 ->
          gateway =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.gatewaySer, null)
        49 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        50 ->
          safety =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        51 ->
          parent = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ownerSer, null)
        else -> throw SerializationException("Unexpected index decoding Device: " + i)
      }
    }
    return Device(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      displayName = R5String.of(displayName, _displayName),
      definition = definition,
      udiCarrier = udiCarrier ?: listOf(),
      status = Enumeration.of(status?.let { Device.FHIRDeviceStatus.fromCode(it) }, _status),
      availabilityStatus = availabilityStatus,
      biologicalSourceEvent = biologicalSourceEvent,
      manufacturer = R5String.of(manufacturer, _manufacturer),
      manufactureDate = DateTime.of(FhirDateTime.fromString(manufactureDate), _manufactureDate),
      expirationDate = DateTime.of(FhirDateTime.fromString(expirationDate), _expirationDate),
      lotNumber = R5String.of(lotNumber, _lotNumber),
      serialNumber = R5String.of(serialNumber, _serialNumber),
      name = name ?: listOf(),
      modelNumber = R5String.of(modelNumber, _modelNumber),
      partNumber = R5String.of(partNumber, _partNumber),
      category = category ?: listOf(),
      type = type ?: listOf(),
      version = version ?: listOf(),
      conformsTo = conformsTo ?: listOf(),
      `property` = `property` ?: listOf(),
      mode = mode,
      cycle = cycle,
      duration = duration,
      owner = owner,
      contact = contact ?: listOf(),
      location = location,
      url = Uri.of(url, _url),
      endpoint = endpoint ?: listOf(),
      gateway = gateway ?: listOf(),
      note = note ?: listOf(),
      safety = safety ?: listOf(),
      parent = parent,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Device,
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
    ((value.displayName?.value))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.displayName?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.definition)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.definitionSer,
        it,
      )
    }
    if (value.udiCarrier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.udiCarrierSer,
        value.udiCarrier,
      )
    ((value.status?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.availabilityStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.availabilityStatusSer,
        it,
      )
    }
    (value.biologicalSourceEvent)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    ((value.manufacturer?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.manufacturer?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.manufactureDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.manufactureDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.expirationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lotNumber?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.serialNumber?.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.serialNumber?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.nameSer,
        value.name,
      )
    ((value.modelNumber?.value))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.modelNumber?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.partNumber?.value))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.partNumber?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.categorySer,
        value.type,
      )
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.versionSer,
        value.version,
      )
    if (value.conformsTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.conformsToSer,
        value.conformsTo,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.propertySer,
        value.`property`,
      )
    (value.mode)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.availabilityStatusSer,
        it,
      )
    }
    (value.cycle)?.let {
      encoder.encodeSerializableElement(descriptor, 40 + descriptorOffset, Hoisted.cycleSer, it)
    }
    (value.duration)?.let {
      encoder.encodeSerializableElement(descriptor, 41 + descriptorOffset, Hoisted.durationSer, it)
    }
    (value.owner)?.let {
      encoder.encodeSerializableElement(descriptor, 42 + descriptorOffset, Hoisted.ownerSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 44 + descriptorOffset, Hoisted.ownerSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 45 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.endpointSer,
        value.endpoint,
      )
    if (value.gateway.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.gatewaySer,
        value.gateway,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.categorySer,
        value.safety,
      )
    (value.parent)?.let {
      encoder.encodeSerializableElement(descriptor, 51 + descriptorOffset, Hoisted.ownerSer, it)
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

    public val definitionSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val udiCarrierSerInner: KSerializer<Device.UdiCarrier> = Device.UdiCarrier.serializer()

    public val udiCarrierSer: KSerializer<List<Device.UdiCarrier>> =
      ListSerializer(Hoisted.udiCarrierSerInner)

    public val availabilityStatusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val nameSerInner: KSerializer<Device.Name> = Device.Name.serializer()

    public val nameSer: KSerializer<List<Device.Name>> = ListSerializer(Hoisted.nameSerInner)

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.availabilityStatusSer)

    public val versionSerInner: KSerializer<Device.Version> = Device.Version.serializer()

    public val versionSer: KSerializer<List<Device.Version>> =
      ListSerializer(Hoisted.versionSerInner)

    public val conformsToSerInner: KSerializer<Device.ConformsTo> = Device.ConformsTo.serializer()

    public val conformsToSer: KSerializer<List<Device.ConformsTo>> =
      ListSerializer(Hoisted.conformsToSerInner)

    public val propertySerInner: KSerializer<Device.Property> = Device.Property.serializer()

    public val propertySer: KSerializer<List<Device.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val cycleSer: KSerializer<Count> = Count.serializer()

    public val durationSer: KSerializer<Duration> = Duration.serializer()

    public val ownerSer: KSerializer<Reference> = Reference.serializer()

    public val contactSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val contactSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.contactSerInner)

    public val endpointSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.ownerSer)

    public val gatewaySer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.definitionSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object DevicePolymorphicSerializer : KSerializer<Device> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Device") { DeviceSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Device) {
    encoder.encodeStructure(descriptor) {
      DeviceSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Device =
    decoder.decodeStructure(descriptor) {
      DeviceSerializer.deserializeInternal(this, descriptor, 0)
    }
}
