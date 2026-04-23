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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> text = decoder.decodeStringElement(__desc, 3)
        4 -> _text = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.textSer, null)
        5 -> site = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.siteSer, null)
        6 -> route = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.siteSer, null)
        7 -> method = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.siteSer, null)
        8 -> dose = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.doseSer, null)
        9 ->
          rateRatio =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.rateRatioSer, null)
        10 ->
          rateQuantity =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.doseSer, null)
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

internal object MedicationAdministrationOccurenceSerializer :
  KSerializer<MedicationAdministration.Occurence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationAdministration.Occurence") {
      element("occurenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurencePeriod", Period.serializer().descriptor, isOptional = true)
      element("occurenceTiming", Timing.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Occurence) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is MedicationAdministration.Occurence.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is MedicationAdministration.Occurence.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.occurencePeriodSer, __d.value)
        }
        is MedicationAdministration.Occurence.Timing -> {
          encodeSerializableElement(__desc, 3, Hoisted.occurenceTimingSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration.Occurence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicationAdministration.Occurence {
    val __desc = descriptor
    var occurenceDateTime: KotlinString? = null
    var _occurenceDateTime: Element? = null
    var occurencePeriod: Period? = null
    var occurenceTiming: Timing? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> occurenceDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _occurenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          occurencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.occurencePeriodSer, null)
        3 ->
          occurenceTiming =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.occurenceTimingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicationAdministration.Occurence: " + __i
          )
      }
    }
    return MedicationAdministration.Occurence.from(
      DateTime.of(FhirDateTime.fromString(occurenceDateTime), _occurenceDateTime),
      occurencePeriod,
      occurenceTiming,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val occurencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurenceTimingSer: KSerializer<Timing> = Timing.serializer()
  }
}

internal object MedicationAdministrationDosageRateSerializer :
  KSerializer<MedicationAdministration.Dosage.Rate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationAdministration.Dosage.Rate") {
      element("rateRatio", Ratio.serializer().descriptor, isOptional = true)
      element("rateQuantity", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Dosage.Rate) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is MedicationAdministration.Dosage.Rate.Ratio -> {
          encodeSerializableElement(__desc, 0, Hoisted.rateRatioSer, __d.value)
        }
        is MedicationAdministration.Dosage.Rate.Quantity -> {
          encodeSerializableElement(__desc, 1, Hoisted.rateQuantitySer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): MedicationAdministration.Dosage.Rate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicationAdministration.Dosage.Rate {
    val __desc = descriptor
    var rateRatio: Ratio? = null
    var rateQuantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          rateRatio =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.rateRatioSer, null)
        1 ->
          rateQuantity =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.rateQuantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicationAdministration.Dosage.Rate: " + __i
          )
      }
    }
    return MedicationAdministration.Dosage.Rate.from(rateRatio, rateQuantity)!!
  }

  private object Hoisted {
    public val rateRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val rateQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object MedicationAdministrationSerializer : KSerializer<MedicationAdministration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationAdministration") {
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
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "statusReason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("medication", CodeableReference.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element(
        "supportingInformation",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("occurenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurencePeriod", Period.serializer().descriptor, isOptional = true)
      element("occurenceTiming", Timing.serializer().descriptor, isOptional = true)
      element("recorded", KotlinString.serializer().descriptor, isOptional = true)
      element("_recorded", Element.serializer().descriptor, isOptional = true)
      element("isSubPotent", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isSubPotent", Element.serializer().descriptor, isOptional = true)
      element(
        "subPotentReason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "performer",
        listSerialDescriptor(
          lazyDescriptor { MedicationAdministration.Performer.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("request", Reference.serializer().descriptor, isOptional = true)
      element(
        "device",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "dosage",
        lazyDescriptor { MedicationAdministration.Dosage.serializer().descriptor },
        isOptional = true,
      )
      element(
        "eventHistory",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationAdministration =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicationAdministration {
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
          basedOn = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.basedOnSer, null)
        13 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.basedOnSer, null)
        14 -> status = decoder.decodeStringElement(__desc, 14)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.statusReasonSer, null)
        17 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.statusReasonSer, null)
        18 ->
          medication =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.medicationSer, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.basedOnSerInner, null)
        20 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.basedOnSerInner, null)
        21 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.basedOnSer, null)
        22 -> occurenceDateTime = decoder.decodeStringElement(__desc, 22)
        23 ->
          _occurenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          occurencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.occurencePeriodSer, null)
        25 ->
          occurenceTiming =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.occurenceTimingSer, null)
        26 -> recorded = decoder.decodeStringElement(__desc, 26)
        27 ->
          _recorded =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> isSubPotent = decoder.decodeBooleanElement(__desc, 28)
        29 ->
          _isSubPotent =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 ->
          subPotentReason =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.statusReasonSer, null)
        31 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.performerSer, null)
        32 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.reasonSer, null)
        33 ->
          request =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.basedOnSerInner, null)
        34 ->
          device = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.reasonSer, null)
        35 -> note = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.noteSer, null)
        36 ->
          dosage = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.dosageSer, null)
        37 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.basedOnSer, null)
        CompositeDecoder.DECODE_DONE -> break
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationAdministration) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MedicationAdministration")
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.statusReasonSer, value.statusReason)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.statusReasonSer, value.category)
    (value.medication)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.medicationSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.basedOnSerInner, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.basedOnSer, value.supportingInformation)
    when (val __d = value.occurence) {
      null -> {}
      is MedicationAdministration.Occurence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
        }
      }
      is MedicationAdministration.Occurence.Period -> {
        encoder.encodeSerializableElement(__desc, 24, Hoisted.occurencePeriodSer, __d.value)
      }
      is MedicationAdministration.Occurence.Timing -> {
        encoder.encodeSerializableElement(__desc, 25, Hoisted.occurenceTimingSer, __d.value)
      }
    }
    ((value.recorded?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.isSubPotent?.value))?.let { encoder.encodeBooleanElement(__desc, 28, it) }
    (value.isSubPotent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.subPotentReason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.statusReasonSer, value.subPotentReason)
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.performerSer, value.performer)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.reasonSer, value.reason)
    (value.request)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.basedOnSerInner, it)
    }
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.reasonSer, value.device)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.noteSer, value.note)
    (value.dosage)?.let { encoder.encodeSerializableElement(__desc, 36, Hoisted.dosageSer, it) }
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.basedOnSer, value.eventHistory)
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
