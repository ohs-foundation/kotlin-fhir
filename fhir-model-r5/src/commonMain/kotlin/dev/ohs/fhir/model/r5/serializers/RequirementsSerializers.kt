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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Requirements
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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

internal object RequirementsStatementSerializer : KSerializer<Requirements.Statement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Statement") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("key", KotlinString.serializer().descriptor)
      optionalElement("_key", ElementSerializer.descriptor)
      optionalElement("label", KotlinString.serializer().descriptor)
      optionalElement("_label", ElementSerializer.descriptor)
      optionalElement("conformance", stringNullableListSerializer.descriptor)
      optionalElement("_conformance", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("conditionality", KotlinBoolean.serializer().descriptor)
      optionalElement("_conditionality", ElementSerializer.descriptor)
      optionalElement("requirement", KotlinString.serializer().descriptor)
      optionalElement("_requirement", ElementSerializer.descriptor)
      optionalElement("derivedFrom", KotlinString.serializer().descriptor)
      optionalElement("_derivedFrom", ElementSerializer.descriptor)
      optionalElement("parent", KotlinString.serializer().descriptor)
      optionalElement("_parent", ElementSerializer.descriptor)
      optionalElement("satisfiedBy", stringNullableListSerializer.descriptor)
      optionalElement("_satisfiedBy", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("reference", stringNullableListSerializer.descriptor)
      optionalElement("_reference", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Requirements.Statement>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Requirements.Statement =
    decoder.decodeStructure(descriptor) {
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
          3 -> key = decodeStringElement(descriptor, i)
          4 -> _key = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> label = decodeStringElement(descriptor, i)
          6 -> _label = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            conformance =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          8 ->
            _conformance =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          9 -> conditionality = decodeBooleanElement(descriptor, i)
          10 ->
            _conditionality =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> requirement = decodeStringElement(descriptor, i)
          12 ->
            _requirement = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> derivedFrom = decodeStringElement(descriptor, i)
          14 ->
            _derivedFrom = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> parent = decodeStringElement(descriptor, i)
          16 -> _parent = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 ->
            satisfiedBy =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          18 ->
            _satisfiedBy =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          19 ->
            reference =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          20 ->
            _reference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          21 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Statement: " + i)
        }
      }
      Requirements.Statement(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        key =
          Id.of(key, _key)
            ?: throw SerializationException(
              "Missing required property 'key' on Requirements.Statement"
            ),
        label = R5String.of(label, _label),
        conformance =
          (kotlin.collections.List(maxOf(conformance?.size ?: 0, _conformance?.size ?: 0)) { index
            ->
            Enumeration.of(
              conformance?.getOrNull(index)?.let {
                Requirements.ConformanceExpectation.fromCode(it)
              },
              _conformance?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'conformance' on Requirements.Statement has neither a value nor an id/extension"
              )
          }),
        conditionality = R5Boolean.of(conditionality, _conditionality),
        requirement =
          Markdown.of(requirement, _requirement)
            ?: throw SerializationException(
              "Missing required property 'requirement' on Requirements.Statement"
            ),
        derivedFrom = R5String.of(derivedFrom, _derivedFrom),
        parent = R5String.of(parent, _parent),
        satisfiedBy =
          (kotlin.collections.List(maxOf(satisfiedBy?.size ?: 0, _satisfiedBy?.size ?: 0)) { index
            ->
            Url.of(satisfiedBy?.getOrNull(index), _satisfiedBy?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'satisfiedBy' on Requirements.Statement has neither a value nor an id/extension"
              )
          }),
        reference =
          (kotlin.collections.List(maxOf(reference?.size ?: 0, _reference?.size ?: 0)) { index ->
            Url.of(reference?.getOrNull(index), _reference?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'reference' on Requirements.Statement has neither a value nor an id/extension"
              )
          }),
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Requirements.Statement) {
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
      encodeStringIfNotNull(descriptor, 3, value.key.value)
      encodeElementIfNotNull(descriptor, 4, value.key)
      encodeStringIfNotNull(descriptor, 5, value.label?.value)
      encodeElementIfNotNull(descriptor, 6, value.label)
      if (value.conformance.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          stringNullableListSerializer,
          value.conformance.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 8, value.conformance)
      }
      encodeBooleanIfNotNull(descriptor, 9, value.conditionality?.value)
      encodeElementIfNotNull(descriptor, 10, value.conditionality)
      encodeStringIfNotNull(descriptor, 11, value.requirement.value)
      encodeElementIfNotNull(descriptor, 12, value.requirement)
      encodeStringIfNotNull(descriptor, 13, value.derivedFrom?.value)
      encodeElementIfNotNull(descriptor, 14, value.derivedFrom)
      encodeStringIfNotNull(descriptor, 15, value.parent?.value)
      encodeElementIfNotNull(descriptor, 16, value.parent)
      if (value.satisfiedBy.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          17,
          stringNullableListSerializer,
          value.satisfiedBy.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 18, value.satisfiedBy)
      }
      if (value.reference.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          19,
          stringNullableListSerializer,
          value.reference.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 20, value.reference)
      }
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 21, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object RequirementsSerializer : FhirResourceSerializer<Requirements> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Requirements")

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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
    b.optionalElement("derivedFrom", stringNullableListSerializer.descriptor)
    b.optionalElement("_derivedFrom", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("reference", stringNullableListSerializer.descriptor)
    b.optionalElement("_reference", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("actor", stringNullableListSerializer.descriptor)
    b.optionalElement("_actor", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("statement", RequirementsStatementSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Requirements {
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> purpose = decoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> copyright = decoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        42 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        43 ->
          reference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        44 ->
          _reference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        45 ->
          actor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        46 ->
          _actor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        47 ->
          statement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequirementsStatementSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Requirements: " + i)
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
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Requirements"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      derivedFrom =
        (kotlin.collections.List(maxOf(derivedFrom?.size ?: 0, _derivedFrom?.size ?: 0)) { index ->
          Canonical.of(derivedFrom?.getOrNull(index), _derivedFrom?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'derivedFrom' on Requirements has neither a value nor an id/extension"
            )
        }),
      reference =
        (kotlin.collections.List(maxOf(reference?.size ?: 0, _reference?.size ?: 0)) { index ->
          Url.of(reference?.getOrNull(index), _reference?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'reference' on Requirements has neither a value nor an id/extension"
            )
        }),
      actor =
        (kotlin.collections.List(maxOf(actor?.size ?: 0, _actor?.size ?: 0)) { index ->
          Canonical.of(actor?.getOrNull(index), _actor?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'actor' on Requirements has neither a value nor an id/extension"
            )
        }),
      statement = statement ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Requirements,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is Requirements.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is Requirements.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 24 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyrightLabel)
    if (value.derivedFrom.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        41 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFrom.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 42 + descriptorOffset, value.derivedFrom)
    }
    if (value.reference.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        43 + descriptorOffset,
        stringNullableListSerializer,
        value.reference.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 44 + descriptorOffset, value.reference)
    }
    if (value.actor.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        value.actor.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 46 + descriptorOffset, value.actor)
    }
    if (value.statement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        RequirementsStatementSerializer.listSerializer,
        value.statement,
      )
  }
}
