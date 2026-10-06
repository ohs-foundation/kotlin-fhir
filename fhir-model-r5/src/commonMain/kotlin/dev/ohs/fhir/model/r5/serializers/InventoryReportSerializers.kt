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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.InventoryReport
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object InventoryReportInventoryListingSerializer :
  KSerializer<InventoryReport.InventoryListing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InventoryListing") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("location", ReferenceSerializer.descriptor)
      optionalElement("itemStatus", CodeableConceptSerializer.descriptor)
      optionalElement("countingDateTime", String.serializer().descriptor)
      optionalElement("_countingDateTime", ElementSerializer.descriptor)
      optionalElement(
        "item",
        InventoryReportInventoryListingItemSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<InventoryReport.InventoryListing>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryReport.InventoryListing =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var location: Reference? = null
      var itemStatus: CodeableConcept? = null
      var countingDateTime: String? = null
      var _countingDateTime: Element? = null
      var item: List<InventoryReport.InventoryListing.Item>? = null
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
            location = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            itemStatus =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> countingDateTime = decodeStringElement(descriptor, i)
          6 ->
            _countingDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            item =
              decodeNullableSerializableElement(
                descriptor,
                i,
                InventoryReportInventoryListingItemSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding InventoryListing: " + i)
        }
      }
      InventoryReport.InventoryListing(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        location = location,
        itemStatus = itemStatus,
        countingDateTime =
          DateTime.of(
            if (countingDateTime != null) FhirDateTime.fromString(countingDateTime) else null,
            _countingDateTime,
          ),
        item = item ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InventoryReport.InventoryListing) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.location)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.itemStatus)
      encodeStringIfNotNull(descriptor, 5, value.countingDateTime?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.countingDateTime)
      if (value.item.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          InventoryReportInventoryListingItemSerializer.listSerializer,
          value.item,
        )
    }
  }
}

internal object InventoryReportInventoryListingItemSerializer :
  KSerializer<InventoryReport.InventoryListing.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("item", CodeableReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InventoryReport.InventoryListing.Item>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryReport.InventoryListing.Item =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var quantity: Quantity? = null
      var item: CodeableReference? = null
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
          4 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            item =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Item: " + i)
        }
      }
      InventoryReport.InventoryListing.Item(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        category = category,
        quantity =
          quantity
            ?: throw SerializationException(
              "Missing required property 'quantity' on InventoryReport.InventoryListing.Item"
            ),
        item =
          item
            ?: throw SerializationException(
              "Missing required property 'item' on InventoryReport.InventoryListing.Item"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InventoryReport.InventoryListing.Item) {
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
      encodeSerializableElement(descriptor, 4, QuantitySerializer, value.quantity)
      encodeSerializableElement(descriptor, 5, CodeableReferenceSerializer, value.item)
    }
  }
}

internal object InventoryReportSerializer : FhirResourceSerializer<InventoryReport> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("InventoryReport")

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
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("countType", String.serializer().descriptor)
    b.optionalElement("_countType", ElementSerializer.descriptor)
    b.optionalElement("operationType", CodeableConceptSerializer.descriptor)
    b.optionalElement("operationTypeReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("reportedDateTime", String.serializer().descriptor)
    b.optionalElement("_reportedDateTime", ElementSerializer.descriptor)
    b.optionalElement("reporter", ReferenceSerializer.descriptor)
    b.optionalElement("reportingPeriod", PeriodSerializer.descriptor)
    b.optionalElement(
      "inventoryListing",
      InventoryReportInventoryListingSerializer.listSerializer.descriptor,
    )
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): InventoryReport {
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
    var status: String? = null
    var _status: Element? = null
    var countType: String? = null
    var _countType: Element? = null
    var operationType: CodeableConcept? = null
    var operationTypeReason: CodeableConcept? = null
    var reportedDateTime: String? = null
    var _reportedDateTime: Element? = null
    var reporter: Reference? = null
    var reportingPeriod: Period? = null
    var inventoryListing: List<InventoryReport.InventoryListing>? = null
    var note: List<Annotation>? = null
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> countType = decoder.decodeStringElement(descriptor, i)
        14 ->
          _countType =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          operationType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          operationTypeReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 -> reportedDateTime = decoder.decodeStringElement(descriptor, i)
        18 ->
          _reportedDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          reporter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          reportingPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        21 ->
          inventoryListing =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryReportInventoryListingSerializer.listSerializer,
              null,
            )
        22 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding InventoryReport: " + i)
      }
    }
    return InventoryReport(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) InventoryReport.InventoryReportStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on InventoryReport"),
      countType =
        Enumeration.of(
          if (countType != null) InventoryReport.InventoryCountType.fromCode(countType) else null,
          _countType,
        )
          ?: throw SerializationException(
            "Missing required property 'countType' on InventoryReport"
          ),
      operationType = operationType,
      operationTypeReason = operationTypeReason,
      reportedDateTime =
        DateTime.of(
          if (reportedDateTime != null) FhirDateTime.fromString(reportedDateTime) else null,
          _reportedDateTime,
        )
          ?: throw SerializationException(
            "Missing required property 'reportedDateTime' on InventoryReport"
          ),
      reporter = reporter,
      reportingPeriod = reportingPeriod,
      inventoryListing = inventoryListing ?: listOf(),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: InventoryReport,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.countType.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.countType)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.operationType,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.operationTypeReason,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.reportedDateTime.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.reportedDateTime)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.reporter,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      PeriodSerializer,
      value.reportingPeriod,
    )
    if (value.inventoryListing.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        InventoryReportInventoryListingSerializer.listSerializer,
        value.inventoryListing,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
