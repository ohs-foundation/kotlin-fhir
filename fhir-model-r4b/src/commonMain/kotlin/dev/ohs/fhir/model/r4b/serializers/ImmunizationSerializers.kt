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
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Immunization
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Immunization.Performer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Immunization.Performer {
    var id: KotlinString? = null
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
    return Immunization.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor =
        actor
          ?: throw SerializationException(
            "Missing required property 'actor' on Immunization.Performer"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Immunization.Performer) {
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Immunization.Education) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Immunization.Education {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> documentType = decoder.decodeStringElement(descriptor, i)
        4 ->
          _documentType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentTypeSer, null)
        5 -> reference = decoder.decodeStringElement(descriptor, i)
        6 ->
          _reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentTypeSer, null)
        7 -> publicationDate = decoder.decodeStringElement(descriptor, i)
        8 ->
          _publicationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentTypeSer, null)
        9 -> presentationDate = decoder.decodeStringElement(descriptor, i)
        10 ->
          _presentationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Education: " + i)
      }
    }
    return Immunization.Education(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      documentType = R4bString.of(documentType, _documentType),
      reference = Uri.of(reference, _reference),
      publicationDate = DateTime.of(FhirDateTime.fromString(publicationDate), _publicationDate),
      presentationDate = DateTime.of(FhirDateTime.fromString(presentationDate), _presentationDate),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Immunization.Education) {
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
    ((value.documentType?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.documentType?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.documentTypeSer, it)
    }
    ((value.reference?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.reference?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.documentTypeSer, it)
    }
    ((value.publicationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 7, it)
    }
    (value.publicationDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.documentTypeSer, it)
    }
    ((value.presentationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 9, it)
    }
    (value.presentationDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.documentTypeSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Immunization.Reaction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Immunization.Reaction {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var detail: Reference? = null
    var reported: KotlinBoolean? = null
    var _reported: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> date = decoder.decodeStringElement(descriptor, i)
        4 -> _date = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateSer, null)
        5 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        6 -> reported = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _reported =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Reaction: " + i)
      }
    }
    return Immunization.Reaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      detail = detail,
      reported = R4bBoolean.of(reported, _reported),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Immunization.Reaction) {
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
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.dateSer, it)
    }
    (value.detail)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.detailSer, it) }
    ((value.reported?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.reported?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.dateSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Immunization.ProtocolApplied) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Immunization.ProtocolApplied {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> series = decoder.decodeStringElement(descriptor, i)
        4 ->
          _series =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.seriesSer, null)
        5 ->
          authority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authoritySer, null)
        6 ->
          targetDisease =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetDiseaseSer, null)
        7 -> doseNumberPositiveInt = decoder.decodeIntElement(descriptor, i)
        8 ->
          _doseNumberPositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.seriesSer, null)
        9 -> doseNumberString = decoder.decodeStringElement(descriptor, i)
        10 ->
          _doseNumberString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.seriesSer, null)
        11 -> seriesDosesPositiveInt = decoder.decodeIntElement(descriptor, i)
        12 ->
          _seriesDosesPositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.seriesSer, null)
        13 -> seriesDosesString = decoder.decodeStringElement(descriptor, i)
        14 ->
          _seriesDosesString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.seriesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProtocolApplied: " + i)
      }
    }
    return Immunization.ProtocolApplied(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      series = R4bString.of(series, _series),
      authority = authority,
      targetDisease = targetDisease ?: listOf(),
      doseNumber =
        Immunization.ProtocolApplied.DoseNumber.from(
          PositiveInt.of(doseNumberPositiveInt, _doseNumberPositiveInt),
          R4bString.of(doseNumberString, _doseNumberString),
        )
          ?: throw SerializationException(
            "Missing required property 'doseNumber' on Immunization.ProtocolApplied"
          ),
      seriesDoses =
        Immunization.ProtocolApplied.SeriesDoses.from(
          PositiveInt.of(seriesDosesPositiveInt, _seriesDosesPositiveInt),
          R4bString.of(seriesDosesString, _seriesDosesString),
        ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Immunization.ProtocolApplied) {
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
    ((value.series?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.series?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.seriesSer, it)
    }
    (value.authority)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.authoritySer, it)
    }
    if (value.targetDisease.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        Hoisted.targetDiseaseSer,
        value.targetDisease,
      )
    when (val choice = value.doseNumber) {
      is Immunization.ProtocolApplied.DoseNumber.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.seriesSer, it)
        }
      }
      is Immunization.ProtocolApplied.DoseNumber.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.seriesSer, it)
        }
      }
    }
    when (val choice = value.seriesDoses) {
      null -> {}
      is Immunization.ProtocolApplied.SeriesDoses.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.seriesSer, it)
        }
      }
      is Immunization.ProtocolApplied.SeriesDoses.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.seriesSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Immunization) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Immunization")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Immunization {
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        14 ->
          vaccineCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        17 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        18 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> occurrenceString = decoder.decodeStringElement(descriptor, i)
        20 ->
          _occurrenceString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> recorded = decoder.decodeStringElement(descriptor, i)
        22 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> primarySource = decoder.decodeBooleanElement(descriptor, i)
        24 ->
          _primarySource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          reportOrigin =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        26 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        27 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        28 -> lotNumber = decoder.decodeStringElement(descriptor, i)
        29 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        31 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 ->
          site =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        33 ->
          route =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        34 ->
          doseQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doseQuantitySer, null)
        35 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        36 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        37 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonCodeSer, null)
        38 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reasonReferenceSer,
              null,
            )
        39 -> isSubpotent = decoder.decodeBooleanElement(descriptor, i)
        40 ->
          _isSubpotent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 ->
          subpotentReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonCodeSer, null)
        42 ->
          education =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.educationSer, null)
        43 ->
          programEligibility =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonCodeSer, null)
        44 ->
          fundingSource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        45 ->
          reaction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reactionSer, null)
        46 ->
          protocolApplied =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.protocolAppliedSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Immunization: " + i)
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
      status =
        Enumeration.of(status?.let { Immunization.ImmunizationStatusCodes.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on Immunization"),
      statusReason = statusReason,
      vaccineCode =
        vaccineCode
          ?: throw SerializationException(
            "Missing required property 'vaccineCode' on Immunization"
          ),
      patient =
        patient
          ?: throw SerializationException("Missing required property 'patient' on Immunization"),
      encounter = encounter,
      occurrence =
        Immunization.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          R4bString.of(occurrenceString, _occurrenceString),
        ) ?: throw SerializationException("Missing required property 'occurrence' on Immunization"),
      recorded = DateTime.of(FhirDateTime.fromString(recorded), _recorded),
      primarySource = R4bBoolean.of(primarySource, _primarySource),
      reportOrigin = reportOrigin,
      location = location,
      manufacturer = manufacturer,
      lotNumber = R4bString.of(lotNumber, _lotNumber),
      expirationDate = Date.of(FhirDate.fromString(expirationDate), _expirationDate),
      site = site,
      route = route,
      doseQuantity = doseQuantity,
      performer = performer ?: listOf(),
      note = note ?: listOf(),
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      isSubpotent = R4bBoolean.of(isSubpotent, _isSubpotent),
      subpotentReason = subpotentReason ?: listOf(),
      education = education ?: listOf(),
      programEligibility = programEligibility ?: listOf(),
      fundingSource = fundingSource,
      reaction = reaction ?: listOf(),
      protocolApplied = protocolApplied ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Immunization,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      Hoisted.statusReasonSer,
      value.vaccineCode,
    )
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      Hoisted.patientSer,
      value.patient,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.patientSer, it)
    }
    when (val choice = value.occurrence) {
      is Immunization.Occurrence.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            18 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Immunization.Occurrence.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            20 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    ((value.recorded?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.primarySource?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.primarySource?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.reportOrigin)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 26 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.patientSer, it)
    }
    ((value.lotNumber?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.expirationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.site)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    (value.route)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    (value.doseQuantity)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.doseQuantitySer,
        it,
      )
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.performerSer,
        value.performer,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.reasonCodeSer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.reasonReferenceSer,
        value.reasonReference,
      )
    ((value.isSubpotent?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.isSubpotent?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.subpotentReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.reasonCodeSer,
        value.subpotentReason,
      )
    if (value.education.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.educationSer,
        value.education,
      )
    if (value.programEligibility.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.reasonCodeSer,
        value.programEligibility,
      )
    (value.fundingSource)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    if (value.reaction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.reactionSer,
        value.reaction,
      )
    if (value.protocolApplied.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
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
      ImmunizationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Immunization =
    decoder.decodeStructure(descriptor) {
      ImmunizationSerializer.deserializeInternal(this, descriptor, 0)
    }
}
