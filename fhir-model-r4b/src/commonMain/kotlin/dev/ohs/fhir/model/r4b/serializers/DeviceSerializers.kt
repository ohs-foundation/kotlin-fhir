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

  override fun deserialize(decoder: Decoder): Device.UdiCarrier =
    decoder.decodeStructure(descriptor) {
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
          3 -> deviceIdentifier = decodeStringElement(descriptor, i)
          4 ->
            _deviceIdentifier =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> issuer = decodeStringElement(descriptor, i)
          6 -> _issuer = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> jurisdiction = decodeStringElement(descriptor, i)
          8 ->
            _jurisdiction =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> carrierAIDC = decodeStringElement(descriptor, i)
          10 ->
            _carrierAIDC = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> carrierHRF = decodeStringElement(descriptor, i)
          12 ->
            _carrierHRF = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> entryType = decodeStringElement(descriptor, i)
          14 ->
            _entryType = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding UdiCarrier: " + i)
        }
      }
      Device.UdiCarrier(
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
            if (entryType != null) Device.UDIEntryType.fromCode(entryType) else null,
            _entryType,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Device.UdiCarrier) {
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
      encodeStringIfNotNull(descriptor, 3, value.deviceIdentifier?.value)
      encodeElementIfNotNull(descriptor, 4, value.deviceIdentifier)
      encodeStringIfNotNull(descriptor, 5, value.issuer?.value)
      encodeElementIfNotNull(descriptor, 6, value.issuer)
      encodeStringIfNotNull(descriptor, 7, value.jurisdiction?.value)
      encodeElementIfNotNull(descriptor, 8, value.jurisdiction)
      encodeStringIfNotNull(descriptor, 9, value.carrierAIDC?.value)
      encodeElementIfNotNull(descriptor, 10, value.carrierAIDC)
      encodeStringIfNotNull(descriptor, 11, value.carrierHRF?.value)
      encodeElementIfNotNull(descriptor, 12, value.carrierHRF)
      encodeStringIfNotNull(descriptor, 13, value.entryType?.value?.code)
      encodeElementIfNotNull(descriptor, 14, value.entryType)
    }
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

  override fun deserialize(decoder: Decoder): Device.DeviceName =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var type: KotlinString? = null
      var _type: Element? = null
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> type = decodeStringElement(descriptor, i)
          6 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DeviceName: " + i)
        }
      }
      Device.DeviceName(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R4bString.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on Device.DeviceName"
            ),
        type =
          Enumeration.of(if (type != null) Device.DeviceNameType.fromCode(type) else null, _type)
            ?: throw SerializationException(
              "Missing required property 'type' on Device.DeviceName"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Device.DeviceName) {
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
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeStringIfNotNull(descriptor, 5, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.type)
    }
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

  override fun deserialize(decoder: Decoder): Device.Specialization =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var systemType: CodeableConcept? = null
      var version: KotlinString? = null
      var _version: Element? = null
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
            systemType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> version = decodeStringElement(descriptor, i)
          5 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Specialization: " + i)
        }
      }
      Device.Specialization(
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.systemType)
      encodeStringIfNotNull(descriptor, 4, value.version?.value)
      encodeElementIfNotNull(descriptor, 5, value.version)
    }
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

  override fun deserialize(decoder: Decoder): Device.Version =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var component: Identifier? = null
      var `value`: KotlinString? = null
      var _value: Element? = null
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
            component = decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          5 -> `value` = decodeStringElement(descriptor, i)
          6 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Version: " + i)
        }
      }
      Device.Version(
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, IdentifierSerializer, value.component)
      encodeStringIfNotNull(descriptor, 5, value.`value`.value)
      encodeElementIfNotNull(descriptor, 6, value.`value`)
    }
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

  override fun deserialize(decoder: Decoder): Device.Property =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var valueQuantity: List<Quantity>? = null
      var valueCode: List<CodeableConcept>? = null
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
            valueQuantity =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuantitySerializer.listSerializer,
                null,
              )
          5 ->
            valueCode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Property: " + i)
        }
      }
      Device.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException("Missing required property 'type' on Device.Property"),
        valueQuantity = valueQuantity ?: listOf(),
        valueCode = valueCode ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Device.Property) {
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
      if (value.valueQuantity.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          QuantitySerializer.listSerializer,
          value.valueQuantity,
        )
      if (value.valueCode.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.valueCode,
        )
    }
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
        11 ->
          definition =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        12 ->
          udiCarrier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceUdiCarrierSerializer.listSerializer,
              null,
            )
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          statusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 -> distinctIdentifier = decoder.decodeStringElement(descriptor, i)
        17 ->
          _distinctIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 -> manufacturer = decoder.decodeStringElement(descriptor, i)
        19 ->
          _manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> manufactureDate = decoder.decodeStringElement(descriptor, i)
        21 ->
          _manufactureDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        23 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> lotNumber = decoder.decodeStringElement(descriptor, i)
        25 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> serialNumber = decoder.decodeStringElement(descriptor, i)
        27 ->
          _serialNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 ->
          deviceName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDeviceNameSerializer.listSerializer,
              null,
            )
        29 -> modelNumber = decoder.decodeStringElement(descriptor, i)
        30 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 -> partNumber = decoder.decodeStringElement(descriptor, i)
        32 ->
          _partNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        34 ->
          specialization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceSpecializationSerializer.listSerializer,
              null,
            )
        35 ->
          version =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceVersionSerializer.listSerializer,
              null,
            )
        36 ->
          `property` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DevicePropertySerializer.listSerializer,
              null,
            )
        37 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        38 ->
          owner =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        39 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        40 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        41 -> url = decoder.decodeStringElement(descriptor, i)
        42 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        44 ->
          safety =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        45 ->
          parent =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
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
        Enumeration.of(
          if (status != null) Device.FHIRDeviceStatus.fromCode(status) else null,
          _status,
        ),
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
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Device,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      ReferenceSerializer,
      value.definition,
    )
    if (value.udiCarrier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        DeviceUdiCarrierSerializer.listSerializer,
        value.udiCarrier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.statusReason,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.distinctIdentifier?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.distinctIdentifier)
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.manufacturer?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.manufacturer)
    encoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.manufactureDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.manufactureDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.expirationDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.expirationDate)
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.lotNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.lotNumber)
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.serialNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.serialNumber)
    if (value.deviceName.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        DeviceDeviceNameSerializer.listSerializer,
        value.deviceName,
      )
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.modelNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.modelNumber)
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.partNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.partNumber)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.specialization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        DeviceSpecializationSerializer.listSerializer,
        value.specialization,
      )
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        DeviceVersionSerializer.listSerializer,
        value.version,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        DevicePropertySerializer.listSerializer,
        value.`property`,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.url)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.safety,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      ReferenceSerializer,
      value.parent,
    )
  }
}
