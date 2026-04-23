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

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItem.Performer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ChargeItem.Performer {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ChargeItem.Performer) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.function)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.functionSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ChargeItemOccurrenceSerializer : KSerializer<ChargeItem.Occurrence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItem.Occurrence") {
      element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ChargeItem.Occurrence) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ChargeItem.Occurrence.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ChargeItem.Occurrence.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.occurrencePeriodSer, __d.value)
        }
        is ChargeItem.Occurrence.Timing -> {
          encodeSerializableElement(__desc, 3, Hoisted.occurrenceTimingSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ChargeItem.Occurrence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ChargeItem.Occurrence {
    val __desc = descriptor
    var occurrenceDateTime: KotlinString? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.occurrencePeriodSer, null)
        3 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.occurrenceTimingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ChargeItem.Occurrence: " + __i)
      }
    }
    return ChargeItem.Occurrence.from(
      DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
      occurrencePeriod,
      occurrenceTiming,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurrenceTimingSer: KSerializer<Timing> = Timing.serializer()
  }
}

internal object ChargeItemProductSerializer : KSerializer<ChargeItem.Product> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItem.Product") {
      element("productReference", Reference.serializer().descriptor, isOptional = true)
      element("productCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ChargeItem.Product) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ChargeItem.Product.Reference -> {
          encodeSerializableElement(__desc, 0, Hoisted.productReferenceSer, __d.value)
        }
        is ChargeItem.Product.CodeableConcept -> {
          encodeSerializableElement(__desc, 1, Hoisted.productCodeableConceptSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ChargeItem.Product =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ChargeItem.Product {
    val __desc = descriptor
    var productReference: Reference? = null
    var productCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          productReference =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.productReferenceSer, null)
        1 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.productCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ChargeItem.Product: " + __i)
      }
    }
    return ChargeItem.Product.from(productReference, productCodeableConcept)!!
  }

  private object Hoisted {
    public val productReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val productCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()
  }
}

internal object ChargeItemSerializer : KSerializer<ChargeItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItem") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
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
      element(
        "definitionUri",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_definitionUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "definitionCanonical",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_definitionCanonical",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("context", Reference.serializer().descriptor, isOptional = true)
      element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(lazyDescriptor { ChargeItem.Performer.serializer().descriptor }),
        isOptional = true,
      )
      element("performingOrganization", Reference.serializer().descriptor, isOptional = true)
      element("requestingOrganization", Reference.serializer().descriptor, isOptional = true)
      element("costCenter", Reference.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element(
        "bodysite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("factorOverride", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factorOverride", Element.serializer().descriptor, isOptional = true)
      element("priceOverride", Money.serializer().descriptor, isOptional = true)
      element("overrideReason", KotlinString.serializer().descriptor, isOptional = true)
      element("_overrideReason", Element.serializer().descriptor, isOptional = true)
      element("enterer", Reference.serializer().descriptor, isOptional = true)
      element("enteredDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_enteredDate", Element.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("service", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("productReference", Reference.serializer().descriptor, isOptional = true)
      element("productCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("account", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "supportingInformation",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ChargeItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ChargeItem {
    val __desc = descriptor
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
    var factorOverride: BigDecimal? = null
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
        12 ->
          definitionUri =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.definitionUriSer, null)
        13 ->
          _definitionUri =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.definitionUriSer2, null)
        14 ->
          definitionCanonical =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.definitionUriSer, null)
        15 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.definitionUriSer2, null)
        16 -> status = decoder.decodeStringElement(__desc, 16)
        17 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.partOfSer, null)
        19 -> code = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.codeSer, null)
        20 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.partOfSerInner, null)
        21 ->
          context =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.partOfSerInner, null)
        22 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 22)
        23 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.occurrencePeriodSer, null)
        25 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.occurrenceTimingSer, null)
        26 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.performerSer, null)
        27 ->
          performingOrganization =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.partOfSerInner, null)
        28 ->
          requestingOrganization =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.partOfSerInner, null)
        29 ->
          costCenter =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.partOfSerInner, null)
        30 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.quantitySer, null)
        31 ->
          bodysite =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.bodysiteSer, null)
        32 ->
          factorOverride =
            decoder.decodeNullableSerializableElement(__desc, 32, BigDecimalSerializer, null)
        33 ->
          _factorOverride =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 ->
          priceOverride =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.priceOverrideSer, null)
        35 -> overrideReason = decoder.decodeStringElement(__desc, 35)
        36 ->
          _overrideReason =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 ->
          enterer =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.partOfSerInner, null)
        38 -> enteredDate = decoder.decodeStringElement(__desc, 38)
        39 ->
          _enteredDate =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.bodysiteSer, null)
        41 ->
          service = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.partOfSer, null)
        42 ->
          productReference =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.partOfSerInner, null)
        43 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.codeSer, null)
        44 ->
          account = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.partOfSer, null)
        45 -> note = decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.noteSer, null)
        46 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.partOfSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ChargeItem: " + __i)
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
        (kotlin.collections.List(maxOf(definitionUri?.size ?: 0, _definitionUri?.size ?: 0)) { __i
          ->
          Uri.of(definitionUri?.getOrNull(__i)?.let { it }, _definitionUri?.getOrNull(__i))!!
        }),
      definitionCanonical =
        (kotlin.collections.List(
          maxOf(definitionCanonical?.size ?: 0, _definitionCanonical?.size ?: 0)
        ) { __i ->
          Canonical.of(
            definitionCanonical?.getOrNull(__i)?.let { it },
            _definitionCanonical?.getOrNull(__i),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ChargeItem) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ChargeItem")
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
    (value.definitionUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.definitionUriSer, it)
    }
    (value.definitionUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.definitionUriSer2, it)
    }
    (value.definitionCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.definitionUriSer, it)
    }
    (value.definitionCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.definitionUriSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.partOfSer, value.partOf)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.codeSer, it) }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.partOfSerInner, it)
    }
    (value.context)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.partOfSerInner, it)
    }
    when (val __d = value.occurrence) {
      null -> {}
      is ChargeItem.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
        }
      }
      is ChargeItem.Occurrence.Period -> {
        encoder.encodeSerializableElement(__desc, 24, Hoisted.occurrencePeriodSer, __d.value)
      }
      is ChargeItem.Occurrence.Timing -> {
        encoder.encodeSerializableElement(__desc, 25, Hoisted.occurrenceTimingSer, __d.value)
      }
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.performerSer, value.performer)
    (value.performingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.partOfSerInner, it)
    }
    (value.requestingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.partOfSerInner, it)
    }
    (value.costCenter)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.partOfSerInner, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 30, Hoisted.quantitySer, it) }
    if (value.bodysite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.bodysiteSer, value.bodysite)
    ((value.factorOverride?.value))?.let {
      encoder.encodeSerializableElement(__desc, 32, BigDecimalSerializer, it)
    }
    (value.factorOverride?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    (value.priceOverride)?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.priceOverrideSer, it)
    }
    ((value.overrideReason?.value))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.overrideReason?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.partOfSerInner, it)
    }
    ((value.enteredDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.enteredDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.bodysiteSer, value.reason)
    if (value.service.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.partOfSer, value.service)
    when (val __d = value.product) {
      null -> {}
      is ChargeItem.Product.Reference -> {
        encoder.encodeSerializableElement(__desc, 42, Hoisted.partOfSerInner, __d.value)
      }
      is ChargeItem.Product.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 43, Hoisted.codeSer, __d.value)
      }
    }
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.partOfSer, value.account)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.noteSer, value.note)
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.partOfSer, value.supportingInformation)
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
