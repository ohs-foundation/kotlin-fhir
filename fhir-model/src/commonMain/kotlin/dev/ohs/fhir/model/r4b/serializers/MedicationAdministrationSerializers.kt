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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
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
      element("actor", Reference.serializer().descriptor, isOptional = true)
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

    public val actorSer: KSerializer<Reference> = Reference.serializer()
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
      text = R4bString.of(text, _text),
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
        "instantiates",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiates",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "statusReason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "medicationCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("medicationReference", Reference.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("context", Reference.serializer().descriptor, isOptional = true)
      element(
        "supportingInformation",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(
          lazyDescriptor { MedicationAdministration.Performer.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("request", Reference.serializer().descriptor, isOptional = true)
      element("device", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
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
    var instantiates: List<KotlinString?>? = null
    var _instantiates: List<Element?>? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: List<CodeableConcept>? = null
    var category: CodeableConcept? = null
    var medicationCodeableConcept: CodeableConcept? = null
    var medicationReference: Reference? = null
    var subject: Reference? = null
    var context: Reference? = null
    var supportingInformation: List<Reference>? = null
    var effectiveDateTime: KotlinString? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var performer: List<MedicationAdministration.Performer>? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var request: Reference? = null
    var device: List<Reference>? = null
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
          instantiates =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.instantiatesSer, null)
        13 ->
          _instantiates =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.instantiatesSer2, null)
        14 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.partOfSer, null)
        15 -> status = decoder.decodeStringElement(__desc, 15)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.statusReasonSer, null)
        18 ->
          category =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.statusReasonSerInner,
              null,
            )
        19 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.statusReasonSerInner,
              null,
            )
        20 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.partOfSerInner, null)
        21 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.partOfSerInner, null)
        22 ->
          context =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.partOfSerInner, null)
        23 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.partOfSer, null)
        24 -> effectiveDateTime = decoder.decodeStringElement(__desc, 24)
        25 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.effectivePeriodSer, null)
        27 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.performerSer, null)
        28 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.statusReasonSer, null)
        29 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.partOfSer, null)
        30 ->
          request =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.partOfSerInner, null)
        31 ->
          device = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.partOfSer, null)
        32 -> note = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.noteSer, null)
        33 ->
          dosage = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.dosageSer, null)
        34 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.partOfSer, null)
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
      instantiates =
        (kotlin.collections.List(maxOf(instantiates?.size ?: 0, _instantiates?.size ?: 0)) { __i ->
          Uri.of(instantiates?.getOrNull(__i)?.let { it }, _instantiates?.getOrNull(__i))!!
        }),
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          MedicationAdministration.MedicationAdministrationStatusCodes.fromCode(status!!),
          _status,
        ),
      statusReason = statusReason ?: listOf(),
      category = category,
      medication =
        MedicationAdministration.Medication.from(medicationCodeableConcept, medicationReference)!!,
      subject = subject!!,
      context = context,
      supportingInformation = supportingInformation ?: listOf(),
      effective =
        MedicationAdministration.Effective.from(
          DateTime.of(FhirDateTime.fromString(effectiveDateTime), _effectiveDateTime),
          effectivePeriod,
        )!!,
      performer = performer ?: listOf(),
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
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
    (value.instantiates.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.instantiatesSer, it)
    }
    (value.instantiates.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.instantiatesSer2, it)
    }
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.partOfSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.statusReasonSer, value.statusReason)
    (value.category)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.statusReasonSerInner, it)
    }
    when (val __d = value.medication) {
      null -> {}
      is MedicationAdministration.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.statusReasonSerInner, __d.value)
      }
      is MedicationAdministration.Medication.Reference -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.partOfSerInner, __d.value)
      }
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.partOfSerInner, it)
    }
    (value.context)?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.partOfSerInner, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.partOfSer, value.supportingInformation)
    when (val __d = value.effective) {
      null -> {}
      is MedicationAdministration.Effective.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
        }
      }
      is MedicationAdministration.Effective.Period -> {
        encoder.encodeSerializableElement(__desc, 26, Hoisted.effectivePeriodSer, __d.value)
      }
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.performerSer, value.performer)
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.statusReasonSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.partOfSer, value.reasonReference)
    (value.request)?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.partOfSerInner, it)
    }
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.partOfSer, value.device)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.noteSer, value.note)
    (value.dosage)?.let { encoder.encodeSerializableElement(__desc, 33, Hoisted.dosageSer, it) }
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.partOfSer, value.eventHistory)
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

    public val instantiatesSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val instantiatesSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.instantiatesSerInner).nullable)

    public val instantiatesSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val partOfSerInner: KSerializer<Reference> = Reference.serializer()

    public val partOfSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.partOfSerInner)

    public val statusReasonSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val statusReasonSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val performerSerInner: KSerializer<MedicationAdministration.Performer> =
      MedicationAdministration.Performer.serializer()

    public val performerSer: KSerializer<List<MedicationAdministration.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val dosageSer: KSerializer<MedicationAdministration.Dosage> =
      MedicationAdministration.Dosage.serializer()
  }
}
