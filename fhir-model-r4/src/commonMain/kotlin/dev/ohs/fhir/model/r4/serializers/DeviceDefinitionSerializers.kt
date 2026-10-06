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
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.ProdCharacteristic
import dev.ohs.fhir.model.r4.ProductShelfLife
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object DeviceDefinitionUdiDeviceIdentifierSerializer :
  KSerializer<DeviceDefinition.UdiDeviceIdentifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("UdiDeviceIdentifier") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("deviceIdentifier", KotlinString.serializer().descriptor)
      optionalElement("_deviceIdentifier", ElementSerializer.descriptor)
      optionalElement("issuer", KotlinString.serializer().descriptor)
      optionalElement("_issuer", ElementSerializer.descriptor)
      optionalElement("jurisdiction", KotlinString.serializer().descriptor)
      optionalElement("_jurisdiction", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.UdiDeviceIdentifier>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.UdiDeviceIdentifier =
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
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding UdiDeviceIdentifier: " + i)
        }
      }
      DeviceDefinition.UdiDeviceIdentifier(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        deviceIdentifier =
          R4String.of(deviceIdentifier, _deviceIdentifier)
            ?: throw SerializationException(
              "Missing required property 'deviceIdentifier' on DeviceDefinition.UdiDeviceIdentifier"
            ),
        issuer =
          Uri.of(issuer, _issuer)
            ?: throw SerializationException(
              "Missing required property 'issuer' on DeviceDefinition.UdiDeviceIdentifier"
            ),
        jurisdiction =
          Uri.of(jurisdiction, _jurisdiction)
            ?: throw SerializationException(
              "Missing required property 'jurisdiction' on DeviceDefinition.UdiDeviceIdentifier"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.UdiDeviceIdentifier) {
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
      encodeStringIfNotNull(descriptor, 7, value.jurisdiction.value)
      encodeElementIfNotNull(descriptor, 8, value.jurisdiction)
    }
  }
}

internal object DeviceDefinitionDeviceNameSerializer : KSerializer<DeviceDefinition.DeviceName> {
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

  internal val listSerializer: KSerializer<List<DeviceDefinition.DeviceName>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.DeviceName =
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
      DeviceDefinition.DeviceName(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R4String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on DeviceDefinition.DeviceName"
            ),
        type =
          Enumeration.of(
            if (type != null) DeviceDefinition.DeviceNameType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on DeviceDefinition.DeviceName"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.DeviceName) {
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

internal object DeviceDefinitionSpecializationSerializer :
  KSerializer<DeviceDefinition.Specialization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Specialization") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("systemType", KotlinString.serializer().descriptor)
      optionalElement("_systemType", ElementSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.Specialization>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Specialization =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var systemType: KotlinString? = null
      var _systemType: Element? = null
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
          3 -> systemType = decodeStringElement(descriptor, i)
          4 ->
            _systemType = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> version = decodeStringElement(descriptor, i)
          6 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Specialization: " + i)
        }
      }
      DeviceDefinition.Specialization(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        systemType =
          R4String.of(systemType, _systemType)
            ?: throw SerializationException(
              "Missing required property 'systemType' on DeviceDefinition.Specialization"
            ),
        version = R4String.of(version, _version),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Specialization) {
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
      encodeStringIfNotNull(descriptor, 3, value.systemType.value)
      encodeElementIfNotNull(descriptor, 4, value.systemType)
      encodeStringIfNotNull(descriptor, 5, value.version?.value)
      encodeElementIfNotNull(descriptor, 6, value.version)
    }
  }
}

internal object DeviceDefinitionCapabilitySerializer : KSerializer<DeviceDefinition.Capability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Capability") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("description", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.Capability>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Capability =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var description: List<CodeableConcept>? = null
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
            description =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Capability: " + i)
        }
      }
      DeviceDefinition.Capability(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on DeviceDefinition.Capability"
            ),
        description = description ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Capability) {
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
      if (value.description.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.description,
        )
    }
  }
}

internal object DeviceDefinitionPropertySerializer : KSerializer<DeviceDefinition.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.listSerializer.descriptor)
      optionalElement("valueCode", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.Property>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Property =
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
      DeviceDefinition.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on DeviceDefinition.Property"
            ),
        valueQuantity = valueQuantity ?: listOf(),
        valueCode = valueCode ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Property) {
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

internal object DeviceDefinitionMaterialSerializer : KSerializer<DeviceDefinition.Material> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Material") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("substance", CodeableConceptSerializer.descriptor)
      optionalElement("alternate", KotlinBoolean.serializer().descriptor)
      optionalElement("_alternate", ElementSerializer.descriptor)
      optionalElement("allergenicIndicator", KotlinBoolean.serializer().descriptor)
      optionalElement("_allergenicIndicator", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.Material>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Material =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var substance: CodeableConcept? = null
      var alternate: KotlinBoolean? = null
      var _alternate: Element? = null
      var allergenicIndicator: KotlinBoolean? = null
      var _allergenicIndicator: Element? = null
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
            substance =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> alternate = decodeBooleanElement(descriptor, i)
          5 ->
            _alternate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> allergenicIndicator = decodeBooleanElement(descriptor, i)
          7 ->
            _allergenicIndicator =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Material: " + i)
        }
      }
      DeviceDefinition.Material(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        substance =
          substance
            ?: throw SerializationException(
              "Missing required property 'substance' on DeviceDefinition.Material"
            ),
        alternate = R4Boolean.of(alternate, _alternate),
        allergenicIndicator = R4Boolean.of(allergenicIndicator, _allergenicIndicator),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Material) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.substance)
      encodeBooleanIfNotNull(descriptor, 4, value.alternate?.value)
      encodeElementIfNotNull(descriptor, 5, value.alternate)
      encodeBooleanIfNotNull(descriptor, 6, value.allergenicIndicator?.value)
      encodeElementIfNotNull(descriptor, 7, value.allergenicIndicator)
    }
  }
}

