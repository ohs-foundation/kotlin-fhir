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
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.ChargeItem
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.MonetaryComponent
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import kotlin.String
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
    var id: String? = null
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

internal object ChargeItemSerializer : KSerializer<ChargeItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItem") {
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
    b.element(
      "definitionUri",
      listSerialDescriptor(String.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_definitionUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "definitionCanonical",
      listSerialDescriptor(String.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_definitionCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
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
    b.element("unitPriceComponent", MonetaryComponent.serializer().descriptor, isOptional = true)
    b.element("totalPriceComponent", MonetaryComponent.serializer().descriptor, isOptional = true)
    b.element("overrideReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("enterer", Reference.serializer().descriptor, isOptional = true)
    b.element("enteredDate", String.serializer().descriptor, isOptional = true)
    b.element("_enteredDate", Element.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "service",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "product",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("account", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "supportingInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ChargeItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItem) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ChargeItem")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ChargeItem {
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
    var definitionUri: List<String?>? = null
    var _definitionUri: List<Element?>? = null
    var definitionCanonical: List<String?>? = null
    var _definitionCanonical: List<Element?>? = null
    var status: String? = null
    var _status: Element? = null
    var partOf: List<Reference>? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    var performer: List<ChargeItem.Performer>? = null
    var performingOrganization: Reference? = null
    var requestingOrganization: Reference? = null
    var costCenter: Reference? = null
    var quantity: Quantity? = null
    var bodysite: List<CodeableConcept>? = null
    var unitPriceComponent: MonetaryComponent? = null
    var totalPriceComponent: MonetaryComponent? = null
    var overrideReason: CodeableConcept? = null
    var enterer: Reference? = null
    var enteredDate: String? = null
    var _enteredDate: Element? = null
    var reason: List<CodeableConcept>? = null
    var service: List<CodeableReference>? = null
    var product: List<CodeableReference>? = null
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
          encounter =
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
          unitPriceComponent =
            decoder.decodeNullableSerializableElement(
              __desc,
              32,
              Hoisted.unitPriceComponentSer,
              null,
            )
        33 ->
          totalPriceComponent =
            decoder.decodeNullableSerializableElement(
              __desc,
              33,
              Hoisted.unitPriceComponentSer,
              null,
            )
        34 ->
          overrideReason =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.codeSer, null)
        35 ->
          enterer =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.partOfSerInner, null)
        36 -> enteredDate = decoder.decodeStringElement(__desc, 36)
        37 ->
          _enteredDate =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.bodysiteSer, null)
        39 ->
          service = decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.serviceSer, null)
        40 ->
          product = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.serviceSer, null)
        41 ->
          account = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.partOfSer, null)
        42 -> note = decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.noteSer, null)
        43 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.partOfSer, null)
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
      encounter = encounter,
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
      unitPriceComponent = unitPriceComponent,
      totalPriceComponent = totalPriceComponent,
      overrideReason = overrideReason,
      enterer = enterer,
      enteredDate = DateTime.of(FhirDateTime.fromString(enteredDate), _enteredDate),
      reason = reason ?: listOf(),
      service = service ?: listOf(),
      product = product ?: listOf(),
      account = account ?: listOf(),
      note = note ?: listOf(),
      supportingInformation = supportingInformation ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: ChargeItem) {
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
    (value.encounter)?.let {
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
    (value.unitPriceComponent)?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.unitPriceComponentSer, it)
    }
    (value.totalPriceComponent)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.unitPriceComponentSer, it)
    }
    (value.overrideReason)?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.codeSer, it)
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.partOfSerInner, it)
    }
    ((value.enteredDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.enteredDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.bodysiteSer, value.reason)
    if (value.service.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.serviceSer, value.service)
    if (value.product.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.serviceSer, value.product)
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.partOfSer, value.account)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.noteSer, value.note)
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43, Hoisted.partOfSer, value.supportingInformation)
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

    public val definitionUriSerInner: KSerializer<String> = String.serializer()

    public val definitionUriSer: KSerializer<List<String?>> =
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

    public val unitPriceComponentSer: KSerializer<MonetaryComponent> =
      MonetaryComponent.serializer()

    public val serviceSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val serviceSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.serviceSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object ChargeItemPolymorphicSerializer : KSerializer<ChargeItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItem") { ChargeItemSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItem) {
    encoder.encodeStructure(descriptor) { ChargeItemSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): ChargeItem =
    decoder.decodeStructure(descriptor) { ChargeItemSerializer.deserializeJson(this) }
}
