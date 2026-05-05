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
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> relationtype = decoder.decodeStringElement(__desc, __i)
        4 ->
          _relationtype =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.relationtypeSer, null)
        5 -> item = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.itemSer, null)
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
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("orderable", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_orderable", Element.serializer().descriptor, isOptional = true)
    b.element("referencedItem", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "additionalIdentifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "classification",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("validityPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("validTo", String.serializer().descriptor, isOptional = true)
    b.element("_validTo", Element.serializer().descriptor, isOptional = true)
    b.element("lastUpdated", String.serializer().descriptor, isOptional = true)
    b.element("_lastUpdated", Element.serializer().descriptor, isOptional = true)
    b.element(
      "additionalCharacteristic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "additionalClassification",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedEntry",
      listSerialDescriptor(lazyDescriptor { CatalogEntry.RelatedEntry.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): CatalogEntry =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: CatalogEntry) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CatalogEntry")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): CatalogEntry {
    val __desc = desc
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
        11 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        12 -> orderable = decoder.decodeBooleanElement(__desc, __i)
        13 ->
          _orderable =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 ->
          referencedItem =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referencedItemSer, null)
        15 ->
          additionalIdentifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        16 ->
          classification =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.classificationSer, null)
        17 -> status = decoder.decodeStringElement(__desc, __i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.validityPeriodSer, null)
        20 -> validTo = decoder.decodeStringElement(__desc, __i)
        21 ->
          _validTo =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 -> lastUpdated = decoder.decodeStringElement(__desc, __i)
        23 ->
          _lastUpdated =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 ->
          additionalCharacteristic =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.classificationSer, null)
        25 ->
          additionalClassification =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.classificationSer, null)
        26 ->
          relatedEntry =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.relatedEntrySer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: CatalogEntry,
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
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.typeSer, it) }
    ((value.orderable.value))?.let { encoder.encodeBooleanElement(__desc, 12 + __off, it) }
    (value.orderable.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.referencedItem)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.referencedItemSer, it)
    }
    if (value.additionalIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15 + __off,
        Hoisted.identifierSer,
        value.additionalIdentifier,
      )
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        16 + __off,
        Hoisted.classificationSer,
        value.classification,
      )
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.validityPeriodSer, it)
    }
    ((value.validTo?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 20 + __off, it)
    }
    (value.validTo?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.lastUpdated?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 22 + __off, it)
    }
    (value.lastUpdated?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.additionalCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        24 + __off,
        Hoisted.classificationSer,
        value.additionalCharacteristic,
      )
    if (value.additionalClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        25 + __off,
        Hoisted.classificationSer,
        value.additionalClassification,
      )
    if (value.relatedEntry.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26 + __off,
        Hoisted.relatedEntrySer,
        value.relatedEntry,
      )
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

internal object CatalogEntryPolymorphicSerializer : KSerializer<CatalogEntry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CatalogEntry") { CatalogEntrySerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: CatalogEntry) {
    encoder.encodeStructure(descriptor) {
      CatalogEntrySerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): CatalogEntry =
    decoder.decodeStructure(descriptor) {
      CatalogEntrySerializer.deserializeJson(this, descriptor, 0)
    }
}
