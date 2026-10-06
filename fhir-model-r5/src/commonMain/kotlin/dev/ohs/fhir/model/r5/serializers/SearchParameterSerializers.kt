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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.SearchParameter
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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

internal object SearchParameterComponentSerializer : KSerializer<SearchParameter.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("definition", KotlinString.serializer().descriptor)
      optionalElement("_definition", ElementSerializer.descriptor)
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SearchParameter.Component>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SearchParameter.Component =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var definition: KotlinString? = null
      var _definition: Element? = null
      var expression: KotlinString? = null
      var _expression: Element? = null
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
          3 -> definition = decodeStringElement(descriptor, i)
          4 ->
            _definition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> expression = decodeStringElement(descriptor, i)
          6 ->
            _expression = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Component: " + i)
        }
      }
      SearchParameter.Component(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        definition =
          Canonical.of(definition, _definition)
            ?: throw SerializationException(
              "Missing required property 'definition' on SearchParameter.Component"
            ),
        expression =
          R5String.of(expression, _expression)
            ?: throw SerializationException(
              "Missing required property 'expression' on SearchParameter.Component"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SearchParameter.Component) {
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
      encodeStringIfNotNull(descriptor, 3, value.definition.value)
      encodeElementIfNotNull(descriptor, 4, value.definition)
      encodeStringIfNotNull(descriptor, 5, value.expression.value)
      encodeElementIfNotNull(descriptor, 6, value.expression)
    }
  }
}

