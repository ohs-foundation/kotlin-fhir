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
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
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
      element(
        "marketDistribution",
        listSerialDescriptor(
          lazyDescriptor {
            DeviceDefinition.UdiDeviceIdentifier.MarketDistribution.serializer().descriptor
          }
        ),
        isOptional = true,
      )
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
    var marketDistribution: List<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution>? = null
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
        9 ->
          marketDistribution =
            decoder.decodeNullableSerializableElement(
              __desc,
              9,
              Hoisted.marketDistributionSer,
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
      deviceIdentifier = R5String.of(deviceIdentifier, _deviceIdentifier)!!,
      issuer = Uri.of(issuer, _issuer)!!,
      jurisdiction = Uri.of(jurisdiction, _jurisdiction)!!,
      marketDistribution = marketDistribution ?: listOf(),
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
    if (value.marketDistribution.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9,
        Hoisted.marketDistributionSer,
        value.marketDistribution,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val deviceIdentifierSer: KSerializer<Element> = Element.serializer()

    public val marketDistributionSerInner:
      KSerializer<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution> =
      DeviceDefinition.UdiDeviceIdentifier.MarketDistribution.serializer()

    public val marketDistributionSer:
      KSerializer<List<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution>> =
      ListSerializer(Hoisted.marketDistributionSerInner)
  }
}

internal object DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer :
  KSerializer<DeviceDefinition.UdiDeviceIdentifier.MarketDistribution> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MarketDistribution") {
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
      element("marketPeriod", Period.serializer().descriptor, isOptional = true)
      element("subJurisdiction", KotlinString.serializer().descriptor, isOptional = true)
      element("_subJurisdiction", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): DeviceDefinition.UdiDeviceIdentifier.MarketDistribution =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: DeviceDefinition.UdiDeviceIdentifier.MarketDistribution,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): DeviceDefinition.UdiDeviceIdentifier.MarketDistribution {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var marketPeriod: Period? = null
    var subJurisdiction: KotlinString? = null
    var _subJurisdiction: Element? = null
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
          marketPeriod =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.marketPeriodSer, null)
        4 -> subJurisdiction = decoder.decodeStringElement(__desc, 4)
        5 ->
          _subJurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.subJurisdictionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MarketDistribution: " + __i)
      }
    }
    return DeviceDefinition.UdiDeviceIdentifier.MarketDistribution(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      marketPeriod = marketPeriod!!,
      subJurisdiction = Uri.of(subJurisdiction, _subJurisdiction)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: DeviceDefinition.UdiDeviceIdentifier.MarketDistribution,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.marketPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.marketPeriodSer, it)
    }
    ((value.subJurisdiction.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.subJurisdiction.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.subJurisdictionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val marketPeriodSer: KSerializer<Period> = Period.serializer()

    public val subJurisdictionSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceDefinitionRegulatoryIdentifierSerializer :
  KSerializer<DeviceDefinition.RegulatoryIdentifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RegulatoryIdentifier") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("deviceIdentifier", KotlinString.serializer().descriptor, isOptional = true)
      element("_deviceIdentifier", Element.serializer().descriptor, isOptional = true)
      element("issuer", KotlinString.serializer().descriptor, isOptional = true)
      element("_issuer", Element.serializer().descriptor, isOptional = true)
      element("jurisdiction", KotlinString.serializer().descriptor, isOptional = true)
      element("_jurisdiction", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.RegulatoryIdentifier =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.RegulatoryIdentifier) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.RegulatoryIdentifier {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> deviceIdentifier = decoder.decodeStringElement(__desc, 5)
        6 ->
          _deviceIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 -> issuer = decoder.decodeStringElement(__desc, 7)
        8 -> _issuer = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.typeSer, null)
        9 -> jurisdiction = decoder.decodeStringElement(__desc, 9)
        10 ->
          _jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding RegulatoryIdentifier: " + __i)
      }
    }
    return DeviceDefinition.RegulatoryIdentifier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          DeviceDefinition.DeviceDefinitionRegulatoryIdentifierType.fromCode(type!!),
          _type,
        ),
      deviceIdentifier = R5String.of(deviceIdentifier, _deviceIdentifier)!!,
      issuer = Uri.of(issuer, _issuer)!!,
      jurisdiction = Uri.of(jurisdiction, _jurisdiction)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: DeviceDefinition.RegulatoryIdentifier,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    ((value.deviceIdentifier.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.deviceIdentifier.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
    ((value.issuer.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.issuer.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, it)
    }
    ((value.jurisdiction.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.jurisdiction.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
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
      name = R5String.of(name, _name)!!,
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

internal object DeviceDefinitionClassificationSerializer :
  KSerializer<DeviceDefinition.Classification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Classification") {
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
        "justification",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Classification =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Classification) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Classification {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var justification: List<RelatedArtifact>? = null
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
          justification =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.justificationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Classification: " + __i)
      }
    }
    return DeviceDefinition.Classification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      justification = justification ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Classification) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    if (value.justification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.justificationSer, value.justification)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val justificationSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val justificationSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.justificationSerInner)
  }
}

