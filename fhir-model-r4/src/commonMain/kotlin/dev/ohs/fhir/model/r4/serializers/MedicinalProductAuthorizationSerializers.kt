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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicinalProductAuthorization
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("country", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("legalStatusOfSupply", CodeableConcept.serializer().descriptor, isOptional = true)
      element("validityPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductAuthorization.JurisdictionalAuthorization =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductAuthorization.JurisdictionalAuthorization,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductAuthorization.JurisdictionalAuthorization {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var country: CodeableConcept? = null
    var jurisdiction: List<CodeableConcept>? = null
    var legalStatusOfSupply: CodeableConcept? = null
    var validityPeriod: Period? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 ->
          country =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySer, null)
        5 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        6 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySer, null)
        7 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.validityPeriodSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding JurisdictionalAuthorization: " + i
          )
      }
    }
    return MedicinalProductAuthorization.JurisdictionalAuthorization(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductAuthorization.JurisdictionalAuthorization,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, value.identifier)
    (value.country)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.countrySer, it)
    }
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.jurisdictionSer, value.jurisdiction)
    (value.legalStatusOfSupply)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.countrySer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.validityPeriodSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val countrySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.countrySer)

    public val validityPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object MedicinalProductAuthorizationProcedureSerializer :
  KSerializer<MedicinalProductAuthorization.Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") {
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
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("datePeriod", Period.serializer().descriptor, isOptional = true)
      element("dateDateTime", String.serializer().descriptor, isOptional = true)
      element("_dateDateTime", Element.serializer().descriptor, isOptional = true)
      element(
        "application",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductAuthorization.Procedure.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicinalProductAuthorization.Procedure =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductAuthorization.Procedure) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductAuthorization.Procedure {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          datePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.datePeriodSer, null)
        6 -> dateDateTime = decoder.decodeStringElement(descriptor, i)
        7 ->
          _dateDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateDateTimeSer, null)
        8 ->
          application =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.applicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + i)
      }
    }
    return MedicinalProductAuthorization.Procedure(
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
          DateTime.of(dateDateTime?.let { FhirDateTime.fromString(it) }, _dateDateTime),
        ),
      application = application ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductAuthorization.Procedure,
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, value.type)
    when (val choice = value.date) {
      null -> {}
      is MedicinalProductAuthorization.Procedure.Date.Period -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.datePeriodSer, choice.value)
      }
      is MedicinalProductAuthorization.Procedure.Date.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.dateDateTimeSer, it)
        }
      }
    }
    if (value.application.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.applicationSer, value.application)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val datePeriodSer: KSerializer<Period> = Period.serializer()

    public val dateDateTimeSer: KSerializer<Element> = Element.serializer()

    public val applicationSerInner: KSerializer<MedicinalProductAuthorization.Procedure> =
      MedicinalProductAuthorization.Procedure.serializer()

    public val applicationSer: KSerializer<List<MedicinalProductAuthorization.Procedure>> =
      ListSerializer(Hoisted.applicationSerInner)
  }
}

