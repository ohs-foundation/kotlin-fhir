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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CodeableReference
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RegulatedAuthorization
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Uri
import kotlin.String
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

internal object RegulatedAuthorizationCaseSerializer : KSerializer<RegulatedAuthorization.Case> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Case") {
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
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("datePeriod", Period.serializer().descriptor, isOptional = true)
      element("dateDateTime", String.serializer().descriptor, isOptional = true)
      element("_dateDateTime", Element.serializer().descriptor, isOptional = true)
      element(
        "application",
        listSerialDescriptor(
          lazyDescriptor { RegulatedAuthorization.Case.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): RegulatedAuthorization.Case =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RegulatedAuthorization.Case) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RegulatedAuthorization.Case {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var type: CodeableConcept? = null
    var status: CodeableConcept? = null
    var datePeriod: Period? = null
    var dateDateTime: String? = null
    var _dateDateTime: Element? = null
    var application: List<RegulatedAuthorization.Case>? = null
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
        5 -> status = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 ->
          datePeriod =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.datePeriodSer, null)
        7 -> dateDateTime = decoder.decodeStringElement(__desc, 7)
        8 ->
          _dateDateTime =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.dateDateTimeSer, null)
        9 ->
          application =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.applicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Case: " + __i)
      }
    }
    return RegulatedAuthorization.Case(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      type = type,
      status = status,
      date =
        RegulatedAuthorization.Case.Date.from(
          datePeriod,
          DateTime.of(FhirDateTime.fromString(dateDateTime), _dateDateTime),
        ),
      application = application ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RegulatedAuthorization.Case) {
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
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    when (val __d = value.date) {
      null -> {}
      is RegulatedAuthorization.Case.Date.Period -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.datePeriodSer, __d.value)
      }
      is RegulatedAuthorization.Case.Date.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.dateDateTimeSer, it)
        }
      }
    }
    if (value.application.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.applicationSer, value.application)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val datePeriodSer: KSerializer<Period> = Period.serializer()

    public val dateDateTimeSer: KSerializer<Element> = Element.serializer()

    public val applicationSerInner: KSerializer<RegulatedAuthorization.Case> =
      RegulatedAuthorization.Case.serializer()

    public val applicationSer: KSerializer<List<RegulatedAuthorization.Case>> =
      ListSerializer(Hoisted.applicationSerInner)
  }
}

internal object RegulatedAuthorizationCaseDateSerializer :
  KSerializer<RegulatedAuthorization.Case.Date> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RegulatedAuthorization.Case.Date") {
      element("datePeriod", Period.serializer().descriptor, isOptional = true)
      element("dateDateTime", String.serializer().descriptor, isOptional = true)
      element("_dateDateTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: RegulatedAuthorization.Case.Date) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is RegulatedAuthorization.Case.Date.Period -> {
          encodeSerializableElement(__desc, 0, Hoisted.datePeriodSer, __d.value)
        }
        is RegulatedAuthorization.Case.Date.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 1, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 2, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): RegulatedAuthorization.Case.Date =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): RegulatedAuthorization.Case.Date {
    val __desc = descriptor
    var datePeriod: Period? = null
    var dateDateTime: String? = null
    var _dateDateTime: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          datePeriod =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.datePeriodSer, null)
        1 -> dateDateTime = decoder.decodeStringElement(__desc, 1)
        2 ->
          _dateDateTime =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding RegulatedAuthorization.Case.Date: " + __i
          )
      }
    }
    return RegulatedAuthorization.Case.Date.from(
      datePeriod,
      DateTime.of(FhirDateTime.fromString(dateDateTime), _dateDateTime),
    )!!
  }

  private object Hoisted {
    public val datePeriodSer: KSerializer<Period> = Period.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object RegulatedAuthorizationSerializer : KSerializer<RegulatedAuthorization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RegulatedAuthorization") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
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
      element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", String.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "region",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("statusDate", String.serializer().descriptor, isOptional = true)
      element("_statusDate", Element.serializer().descriptor, isOptional = true)
      element("validityPeriod", Period.serializer().descriptor, isOptional = true)
      element("indication", CodeableReference.serializer().descriptor, isOptional = true)
      element("intendedUse", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "basis",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("holder", Reference.serializer().descriptor, isOptional = true)
      element("regulator", Reference.serializer().descriptor, isOptional = true)
      element(
        "case",
        lazyDescriptor { RegulatedAuthorization.Case.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): RegulatedAuthorization =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RegulatedAuthorization) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): RegulatedAuthorization {
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
    var subject: List<Reference>? = null
    var type: CodeableConcept? = null
    var description: String? = null
    var _description: Element? = null
    var region: List<CodeableConcept>? = null
    var status: CodeableConcept? = null
    var statusDate: String? = null
    var _statusDate: Element? = null
    var validityPeriod: Period? = null
    var indication: CodeableReference? = null
    var intendedUse: CodeableConcept? = null
    var basis: List<CodeableConcept>? = null
    var holder: Reference? = null
    var regulator: Reference? = null
    var case: RegulatedAuthorization.Case? = null
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
        13 -> type = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.typeSer, null)
        14 -> description = decoder.decodeStringElement(__desc, 14)
        15 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          region = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.regionSer, null)
        17 -> status = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.typeSer, null)
        18 -> statusDate = decoder.decodeStringElement(__desc, 18)
        19 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.validityPeriodSer, null)
        21 ->
          indication =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.indicationSer, null)
        22 ->
          intendedUse = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.typeSer, null)
        23 -> basis = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.regionSer, null)
        24 ->
          holder =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.subjectSerInner, null)
        25 ->
          regulator =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.subjectSerInner, null)
        26 -> case = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.caseSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding RegulatedAuthorization: " + __i)
      }
    }
    return RegulatedAuthorization(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      subject = subject ?: listOf(),
      type = type,
      description = Markdown.of(description, _description),
      region = region ?: listOf(),
      status = status,
      statusDate = DateTime.of(FhirDateTime.fromString(statusDate), _statusDate),
      validityPeriod = validityPeriod,
      indication = indication,
      intendedUse = intendedUse,
      basis = basis ?: listOf(),
      holder = holder,
      regulator = regulator,
      case = case,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RegulatedAuthorization) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "RegulatedAuthorization")
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
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.subjectSer, value.subject)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.typeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    if (value.region.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.regionSer, value.region)
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.typeSer, it) }
    ((value.statusDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.validityPeriodSer, it)
    }
    (value.indication)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.indicationSer, it)
    }
    (value.intendedUse)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.typeSer, it) }
    if (value.basis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.regionSer, value.basis)
    (value.holder)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.subjectSerInner, it)
    }
    (value.regulator)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.subjectSerInner, it)
    }
    (value.case)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.caseSer, it) }
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

    public val subjectSerInner: KSerializer<Reference> = Reference.serializer()

    public val subjectSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val regionSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val validityPeriodSer: KSerializer<Period> = Period.serializer()

    public val indicationSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val caseSer: KSerializer<RegulatedAuthorization.Case> =
      RegulatedAuthorization.Case.serializer()
  }
}