internal object DeviceDefinitionConformsToSerializer : KSerializer<DeviceDefinition.ConformsTo> {
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
      element(
        "version",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_version", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "source",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.ConformsTo =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.ConformsTo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.ConformsTo {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var specification: CodeableConcept? = null
    var version: List<KotlinString?>? = null
    var _version: List<Element?>? = null
    var source: List<RelatedArtifact>? = null
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
        5 ->
          version = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.versionSer, null)
        6 ->
          _version = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.versionSer2, null)
        7 -> source = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ConformsTo: " + __i)
      }
    }
    return DeviceDefinition.ConformsTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      specification = specification!!,
      version =
        (kotlin.collections.List(maxOf(version?.size ?: 0, _version?.size ?: 0)) { __i ->
          R5String.of(version?.getOrNull(__i)?.let { it }, _version?.getOrNull(__i))!!
        }),
      source = source ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.ConformsTo) {
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
    (value.version.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.versionSer, it)
    }
    (value.version.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.versionSer2, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val versionSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val versionSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.versionSerInner).nullable)

    public val versionSerInner2: KSerializer<Element> = Element.serializer()

    public val versionSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.versionSerInner2).nullable)

    public val sourceSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val sourceSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.sourceSerInner)
  }
}

internal object DeviceDefinitionHasPartSerializer : KSerializer<DeviceDefinition.HasPart> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("HasPart") {
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
      element("reference", Reference.serializer().descriptor, isOptional = true)
      element("count", Int.serializer().descriptor, isOptional = true)
      element("_count", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.HasPart =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.HasPart) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.HasPart {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var count: Int? = null
    var _count: Element? = null
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
          reference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.referenceSer, null)
        4 -> count = decoder.decodeIntElement(__desc, 4)
        5 -> _count = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.countSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding HasPart: " + __i)
      }
    }
    return DeviceDefinition.HasPart(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference!!,
      count = Integer.of(count, _count),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.HasPart) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.referenceSer, it)
    }
    ((value.count?.value))?.let { encoder.encodeIntElement(__desc, 4, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.countSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSer: KSerializer<Reference> = Reference.serializer()

    public val countSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceDefinitionPackagingSerializer : KSerializer<DeviceDefinition.Packaging> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Packaging") {
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
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("count", Int.serializer().descriptor, isOptional = true)
      element("_count", Element.serializer().descriptor, isOptional = true)
      element(
        "distributor",
        listSerialDescriptor(
          lazyDescriptor { DeviceDefinition.Packaging.Distributor.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "udiDeviceIdentifier",
        listSerialDescriptor(
          lazyDescriptor { DeviceDefinition.UdiDeviceIdentifier.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "packaging",
        listSerialDescriptor(lazyDescriptor { DeviceDefinition.Packaging.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Packaging =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Packaging) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Packaging {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> count = decoder.decodeIntElement(__desc, 5)
        6 -> _count = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.countSer, null)
        7 ->
          distributor =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.distributorSer, null)
        8 ->
          udiDeviceIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.udiDeviceIdentifierSer,
              null,
            )
        9 ->
          packaging =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.packagingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Packaging: " + __i)
      }
    }
    return DeviceDefinition.Packaging(
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Packaging) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    ((value.count?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.countSer, it)
    }
    if (value.distributor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.distributorSer, value.distributor)
    if (value.udiDeviceIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        8,
        Hoisted.udiDeviceIdentifierSer,
        value.udiDeviceIdentifier,
      )
    if (value.packaging.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.packagingSer, value.packaging)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val countSer: KSerializer<Element> = Element.serializer()

    public val distributorSerInner: KSerializer<DeviceDefinition.Packaging.Distributor> =
      DeviceDefinition.Packaging.Distributor.serializer()

    public val distributorSer: KSerializer<List<DeviceDefinition.Packaging.Distributor>> =
      ListSerializer(Hoisted.distributorSerInner)

    public val udiDeviceIdentifierSerInner: KSerializer<DeviceDefinition.UdiDeviceIdentifier> =
      DeviceDefinition.UdiDeviceIdentifier.serializer()

    public val udiDeviceIdentifierSer: KSerializer<List<DeviceDefinition.UdiDeviceIdentifier>> =
      ListSerializer(Hoisted.udiDeviceIdentifierSerInner)

    public val packagingSerInner: KSerializer<DeviceDefinition.Packaging> =
      DeviceDefinition.Packaging.serializer()

    public val packagingSer: KSerializer<List<DeviceDefinition.Packaging>> =
      ListSerializer(Hoisted.packagingSerInner)
  }
}

internal object DeviceDefinitionPackagingDistributorSerializer :
  KSerializer<DeviceDefinition.Packaging.Distributor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Distributor") {
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
      element(
        "organizationReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Packaging.Distributor =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Packaging.Distributor) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Packaging.Distributor {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var organizationReference: List<Reference>? = null
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
        5 ->
          organizationReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.organizationReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Distributor: " + __i)
      }
    }
    return DeviceDefinition.Packaging.Distributor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name),
      organizationReference = organizationReference ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: DeviceDefinition.Packaging.Distributor,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    if (value.organizationReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        5,
        Hoisted.organizationReferenceSer,
        value.organizationReference,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val organizationReferenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val organizationReferenceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.organizationReferenceSerInner)
  }
}

