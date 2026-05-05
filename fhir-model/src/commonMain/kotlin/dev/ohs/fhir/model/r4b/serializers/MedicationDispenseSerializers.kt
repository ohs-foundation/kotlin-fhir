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
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.MedicationDispense
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String
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

internal object MedicationDispensePerformerSerializer : KSerializer<MedicationDispense.Performer> {
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

  override fun deserialize(decoder: Decoder): MedicationDispense.Performer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Performer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationDispense.Performer {
    val __desc = descriptor
    var id: String? = null
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
    return MedicationDispense.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationDispense.Performer) {
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

internal object MedicationDispenseSubstitutionSerializer :
  KSerializer<MedicationDispense.Substitution> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Substitution") {
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
      element("wasSubstituted", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_wasSubstituted", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "responsibleParty",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationDispense.Substitution =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Substitution) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationDispense.Substitution {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var wasSubstituted: KotlinBoolean? = null
    var _wasSubstituted: Element? = null
    var type: CodeableConcept? = null
    var reason: List<CodeableConcept>? = null
    var responsibleParty: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> wasSubstituted = decoder.decodeBooleanElement(__desc, __i)
        4 ->
          _wasSubstituted =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.wasSubstitutedSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        7 ->
          responsibleParty =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.responsiblePartySer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + __i)
      }
    }
    return MedicationDispense.Substitution(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      wasSubstituted = R4bBoolean.of(wasSubstituted, _wasSubstituted)!!,
      type = type,
      reason = reason ?: listOf(),
      responsibleParty = responsibleParty ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationDispense.Substitution) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.wasSubstituted.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.wasSubstituted.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.wasSubstitutedSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.reasonSer, value.reason)
    if (value.responsibleParty.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        7,
        Hoisted.responsiblePartySer,
        value.responsibleParty,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val wasSubstitutedSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reasonSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val responsiblePartySerInner: KSerializer<Reference> = Reference.serializer()

    public val responsiblePartySer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.responsiblePartySerInner)
  }
}

