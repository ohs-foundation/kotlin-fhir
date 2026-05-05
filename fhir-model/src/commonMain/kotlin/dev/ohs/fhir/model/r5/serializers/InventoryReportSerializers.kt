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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.InventoryReport
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
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

internal object InventoryReportInventoryListingSerializer :
  KSerializer<InventoryReport.InventoryListing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InventoryListing") {
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
      element("location", Reference.serializer().descriptor, isOptional = true)
      element("itemStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element("countingDateTime", String.serializer().descriptor, isOptional = true)
      element("_countingDateTime", Element.serializer().descriptor, isOptional = true)
      element(
        "item",
        listSerialDescriptor(
          lazyDescriptor { InventoryReport.InventoryListing.Item.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): InventoryReport.InventoryListing =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryReport.InventoryListing) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): InventoryReport.InventoryListing {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var location: Reference? = null
    var itemStatus: CodeableConcept? = null
    var countingDateTime: String? = null
    var _countingDateTime: Element? = null
    var item: List<InventoryReport.InventoryListing.Item>? = null
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
          location = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.locationSer, null)
        4 ->
          itemStatus =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.itemStatusSer, null)
        5 -> countingDateTime = decoder.decodeStringElement(__desc, 5)
        6 ->
          _countingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.countingDateTimeSer, null)
        7 -> item = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding InventoryListing: " + __i)
      }
    }
    return InventoryReport.InventoryListing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      location = location,
      itemStatus = itemStatus,
      countingDateTime = DateTime.of(FhirDateTime.fromString(countingDateTime), _countingDateTime),
      item = item ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: InventoryReport.InventoryListing) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.locationSer, it) }
    (value.itemStatus)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.itemStatusSer, it)
    }
    ((value.countingDateTime?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 5, it)
    }
    (value.countingDateTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.countingDateTimeSer, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.itemSer, value.item)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val locationSer: KSerializer<Reference> = Reference.serializer()

    public val itemStatusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val countingDateTimeSer: KSerializer<Element> = Element.serializer()

    public val itemSerInner: KSerializer<InventoryReport.InventoryListing.Item> =
      InventoryReport.InventoryListing.Item.serializer()

    public val itemSer: KSerializer<List<InventoryReport.InventoryListing.Item>> =
      ListSerializer(Hoisted.itemSerInner)
  }
}

internal object InventoryReportInventoryListingItemSerializer :
  KSerializer<InventoryReport.InventoryListing.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("item", CodeableReference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): InventoryReport.InventoryListing.Item =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryReport.InventoryListing.Item) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): InventoryReport.InventoryListing.Item {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var quantity: Quantity? = null
    var item: CodeableReference? = null
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
          quantity = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.quantitySer, null)
        5 -> item = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + __i)
      }
    }
    return InventoryReport.InventoryListing.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      quantity = quantity!!,
      item = item!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: InventoryReport.InventoryListing.Item,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.quantitySer, it) }
    (value.item)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.itemSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val itemSer: KSerializer<CodeableReference> = CodeableReference.serializer()
  }
}

internal object InventoryReportSerializer : KSerializer<InventoryReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InventoryReport") {
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
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("countType", String.serializer().descriptor, isOptional = true)
    b.element("_countType", Element.serializer().descriptor, isOptional = true)
    b.element("operationType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("operationTypeReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("reportedDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_reportedDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("reporter", Reference.serializer().descriptor, isOptional = true)
    b.element("reportingPeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "inventoryListing",
      listSerialDescriptor(
        lazyDescriptor { InventoryReport.InventoryListing.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): InventoryReport =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryReport) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "InventoryReport")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): InventoryReport {
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> countType = decoder.decodeStringElement(__desc, 14)
        15 ->
          _countType =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          operationType =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.operationTypeSer, null)
        17 ->
          operationTypeReason =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.operationTypeSer, null)
        18 -> reportedDateTime = decoder.decodeStringElement(__desc, 18)
        19 ->
          _reportedDateTime =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          reporter =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.reporterSer, null)
        21 ->
          reportingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.reportingPeriodSer, null)
        22 ->
          inventoryListing =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.inventoryListingSer, null)
        23 -> note = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding InventoryReport: " + __i)
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
      status = Enumeration.of(InventoryReport.InventoryReportStatus.fromCode(status!!), _status),
      countType =
        Enumeration.of(InventoryReport.InventoryCountType.fromCode(countType!!), _countType),
      operationType = operationType,
      operationTypeReason = operationTypeReason,
      reportedDateTime =
        DateTime.of(FhirDateTime.fromString(reportedDateTime), _reportedDateTime)!!,
      reporter = reporter,
      reportingPeriod = reportingPeriod,
      inventoryListing = inventoryListing ?: listOf(),
      note = note ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: InventoryReport) {
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.countType.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.countType.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    (value.operationType)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.operationTypeSer, it)
    }
    (value.operationTypeReason)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.operationTypeSer, it)
    }
    ((value.reportedDateTime.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 18, it)
    }
    (value.reportedDateTime.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    (value.reporter)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.reporterSer, it) }
    (value.reportingPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.reportingPeriodSer, it)
    }
    if (value.inventoryListing.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22,
        Hoisted.inventoryListingSer,
        value.inventoryListing,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.noteSer, value.note)
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

    public val operationTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reporterSer: KSerializer<Reference> = Reference.serializer()

    public val reportingPeriodSer: KSerializer<Period> = Period.serializer()

    public val inventoryListingSerInner: KSerializer<InventoryReport.InventoryListing> =
      InventoryReport.InventoryListing.serializer()

    public val inventoryListingSer: KSerializer<List<InventoryReport.InventoryListing>> =
      ListSerializer(Hoisted.inventoryListingSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object InventoryReportPolymorphicSerializer : KSerializer<InventoryReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InventoryReport") {
      InventoryReportSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryReport) {
    encoder.encodeStructure(descriptor) { InventoryReportSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): InventoryReport =
    decoder.decodeStructure(descriptor) { InventoryReportSerializer.deserializeJson(this) }
}
