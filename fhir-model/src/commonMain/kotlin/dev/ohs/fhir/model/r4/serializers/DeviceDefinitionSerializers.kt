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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.DeviceDefinition
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.ProdCharacteristic
import dev.ohs.fhir.model.r4.ProductShelfLife
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding UdiDeviceIdentifier: " + __i)
      }
    }
    return DeviceDefinition.UdiDeviceIdentifier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      deviceIdentifier = R4String.of(deviceIdentifier, _deviceIdentifier)!!,
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
    return DeviceDefinition.DeviceName(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name)!!,
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> systemType = decoder.decodeStringElement(__desc, __i)
        4 ->
          _systemType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.systemTypeSer, null)
        5 -> version = decoder.decodeStringElement(__desc, __i)
        6 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.systemTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Specialization: " + __i)
      }
    }
    return DeviceDefinition.Specialization(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      systemType = R4String.of(systemType, _systemType)!!,
      version = R4String.of(version, _version),
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          substance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.substanceSer, null)
        4 -> alternate = decoder.decodeBooleanElement(__desc, __i)
        5 ->
          _alternate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.alternateSer, null)
        6 -> allergenicIndicator = decoder.decodeBooleanElement(__desc, __i)
        7 ->
          _allergenicIndicator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.alternateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Material: " + __i)
      }
    }
    return DeviceDefinition.Material(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      substance = substance!!,
      alternate = R4Boolean.of(alternate, _alternate),
      allergenicIndicator = R4Boolean.of(allergenicIndicator, _allergenicIndicator),
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
    b.element(
      "udiDeviceIdentifier",
      listSerialDescriptor(
        lazyDescriptor { DeviceDefinition.UdiDeviceIdentifier.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("manufacturerString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_manufacturerString", Element.serializer().descriptor, isOptional = true)
    b.element("manufacturerReference", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "deviceName",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.DeviceName.serializer().descriptor }),
      isOptional = true,
    )
    b.element("modelNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_modelNumber", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "specialization",
      listSerialDescriptor(
        lazyDescriptor { DeviceDefinition.Specialization.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "version",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_version", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "safety",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "shelfLifeStorage",
      listSerialDescriptor(ProductShelfLife.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "physicalCharacteristics",
      ProdCharacteristic.serializer().descriptor,
      isOptional = true,
    )
    b.element(
      "languageCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "capability",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.Capability.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "property",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.Property.serializer().descriptor }),
      isOptional = true,
    )
    b.element("owner", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactPoint.serializer().descriptor),
      isOptional = true,
    )
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element("onlineInformation", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_onlineInformation", Element.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element("quantity", Quantity.serializer().descriptor, isOptional = true)
    b.element("parentDevice", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "material",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.Material.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DeviceDefinition")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): DeviceDefinition {
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
          udiDeviceIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.udiDeviceIdentifierSer,
              null,
            )
        12 -> manufacturerString = decoder.decodeStringElement(__desc, __i)
        13 ->
          _manufacturerString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 ->
          manufacturerReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.manufacturerReferenceSer,
              null,
            )
        15 ->
          deviceName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.deviceNameSer, null)
        16 -> modelNumber = decoder.decodeStringElement(__desc, __i)
        17 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        19 ->
          specialization =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.specializationSer, null)
        20 ->
          version = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.versionSer, null)
        21 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.versionSer2, null)
        22 ->
          safety = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.safetySer, null)
        23 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.shelfLifeStorageSer,
              null,
            )
        24 ->
          physicalCharacteristics =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.physicalCharacteristicsSer,
              null,
            )
        25 ->
          languageCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.safetySer, null)
        26 ->
          capability =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.capabilitySer, null)
        27 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        28 ->
          owner =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.manufacturerReferenceSer,
              null,
            )
        29 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        30 -> url = decoder.decodeStringElement(__desc, __i)
        31 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        32 -> onlineInformation = decoder.decodeStringElement(__desc, __i)
        33 ->
          _onlineInformation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        34 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        35 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        36 ->
          parentDevice =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.manufacturerReferenceSer,
              null,
            )
        37 ->
          material =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.materialSer, null)
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
          R4String.of(manufacturerString, _manufacturerString),
          manufacturerReference,
        ),
      deviceName = deviceName ?: listOf(),
      modelNumber = R4String.of(modelNumber, _modelNumber),
      type = type,
      specialization = specialization ?: listOf(),
      version =
        (kotlin.collections.List(maxOf(version?.size ?: 0, _version?.size ?: 0)) { __i ->
          R4String.of(version?.getOrNull(__i)?.let { it }, _version?.getOrNull(__i))!!
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: DeviceDefinition,
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
    if (value.udiDeviceIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        11 + __off,
        Hoisted.udiDeviceIdentifierSer,
        value.udiDeviceIdentifier,
      )
    when (val __d = value.manufacturer) {
      null -> {}
      is DeviceDefinition.Manufacturer.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is DeviceDefinition.Manufacturer.Reference -> {
        encoder.encodeSerializableElement(
          __desc,
          14 + __off,
          Hoisted.manufacturerReferenceSer,
          __d.value,
        )
      }
    }
    if (value.deviceName.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.deviceNameSer, value.deviceName)
    ((value.modelNumber?.value))?.let { encoder.encodeStringElement(__desc, 16 + __off, it) }
    (value.modelNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.typeSer, it) }
    if (value.specialization.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19 + __off,
        Hoisted.specializationSer,
        value.specialization,
      )
    (value.version.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.versionSer, it)
    }
    (value.version.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.versionSer2, it)
    }
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.safetySer, value.safety)
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23 + __off,
        Hoisted.shelfLifeStorageSer,
        value.shelfLifeStorage,
      )
    (value.physicalCharacteristics)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.physicalCharacteristicsSer, it)
    }
    if (value.languageCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.safetySer, value.languageCode)
    if (value.capability.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.capabilitySer, value.capability)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.propertySer, value.`property`)
    (value.owner)?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.manufacturerReferenceSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.contactSer, value.contact)
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 30 + __off, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.onlineInformation?.value))?.let { encoder.encodeStringElement(__desc, 32 + __off, it) }
    (value.onlineInformation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.noteSer, value.note)
    (value.quantity)?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.quantitySer, it)
    }
    (value.parentDevice)?.let {
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.manufacturerReferenceSer, it)
    }
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.materialSer, value.material)
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

internal object DeviceDefinitionPolymorphicSerializer : KSerializer<DeviceDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceDefinition") {
      DeviceDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition) {
    encoder.encodeStructure(descriptor) {
      DeviceDefinitionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition =
    decoder.decodeStructure(descriptor) {
      DeviceDefinitionSerializer.deserializeJson(this, descriptor, 0)
    }
}