internal object MedicinalProductAuthorizationSerializer :
  KSerializer<MedicinalProductAuthorization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductAuthorization") {
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
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "country",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("statusDate", String.serializer().descriptor, isOptional = true)
    b.element("_statusDate", Element.serializer().descriptor, isOptional = true)
    b.element("restoreDate", String.serializer().descriptor, isOptional = true)
    b.element("_restoreDate", Element.serializer().descriptor, isOptional = true)
    b.element("validityPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("dataExclusivityPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("dateOfFirstAuthorization", String.serializer().descriptor, isOptional = true)
    b.element("_dateOfFirstAuthorization", Element.serializer().descriptor, isOptional = true)
    b.element("internationalBirthDate", String.serializer().descriptor, isOptional = true)
    b.element("_internationalBirthDate", Element.serializer().descriptor, isOptional = true)
    b.element("legalBasis", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "jurisdictionalAuthorization",
      listSerialDescriptor(
        lazyDescriptor {
          MedicinalProductAuthorization.JurisdictionalAuthorization.serializer().descriptor
        }
      ),
      isOptional = true,
    )
    b.element("holder", Reference.serializer().descriptor, isOptional = true)
    b.element("regulator", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "procedure",
      lazyDescriptor { MedicinalProductAuthorization.Procedure.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductAuthorization =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductAuthorization) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductAuthorization")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        12 ->
          country =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySer, null)
        13 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySer, null)
        14 ->
          status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySerInner, null)
        15 -> statusDate = decoder.decodeStringElement(descriptor, i)
        16 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> restoreDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _restoreDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.validityPeriodSer,
              null,
            )
        20 ->
          dataExclusivityPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.validityPeriodSer,
              null,
            )
        21 -> dateOfFirstAuthorization = decoder.decodeStringElement(descriptor, i)
        22 ->
          _dateOfFirstAuthorization =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> internationalBirthDate = decoder.decodeStringElement(descriptor, i)
        24 ->
          _internationalBirthDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          legalBasis =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySerInner, null)
        26 ->
          jurisdictionalAuthorization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.jurisdictionalAuthorizationSer,
              null,
            )
        27 ->
          holder =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        28 ->
          regulator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        29 ->
          procedure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.procedureSer, null)
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
      statusDate = DateTime.of(statusDate?.let { FhirDateTime.fromString(it) }, _statusDate),
      restoreDate = DateTime.of(restoreDate?.let { FhirDateTime.fromString(it) }, _restoreDate),
      validityPeriod = validityPeriod,
      dataExclusivityPeriod = dataExclusivityPeriod,
      dateOfFirstAuthorization =
        DateTime.of(
          dateOfFirstAuthorization?.let { FhirDateTime.fromString(it) },
          _dateOfFirstAuthorization,
        ),
      internationalBirthDate =
        DateTime.of(
          internationalBirthDate?.let { FhirDateTime.fromString(it) },
          _internationalBirthDate,
        ),
      legalBasis = legalBasis,
      jurisdictionalAuthorization = jurisdictionalAuthorization ?: listOf(),
      holder = holder,
      regulator = regulator,
      procedure = procedure,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductAuthorization,
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
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.country.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.countrySer,
        value.country,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.countrySer,
        value.jurisdiction,
      )
    (value.status)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.countrySerInner,
        it,
      )
    }
    ((value.statusDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.restoreDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.restoreDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.validityPeriodSer,
        it,
      )
    }
    (value.dataExclusivityPeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.validityPeriodSer,
        it,
      )
    }
    ((value.dateOfFirstAuthorization?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.dateOfFirstAuthorization?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.internationalBirthDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.internationalBirthDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.legalBasis)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.countrySerInner,
        it,
      )
    }
    if (value.jurisdictionalAuthorization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.jurisdictionalAuthorizationSer,
        value.jurisdictionalAuthorization,
      )
    (value.holder)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.regulator)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.procedure)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.procedureSer, it)
    }
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

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val countrySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val countrySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.countrySerInner)

    public val validityPeriodSer: KSerializer<Period> = Period.serializer()

    public val jurisdictionalAuthorizationSerInner:
      KSerializer<MedicinalProductAuthorization.JurisdictionalAuthorization> =
      MedicinalProductAuthorization.JurisdictionalAuthorization.serializer()

    public val jurisdictionalAuthorizationSer:
      KSerializer<List<MedicinalProductAuthorization.JurisdictionalAuthorization>> =
      ListSerializer(Hoisted.jurisdictionalAuthorizationSerInner)

    public val procedureSer: KSerializer<MedicinalProductAuthorization.Procedure> =
      MedicinalProductAuthorization.Procedure.serializer()
  }
}

internal object MedicinalProductAuthorizationPolymorphicSerializer :
  KSerializer<MedicinalProductAuthorization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductAuthorization") {
      MedicinalProductAuthorizationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductAuthorization) {
    encoder.encodeStructure(descriptor) {
      MedicinalProductAuthorizationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductAuthorization =
    decoder.decodeStructure(descriptor) {
      MedicinalProductAuthorizationSerializer.deserializeInternal(this, descriptor, 0)
    }
}
