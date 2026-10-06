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
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.ProductShelfLife
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
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
      optionalElement(
        "marketDistribution",
        DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer.listSerializer.descriptor,
      )
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
      var marketDistribution: List<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution>? = null
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
          9 ->
            marketDistribution =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer.listSerializer,
                null,
              )
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
          R5String.of(deviceIdentifier, _deviceIdentifier)
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
        marketDistribution = marketDistribution ?: listOf(),
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
      if (value.marketDistribution.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer.listSerializer,
          value.marketDistribution,
        )
    }
  }
}

internal object DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer :
  KSerializer<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MarketDistribution") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("marketPeriod", PeriodSerializer.descriptor)
      optionalElement("subJurisdiction", KotlinString.serializer().descriptor)
      optionalElement("_subJurisdiction", ElementSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): DeviceDefinition.UdiDeviceIdentifier.MarketDistribution =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var marketPeriod: Period? = null
      var subJurisdiction: KotlinString? = null
      var _subJurisdiction: Element? = null
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
            marketPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          4 -> subJurisdiction = decodeStringElement(descriptor, i)
          5 ->
            _subJurisdiction =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding MarketDistribution: " + i)
        }
      }
      DeviceDefinition.UdiDeviceIdentifier.MarketDistribution(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        marketPeriod =
          marketPeriod
            ?: throw SerializationException(
              "Missing required property 'marketPeriod' on DeviceDefinition.UdiDeviceIdentifier.MarketDistribution"
            ),
        subJurisdiction =
          Uri.of(subJurisdiction, _subJurisdiction)
            ?: throw SerializationException(
              "Missing required property 'subJurisdiction' on DeviceDefinition.UdiDeviceIdentifier.MarketDistribution"
            ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: DeviceDefinition.UdiDeviceIdentifier.MarketDistribution,
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
      encodeSerializableElement(descriptor, 3, PeriodSerializer, value.marketPeriod)
      encodeStringIfNotNull(descriptor, 4, value.subJurisdiction.value)
      encodeElementIfNotNull(descriptor, 5, value.subJurisdiction)
    }
  }
}

internal object DeviceDefinitionRegulatoryIdentifierSerializer :
  KSerializer<DeviceDefinition.RegulatoryIdentifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RegulatoryIdentifier") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("deviceIdentifier", KotlinString.serializer().descriptor)
      optionalElement("_deviceIdentifier", ElementSerializer.descriptor)
      optionalElement("issuer", KotlinString.serializer().descriptor)
      optionalElement("_issuer", ElementSerializer.descriptor)
      optionalElement("jurisdiction", KotlinString.serializer().descriptor)
      optionalElement("_jurisdiction", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.RegulatoryIdentifier>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.RegulatoryIdentifier =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> deviceIdentifier = decodeStringElement(descriptor, i)
          6 ->
            _deviceIdentifier =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> issuer = decodeStringElement(descriptor, i)
          8 -> _issuer = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> jurisdiction = decodeStringElement(descriptor, i)
          10 ->
            _jurisdiction =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding RegulatoryIdentifier: " + i)
        }
      }
      DeviceDefinition.RegulatoryIdentifier(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null)
              DeviceDefinition.DeviceDefinitionRegulatoryIdentifierType.fromCode(type)
            else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on DeviceDefinition.RegulatoryIdentifier"
            ),
        deviceIdentifier =
          R5String.of(deviceIdentifier, _deviceIdentifier)
            ?: throw SerializationException(
              "Missing required property 'deviceIdentifier' on DeviceDefinition.RegulatoryIdentifier"
            ),
        issuer =
          Uri.of(issuer, _issuer)
            ?: throw SerializationException(
              "Missing required property 'issuer' on DeviceDefinition.RegulatoryIdentifier"
            ),
        jurisdiction =
          Uri.of(jurisdiction, _jurisdiction)
            ?: throw SerializationException(
              "Missing required property 'jurisdiction' on DeviceDefinition.RegulatoryIdentifier"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.RegulatoryIdentifier) {
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
      encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeStringIfNotNull(descriptor, 5, value.deviceIdentifier.value)
      encodeElementIfNotNull(descriptor, 6, value.deviceIdentifier)
      encodeStringIfNotNull(descriptor, 7, value.issuer.value)
      encodeElementIfNotNull(descriptor, 8, value.issuer)
      encodeStringIfNotNull(descriptor, 9, value.jurisdiction.value)
      encodeElementIfNotNull(descriptor, 10, value.jurisdiction)
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
          R5String.of(name, _name)
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

internal object DeviceDefinitionClassificationSerializer :
  KSerializer<DeviceDefinition.Classification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Classification") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("justification", RelatedArtifactSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.Classification>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Classification =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var justification: List<RelatedArtifact>? = null
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
            justification =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RelatedArtifactSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Classification: " + i)
        }
      }
      DeviceDefinition.Classification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on DeviceDefinition.Classification"
            ),
        justification = justification ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Classification) {
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
      if (value.justification.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          RelatedArtifactSerializer.listSerializer,
          value.justification,
        )
    }
  }
}

