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
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.DeviceNameType
import dev.ohs.fhir.model.r4b.terminologies.FHIRDeviceStatus
import dev.ohs.fhir.model.r4b.terminologies.UDIEntryType
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

internal object DeviceUdiCarrierSerializer : KSerializer<Device.UdiCarrier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("UdiCarrier") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("deviceIdentifier", KotlinString.serializer().descriptor)
      optionalElement("_deviceIdentifier", ElementSerializer.descriptor)
      optionalElement("issuer", KotlinString.serializer().descriptor)
      optionalElement("_issuer", ElementSerializer.descriptor)
      optionalElement("jurisdiction", KotlinString.serializer().descriptor)
      optionalElement("_jurisdiction", ElementSerializer.descriptor)
      optionalElement("carrierAIDC", KotlinString.serializer().descriptor)
      optionalElement("_carrierAIDC", ElementSerializer.descriptor)
      optionalElement("carrierHRF", KotlinString.serializer().descriptor)
      optionalElement("_carrierHRF", ElementSerializer.descriptor)
      optionalElement("entryType", KotlinString.serializer().descriptor)
      optionalElement("_entryType", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Device.UdiCarrier>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Device.UdiCarrier {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> deviceIdentifier = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _deviceIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> issuer = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _issuer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> jurisdiction = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> carrierAIDC = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _carrierAIDC =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> carrierHRF = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _carrierHRF =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> entryType = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _entryType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding UdiCarrier: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Device.UdiCarrier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      deviceIdentifier = R4bString.of(deviceIdentifier, _deviceIdentifier),
      issuer = Uri.of(issuer, _issuer),
      jurisdiction = Uri.of(jurisdiction, _jurisdiction),
      carrierAIDC = Base64Binary.of(carrierAIDC, _carrierAIDC),
      carrierHRF = R4bString.of(carrierHRF, _carrierHRF),
      entryType =
        Enumeration.of(
          if (entryType != null) UDIEntryType.fromCode(entryType) else null,
          _entryType,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Device.UdiCarrier) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.deviceIdentifier?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.deviceIdentifier)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.issuer?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.issuer)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.jurisdiction?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.jurisdiction)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.carrierAIDC?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.carrierAIDC)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.carrierHRF?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.carrierHRF)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.entryType?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.entryType)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDeviceNameSerializer : KSerializer<Device.DeviceName> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceName") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Device.DeviceName>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Device.DeviceName {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DeviceName: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Device.DeviceName(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on Device.DeviceName"),
      type =
        Enumeration.of(if (type != null) DeviceNameType.fromCode(type) else null, _type)
          ?: throw SerializationException("Missing required property 'type' on Device.DeviceName"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Device.DeviceName) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.type)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceSpecializationSerializer : KSerializer<Device.Specialization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specialization") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("systemType", CodeableConceptSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Device.Specialization>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Device.Specialization {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var systemType: CodeableConcept? = null
    var version: KotlinString? = null
    var _version: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          systemType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Specialization: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Device.Specialization(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      systemType =
        systemType
          ?: throw SerializationException(
            "Missing required property 'systemType' on Device.Specialization"
          ),
      version = R4bString.of(version, _version),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Device.Specialization) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.systemType,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.version)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceVersionSerializer : KSerializer<Device.Version> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Version") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("component", IdentifierSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Device.Version>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Device.Version {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var component: Identifier? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          component =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        5 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Device.Version(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      component = component,
      `value` =
        R4bString.of(`value`, _value)
          ?: throw SerializationException("Missing required property 'value' on Device.Version"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Device.Version) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      IdentifierSerializer,
      value.component,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DevicePropertySerializer : KSerializer<Device.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.listSerializer.descriptor)
      optionalElement("valueCode", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Device.Property>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Device.Property {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueQuantity: List<Quantity>? = null
    var valueCode: List<CodeableConcept>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer.listSerializer,
              null,
            )
        5 ->
          valueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Device.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Device.Property"),
      valueQuantity = valueQuantity ?: listOf(),
      valueCode = valueCode ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Device.Property) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    if (value.valueQuantity.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        QuantitySerializer.listSerializer,
        value.valueQuantity,
      )
    if (value.valueCode.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        CodeableConceptSerializer.listSerializer,
        value.valueCode,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceSerializer : FhirResourceSerializer<Device> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Device")

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
    b.optionalElement("definition", ReferenceSerializer.descriptor)
    b.optionalElement("udiCarrier", DeviceUdiCarrierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("distinctIdentifier", KotlinString.serializer().descriptor)
    b.optionalElement("_distinctIdentifier", ElementSerializer.descriptor)
    b.optionalElement("manufacturer", KotlinString.serializer().descriptor)
    b.optionalElement("_manufacturer", ElementSerializer.descriptor)
    b.optionalElement("manufactureDate", KotlinString.serializer().descriptor)
    b.optionalElement("_manufactureDate", ElementSerializer.descriptor)
    b.optionalElement("expirationDate", KotlinString.serializer().descriptor)
    b.optionalElement("_expirationDate", ElementSerializer.descriptor)
    b.optionalElement("lotNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_lotNumber", ElementSerializer.descriptor)
    b.optionalElement("serialNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_serialNumber", ElementSerializer.descriptor)
    b.optionalElement("deviceName", DeviceDeviceNameSerializer.listSerializer.descriptor)
    b.optionalElement("modelNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_modelNumber", ElementSerializer.descriptor)
    b.optionalElement("partNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_partNumber", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("specialization", DeviceSpecializationSerializer.listSerializer.descriptor)
    b.optionalElement("version", DeviceVersionSerializer.listSerializer.descriptor)
    b.optionalElement("property", DevicePropertySerializer.listSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("owner", ReferenceSerializer.descriptor)
    b.optionalElement("contact", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("safety", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("parent", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          definition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        12 ->
          udiCarrier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceUdiCarrierSerializer.listSerializer,
              null,
            )
        13 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          statusReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 -> distinctIdentifier = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _distinctIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> manufacturer = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> manufactureDate = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _manufactureDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> expirationDate = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _expirationDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> lotNumber = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _lotNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> serialNumber = compositeDecoder.decodeStringElement(descriptor, i)
        27 ->
          _serialNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 ->
          deviceName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDeviceNameSerializer.listSerializer,
              null,
            )
        29 -> modelNumber = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _modelNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 -> partNumber = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _partNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        34 ->
          specialization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceSpecializationSerializer.listSerializer,
              null,
            )
        35 ->
          version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceVersionSerializer.listSerializer,
              null,
            )
        36 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DevicePropertySerializer.listSerializer,
              null,
            )
        37 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        38 ->
          owner =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        39 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        40 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        41 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        44 ->
          safety =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        45 ->
          parent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
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
      definition = definition,
      udiCarrier = udiCarrier ?: listOf(),
      status =
        Enumeration.of(if (status != null) FHIRDeviceStatus.fromCode(status) else null, _status),
      statusReason = statusReason ?: listOf(),
      distinctIdentifier = R4bString.of(distinctIdentifier, _distinctIdentifier),
      manufacturer = R4bString.of(manufacturer, _manufacturer),
      manufactureDate =
        DateTime.of(
          if (manufactureDate != null) FhirDateTime.fromString(manufactureDate) else null,
          _manufactureDate,
        ),
      expirationDate =
        DateTime.of(
          if (expirationDate != null) FhirDateTime.fromString(expirationDate) else null,
          _expirationDate,
        ),
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

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Device,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      ReferenceSerializer,
      value.definition,
    )
    if (value.udiCarrier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        DeviceUdiCarrierSerializer.listSerializer,
        value.udiCarrier,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.status?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    if (value.statusReason.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.statusReason,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.distinctIdentifier?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.distinctIdentifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.manufacturer?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.manufacturer)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.manufactureDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.manufactureDate,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.expirationDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.expirationDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.lotNumber?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.lotNumber)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.serialNumber?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.serialNumber)
    if (value.deviceName.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        DeviceDeviceNameSerializer.listSerializer,
        value.deviceName,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.modelNumber?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.modelNumber)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.partNumber?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.partNumber)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.specialization.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        DeviceSpecializationSerializer.listSerializer,
        value.specialization,
      )
    if (value.version.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        DeviceVersionSerializer.listSerializer,
        value.version,
      )
    if (value.`property`.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        DevicePropertySerializer.listSerializer,
        value.`property`,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.url)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.safety.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.safety,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      ReferenceSerializer,
      value.parent,
    )
  }
}
