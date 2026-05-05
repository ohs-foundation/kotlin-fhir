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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Requirements
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object RequirementsStatementSerializer : KSerializer<Requirements.Statement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Statement") {
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
      element("key", KotlinString.serializer().descriptor, isOptional = true)
      element("_key", Element.serializer().descriptor, isOptional = true)
      element("label", KotlinString.serializer().descriptor, isOptional = true)
      element("_label", Element.serializer().descriptor, isOptional = true)
      element(
        "conformance",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_conformance",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("conditionality", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_conditionality", Element.serializer().descriptor, isOptional = true)
      element("requirement", KotlinString.serializer().descriptor, isOptional = true)
      element("_requirement", Element.serializer().descriptor, isOptional = true)
      element("derivedFrom", KotlinString.serializer().descriptor, isOptional = true)
      element("_derivedFrom", Element.serializer().descriptor, isOptional = true)
      element("parent", KotlinString.serializer().descriptor, isOptional = true)
      element("_parent", Element.serializer().descriptor, isOptional = true)
      element(
        "satisfiedBy",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_satisfiedBy",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reference",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_reference",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Requirements.Statement =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Requirements.Statement) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Requirements.Statement {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var key: KotlinString? = null
    var _key: Element? = null
    var label: KotlinString? = null
    var _label: Element? = null
    var conformance: List<KotlinString?>? = null
    var _conformance: List<Element?>? = null
    var conditionality: KotlinBoolean? = null
    var _conditionality: Element? = null
    var requirement: KotlinString? = null
    var _requirement: Element? = null
    var derivedFrom: KotlinString? = null
    var _derivedFrom: Element? = null
    var parent: KotlinString? = null
    var _parent: Element? = null
    var satisfiedBy: List<KotlinString?>? = null
    var _satisfiedBy: List<Element?>? = null
    var reference: List<KotlinString?>? = null
    var _reference: List<Element?>? = null
    var source: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> key = decoder.decodeStringElement(__desc, __i)
        4 -> _key = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.keySer, null)
        5 -> label = decoder.decodeStringElement(__desc, __i)
        6 -> _label = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.keySer, null)
        7 ->
          conformance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conformanceSer, null)
        8 ->
          _conformance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conformanceSer2, null)
        9 -> conditionality = decoder.decodeBooleanElement(__desc, __i)
        10 ->
          _conditionality =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.keySer, null)
        11 -> requirement = decoder.decodeStringElement(__desc, __i)
        12 ->
          _requirement =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.keySer, null)
        13 -> derivedFrom = decoder.decodeStringElement(__desc, __i)
        14 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.keySer, null)
        15 -> parent = decoder.decodeStringElement(__desc, __i)
        16 -> _parent = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.keySer, null)
        17 ->
          satisfiedBy =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conformanceSer, null)
        18 ->
          _satisfiedBy =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conformanceSer2, null)
        19 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conformanceSer, null)
        20 ->
          _reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conformanceSer2, null)
        21 ->
          source = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Statement: " + __i)
      }
    }
    return Requirements.Statement(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      key = Id.of(key, _key)!!,
      label = R5String.of(label, _label),
      conformance =
        (kotlin.collections.List(maxOf(conformance?.size ?: 0, _conformance?.size ?: 0)) { __i ->
          Enumeration.of(
            Requirements.ConformanceExpectation.fromCode(conformance?.getOrNull(__i)!!),
            _conformance?.getOrNull(__i),
          )
        }),
      conditionality = R5Boolean.of(conditionality, _conditionality),
      requirement = Markdown.of(requirement, _requirement)!!,
      derivedFrom = R5String.of(derivedFrom, _derivedFrom),
      parent = R5String.of(parent, _parent),
      satisfiedBy =
        (kotlin.collections.List(maxOf(satisfiedBy?.size ?: 0, _satisfiedBy?.size ?: 0)) { __i ->
          Url.of(satisfiedBy?.getOrNull(__i)?.let { it }, _satisfiedBy?.getOrNull(__i))!!
        }),
      reference =
        (kotlin.collections.List(maxOf(reference?.size ?: 0, _reference?.size ?: 0)) { __i ->
          Url.of(reference?.getOrNull(__i)?.let { it }, _reference?.getOrNull(__i))!!
        }),
      source = source ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Requirements.Statement) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.key.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.key.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.keySer, it)
    }
    ((value.label?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.keySer, it)
    }
    (value.conformance.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.conformanceSer, it)
    }
    (value.conformance.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.conformanceSer2, it)
    }
    ((value.conditionality?.value))?.let { encoder.encodeBooleanElement(__desc, 9, it) }
    (value.conditionality?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.keySer, it)
    }
    ((value.requirement.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.requirement.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.keySer, it)
    }
    ((value.derivedFrom?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.derivedFrom?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.keySer, it)
    }
    ((value.parent?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.parent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.keySer, it)
    }
    (value.satisfiedBy.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.conformanceSer, it)
    }
    (value.satisfiedBy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.conformanceSer2, it)
    }
    (value.reference.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.conformanceSer, it)
    }
    (value.reference.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.conformanceSer2, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val keySer: KSerializer<Element> = Element.serializer()

    public val conformanceSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val conformanceSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.conformanceSerInner).nullable)

    public val conformanceSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.keySer).nullable)

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)
  }
}