internal object DeviceDefinitionConformsToSerializer : KSerializer<DeviceDefinition.ConformsTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConformsTo") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("specification", CodeableConceptSerializer.descriptor)
      optionalElement("version", stringNullableListSerializer.descriptor)
      optionalElement("_version", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("source", RelatedArtifactSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.ConformsTo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.ConformsTo =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var specification: CodeableConcept? = null
      var version: List<KotlinString?>? = null
      var _version: List<Element?>? = null
      var source: List<RelatedArtifact>? = null
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
          5 ->
            version =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          6 ->
            _version =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          7 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RelatedArtifactSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ConformsTo: " + i)
        }
      }
      DeviceDefinition.ConformsTo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        category = category,
        specification =
          specification
            ?: throw SerializationException(
              "Missing required property 'specification' on DeviceDefinition.ConformsTo"
            ),
        version =
          (kotlin.collections.List(maxOf(version?.size ?: 0, _version?.size ?: 0)) { index ->
            R5String.of(version?.getOrNull(index), _version?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'version' on DeviceDefinition.ConformsTo has neither a value nor an id/extension"
              )
          }),
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.ConformsTo) {
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
      if (value.version.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          stringNullableListSerializer,
          value.version.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.version)
      }
      if (value.source.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          RelatedArtifactSerializer.listSerializer,
          value.source,
        )
    }
  }
}

internal object DeviceDefinitionHasPartSerializer : KSerializer<DeviceDefinition.HasPart> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("HasPart") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
      optionalElement("count", Int.serializer().descriptor)
      optionalElement("_count", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.HasPart>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.HasPart =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var reference: Reference? = null
      var count: Int? = null
      var _count: Element? = null
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
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> count = decodeIntElement(descriptor, i)
          5 -> _count = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding HasPart: " + i)
        }
      }
      DeviceDefinition.HasPart(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        reference =
          reference
            ?: throw SerializationException(
              "Missing required property 'reference' on DeviceDefinition.HasPart"
            ),
        count = Integer.of(count, _count),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.HasPart) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.reference)
      encodeIntIfNotNull(descriptor, 4, value.count?.value)
      encodeElementIfNotNull(descriptor, 5, value.count)
    }
  }
}

