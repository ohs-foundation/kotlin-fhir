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

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicationDispense
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.String
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> wasSubstituted = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _wasSubstituted =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.wasSubstitutedSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> reason = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.reasonSer, null)
        7 ->
          responsibleParty =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.responsiblePartySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + __i)
      }
    }
    return MedicationDispense.Substitution(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      wasSubstituted = R4Boolean.of(wasSubstituted, _wasSubstituted)!!,
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

internal object MedicationDispenseStatusReasonSerializer :
  KSerializer<MedicationDispense.StatusReason> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationDispense.StatusReason") {
      element(
        "statusReasonCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("statusReasonReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.StatusReason) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is MedicationDispense.StatusReason.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.statusReasonCodeableConceptSer, __d.value)
        }
        is MedicationDispense.StatusReason.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.statusReasonReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.StatusReason =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicationDispense.StatusReason {
    val __desc = descriptor
    var statusReasonCodeableConcept: CodeableConcept? = null
    var statusReasonReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          statusReasonCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        1 ->
          statusReasonReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.statusReasonReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicationDispense.StatusReason: " + __i
          )
      }
    }
    return MedicationDispense.StatusReason.from(
      statusReasonCodeableConcept,
      statusReasonReference,
    )!!
  }

  private object Hoisted {
    public val statusReasonCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val statusReasonReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MedicationDispenseMedicationSerializer :
  KSerializer<MedicationDispense.Medication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationDispense.Medication") {
      element(
        "medicationCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("medicationReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Medication) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is MedicationDispense.Medication.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.medicationCodeableConceptSer, __d.value)
        }
        is MedicationDispense.Medication.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.medicationReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.Medication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicationDispense.Medication {
    val __desc = descriptor
    var medicationCodeableConcept: CodeableConcept? = null
    var medicationReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.medicationCodeableConceptSer,
              null,
            )
        1 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.medicationReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicationDispense.Medication: " + __i
          )
      }
    }
    return MedicationDispense.Medication.from(medicationCodeableConcept, medicationReference)!!
  }

  private object Hoisted {
    public val medicationCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val medicationReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MedicationDispenseSerializer : KSerializer<MedicationDispense> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationDispense") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
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
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "statusReasonCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("statusReasonReference", Reference.serializer().descriptor, isOptional = true)
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
      element(
        "performer",
        listSerialDescriptor(
          lazyDescriptor { MedicationDispense.Performer.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("location", Reference.serializer().descriptor, isOptional = true)
      element(
        "authorizingPrescription",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("daysSupply", Quantity.serializer().descriptor, isOptional = true)
      element("whenPrepared", String.serializer().descriptor, isOptional = true)
      element("_whenPrepared", Element.serializer().descriptor, isOptional = true)
      element("whenHandedOver", String.serializer().descriptor, isOptional = true)
      element("_whenHandedOver", Element.serializer().descriptor, isOptional = true)
      element("destination", Reference.serializer().descriptor, isOptional = true)
      element(
        "receiver",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "dosageInstruction",
        listSerialDescriptor(Dosage.serializer().descriptor),
        isOptional = true,
      )
      element(
        "substitution",
        lazyDescriptor { MedicationDispense.Substitution.serializer().descriptor },
        isOptional = true,
      )
      element(
        "detectedIssue",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "eventHistory",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationDispense =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicationDispense {
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
          partOf = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.partOfSer, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          statusReasonCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        16 ->
          statusReasonReference =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.partOfSerInner, null)
        17 ->
          category =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        18 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        19 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.partOfSerInner, null)
        20 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.partOfSerInner, null)
        21 ->
          context =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.partOfSerInner, null)
        22 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.partOfSer, null)
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.performerSer, null)
        24 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.partOfSerInner, null)
        25 ->
          authorizingPrescription =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.partOfSer, null)
        26 ->
          type =
            decoder.decodeNullableSerializableElement(
              __desc,
              26,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        27 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.quantitySer, null)
        28 ->
          daysSupply =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.quantitySer, null)
        29 -> whenPrepared = decoder.decodeStringElement(__desc, 29)
        30 ->
          _whenPrepared =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> whenHandedOver = decoder.decodeStringElement(__desc, 31)
        32 ->
          _whenHandedOver =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          destination =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.partOfSerInner, null)
        34 ->
          `receiver` =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.partOfSer, null)
        35 -> note = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.noteSer, null)
        36 ->
          dosageInstruction =
            decoder.decodeNullableSerializableElement(
              __desc,
              36,
              Hoisted.dosageInstructionSer,
              null,
            )
        37 ->
          substitution =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.substitutionSer, null)
        38 ->
          detectedIssue =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.partOfSer, null)
        39 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.partOfSer, null)
        CompositeDecoder.DECODE_DONE -> break
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationDispense) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MedicationDispense")
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
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.partOfSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.statusReason) {
      null -> {}
      is MedicationDispense.StatusReason.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          15,
          Hoisted.statusReasonCodeableConceptSer,
          __d.value,
        )
      }
      is MedicationDispense.StatusReason.Reference -> {
        encoder.encodeSerializableElement(__desc, 16, Hoisted.partOfSerInner, __d.value)
      }
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.statusReasonCodeableConceptSer, it)
    }
    when (val __d = value.medication) {
      null -> {}
      is MedicationDispense.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          18,
          Hoisted.statusReasonCodeableConceptSer,
          __d.value,
        )
      }
      is MedicationDispense.Medication.Reference -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.partOfSerInner, __d.value)
      }
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.partOfSerInner, it)
    }
    (value.context)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.partOfSerInner, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.partOfSer, value.supportingInformation)
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.performerSer, value.performer)
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.partOfSerInner, it)
    }
    if (value.authorizingPrescription.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        25,
        Hoisted.partOfSer,
        value.authorizingPrescription,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.statusReasonCodeableConceptSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 27, Hoisted.quantitySer, it) }
    (value.daysSupply)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.quantitySer, it)
    }
    ((value.whenPrepared?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.whenPrepared?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    ((value.whenHandedOver?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.whenHandedOver?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    (value.destination)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.partOfSerInner, it)
    }
    if (value.`receiver`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.partOfSer, value.`receiver`)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.noteSer, value.note)
    if (value.dosageInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        36,
        Hoisted.dosageInstructionSer,
        value.dosageInstruction,
      )
    (value.substitution)?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.substitutionSer, it)
    }
    if (value.detectedIssue.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.partOfSer, value.detectedIssue)
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.partOfSer, value.eventHistory)
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