internal object RequirementsSerializer : KSerializer<Requirements> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Requirements") {
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
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
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
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
    b.element(
      "derivedFrom",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_derivedFrom",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reference",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_reference",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "actor",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_actor", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "statement",
      listSerialDescriptor(lazyDescriptor { Requirements.Statement.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Requirements =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Requirements) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Requirements")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Requirements {
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
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
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var derivedFrom: List<KotlinString?>? = null
    var _derivedFrom: List<Element?>? = null
    var reference: List<KotlinString?>? = null
    var _reference: List<Element?>? = null
    var actor: List<KotlinString?>? = null
    var _actor: List<Element?>? = null
    var statement: List<Requirements.Statement>? = null
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
        15 -> versionAlgorithmString = decoder.decodeStringElement(__desc, __i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(__desc, __i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(__desc, __i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 -> status = decoder.decodeStringElement(__desc, __i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(__desc, __i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        26 -> date = decoder.decodeStringElement(__desc, __i)
        27 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 -> publisher = decoder.decodeStringElement(__desc, __i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        31 -> description = decoder.decodeStringElement(__desc, __i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useContextSer, null)
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        35 -> purpose = decoder.decodeStringElement(__desc, __i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        37 -> copyright = decoder.decodeStringElement(__desc, __i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(__desc, __i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        41 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.derivedFromSer, null)
        42 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.derivedFromSer2, null)
        43 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.derivedFromSer, null)
        44 ->
          _reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.derivedFromSer2, null)
        45 ->
          actor =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.derivedFromSer, null)
        46 ->
          _actor =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.derivedFromSer2, null)
        47 ->
          statement =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statementSer, null)
        else -> throw SerializationException("Unexpected index decoding Requirements: " + __i)
      }
    }
    return Requirements(
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
      version = R5String.of(version, _version),
      versionAlgorithm =
        Requirements.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      derivedFrom =
        (kotlin.collections.List(maxOf(derivedFrom?.size ?: 0, _derivedFrom?.size ?: 0)) { __i ->
          Canonical.of(derivedFrom?.getOrNull(__i)?.let { it }, _derivedFrom?.getOrNull(__i))!!
        }),
      reference =
        (kotlin.collections.List(maxOf(reference?.size ?: 0, _reference?.size ?: 0)) { __i ->
          Url.of(reference?.getOrNull(__i)?.let { it }, _reference?.getOrNull(__i))!!
        }),
      actor =
        (kotlin.collections.List(maxOf(actor?.size ?: 0, _actor?.size ?: 0)) { __i ->
          Canonical.of(actor?.getOrNull(__i)?.let { it }, _actor?.getOrNull(__i))!!
        }),
      statement = statement ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Requirements,
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
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is Requirements.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Requirements.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          __desc,
          17 + __off,
          Hoisted.versionAlgorithmCodingSer,
          __d.value,
        )
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 22 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 24 + __off, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 31 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        34 + __off,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 35 + __off, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 37 + __off, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.copyrightLabel?.value))?.let { encoder.encodeStringElement(__desc, 39 + __off, it) }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.derivedFrom.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.derivedFromSer, it)
    }
    (value.derivedFrom.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.derivedFromSer2, it)
    }
    (value.reference.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.derivedFromSer, it)
    }
    (value.reference.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.derivedFromSer2, it)
    }
    (value.actor.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.derivedFromSer, it)
    }
    (value.actor.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.derivedFromSer2, it)
    }
    if (value.statement.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.statementSer, value.statement)
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

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val derivedFromSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val derivedFromSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.derivedFromSerInner).nullable)

    public val derivedFromSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val statementSerInner: KSerializer<Requirements.Statement> =
      Requirements.Statement.serializer()

    public val statementSer: KSerializer<List<Requirements.Statement>> =
      ListSerializer(Hoisted.statementSerInner)
  }
}

internal object RequirementsPolymorphicSerializer : KSerializer<Requirements> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Requirements") { RequirementsSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Requirements) {
    encoder.encodeStructure(descriptor) {
      RequirementsSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Requirements =
    decoder.decodeStructure(descriptor) {
      RequirementsSerializer.deserializeJson(this, descriptor, 0)
    }
}