internal object DeviceDefinitionPackagingSerializer : KSerializer<DeviceDefinition.Packaging> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Packaging") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("count", Int.serializer().descriptor)
      optionalElement("_count", ElementSerializer.descriptor)
      optionalElement(
        "distributor",
        DeviceDefinitionPackagingDistributorSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "udiDeviceIdentifier",
        listSerialDescriptor(
          lazyDescriptor { DeviceDefinitionUdiDeviceIdentifierSerializer.descriptor }
        ),
      )
      optionalElement(
        "packaging",
        listSerialDescriptor(lazyDescriptor { DeviceDefinitionPackagingSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.Packaging>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Packaging =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: Identifier? = null
      var type: CodeableConcept? = null
      var count: Int? = null
      var _count: Element? = null
      var distributor: List<DeviceDefinition.Packaging.Distributor>? = null
      var udiDeviceIdentifier: List<DeviceDefinition.UdiDeviceIdentifier>? = null
      var packaging: List<DeviceDefinition.Packaging>? = null
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
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> count = decodeIntElement(descriptor, i)
          6 -> _count = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            distributor =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DeviceDefinitionPackagingDistributorSerializer.listSerializer,
                null,
              )
          8 ->
            udiDeviceIdentifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
                null,
              )
          9 ->
            packaging =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DeviceDefinitionPackagingSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Packaging: " + i)
        }
      }
      DeviceDefinition.Packaging(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier,
        type = type,
        count = Integer.of(count, _count),
        distributor = distributor ?: listOf(),
        udiDeviceIdentifier = udiDeviceIdentifier ?: listOf(),
        packaging = packaging ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Packaging) {
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
      encodeSerializableIfNotNull(descriptor, 3, IdentifierSerializer, value.identifier)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeIntIfNotNull(descriptor, 5, value.count?.value)
      encodeElementIfNotNull(descriptor, 6, value.count)
      if (value.distributor.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          DeviceDefinitionPackagingDistributorSerializer.listSerializer,
          value.distributor,
        )
      if (value.udiDeviceIdentifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
          value.udiDeviceIdentifier,
        )
      if (value.packaging.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          DeviceDefinitionPackagingSerializer.listSerializer,
          value.packaging,
        )
    }
  }
}

internal object DeviceDefinitionPackagingDistributorSerializer :
  KSerializer<DeviceDefinition.Packaging.Distributor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Distributor") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("organizationReference", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.Packaging.Distributor>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Packaging.Distributor =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var organizationReference: List<Reference>? = null
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
          5 ->
            organizationReference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Distributor: " + i)
        }
      }
      DeviceDefinition.Packaging.Distributor(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name = R5String.of(name, _name),
        organizationReference = organizationReference ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Packaging.Distributor) {
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
      encodeStringIfNotNull(descriptor, 3, value.name?.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      if (value.organizationReference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          ReferenceSerializer.listSerializer,
          value.organizationReference,
        )
    }
  }
}

internal object DeviceDefinitionVersionSerializer : KSerializer<DeviceDefinition.Version> {
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

  internal val listSerializer: KSerializer<List<DeviceDefinition.Version>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Version =
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
      DeviceDefinition.Version(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        component = component,
        `value` =
          R5String.of(`value`, _value)
            ?: throw SerializationException(
              "Missing required property 'value' on DeviceDefinition.Version"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Version) {
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

internal object DeviceDefinitionPropertySerializer : KSerializer<DeviceDefinition.Property> {
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

  internal val listSerializer: KSerializer<List<DeviceDefinition.Property>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Property =
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
      DeviceDefinition.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on DeviceDefinition.Property"
            ),
        `value` =
          DeviceDefinition.Property.Value.from(
            valueQuantity,
            valueCodeableConcept,
            R5String.of(valueString, _valueString),
            R5Boolean.of(valueBoolean, _valueBoolean),
            Integer.of(valueInteger, _valueInteger),
            valueRange,
            valueAttachment,
          )
            ?: throw SerializationException(
              "Missing required property 'value' on DeviceDefinition.Property"
            ),
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
      when (val choice = value.`value`) {
        is DeviceDefinition.Property.Value.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
        is DeviceDefinition.Property.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is DeviceDefinition.Property.Value.String -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is DeviceDefinition.Property.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is DeviceDefinition.Property.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is DeviceDefinition.Property.Value.Range -> {
          encodeSerializableElement(descriptor, 12, RangeSerializer, choice.value)
        }
        is DeviceDefinition.Property.Value.Attachment -> {
          encodeSerializableElement(descriptor, 13, AttachmentSerializer, choice.value)
        }
      }
    }
  }
}

