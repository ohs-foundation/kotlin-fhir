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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicinalProductAuthorization
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.Uri
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

internal object MedicinalProductAuthorizationJurisdictionalAuthorizationSerializer :
  KSerializer<MedicinalProductAuthorization.JurisdictionalAuthorization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("JurisdictionalAuthorization") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("country", CodeableConceptSerializer.descriptor)
      optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("legalStatusOfSupply", CodeableConceptSerializer.descriptor)
      optionalElement("validityPeriod", PeriodSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<MedicinalProductAuthorization.JurisdictionalAuthorization>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductAuthorization.JurisdictionalAuthorization =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: List<Identifier>? = null
      var country: CodeableConcept? = null
      var jurisdiction: List<CodeableConcept>? = null
      var legalStatusOfSupply: CodeableConcept? = null
      var validityPeriod: Period? = null
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
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            country =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            jurisdiction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 ->
            legalStatusOfSupply =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            validityPeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException(
              "Unexpected index decoding JurisdictionalAuthorization: " + i
            )
        }
      }
      MedicinalProductAuthorization.JurisdictionalAuthorization(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier ?: listOf(),
        country = country,
        jurisdiction = jurisdiction ?: listOf(),
        legalStatusOfSupply = legalStatusOfSupply,
        validityPeriod = validityPeriod,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductAuthorization.JurisdictionalAuthorization,
  ) {
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
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.country)
      if (value.jurisdiction.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.jurisdiction,
        )
      encodeSerializableIfNotNull(
        descriptor,
        6,
        CodeableConceptSerializer,
        value.legalStatusOfSupply,
      )
      encodeSerializableIfNotNull(descriptor, 7, PeriodSerializer, value.validityPeriod)
    }
  }
}

internal object MedicinalProductAuthorizationProcedureSerializer :
  KSerializer<MedicinalProductAuthorization.Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("datePeriod", PeriodSerializer.descriptor)
      optionalElement("dateDateTime", String.serializer().descriptor)
      optionalElement("_dateDateTime", ElementSerializer.descriptor)
      optionalElement(
        "application",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductAuthorizationProcedureSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<MedicinalProductAuthorization.Procedure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductAuthorization.Procedure =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: Identifier? = null
      var type: CodeableConcept? = null
      var datePeriod: Period? = null
      var dateDateTime: String? = null
      var _dateDateTime: Element? = null
      var application: List<MedicinalProductAuthorization.Procedure>? = null
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
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> datePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          6 -> dateDateTime = decodeStringElement(descriptor, i)
          7 ->
            _dateDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            application =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductAuthorizationProcedureSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Procedure: " + i)
        }
      }
      MedicinalProductAuthorization.Procedure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier,
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicinalProductAuthorization.Procedure"
            ),
        date =
          MedicinalProductAuthorization.Procedure.Date.from(
            datePeriod,
            DateTime.of(
              if (dateDateTime != null) FhirDateTime.fromString(dateDateTime) else null,
              _dateDateTime,
            ),
          ),
        application = application ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductAuthorization.Procedure) {
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
      encodeSerializableIfNotNull(descriptor, 3, IdentifierSerializer, value.identifier)
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.type)
      when (val choice = value.date) {
        null -> {}
        is MedicinalProductAuthorization.Procedure.Date.Period -> {
          encodeSerializableElement(descriptor, 5, PeriodSerializer, choice.value)
        }
        is MedicinalProductAuthorization.Procedure.Date.DateTime -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
      }
      if (value.application.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          MedicinalProductAuthorizationProcedureSerializer.listSerializer,
          value.application,
        )
    }
  }
}

