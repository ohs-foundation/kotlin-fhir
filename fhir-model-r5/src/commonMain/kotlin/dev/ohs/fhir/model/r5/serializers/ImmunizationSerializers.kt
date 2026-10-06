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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Immunization
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object ImmunizationProgramEligibilitySerializer :
  KSerializer<Immunization.ProgramEligibility> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProgramEligibility") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("program", CodeableConceptSerializer.descriptor)
      optionalElement("programStatus", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Immunization.ProgramEligibility>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Immunization.ProgramEligibility =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var program: CodeableConcept? = null
      var programStatus: CodeableConcept? = null
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
            program =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            programStatus =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ProgramEligibility: " + i)
        }
      }
      Immunization.ProgramEligibility(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        program =
          program
            ?: throw SerializationException(
              "Missing required property 'program' on Immunization.ProgramEligibility"
            ),
        programStatus =
          programStatus
            ?: throw SerializationException(
              "Missing required property 'programStatus' on Immunization.ProgramEligibility"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Immunization.ProgramEligibility) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.program)
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.programStatus)
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
      optionalElement("manifestation", CodeableReferenceSerializer.descriptor)
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
      var manifestation: CodeableReference? = null
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
          5 ->
            manifestation =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
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
        manifestation = manifestation,
        reported = R5Boolean.of(reported, _reported),
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
      encodeSerializableIfNotNull(descriptor, 5, CodeableReferenceSerializer, value.manifestation)
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
      optionalElement("doseNumber", KotlinString.serializer().descriptor)
      optionalElement("_doseNumber", ElementSerializer.descriptor)
      optionalElement("seriesDoses", KotlinString.serializer().descriptor)
      optionalElement("_seriesDoses", ElementSerializer.descriptor)
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
      var doseNumber: KotlinString? = null
      var _doseNumber: Element? = null
      var seriesDoses: KotlinString? = null
      var _seriesDoses: Element? = null
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
          7 -> doseNumber = decodeStringElement(descriptor, i)
          8 ->
            _doseNumber = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> seriesDoses = decodeStringElement(descriptor, i)
          10 ->
            _seriesDoses = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ProtocolApplied: " + i)
        }
      }
      Immunization.ProtocolApplied(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        series = R5String.of(series, _series),
        authority = authority,
        targetDisease = targetDisease ?: listOf(),
        doseNumber =
          R5String.of(doseNumber, _doseNumber)
            ?: throw SerializationException(
              "Missing required property 'doseNumber' on Immunization.ProtocolApplied"
            ),
        seriesDoses = R5String.of(seriesDoses, _seriesDoses),
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
      encodeStringIfNotNull(descriptor, 7, value.doseNumber.value)
      encodeElementIfNotNull(descriptor, 8, value.doseNumber)
      encodeStringIfNotNull(descriptor, 9, value.seriesDoses?.value)
      encodeElementIfNotNull(descriptor, 10, value.seriesDoses)
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
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("vaccineCode", CodeableConceptSerializer.descriptor)
    b.optionalElement("administeredProduct", CodeableReferenceSerializer.descriptor)
    b.optionalElement("manufacturer", CodeableReferenceSerializer.descriptor)
    b.optionalElement("lotNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_lotNumber", ElementSerializer.descriptor)
    b.optionalElement("expirationDate", KotlinString.serializer().descriptor)
    b.optionalElement("_expirationDate", ElementSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurrenceString", KotlinString.serializer().descriptor)
    b.optionalElement("_occurrenceString", ElementSerializer.descriptor)
    b.optionalElement("primarySource", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_primarySource", ElementSerializer.descriptor)
    b.optionalElement("informationSource", CodeableReferenceSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("site", CodeableConceptSerializer.descriptor)
    b.optionalElement("route", CodeableConceptSerializer.descriptor)
    b.optionalElement("doseQuantity", QuantitySerializer.descriptor)
    b.optionalElement("performer", ImmunizationPerformerSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("isSubpotent", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_isSubpotent", ElementSerializer.descriptor)
    b.optionalElement("subpotentReason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "programEligibility",
      ImmunizationProgramEligibilitySerializer.listSerializer.descriptor,
    )
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
        11 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          statusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          vaccineCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          administeredProduct =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        17 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        18 -> lotNumber = decoder.decodeStringElement(descriptor, i)
        19 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        21 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        25 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        26 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> occurrenceString = decoder.decodeStringElement(descriptor, i)
        28 ->
          _occurrenceString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 -> primarySource = decoder.decodeBooleanElement(descriptor, i)
        30 ->
          _primarySource =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          informationSource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        32 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        33 ->
          site =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        34 ->
          route =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        35 ->
          doseQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        36 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImmunizationPerformerSerializer.listSerializer,
              null,
            )
        37 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        38 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
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
          programEligibility =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImmunizationProgramEligibilitySerializer.listSerializer,
              null,
            )
        43 ->
          fundingSource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        44 ->
          reaction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImmunizationReactionSerializer.listSerializer,
              null,
            )
        45 ->
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
      basedOn = basedOn ?: listOf(),
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
      administeredProduct = administeredProduct,
      manufacturer = manufacturer,
      lotNumber = R5String.of(lotNumber, _lotNumber),
      expirationDate =
        Date.of(
          if (expirationDate != null) FhirDate.fromString(expirationDate) else null,
          _expirationDate,
        ),
      patient =
        patient
          ?: throw SerializationException("Missing required property 'patient' on Immunization"),
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      occurrence =
        Immunization.Occurrence.from(
          DateTime.of(
            if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
            _occurrenceDateTime,
          ),
          R5String.of(occurrenceString, _occurrenceString),
        ) ?: throw SerializationException("Missing required property 'occurrence' on Immunization"),
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.statusReason,
    )
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.vaccineCode,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableReferenceSerializer,
      value.administeredProduct,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableReferenceSerializer,
      value.manufacturer,
    )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.lotNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.lotNumber)
    encoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.expirationDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.expirationDate)
    encoder.encodeSerializableElement(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    when (val choice = value.occurrence) {
      is Immunization.Occurrence.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          25 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, choice.value)
      }
      is Immunization.Occurrence.String -> {
        encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeBooleanIfNotNull(descriptor, 29 + descriptorOffset, value.primarySource?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.primarySource)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      CodeableReferenceSerializer,
      value.informationSource,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      CodeableConceptSerializer,
      value.site,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      CodeableConceptSerializer,
      value.route,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      QuantitySerializer,
      value.doseQuantity,
    )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ImmunizationPerformerSerializer.listSerializer,
        value.performer,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
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
    if (value.programEligibility.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ImmunizationProgramEligibilitySerializer.listSerializer,
        value.programEligibility,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      43 + descriptorOffset,
      CodeableConceptSerializer,
      value.fundingSource,
    )
    if (value.reaction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        ImmunizationReactionSerializer.listSerializer,
        value.reaction,
      )
    if (value.protocolApplied.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        ImmunizationProtocolAppliedSerializer.listSerializer,
        value.protocolApplied,
      )
  }
}