internal object DeviceDefinitionSerializer : FhirResourceSerializer<DeviceDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("DeviceDefinition")

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
    b.optionalElement(
      "udiDeviceIdentifier",
      DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer.descriptor,
    )
    b.optionalElement("manufacturerString", KotlinString.serializer().descriptor)
    b.optionalElement("_manufacturerString", ElementSerializer.descriptor)
    b.optionalElement("manufacturerReference", ReferenceSerializer.descriptor)
    b.optionalElement("deviceName", DeviceDefinitionDeviceNameSerializer.listSerializer.descriptor)
    b.optionalElement("modelNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_modelNumber", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "specialization",
      DeviceDefinitionSpecializationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("version", stringNullableListSerializer.descriptor)
    b.optionalElement("_version", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("safety", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("shelfLifeStorage", ProductShelfLifeSerializer.listSerializer.descriptor)
    b.optionalElement("physicalCharacteristics", ProdCharacteristicSerializer.descriptor)
    b.optionalElement("languageCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("capability", DeviceDefinitionCapabilitySerializer.listSerializer.descriptor)
    b.optionalElement("property", DeviceDefinitionPropertySerializer.listSerializer.descriptor)
    b.optionalElement("owner", ReferenceSerializer.descriptor)
    b.optionalElement("contact", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("onlineInformation", KotlinString.serializer().descriptor)
    b.optionalElement("_onlineInformation", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("parentDevice", ReferenceSerializer.descriptor)
    b.optionalElement("material", DeviceDefinitionMaterialSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): DeviceDefinition {
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
          udiDeviceIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
              null,
            )
        12 -> manufacturerString = decoder.decodeStringElement(descriptor, i)
        13 ->
          _manufacturerString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          manufacturerReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        15 ->
          deviceName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionDeviceNameSerializer.listSerializer,
              null,
            )
        16 -> modelNumber = decoder.decodeStringElement(descriptor, i)
        17 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          specialization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionSpecializationSerializer.listSerializer,
              null,
            )
        20 ->
          version =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        21 ->
          _version =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        22 ->
          safety =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        23 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ProductShelfLifeSerializer.listSerializer,
              null,
            )
        24 ->
          physicalCharacteristics =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ProdCharacteristicSerializer,
              null,
            )
        25 ->
          languageCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        26 ->
          capability =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionCapabilitySerializer.listSerializer,
              null,
            )
        27 ->
          `property` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionPropertySerializer.listSerializer,
              null,
            )
        28 ->
          owner =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        30 -> url = decoder.decodeStringElement(descriptor, i)
        31 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 -> onlineInformation = decoder.decodeStringElement(descriptor, i)
        33 ->
          _onlineInformation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        35 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        36 ->
          parentDevice =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        37 ->
          material =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionMaterialSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding DeviceDefinition: " + i)
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
        (kotlin.collections.List(maxOf(version?.size ?: 0, _version?.size ?: 0)) { index ->
          R4String.of(version?.getOrNull(index), _version?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'version' on DeviceDefinition has neither a value nor an id/extension"
            )
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DeviceDefinition,
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
    if (value.udiDeviceIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
        value.udiDeviceIdentifier,
      )
    when (val choice = value.manufacturer) {
      null -> {}
      is DeviceDefinition.Manufacturer.String -> {
        encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, choice.value)
      }
      is DeviceDefinition.Manufacturer.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          14 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    if (value.deviceName.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        DeviceDefinitionDeviceNameSerializer.listSerializer,
        value.deviceName,
      )
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.modelNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.modelNumber)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.specialization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        DeviceDefinitionSpecializationSerializer.listSerializer,
        value.specialization,
      )
    if (value.version.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        20 + descriptorOffset,
        stringNullableListSerializer,
        value.version.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 21 + descriptorOffset, value.version)
    }
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.safety,
      )
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ProductShelfLifeSerializer.listSerializer,
        value.shelfLifeStorage,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ProdCharacteristicSerializer,
      value.physicalCharacteristics,
    )
    if (value.languageCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.languageCode,
      )
    if (value.capability.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        DeviceDefinitionCapabilitySerializer.listSerializer,
        value.capability,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        DeviceDefinitionPropertySerializer.listSerializer,
        value.`property`,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.url)
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.onlineInformation?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.onlineInformation)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      36 + descriptorOffset,
      ReferenceSerializer,
      value.parentDevice,
    )
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        DeviceDefinitionMaterialSerializer.listSerializer,
        value.material,
      )
  }
}