internal object DeviceDefinitionLinkSerializer : KSerializer<DeviceDefinition.Link> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Link") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("relation", CodingSerializer.descriptor)
      optionalElement("relatedDevice", CodeableReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.Link>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Link =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var relation: Coding? = null
      var relatedDevice: CodeableReference? = null
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
          3 -> relation = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 ->
            relatedDevice =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Link: " + i)
        }
      }
      DeviceDefinition.Link(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        relation =
          relation
            ?: throw SerializationException(
              "Missing required property 'relation' on DeviceDefinition.Link"
            ),
        relatedDevice =
          relatedDevice
            ?: throw SerializationException(
              "Missing required property 'relatedDevice' on DeviceDefinition.Link"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Link) {
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
      encodeSerializableElement(descriptor, 3, CodingSerializer, value.relation)
      encodeSerializableElement(descriptor, 4, CodeableReferenceSerializer, value.relatedDevice)
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
        alternate = R5Boolean.of(alternate, _alternate),
        allergenicIndicator = R5Boolean.of(allergenicIndicator, _allergenicIndicator),
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

internal object DeviceDefinitionGuidelineSerializer : KSerializer<DeviceDefinition.Guideline> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Guideline") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
      optionalElement("usageInstruction", KotlinString.serializer().descriptor)
      optionalElement("_usageInstruction", ElementSerializer.descriptor)
      optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
      optionalElement("indication", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("contraindication", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("warning", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("intendedUse", KotlinString.serializer().descriptor)
      optionalElement("_intendedUse", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.Guideline>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.Guideline =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var useContext: List<UsageContext>? = null
      var usageInstruction: KotlinString? = null
      var _usageInstruction: Element? = null
      var relatedArtifact: List<RelatedArtifact>? = null
      var indication: List<CodeableConcept>? = null
      var contraindication: List<CodeableConcept>? = null
      var warning: List<CodeableConcept>? = null
      var intendedUse: KotlinString? = null
      var _intendedUse: Element? = null
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
            useContext =
              decodeNullableSerializableElement(
                descriptor,
                i,
                UsageContextSerializer.listSerializer,
                null,
              )
          4 -> usageInstruction = decodeStringElement(descriptor, i)
          5 ->
            _usageInstruction =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            relatedArtifact =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RelatedArtifactSerializer.listSerializer,
                null,
              )
          7 ->
            indication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 ->
            contraindication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          9 ->
            warning =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          10 -> intendedUse = decodeStringElement(descriptor, i)
          11 ->
            _intendedUse = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Guideline: " + i)
        }
      }
      DeviceDefinition.Guideline(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        useContext = useContext ?: listOf(),
        usageInstruction = Markdown.of(usageInstruction, _usageInstruction),
        relatedArtifact = relatedArtifact ?: listOf(),
        indication = indication ?: listOf(),
        contraindication = contraindication ?: listOf(),
        warning = warning ?: listOf(),
        intendedUse = R5String.of(intendedUse, _intendedUse),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Guideline) {
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
      if (value.useContext.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          UsageContextSerializer.listSerializer,
          value.useContext,
        )
      encodeStringIfNotNull(descriptor, 4, value.usageInstruction?.value)
      encodeElementIfNotNull(descriptor, 5, value.usageInstruction)
      if (value.relatedArtifact.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          RelatedArtifactSerializer.listSerializer,
          value.relatedArtifact,
        )
      if (value.indication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.indication,
        )
      if (value.contraindication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer.listSerializer,
          value.contraindication,
        )
      if (value.warning.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CodeableConceptSerializer.listSerializer,
          value.warning,
        )
      encodeStringIfNotNull(descriptor, 10, value.intendedUse?.value)
      encodeElementIfNotNull(descriptor, 11, value.intendedUse)
    }
  }
}

internal object DeviceDefinitionCorrectiveActionSerializer :
  KSerializer<DeviceDefinition.CorrectiveAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CorrectiveAction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("recall", KotlinBoolean.serializer().descriptor)
      optionalElement("_recall", ElementSerializer.descriptor)
      optionalElement("scope", KotlinString.serializer().descriptor)
      optionalElement("_scope", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.CorrectiveAction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.CorrectiveAction =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var recall: KotlinBoolean? = null
      var _recall: Element? = null
      var scope: KotlinString? = null
      var _scope: Element? = null
      var period: Period? = null
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
          3 -> recall = decodeBooleanElement(descriptor, i)
          4 -> _recall = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> scope = decodeStringElement(descriptor, i)
          6 -> _scope = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding CorrectiveAction: " + i)
        }
      }
      DeviceDefinition.CorrectiveAction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        recall =
          R5Boolean.of(recall, _recall)
            ?: throw SerializationException(
              "Missing required property 'recall' on DeviceDefinition.CorrectiveAction"
            ),
        scope =
          Enumeration.of(
            if (scope != null) DeviceDefinition.DeviceCorrectiveActionScope.fromCode(scope)
            else null,
            _scope,
          ),
        period =
          period
            ?: throw SerializationException(
              "Missing required property 'period' on DeviceDefinition.CorrectiveAction"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.CorrectiveAction) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.recall.value)
      encodeElementIfNotNull(descriptor, 4, value.recall)
      encodeStringIfNotNull(descriptor, 5, value.scope?.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.scope)
      encodeSerializableElement(descriptor, 7, PeriodSerializer, value.period)
    }
  }
}

