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
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
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

internal object MedicationAdministrationPerformerSerializer :
  KSerializer<MedicationAdministration.Performer> {
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
      element("actor", CodeableReference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationAdministration.Performer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Performer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationAdministration.Performer {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: CodeableReference? = null
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
    return MedicationAdministration.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationAdministration.Performer,
  ) {
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

    public val actorSer: KSerializer<CodeableReference> = CodeableReference.serializer()
  }
}

internal object MedicationAdministrationDosageSerializer :
  KSerializer<MedicationAdministration.Dosage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage") {
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
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element("site", CodeableConcept.serializer().descriptor, isOptional = true)
      element("route", CodeableConcept.serializer().descriptor, isOptional = true)
      element("method", CodeableConcept.serializer().descriptor, isOptional = true)
      element("dose", Quantity.serializer().descriptor, isOptional = true)
      element("rateRatio", Ratio.serializer().descriptor, isOptional = true)
      element("rateQuantity", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationAdministration.Dosage =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Dosage) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationAdministration.Dosage {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var site: CodeableConcept? = null
    var route: CodeableConcept? = null
    var method: CodeableConcept? = null
    var dose: Quantity? = null
    var rateRatio: Ratio? = null
    var rateQuantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> text = decoder.decodeStringElement(__desc, __i)
        4 -> _text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        5 -> site = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.siteSer, null)
        6 -> route = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.siteSer, null)
        7 -> method = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.siteSer, null)
        8 -> dose = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.doseSer, null)
        9 ->
          rateRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.rateRatioSer, null)
        10 ->
          rateQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.doseSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dosage: " + __i)
      }
    }
    return MedicationAdministration.Dosage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      text = R5String.of(text, _text),
      site = site,
      route = route,
      method = method,
      dose = dose,
      rate = MedicationAdministration.Dosage.Rate.from(rateRatio, rateQuantity),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationAdministration.Dosage) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.textSer, it)
    }
    (value.site)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.siteSer, it) }
    (value.route)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.siteSer, it) }
    (value.method)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.siteSer, it) }
    (value.dose)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.doseSer, it) }
    when (val __d = value.rate) {
      null -> {}
      is MedicationAdministration.Dosage.Rate.Ratio -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.rateRatioSer, __d.value)
      }
      is MedicationAdministration.Dosage.Rate.Quantity -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.doseSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val textSer: KSerializer<Element> = Element.serializer()

    public val siteSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val doseSer: KSerializer<Quantity> = Quantity.serializer()

    public val rateRatioSer: KSerializer<Ratio> = Ratio.serializer()
  }
}

