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
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.DeviceDefinition
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.ProdCharacteristic
import dev.ohs.fhir.model.r4b.ProductShelfLife
import dev.ohs.fhir.model.r4b.Quantity
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
import kotlinx.serialization.builtins.nullable
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

internal object DeviceDefinitionUdiDeviceIdentifierSerializer :
  KSerializer<DeviceDefinition.UdiDeviceIdentifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("UdiDeviceIdentifier") {
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
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.UdiDeviceIdentifier =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.UdiDeviceIdentifier) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.UdiDeviceIdentifier {
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
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding UdiDeviceIdentifier: " + __i)
      }
    }
    return DeviceDefinition.UdiDeviceIdentifier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      deviceIdentifier = R4bString.of(deviceIdentifier, _deviceIdentifier)!!,
      issuer = Uri.of(issuer, _issuer)!!,
      jurisdiction = Uri.of(jurisdiction, _jurisdiction)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: DeviceDefinition.UdiDeviceIdentifier,
  ) {
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
    ((value.jurisdiction.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.jurisdiction.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.deviceIdentifierSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val deviceIdentifierSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceDefinitionDeviceNameSerializer : KSerializer<DeviceDefinition.DeviceName> {
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

  override fun deserialize(decoder: Decoder): DeviceDefinition.DeviceName =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.DeviceName) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.DeviceName {
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> type = decoder.decodeStringElement(__desc, 5)
        6 -> _type = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DeviceName: " + __i)
      }
    }
    return DeviceDefinition.DeviceName(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name)!!,
      type = Enumeration.of(DeviceDefinition.DeviceNameType.fromCode(type!!), _type),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.DeviceName) {
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

internal object DeviceDefinitionSpecializationSerializer :
  KSerializer<DeviceDefinition.Specialization> {
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
      element("systemType", KotlinString.serializer().descriptor, isOptional = true)
      element("_systemType", Element.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Specialization =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Specialization) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Specialization {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var systemType: KotlinString? = null
    var _systemType: Element? = null
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
        3 -> systemType = decoder.decodeStringElement(__desc, 3)
        4 ->
          _systemType =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.systemTypeSer, null)
        5 -> version = decoder.decodeStringElement(__desc, 5)
        6 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.systemTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Specialization: " + __i)
      }
    }
    return DeviceDefinition.Specialization(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      systemType = R4bString.of(systemType, _systemType)!!,
      version = R4bString.of(version, _version),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Specialization) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.systemType.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.systemType.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.systemTypeSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.systemTypeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val systemTypeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceDefinitionCapabilitySerializer : KSerializer<DeviceDefinition.Capability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Capability") {
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
        "description",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Capability =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Capability) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Capability {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var description: List<CodeableConcept>? = null
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
          description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Capability: " + __i)
      }
    }
    return DeviceDefinition.Capability(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      description = description ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Capability) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    if (value.description.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, value.description)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val descriptionSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)
  }
}

internal object DeviceDefinitionPropertySerializer : KSerializer<DeviceDefinition.Property> {
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

