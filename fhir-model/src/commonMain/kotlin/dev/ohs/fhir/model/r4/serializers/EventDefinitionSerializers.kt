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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.EventDefinition
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.TriggerDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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

internal object EventDefinitionSerializer : KSerializer<EventDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EventDefinition") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_subtitle", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subjectReference", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("usage", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_usage", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "topic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "trigger",
      listSerialDescriptor(TriggerDefinition.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): EventDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: EventDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "EventDefinition")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): EventDefinition {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var usage: KotlinString? = null
    var _usage: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var trigger: List<TriggerDefinition>? = null
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
        10 -> url = decoder.decodeStringElement(__desc, __i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(__desc, __i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(__desc, __i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(__desc, __i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> subtitle = decoder.decodeStringElement(__desc, __i)
        20 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> status = decoder.decodeStringElement(__desc, __i)
        22 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> experimental = decoder.decodeBooleanElement(__desc, __i)
        24 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        26 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.subjectReferenceSer,
              null,
            )
        27 -> date = decoder.decodeStringElement(__desc, __i)
        28 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        29 -> publisher = decoder.decodeStringElement(__desc, __i)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        31 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        32 -> description = decoder.decodeStringElement(__desc, __i)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useContextSer, null)
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        36 -> purpose = decoder.decodeStringElement(__desc, __i)
        37 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        38 -> usage = decoder.decodeStringElement(__desc, __i)
        39 ->
          _usage =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        40 -> copyright = decoder.decodeStringElement(__desc, __i)
        41 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        42 -> approvalDate = decoder.decodeStringElement(__desc, __i)
        43 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        44 -> lastReviewDate = decoder.decodeStringElement(__desc, __i)
        45 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        46 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectivePeriodSer, null)
        47 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        48 ->
          author = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        49 ->
          editor = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        50 ->
          reviewer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        51 ->
          endorser =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        52 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.relatedArtifactSer, null)
        53 ->
          trigger = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.triggerSer, null)
        else -> throw SerializationException("Unexpected index decoding EventDefinition: " + __i)
      }
    }
    return EventDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      subtitle = R4String.of(subtitle, _subtitle),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      subject = EventDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4String.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      trigger = trigger ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: EventDefinition,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.subtitle?.value))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 23 + __off, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.subject) {
      null -> {}
      is EventDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          25 + __off,
          Hoisted.subjectCodeableConceptSer,
          __d.value,
        )
      }
      is EventDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(
          __desc,
          26 + __off,
          Hoisted.subjectReferenceSer,
          __d.value,
        )
      }
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 27 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 29 + __off, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 32 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        35 + __off,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 36 + __off, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.usage?.value))?.let { encoder.encodeStringElement(__desc, 38 + __off, it) }
    (value.usage?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 40 + __off, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 42 + __off, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 44 + __off, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.effectivePeriodSer, it)
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.jurisdictionSer, value.topic)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48 + __off, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50 + __off, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51 + __off, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        52 + __off,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    if (value.trigger.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53 + __off, Hoisted.triggerSer, value.trigger)
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

    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.subjectCodeableConceptSer)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val triggerSerInner: KSerializer<TriggerDefinition> = TriggerDefinition.serializer()

    public val triggerSer: KSerializer<List<TriggerDefinition>> =
      ListSerializer(Hoisted.triggerSerInner)
  }
}

internal object EventDefinitionPolymorphicSerializer : KSerializer<EventDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EventDefinition") {
      EventDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: EventDefinition) {
    encoder.encodeStructure(descriptor) {
      EventDefinitionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): EventDefinition =
    decoder.decodeStructure(descriptor) {
      EventDefinitionSerializer.deserializeJson(this, descriptor, 0)
    }
}
