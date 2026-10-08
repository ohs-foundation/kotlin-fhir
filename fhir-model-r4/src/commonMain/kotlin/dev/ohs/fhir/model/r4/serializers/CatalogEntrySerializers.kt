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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.CatalogEntry
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.CatalogEntryRelationType
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object CatalogEntryRelatedEntrySerializer : KSerializer<CatalogEntry.RelatedEntry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedEntry") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("relationtype", String.serializer().descriptor)
      optionalElement("_relationtype", ElementSerializer.descriptor)
      optionalElement("item", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CatalogEntry.RelatedEntry>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): CatalogEntry.RelatedEntry {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relationtype: String? = null
    var _relationtype: Element? = null
    var item: Reference? = null
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
        3 -> relationtype = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _relationtype =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedEntry: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CatalogEntry.RelatedEntry(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relationtype =
        Enumeration.of(
          if (relationtype != null) CatalogEntryRelationType.fromCode(relationtype) else null,
          _relationtype,
        )
          ?: throw SerializationException(
            "Missing required property 'relationtype' on CatalogEntry.RelatedEntry"
          ),
      item =
        item
          ?: throw SerializationException(
            "Missing required property 'item' on CatalogEntry.RelatedEntry"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CatalogEntry.RelatedEntry) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.relationtype.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.relationtype)
    compositeEncoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.item)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CatalogEntrySerializer : FhirResourceSerializer<CatalogEntry> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CatalogEntry")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("orderable", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_orderable", ElementSerializer.descriptor)
    b.optionalElement("referencedItem", ReferenceSerializer.descriptor)
    b.optionalElement("additionalIdentifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("classification", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("validityPeriod", PeriodSerializer.descriptor)
    b.optionalElement("validTo", String.serializer().descriptor)
    b.optionalElement("_validTo", ElementSerializer.descriptor)
    b.optionalElement("lastUpdated", String.serializer().descriptor)
    b.optionalElement("_lastUpdated", ElementSerializer.descriptor)
    b.optionalElement(
      "additionalCharacteristic",
      CodeableConceptSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "additionalClassification",
      CodeableConceptSerializer.listSerializer.descriptor,
    )
    b.optionalElement("relatedEntry", CatalogEntryRelatedEntrySerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 -> orderable = compositeDecoder.decodeBooleanElement(descriptor, i)
        13 ->
          _orderable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          referencedItem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        15 ->
          additionalIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        16 ->
          classification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          validityPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        20 -> validTo = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _validTo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> lastUpdated = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _lastUpdated =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          additionalCharacteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        25 ->
          additionalClassification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        26 ->
          relatedEntry =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CatalogEntryRelatedEntrySerializer.listSerializer,
              null,
            )
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
      orderable =
        R4Boolean.of(orderable, _orderable)
          ?: throw SerializationException("Missing required property 'orderable' on CatalogEntry"),
      referencedItem =
        referencedItem
          ?: throw SerializationException(
            "Missing required property 'referencedItem' on CatalogEntry"
          ),
      additionalIdentifier = additionalIdentifier ?: listOf(),
      classification = classification ?: listOf(),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status),
      validityPeriod = validityPeriod,
      validTo =
        DateTime.of(if (validTo != null) FhirDateTime.fromString(validTo) else null, _validTo),
      lastUpdated =
        DateTime.of(
          if (lastUpdated != null) FhirDateTime.fromString(lastUpdated) else null,
          _lastUpdated,
        ),
      additionalCharacteristic = additionalCharacteristic ?: listOf(),
      additionalClassification = additionalClassification ?: listOf(),
      relatedEntry = relatedEntry ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CatalogEntry,
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
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.orderable.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.orderable)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.referencedItem,
    )
    if (value.additionalIdentifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.additionalIdentifier,
      )
    if (value.classification.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.classification,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.status?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      PeriodSerializer,
      value.validityPeriod,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.validTo?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.validTo)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.lastUpdated?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.lastUpdated)
    if (value.additionalCharacteristic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.additionalCharacteristic,
      )
    if (value.additionalClassification.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.additionalClassification,
      )
    if (value.relatedEntry.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CatalogEntryRelatedEntrySerializer.listSerializer,
        value.relatedEntry,
      )
  }
}
