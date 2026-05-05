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
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Immunization
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object ImmunizationEducationSerializer : KSerializer<Immunization.Education> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Education") {
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
      element("documentType", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentType", Element.serializer().descriptor, isOptional = true)
      element("reference", KotlinString.serializer().descriptor, isOptional = true)
      element("_reference", Element.serializer().descriptor, isOptional = true)
      element("publicationDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_publicationDate", Element.serializer().descriptor, isOptional = true)
      element("presentationDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_presentationDate", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Immunization.Education =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Immunization.Education) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Immunization.Education {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var documentType: KotlinString? = null
    var _documentType: Element? = null
    var reference: KotlinString? = null
    var _reference: Element? = null
    var publicationDate: KotlinString? = null
    var _publicationDate: Element? = null
    var presentationDate: KotlinString? = null
    var _presentationDate: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> documentType = decoder.decodeStringElement(__desc, __i)
        4 ->
          _documentType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.documentTypeSer, null)
        5 -> reference = decoder.decodeStringElement(__desc, __i)
        6 ->
          _reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.documentTypeSer, null)
        7 -> publicationDate = decoder.decodeStringElement(__desc, __i)
        8 ->
          _publicationDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.documentTypeSer, null)
        9 -> presentationDate = decoder.decodeStringElement(__desc, __i)
        10 ->
          _presentationDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.documentTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Education: " + __i)
      }
    }
    return Immunization.Education(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      documentType = R4String.of(documentType, _documentType),
      reference = Uri.of(reference, _reference),
      publicationDate = DateTime.of(FhirDateTime.fromString(publicationDate), _publicationDate),
      presentationDate = DateTime.of(FhirDateTime.fromString(presentationDate), _presentationDate),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Immunization.Education) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.documentType?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.documentType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.documentTypeSer, it)
    }
    ((value.reference?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.reference?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.documentTypeSer, it)
    }
    ((value.publicationDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.publicationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.documentTypeSer, it)
    }
    ((value.presentationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 9, it)
    }
    (value.presentationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.documentTypeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val documentTypeSer: KSerializer<Element> = Element.serializer()
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
      element("detail", Reference.serializer().descriptor, isOptional = true)
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
    var detail: Reference? = null
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
          detail = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.detailSer, null)
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
      detail = detail,
      reported = R4Boolean.of(reported, _reported),
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
    (value.detail)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.detailSer, it) }
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

    public val detailSer: KSerializer<Reference> = Reference.serializer()
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
      element("doseNumberPositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_doseNumberPositiveInt", Element.serializer().descriptor, isOptional = true)
      element("doseNumberString", KotlinString.serializer().descriptor, isOptional = true)
      element("_doseNumberString", Element.serializer().descriptor, isOptional = true)
      element("seriesDosesPositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_seriesDosesPositiveInt", Element.serializer().descriptor, isOptional = true)
      element("seriesDosesString", KotlinString.serializer().descriptor, isOptional = true)
      element("_seriesDosesString", Element.serializer().descriptor, isOptional = true)
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
    var doseNumberPositiveInt: Int? = null
    var _doseNumberPositiveInt: Element? = null
    var doseNumberString: KotlinString? = null
    var _doseNumberString: Element? = null
    var seriesDosesPositiveInt: Int? = null
    var _seriesDosesPositiveInt: Element? = null
    var seriesDosesString: KotlinString? = null
    var _seriesDosesString: Element? = null
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
        7 -> doseNumberPositiveInt = decoder.decodeIntElement(__desc, __i)
        8 ->
          _doseNumberPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.seriesSer, null)
        9 -> doseNumberString = decoder.decodeStringElement(__desc, __i)
        10 ->
          _doseNumberString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.seriesSer, null)
        11 -> seriesDosesPositiveInt = decoder.decodeIntElement(__desc, __i)
        12 ->
          _seriesDosesPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.seriesSer, null)
        13 -> seriesDosesString = decoder.decodeStringElement(__desc, __i)
        14 ->
          _seriesDosesString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.seriesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProtocolApplied: " + __i)
      }
    }
    return Immunization.ProtocolApplied(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      series = R4String.of(series, _series),
      authority = authority,
      targetDisease = targetDisease ?: listOf(),
      doseNumber =
        Immunization.ProtocolApplied.DoseNumber.from(
          PositiveInt.of(doseNumberPositiveInt, _doseNumberPositiveInt),
          R4String.of(doseNumberString, _doseNumberString),
        )!!,
      seriesDoses =
        Immunization.ProtocolApplied.SeriesDoses.from(
          PositiveInt.of(seriesDosesPositiveInt, _seriesDosesPositiveInt),
          R4String.of(seriesDosesString, _seriesDosesString),
        ),
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
    when (val __d = value.doseNumber) {
      null -> {}
      is Immunization.ProtocolApplied.DoseNumber.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.seriesSer, it)
        }
      }
      is Immunization.ProtocolApplied.DoseNumber.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.seriesSer, it)
        }
      }
    }
    when (val __d = value.seriesDoses) {
      null -> {}
      is Immunization.ProtocolApplied.SeriesDoses.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.seriesSer, it)
        }
      }
      is Immunization.ProtocolApplied.SeriesDoses.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.seriesSer, it)
        }
      }
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("vaccineCode", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurrenceString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurrenceString", Element.serializer().descriptor, isOptional = true)
    b.element("recorded", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_recorded", Element.serializer().descriptor, isOptional = true)
    b.element("primarySource", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_primarySource", Element.serializer().descriptor, isOptional = true)
    b.element("reportOrigin", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element("manufacturer", Reference.serializer().descriptor, isOptional = true)
    b.element("lotNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lotNumber", Element.serializer().descriptor, isOptional = true)
    b.element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_expirationDate", Element.serializer().descriptor, isOptional = true)
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
      "reasonCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reasonReference",
      listSerialDescriptor(Reference.serializer().descriptor),
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
      "education",
      listSerialDescriptor(lazyDescriptor { Immunization.Education.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "programEligibility",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
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
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: CodeableConcept? = null
    var vaccineCode: CodeableConcept? = null
    var patient: Reference? = null
    var encounter: Reference? = null
    var occurrenceDateTime: KotlinString? = null
    var _occurrenceDateTime: Element? = null
    var occurrenceString: KotlinString? = null
    var _occurrenceString: Element? = null
    var recorded: KotlinString? = null
    var _recorded: Element? = null
    var primarySource: KotlinBoolean? = null
    var _primarySource: Element? = null
    var reportOrigin: CodeableConcept? = null
    var location: Reference? = null
    var manufacturer: Reference? = null
    var lotNumber: KotlinString? = null
    var _lotNumber: Element? = null
    var expirationDate: KotlinString? = null
    var _expirationDate: Element? = null
    var site: CodeableConcept? = null
    var route: CodeableConcept? = null
    var doseQuantity: Quantity? = null
    var performer: List<Immunization.Performer>? = null
    var note: List<Annotation>? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var isSubpotent: KotlinBoolean? = null
    var _isSubpotent: Element? = null
    var subpotentReason: List<CodeableConcept>? = null
    var education: List<Immunization.Education>? = null
    var programEligibility: List<CodeableConcept>? = null
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
        11 -> status = decoder.decodeStringElement(__desc, __i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        14 ->
          vaccineCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        15 ->
          patient = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        17 -> occurrenceDateTime = decoder.decodeStringElement(__desc, __i)
        18 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> occurrenceString = decoder.decodeStringElement(__desc, __i)
        20 ->
          _occurrenceString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> recorded = decoder.decodeStringElement(__desc, __i)
        22 ->
          _recorded =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> primarySource = decoder.decodeBooleanElement(__desc, __i)
        24 ->
          _primarySource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 ->
          reportOrigin =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        26 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        27 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        28 -> lotNumber = decoder.decodeStringElement(__desc, __i)
        29 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 -> expirationDate = decoder.decodeStringElement(__desc, __i)
        31 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        32 ->
          site =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        33 ->
          route =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        34 ->
          doseQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.doseQuantitySer, null)
        35 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerSer, null)
        36 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        37 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonCodeSer, null)
        38 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonReferenceSer, null)
        39 -> isSubpotent = decoder.decodeBooleanElement(__desc, __i)
        40 ->
          _isSubpotent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        41 ->
          subpotentReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonCodeSer, null)
        42 ->
          education =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.educationSer, null)
        43 ->
          programEligibility =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonCodeSer, null)
        44 ->
          fundingSource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        45 ->
          reaction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reactionSer, null)
        46 ->
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
      status = Enumeration.of(Immunization.ImmunizationStatusCodes.fromCode(status!!), _status),
      statusReason = statusReason,
      vaccineCode = vaccineCode!!,
      patient = patient!!,
      encounter = encounter,
      occurrence =
        Immunization.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          R4String.of(occurrenceString, _occurrenceString),
        )!!,
      recorded = DateTime.of(FhirDateTime.fromString(recorded), _recorded),
      primarySource = R4Boolean.of(primarySource, _primarySource),
      reportOrigin = reportOrigin,
      location = location,
      manufacturer = manufacturer,
      lotNumber = R4String.of(lotNumber, _lotNumber),
      expirationDate = Date.of(FhirDate.fromString(expirationDate), _expirationDate),
      site = site,
      route = route,
      doseQuantity = doseQuantity,
      performer = performer ?: listOf(),
      note = note ?: listOf(),
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      isSubpotent = R4Boolean.of(isSubpotent, _isSubpotent),
      subpotentReason = subpotentReason ?: listOf(),
      education = education ?: listOf(),
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.statusReasonSer, it)
    }
    (value.vaccineCode)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.statusReasonSer, it)
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.patientSer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.patientSer, it)
    }
    when (val __d = value.occurrence) {
      null -> {}
      is Immunization.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Immunization.Occurrence.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.recorded?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 21 + __off, it)
    }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.primarySource?.value))?.let { encoder.encodeBooleanElement(__desc, 23 + __off, it) }
    (value.primarySource?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.reportOrigin)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.statusReasonSer, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.patientSer, it)
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.patientSer, it)
    }
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.expirationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 30 + __off, it)
    }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.site)?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.statusReasonSer, it)
    }
    (value.route)?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.statusReasonSer, it)
    }
    (value.doseQuantity)?.let {
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.doseQuantitySer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.performerSer, value.performer)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.noteSer, value.note)
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.reasonCodeSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        38 + __off,
        Hoisted.reasonReferenceSer,
        value.reasonReference,
      )
    ((value.isSubpotent?.value))?.let { encoder.encodeBooleanElement(__desc, 39 + __off, it) }
    (value.isSubpotent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.subpotentReason.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        41 + __off,
        Hoisted.reasonCodeSer,
        value.subpotentReason,
      )
    if (value.education.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.educationSer, value.education)
    if (value.programEligibility.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        43 + __off,
        Hoisted.reasonCodeSer,
        value.programEligibility,
      )
    (value.fundingSource)?.let {
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.statusReasonSer, it)
    }
    if (value.reaction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.reactionSer, value.reaction)
    if (value.protocolApplied.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        46 + __off,
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

    public val statusReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val doseQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val performerSerInner: KSerializer<Immunization.Performer> =
      Immunization.Performer.serializer()

    public val performerSer: KSerializer<List<Immunization.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val reasonCodeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val reasonReferenceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.patientSer)

    public val educationSerInner: KSerializer<Immunization.Education> =
      Immunization.Education.serializer()

    public val educationSer: KSerializer<List<Immunization.Education>> =
      ListSerializer(Hoisted.educationSerInner)

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
