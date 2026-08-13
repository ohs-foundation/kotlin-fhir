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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.InventoryReport
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryReport.InventoryListing) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InventoryReport.InventoryListing {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var location: Reference? = null
    var itemStatus: CodeableConcept? = null
    var countingDateTime: String? = null
    var _countingDateTime: Element? = null
    var item: List<InventoryReport.InventoryListing.Item>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        4 ->
          itemStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemStatusSer, null)
        5 -> countingDateTime = decoder.decodeStringElement(descriptor, i)
        6 ->
          _countingDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.countingDateTimeSer,
              null,
            )
        7 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding InventoryListing: " + i)
      }
    }
    return InventoryReport.InventoryListing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      location = location,
      itemStatus = itemStatus,
      countingDateTime =
        DateTime.of(countingDateTime?.let { FhirDateTime.fromString(it) }, _countingDateTime),
      item = item ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: InventoryReport.InventoryListing,
  ) {
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
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.locationSer, it)
    }
    (value.itemStatus)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.itemStatusSer, it)
    }
    ((value.countingDateTime?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 5, it)
    }
    (value.countingDateTime?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.countingDateTimeSer, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.itemSer, value.item)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryReport.InventoryListing.Item) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): InventoryReport.InventoryListing.Item {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var quantity: Quantity? = null
    var item: CodeableReference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        5 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    return InventoryReport.InventoryListing.Item(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: InventoryReport.InventoryListing.Item,
  ) {
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
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.quantitySer, value.quantity)
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.itemSer, value.item)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryReport) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "InventoryReport")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> countType = decoder.decodeStringElement(descriptor, i)
        14 ->
          _countType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          operationType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationTypeSer, null)
        16 ->
          operationTypeReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationTypeSer, null)
        17 -> reportedDateTime = decoder.decodeStringElement(descriptor, i)
        18 ->
          _reportedDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          reporter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reporterSer, null)
        20 ->
          reportingPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reportingPeriodSer,
              null,
            )
        21 ->
          inventoryListing =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.inventoryListingSer,
              null,
            )
        22 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
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
          InventoryReport.InventoryReportStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on InventoryReport"
              )
          ),
          _status,
        ),
      countType =
        Enumeration.of(
          InventoryReport.InventoryCountType.fromCode(
            countType
              ?: throw SerializationException(
                "Missing required property 'countType' on InventoryReport"
              )
          ),
          _countType,
        ),
      operationType = operationType,
      operationTypeReason = operationTypeReason,
      reportedDateTime =
        DateTime.of(reportedDateTime?.let { FhirDateTime.fromString(it) }, _reportedDateTime)
          ?: throw SerializationException(
            "Missing required property 'reportedDateTime' on InventoryReport"
          ),
      reporter = reporter,
      reportingPeriod = reportingPeriod,
      inventoryListing = inventoryListing ?: listOf(),
      note = note ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: InventoryReport,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.countType.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.countType.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.operationType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.operationTypeSer,
        it,
      )
    }
    (value.operationTypeReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.operationTypeSer,
        it,
      )
    }
    ((value.reportedDateTime.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.reportedDateTime.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.reporter)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.reporterSer, it)
    }
    (value.reportingPeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.reportingPeriodSer,
        it,
      )
    }
    if (value.inventoryListing.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.inventoryListingSer,
        value.inventoryListing,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
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
    encoder.encodeStructure(descriptor) {
      InventoryReportSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): InventoryReport =
    decoder.decodeStructure(descriptor) {
      InventoryReportSerializer.deserializeInternal(this, descriptor, 0)
    }
}
