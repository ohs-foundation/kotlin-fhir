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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Device.UdiCarrier) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Device.UdiCarrier {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> deviceIdentifier = decoder.decodeStringElement(__desc, 3)
        4 ->
          _deviceIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.deviceIdentifierSer, null)
        5 -> issuer = decoder.decodeStringElement(__desc, 5)
        6 ->
          _issuer =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.deviceIdentifierSer, null)
        7 -> jurisdiction = decoder.decodeStringElement(__desc, 7)
        8 ->
          _jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.deviceIdentifierSer, null)
        9 -> carrierAIDC = decoder.decodeStringElement(__desc, 9)
        10 ->
          _carrierAIDC =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.deviceIdentifierSer, null)
        11 -> carrierHRF = decoder.decodeStringElement(__desc, 11)
        12 ->
          _carrierHRF =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.deviceIdentifierSer, null)
        13 -> entryType = decoder.decodeStringElement(__desc, 13)
        14 ->
          _entryType =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.deviceIdentifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding UdiCarrier: " + __i)
      }
    }
    return Device.UdiCarrier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      deviceIdentifier = R5String.of(deviceIdentifier, _deviceIdentifier)!!,
      issuer = Uri.of(issuer, _issuer)!!,
      jurisdiction = Uri.of(jurisdiction, _jurisdiction),
      carrierAIDC = Base64Binary.of(carrierAIDC, _carrierAIDC),
      carrierHRF = R5String.of(carrierHRF, _carrierHRF),
      entryType = entryType?.let { Enumeration.of(Device.UDIEntryType.fromCode(it), _entryType) },
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Device.UdiCarrier) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.deviceIdentifier.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.deviceIdentifier.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.deviceIdentifierSer, it)
    }
    ((value.issuer.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.issuer.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.deviceIdentifierSer, it)
    }
    ((value.jurisdiction?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.jurisdiction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.deviceIdentifierSer, it)
    }
    ((value.carrierAIDC?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.carrierAIDC?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.deviceIdentifierSer, it)
    }
    ((value.carrierHRF?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.carrierHRF?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.deviceIdentifierSer, it)
    }
    ((value.entryType?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.entryType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.deviceIdentifierSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Device.Name) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Device.Name {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> `value` = decoder.decodeStringElement(__desc, 3)
        4 -> _value = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueSer, null)
        5 -> type = decoder.decodeStringElement(__desc, 5)
        6 -> _type = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueSer, null)
        7 -> display = decoder.decodeBooleanElement(__desc, 7)
        8 -> _display = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + __i)
      }
    }
    return Device.Name(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` = R5String.of(`value`, _value)!!,
      type = Enumeration.of(Device.DeviceNameType.fromCode(type!!), _type),
      display = R5Boolean.of(display, _display),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Device.Name) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.valueSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.valueSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.valueSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Device.Version) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Device.Version {
    val __desc = descriptor
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
          component =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.componentSer, null)
        5 -> installDate = decoder.decodeStringElement(__desc, 5)
        6 ->
          _installDate =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.installDateSer, null)
        7 -> `value` = decoder.decodeStringElement(__desc, 7)
        8 ->
          _value =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.installDateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + __i)
      }
    }
    return Device.Version(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      component = component,
      installDate = DateTime.of(FhirDateTime.fromString(installDate), _installDate),
      `value` = R5String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Device.Version) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.component)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.componentSer, it)
    }
    ((value.installDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.installDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.installDateSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.installDateSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Device.ConformsTo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Device.ConformsTo {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var specification: CodeableConcept? = null
    var version: KotlinString? = null
    var _version: Element? = null
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
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 ->
          specification =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.categorySer, null)
        5 -> version = decoder.decodeStringElement(__desc, 5)
        6 ->
          _version = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.versionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ConformsTo: " + __i)
      }
    }
    return Device.ConformsTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      specification = specification!!,
      version = R5String.of(version, _version),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Device.ConformsTo) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.specification)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.categorySer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.versionSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Device.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Device.Property {
    val __desc = descriptor
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
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueQuantitySer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> valueString = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueStringSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, 8)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueStringSer, null)
        10 -> valueInteger = decoder.decodeIntElement(__desc, 10)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueStringSer, null)
        12 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valueRangeSer, null)
        13 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return Device.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        Device.Property.Value.from(
          valueQuantity,
          valueCodeableConcept,
          R5String.of(valueString, _valueString),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          valueRange,
          valueAttachment,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Device.Property) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is Device.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.valueQuantitySer, __d.value)
      }
      is Device.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, __d.value)
      }
      is Device.Property.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueStringSer, it)
        }
      }
      is Device.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueStringSer, it)
        }
      }
      is Device.Property.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueStringSer, it)
        }
      }
      is Device.Property.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.valueRangeSer, __d.value)
      }
      is Device.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 13, Hoisted.valueAttachmentSer, __d.value)
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
      element("displayName", KotlinString.serializer().descriptor, isOptional = true)
      element("_displayName", Element.serializer().descriptor, isOptional = true)
      element("definition", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "udiCarrier",
        listSerialDescriptor(lazyDescriptor { Device.UdiCarrier.serializer().descriptor }),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("availabilityStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element("biologicalSourceEvent", Identifier.serializer().descriptor, isOptional = true)
      element("manufacturer", KotlinString.serializer().descriptor, isOptional = true)
      element("_manufacturer", Element.serializer().descriptor, isOptional = true)
      element("manufactureDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_manufactureDate", Element.serializer().descriptor, isOptional = true)
      element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_expirationDate", Element.serializer().descriptor, isOptional = true)
      element("lotNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_lotNumber", Element.serializer().descriptor, isOptional = true)
      element("serialNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_serialNumber", Element.serializer().descriptor, isOptional = true)
      element(
        "name",
        listSerialDescriptor(lazyDescriptor { Device.Name.serializer().descriptor }),
        isOptional = true,
      )
      element("modelNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_modelNumber", Element.serializer().descriptor, isOptional = true)
      element("partNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_partNumber", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "version",
        listSerialDescriptor(lazyDescriptor { Device.Version.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "conformsTo",
        listSerialDescriptor(lazyDescriptor { Device.ConformsTo.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(lazyDescriptor { Device.Property.serializer().descriptor }),
        isOptional = true,
      )
      element("mode", CodeableConcept.serializer().descriptor, isOptional = true)
      element("cycle", Count.serializer().descriptor, isOptional = true)
      element("duration", Duration.serializer().descriptor, isOptional = true)
      element("owner", Reference.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactPoint.serializer().descriptor),
        isOptional = true,
      )
      element("location", Reference.serializer().descriptor, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "endpoint",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "gateway",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "safety",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("parent", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Device =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Device) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Device {
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
        12 -> displayName = decoder.decodeStringElement(__desc, 12)
        13 ->
          _displayName =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          definition =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.definitionSer, null)
        15 ->
          udiCarrier =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.udiCarrierSer, null)
        16 -> status = decoder.decodeStringElement(__desc, 16)
        17 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          availabilityStatus =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.availabilityStatusSer,
              null,
            )
        19 ->
          biologicalSourceEvent =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.identifierSerInner, null)
        20 -> manufacturer = decoder.decodeStringElement(__desc, 20)
        21 ->
          _manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> manufactureDate = decoder.decodeStringElement(__desc, 22)
        23 ->
          _manufactureDate =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> expirationDate = decoder.decodeStringElement(__desc, 24)
        25 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> lotNumber = decoder.decodeStringElement(__desc, 26)
        27 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> serialNumber = decoder.decodeStringElement(__desc, 28)
        29 ->
          _serialNumber =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> name = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.nameSer, null)
        31 -> modelNumber = decoder.decodeStringElement(__desc, 31)
        32 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 -> partNumber = decoder.decodeStringElement(__desc, 33)
        34 ->
          _partNumber =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.categorySer, null)
        36 ->
          type = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.categorySer, null)
        37 ->
          version = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.versionSer, null)
        38 ->
          conformsTo =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.conformsToSer, null)
        39 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.propertySer, null)
        40 ->
          mode =
            decoder.decodeNullableSerializableElement(
              __desc,
              40,
              Hoisted.availabilityStatusSer,
              null,
            )
        41 -> cycle = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.cycleSer, null)
        42 ->
          duration =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.durationSer, null)
        43 -> owner = decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.ownerSer, null)
        44 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.contactSer, null)
        45 ->
          location = decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.ownerSer, null)
        46 -> url = decoder.decodeStringElement(__desc, 46)
        47 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.implicitRulesSer, null)
        48 ->
          endpoint =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.endpointSer, null)
        49 ->
          gateway = decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.gatewaySer, null)
        50 -> note = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.noteSer, null)
        51 ->
          safety = decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.categorySer, null)
        52 -> parent = decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.ownerSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Device: " + __i)
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
      status = status?.let { Enumeration.of(Device.FHIRDeviceStatus.fromCode(it), _status) },
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Device) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Device")
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
    ((value.displayName?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.displayName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.definition)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.definitionSer, it)
    }
    if (value.udiCarrier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.udiCarrierSer, value.udiCarrier)
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.availabilityStatus)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.availabilityStatusSer, it)
    }
    (value.biologicalSourceEvent)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.identifierSerInner, it)
    }
    ((value.manufacturer?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.manufacturer?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.manufactureDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 22, it)
    }
    (value.manufactureDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.expirationDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.serialNumber?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.serialNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.nameSer, value.name)
    ((value.modelNumber?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.modelNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    ((value.partNumber?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.partNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.categorySer, value.category)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.categorySer, value.type)
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.versionSer, value.version)
    if (value.conformsTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.conformsToSer, value.conformsTo)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.propertySer, value.`property`)
    (value.mode)?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.availabilityStatusSer, it)
    }
    (value.cycle)?.let { encoder.encodeSerializableElement(__desc, 41, Hoisted.cycleSer, it) }
    (value.duration)?.let { encoder.encodeSerializableElement(__desc, 42, Hoisted.durationSer, it) }
    (value.owner)?.let { encoder.encodeSerializableElement(__desc, 43, Hoisted.ownerSer, it) }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.contactSer, value.contact)
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 45, Hoisted.ownerSer, it) }
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 46, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.implicitRulesSer, it)
    }
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.endpointSer, value.endpoint)
    if (value.gateway.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.gatewaySer, value.gateway)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.noteSer, value.note)
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.categorySer, value.safety)
    (value.parent)?.let { encoder.encodeSerializableElement(__desc, 52, Hoisted.ownerSer, it) }
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