  override fun deserialize(decoder: Decoder): DeviceDefinition.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Property {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueQuantity: List<Quantity>? = null
    var valueCode: List<CodeableConcept>? = null
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
          valueCode =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueCodeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return DeviceDefinition.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      valueQuantity = valueQuantity ?: listOf(),
      valueCode = valueCode ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Property) {
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

internal object DeviceDefinitionMaterialSerializer : KSerializer<DeviceDefinition.Material> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Material") {
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
      element("substance", CodeableConcept.serializer().descriptor, isOptional = true)
      element("alternate", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_alternate", Element.serializer().descriptor, isOptional = true)
      element("allergenicIndicator", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_allergenicIndicator", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Material =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Material) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Material {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var substance: CodeableConcept? = null
    var alternate: KotlinBoolean? = null
    var _alternate: Element? = null
    var allergenicIndicator: KotlinBoolean? = null
    var _allergenicIndicator: Element? = null
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
          substance =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.substanceSer, null)
        4 -> alternate = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _alternate =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.alternateSer, null)
        6 -> allergenicIndicator = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _allergenicIndicator =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.alternateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Material: " + __i)
      }
    }
    return DeviceDefinition.Material(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      substance = substance!!,
      alternate = R4bBoolean.of(alternate, _alternate),
      allergenicIndicator = R4bBoolean.of(allergenicIndicator, _allergenicIndicator),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Material) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.substance)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.substanceSer, it)
    }
    ((value.alternate?.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.alternate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.alternateSer, it)
    }
    ((value.allergenicIndicator?.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
    (value.allergenicIndicator?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.alternateSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val substanceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val alternateSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceDefinitionSerializer : KSerializer<DeviceDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceDefinition") {
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
      element(
        "udiDeviceIdentifier",
        listSerialDescriptor(
          lazyDescriptor { DeviceDefinition.UdiDeviceIdentifier.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("manufacturerString", KotlinString.serializer().descriptor, isOptional = true)
      element("_manufacturerString", Element.serializer().descriptor, isOptional = true)
      element("manufacturerReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "deviceName",
        listSerialDescriptor(
          lazyDescriptor { DeviceDefinition.DeviceName.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("modelNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_modelNumber", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "specialization",
        listSerialDescriptor(
          lazyDescriptor { DeviceDefinition.Specialization.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "version",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_version", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "safety",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "shelfLifeStorage",
        listSerialDescriptor(ProductShelfLife.serializer().descriptor),
        isOptional = true,
      )
      element(
        "physicalCharacteristics",
        ProdCharacteristic.serializer().descriptor,
        isOptional = true,
      )
      element(
        "languageCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "capability",
        listSerialDescriptor(
          lazyDescriptor { DeviceDefinition.Capability.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(lazyDescriptor { DeviceDefinition.Property.serializer().descriptor }),
        isOptional = true,
      )
      element("owner", Reference.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactPoint.serializer().descriptor),
        isOptional = true,
      )
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element("onlineInformation", KotlinString.serializer().descriptor, isOptional = true)
      element("_onlineInformation", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("parentDevice", Reference.serializer().descriptor, isOptional = true)
      element(
        "material",
        listSerialDescriptor(lazyDescriptor { DeviceDefinition.Material.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition {
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
    var udiDeviceIdentifier: List<DeviceDefinition.UdiDeviceIdentifier>? = null
    var manufacturerString: KotlinString? = null
    var _manufacturerString: Element? = null
    var manufacturerReference: Reference? = null
    var deviceName: List<DeviceDefinition.DeviceName>? = null
    var modelNumber: KotlinString? = null
    var _modelNumber: Element? = null
    var type: CodeableConcept? = null
    var specialization: List<DeviceDefinition.Specialization>? = null
    var version: List<KotlinString?>? = null
    var _version: List<Element?>? = null
    var safety: List<CodeableConcept>? = null
    var shelfLifeStorage: List<ProductShelfLife>? = null
    var physicalCharacteristics: ProdCharacteristic? = null
    var languageCode: List<CodeableConcept>? = null
    var capability: List<DeviceDefinition.Capability>? = null
    var `property`: List<DeviceDefinition.Property>? = null
    var owner: Reference? = null
    var contact: List<ContactPoint>? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var onlineInformation: KotlinString? = null
    var _onlineInformation: Element? = null
    var note: List<Annotation>? = null
    var quantity: Quantity? = null
    var parentDevice: Reference? = null
    var material: List<DeviceDefinition.Material>? = null
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
        12 ->
          udiDeviceIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.udiDeviceIdentifierSer,
              null,
            )
        13 -> manufacturerString = decoder.decodeStringElement(__desc, 13)
        14 ->
          _manufacturerString =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          manufacturerReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.manufacturerReferenceSer,
              null,
            )
        16 ->
          deviceName =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.deviceNameSer, null)
        17 -> modelNumber = decoder.decodeStringElement(__desc, 17)
        18 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 -> type = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.typeSer, null)
        20 ->
          specialization =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.specializationSer, null)
        21 ->
          version = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.versionSer, null)
        22 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.versionSer2, null)
        23 ->
          safety = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.safetySer, null)
        24 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.shelfLifeStorageSer, null)
        25 ->
          physicalCharacteristics =
            decoder.decodeNullableSerializableElement(
              __desc,
              25,
              Hoisted.physicalCharacteristicsSer,
              null,
            )
        26 ->
          languageCode =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.safetySer, null)
        27 ->
          capability =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.capabilitySer, null)
        28 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.propertySer, null)
        29 ->
          owner =
            decoder.decodeNullableSerializableElement(
              __desc,
              29,
              Hoisted.manufacturerReferenceSer,
              null,
            )
        30 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.contactSer, null)
        31 -> url = decoder.decodeStringElement(__desc, 31)
        32 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 -> onlineInformation = decoder.decodeStringElement(__desc, 33)
        34 ->
          _onlineInformation =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 -> note = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.noteSer, null)
        36 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.quantitySer, null)
        37 ->
          parentDevice =
            decoder.decodeNullableSerializableElement(
              __desc,
              37,
              Hoisted.manufacturerReferenceSer,
              null,
            )
        38 ->
          material =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.materialSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DeviceDefinition: " + __i)
      }
    }
    return DeviceDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      udiDeviceIdentifier = udiDeviceIdentifier ?: listOf(),
      manufacturer =
        DeviceDefinition.Manufacturer.from(
          R4bString.of(manufacturerString, _manufacturerString),
          manufacturerReference,
        ),
      deviceName = deviceName ?: listOf(),
      modelNumber = R4bString.of(modelNumber, _modelNumber),
      type = type,
      specialization = specialization ?: listOf(),
      version =
        (kotlin.collections.List(maxOf(version?.size ?: 0, _version?.size ?: 0)) { __i ->
          R4bString.of(version?.getOrNull(__i)?.let { it }, _version?.getOrNull(__i))!!
        }),
      safety = safety ?: listOf(),
      shelfLifeStorage = shelfLifeStorage ?: listOf(),
      physicalCharacteristics = physicalCharacteristics,
      languageCode = languageCode ?: listOf(),
      capability = capability ?: listOf(),
      `property` = `property` ?: listOf(),
      owner = owner,
      contact = contact ?: listOf(),
      url = Uri.of(url, _url),
      onlineInformation = Uri.of(onlineInformation, _onlineInformation),
      note = note ?: listOf(),
      quantity = quantity,
      parentDevice = parentDevice,
      material = material ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "DeviceDefinition")
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
    if (value.udiDeviceIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        12,
        Hoisted.udiDeviceIdentifierSer,
        value.udiDeviceIdentifier,
      )
    when (val __d = value.manufacturer) {
      null -> {}
      is DeviceDefinition.Manufacturer.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
        }
      }
      is DeviceDefinition.Manufacturer.Reference -> {
        encoder.encodeSerializableElement(__desc, 15, Hoisted.manufacturerReferenceSer, __d.value)
      }
    }
    if (value.deviceName.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.deviceNameSer, value.deviceName)
    ((value.modelNumber?.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.modelNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.typeSer, it) }
    if (value.specialization.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.specializationSer, value.specialization)
    (value.version.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.versionSer, it)
    }
    (value.version.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.versionSer2, it)
    }
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.safetySer, value.safety)
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        24,
        Hoisted.shelfLifeStorageSer,
        value.shelfLifeStorage,
      )
    (value.physicalCharacteristics)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.physicalCharacteristicsSer, it)
    }
    if (value.languageCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.safetySer, value.languageCode)
    if (value.capability.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.capabilitySer, value.capability)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.propertySer, value.`property`)
    (value.owner)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.manufacturerReferenceSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.contactSer, value.contact)
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    ((value.onlineInformation?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.onlineInformation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.noteSer, value.note)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 36, Hoisted.quantitySer, it) }
    (value.parentDevice)?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.manufacturerReferenceSer, it)
    }
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.materialSer, value.material)
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

    public val udiDeviceIdentifierSerInner: KSerializer<DeviceDefinition.UdiDeviceIdentifier> =
      DeviceDefinition.UdiDeviceIdentifier.serializer()

    public val udiDeviceIdentifierSer: KSerializer<List<DeviceDefinition.UdiDeviceIdentifier>> =
      ListSerializer(Hoisted.udiDeviceIdentifierSerInner)

    public val manufacturerReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val deviceNameSerInner: KSerializer<DeviceDefinition.DeviceName> =
      DeviceDefinition.DeviceName.serializer()

    public val deviceNameSer: KSerializer<List<DeviceDefinition.DeviceName>> =
      ListSerializer(Hoisted.deviceNameSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val specializationSerInner: KSerializer<DeviceDefinition.Specialization> =
      DeviceDefinition.Specialization.serializer()

    public val specializationSer: KSerializer<List<DeviceDefinition.Specialization>> =
      ListSerializer(Hoisted.specializationSerInner)

    public val versionSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val versionSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.versionSerInner).nullable)

    public val versionSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val safetySer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val shelfLifeStorageSerInner: KSerializer<ProductShelfLife> =
      ProductShelfLife.serializer()

    public val shelfLifeStorageSer: KSerializer<List<ProductShelfLife>> =
      ListSerializer(Hoisted.shelfLifeStorageSerInner)

    public val physicalCharacteristicsSer: KSerializer<ProdCharacteristic> =
      ProdCharacteristic.serializer()

    public val capabilitySerInner: KSerializer<DeviceDefinition.Capability> =
      DeviceDefinition.Capability.serializer()

    public val capabilitySer: KSerializer<List<DeviceDefinition.Capability>> =
      ListSerializer(Hoisted.capabilitySerInner)

    public val propertySerInner: KSerializer<DeviceDefinition.Property> =
      DeviceDefinition.Property.serializer()

    public val propertySer: KSerializer<List<DeviceDefinition.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val contactSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val contactSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.contactSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val materialSerInner: KSerializer<DeviceDefinition.Material> =
      DeviceDefinition.Material.serializer()

    public val materialSer: KSerializer<List<DeviceDefinition.Material>> =
      ListSerializer(Hoisted.materialSerInner)
  }
}
