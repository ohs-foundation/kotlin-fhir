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
import kotlin.OptIn
import kotlin.String
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Performer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationDispense.Performer {
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
    return MedicationDispense.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor =
        actor
          ?: throw SerializationException(
            "Missing required property 'actor' on MedicationDispense.Performer"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MedicationDispense.Performer) {
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Substitution) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationDispense.Substitution {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var wasSubstituted: KotlinBoolean? = null
    var _wasSubstituted: Element? = null
    var type: CodeableConcept? = null
    var reason: List<CodeableConcept>? = null
    var responsibleParty: List<Reference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> wasSubstituted = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _wasSubstituted =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.wasSubstitutedSer,
              null,
            )
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        7 ->
          responsibleParty =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.responsiblePartySer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + i)
      }
    }
    return MedicationDispense.Substitution(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      wasSubstituted =
        R4bBoolean.of(wasSubstituted, _wasSubstituted)
          ?: throw SerializationException(
            "Missing required property 'wasSubstituted' on MedicationDispense.Substitution"
          ),
      type = type,
      reason = reason ?: listOf(),
      responsibleParty = responsibleParty ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationDispense.Substitution,
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
    ((value.wasSubstituted.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.wasSubstituted.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.wasSubstitutedSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.reasonSer, value.reason)
    if (value.responsibleParty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationDispense) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicationDispense")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicationDispense {
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
          partOf = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 ->
          statusReasonCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        15 ->
          statusReasonReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        16 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        17 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        18 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        20 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        21 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        22 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        23 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        24 ->
          authorizingPrescription =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        25 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.statusReasonCodeableConceptSer,
              null,
            )
        26 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        27 ->
          daysSupply =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        28 -> whenPrepared = decoder.decodeStringElement(descriptor, i)
        29 ->
          _whenPrepared =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 -> whenHandedOver = decoder.decodeStringElement(descriptor, i)
        31 ->
          _whenHandedOver =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 ->
          destination =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSerInner, null)
        33 ->
          `receiver` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        34 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        35 ->
          dosageInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dosageInstructionSer,
              null,
            )
        36 ->
          substitution =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.substitutionSer, null)
        37 ->
          detectedIssue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        38 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partOfSer, null)
        else -> throw SerializationException("Unexpected index decoding MedicationDispense: " + i)
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
          status?.let { MedicationDispense.MedicationDispenseStatusCodes.fromCode(it) },
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on MedicationDispense"
          ),
      statusReason =
        MedicationDispense.StatusReason.from(statusReasonCodeableConcept, statusReasonReference),
      category = category,
      medication =
        MedicationDispense.Medication.from(medicationCodeableConcept, medicationReference)
          ?: throw SerializationException(
            "Missing required property 'medication' on MedicationDispense"
          ),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationDispense,
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
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.partOfSer,
        value.partOf,
      )
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.statusReason) {
      null -> {}
      is MedicationDispense.StatusReason.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          14 + descriptorOffset,
          Hoisted.statusReasonCodeableConceptSer,
          choice.value,
        )
      }
      is MedicationDispense.StatusReason.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          15 + descriptorOffset,
          Hoisted.partOfSerInner,
          choice.value,
        )
      }
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.statusReasonCodeableConceptSer,
        it,
      )
    }
    when (val choice = value.medication) {
      is MedicationDispense.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.statusReasonCodeableConceptSer,
          choice.value,
        )
      }
      is MedicationDispense.Medication.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          18 + descriptorOffset,
          Hoisted.partOfSerInner,
          choice.value,
        )
      }
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    (value.context)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.partOfSer,
        value.supportingInformation,
      )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.performerSer,
        value.performer,
      )
    (value.location)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    if (value.authorizingPrescription.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.partOfSer,
        value.authorizingPrescription,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.statusReasonCodeableConceptSer,
        it,
      )
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 26 + descriptorOffset, Hoisted.quantitySer, it)
    }
    (value.daysSupply)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.quantitySer, it)
    }
    ((value.whenPrepared?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.whenPrepared?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.whenHandedOver?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.whenHandedOver?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.destination)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.partOfSerInner,
        it,
      )
    }
    if (value.`receiver`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.partOfSer,
        value.`receiver`,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.dosageInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.dosageInstructionSer,
        value.dosageInstruction,
      )
    (value.substitution)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.substitutionSer,
        it,
      )
    }
    if (value.detectedIssue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.partOfSer,
        value.detectedIssue,
      )
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.partOfSer,
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
      MedicationDispenseSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicationDispense =
    decoder.decodeStructure(descriptor) {
      MedicationDispenseSerializer.deserializeInternal(this, descriptor, 0)
    }
}
