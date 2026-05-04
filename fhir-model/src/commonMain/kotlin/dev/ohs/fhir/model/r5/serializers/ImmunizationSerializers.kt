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
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Immunization
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
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

internal object ImmunizationPerformerSerializer : KSerializer<Immunization.Performer> {
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

  override fun deserialize(decoder: Decoder): Immunization.Performer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Immunization.Performer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Immunization.Performer {
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
    return Immunization.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Immunization.Performer) {
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

internal object ImmunizationProgramEligibilitySerializer :
  KSerializer<Immunization.ProgramEligibility> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProgramEligibility") {
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
      element("program", CodeableConcept.serializer().descriptor, isOptional = true)
      element("programStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Immunization.ProgramEligibility =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Immunization.ProgramEligibility) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Immunization.ProgramEligibility {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var program: CodeableConcept? = null
    var programStatus: CodeableConcept? = null
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
          program = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.programSer, null)
        4 ->
          programStatus =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.programSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProgramEligibility: " + __i)
      }
    }
    return Immunization.ProgramEligibility(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      program = program!!,
      programStatus = programStatus!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Immunization.ProgramEligibility) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.program)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.programSer, it) }
    (value.programStatus)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.programSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val programSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ImmunizationReactionSerializer : KSerializer<Immunization.Reaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Reaction") {
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
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("manifestation", CodeableReference.serializer().descriptor, isOptional = true)
      element("reported", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_reported", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Immunization.Reaction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Immunization.Reaction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Immunization.Reaction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var manifestation: CodeableReference? = null
    var reported: KotlinBoolean? = null
    var _reported: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> date = decoder.decodeStringElement(__desc, 3)
        4 -> _date = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.dateSer, null)
        5 ->
          manifestation =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.manifestationSer, null)
        6 -> reported = decoder.decodeBooleanElement(__desc, 6)
        7 -> _reported = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.dateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Reaction: " + __i)
      }
    }
    return Immunization.Reaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      manifestation = manifestation,
      reported = R5Boolean.of(reported, _reported),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Immunization.Reaction) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.dateSer, it)
    }
    (value.manifestation)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.manifestationSer, it)
    }
    ((value.reported?.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
    (value.reported?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.dateSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val dateSer: KSerializer<Element> = Element.serializer()

    public val manifestationSer: KSerializer<CodeableReference> = CodeableReference.serializer()
  }
}

internal object ImmunizationProtocolAppliedSerializer : KSerializer<Immunization.ProtocolApplied> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProtocolApplied") {
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
      element("series", KotlinString.serializer().descriptor, isOptional = true)
      element("_series", Element.serializer().descriptor, isOptional = true)
      element("authority", Reference.serializer().descriptor, isOptional = true)
      element(
        "targetDisease",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("doseNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_doseNumber", Element.serializer().descriptor, isOptional = true)
      element("seriesDoses", KotlinString.serializer().descriptor, isOptional = true)
      element("_seriesDoses", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Immunization.ProtocolApplied =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Immunization.ProtocolApplied) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Immunization.ProtocolApplied {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var series: KotlinString? = null
    var _series: Element? = null
    var authority: Reference? = null
    var targetDisease: List<CodeableConcept>? = null
    var doseNumber: KotlinString? = null
    var _doseNumber: Element? = null
    var seriesDoses: KotlinString? = null
    var _seriesDoses: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> series = decoder.decodeStringElement(__desc, 3)
        4 -> _series = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.seriesSer, null)
        5 ->
          authority =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.authoritySer, null)
        6 ->
          targetDisease =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.targetDiseaseSer, null)
        7 -> doseNumber = decoder.decodeStringElement(__desc, 7)
        8 ->
          _doseNumber =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.seriesSer, null)
        9 -> seriesDoses = decoder.decodeStringElement(__desc, 9)
        10 ->
          _seriesDoses =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.seriesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProtocolApplied: " + __i)
      }
    }
    return Immunization.ProtocolApplied(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      series = R5String.of(series, _series),
      authority = authority,
      targetDisease = targetDisease ?: listOf(),
      doseNumber = R5String.of(doseNumber, _doseNumber)!!,
      seriesDoses = R5String.of(seriesDoses, _seriesDoses),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Immunization.ProtocolApplied) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.series?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.series?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.seriesSer, it)
    }
    (value.authority)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.authoritySer, it)
    }
    if (value.targetDisease.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.targetDiseaseSer, value.targetDisease)
    ((value.doseNumber.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.doseNumber.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.seriesSer, it)
    }
    ((value.seriesDoses?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.seriesDoses?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.seriesSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val seriesSer: KSerializer<Element> = Element.serializer()

    public val authoritySer: KSerializer<Reference> = Reference.serializer()

    public val targetDiseaseSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val targetDiseaseSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.targetDiseaseSerInner)
  }
}