internal object MedicationAdministrationSerializer : KSerializer<MedicationAdministration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationAdministration") {
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "statusReason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("medication", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "supportingInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("occurenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurencePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("occurenceTiming", Timing.serializer().descriptor, isOptional = true)
    b.element("recorded", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_recorded", Element.serializer().descriptor, isOptional = true)
    b.element("isSubPotent", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_isSubPotent", Element.serializer().descriptor, isOptional = true)
    b.element(
      "subPotentReason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "performer",
      listSerialDescriptor(
        lazyDescriptor { MedicationAdministration.Performer.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("request", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "device",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "dosage",
      lazyDescriptor { MedicationAdministration.Dosage.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "eventHistory",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicationAdministration")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): MedicationAdministration {
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
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: List<CodeableConcept>? = null
    var category: List<CodeableConcept>? = null
    var medication: CodeableReference? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var supportingInformation: List<Reference>? = null
    var occurenceDateTime: KotlinString? = null
    var _occurenceDateTime: Element? = null
    var occurencePeriod: Period? = null
    var occurenceTiming: Timing? = null
    var recorded: KotlinString? = null
    var _recorded: Element? = null
    var isSubPotent: KotlinBoolean? = null
    var _isSubPotent: Element? = null
    var subPotentReason: List<CodeableConcept>? = null
    var performer: List<MedicationAdministration.Performer>? = null
    var reason: List<CodeableReference>? = null
    var request: Reference? = null
    var device: List<CodeableReference>? = null
    var note: List<Annotation>? = null
    var dosage: MedicationAdministration.Dosage? = null
    var eventHistory: List<Reference>? = null
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
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        12 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(__desc, __i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        16 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        17 ->
          medication =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.medicationSer, null)
        18 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        20 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        21 -> occurenceDateTime = decoder.decodeStringElement(__desc, __i)
        22 ->
          _occurenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 ->
          occurencePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.occurencePeriodSer, null)
        24 ->
          occurenceTiming =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.occurenceTimingSer, null)
        25 -> recorded = decoder.decodeStringElement(__desc, __i)
        26 ->
          _recorded =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 -> isSubPotent = decoder.decodeBooleanElement(__desc, __i)
        28 ->
          _isSubPotent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        29 ->
          subPotentReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        30 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerSer, null)
        31 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        32 ->
          request =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        33 ->
          device = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        34 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        35 ->
          dosage = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dosageSer, null)
        36 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        else ->
          throw SerializationException("Unexpected index decoding MedicationAdministration: " + __i)
      }
    }
    return MedicationAdministration(
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
        Enumeration.of(
          MedicationAdministration.MedicationAdministrationStatusCodes.fromCode(status!!),
          _status,
        ),
      statusReason = statusReason ?: listOf(),
      category = category ?: listOf(),
      medication = medication!!,
      subject = subject!!,
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      occurence =
        MedicationAdministration.Occurence.from(
          DateTime.of(FhirDateTime.fromString(occurenceDateTime), _occurenceDateTime),
          occurencePeriod,
          occurenceTiming,
        )!!,
      recorded = DateTime.of(FhirDateTime.fromString(recorded), _recorded),
      isSubPotent = R5Boolean.of(isSubPotent, _isSubPotent),
      subPotentReason = subPotentReason ?: listOf(),
      performer = performer ?: listOf(),
      reason = reason ?: listOf(),
      request = request,
      device = device ?: listOf(),
      note = note ?: listOf(),
      dosage = dosage,
      eventHistory = eventHistory ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: MedicationAdministration,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15 + __off,
        Hoisted.statusReasonSer,
        value.statusReason,
      )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.statusReasonSer, value.category)
    (value.medication)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.medicationSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        20 + __off,
        Hoisted.basedOnSer,
        value.supportingInformation,
      )
    when (val __d = value.occurence) {
      null -> {}
      is MedicationAdministration.Occurence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is MedicationAdministration.Occurence.Period -> {
        encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.occurencePeriodSer, __d.value)
      }
      is MedicationAdministration.Occurence.Timing -> {
        encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.occurenceTimingSer, __d.value)
      }
    }
    ((value.recorded?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 25 + __off, it)
    }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.isSubPotent?.value))?.let { encoder.encodeBooleanElement(__desc, 27 + __off, it) }
    (value.isSubPotent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.subPotentReason.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29 + __off,
        Hoisted.statusReasonSer,
        value.subPotentReason,
      )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.performerSer, value.performer)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.reasonSer, value.reason)
    (value.request)?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.reasonSer, value.device)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.noteSer, value.note)
    (value.dosage)?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.dosageSer, it)
    }
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.basedOnSer, value.eventHistory)
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

    public val statusReasonSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val statusReasonSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSerInner)

    public val medicationSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val occurencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurenceTimingSer: KSerializer<Timing> = Timing.serializer()

    public val performerSerInner: KSerializer<MedicationAdministration.Performer> =
      MedicationAdministration.Performer.serializer()

    public val performerSer: KSerializer<List<MedicationAdministration.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.medicationSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val dosageSer: KSerializer<MedicationAdministration.Dosage> =
      MedicationAdministration.Dosage.serializer()
  }
}

internal object MedicationAdministrationPolymorphicSerializer :
  KSerializer<MedicationAdministration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationAdministration") {
      MedicationAdministrationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration) {
    encoder.encodeStructure(descriptor) {
      MedicationAdministrationSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration =
    decoder.decodeStructure(descriptor) {
      MedicationAdministrationSerializer.deserializeJson(this, descriptor, 0)
    }
}
