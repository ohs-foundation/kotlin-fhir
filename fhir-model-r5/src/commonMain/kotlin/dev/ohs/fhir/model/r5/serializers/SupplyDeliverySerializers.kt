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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.SupplyDelivery
import dev.ohs.fhir.model.r5.Timing
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

internal object SupplyDeliverySuppliedItemSerializer : KSerializer<SupplyDelivery.SuppliedItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SuppliedItem") {
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
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("itemCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("itemReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SupplyDelivery.SuppliedItem =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SupplyDelivery.SuppliedItem) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SupplyDelivery.SuppliedItem {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var quantity: Quantity? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
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
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        5 ->
          itemReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SuppliedItem: " + i)
      }
    }
    return SupplyDelivery.SuppliedItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      quantity = quantity,
      item = SupplyDelivery.SuppliedItem.Item.from(itemCodeableConcept, itemReference),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SupplyDelivery.SuppliedItem) {
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
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.quantitySer, it)
    }
    when (val choice = value.item) {
      null -> {}
      is SupplyDelivery.SuppliedItem.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.itemCodeableConceptSer,
          choice.value,
        )
      }
      is SupplyDelivery.SuppliedItem.Item.Reference -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.itemReferenceSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val itemCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val itemReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object SupplyDeliverySerializer : KSerializer<SupplyDelivery> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupplyDelivery") {
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "suppliedItem",
      listSerialDescriptor(lazyDescriptor { SupplyDelivery.SuppliedItem.serializer().descriptor }),
      isOptional = true,
    )
    b.element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
    b.element("supplier", Reference.serializer().descriptor, isOptional = true)
    b.element("destination", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "receiver",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SupplyDelivery =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: SupplyDelivery) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SupplyDelivery")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SupplyDelivery {
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
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: String? = null
    var _status: Element? = null
    var patient: Reference? = null
    var type: CodeableConcept? = null
    var suppliedItem: List<SupplyDelivery.SuppliedItem>? = null
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    var supplier: Reference? = null
    var destination: Reference? = null
    var `receiver`: List<Reference>? = null
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
        11 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        12 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        16 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        17 ->
          suppliedItem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.suppliedItemSer, null)
        18 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        19 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        21 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceTimingSer,
              null,
            )
        22 ->
          supplier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        23 ->
          destination =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        24 ->
          `receiver` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        else -> throw SerializationException("Unexpected index decoding SupplyDelivery: " + i)
      }
    }
    return SupplyDelivery(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      status =
        status?.let { Enumeration.of(SupplyDelivery.SupplyDeliveryStatus.fromCode(it), _status) },
      patient = patient,
      type = type,
      suppliedItem = suppliedItem ?: listOf(),
      occurrence =
        SupplyDelivery.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
          occurrenceTiming,
        ),
      supplier = supplier,
      destination = destination,
      `receiver` = `receiver` ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SupplyDelivery,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.basedOnSer,
        value.partOf,
      )
    ((value.status?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.typeSer, it)
    }
    if (value.suppliedItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.suppliedItemSer,
        value.suppliedItem,
      )
    when (val choice = value.occurrence) {
      null -> {}
      is SupplyDelivery.Occurrence.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            19 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is SupplyDelivery.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          20 + descriptorOffset,
          Hoisted.occurrencePeriodSer,
          choice.value,
        )
      }
      is SupplyDelivery.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          Hoisted.occurrenceTimingSer,
          choice.value,
        )
      }
    }
    (value.supplier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    (value.destination)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.`receiver`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.basedOnSer,
        value.`receiver`,
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

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val suppliedItemSerInner: KSerializer<SupplyDelivery.SuppliedItem> =
      SupplyDelivery.SuppliedItem.serializer()

    public val suppliedItemSer: KSerializer<List<SupplyDelivery.SuppliedItem>> =
      ListSerializer(Hoisted.suppliedItemSerInner)

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurrenceTimingSer: KSerializer<Timing> = Timing.serializer()
  }
}

internal object SupplyDeliveryPolymorphicSerializer : KSerializer<SupplyDelivery> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupplyDelivery") { SupplyDeliverySerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: SupplyDelivery) {
    encoder.encodeStructure(descriptor) {
      SupplyDeliverySerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SupplyDelivery =
    decoder.decodeStructure(descriptor) {
      SupplyDeliverySerializer.deserializeInternal(this, descriptor, 0)
    }
}