internal object SearchParameterSerializer : FhirResourceSerializer<SearchParameter> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SearchParameter")

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
    b.optionalElement("derivedFrom", KotlinString.serializer().descriptor)
    b.optionalElement("_derivedFrom", ElementSerializer.descriptor)
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
    b.optionalElement("code", KotlinString.serializer().descriptor)
    b.optionalElement("_code", ElementSerializer.descriptor)
    b.optionalElement("base", stringNullableListSerializer.descriptor)
    b.optionalElement("_base", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("expression", KotlinString.serializer().descriptor)
    b.optionalElement("_expression", ElementSerializer.descriptor)
    b.optionalElement("processingMode", KotlinString.serializer().descriptor)
    b.optionalElement("_processingMode", ElementSerializer.descriptor)
    b.optionalElement("constraint", KotlinString.serializer().descriptor)
    b.optionalElement("_constraint", ElementSerializer.descriptor)
    b.optionalElement("target", stringNullableListSerializer.descriptor)
    b.optionalElement("_target", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("multipleOr", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_multipleOr", ElementSerializer.descriptor)
    b.optionalElement("multipleAnd", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_multipleAnd", ElementSerializer.descriptor)
    b.optionalElement("comparator", stringNullableListSerializer.descriptor)
    b.optionalElement("_comparator", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("modifier", stringNullableListSerializer.descriptor)
    b.optionalElement("_modifier", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("chain", stringNullableListSerializer.descriptor)
    b.optionalElement("_chain", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("component", SearchParameterComponentSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SearchParameter {
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
    var derivedFrom: KotlinString? = null
    var _derivedFrom: Element? = null
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
    var code: KotlinString? = null
    var _code: Element? = null
    var base: List<KotlinString?>? = null
    var _base: List<Element?>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var processingMode: KotlinString? = null
    var _processingMode: Element? = null
    var constraint: KotlinString? = null
    var _constraint: Element? = null
    var target: List<KotlinString?>? = null
    var _target: List<Element?>? = null
    var multipleOr: KotlinBoolean? = null
    var _multipleOr: Element? = null
    var multipleAnd: KotlinBoolean? = null
    var _multipleAnd: Element? = null
    var comparator: List<KotlinString?>? = null
    var _comparator: List<Element?>? = null
    var modifier: List<KotlinString?>? = null
    var _modifier: List<Element?>? = null
    var chain: List<KotlinString?>? = null
    var _chain: List<Element?>? = null
    var component: List<SearchParameter.Component>? = null
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
        22 -> derivedFrom = decoder.decodeStringElement(descriptor, i)
        23 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> status = decoder.decodeStringElement(descriptor, i)
        25 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        27 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> date = decoder.decodeStringElement(descriptor, i)
        29 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> publisher = decoder.decodeStringElement(descriptor, i)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        33 -> description = decoder.decodeStringElement(descriptor, i)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        36 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        37 -> purpose = decoder.decodeStringElement(descriptor, i)
        38 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> copyright = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        42 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 -> code = decoder.decodeStringElement(descriptor, i)
        44 ->
          _code = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 ->
          base =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        46 ->
          _base =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        47 -> type = decoder.decodeStringElement(descriptor, i)
        48 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        49 -> expression = decoder.decodeStringElement(descriptor, i)
        50 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        51 -> processingMode = decoder.decodeStringElement(descriptor, i)
        52 ->
          _processingMode =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        53 -> constraint = decoder.decodeStringElement(descriptor, i)
        54 ->
          _constraint =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        55 ->
          target =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        56 ->
          _target =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        57 -> multipleOr = decoder.decodeBooleanElement(descriptor, i)
        58 ->
          _multipleOr =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        59 -> multipleAnd = decoder.decodeBooleanElement(descriptor, i)
        60 ->
          _multipleAnd =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        61 ->
          comparator =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        62 ->
          _comparator =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        63 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        64 ->
          _modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        65 ->
          chain =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        66 ->
          _chain =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        67 ->
          component =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SearchParameterComponentSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SearchParameter: " + i)
      }
    }
    return SearchParameter(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url =
        Uri.of(url, _url)
          ?: throw SerializationException("Missing required property 'url' on SearchParameter"),
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        SearchParameter.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name =
        R5String.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on SearchParameter"),
      title = R5String.of(title, _title),
      derivedFrom = Canonical.of(derivedFrom, _derivedFrom),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on SearchParameter"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description =
        Markdown.of(description, _description)
          ?: throw SerializationException(
            "Missing required property 'description' on SearchParameter"
          ),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      code =
        Code.of(code, _code)
          ?: throw SerializationException("Missing required property 'code' on SearchParameter"),
      base =
        (kotlin.collections.List(maxOf(base?.size ?: 0, _base?.size ?: 0)) { index ->
          Enumeration.of(
            base?.getOrNull(index)?.let {
              SearchParameter.VersionIndependentResourceTypesAll.fromCode(it)
            },
            _base?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'base' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      type =
        Enumeration.of(if (type != null) SearchParamType.fromCode(type) else null, _type)
          ?: throw SerializationException("Missing required property 'type' on SearchParameter"),
      expression = R5String.of(expression, _expression),
      processingMode =
        Enumeration.of(
          if (processingMode != null)
            SearchParameter.SearchProcessingModeType.fromCode(processingMode)
          else null,
          _processingMode,
        ),
      constraint = R5String.of(constraint, _constraint),
      target =
        (kotlin.collections.List(maxOf(target?.size ?: 0, _target?.size ?: 0)) { index ->
          Enumeration.of(
            target?.getOrNull(index)?.let {
              SearchParameter.VersionIndependentResourceTypesAll.fromCode(it)
            },
            _target?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'target' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      multipleOr = R5Boolean.of(multipleOr, _multipleOr),
      multipleAnd = R5Boolean.of(multipleAnd, _multipleAnd),
      comparator =
        (kotlin.collections.List(maxOf(comparator?.size ?: 0, _comparator?.size ?: 0)) { index ->
          Enumeration.of(
            comparator?.getOrNull(index)?.let { SearchParameter.SearchComparator.fromCode(it) },
            _comparator?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'comparator' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      modifier =
        (kotlin.collections.List(maxOf(modifier?.size ?: 0, _modifier?.size ?: 0)) { index ->
          Enumeration.of(
            modifier?.getOrNull(index)?.let { SearchParameter.SearchModifierCode.fromCode(it) },
            _modifier?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'modifier' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      chain =
        (kotlin.collections.List(maxOf(chain?.size ?: 0, _chain?.size ?: 0)) { index ->
          R5String.of(chain?.getOrNull(index), _chain?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'chain' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      component = component ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SearchParameter,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url.value)
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
      is SearchParameter.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is SearchParameter.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.derivedFrom?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.derivedFrom)
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 26 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.description.value)
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.copyrightLabel)
    encoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, value.code.value)
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.code)
    if (value.base.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        value.base.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 46 + descriptorOffset, value.base)
    }
    encoder.encodeStringIfNotNull(descriptor, 47 + descriptorOffset, value.type.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.type)
    encoder.encodeStringIfNotNull(descriptor, 49 + descriptorOffset, value.expression?.value)
    encoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.expression)
    encoder.encodeStringIfNotNull(
      descriptor,
      51 + descriptorOffset,
      value.processingMode?.value?.code,
    )
    encoder.encodeElementIfNotNull(descriptor, 52 + descriptorOffset, value.processingMode)
    encoder.encodeStringIfNotNull(descriptor, 53 + descriptorOffset, value.constraint?.value)
    encoder.encodeElementIfNotNull(descriptor, 54 + descriptorOffset, value.constraint)
    if (value.target.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        55 + descriptorOffset,
        stringNullableListSerializer,
        value.target.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 56 + descriptorOffset, value.target)
    }
    encoder.encodeBooleanIfNotNull(descriptor, 57 + descriptorOffset, value.multipleOr?.value)
    encoder.encodeElementIfNotNull(descriptor, 58 + descriptorOffset, value.multipleOr)
    encoder.encodeBooleanIfNotNull(descriptor, 59 + descriptorOffset, value.multipleAnd?.value)
    encoder.encodeElementIfNotNull(descriptor, 60 + descriptorOffset, value.multipleAnd)
    if (value.comparator.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        61 + descriptorOffset,
        stringNullableListSerializer,
        value.comparator.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 62 + descriptorOffset, value.comparator)
    }
    if (value.modifier.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        63 + descriptorOffset,
        stringNullableListSerializer,
        value.modifier.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 64 + descriptorOffset, value.modifier)
    }
    if (value.chain.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        65 + descriptorOffset,
        stringNullableListSerializer,
        value.chain.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 66 + descriptorOffset, value.chain)
    }
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        67 + descriptorOffset,
        SearchParameterComponentSerializer.listSerializer,
        value.component,
      )
  }
}
