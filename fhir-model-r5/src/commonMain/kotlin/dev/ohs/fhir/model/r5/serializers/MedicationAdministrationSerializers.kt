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
@file:OptIn(ExperimentalSerializationApi::class)

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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Performer) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationAdministration.Performer {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: CodeableReference? = null
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
    return MedicationAdministration.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationAdministration.Performer,
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Dosage) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationAdministration.Dosage {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> text = decoder.decodeStringElement(descriptor, i)
        4 -> _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        5 -> site = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.siteSer, null)
        6 -> route = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.siteSer, null)
        7 ->
          method = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.siteSer, null)
        8 -> dose = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doseSer, null)
        9 ->
          rateRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rateRatioSer, null)
        10 ->
          rateQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doseSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dosage: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationAdministration.Dosage,
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
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.textSer, it)
    }
    (value.site)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.siteSer, it) }
    (value.route)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.siteSer, it) }
    (value.method)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.siteSer, it) }
    (value.dose)?.let { encoder.encodeSerializableElement(descriptor, 8, Hoisted.doseSer, it) }
    when (val choice = value.rate) {
      null -> {}
      is MedicationAdministration.Dosage.Rate.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.rateRatioSer, choice.value)
      }
      is MedicationAdministration.Dosage.Rate.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.doseSer, choice.value)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicationAdministration")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicationAdministration {
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
          statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        16 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        17 ->
          medication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.medicationSer, null)
        18 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        20 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        21 -> occurenceDateTime = decoder.decodeStringElement(descriptor, i)
        22 ->
          _occurenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 ->
          occurencePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurencePeriodSer,
              null,
            )
        24 ->
          occurenceTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurenceTimingSer,
              null,
            )
        25 -> recorded = decoder.decodeStringElement(descriptor, i)
        26 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> isSubPotent = decoder.decodeBooleanElement(descriptor, i)
        28 ->
          _isSubPotent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          subPotentReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        30 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        31 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        32 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        33 ->
          device = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        34 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        35 ->
          dosage = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dosageSer, null)
        36 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        else ->
          throw SerializationException("Unexpected index decoding MedicationAdministration: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationAdministration,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.statusReasonSer,
        value.statusReason,
      )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.statusReasonSer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      Hoisted.medicationSer,
      value.medication,
    )
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      Hoisted.basedOnSerInner,
      value.subject,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.basedOnSer,
        value.supportingInformation,
      )
    when (val choice = value.occurence) {
      is MedicationAdministration.Occurence.DateTime -> {
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
      is MedicationAdministration.Occurence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          Hoisted.occurencePeriodSer,
          choice.value,
        )
      }
      is MedicationAdministration.Occurence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          Hoisted.occurenceTimingSer,
          choice.value,
        )
      }
    }
    ((value.recorded?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.isSubPotent?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.isSubPotent?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.subPotentReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.statusReasonSer,
        value.subPotentReason,
      )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.performerSer,
        value.performer,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.reasonSer,
        value.reason,
      )
    (value.request)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.reasonSer,
        value.device,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    (value.dosage)?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, Hoisted.dosageSer, it)
    }
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.basedOnSer,
        value.eventHistory,
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
      MedicationAdministrationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration =
    decoder.decodeStructure(descriptor) {
      MedicationAdministrationSerializer.deserializeInternal(this, descriptor, 0)
    }
}