internal object MedicationDispenseSerializer : KSerializer<MedicationDispense> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationDispense") {
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
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "statusReasonCodeableConcept",
      CodeableConcept.serializer().descriptor,
      isOptional = true,
    )
    b.element("statusReasonReference", Reference.serializer().descriptor, isOptional = true)
    b.element("category", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "medicationCodeableConcept",
      CodeableConcept.serializer().descriptor,
      isOptional = true,
    )
    b.element("medicationReference", Reference.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("context", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "supportingInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "performer",
      listSerialDescriptor(lazyDescriptor { MedicationDispense.Performer.serializer().descriptor }),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "authorizingPrescription",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("quantity", Quantity.serializer().descriptor, isOptional = true)
    b.element("daysSupply", Quantity.serializer().descriptor, isOptional = true)
    b.element("whenPrepared", String.serializer().descriptor, isOptional = true)
    b.element("_whenPrepared", Element.serializer().descriptor, isOptional = true)
    b.element("whenHandedOver", String.serializer().descriptor, isOptional = true)
    b.element("_whenHandedOver", Element.serializer().descriptor, isOptional = true)
    b.element("destination", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "receiver",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "dosageInstruction",
      listSerialDescriptor(Dosage.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "substitution",
      lazyDescriptor { MedicationDispense.Substitution.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "detectedIssue",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "eventHistory",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicationDispense =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicationDispense")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): MedicationDispense {
    val __desc = desc
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
    var partOf: List<Reference>? = null
    var status: String? = null
    var _status: Element? = null
    var statusReasonCodeableConcept: CodeableConcept? = null
    var statusReasonReference: Reference? = null
    var category: CodeableConcept? = null
    var medicationCodeableConcept: CodeableConcept? = null
    var medicationReference: Reference? = null
    var subject: Reference? = null
    var context: Reference? = null
    var supportingInformation: List<Reference>? = null
    var performer: List<MedicationDispense.Performer>? = null
    var location: Reference? = null
    var authorizingPrescription: List<Reference>? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
    var daysSupply: Quantity? = null
    var whenPrepared: String? = null
    var _whenPrepared: Element? = null
    var whenHandedOver: String? = null
    var _whenHandedOver: Element? = null
    var destination: Reference? = null
    var `receiver`: List<Reference>? = null
    var note: List<Annotation>? = null
    var dosageInstruction: List<Dosage>? = null
    var substitution: MedicationDispense.Substitution? = null
    var detectedIssue: List<Reference>? = null
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
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
        12 -> status = decoder.decodeStringElement(__desc, __i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 ->
          statusReasonCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        15 ->
          statusReasonReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        16 ->
          category =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        17 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        18 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        20 ->
          context =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        21 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
        22 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerSer, null)
        23 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        24 ->
          authorizingPrescription =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
        25 ->
          type =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        26 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        27 ->
          daysSupply =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        28 -> whenPrepared = decoder.decodeStringElement(__desc, __i)
        29 ->
          _whenPrepared =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 -> whenHandedOver = decoder.decodeStringElement(__desc, __i)
        31 ->
          _whenHandedOver =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        32 ->
          destination =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSerInner, null)
        33 ->
          `receiver` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
        34 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        35 ->
          dosageInstruction =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.dosageInstructionSer,
              null,
            )
        36 ->
          substitution =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.substitutionSer, null)
        37 ->
          detectedIssue =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
        38 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partOfSer, null)
        else -> throw SerializationException("Unexpected index decoding MedicationDispense: " + __i)
      }
    }
    return MedicationDispense(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          MedicationDispense.MedicationDispenseStatusCodes.fromCode(status!!),
          _status,
        ),
      statusReason =
        MedicationDispense.StatusReason.from(statusReasonCodeableConcept, statusReasonReference),
      category = category,
      medication =
        MedicationDispense.Medication.from(medicationCodeableConcept, medicationReference)!!,
      subject = subject,
      context = context,
      supportingInformation = supportingInformation ?: listOf(),
      performer = performer ?: listOf(),
      location = location,
      authorizingPrescription = authorizingPrescription ?: listOf(),
      type = type,
      quantity = quantity,
      daysSupply = daysSupply,
      whenPrepared = DateTime.of(FhirDateTime.fromString(whenPrepared), _whenPrepared),
      whenHandedOver = DateTime.of(FhirDateTime.fromString(whenHandedOver), _whenHandedOver),
      destination = destination,
      `receiver` = `receiver` ?: listOf(),
      note = note ?: listOf(),
      dosageInstruction = dosageInstruction ?: listOf(),
      substitution = substitution,
      detectedIssue = detectedIssue ?: listOf(),
      eventHistory = eventHistory ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: MedicationDispense,
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
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.partOfSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.statusReason) {
      null -> {}
      is MedicationDispense.StatusReason.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          14 + __off,
          Hoisted.statusReasonCodeableConceptSer,
          __d.value,
        )
      }
      is MedicationDispense.StatusReason.Reference -> {
        encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.partOfSerInner, __d.value)
      }
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(
        __desc,
        16 + __off,
        Hoisted.statusReasonCodeableConceptSer,
        it,
      )
    }
    when (val __d = value.medication) {
      null -> {}
      is MedicationDispense.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          17 + __off,
          Hoisted.statusReasonCodeableConceptSer,
          __d.value,
        )
      }
      is MedicationDispense.Medication.Reference -> {
        encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.partOfSerInner, __d.value)
      }
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.partOfSerInner, it)
    }
    (value.context)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.partOfSerInner, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        21 + __off,
        Hoisted.partOfSer,
        value.supportingInformation,
      )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.performerSer, value.performer)
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.partOfSerInner, it)
    }
    if (value.authorizingPrescription.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        24 + __off,
        Hoisted.partOfSer,
        value.authorizingPrescription,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(
        __desc,
        25 + __off,
        Hoisted.statusReasonCodeableConceptSer,
        it,
      )
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.quantitySer, it)
    }
    (value.daysSupply)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.quantitySer, it)
    }
    ((value.whenPrepared?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 28 + __off, it)
    }
    (value.whenPrepared?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.whenHandedOver?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 30 + __off, it)
    }
    (value.whenHandedOver?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.destination)?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.partOfSerInner, it)
    }
    if (value.`receiver`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.partOfSer, value.`receiver`)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.noteSer, value.note)
    if (value.dosageInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        35 + __off,
        Hoisted.dosageInstructionSer,
        value.dosageInstruction,
      )
    (value.substitution)?.let {
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.substitutionSer, it)
    }
    if (value.detectedIssue.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.partOfSer, value.detectedIssue)
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.partOfSer, value.eventHistory)
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

    public val partOfSerInner: KSerializer<Reference> = Reference.serializer()

    public val partOfSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.partOfSerInner)

    public val statusReasonCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val performerSerInner: KSerializer<MedicationDispense.Performer> =
      MedicationDispense.Performer.serializer()

    public val performerSer: KSerializer<List<MedicationDispense.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val dosageInstructionSerInner: KSerializer<Dosage> = Dosage.serializer()

    public val dosageInstructionSer: KSerializer<List<Dosage>> =
      ListSerializer(Hoisted.dosageInstructionSerInner)

    public val substitutionSer: KSerializer<MedicationDispense.Substitution> =
      MedicationDispense.Substitution.serializer()
  }
}

internal object MedicationDispensePolymorphicSerializer : KSerializer<MedicationDispense> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationDispense") {
      MedicationDispenseSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense) {
    encoder.encodeStructure(descriptor) {
      MedicationDispenseSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicationDispense =
    decoder.decodeStructure(descriptor) {
      MedicationDispenseSerializer.deserializeJson(this, descriptor, 0)
    }
}
