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
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Immunization
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Immunization.Performer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Immunization.Performer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var function: CodeableConcept? = null
      var actor: Reference? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Performer: " + i)
        }
      }
      Immunization.Performer(
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

  override fun serialize(encoder: Encoder, `value`: Immunization.Performer) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.function)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    }
  }
}

internal object ImmunizationEducationSerializer : KSerializer<Immunization.Education> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Education") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("documentType", KotlinString.serializer().descriptor)
      optionalElement("_documentType", ElementSerializer.descriptor)
      optionalElement("reference", KotlinString.serializer().descriptor)
      optionalElement("_reference", ElementSerializer.descriptor)
      optionalElement("publicationDate", KotlinString.serializer().descriptor)
      optionalElement("_publicationDate", ElementSerializer.descriptor)
      optionalElement("presentationDate", KotlinString.serializer().descriptor)
      optionalElement("_presentationDate", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Immunization.Education>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Immunization.Education =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> documentType = decodeStringElement(descriptor, i)
          4 ->
            _documentType =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> reference = decodeStringElement(descriptor, i)
          6 ->
            _reference = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> publicationDate = decodeStringElement(descriptor, i)
          8 ->
            _publicationDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> presentationDate = decodeStringElement(descriptor, i)
          10 ->
            _presentationDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Education: " + i)
        }
      }
      Immunization.Education(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        documentType = R4bString.of(documentType, _documentType),
        reference = Uri.of(reference, _reference),
        publicationDate =
          DateTime.of(
            if (publicationDate != null) FhirDateTime.fromString(publicationDate) else null,
            _publicationDate,
          ),
        presentationDate =
          DateTime.of(
            if (presentationDate != null) FhirDateTime.fromString(presentationDate) else null,
            _presentationDate,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Immunization.Education) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.documentType?.value)
      encodeElementIfNotNull(descriptor, 4, value.documentType)
      encodeStringIfNotNull(descriptor, 5, value.reference?.value)
      encodeElementIfNotNull(descriptor, 6, value.reference)
      encodeStringIfNotNull(descriptor, 7, value.publicationDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 8, value.publicationDate)
      encodeStringIfNotNull(descriptor, 9, value.presentationDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 10, value.presentationDate)
    }
  }
}

internal object ImmunizationReactionSerializer : KSerializer<Immunization.Reaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Reaction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("detail", ReferenceSerializer.descriptor)
      optionalElement("reported", KotlinBoolean.serializer().descriptor)
      optionalElement("_reported", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Immunization.Reaction>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Immunization.Reaction =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var date: KotlinString? = null
      var _date: Element? = null
      var detail: Reference? = null
      var reported: KotlinBoolean? = null
      var _reported: Element? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> date = decodeStringElement(descriptor, i)
          4 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> detail = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> reported = decodeBooleanElement(descriptor, i)
          7 -> _reported = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Reaction: " + i)
        }
      }
      Immunization.Reaction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
        detail = detail,
        reported = R4bBoolean.of(reported, _reported),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Immunization.Reaction) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 4, value.date)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.detail)
      encodeBooleanIfNotNull(descriptor, 6, value.reported?.value)
      encodeElementIfNotNull(descriptor, 7, value.reported)
    }
  }
}

internal object ImmunizationProtocolAppliedSerializer : KSerializer<Immunization.ProtocolApplied> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProtocolApplied") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("series", KotlinString.serializer().descriptor)
      optionalElement("_series", ElementSerializer.descriptor)
      optionalElement("authority", ReferenceSerializer.descriptor)
      optionalElement("targetDisease", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("doseNumberPositiveInt", Int.serializer().descriptor)
      optionalElement("_doseNumberPositiveInt", ElementSerializer.descriptor)
      optionalElement("doseNumberString", KotlinString.serializer().descriptor)
      optionalElement("_doseNumberString", ElementSerializer.descriptor)
      optionalElement("seriesDosesPositiveInt", Int.serializer().descriptor)
      optionalElement("_seriesDosesPositiveInt", ElementSerializer.descriptor)
      optionalElement("seriesDosesString", KotlinString.serializer().descriptor)
      optionalElement("_seriesDosesString", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Immunization.ProtocolApplied>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Immunization.ProtocolApplied =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> series = decodeStringElement(descriptor, i)
          4 -> _series = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            authority = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 ->
            targetDisease =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          7 -> doseNumberPositiveInt = decodeIntElement(descriptor, i)
          8 ->
            _doseNumberPositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> doseNumberString = decodeStringElement(descriptor, i)
          10 ->
            _doseNumberString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> seriesDosesPositiveInt = decodeIntElement(descriptor, i)
          12 ->
            _seriesDosesPositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> seriesDosesString = decodeStringElement(descriptor, i)
          14 ->
            _seriesDosesString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ProtocolApplied: " + i)
        }
      }
      Immunization.ProtocolApplied(
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

  override fun serialize(encoder: Encoder, `value`: Immunization.ProtocolApplied) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.series?.value)
      encodeElementIfNotNull(descriptor, 4, value.series)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.authority)
      if (value.targetDisease.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer.listSerializer,
          value.targetDisease,
        )
      when (val choice = value.doseNumber) {
        is Immunization.ProtocolApplied.DoseNumber.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Immunization.ProtocolApplied.DoseNumber.String -> {
          encodeStringIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
      }
      when (val choice = value.seriesDoses) {
        null -> {}
        is Immunization.ProtocolApplied.SeriesDoses.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is Immunization.ProtocolApplied.SeriesDoses.String -> {
          encodeStringIfNotNull(descriptor, 13, choice.value.value)
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
      }
    }
  }
}