internal object DeviceDefinitionVersionSerializer : KSerializer<DeviceDefinition.Version> {
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

  override fun deserialize(decoder: Decoder): DeviceDefinition.Version =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Version) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Version {
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
        5 -> `value` = decoder.decodeStringElement(__desc, 5)
        6 -> _value = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + __i)
      }
    }
    return DeviceDefinition.Version(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      component = component,
      `value` = R5String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Version) {
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
    return DeviceDefinition.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        DeviceDefinition.Property.Value.from(
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Property) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is DeviceDefinition.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.valueQuantitySer, __d.value)
      }
      is DeviceDefinition.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, __d.value)
      }
      is DeviceDefinition.Property.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueStringSer, it)
        }
      }
      is DeviceDefinition.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueStringSer, it)
        }
      }
      is DeviceDefinition.Property.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueStringSer, it)
        }
      }
      is DeviceDefinition.Property.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.valueRangeSer, __d.value)
      }
      is DeviceDefinition.Property.Value.Attachment -> {
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

internal object DeviceDefinitionLinkSerializer : KSerializer<DeviceDefinition.Link> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Link") {
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
      element("relation", Coding.serializer().descriptor, isOptional = true)
      element("relatedDevice", CodeableReference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Link =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Link) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Link {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relation: Coding? = null
    var relatedDevice: CodeableReference? = null
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
          relation = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.relationSer, null)
        4 ->
          relatedDevice =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.relatedDeviceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + __i)
      }
    }
    return DeviceDefinition.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relation = relation!!,
      relatedDevice = relatedDevice!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Link) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.relation)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.relationSer, it) }
    (value.relatedDevice)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.relatedDeviceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val relationSer: KSerializer<Coding> = Coding.serializer()

    public val relatedDeviceSer: KSerializer<CodeableReference> = CodeableReference.serializer()
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
      alternate = R5Boolean.of(alternate, _alternate),
      allergenicIndicator = R5Boolean.of(allergenicIndicator, _allergenicIndicator),
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

