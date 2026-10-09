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
import dev.ohs.fhir.model.r5.terminologies.DeviceCorrectiveActionScope
import dev.ohs.fhir.model.r5.terminologies.DeviceDefinitionRegulatoryIdentifierType
import dev.ohs.fhir.model.r5.terminologies.DeviceNameType
import dev.ohs.fhir.model.r5.terminologies.DeviceProductionIdentifierInUDI
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object DeviceDefinitionUdiDeviceIdentifierSerializer :
  FhirSerializer<DeviceDefinition.UdiDeviceIdentifier> {
  override val descriptor: SerialDescriptor = buildDescriptor("UdiDeviceIdentifier", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.UdiDeviceIdentifier>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("deviceIdentifier")
    b.strPrim("issuer")
    b.strPrim("jurisdiction")
    b.optionalElement(
      "marketDistribution",
      DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.UdiDeviceIdentifier {
    val descriptor = this.descriptor
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
    var marketDistribution: List<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution>? = null
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
        9 ->
          marketDistribution =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.UdiDeviceIdentifier(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      deviceIdentifier =
        required(
          R5String.of(deviceIdentifier, _deviceIdentifier),
          "DeviceDefinition.UdiDeviceIdentifier",
          "deviceIdentifier",
        ),
      issuer = required(Uri.of(issuer, _issuer), "DeviceDefinition.UdiDeviceIdentifier", "issuer"),
      jurisdiction =
        required(
          Uri.of(jurisdiction, _jurisdiction),
          "DeviceDefinition.UdiDeviceIdentifier",
          "jurisdiction",
        ),
      marketDistribution = listOrEmpty(marketDistribution),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.UdiDeviceIdentifier) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.deviceIdentifier.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.deviceIdentifier)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.issuer.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.issuer)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.jurisdiction.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.jurisdiction)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer.listSerializer,
      value.marketDistribution,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer :
  FhirSerializer<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution> {
  override val descriptor: SerialDescriptor = buildDescriptor("MarketDistribution", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("marketPeriod", PeriodSerializer.descriptor)
    b.strPrim("subJurisdiction")
  }

  override fun deserialize(
    decoder: Decoder
  ): DeviceDefinition.UdiDeviceIdentifier.MarketDistribution {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var marketPeriod: Period? = null
    var subJurisdiction: KotlinString? = null
    var _subJurisdiction: Element? = null
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
          marketPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        4 -> subJurisdiction = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _subJurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.UdiDeviceIdentifier.MarketDistribution(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      marketPeriod =
        required(
          marketPeriod,
          "DeviceDefinition.UdiDeviceIdentifier.MarketDistribution",
          "marketPeriod",
        ),
      subJurisdiction =
        required(
          Uri.of(subJurisdiction, _subJurisdiction),
          "DeviceDefinition.UdiDeviceIdentifier.MarketDistribution",
          "subJurisdiction",
        ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: DeviceDefinition.UdiDeviceIdentifier.MarketDistribution,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, PeriodSerializer, value.marketPeriod)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.subJurisdiction.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.subJurisdiction)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionRegulatoryIdentifierSerializer :
  FhirSerializer<DeviceDefinition.RegulatoryIdentifier> {
  override val descriptor: SerialDescriptor = buildDescriptor("RegulatoryIdentifier", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.RegulatoryIdentifier>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("deviceIdentifier")
    b.strPrim("issuer")
    b.strPrim("jurisdiction")
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.RegulatoryIdentifier {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: DeviceDefinitionRegulatoryIdentifierType? = null
    var _type: Element? = null
    var deviceIdentifier: KotlinString? = null
    var _deviceIdentifier: Element? = null
    var issuer: KotlinString? = null
    var _issuer: Element? = null
    var jurisdiction: KotlinString? = null
    var _jurisdiction: Element? = null
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
            DeviceDefinitionRegulatoryIdentifierType.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> deviceIdentifier = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _deviceIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> issuer = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _issuer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> jurisdiction = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.RegulatoryIdentifier(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(Enumeration.of(type, _type), "DeviceDefinition.RegulatoryIdentifier", "type"),
      deviceIdentifier =
        required(
          R5String.of(deviceIdentifier, _deviceIdentifier),
          "DeviceDefinition.RegulatoryIdentifier",
          "deviceIdentifier",
        ),
      issuer = required(Uri.of(issuer, _issuer), "DeviceDefinition.RegulatoryIdentifier", "issuer"),
      jurisdiction =
        required(
          Uri.of(jurisdiction, _jurisdiction),
          "DeviceDefinition.RegulatoryIdentifier",
          "jurisdiction",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.RegulatoryIdentifier) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.deviceIdentifier.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.deviceIdentifier)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.issuer.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.issuer)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.jurisdiction.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.jurisdiction)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionDeviceNameSerializer : FhirSerializer<DeviceDefinition.DeviceName> {
  override val descriptor: SerialDescriptor = buildDescriptor("DeviceName", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.DeviceName>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("type")
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.DeviceName {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: DeviceNameType? = null
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
        5 -> type = DeviceNameType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.DeviceName(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R5String.of(name, _name), "DeviceDefinition.DeviceName", "name"),
      type = required(Enumeration.of(type, _type), "DeviceDefinition.DeviceName", "type"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.DeviceName) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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

internal object DeviceDefinitionClassificationSerializer :
  FhirSerializer<DeviceDefinition.Classification> {
  override val descriptor: SerialDescriptor = buildDescriptor("Classification", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.Classification>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("justification", RelatedArtifactSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Classification {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var justification: List<RelatedArtifact>? = null
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
          justification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.Classification(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "DeviceDefinition.Classification", "type"),
      justification = listOrEmpty(justification),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Classification) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      RelatedArtifactSerializer.listSerializer,
      value.justification,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionConformsToSerializer : FhirSerializer<DeviceDefinition.ConformsTo> {
  override val descriptor: SerialDescriptor = buildDescriptor("ConformsTo", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.ConformsTo>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("specification", CodeableConceptSerializer.descriptor)
    b.strPrimList("version")
    b.optionalElement("source", RelatedArtifactSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.ConformsTo {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var specification: CodeableConcept? = null
    var version: List<KotlinString?>? = null
    var _version: List<Element?>? = null
    var source: List<RelatedArtifact>? = null
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
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          specification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        6 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val version_ =
      List(maxSize(version, _version)) { index ->
        entryRequired(
          R5String.of(at(version, index), at(_version, index)),
          "DeviceDefinition.ConformsTo",
          "version",
        )
      }
    return DeviceDefinition.ConformsTo(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      category = category,
      specification = required(specification, "DeviceDefinition.ConformsTo", "specification"),
      version = version_,
      source = listOrEmpty(source),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.ConformsTo) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.specification,
    )
    if (!value.version.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        stringNullableListSerializer,
        value.version.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.version)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      RelatedArtifactSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionHasPartSerializer : FhirSerializer<DeviceDefinition.HasPart> {
  override val descriptor: SerialDescriptor = buildDescriptor("HasPart", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.HasPart>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("reference", ReferenceSerializer.descriptor)
    b.intPrim("count")
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.HasPart {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var count: Int? = null
    var _count: Element? = null
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
          reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> count = compositeDecoder.decodeIntElement(descriptor, i)
        5 ->
          _count =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.HasPart(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      reference = required(reference, "DeviceDefinition.HasPart", "reference"),
      count = Integer.of(count, _count),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.HasPart) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.reference)
    compositeEncoder.encodeIntIfNotNull(descriptor, 4, value.count?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.count)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionPackagingSerializer : FhirSerializer<DeviceDefinition.Packaging> {
  override val descriptor: SerialDescriptor = buildDescriptor("Packaging", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.Packaging>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.intPrim("count")
    b.optionalElement(
      "distributor",
      DeviceDefinitionPackagingDistributorSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "udiDeviceIdentifier",
      listSerialDescriptor(
        lazyDescriptor(LazyDescriptorId.DeviceDefinitionUdiDeviceIdentifierSerializer)
      ),
    )
    b.optionalElement(
      "packaging",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.DeviceDefinitionPackagingSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Packaging {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        4 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> count = compositeDecoder.decodeIntElement(descriptor, i)
        6 ->
          _count =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          distributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionPackagingDistributorSerializer.listSerializer,
              null,
            )
        8 ->
          udiDeviceIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
              null,
            )
        9 ->
          packaging =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionPackagingSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.Packaging(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = identifier,
      type = type,
      count = Integer.of(count, _count),
      distributor = listOrEmpty(distributor),
      udiDeviceIdentifier = listOrEmpty(udiDeviceIdentifier),
      packaging = listOrEmpty(packaging),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Packaging) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.count?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.count)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      DeviceDefinitionPackagingDistributorSerializer.listSerializer,
      value.distributor,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
      value.udiDeviceIdentifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      DeviceDefinitionPackagingSerializer.listSerializer,
      value.packaging,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionPackagingDistributorSerializer :
  FhirSerializer<DeviceDefinition.Packaging.Distributor> {
  override val descriptor: SerialDescriptor = buildDescriptor("Distributor", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.Packaging.Distributor>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.optionalElement("organizationReference", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Packaging.Distributor {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var organizationReference: List<Reference>? = null
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
        5 ->
          organizationReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.Packaging.Distributor(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = R5String.of(name, _name),
      organizationReference = listOrEmpty(organizationReference),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Packaging.Distributor) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      ReferenceSerializer.listSerializer,
      value.organizationReference,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionVersionSerializer : FhirSerializer<DeviceDefinition.Version> {
  override val descriptor: SerialDescriptor = buildDescriptor("Version", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.Version>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("component", IdentifierSerializer.descriptor)
    b.strPrim("value")
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Version {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.Version(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      component = component,
      `value` = required(R5String.of(`value`, _value), "DeviceDefinition.Version", "value"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Version) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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

internal object DeviceDefinitionPropertySerializer : FhirSerializer<DeviceDefinition.Property> {
  override val descriptor: SerialDescriptor = buildDescriptor("Property", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.Property>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.strPrim("valueString")
    b.boolPrim("valueBoolean")
    b.intPrim("valueInteger")
    b.optionalElement("valueRange", RangeSerializer.descriptor)
    b.optionalElement("valueAttachment", AttachmentSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Property {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
              QuantitySerializer,
              null,
            )
        5 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        11 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        13 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.Property(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "DeviceDefinition.Property", "type"),
      `value` =
        required(
          DeviceDefinition.Property.Value.from(
            valueQuantity,
            valueCodeableConcept,
            R5String.of(valueString, _valueString),
            R5Boolean.of(valueBoolean, _valueBoolean),
            Integer.of(valueInteger, _valueInteger),
            valueRange,
            valueAttachment,
          ),
          "DeviceDefinition.Property",
          "value",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Property) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.`value`) {
      is DeviceDefinition.Property.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
      }
      is DeviceDefinition.Property.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is DeviceDefinition.Property.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is DeviceDefinition.Property.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is DeviceDefinition.Property.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is DeviceDefinition.Property.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 12, RangeSerializer, choice.value)
      }
      is DeviceDefinition.Property.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          13,
          AttachmentSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionLinkSerializer : FhirSerializer<DeviceDefinition.Link> {
  override val descriptor: SerialDescriptor = buildDescriptor("Link", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.Link>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("relation", CodingSerializer.descriptor)
    b.optionalElement("relatedDevice", CodeableReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Link {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relation: Coding? = null
    var relatedDevice: CodeableReference? = null
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
          relation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        4 ->
          relatedDevice =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.Link(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      relation = required(relation, "DeviceDefinition.Link", "relation"),
      relatedDevice = required(relatedDevice, "DeviceDefinition.Link", "relatedDevice"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Link) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodingSerializer, value.relation)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      4,
      CodeableReferenceSerializer,
      value.relatedDevice,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionMaterialSerializer : FhirSerializer<DeviceDefinition.Material> {
  override val descriptor: SerialDescriptor = buildDescriptor("Material", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.Material>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("substance", CodeableConceptSerializer.descriptor)
    b.boolPrim("alternate")
    b.boolPrim("allergenicIndicator")
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Material {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var substance: CodeableConcept? = null
    var alternate: KotlinBoolean? = null
    var _alternate: Element? = null
    var allergenicIndicator: KotlinBoolean? = null
    var _allergenicIndicator: Element? = null
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
          substance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> alternate = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _alternate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> allergenicIndicator = compositeDecoder.decodeBooleanElement(descriptor, i)
        7 ->
          _allergenicIndicator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.Material(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      substance = required(substance, "DeviceDefinition.Material", "substance"),
      alternate = R5Boolean.of(alternate, _alternate),
      allergenicIndicator = R5Boolean.of(allergenicIndicator, _allergenicIndicator),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Material) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.substance,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.alternate?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.alternate)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 6, value.allergenicIndicator?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.allergenicIndicator)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionGuidelineSerializer : FhirSerializer<DeviceDefinition.Guideline> {
  override val descriptor: SerialDescriptor = buildDescriptor("Guideline", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.Guideline>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.strPrim("usageInstruction")
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("indication", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("contraindication", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("warning", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("intendedUse")
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Guideline {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        4 -> usageInstruction = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _usageInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          relatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        7 ->
          indication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          contraindication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          warning =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        10 -> intendedUse = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _intendedUse =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.Guideline(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      useContext = listOrEmpty(useContext),
      usageInstruction = Markdown.of(usageInstruction, _usageInstruction),
      relatedArtifact = listOrEmpty(relatedArtifact),
      indication = listOrEmpty(indication),
      contraindication = listOrEmpty(contraindication),
      warning = listOrEmpty(warning),
      intendedUse = R5String.of(intendedUse, _intendedUse),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Guideline) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.usageInstruction?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.usageInstruction)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      RelatedArtifactSerializer.listSerializer,
      value.relatedArtifact,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.indication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      CodeableConceptSerializer.listSerializer,
      value.contraindication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      CodeableConceptSerializer.listSerializer,
      value.warning,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.intendedUse?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.intendedUse)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionCorrectiveActionSerializer :
  FhirSerializer<DeviceDefinition.CorrectiveAction> {
  override val descriptor: SerialDescriptor = buildDescriptor("CorrectiveAction", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.CorrectiveAction>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("recall")
    b.strPrim("scope")
    b.optionalElement("period", PeriodSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.CorrectiveAction {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var recall: KotlinBoolean? = null
    var _recall: Element? = null
    var scope: DeviceCorrectiveActionScope? = null
    var _scope: Element? = null
    var period: Period? = null
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
        3 -> recall = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _recall =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          scope =
            DeviceCorrectiveActionScope.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        6 ->
          _scope =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.CorrectiveAction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      recall =
        required(R5Boolean.of(recall, _recall), "DeviceDefinition.CorrectiveAction", "recall"),
      scope = Enumeration.of(scope, _scope),
      period = required(period, "DeviceDefinition.CorrectiveAction", "period"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.CorrectiveAction) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.recall.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.recall)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.scope?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.scope)
    compositeEncoder.encodeSerializableElement(descriptor, 7, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionChargeItemSerializer : FhirSerializer<DeviceDefinition.ChargeItem> {
  override val descriptor: SerialDescriptor = buildDescriptor("ChargeItem", this)

  @JvmField
  internal val listSerializer: KSerializer<List<DeviceDefinition.ChargeItem>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("chargeItemCode", CodeableReferenceSerializer.descriptor)
    b.optionalElement("count", QuantitySerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.ChargeItem {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var chargeItemCode: CodeableReference? = null
    var count: Quantity? = null
    var effectivePeriod: Period? = null
    var useContext: List<UsageContext>? = null
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
          chargeItemCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 ->
          count =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        6 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceDefinition.ChargeItem(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      chargeItemCode = required(chargeItemCode, "DeviceDefinition.ChargeItem", "chargeItemCode"),
      count = required(count, "DeviceDefinition.ChargeItem", "count"),
      effectivePeriod = effectivePeriod,
      useContext = listOrEmpty(useContext),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.ChargeItem) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableReferenceSerializer,
      value.chargeItemCode,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, QuantitySerializer, value.count)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      PeriodSerializer,
      value.effectivePeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceDefinitionSerializer : FhirResourceSerializer<DeviceDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("DeviceDefinition")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement(
      "udiDeviceIdentifier",
      DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "regulatoryIdentifier",
      DeviceDefinitionRegulatoryIdentifierSerializer.listSerializer.descriptor,
    )
    b.strPrim("partNumber")
    b.optionalElement("manufacturer", ReferenceSerializer.descriptor)
    b.optionalElement("deviceName", DeviceDefinitionDeviceNameSerializer.listSerializer.descriptor)
    b.strPrim("modelNumber")
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
    b.strPrimList("productionIdentifierInUDI")
    b.optionalElement("guideline", DeviceDefinitionGuidelineSerializer.descriptor)
    b.optionalElement("correctiveAction", DeviceDefinitionCorrectiveActionSerializer.descriptor)
    b.optionalElement("chargeItem", DeviceDefinitionChargeItemSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
        10 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 ->
          udiDeviceIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
              null,
            )
        14 ->
          regulatoryIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionRegulatoryIdentifierSerializer.listSerializer,
              null,
            )
        15 -> partNumber = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _partNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 ->
          deviceName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionDeviceNameSerializer.listSerializer,
              null,
            )
        19 -> modelNumber = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _modelNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          classification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionClassificationSerializer.listSerializer,
              null,
            )
        22 ->
          conformsTo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionConformsToSerializer.listSerializer,
              null,
            )
        23 ->
          hasPart =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionHasPartSerializer.listSerializer,
              null,
            )
        24 ->
          packaging =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionPackagingSerializer.listSerializer,
              null,
            )
        25 ->
          version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionVersionSerializer.listSerializer,
              null,
            )
        26 ->
          safety =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        27 ->
          shelfLifeStorage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ProductShelfLifeSerializer.listSerializer,
              null,
            )
        28 ->
          languageCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        29 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionPropertySerializer.listSerializer,
              null,
            )
        30 ->
          owner =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        31 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        32 ->
          link =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionLinkSerializer.listSerializer,
              null,
            )
        33 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        34 ->
          material =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionMaterialSerializer.listSerializer,
              null,
            )
        35 ->
          productionIdentifierInUDI =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        36 ->
          _productionIdentifierInUDI =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        37 ->
          guideline =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionGuidelineSerializer,
              null,
            )
        38 ->
          correctiveAction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionCorrectiveActionSerializer,
              null,
            )
        39 ->
          chargeItem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceDefinitionChargeItemSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val productionIdentifierInUDI_ =
      List(maxSize(productionIdentifierInUDI, _productionIdentifierInUDI)) { index ->
        entryRequired(
          Enumeration.of(
            at(productionIdentifierInUDI, index)?.let {
              DeviceProductionIdentifierInUDI.fromCode(it)
            },
            at(_productionIdentifierInUDI, index),
          ),
          "DeviceDefinition",
          "productionIdentifierInUDI",
        )
      }
    return DeviceDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      description = Markdown.of(description, _description),
      identifier = listOrEmpty(identifier),
      udiDeviceIdentifier = listOrEmpty(udiDeviceIdentifier),
      regulatoryIdentifier = listOrEmpty(regulatoryIdentifier),
      partNumber = R5String.of(partNumber, _partNumber),
      manufacturer = manufacturer,
      deviceName = listOrEmpty(deviceName),
      modelNumber = R5String.of(modelNumber, _modelNumber),
      classification = listOrEmpty(classification),
      conformsTo = listOrEmpty(conformsTo),
      hasPart = listOrEmpty(hasPart),
      packaging = listOrEmpty(packaging),
      version = listOrEmpty(version),
      safety = listOrEmpty(safety),
      shelfLifeStorage = listOrEmpty(shelfLifeStorage),
      languageCode = listOrEmpty(languageCode),
      `property` = listOrEmpty(`property`),
      owner = owner,
      contact = listOrEmpty(contact),
      link = listOrEmpty(link),
      note = listOrEmpty(note),
      material = listOrEmpty(material),
      productionIdentifierInUDI = productionIdentifierInUDI_,
      guideline = guideline,
      correctiveAction = correctiveAction,
      chargeItem = listOrEmpty(chargeItem),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DeviceDefinition,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      10 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13 + descriptorOffset,
      DeviceDefinitionUdiDeviceIdentifierSerializer.listSerializer,
      value.udiDeviceIdentifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      DeviceDefinitionRegulatoryIdentifierSerializer.listSerializer,
      value.regulatoryIdentifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.partNumber?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.partNumber)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18 + descriptorOffset,
      DeviceDefinitionDeviceNameSerializer.listSerializer,
      value.deviceName,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.modelNumber?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.modelNumber)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21 + descriptorOffset,
      DeviceDefinitionClassificationSerializer.listSerializer,
      value.classification,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      DeviceDefinitionConformsToSerializer.listSerializer,
      value.conformsTo,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      DeviceDefinitionHasPartSerializer.listSerializer,
      value.hasPart,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24 + descriptorOffset,
      DeviceDefinitionPackagingSerializer.listSerializer,
      value.packaging,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25 + descriptorOffset,
      DeviceDefinitionVersionSerializer.listSerializer,
      value.version,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.safety,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      ProductShelfLifeSerializer.listSerializer,
      value.shelfLifeStorage,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      28 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.languageCode,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      29 + descriptorOffset,
      DeviceDefinitionPropertySerializer.listSerializer,
      value.`property`,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      ContactPointSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      DeviceDefinitionLinkSerializer.listSerializer,
      value.link,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      DeviceDefinitionMaterialSerializer.listSerializer,
      value.material,
    )
    if (!value.productionIdentifierInUDI.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        35 + descriptorOffset,
        stringNullableListSerializer,
        value.productionIdentifierInUDI.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        36 + descriptorOffset,
        value.productionIdentifierInUDI,
      )
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      DeviceDefinitionGuidelineSerializer,
      value.guideline,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      DeviceDefinitionCorrectiveActionSerializer,
      value.correctiveAction,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      39 + descriptorOffset,
      DeviceDefinitionChargeItemSerializer.listSerializer,
      value.chargeItem,
    )
  }
}
