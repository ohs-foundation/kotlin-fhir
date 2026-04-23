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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.CatalogEntry
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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

internal object CatalogEntryRelatedEntrySerializer : KSerializer<CatalogEntry.RelatedEntry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedEntry") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("relationtype", String.serializer().descriptor, isOptional = true)
      element("_relationtype", Element.serializer().descriptor, isOptional = true)
      element("item", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CatalogEntry.RelatedEntry =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CatalogEntry.RelatedEntry) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CatalogEntry.RelatedEntry {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relationtype: String? = null
    var _relationtype: Element? = null
    var item: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> relationtype = decoder.decodeStringElement(__desc, 3)
        4 ->
          _relationtype =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.relationtypeSer, null)
        5 -> item = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedEntry: " + __i)
      }
    }
    return CatalogEntry.RelatedEntry(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relationtype =
        Enumeration.of(
          CatalogEntry.CatalogEntryRelationType.fromCode(relationtype!!),
          _relationtype,
        ),
      item = item!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CatalogEntry.RelatedEntry) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.relationtype.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.relationtype.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.relationtypeSer, it)
    }
    (value.item)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.itemSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val relationtypeSer: KSerializer<Element> = Element.serializer()

    public val itemSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CatalogEntrySerializer : KSerializer<CatalogEntry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CatalogEntry") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("orderable", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_orderable", Element.serializer().descriptor, isOptional = true)
      element("referencedItem", Reference.serializer().descriptor, isOptional = true)
      element(
        "additionalIdentifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element(
        "classification",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("validityPeriod", Period.serializer().descriptor, isOptional = true)
      element("validTo", String.serializer().descriptor, isOptional = true)
      element("_validTo", Element.serializer().descriptor, isOptional = true)
      element("lastUpdated", String.serializer().descriptor, isOptional = true)
      element("_lastUpdated", Element.serializer().descriptor, isOptional = true)
      element(
        "additionalCharacteristic",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "additionalClassification",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relatedEntry",
        listSerialDescriptor(lazyDescriptor { CatalogEntry.RelatedEntry.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): CatalogEntry =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CatalogEntry) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): CatalogEntry {
    val __desc = descriptor
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var type: CodeableConcept? = null
    var orderable: KotlinBoolean? = null
    var _orderable: Element? = null
    var referencedItem: Reference? = null
    var additionalIdentifier: List<Identifier>? = null
    var classification: List<CodeableConcept>? = null
    var status: String? = null
    var _status: Element? = null
    var validityPeriod: Period? = null
    var validTo: String? = null
    var _validTo: Element? = null
    var lastUpdated: String? = null
    var _lastUpdated: Element? = null
    var additionalCharacteristic: List<CodeableConcept>? = null
    var additionalClassification: List<CodeableConcept>? = null
    var relatedEntry: List<CatalogEntry.RelatedEntry>? = null
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
        12 -> type = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.typeSer, null)
        13 -> orderable = decoder.decodeBooleanElement(__desc, 13)
        14 ->
          _orderable =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          referencedItem =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.referencedItemSer, null)
        16 ->
          additionalIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.identifierSer, null)
        17 ->
          classification =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.classificationSer, null)
        18 -> status = decoder.decodeStringElement(__desc, 18)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.validityPeriodSer, null)
        21 -> validTo = decoder.decodeStringElement(__desc, 21)
        22 ->
          _validTo =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> lastUpdated = decoder.decodeStringElement(__desc, 23)
        24 ->
          _lastUpdated =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          additionalCharacteristic =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.classificationSer, null)
        26 ->
          additionalClassification =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.classificationSer, null)
        27 ->
          relatedEntry =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.relatedEntrySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CatalogEntry: " + __i)
      }
    }
    return CatalogEntry(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type = type,
      orderable = R4Boolean.of(orderable, _orderable)!!,
      referencedItem = referencedItem!!,
      additionalIdentifier = additionalIdentifier ?: listOf(),
      classification = classification ?: listOf(),
      status = status?.let { Enumeration.of(PublicationStatus.fromCode(it), _status) },
      validityPeriod = validityPeriod,
      validTo = DateTime.of(FhirDateTime.fromString(validTo), _validTo),
      lastUpdated = DateTime.of(FhirDateTime.fromString(lastUpdated), _lastUpdated),
      additionalCharacteristic = additionalCharacteristic ?: listOf(),
      additionalClassification = additionalClassification ?: listOf(),
      relatedEntry = relatedEntry ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CatalogEntry) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "CatalogEntry")
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
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.typeSer, it) }
    ((value.orderable.value))?.let { encoder.encodeBooleanElement(__desc, 13, it) }
    (value.orderable.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.referencedItem)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.referencedItemSer, it)
    }
    if (value.additionalIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        16,
        Hoisted.identifierSer,
        value.additionalIdentifier,
      )
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.classificationSer, value.classification)
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.validityPeriodSer, it)
    }
    ((value.validTo?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.validTo?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.lastUpdated?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.lastUpdated?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    if (value.additionalCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        25,
        Hoisted.classificationSer,
        value.additionalCharacteristic,
      )
    if (value.additionalClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26,
        Hoisted.classificationSer,
        value.additionalClassification,
      )
    if (value.relatedEntry.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.relatedEntrySer, value.relatedEntry)
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

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val referencedItemSer: KSerializer<Reference> = Reference.serializer()

    public val classificationSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeSer)

    public val validityPeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedEntrySerInner: KSerializer<CatalogEntry.RelatedEntry> =
      CatalogEntry.RelatedEntry.serializer()

    public val relatedEntrySer: KSerializer<List<CatalogEntry.RelatedEntry>> =
      ListSerializer(Hoisted.relatedEntrySerInner)
  }
}
