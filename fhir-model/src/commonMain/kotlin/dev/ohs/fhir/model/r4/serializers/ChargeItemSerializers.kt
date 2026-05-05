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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.ChargeItem
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          function =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actorSer, null)
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
    b.element("factorOverride", BigDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ChargeItem) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ChargeItem")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): ChargeItem {
    val __desc = desc
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
        11 ->
          definitionUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionUriSer, null)
        12 ->
          _definitionUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionUriSer2, null)
        13 ->
          definitionCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionUriSer, null)
        14 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionUriSer2, null)
        15 -> status = decoder.decodeStringElement(__desc, __i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
        18 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        20 ->
          context =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        21 -> occurrenceDateTime = decoder.decodeStringElement(__desc, __i)
        22 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        24 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.occurrenceTimingSer,
              null,
            )
        25 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerSer, null)
        26 ->
          performingOrganization =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        27 ->
          requestingOrganization =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        28 ->
          costCenter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        29 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        30 ->
          bodysite =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.bodysiteSer, null)
        31 ->
          factorOverride =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        32 ->
          _factorOverride =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        33 ->
          priceOverride =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.priceOverrideSer, null)
        34 -> overrideReason = decoder.decodeStringElement(__desc, __i)
        35 ->
          _overrideReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        36 ->
          enterer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        37 -> enteredDate = decoder.decodeStringElement(__desc, __i)
        38 ->
          _enteredDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        39 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.bodysiteSer, null)
        40 ->
          service = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
        41 ->
          productReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        42 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        43 ->
          account = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
        44 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        45 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
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
      overrideReason = R4String.of(overrideReason, _overrideReason),
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: ChargeItem,
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
    (value.definitionUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.definitionUriSer, it)
    }
    (value.definitionUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.definitionUriSer2, it)
    }
    (value.definitionCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.definitionUriSer, it)
    }
    (value.definitionCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.definitionUriSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.partOfSer, value.partOf)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.codeSer, it) }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.partOfSerInner, it)
    }
    (value.context)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.partOfSerInner, it)
    }
    when (val __d = value.occurrence) {
      null -> {}
      is ChargeItem.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is ChargeItem.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          __desc,
          23 + __off,
          Hoisted.occurrencePeriodSer,
          __d.value,
        )
      }
      is ChargeItem.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          __desc,
          24 + __off,
          Hoisted.occurrenceTimingSer,
          __d.value,
        )
      }
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.performerSer, value.performer)
    (value.performingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.partOfSerInner, it)
    }
    (value.requestingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.partOfSerInner, it)
    }
    (value.costCenter)?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.partOfSerInner, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.quantitySer, it)
    }
    if (value.bodysite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.bodysiteSer, value.bodysite)
    ((value.factorOverride?.value))?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, BigDecimalSerializer, it)
    }
    (value.factorOverride?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.priceOverride)?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.priceOverrideSer, it)
    }
    ((value.overrideReason?.value))?.let { encoder.encodeStringElement(__desc, 34 + __off, it) }
    (value.overrideReason?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.partOfSerInner, it)
    }
    ((value.enteredDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 37 + __off, it)
    }
    (value.enteredDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.bodysiteSer, value.reason)
    if (value.service.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.partOfSer, value.service)
    when (val __d = value.product) {
      null -> {}
      is ChargeItem.Product.Reference -> {
        encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.partOfSerInner, __d.value)
      }
      is ChargeItem.Product.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.codeSer, __d.value)
      }
    }
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.partOfSer, value.account)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.noteSer, value.note)
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        45 + __off,
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
      ChargeItemSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ChargeItem =
    decoder.decodeStructure(descriptor) {
      ChargeItemSerializer.deserializeJson(this, descriptor, 0)
    }
}