internal object ImmunizationSerializer : FhirResourceSerializer<Immunization> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Immunization")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("vaccineCode", CodeableConceptSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurrenceString", KotlinString.serializer().descriptor)
    b.optionalElement("_occurrenceString", ElementSerializer.descriptor)
    b.optionalElement("recorded", KotlinString.serializer().descriptor)
    b.optionalElement("_recorded", ElementSerializer.descriptor)
    b.optionalElement("primarySource", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_primarySource", ElementSerializer.descriptor)
    b.optionalElement("reportOrigin", CodeableConceptSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.descriptor)
    b.optionalElement("lotNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_lotNumber", ElementSerializer.descriptor)
    b.optionalElement("expirationDate", KotlinString.serializer().descriptor)
    b.optionalElement("_expirationDate", ElementSerializer.descriptor)
    b.optionalElement("site", CodeableConceptSerializer.descriptor)
    b.optionalElement("route", CodeableConceptSerializer.descriptor)
    b.optionalElement("doseQuantity", QuantitySerializer.descriptor)
    b.optionalElement("performer", ImmunizationPerformerSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("isSubpotent", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_isSubpotent", ElementSerializer.descriptor)
    b.optionalElement("subpotentReason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("education", ImmunizationEducationSerializer.listSerializer.descriptor)
    b.optionalElement("programEligibility", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("fundingSource", CodeableConceptSerializer.descriptor)
    b.optionalElement("reaction", ImmunizationReactionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "protocolApplied",
      ImmunizationProtocolAppliedSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          statusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          vaccineCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        18 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> occurrenceString = decoder.decodeStringElement(descriptor, i)
        20 ->
          _occurrenceString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> recorded = decoder.decodeStringElement(descriptor, i)
        22 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> primarySource = decoder.decodeBooleanElement(descriptor, i)
        24 ->
          _primarySource =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          reportOrigin =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 -> lotNumber = decoder.decodeStringElement(descriptor, i)
        29 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        31 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          site =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        33 ->
          route =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        34 ->
          doseQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        35 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImmunizationPerformerSerializer.listSerializer,
              null,
            )
        36 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        37 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        38 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        39 -> isSubpotent = decoder.decodeBooleanElement(descriptor, i)
        40 ->
          _isSubpotent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          subpotentReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        42 ->
          education =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImmunizationEducationSerializer.listSerializer,
              null,
            )
        43 ->
          programEligibility =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        44 ->
          fundingSource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        45 ->
          reaction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImmunizationReactionSerializer.listSerializer,
              null,
            )
        46 ->
          protocolApplied =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImmunizationProtocolAppliedSerializer.listSerializer,
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
        Enumeration.of(
          if (status != null) Immunization.ImmunizationStatusCodes.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Immunization"),
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
          DateTime.of(
            if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
            _occurrenceDateTime,
          ),
          R4bString.of(occurrenceString, _occurrenceString),
        ) ?: throw SerializationException("Missing required property 'occurrence' on Immunization"),
      recorded =
        DateTime.of(if (recorded != null) FhirDateTime.fromString(recorded) else null, _recorded),
      primarySource = R4bBoolean.of(primarySource, _primarySource),
      reportOrigin = reportOrigin,
      location = location,
      manufacturer = manufacturer,
      lotNumber = R4bString.of(lotNumber, _lotNumber),
      expirationDate =
        Date.of(
          if (expirationDate != null) FhirDate.fromString(expirationDate) else null,
          _expirationDate,
        ),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Immunization,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.statusReason,
    )
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.vaccineCode,
    )
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.occurrence) {
      is Immunization.Occurrence.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          17 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, choice.value)
      }
      is Immunization.Occurrence.String -> {
        encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.recorded?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.recorded)
    encoder.encodeBooleanIfNotNull(descriptor, 23 + descriptorOffset, value.primarySource?.value)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.primarySource)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.reportOrigin,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.manufacturer,
    )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.lotNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.lotNumber)
    encoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.expirationDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.expirationDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      CodeableConceptSerializer,
      value.site,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      CodeableConceptSerializer,
      value.route,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      QuantitySerializer,
      value.doseQuantity,
    )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ImmunizationPerformerSerializer.listSerializer,
        value.performer,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.reasonReference,
      )
    encoder.encodeBooleanIfNotNull(descriptor, 39 + descriptorOffset, value.isSubpotent?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.isSubpotent)
    if (value.subpotentReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.subpotentReason,
      )
    if (value.education.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ImmunizationEducationSerializer.listSerializer,
        value.education,
      )
    if (value.programEligibility.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.programEligibility,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      CodeableConceptSerializer,
      value.fundingSource,
    )
    if (value.reaction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        ImmunizationReactionSerializer.listSerializer,
        value.reaction,
      )
    if (value.protocolApplied.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        ImmunizationProtocolAppliedSerializer.listSerializer,
        value.protocolApplied,
      )
  }
}
