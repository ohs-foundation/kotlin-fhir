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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
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

internal object ChargeItemPerformerSerializer : KSerializer<ChargeItem.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ChargeItem.Performer =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ChargeItem.Performer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ChargeItem.Performer {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.functionSer, null)
        4 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + i)
      }
    }
    return ChargeItem.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ChargeItem.Performer) {
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
    (value.function)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.functionSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.actorSer, value.actor)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ChargeItemSerializer : KSerializer<ChargeItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItem") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "definitionUri",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_definitionUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "definitionCanonical",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_definitionCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("context", Reference.serializer().descriptor, isOptional = true)
    b.element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(lazyDescriptor { ChargeItem.Performer.serializer().descriptor }),
      isOptional = true,
    )
    b.element("performingOrganization", Reference.serializer().descriptor, isOptional = true)
    b.element("requestingOrganization", Reference.serializer().descriptor, isOptional = true)
    b.element("costCenter", Reference.serializer().descriptor, isOptional = true)
    b.element("quantity", Quantity.serializer().descriptor, isOptional = true)
    b.element(
      "bodysite",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("factorOverride", FhirDecimalSerializer.descriptor, isOptional = true)
    b.element("_factorOverride", Element.serializer().descriptor, isOptional = true)
    b.element("priceOverride", Money.serializer().descriptor, isOptional = true)
    b.element("overrideReason", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_overrideReason", Element.serializer().descriptor, isOptional = true)
    b.element("enterer", Reference.serializer().descriptor, isOptional = true)
    b.element("enteredDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_enteredDate", Element.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("service", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("productReference", Reference.serializer().descriptor, isOptional = true)
    b.element("productCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("account", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "supportingInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ChargeItem =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ChargeItem) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ChargeItem")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
          definitionUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.definitionUriSer, null)
        12 ->
          _definitionUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionUriSer2,
              null,
            )
        13 ->
          definitionCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.definitionUriSer, null)
        14 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionUriSer2,
              null,
            )
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          partOf = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        18 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        20 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        21 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        22 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        24 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceTimingSer,
              null,
            )
        25 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        26 ->
          performingOrganization =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        27 ->
          requestingOrganization =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        28 ->
          costCenter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        29 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        30 ->
          bodysite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.bodysiteSer, null)
        31 ->
          factorOverride =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        32 ->
          _factorOverride =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 ->
          priceOverride =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.priceOverrideSer, null)
        34 -> overrideReason = decoder.decodeStringElement(descriptor, i)
        35 ->
          _overrideReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        37 -> enteredDate = decoder.decodeStringElement(descriptor, i)
        38 ->
          _enteredDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 ->
          reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.bodysiteSer, null)
        40 ->
          service =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        41 ->
          productReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        42 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        43 ->
          account =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        44 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        45 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
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
          Uri.of(definitionUri?.getOrNull(index)?.let { it }, _definitionUri?.getOrNull(index))!!
        }),
      definitionCanonical =
        (kotlin.collections.List(
          maxOf(definitionCanonical?.size ?: 0, _definitionCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            definitionCanonical?.getOrNull(index)?.let { it },
            _definitionCanonical?.getOrNull(index),
          )!!
        }),
      status = Enumeration.of(ChargeItem.ChargeItemStatus.fromCode(status!!), _status),
      partOf = partOf ?: listOf(),
      code = code!!,
      subject = subject!!,
      context = context,
      occurrence =
        ChargeItem.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
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
      enteredDate = DateTime.of(FhirDateTime.fromString(enteredDate), _enteredDate),
      reason = reason ?: listOf(),
      service = service ?: listOf(),
      product = ChargeItem.Product.from(productReference, productCodeableConcept),
      account = account ?: listOf(),
      note = note ?: listOf(),
      supportingInformation = supportingInformation ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ChargeItem,
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
    (value.definitionUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.definitionUriSer,
        it,
      )
    }
    (value.definitionUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.definitionUriSer2,
        it,
      )
    }
    (value.definitionCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.definitionUriSer,
        it,
      )
    }
    (value.definitionCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.definitionUriSer2,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.partOfSer,
        value.partOf,
      )
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      Hoisted.codeSer,
      value.code,
    )
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      Hoisted.partOfSerInner,
      value.subject,
    )
    (value.context)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    when (val choice = value.occurrence) {
      null -> {}
      is ChargeItem.Occurrence.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            22 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is ChargeItem.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          Hoisted.occurrencePeriodSer,
          choice.value,
        )
      }
      is ChargeItem.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          Hoisted.occurrenceTimingSer,
          choice.value,
        )
      }
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.performerSer,
        value.performer,
      )
    (value.performingOrganization)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    (value.requestingOrganization)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    (value.costCenter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.quantitySer, it)
    }
    if (value.bodysite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.bodysiteSer,
        value.bodysite,
      )
    ((value.factorOverride?.value))?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        FhirDecimalSerializer,
        it,
      )
    }
    (value.factorOverride?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.priceOverride)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.priceOverrideSer,
        it,
      )
    }
    ((value.overrideReason?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.overrideReason?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    ((value.enteredDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.enteredDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.bodysiteSer,
        value.reason,
      )
    if (value.service.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.partOfSer,
        value.service,
      )
    when (val choice = value.product) {
      null -> {}
      is ChargeItem.Product.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          41 + descriptorOffset,
          Hoisted.partOfSerInner,
          choice.value,
        )
      }
      is ChargeItem.Product.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          42 + descriptorOffset,
          Hoisted.codeSer,
          choice.value,
        )
      }
    }
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.partOfSer,
        value.account,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.partOfSer,
        value.supportingInformation,
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

    public val definitionUriSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val definitionUriSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.definitionUriSerInner).nullable)

    public val definitionUriSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val partOfSerInner: KSerializer<Reference> = Reference.serializer()

    public val partOfSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.partOfSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurrenceTimingSer: KSerializer<Timing> = Timing.serializer()

    public val performerSerInner: KSerializer<ChargeItem.Performer> =
      ChargeItem.Performer.serializer()

    public val performerSer: KSerializer<List<ChargeItem.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val bodysiteSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSer)

    public val priceOverrideSer: KSerializer<Money> = Money.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object ChargeItemPolymorphicSerializer : KSerializer<ChargeItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItem") { ChargeItemSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItem) {
    encoder.encodeStructure(descriptor) {
      ChargeItemSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ChargeItem =
    decoder.decodeStructure(descriptor) {
      ChargeItemSerializer.deserializeInternal(this, descriptor, 0)
    }
}
