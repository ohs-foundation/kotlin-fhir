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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          program = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.programSer, null)
        4 ->
          programStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.programSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> date = decoder.decodeStringElement(__desc, __i)
        4 -> _date = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateSer, null)
        5 ->
          manifestation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.manifestationSer, null)
        6 -> reported = decoder.decodeBooleanElement(__desc, __i)
        7 ->
          _reported = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> series = decoder.decodeStringElement(__desc, __i)
        4 ->
          _series = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.seriesSer, null)
        5 ->
          authority =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.authoritySer, null)
        6 ->
          targetDisease =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetDiseaseSer, null)
        7 -> doseNumber = decoder.decodeStringElement(__desc, __i)
        8 ->
          _doseNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.seriesSer, null)
        9 -> seriesDoses = decoder.decodeStringElement(__desc, __i)
        10 ->
          _seriesDoses =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.seriesSer, null)
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("vaccineCode", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("administeredProduct", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("manufacturer", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("lotNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lotNumber", Element.serializer().descriptor, isOptional = true)
    b.element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_expirationDate", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "supportingInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurrenceString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurrenceString", Element.serializer().descriptor, isOptional = true)
    b.element("primarySource", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_primarySource", Element.serializer().descriptor, isOptional = true)
    b.element("informationSource", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element("site", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("route", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("doseQuantity", Quantity.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(lazyDescriptor { Immunization.Performer.serializer().descriptor }),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("isSubpotent", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_isSubpotent", Element.serializer().descriptor, isOptional = true)
    b.element(
      "subpotentReason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "programEligibility",
      listSerialDescriptor(
        lazyDescriptor { Immunization.ProgramEligibility.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("fundingSource", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "reaction",
      listSerialDescriptor(lazyDescriptor { Immunization.Reaction.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "protocolApplied",
      listSerialDescriptor(lazyDescriptor { Immunization.ProtocolApplied.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Immunization =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Immunization) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Immunization")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Immunization {
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
        12 -> status = decoder.decodeStringElement(__desc, __i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        15 ->
          vaccineCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        16 ->
          administeredProduct =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.administeredProductSer,
              null,
            )
        17 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.administeredProductSer,
              null,
            )
        18 -> lotNumber = decoder.decodeStringElement(__desc, __i)
        19 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 -> expirationDate = decoder.decodeStringElement(__desc, __i)
        21 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 ->
          patient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        23 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        24 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        25 -> occurrenceDateTime = decoder.decodeStringElement(__desc, __i)
        26 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 -> occurrenceString = decoder.decodeStringElement(__desc, __i)
        28 ->
          _occurrenceString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        29 -> primarySource = decoder.decodeBooleanElement(__desc, __i)
        30 ->
          _primarySource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        31 ->
          informationSource =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.administeredProductSer,
              null,
            )
        32 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        33 ->
          site =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        34 ->
          route =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        35 ->
          doseQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.doseQuantitySer, null)
        36 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerSer, null)
        37 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        38 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        39 -> isSubpotent = decoder.decodeBooleanElement(__desc, __i)
        40 ->
          _isSubpotent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        41 ->
          subpotentReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subpotentReasonSer, null)
        42 ->
          programEligibility =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.programEligibilitySer,
              null,
            )
        43 ->
          fundingSource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        44 ->
          reaction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reactionSer, null)
        45 ->
          protocolApplied =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.protocolAppliedSer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Immunization,
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.statusReasonSer, it)
    }
    (value.vaccineCode)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.statusReasonSer, it)
    }
    (value.administeredProduct)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.administeredProductSer, it)
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.administeredProductSer, it)
    }
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.expirationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 20 + __off, it)
    }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        24 + __off,
        Hoisted.basedOnSer,
        value.supportingInformation,
      )
    when (val __d = value.occurrence) {
      null -> {}
      is Immunization.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 25 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Immunization.Occurrence.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 27 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.primarySource?.value))?.let { encoder.encodeBooleanElement(__desc, 29 + __off, it) }
    (value.primarySource?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.informationSource)?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.administeredProductSer, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.site)?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.statusReasonSer, it)
    }
    (value.route)?.let {
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.statusReasonSer, it)
    }
    (value.doseQuantity)?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.doseQuantitySer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.performerSer, value.performer)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.noteSer, value.note)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.reasonSer, value.reason)
    ((value.isSubpotent?.value))?.let { encoder.encodeBooleanElement(__desc, 39 + __off, it) }
    (value.isSubpotent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.subpotentReason.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        41 + __off,
        Hoisted.subpotentReasonSer,
        value.subpotentReason,
      )
    if (value.programEligibility.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        42 + __off,
        Hoisted.programEligibilitySer,
        value.programEligibility,
      )
    (value.fundingSource)?.let {
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.statusReasonSer, it)
    }
    if (value.reaction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.reactionSer, value.reaction)
    if (value.protocolApplied.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        45 + __off,
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

internal object ImmunizationPolymorphicSerializer : KSerializer<Immunization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Immunization") { ImmunizationSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Immunization) {
    encoder.encodeStructure(descriptor) {
      ImmunizationSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Immunization =
    decoder.decodeStructure(descriptor) {
      ImmunizationSerializer.deserializeJson(this, descriptor, 0)
    }
}