internal object ImmunizationSerializer : KSerializer<Immunization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Immunization") {
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("vaccineCode", CodeableConcept.serializer().descriptor, isOptional = true)
      element("administeredProduct", CodeableReference.serializer().descriptor, isOptional = true)
      element("manufacturer", CodeableReference.serializer().descriptor, isOptional = true)
      element("lotNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_lotNumber", Element.serializer().descriptor, isOptional = true)
      element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_expirationDate", Element.serializer().descriptor, isOptional = true)
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element(
        "supportingInformation",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrenceString", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceString", Element.serializer().descriptor, isOptional = true)
      element("primarySource", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_primarySource", Element.serializer().descriptor, isOptional = true)
      element("informationSource", CodeableReference.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
      element("site", CodeableConcept.serializer().descriptor, isOptional = true)
      element("route", CodeableConcept.serializer().descriptor, isOptional = true)
      element("doseQuantity", Quantity.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(lazyDescriptor { Immunization.Performer.serializer().descriptor }),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("isSubpotent", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isSubpotent", Element.serializer().descriptor, isOptional = true)
      element(
        "subpotentReason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "programEligibility",
        listSerialDescriptor(
          lazyDescriptor { Immunization.ProgramEligibility.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("fundingSource", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "reaction",
        listSerialDescriptor(lazyDescriptor { Immunization.Reaction.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "protocolApplied",
        listSerialDescriptor(
          lazyDescriptor { Immunization.ProtocolApplied.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Immunization =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Immunization) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Immunization {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: CodeableConcept? = null
    var vaccineCode: CodeableConcept? = null
    var administeredProduct: CodeableReference? = null
    var manufacturer: CodeableReference? = null
    var lotNumber: KotlinString? = null
    var _lotNumber: Element? = null
    var expirationDate: KotlinString? = null
    var _expirationDate: Element? = null
    var patient: Reference? = null
    var encounter: Reference? = null
    var supportingInformation: List<Reference>? = null
    var occurrenceDateTime: KotlinString? = null
    var _occurrenceDateTime: Element? = null
    var occurrenceString: KotlinString? = null
    var _occurrenceString: Element? = null
    var primarySource: KotlinBoolean? = null
    var _primarySource: Element? = null
    var informationSource: CodeableReference? = null
    var location: Reference? = null
    var site: CodeableConcept? = null
    var route: CodeableConcept? = null
    var doseQuantity: Quantity? = null
    var performer: List<Immunization.Performer>? = null
    var note: List<Annotation>? = null
    var reason: List<CodeableReference>? = null
    var isSubpotent: KotlinBoolean? = null
    var _isSubpotent: Element? = null
    var subpotentReason: List<CodeableConcept>? = null
    var programEligibility: List<Immunization.ProgramEligibility>? = null
    var fundingSource: CodeableConcept? = null
    var reaction: List<Immunization.Reaction>? = null
    var protocolApplied: List<Immunization.ProtocolApplied>? = null
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
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.statusReasonSer, null)
        16 ->
          vaccineCode =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.statusReasonSer, null)
        17 ->
          administeredProduct =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.administeredProductSer,
              null,
            )
        18 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.administeredProductSer,
              null,
            )
        19 -> lotNumber = decoder.decodeStringElement(__desc, 19)
        20 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> expirationDate = decoder.decodeStringElement(__desc, 21)
        22 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          patient =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.basedOnSerInner, null)
        24 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.basedOnSerInner, null)
        25 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.basedOnSer, null)
        26 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 26)
        27 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> occurrenceString = decoder.decodeStringElement(__desc, 28)
        29 ->
          _occurrenceString =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> primarySource = decoder.decodeBooleanElement(__desc, 30)
        31 ->
          _primarySource =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          informationSource =
            decoder.decodeNullableSerializableElement(
              __desc,
              32,
              Hoisted.administeredProductSer,
              null,
            )
        33 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.basedOnSerInner, null)
        34 ->
          site =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.statusReasonSer, null)
        35 ->
          route =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.statusReasonSer, null)
        36 ->
          doseQuantity =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.doseQuantitySer, null)
        37 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.performerSer, null)
        38 -> note = decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.noteSer, null)
        39 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.reasonSer, null)
        40 -> isSubpotent = decoder.decodeBooleanElement(__desc, 40)
        41 ->
          _isSubpotent =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 ->
          subpotentReason =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.subpotentReasonSer, null)
        43 ->
          programEligibility =
            decoder.decodeNullableSerializableElement(
              __desc,
              43,
              Hoisted.programEligibilitySer,
              null,
            )
        44 ->
          fundingSource =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.statusReasonSer, null)
        45 ->
          reaction =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.reactionSer, null)
        46 ->
          protocolApplied =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.protocolAppliedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Immunization: " + __i)
      }
    }
    return Immunization(
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
      status = Enumeration.of(Immunization.ImmunizationStatusCodes.fromCode(status!!), _status),
      statusReason = statusReason,
      vaccineCode = vaccineCode!!,
      administeredProduct = administeredProduct,
      manufacturer = manufacturer,
      lotNumber = R5String.of(lotNumber, _lotNumber),
      expirationDate = Date.of(FhirDate.fromString(expirationDate), _expirationDate),
      patient = patient!!,
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      occurrence =
        Immunization.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          R5String.of(occurrenceString, _occurrenceString),
        )!!,
      primarySource = R5Boolean.of(primarySource, _primarySource),
      informationSource = informationSource,
      location = location,
      site = site,
      route = route,
      doseQuantity = doseQuantity,
      performer = performer ?: listOf(),
      note = note ?: listOf(),
      reason = reason ?: listOf(),
      isSubpotent = R5Boolean.of(isSubpotent, _isSubpotent),
      subpotentReason = subpotentReason ?: listOf(),
      programEligibility = programEligibility ?: listOf(),
      fundingSource = fundingSource,
      reaction = reaction ?: listOf(),
      protocolApplied = protocolApplied ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Immunization) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Immunization")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.statusReasonSer, it)
    }
    (value.vaccineCode)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.statusReasonSer, it)
    }
    (value.administeredProduct)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.administeredProductSer, it)
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.administeredProductSer, it)
    }
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.expirationDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.basedOnSerInner, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.basedOnSer, value.supportingInformation)
    when (val __d = value.occurrence) {
      null -> {}
      is Immunization.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
        }
      }
      is Immunization.Occurrence.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.primarySource?.value))?.let { encoder.encodeBooleanElement(__desc, 30, it) }
    (value.primarySource?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    (value.informationSource)?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.administeredProductSer, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.basedOnSerInner, it)
    }
    (value.site)?.let { encoder.encodeSerializableElement(__desc, 34, Hoisted.statusReasonSer, it) }
    (value.route)?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.statusReasonSer, it)
    }
    (value.doseQuantity)?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.doseQuantitySer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.performerSer, value.performer)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.noteSer, value.note)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.reasonSer, value.reason)
    ((value.isSubpotent?.value))?.let { encoder.encodeBooleanElement(__desc, 40, it) }
    (value.isSubpotent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    if (value.subpotentReason.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        42,
        Hoisted.subpotentReasonSer,
        value.subpotentReason,
      )
    if (value.programEligibility.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        43,
        Hoisted.programEligibilitySer,
        value.programEligibility,
      )
    (value.fundingSource)?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.statusReasonSer, it)
    }
    if (value.reaction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.reactionSer, value.reaction)
    if (value.protocolApplied.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        46,
        Hoisted.protocolAppliedSer,
        value.protocolApplied,
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

    public val statusReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val administeredProductSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val doseQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val performerSerInner: KSerializer<Immunization.Performer> =
      Immunization.Performer.serializer()

    public val performerSer: KSerializer<List<Immunization.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.administeredProductSer)

    public val subpotentReasonSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val programEligibilitySerInner: KSerializer<Immunization.ProgramEligibility> =
      Immunization.ProgramEligibility.serializer()

    public val programEligibilitySer: KSerializer<List<Immunization.ProgramEligibility>> =
      ListSerializer(Hoisted.programEligibilitySerInner)

    public val reactionSerInner: KSerializer<Immunization.Reaction> =
      Immunization.Reaction.serializer()

    public val reactionSer: KSerializer<List<Immunization.Reaction>> =
      ListSerializer(Hoisted.reactionSerInner)

    public val protocolAppliedSerInner: KSerializer<Immunization.ProtocolApplied> =
      Immunization.ProtocolApplied.serializer()

    public val protocolAppliedSer: KSerializer<List<Immunization.ProtocolApplied>> =
      ListSerializer(Hoisted.protocolAppliedSerInner)
  }
}