internal object DeviceDefinitionChargeItemSerializer : KSerializer<DeviceDefinition.ChargeItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItem") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("chargeItemCode", CodeableReferenceSerializer.descriptor)
      optionalElement("count", QuantitySerializer.descriptor)
      optionalElement("effectivePeriod", PeriodSerializer.descriptor)
      optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceDefinition.ChargeItem>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceDefinition.ChargeItem =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var chargeItemCode: CodeableReference? = null
      var count: Quantity? = null
      var effectivePeriod: Period? = null
      var useContext: List<UsageContext>? = null
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
            chargeItemCode =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 -> count = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            effectivePeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          6 ->
            useContext =
              decodeNullableSerializableElement(
                descriptor,
                i,
                UsageContextSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ChargeItem: " + i)
        }
      }
      DeviceDefinition.ChargeItem(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        chargeItemCode =
          chargeItemCode
            ?: throw SerializationException(
              "Missing required property 'chargeItemCode' on DeviceDefinition.ChargeItem"
            ),
        count =
          count
            ?: throw SerializationException(
              "Missing required property 'count' on DeviceDefinition.ChargeItem"
            ),
        effectivePeriod = effectivePeriod,
        useContext = useContext ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.ChargeItem) {
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
      encodeSerializableElement(descriptor, 3, CodeableReferenceSerializer, value.chargeItemCode)
      encodeSerializableElement(descriptor, 4, QuantitySerializer, value.count)
      encodeSerializableIfNotNull(descriptor, 5, PeriodSerializer, value.effectivePeriod)
      if (value.useContext.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          UsageContextSerializer.listSerializer,
          value.useContext,
        )
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
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement(
      "udiDeviceIdentifier",
      DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "regulatoryIdentifier",
      DeviceDefinitionRegulatoryIdentifierSerializer.listSerializer.descriptor,
    )
    b.optionalElement("partNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_partNumber", ElementSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.descriptor)
    b.optionalElement("deviceName", DeviceDefinitionDeviceNameSerializer.listSerializer.descriptor)
    b.optionalElement("modelNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_modelNumber", ElementSerializer.descriptor)
    b.optionalElement(
      "classification",
      DeviceDefinitionClassificationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("conformsTo", DeviceDefinitionConformsToSerializer.listSerializer.descriptor)
    b.optionalElement("hasPart", DeviceDefinitionHasPartSerializer.listSerializer.descriptor)
    b.optionalElement("packaging", DeviceDefinitionPackagingSerializer.listSerializer.descriptor)
    b.optionalElement("version", DeviceDefinitionVersionSerializer.listSerializer.descriptor)
    b.optionalElement("safety", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("shelfLifeStorage", ProductShelfLifeSerializer.listSerializer.descriptor)
    b.optionalElement("languageCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("property", DeviceDefinitionPropertySerializer.listSerializer.descriptor)
    b.optionalElement("owner", ReferenceSerializer.descriptor)
    b.optionalElement("contact", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("link", DeviceDefinitionLinkSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("material", DeviceDefinitionMaterialSerializer.listSerializer.descriptor)
    b.optionalElement("productionIdentifierInUDI", stringNullableListSerializer.descriptor)
    b.optionalElement(
      "_productionIdentifierInUDI",
      ElementSerializer.nullableListSerializer.descriptor,
    )
    b.optionalElement("guideline", DeviceDefinitionGuidelineSerializer.descriptor)
    b.optionalElement("correctiveAction", DeviceDefinitionCorrectiveActionSerializer.descriptor)
    b.optionalElement("chargeItem", DeviceDefinitionChargeItemSerializer.listSerializer.descriptor)
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
    var description: KotlinString? = null
    var _description: Element? = null
    var identifier: List<Identifier>? = null
    var udiDeviceIdentifier: List<DeviceDefinition.UdiDeviceIdentifier>? = null
    var regulatoryIdentifier: List<DeviceDefinition.RegulatoryIdentifier>? = null
    var partNumber: KotlinString? = null
    var _partNumber: Element? = null
    var manufacturer: Reference? = null
    var deviceName: List<DeviceDefinition.DeviceName>? = null
    var modelNumber: KotlinString? = null
    var _modelNumber: Element? = null
    var classification: List<DeviceDefinition.Classification>? = null
    var conformsTo: List<DeviceDefinition.ConformsTo>? = null
    var hasPart: List<DeviceDefinition.HasPart>? = null
    var packaging: List<DeviceDefinition.Packaging>? = null
    var version: List<DeviceDefinition.Version>? = null
    var safety: List<CodeableConcept>? = null
    var shelfLifeStorage: List<ProductShelfLife>? = null
    var languageCode: List<CodeableConcept>? = null
    var `property`: List<DeviceDefinition.Property>? = null
    var owner: Reference? = null
    var contact: List<ContactPoint>? = null
    var link: List<DeviceDefinition.Link>? = null
    var note: List<Annotation>? = null
    var material: List<DeviceDefinition.Material>? = null
    var productionIdentifierInUDI: List<KotlinString?>? = null
    var _productionIdentifierInUDI: List<Element?>? = null
    var guideline: DeviceDefinition.Guideline? = null
    var correctiveAction: DeviceDefinition.CorrectiveAction? = null
    var chargeItem: List<DeviceDefinition.ChargeItem>? = null
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
        10 -> description = decoder.decodeStringElement(descriptor, i)
        11 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 ->
          udiDeviceIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
              null,
            )
        14 ->
          regulatoryIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionRegulatoryIdentifierSerializer.listSerializer,
              null,
            )
        15 -> partNumber = decoder.decodeStringElement(descriptor, i)
        16 ->
          _partNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          deviceName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionDeviceNameSerializer.listSerializer,
              null,
            )
        19 -> modelNumber = decoder.decodeStringElement(descriptor, i)
        20 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionClassificationSerializer.listSerializer,
              null,
            )
        22 ->
          conformsTo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionConformsToSerializer.listSerializer,
              null,
            )
        23 ->
          hasPart =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionHasPartSerializer.listSerializer,
              null,
            )
        24 ->
          packaging =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionPackagingSerializer.listSerializer,
              null,
            )
        25 ->
          version =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionVersionSerializer.listSerializer,
              null,
            )
        26 ->
          safety =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        27 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ProductShelfLifeSerializer.listSerializer,
              null,
            )
        28 ->
          languageCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        29 ->
          `property` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionPropertySerializer.listSerializer,
              null,
            )
        30 ->
          owner =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        31 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        32 ->
          link =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionLinkSerializer.listSerializer,
              null,
            )
        33 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        34 ->
          material =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionMaterialSerializer.listSerializer,
              null,
            )
        35 ->
          productionIdentifierInUDI =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        36 ->
          _productionIdentifierInUDI =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        37 ->
          guideline =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionGuidelineSerializer,
              null,
            )
        38 ->
          correctiveAction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionCorrectiveActionSerializer,
              null,
            )
        39 ->
          chargeItem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionChargeItemSerializer.listSerializer,
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
      description = Markdown.of(description, _description),
      identifier = identifier ?: listOf(),
      udiDeviceIdentifier = udiDeviceIdentifier ?: listOf(),
      regulatoryIdentifier = regulatoryIdentifier ?: listOf(),
      partNumber = R5String.of(partNumber, _partNumber),
      manufacturer = manufacturer,
      deviceName = deviceName ?: listOf(),
      modelNumber = R5String.of(modelNumber, _modelNumber),
      classification = classification ?: listOf(),
      conformsTo = conformsTo ?: listOf(),
      hasPart = hasPart ?: listOf(),
      packaging = packaging ?: listOf(),
      version = version ?: listOf(),
      safety = safety ?: listOf(),
      shelfLifeStorage = shelfLifeStorage ?: listOf(),
      languageCode = languageCode ?: listOf(),
      `property` = `property` ?: listOf(),
      owner = owner,
      contact = contact ?: listOf(),
      link = link ?: listOf(),
      note = note ?: listOf(),
      material = material ?: listOf(),
      productionIdentifierInUDI =
        (kotlin.collections.List(
          maxOf(productionIdentifierInUDI?.size ?: 0, _productionIdentifierInUDI?.size ?: 0)
        ) { index ->
          Enumeration.of(
            productionIdentifierInUDI?.getOrNull(index)?.let {
              DeviceDefinition.DeviceProductionIdentifierInUDI.fromCode(it)
            },
            _productionIdentifierInUDI?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'productionIdentifierInUDI' on DeviceDefinition has neither a value nor an id/extension"
            )
        }),
      guideline = guideline,
      correctiveAction = correctiveAction,
      chargeItem = chargeItem ?: listOf(),
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.description)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.udiDeviceIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
        value.udiDeviceIdentifier,
      )
    if (value.regulatoryIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        DeviceDefinitionRegulatoryIdentifierSerializer.listSerializer,
        value.regulatoryIdentifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.partNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.partNumber)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.manufacturer,
    )
    if (value.deviceName.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        DeviceDefinitionDeviceNameSerializer.listSerializer,
        value.deviceName,
      )
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.modelNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.modelNumber)
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        DeviceDefinitionClassificationSerializer.listSerializer,
        value.classification,
      )
    if (value.conformsTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        DeviceDefinitionConformsToSerializer.listSerializer,
        value.conformsTo,
      )
    if (value.hasPart.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        DeviceDefinitionHasPartSerializer.listSerializer,
        value.hasPart,
      )
    if (value.packaging.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        DeviceDefinitionPackagingSerializer.listSerializer,
        value.packaging,
      )
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        DeviceDefinitionVersionSerializer.listSerializer,
        value.version,
      )
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.safety,
      )
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ProductShelfLifeSerializer.listSerializer,
        value.shelfLifeStorage,
      )
    if (value.languageCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.languageCode,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        DeviceDefinitionPropertySerializer.listSerializer,
        value.`property`,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.contact,
      )
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        DeviceDefinitionLinkSerializer.listSerializer,
        value.link,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        DeviceDefinitionMaterialSerializer.listSerializer,
        value.material,
      )
    if (value.productionIdentifierInUDI.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        35 + descriptorOffset,
        stringNullableListSerializer,
        value.productionIdentifierInUDI.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        36 + descriptorOffset,
        value.productionIdentifierInUDI,
      )
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      DeviceDefinitionGuidelineSerializer,
      value.guideline,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      DeviceDefinitionCorrectiveActionSerializer,
      value.correctiveAction,
    )
    if (value.chargeItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        DeviceDefinitionChargeItemSerializer.listSerializer,
        value.chargeItem,
      )
  }
}
