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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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
      encodeStringIfNotNull(descriptor, 3, value.deviceIdentifier.value)
      encodeElementIfNotNull(descriptor, 4, value.deviceIdentifier)
      encodeStringIfNotNull(descriptor, 5, value.issuer.value)
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

internal object DeviceNameSerializer : KSerializer<Device.Name> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Name") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("display", KotlinBoolean.serializer().descriptor)
      optionalElement("_display", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Device.Name>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Device.Name =
    decoder.decodeStructure(descriptor) {
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
          3 -> `value` = decodeStringElement(descriptor, i)
          4 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> type = decodeStringElement(descriptor, i)
          6 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> display = decodeBooleanElement(descriptor, i)
          8 -> _display = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Name: " + i)
        }
      }
      Device.Name(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` =
          R5String.of(`value`, _value)
            ?: throw SerializationException("Missing required property 'value' on Device.Name"),
        type =
          Enumeration.of(if (type != null) Device.DeviceNameType.fromCode(type) else null, _type)
            ?: throw SerializationException("Missing required property 'type' on Device.Name"),
        display = R5Boolean.of(display, _display),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Device.Name) {
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
      encodeStringIfNotNull(descriptor, 3, value.`value`.value)
      encodeElementIfNotNull(descriptor, 4, value.`value`)
      encodeStringIfNotNull(descriptor, 5, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.type)
      encodeBooleanIfNotNull(descriptor, 7, value.display?.value)
      encodeElementIfNotNull(descriptor, 8, value.display)
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
      optionalElement("installDate", KotlinString.serializer().descriptor)
      optionalElement("_installDate", ElementSerializer.descriptor)
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
      var installDate: KotlinString? = null
      var _installDate: Element? = null
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
          5 -> installDate = decodeStringElement(descriptor, i)
          6 ->
            _installDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> `value` = decodeStringElement(descriptor, i)
          8 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
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
        installDate =
          DateTime.of(
            if (installDate != null) FhirDateTime.fromString(installDate) else null,
            _installDate,
          ),
        `value` =
          R5String.of(`value`, _value)
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
      encodeStringIfNotNull(descriptor, 5, value.installDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.installDate)
      encodeStringIfNotNull(descriptor, 7, value.`value`.value)
      encodeElementIfNotNull(descriptor, 8, value.`value`)
    }
  }
}

internal object DeviceConformsToSerializer : KSerializer<Device.ConformsTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConformsTo") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("specification", CodeableConceptSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Device.ConformsTo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Device.ConformsTo =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var specification: CodeableConcept? = null
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
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            specification =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> version = decodeStringElement(descriptor, i)
          6 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ConformsTo: " + i)
        }
      }
      Device.ConformsTo(
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

  override fun serialize(encoder: Encoder, `value`: Device.ConformsTo) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.category)
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.specification)
      encodeStringIfNotNull(descriptor, 5, value.version?.value)
      encodeElementIfNotNull(descriptor, 6, value.version)
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
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Device.Property>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Device.Property =
    decoder.decodeStructure(descriptor) {
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
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> valueString = decodeStringElement(descriptor, i)
          7 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueBoolean = decodeBooleanElement(descriptor, i)
          9 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> valueInteger = decodeIntElement(descriptor, i)
          11 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          13 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
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
      when (val choice = value.`value`) {
        is Device.Property.Value.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
        is Device.Property.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is Device.Property.Value.String -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is Device.Property.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is Device.Property.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is Device.Property.Value.Range -> {
          encodeSerializableElement(descriptor, 12, RangeSerializer, choice.value)
        }
        is Device.Property.Value.Attachment -> {
          encodeSerializableElement(descriptor, 13, AttachmentSerializer, choice.value)
        }
      }
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
    b.optionalElement("displayName", KotlinString.serializer().descriptor)
    b.optionalElement("_displayName", ElementSerializer.descriptor)
    b.optionalElement("definition", CodeableReferenceSerializer.descriptor)
    b.optionalElement("udiCarrier", DeviceUdiCarrierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("availabilityStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("biologicalSourceEvent", IdentifierSerializer.descriptor)
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
    b.optionalElement("name", DeviceNameSerializer.listSerializer.descriptor)
    b.optionalElement("modelNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_modelNumber", ElementSerializer.descriptor)
    b.optionalElement("partNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_partNumber", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("version", DeviceVersionSerializer.listSerializer.descriptor)
    b.optionalElement("conformsTo", DeviceConformsToSerializer.listSerializer.descriptor)
    b.optionalElement("property", DevicePropertySerializer.listSerializer.descriptor)
    b.optionalElement("mode", CodeableConceptSerializer.descriptor)
    b.optionalElement("cycle", CountSerializer.descriptor)
    b.optionalElement("duration", DurationSerializer.descriptor)
    b.optionalElement("owner", ReferenceSerializer.descriptor)
    b.optionalElement("contact", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("endpoint", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("gateway", CodeableReferenceSerializer.listSerializer.descriptor)
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
        11 -> displayName = decoder.decodeStringElement(descriptor, i)
        12 ->
          _displayName =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          definition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        14 ->
          udiCarrier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceUdiCarrierSerializer.listSerializer,
              null,
            )
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          availabilityStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          biologicalSourceEvent =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        19 -> manufacturer = decoder.decodeStringElement(descriptor, i)
        20 ->
          _manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> manufactureDate = decoder.decodeStringElement(descriptor, i)
        22 ->
          _manufactureDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        24 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> lotNumber = decoder.decodeStringElement(descriptor, i)
        26 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> serialNumber = decoder.decodeStringElement(descriptor, i)
        28 ->
          _serialNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceNameSerializer.listSerializer,
              null,
            )
        30 -> modelNumber = decoder.decodeStringElement(descriptor, i)
        31 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 -> partNumber = decoder.decodeStringElement(descriptor, i)
        33 ->
          _partNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        36 ->
          version =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceVersionSerializer.listSerializer,
              null,
            )
        37 ->
          conformsTo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceConformsToSerializer.listSerializer,
              null,
            )
        38 ->
          `property` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DevicePropertySerializer.listSerializer,
              null,
            )
        39 ->
          mode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        40 ->
          cycle = decoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        41 ->
          duration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        42 ->
          owner =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        43 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        44 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        45 -> url = decoder.decodeStringElement(descriptor, i)
        46 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 ->
          endpoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        48 ->
          gateway =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        49 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        50 ->
          safety =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        51 ->
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
      displayName = R5String.of(displayName, _displayName),
      definition = definition,
      udiCarrier = udiCarrier ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) Device.FHIRDeviceStatus.fromCode(status) else null,
          _status,
        ),
      availabilityStatus = availabilityStatus,
      biologicalSourceEvent = biologicalSourceEvent,
      manufacturer = R5String.of(manufacturer, _manufacturer),
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.displayName?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.displayName)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableReferenceSerializer,
      value.definition,
    )
    if (value.udiCarrier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        DeviceUdiCarrierSerializer.listSerializer,
        value.udiCarrier,
      )
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.availabilityStatus,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      IdentifierSerializer,
      value.biologicalSourceEvent,
    )
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.manufacturer?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.manufacturer)
    encoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.manufactureDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.manufactureDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.expirationDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.expirationDate)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.lotNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.lotNumber)
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.serialNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.serialNumber)
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        DeviceNameSerializer.listSerializer,
        value.name,
      )
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.modelNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.modelNumber)
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.partNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.partNumber)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        DeviceVersionSerializer.listSerializer,
        value.version,
      )
    if (value.conformsTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        DeviceConformsToSerializer.listSerializer,
        value.conformsTo,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        DevicePropertySerializer.listSerializer,
        value.`property`,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      CodeableConceptSerializer,
      value.mode,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      CountSerializer,
      value.cycle,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      41 + descriptorOffset,
      DurationSerializer,
      value.duration,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    encoder.encodeStringIfNotNull(descriptor, 45 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.url)
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.endpoint,
      )
    if (value.gateway.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.gateway,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.safety,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      ReferenceSerializer,
      value.parent,
    )
  }
}
