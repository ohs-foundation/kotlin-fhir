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
import kotlin.String
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductAuthorization.JurisdictionalAuthorization,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductAuthorization.JurisdictionalAuthorization {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var country: CodeableConcept? = null
    var jurisdiction: List<CodeableConcept>? = null
    var legalStatusOfSupply: CodeableConcept? = null
    var validityPeriod: Period? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 ->
          country = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.countrySer, null)
        5 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.jurisdictionSer, null)
        6 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.countrySer, null)
        7 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.validityPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding JurisdictionalAuthorization: " + __i
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductAuthorization.JurisdictionalAuthorization,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, value.identifier)
    (value.country)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.countrySer, it) }
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.jurisdictionSer, value.jurisdiction)
    (value.legalStatusOfSupply)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.countrySer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.validityPeriodSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductAuthorization.Procedure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductAuthorization.Procedure {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 ->
          datePeriod =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.datePeriodSer, null)
        6 -> dateDateTime = decoder.decodeStringElement(__desc, 6)
        7 ->
          _dateDateTime =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.dateDateTimeSer, null)
        8 ->
          application =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.applicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + __i)
      }
    }
    return MedicinalProductAuthorization.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      type = type!!,
      date =
        MedicinalProductAuthorization.Procedure.Date.from(
          datePeriod,
          DateTime.of(FhirDateTime.fromString(dateDateTime), _dateDateTime),
        ),
      application = application ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductAuthorization.Procedure,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    when (val __d = value.date) {
      null -> {}
      is MedicinalProductAuthorization.Procedure.Date.Period -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.datePeriodSer, __d.value)
      }
      is MedicinalProductAuthorization.Procedure.Date.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.dateDateTimeSer, it)
        }
      }
    }
    if (value.application.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.applicationSer, value.application)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductAuthorization) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductAuthorization")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicinalProductAuthorization {
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
          subject = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.subjectSer, null)
        13 ->
          country = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.countrySer, null)
        14 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.countrySer, null)
        15 ->
          status =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.countrySerInner, null)
        16 -> statusDate = decoder.decodeStringElement(__desc, 16)
        17 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> restoreDate = decoder.decodeStringElement(__desc, 18)
        19 ->
          _restoreDate =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.validityPeriodSer, null)
        21 ->
          dataExclusivityPeriod =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.validityPeriodSer, null)
        22 -> dateOfFirstAuthorization = decoder.decodeStringElement(__desc, 22)
        23 ->
          _dateOfFirstAuthorization =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> internationalBirthDate = decoder.decodeStringElement(__desc, 24)
        25 ->
          _internationalBirthDate =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          legalBasis =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.countrySerInner, null)
        27 ->
          jurisdictionalAuthorization =
            decoder.decodeNullableSerializableElement(
              __desc,
              27,
              Hoisted.jurisdictionalAuthorizationSer,
              null,
            )
        28 ->
          holder = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.subjectSer, null)
        29 ->
          regulator =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.subjectSer, null)
        30 ->
          procedure =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.procedureSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductAuthorization: " + __i
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
      statusDate = DateTime.of(FhirDateTime.fromString(statusDate), _statusDate),
      restoreDate = DateTime.of(FhirDateTime.fromString(restoreDate), _restoreDate),
      validityPeriod = validityPeriod,
      dataExclusivityPeriod = dataExclusivityPeriod,
      dateOfFirstAuthorization =
        DateTime.of(FhirDateTime.fromString(dateOfFirstAuthorization), _dateOfFirstAuthorization),
      internationalBirthDate =
        DateTime.of(FhirDateTime.fromString(internationalBirthDate), _internationalBirthDate),
      legalBasis = legalBasis,
      jurisdictionalAuthorization = jurisdictionalAuthorization ?: listOf(),
      holder = holder,
      regulator = regulator,
      procedure = procedure,
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProductAuthorization) {
    val __desc = descriptor
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
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.subjectSer, it) }
    if (value.country.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.countrySer, value.country)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.countrySer, value.jurisdiction)
    (value.status)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.countrySerInner, it)
    }
    ((value.statusDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.restoreDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.restoreDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.validityPeriodSer, it)
    }
    (value.dataExclusivityPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.validityPeriodSer, it)
    }
    ((value.dateOfFirstAuthorization?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 22, it)
    }
    (value.dateOfFirstAuthorization?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.internationalBirthDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 24, it)
    }
    (value.internationalBirthDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    (value.legalBasis)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.countrySerInner, it)
    }
    if (value.jurisdictionalAuthorization.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        27,
        Hoisted.jurisdictionalAuthorizationSer,
        value.jurisdictionalAuthorization,
      )
    (value.holder)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.subjectSer, it) }
    (value.regulator)?.let { encoder.encodeSerializableElement(__desc, 29, Hoisted.subjectSer, it) }
    (value.procedure)?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.procedureSer, it)
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
      MedicinalProductAuthorizationSerializer.serializeJson(this, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductAuthorization =
    decoder.decodeStructure(descriptor) {
      MedicinalProductAuthorizationSerializer.deserializeJson(this)
    }
}
