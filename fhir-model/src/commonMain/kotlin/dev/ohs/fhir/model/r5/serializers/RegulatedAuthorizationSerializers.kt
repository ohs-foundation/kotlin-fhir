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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RegulatedAuthorization
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 -> status = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 ->
          datePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.datePeriodSer, null)
        7 -> dateDateTime = decoder.decodeStringElement(__desc, __i)
        8 ->
          _dateDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateDateTimeSer, null)
        9 ->
          application =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.applicationSer, null)
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

internal object RegulatedAuthorizationSerializer : KSerializer<RegulatedAuthorization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RegulatedAuthorization") {
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
    b.element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("description", String.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "region",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("statusDate", String.serializer().descriptor, isOptional = true)
    b.element("_statusDate", Element.serializer().descriptor, isOptional = true)
    b.element("validityPeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "indication",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("intendedUse", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "basis",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("holder", Reference.serializer().descriptor, isOptional = true)
    b.element("regulator", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "attachedDocument",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "case",
      lazyDescriptor { RegulatedAuthorization.Case.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): RegulatedAuthorization =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: RegulatedAuthorization) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "RegulatedAuthorization")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): RegulatedAuthorization {
    val __desc = desc
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
    var indication: List<CodeableReference>? = null
    var intendedUse: CodeableConcept? = null
    var basis: List<CodeableConcept>? = null
    var holder: Reference? = null
    var regulator: Reference? = null
    var attachedDocument: List<Reference>? = null
    var case: RegulatedAuthorization.Case? = null
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
          subject = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        12 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        13 -> description = decoder.decodeStringElement(__desc, __i)
        14 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 ->
          region = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.regionSer, null)
        16 -> status = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        17 -> statusDate = decoder.decodeStringElement(__desc, __i)
        18 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 ->
          validityPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.validityPeriodSer, null)
        20 ->
          indication =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.indicationSer, null)
        21 ->
          intendedUse =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        22 ->
          basis = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.regionSer, null)
        23 ->
          holder =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSerInner, null)
        24 ->
          regulator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSerInner, null)
        25 ->
          attachedDocument =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        26 -> case = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.caseSer, null)
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
      indication = indication ?: listOf(),
      intendedUse = intendedUse,
      basis = basis ?: listOf(),
      holder = holder,
      regulator = regulator,
      attachedDocument = attachedDocument ?: listOf(),
      case = case,
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: RegulatedAuthorization,
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
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.subjectSer, value.subject)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.typeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.region.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.regionSer, value.region)
    (value.status)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.typeSer, it)
    }
    ((value.statusDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 17 + __off, it)
    }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.validityPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.validityPeriodSer, it)
    }
    if (value.indication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.indicationSer, value.indication)
    (value.intendedUse)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.typeSer, it)
    }
    if (value.basis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.regionSer, value.basis)
    (value.holder)?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.subjectSerInner, it)
    }
    (value.regulator)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.subjectSerInner, it)
    }
    if (value.attachedDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        25 + __off,
        Hoisted.subjectSer,
        value.attachedDocument,
      )
    (value.case)?.let { encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.caseSer, it) }
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

    public val indicationSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val indicationSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.indicationSerInner)

    public val caseSer: KSerializer<RegulatedAuthorization.Case> =
      RegulatedAuthorization.Case.serializer()
  }
}

internal object RegulatedAuthorizationPolymorphicSerializer : KSerializer<RegulatedAuthorization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RegulatedAuthorization") {
      RegulatedAuthorizationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: RegulatedAuthorization) {
    encoder.encodeStructure(descriptor) {
      RegulatedAuthorizationSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): RegulatedAuthorization =
    decoder.decodeStructure(descriptor) {
      RegulatedAuthorizationSerializer.deserializeJson(this, descriptor, 0)
    }
}
