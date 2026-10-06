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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.ChargeItem
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
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

internal object ChargeItemPerformerSerializer : KSerializer<ChargeItem.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ChargeItem.Performer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ChargeItem.Performer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var function: CodeableConcept? = null
      var actor: Reference? = null
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
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Performer: " + i)
        }
      }
      ChargeItem.Performer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        function = function,
        actor =
          actor
            ?: throw SerializationException(
              "Missing required property 'actor' on ChargeItem.Performer"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ChargeItem.Performer) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.function)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    }
  }
}

internal object ChargeItemSerializer : FhirResourceSerializer<ChargeItem> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ChargeItem")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("definitionUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_definitionUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("definitionCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_definitionCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("context", ReferenceSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurrencePeriod", PeriodSerializer.descriptor)
    b.optionalElement("occurrenceTiming", TimingSerializer.descriptor)
    b.optionalElement("performer", ChargeItemPerformerSerializer.listSerializer.descriptor)
    b.optionalElement("performingOrganization", ReferenceSerializer.descriptor)
    b.optionalElement("requestingOrganization", ReferenceSerializer.descriptor)
    b.optionalElement("costCenter", ReferenceSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("bodysite", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("factorOverride", FhirDecimalSerializer.descriptor)
    b.optionalElement("_factorOverride", ElementSerializer.descriptor)
    b.optionalElement("priceOverride", MoneySerializer.descriptor)
    b.optionalElement("overrideReason", KotlinString.serializer().descriptor)
    b.optionalElement("_overrideReason", ElementSerializer.descriptor)
    b.optionalElement("enterer", ReferenceSerializer.descriptor)
    b.optionalElement("enteredDate", KotlinString.serializer().descriptor)
    b.optionalElement("_enteredDate", ElementSerializer.descriptor)
    b.optionalElement("reason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("service", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("productReference", ReferenceSerializer.descriptor)
    b.optionalElement("productCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("account", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ChargeItem {
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
    var identifier: List<Identifier>? = null
    var definitionUri: List<KotlinString?>? = null
    var _definitionUri: List<Element?>? = null
    var definitionCanonical: List<KotlinString?>? = null
    var _definitionCanonical: List<Element?>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var partOf: List<Reference>? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var context: Reference? = null
    var occurrenceDateTime: KotlinString? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    var performer: List<ChargeItem.Performer>? = null
    var performingOrganization: Reference? = null
    var requestingOrganization: Reference? = null
    var costCenter: Reference? = null
    var quantity: Quantity? = null
    var bodysite: List<CodeableConcept>? = null
    var factorOverride: FhirDecimal? = null
    var _factorOverride: Element? = null
    var priceOverride: Money? = null
    var overrideReason: KotlinString? = null
    var _overrideReason: Element? = null
    var enterer: Reference? = null
    var enteredDate: KotlinString? = null
    var _enteredDate: Element? = null
    var reason: List<CodeableConcept>? = null
    var service: List<Reference>? = null
    var productReference: Reference? = null
    var productCodeableConcept: CodeableConcept? = null
    var account: List<Reference>? = null
    var note: List<Annotation>? = null
    var supportingInformation: List<Reference>? = null
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
        11 ->
          definitionUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _definitionUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          definitionCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        22 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        24 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        25 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ChargeItemPerformerSerializer.listSerializer,
              null,
            )
        26 ->
          performingOrganization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          requestingOrganization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          costCenter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        30 ->
          bodysite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 ->
          factorOverride =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        32 ->
          _factorOverride =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          priceOverride =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        34 -> overrideReason = decoder.decodeStringElement(descriptor, i)
        35 ->
          _overrideReason =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        37 -> enteredDate = decoder.decodeStringElement(descriptor, i)
        38 ->
          _enteredDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        40 ->
          service =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        41 ->
          productReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        42 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        43 ->
          account =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        44 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        45 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ChargeItem: " + i)
      }
    }
    return ChargeItem(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      definitionUri =
        (kotlin.collections.List(maxOf(definitionUri?.size ?: 0, _definitionUri?.size ?: 0)) { index
          ->
          Uri.of(definitionUri?.getOrNull(index), _definitionUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'definitionUri' on ChargeItem has neither a value nor an id/extension"
            )
        }),
      definitionCanonical =
        (kotlin.collections.List(
          maxOf(definitionCanonical?.size ?: 0, _definitionCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            definitionCanonical?.getOrNull(index),
            _definitionCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'definitionCanonical' on ChargeItem has neither a value nor an id/extension"
            )
        }),
      status =
        Enumeration.of(
          if (status != null) ChargeItem.ChargeItemStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on ChargeItem"),
      partOf = partOf ?: listOf(),
      code = code ?: throw SerializationException("Missing required property 'code' on ChargeItem"),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on ChargeItem"),
      context = context,
      occurrence =
        ChargeItem.Occurrence.from(
          DateTime.of(
            if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
            _occurrenceDateTime,
          ),
          occurrencePeriod,
          occurrenceTiming,
        ),
      performer = performer ?: listOf(),
      performingOrganization = performingOrganization,
      requestingOrganization = requestingOrganization,
      costCenter = costCenter,
      quantity = quantity,
      bodysite = bodysite ?: listOf(),
      factorOverride = Decimal.of(factorOverride, _factorOverride),
      priceOverride = priceOverride,
      overrideReason = R4bString.of(overrideReason, _overrideReason),
      enterer = enterer,
      enteredDate =
        DateTime.of(
          if (enteredDate != null) FhirDateTime.fromString(enteredDate) else null,
          _enteredDate,
        ),
      reason = reason ?: listOf(),
      service = service ?: listOf(),
      product = ChargeItem.Product.from(productReference, productCodeableConcept),
      account = account ?: listOf(),
      note = note ?: listOf(),
      supportingInformation = supportingInformation ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ChargeItem,
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
    if (value.definitionUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.definitionUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 12 + descriptorOffset, value.definitionUri)
    }
    if (value.definitionCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.definitionCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        14 + descriptorOffset,
        value.definitionCanonical,
      )
    }
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.status)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.context,
    )
    when (val choice = value.occurrence) {
      null -> {}
      is ChargeItem.Occurrence.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          21 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, choice.value)
      }
      is ChargeItem.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is ChargeItem.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ChargeItemPerformerSerializer.listSerializer,
        value.performer,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.performingOrganization,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.requestingOrganization,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.costCenter,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    if (value.bodysite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.bodysite,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      FhirDecimalSerializer,
      value.factorOverride?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.factorOverride)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      MoneySerializer,
      value.priceOverride,
    )
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.overrideReason?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.overrideReason)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      36 + descriptorOffset,
      ReferenceSerializer,
      value.enterer,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.enteredDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.enteredDate)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reason,
      )
    if (value.service.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.service,
      )
    when (val choice = value.product) {
      null -> {}
      is ChargeItem.Product.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          41 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ChargeItem.Product.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          42 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.account,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
  }
}
