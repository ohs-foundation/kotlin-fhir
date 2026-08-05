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
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ChargeItem.Performer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ChargeItem.Performer {
    var id: String? = null
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
      actor =
        actor
          ?: throw SerializationException(
            "Missing required property 'actor' on ChargeItem.Performer"
          ),
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
          encounter =
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
          unitPriceComponent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.unitPriceComponentSer,
              null,
            )
        32 ->
          totalPriceComponent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.unitPriceComponentSer,
              null,
            )
        33 ->
          overrideReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        34 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        35 -> enteredDate = decoder.decodeStringElement(descriptor, i)
        36 ->
          _enteredDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 ->
          reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.bodysiteSer, null)
        38 ->
          service =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.serviceSer, null)
        39 ->
          product =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.serviceSer, null)
        40 ->
          account =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        41 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        42 ->
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
      status =
        Enumeration.of(
          ChargeItem.ChargeItemStatus.fromCode(
            status
              ?: throw SerializationException("Missing required property 'status' on ChargeItem")
          ),
          _status,
        ),
      partOf = partOf ?: listOf(),
      code = code ?: throw SerializationException("Missing required property 'code' on ChargeItem"),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on ChargeItem"),
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
    (value.encounter)?.let {
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
    (value.unitPriceComponent)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.unitPriceComponentSer,
        it,
      )
    }
    (value.totalPriceComponent)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.unitPriceComponentSer,
        it,
      )
    }
    (value.overrideReason)?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, Hoisted.codeSer, it)
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    ((value.enteredDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.enteredDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.bodysiteSer,
        value.reason,
      )
    if (value.service.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.serviceSer,
        value.service,
      )
    if (value.product.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.serviceSer,
        value.product,
      )
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.partOfSer,
        value.account,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
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
    encoder.encodeStructure(descriptor) {
      ChargeItemSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ChargeItem =
    decoder.decodeStructure(descriptor) {
      ChargeItemSerializer.deserializeInternal(this, descriptor, 0)
    }
}
