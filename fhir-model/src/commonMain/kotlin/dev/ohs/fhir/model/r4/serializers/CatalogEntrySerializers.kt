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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: CatalogEntry.RelatedEntry) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CatalogEntry.RelatedEntry {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relationtype: String? = null
    var _relationtype: Element? = null
    var item: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> relationtype = decoder.decodeStringElement(descriptor, i)
        4 ->
          _relationtype =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relationtypeSer, null)
        5 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedEntry: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CatalogEntry.RelatedEntry) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.relationtype.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.relationtype.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.relationtypeSer, it)
    }
    (value.item)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.itemSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: CatalogEntry) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CatalogEntry")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): CatalogEntry {
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        12 -> orderable = decoder.decodeBooleanElement(descriptor, i)
        13 ->
          _orderable =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 ->
          referencedItem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.referencedItemSer,
              null,
            )
        15 ->
          additionalIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        16 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        17 -> status = decoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.validityPeriodSer,
              null,
            )
        20 -> validTo = decoder.decodeStringElement(descriptor, i)
        21 ->
          _validTo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> lastUpdated = decoder.decodeStringElement(descriptor, i)
        23 ->
          _lastUpdated =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          additionalCharacteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        25 ->
          additionalClassification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        26 ->
          relatedEntry =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relatedEntrySer, null)
        else -> throw SerializationException("Unexpected index decoding CatalogEntry: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CatalogEntry,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.orderable.value))?.let {
      encoder.encodeBooleanElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.orderable.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.referencedItem)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.referencedItemSer,
        it,
      )
    }
    if (value.additionalIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.identifierSer,
        value.additionalIdentifier,
      )
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.classificationSer,
        value.classification,
      )
    ((value.status?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.validityPeriodSer,
        it,
      )
    }
    ((value.validTo?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.validTo?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastUpdated?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.lastUpdated?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.additionalCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.classificationSer,
        value.additionalCharacteristic,
      )
    if (value.additionalClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.classificationSer,
        value.additionalClassification,
      )
    if (value.relatedEntry.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
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
      CatalogEntrySerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): CatalogEntry =
    decoder.decodeStructure(descriptor) {
      CatalogEntrySerializer.deserializeInternal(this, descriptor, 0)
    }
}