internal object MedicinalProductAuthorizationSerializer :
  FhirResourceSerializer<MedicinalProductAuthorization> {
  override val descriptor: SerialDescriptor =
    buildResourceDescriptor("MedicinalProductAuthorization")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("country", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.optionalElement("statusDate", String.serializer().descriptor)
    b.optionalElement("_statusDate", ElementSerializer.descriptor)
    b.optionalElement("restoreDate", String.serializer().descriptor)
    b.optionalElement("_restoreDate", ElementSerializer.descriptor)
    b.optionalElement("validityPeriod", PeriodSerializer.descriptor)
    b.optionalElement("dataExclusivityPeriod", PeriodSerializer.descriptor)
    b.optionalElement("dateOfFirstAuthorization", String.serializer().descriptor)
    b.optionalElement("_dateOfFirstAuthorization", ElementSerializer.descriptor)
    b.optionalElement("internationalBirthDate", String.serializer().descriptor)
    b.optionalElement("_internationalBirthDate", ElementSerializer.descriptor)
    b.optionalElement("legalBasis", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "jurisdictionalAuthorization",
      MedicinalProductAuthorizationJurisdictionalAuthorizationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("holder", ReferenceSerializer.descriptor)
    b.optionalElement("regulator", ReferenceSerializer.descriptor)
    b.optionalElement("procedure", MedicinalProductAuthorizationProcedureSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicinalProductAuthorization {
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
    var subject: Reference? = null
    var country: List<CodeableConcept>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var status: CodeableConcept? = null
    var statusDate: String? = null
    var _statusDate: Element? = null
    var restoreDate: String? = null
    var _restoreDate: Element? = null
    var validityPeriod: Period? = null
    var dataExclusivityPeriod: Period? = null
    var dateOfFirstAuthorization: String? = null
    var _dateOfFirstAuthorization: Element? = null
    var internationalBirthDate: String? = null
    var _internationalBirthDate: Element? = null
    var legalBasis: CodeableConcept? = null
    var jurisdictionalAuthorization:
      List<MedicinalProductAuthorization.JurisdictionalAuthorization>? =
      null
    var holder: Reference? = null
    var regulator: Reference? = null
    var procedure: MedicinalProductAuthorization.Procedure? = null
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
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        12 ->
          country =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          status =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 -> statusDate = decoder.decodeStringElement(descriptor, i)
        16 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> restoreDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _restoreDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        20 ->
          dataExclusivityPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        21 -> dateOfFirstAuthorization = decoder.decodeStringElement(descriptor, i)
        22 ->
          _dateOfFirstAuthorization =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> internationalBirthDate = decoder.decodeStringElement(descriptor, i)
        24 ->
          _internationalBirthDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          legalBasis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          jurisdictionalAuthorization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductAuthorizationJurisdictionalAuthorizationSerializer.listSerializer,
              null,
            )
        27 ->
          holder =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          regulator =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          procedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductAuthorizationProcedureSerializer,
              null,
            )
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductAuthorization: " + i
          )
      }
    }
    return MedicinalProductAuthorization(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      subject = subject,
      country = country ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      status = status,
      statusDate =
        DateTime.of(
          if (statusDate != null) FhirDateTime.fromString(statusDate) else null,
          _statusDate,
        ),
      restoreDate =
        DateTime.of(
          if (restoreDate != null) FhirDateTime.fromString(restoreDate) else null,
          _restoreDate,
        ),
      validityPeriod = validityPeriod,
      dataExclusivityPeriod = dataExclusivityPeriod,
      dateOfFirstAuthorization =
        DateTime.of(
          if (dateOfFirstAuthorization != null) FhirDateTime.fromString(dateOfFirstAuthorization)
          else null,
          _dateOfFirstAuthorization,
        ),
      internationalBirthDate =
        DateTime.of(
          if (internationalBirthDate != null) FhirDateTime.fromString(internationalBirthDate)
          else null,
          _internationalBirthDate,
        ),
      legalBasis = legalBasis,
      jurisdictionalAuthorization = jurisdictionalAuthorization ?: listOf(),
      holder = holder,
      regulator = regulator,
      procedure = procedure,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductAuthorization,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.country.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.country,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.statusDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.statusDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.restoreDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.restoreDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      PeriodSerializer,
      value.validityPeriod,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      PeriodSerializer,
      value.dataExclusivityPeriod,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.dateOfFirstAuthorization?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.dateOfFirstAuthorization,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.internationalBirthDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.internationalBirthDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.legalBasis,
    )
    if (value.jurisdictionalAuthorization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        MedicinalProductAuthorizationJurisdictionalAuthorizationSerializer.listSerializer,
        value.jurisdictionalAuthorization,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.holder,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.regulator,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      MedicinalProductAuthorizationProcedureSerializer,
      value.procedure,
    )
  }
}
