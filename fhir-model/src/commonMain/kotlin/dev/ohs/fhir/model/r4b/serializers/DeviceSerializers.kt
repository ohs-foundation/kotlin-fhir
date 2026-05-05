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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> deviceIdentifier = decoder.decodeStringElement(__desc, __i)
        4 ->
          _deviceIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        5 -> issuer = decoder.decodeStringElement(__desc, __i)
        6 ->
          _issuer =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        7 -> jurisdiction = decoder.decodeStringElement(__desc, __i)
        8 ->
          _jurisdiction =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        9 -> carrierAIDC = decoder.decodeStringElement(__desc, __i)
        10 ->
          _carrierAIDC =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        11 -> carrierHRF = decoder.decodeStringElement(__desc, __i)
        12 ->
          _carrierHRF =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        13 -> entryType = decoder.decodeStringElement(__desc, __i)
        14 ->
          _entryType =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.deviceIdentifierSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding UdiCarrier: " + __i)
      }
    }
    return Device.UdiCarrier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      deviceIdentifier = R4bString.of(deviceIdentifier, _deviceIdentifier),
      issuer = Uri.of(issuer, _issuer),
      jurisdiction = Uri.of(jurisdiction, _jurisdiction),
      carrierAIDC = Base64Binary.of(carrierAIDC, _carrierAIDC),
      carrierHRF = R4bString.of(carrierHRF, _carrierHRF),
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
    ((value.deviceIdentifier?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.deviceIdentifier?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.deviceIdentifierSer, it)
    }
    ((value.issuer?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.issuer?.toElement())?.let {
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

internal object DeviceDeviceNameSerializer : KSerializer<Device.DeviceName> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceName") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Device.DeviceName =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Device.DeviceName) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Device.DeviceName {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 -> type = decoder.decodeStringElement(__desc, __i)
        6 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DeviceName: " + __i)
      }
    }
    return Device.DeviceName(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name)!!,
      type = Enumeration.of(Device.DeviceNameType.fromCode(type!!), _type),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Device.DeviceName) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceSpecializationSerializer : KSerializer<Device.Specialization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specialization") {
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
      element("systemType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Device.Specialization =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Device.Specialization) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Device.Specialization {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var systemType: CodeableConcept? = null
    var version: KotlinString? = null
    var _version: Element? = null
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
          systemType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.systemTypeSer, null)
        4 -> version = decoder.decodeStringElement(__desc, __i)
        5 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.versionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Specialization: " + __i)
      }
    }
    return Device.Specialization(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      systemType = systemType!!,
      version = R4bString.of(version, _version),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Device.Specialization) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.systemType)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.systemTypeSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.versionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val systemTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val versionSer: KSerializer<Element> = Element.serializer()
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
    var `value`: KotlinString? = null
    var _value: Element? = null
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
          component =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.componentSer, null)
        5 -> `value` = decoder.decodeStringElement(__desc, __i)
        6 -> _value = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueSer, null)
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
      `value` = R4bString.of(`value`, _value)!!,
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
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val componentSer: KSerializer<Identifier> = Identifier.serializer()

    public val valueSer: KSerializer<Element> = Element.serializer()
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
      element(
        "valueQuantity",
        listSerialDescriptor(Quantity.serializer().descriptor),
        isOptional = true,
      )
      element(
        "valueCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
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
    var valueQuantity: List<Quantity>? = null
    var valueCode: List<CodeableConcept>? = null
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
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        5 ->
          valueCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCodeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return Device.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      valueQuantity = valueQuantity ?: listOf(),
      valueCode = valueCode ?: listOf(),
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
    if (value.valueQuantity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.valueQuantitySer, value.valueQuantity)
    if (value.valueCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.valueCodeSer, value.valueCode)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySerInner: KSerializer<Quantity> = Quantity.serializer()

    public val valueQuantitySer: KSerializer<List<Quantity>> =
      ListSerializer(Hoisted.valueQuantitySerInner)

    public val valueCodeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)
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
    b.element("definition", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "udiCarrier",
      listSerialDescriptor(lazyDescriptor { Device.UdiCarrier.serializer().descriptor }),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "statusReason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("distinctIdentifier", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_distinctIdentifier", Element.serializer().descriptor, isOptional = true)
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
      "deviceName",
      listSerialDescriptor(lazyDescriptor { Device.DeviceName.serializer().descriptor }),
      isOptional = true,
    )
    b.element("modelNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_modelNumber", Element.serializer().descriptor, isOptional = true)
    b.element("partNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_partNumber", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "specialization",
      listSerialDescriptor(lazyDescriptor { Device.Specialization.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "version",
      listSerialDescriptor(lazyDescriptor { Device.Version.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "property",
      listSerialDescriptor(lazyDescriptor { Device.Property.serializer().descriptor }),
      isOptional = true,
    )
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("owner", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactPoint.serializer().descriptor),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "safety",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("parent", Reference.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Device =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Device) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Device")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Device {
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
    var definition: Reference? = null
    var udiCarrier: List<Device.UdiCarrier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: List<CodeableConcept>? = null
    var distinctIdentifier: KotlinString? = null
    var _distinctIdentifier: Element? = null
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
    var deviceName: List<Device.DeviceName>? = null
    var modelNumber: KotlinString? = null
    var _modelNumber: Element? = null
    var partNumber: KotlinString? = null
    var _partNumber: Element? = null
    var type: CodeableConcept? = null
    var specialization: List<Device.Specialization>? = null
    var version: List<Device.Version>? = null
    var `property`: List<Device.Property>? = null
    var patient: Reference? = null
    var owner: Reference? = null
    var contact: List<ContactPoint>? = null
    var location: Reference? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var note: List<Annotation>? = null
    var safety: List<CodeableConcept>? = null
    var parent: Reference? = null
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
        11 ->
          definition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionSer, null)
        12 ->
          udiCarrier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.udiCarrierSer, null)
        13 -> status = decoder.decodeStringElement(__desc, __i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        16 -> distinctIdentifier = decoder.decodeStringElement(__desc, __i)
        17 ->
          _distinctIdentifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 -> manufacturer = decoder.decodeStringElement(__desc, __i)
        19 ->
          _manufacturer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 -> manufactureDate = decoder.decodeStringElement(__desc, __i)
        21 ->
          _manufactureDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 -> expirationDate = decoder.decodeStringElement(__desc, __i)
        23 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 -> lotNumber = decoder.decodeStringElement(__desc, __i)
        25 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        26 -> serialNumber = decoder.decodeStringElement(__desc, __i)
        27 ->
          _serialNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 ->
          deviceName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.deviceNameSer, null)
        29 -> modelNumber = decoder.decodeStringElement(__desc, __i)
        30 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        31 -> partNumber = decoder.decodeStringElement(__desc, __i)
        32 ->
          _partNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        33 ->
          type =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.statusReasonSerInner,
              null,
            )
        34 ->
          specialization =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.specializationSer, null)
        35 ->
          version = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.versionSer, null)
        36 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        37 ->
          patient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionSer, null)
        38 ->
          owner =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionSer, null)
        39 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        40 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionSer, null)
        41 -> url = decoder.decodeStringElement(__desc, __i)
        42 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        43 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        44 ->
          safety =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        45 ->
          parent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionSer, null)
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
      definition = definition,
      udiCarrier = udiCarrier ?: listOf(),
      status = status?.let { Enumeration.of(Device.FHIRDeviceStatus.fromCode(it), _status) },
      statusReason = statusReason ?: listOf(),
      distinctIdentifier = R4bString.of(distinctIdentifier, _distinctIdentifier),
      manufacturer = R4bString.of(manufacturer, _manufacturer),
      manufactureDate = DateTime.of(FhirDateTime.fromString(manufactureDate), _manufactureDate),
      expirationDate = DateTime.of(FhirDateTime.fromString(expirationDate), _expirationDate),
      lotNumber = R4bString.of(lotNumber, _lotNumber),
      serialNumber = R4bString.of(serialNumber, _serialNumber),
      deviceName = deviceName ?: listOf(),
      modelNumber = R4bString.of(modelNumber, _modelNumber),
      partNumber = R4bString.of(partNumber, _partNumber),
      type = type,
      specialization = specialization ?: listOf(),
      version = version ?: listOf(),
      `property` = `property` ?: listOf(),
      patient = patient,
      owner = owner,
      contact = contact ?: listOf(),
      location = location,
      url = Uri.of(url, _url),
      note = note ?: listOf(),
      safety = safety ?: listOf(),
      parent = parent,
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Device,
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
    (value.definition)?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.definitionSer, it)
    }
    if (value.udiCarrier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.udiCarrierSer, value.udiCarrier)
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15 + __off,
        Hoisted.statusReasonSer,
        value.statusReason,
      )
    ((value.distinctIdentifier?.value))?.let { encoder.encodeStringElement(__desc, 16 + __off, it) }
    (value.distinctIdentifier?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.manufacturer?.value))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.manufacturer?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.manufactureDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 20 + __off, it)
    }
    (value.manufactureDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.expirationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 22 + __off, it)
    }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(__desc, 24 + __off, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.serialNumber?.value))?.let { encoder.encodeStringElement(__desc, 26 + __off, it) }
    (value.serialNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.deviceName.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.deviceNameSer, value.deviceName)
    ((value.modelNumber?.value))?.let { encoder.encodeStringElement(__desc, 29 + __off, it) }
    (value.modelNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.partNumber?.value))?.let { encoder.encodeStringElement(__desc, 31 + __off, it) }
    (value.partNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.statusReasonSerInner, it)
    }
    if (value.specialization.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        34 + __off,
        Hoisted.specializationSer,
        value.specialization,
      )
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.versionSer, value.version)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.propertySer, value.`property`)
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.definitionSer, it)
    }
    (value.owner)?.let {
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.definitionSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.contactSer, value.contact)
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.definitionSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 41 + __off, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.noteSer, value.note)
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.statusReasonSer, value.safety)
    (value.parent)?.let {
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.definitionSer, it)
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

    public val definitionSer: KSerializer<Reference> = Reference.serializer()

    public val udiCarrierSerInner: KSerializer<Device.UdiCarrier> = Device.UdiCarrier.serializer()

    public val udiCarrierSer: KSerializer<List<Device.UdiCarrier>> =
      ListSerializer(Hoisted.udiCarrierSerInner)

    public val statusReasonSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val statusReasonSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSerInner)

    public val deviceNameSerInner: KSerializer<Device.DeviceName> = Device.DeviceName.serializer()

    public val deviceNameSer: KSerializer<List<Device.DeviceName>> =
      ListSerializer(Hoisted.deviceNameSerInner)

    public val specializationSerInner: KSerializer<Device.Specialization> =
      Device.Specialization.serializer()

    public val specializationSer: KSerializer<List<Device.Specialization>> =
      ListSerializer(Hoisted.specializationSerInner)

    public val versionSerInner: KSerializer<Device.Version> = Device.Version.serializer()

    public val versionSer: KSerializer<List<Device.Version>> =
      ListSerializer(Hoisted.versionSerInner)

    public val propertySerInner: KSerializer<Device.Property> = Device.Property.serializer()

    public val propertySer: KSerializer<List<Device.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val contactSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val contactSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.contactSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object DevicePolymorphicSerializer : KSerializer<Device> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Device") { DeviceSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Device) {
    encoder.encodeStructure(descriptor) {
      DeviceSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Device =
    decoder.decodeStructure(descriptor) { DeviceSerializer.deserializeJson(this, descriptor, 0) }
}