internal object DeviceDefinitionGuidelineSerializer : KSerializer<DeviceDefinition.Guideline> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Guideline") {
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
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element("usageInstruction", KotlinString.serializer().descriptor, isOptional = true)
      element("_usageInstruction", Element.serializer().descriptor, isOptional = true)
      element(
        "relatedArtifact",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "indication",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "contraindication",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "warning",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("intendedUse", KotlinString.serializer().descriptor, isOptional = true)
      element("_intendedUse", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Guideline =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Guideline) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.Guideline {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.useContextSer, null)
        4 -> usageInstruction = decoder.decodeStringElement(__desc, 4)
        5 ->
          _usageInstruction =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.usageInstructionSer, null)
        6 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.relatedArtifactSer, null)
        7 ->
          indication =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.indicationSer, null)
        8 ->
          contraindication =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.indicationSer, null)
        9 ->
          warning =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.indicationSer, null)
        10 -> intendedUse = decoder.decodeStringElement(__desc, 10)
        11 ->
          _intendedUse =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.usageInstructionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Guideline: " + __i)
      }
    }
    return DeviceDefinition.Guideline(
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.Guideline) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.useContextSer, value.useContext)
    ((value.usageInstruction?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.usageInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.usageInstructionSer, it)
    }
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        6,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    if (value.indication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.indicationSer, value.indication)
    if (value.contraindication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.indicationSer, value.contraindication)
    if (value.warning.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.indicationSer, value.warning)
    ((value.intendedUse?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.intendedUse?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.usageInstructionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val usageInstructionSer: KSerializer<Element> = Element.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val indicationSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val indicationSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.indicationSerInner)
  }
}

internal object DeviceDefinitionCorrectiveActionSerializer :
  KSerializer<DeviceDefinition.CorrectiveAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CorrectiveAction") {
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
      element("recall", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_recall", Element.serializer().descriptor, isOptional = true)
      element("scope", KotlinString.serializer().descriptor, isOptional = true)
      element("_scope", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.CorrectiveAction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.CorrectiveAction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.CorrectiveAction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var recall: KotlinBoolean? = null
    var _recall: Element? = null
    var scope: KotlinString? = null
    var _scope: Element? = null
    var period: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> recall = decoder.decodeBooleanElement(__desc, 3)
        4 -> _recall = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.recallSer, null)
        5 -> scope = decoder.decodeStringElement(__desc, 5)
        6 -> _scope = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.recallSer, null)
        7 -> period = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CorrectiveAction: " + __i)
      }
    }
    return DeviceDefinition.CorrectiveAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      recall = R5Boolean.of(recall, _recall)!!,
      scope =
        scope?.let {
          Enumeration.of(DeviceDefinition.DeviceCorrectiveActionScope.fromCode(it), _scope)
        },
      period = period!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.CorrectiveAction) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.recall.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.recall.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.recallSer, it)
    }
    ((value.scope?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.scope?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.recallSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val recallSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object DeviceDefinitionChargeItemSerializer : KSerializer<DeviceDefinition.ChargeItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItem") {
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
      element("chargeItemCode", CodeableReference.serializer().descriptor, isOptional = true)
      element("count", Quantity.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DeviceDefinition.ChargeItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.ChargeItem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceDefinition.ChargeItem {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var chargeItemCode: CodeableReference? = null
    var count: Quantity? = null
    var effectivePeriod: Period? = null
    var useContext: List<UsageContext>? = null
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
          chargeItemCode =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.chargeItemCodeSer, null)
        4 -> count = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.countSer, null)
        5 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.effectivePeriodSer, null)
        6 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.useContextSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ChargeItem: " + __i)
      }
    }
    return DeviceDefinition.ChargeItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      chargeItemCode = chargeItemCode!!,
      count = count!!,
      effectivePeriod = effectivePeriod,
      useContext = useContext ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition.ChargeItem) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.chargeItemCode)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.chargeItemCodeSer, it)
    }
    (value.count)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.countSer, it) }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.effectivePeriodSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.useContextSer, value.useContext)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val chargeItemCodeSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val countSer: KSerializer<Quantity> = Quantity.serializer()

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)
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
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
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
    b.element(
      "regulatoryIdentifier",
      listSerialDescriptor(
        lazyDescriptor { DeviceDefinition.RegulatoryIdentifier.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("partNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_partNumber", Element.serializer().descriptor, isOptional = true)
    b.element("manufacturer", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "deviceName",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.DeviceName.serializer().descriptor }),
      isOptional = true,
    )
    b.element("modelNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_modelNumber", Element.serializer().descriptor, isOptional = true)
    b.element(
      "classification",
      listSerialDescriptor(
        lazyDescriptor { DeviceDefinition.Classification.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "conformsTo",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.ConformsTo.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "hasPart",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.HasPart.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "packaging",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.Packaging.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "version",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.Version.serializer().descriptor }),
      isOptional = true,
    )
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
      "languageCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
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
    b.element(
      "link",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.Link.serializer().descriptor }),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "material",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.Material.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "productionIdentifierInUDI",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_productionIdentifierInUDI",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "guideline",
      lazyDescriptor { DeviceDefinition.Guideline.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "correctiveAction",
      lazyDescriptor { DeviceDefinition.CorrectiveAction.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "chargeItem",
      listSerialDescriptor(lazyDescriptor { DeviceDefinition.ChargeItem.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DeviceDefinition")
      serializeJson(this, value)
    }
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
        11 -> description = decoder.decodeStringElement(__desc, 11)
        12 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 ->
          udiDeviceIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.udiDeviceIdentifierSer,
              null,
            )
        15 ->
          regulatoryIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.regulatoryIdentifierSer,
              null,
            )
        16 -> partNumber = decoder.decodeStringElement(__desc, 16)
        17 ->
          _partNumber =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.manufacturerSer, null)
        19 ->
          deviceName =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.deviceNameSer, null)
        20 -> modelNumber = decoder.decodeStringElement(__desc, 20)
        21 ->
          _modelNumber =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          classification =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.classificationSer, null)
        23 ->
          conformsTo =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.conformsToSer, null)
        24 ->
          hasPart = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.hasPartSer, null)
        25 ->
          packaging =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.packagingSer, null)
        26 ->
          version = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.versionSer, null)
        27 ->
          safety = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.safetySer, null)
        28 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.shelfLifeStorageSer, null)
        29 ->
          languageCode =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.safetySer, null)
        30 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.propertySer, null)
        31 ->
          owner =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.manufacturerSer, null)
        32 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.contactSer, null)
        33 -> link = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.linkSer, null)
        34 -> note = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.noteSer, null)
        35 ->
          material =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.materialSer, null)
        36 ->
          productionIdentifierInUDI =
            decoder.decodeNullableSerializableElement(
              __desc,
              36,
              Hoisted.productionIdentifierInUDISer,
              null,
            )
        37 ->
          _productionIdentifierInUDI =
            decoder.decodeNullableSerializableElement(
              __desc,
              37,
              Hoisted.productionIdentifierInUDISer2,
              null,
            )
        38 ->
          guideline =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.guidelineSer, null)
        39 ->
          correctiveAction =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.correctiveActionSer, null)
        40 ->
          chargeItem =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.chargeItemSer, null)
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
        ) { __i ->
          Enumeration.of(
            DeviceDefinition.DeviceProductionIdentifierInUDI.fromCode(
              productionIdentifierInUDI?.getOrNull(__i)!!
            ),
            _productionIdentifierInUDI?.getOrNull(__i),
          )
        }),
      guideline = guideline,
      correctiveAction = correctiveAction,
      chargeItem = chargeItem ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: DeviceDefinition) {
    val __desc = descriptor
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
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    if (value.udiDeviceIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        14,
        Hoisted.udiDeviceIdentifierSer,
        value.udiDeviceIdentifier,
      )
    if (value.regulatoryIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15,
        Hoisted.regulatoryIdentifierSer,
        value.regulatoryIdentifier,
      )
    ((value.partNumber?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.partNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.manufacturerSer, it)
    }
    if (value.deviceName.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.deviceNameSer, value.deviceName)
    ((value.modelNumber?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.modelNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.classificationSer, value.classification)
    if (value.conformsTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.conformsToSer, value.conformsTo)
    if (value.hasPart.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.hasPartSer, value.hasPart)
    if (value.packaging.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.packagingSer, value.packaging)
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.versionSer, value.version)
    if (value.safety.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.safetySer, value.safety)
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        28,
        Hoisted.shelfLifeStorageSer,
        value.shelfLifeStorage,
      )
    if (value.languageCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.safetySer, value.languageCode)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.propertySer, value.`property`)
    (value.owner)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.manufacturerSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.contactSer, value.contact)
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.linkSer, value.link)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.noteSer, value.note)
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.materialSer, value.material)
    (value.productionIdentifierInUDI
        .map { it.value?.getCode() }
        .takeUnless { it.all { it == null } })
      ?.let {
        encoder.encodeSerializableElement(__desc, 36, Hoisted.productionIdentifierInUDISer, it)
      }
    (value.productionIdentifierInUDI.map { it.toElement() }.takeUnless { it.all { it == null } })
      ?.let {
        encoder.encodeSerializableElement(__desc, 37, Hoisted.productionIdentifierInUDISer2, it)
      }
    (value.guideline)?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.guidelineSer, it)
    }
    (value.correctiveAction)?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.correctiveActionSer, it)
    }
    if (value.chargeItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.chargeItemSer, value.chargeItem)
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

    public val regulatoryIdentifierSerInner: KSerializer<DeviceDefinition.RegulatoryIdentifier> =
      DeviceDefinition.RegulatoryIdentifier.serializer()

    public val regulatoryIdentifierSer: KSerializer<List<DeviceDefinition.RegulatoryIdentifier>> =
      ListSerializer(Hoisted.regulatoryIdentifierSerInner)

    public val manufacturerSer: KSerializer<Reference> = Reference.serializer()

    public val deviceNameSerInner: KSerializer<DeviceDefinition.DeviceName> =
      DeviceDefinition.DeviceName.serializer()

    public val deviceNameSer: KSerializer<List<DeviceDefinition.DeviceName>> =
      ListSerializer(Hoisted.deviceNameSerInner)

    public val classificationSerInner: KSerializer<DeviceDefinition.Classification> =
      DeviceDefinition.Classification.serializer()

    public val classificationSer: KSerializer<List<DeviceDefinition.Classification>> =
      ListSerializer(Hoisted.classificationSerInner)

    public val conformsToSerInner: KSerializer<DeviceDefinition.ConformsTo> =
      DeviceDefinition.ConformsTo.serializer()

    public val conformsToSer: KSerializer<List<DeviceDefinition.ConformsTo>> =
      ListSerializer(Hoisted.conformsToSerInner)

    public val hasPartSerInner: KSerializer<DeviceDefinition.HasPart> =
      DeviceDefinition.HasPart.serializer()

    public val hasPartSer: KSerializer<List<DeviceDefinition.HasPart>> =
      ListSerializer(Hoisted.hasPartSerInner)

    public val packagingSerInner: KSerializer<DeviceDefinition.Packaging> =
      DeviceDefinition.Packaging.serializer()

    public val packagingSer: KSerializer<List<DeviceDefinition.Packaging>> =
      ListSerializer(Hoisted.packagingSerInner)

    public val versionSerInner: KSerializer<DeviceDefinition.Version> =
      DeviceDefinition.Version.serializer()

    public val versionSer: KSerializer<List<DeviceDefinition.Version>> =
      ListSerializer(Hoisted.versionSerInner)

    public val safetySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val safetySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.safetySerInner)

    public val shelfLifeStorageSerInner: KSerializer<ProductShelfLife> =
      ProductShelfLife.serializer()

    public val shelfLifeStorageSer: KSerializer<List<ProductShelfLife>> =
      ListSerializer(Hoisted.shelfLifeStorageSerInner)

    public val propertySerInner: KSerializer<DeviceDefinition.Property> =
      DeviceDefinition.Property.serializer()

    public val propertySer: KSerializer<List<DeviceDefinition.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val contactSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val contactSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.contactSerInner)

    public val linkSerInner: KSerializer<DeviceDefinition.Link> = DeviceDefinition.Link.serializer()

    public val linkSer: KSerializer<List<DeviceDefinition.Link>> =
      ListSerializer(Hoisted.linkSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val materialSerInner: KSerializer<DeviceDefinition.Material> =
      DeviceDefinition.Material.serializer()

    public val materialSer: KSerializer<List<DeviceDefinition.Material>> =
      ListSerializer(Hoisted.materialSerInner)

    public val productionIdentifierInUDISerInner: KSerializer<KotlinString> =
      KotlinString.serializer()

    public val productionIdentifierInUDISer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.productionIdentifierInUDISerInner).nullable)

    public val productionIdentifierInUDISer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val guidelineSer: KSerializer<DeviceDefinition.Guideline> =
      DeviceDefinition.Guideline.serializer()

    public val correctiveActionSer: KSerializer<DeviceDefinition.CorrectiveAction> =
      DeviceDefinition.CorrectiveAction.serializer()

    public val chargeItemSerInner: KSerializer<DeviceDefinition.ChargeItem> =
      DeviceDefinition.ChargeItem.serializer()

    public val chargeItemSer: KSerializer<List<DeviceDefinition.ChargeItem>> =
      ListSerializer(Hoisted.chargeItemSerInner)
  }
}

internal object DeviceDefinitionPolymorphicSerializer : KSerializer<DeviceDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceDefinition") {
      DeviceDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition) {
    encoder.encodeStructure(descriptor) { DeviceDefinitionSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition =
    decoder.decodeStructure(descriptor) { DeviceDefinitionSerializer.deserializeJson(this) }
}
