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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.SearchParameter
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
import dev.ohs.fhir.model.r4.terminologies.SearchComparator
import dev.ohs.fhir.model.r4.terminologies.SearchModifierCode
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import dev.ohs.fhir.model.r4.terminologies.XPathUsageType
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

  override fun deserialize(decoder: Decoder): SearchParameter.Component {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> definition = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _definition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> expression = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SearchParameter.Component(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      definition =
        Canonical.of(definition, _definition)
          ?: throw SerializationException(
            "Missing required property 'definition' on SearchParameter.Component"
          ),
      expression =
        R4String.of(expression, _expression)
          ?: throw SerializationException(
            "Missing required property 'expression' on SearchParameter.Component"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SearchParameter.Component) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.definition.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.definition)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.expression.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.expression)
    compositeEncoder.endStructure(descriptor)
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
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
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
    b.optionalElement("code", KotlinString.serializer().descriptor)
    b.optionalElement("_code", ElementSerializer.descriptor)
    b.optionalElement("base", stringNullableListSerializer.descriptor)
    b.optionalElement("_base", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("expression", KotlinString.serializer().descriptor)
    b.optionalElement("_expression", ElementSerializer.descriptor)
    b.optionalElement("xpath", KotlinString.serializer().descriptor)
    b.optionalElement("_xpath", ElementSerializer.descriptor)
    b.optionalElement("xpathUsage", KotlinString.serializer().descriptor)
    b.optionalElement("_xpathUsage", ElementSerializer.descriptor)
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
    compositeDecoder: CompositeDecoder,
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
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
    var code: KotlinString? = null
    var _code: Element? = null
    var base: List<KotlinString?>? = null
    var _base: List<Element?>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var xpath: KotlinString? = null
    var _xpath: Element? = null
    var xpathUsage: KotlinString? = null
    var _xpathUsage: Element? = null
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> derivedFrom = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _derivedFrom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        21 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        27 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        30 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          base =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        36 ->
          _base =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        37 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> expression = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> xpath = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _xpath =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> xpathUsage = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _xpathUsage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 ->
          target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        46 ->
          _target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        47 -> multipleOr = compositeDecoder.decodeBooleanElement(descriptor, i)
        48 ->
          _multipleOr =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        49 -> multipleAnd = compositeDecoder.decodeBooleanElement(descriptor, i)
        50 ->
          _multipleAnd =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        51 ->
          comparator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        52 ->
          _comparator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        53 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        54 ->
          _modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        55 ->
          chain =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        56 ->
          _chain =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        57 ->
          component =
            compositeDecoder.decodeNullableSerializableElement(
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
      version = R4String.of(version, _version),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on SearchParameter"),
      derivedFrom = Canonical.of(derivedFrom, _derivedFrom),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on SearchParameter"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description =
        Markdown.of(description, _description)
          ?: throw SerializationException(
            "Missing required property 'description' on SearchParameter"
          ),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      code =
        Code.of(code, _code)
          ?: throw SerializationException("Missing required property 'code' on SearchParameter"),
      base =
        (kotlin.collections.List(maxOf(base?.size ?: 0, _base?.size ?: 0)) { index ->
          Enumeration.of(
            base?.getOrNull(index)?.let { ResourceType.fromCode(it) },
            _base?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'base' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      type =
        Enumeration.of(if (type != null) SearchParamType.fromCode(type) else null, _type)
          ?: throw SerializationException("Missing required property 'type' on SearchParameter"),
      expression = R4String.of(expression, _expression),
      xpath = R4String.of(xpath, _xpath),
      xpathUsage =
        Enumeration.of(
          if (xpathUsage != null) XPathUsageType.fromCode(xpathUsage) else null,
          _xpathUsage,
        ),
      target =
        (kotlin.collections.List(maxOf(target?.size ?: 0, _target?.size ?: 0)) { index ->
          Enumeration.of(
            target?.getOrNull(index)?.let { ResourceType.fromCode(it) },
            _target?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'target' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      multipleOr = R4Boolean.of(multipleOr, _multipleOr),
      multipleAnd = R4Boolean.of(multipleAnd, _multipleAnd),
      comparator =
        (kotlin.collections.List(maxOf(comparator?.size ?: 0, _comparator?.size ?: 0)) { index ->
          Enumeration.of(
            comparator?.getOrNull(index)?.let { SearchComparator.fromCode(it) },
            _comparator?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'comparator' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      modifier =
        (kotlin.collections.List(maxOf(modifier?.size ?: 0, _modifier?.size ?: 0)) { index ->
          Enumeration.of(
            modifier?.getOrNull(index)?.let { SearchModifierCode.fromCode(it) },
            _modifier?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'modifier' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      chain =
        (kotlin.collections.List(maxOf(chain?.size ?: 0, _chain?.size ?: 0)) { index ->
          R4String.of(chain?.getOrNull(index), _chain?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'chain' on SearchParameter has neither a value nor an id/extension"
            )
        }),
      component = component ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SearchParameter,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.derivedFrom?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.derivedFrom)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      27 + descriptorOffset,
      value.description.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.code)
    if (value.base.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        35 + descriptorOffset,
        stringNullableListSerializer,
        value.base.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 36 + descriptorOffset, value.base)
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.type.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.type)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.expression?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.expression)
    compositeEncoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.xpath?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.xpath)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.xpathUsage?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.xpathUsage)
    if (value.target.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        value.target.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 46 + descriptorOffset, value.target)
    }
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      47 + descriptorOffset,
      value.multipleOr?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.multipleOr)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      49 + descriptorOffset,
      value.multipleAnd?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.multipleAnd)
    if (value.comparator.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        51 + descriptorOffset,
        stringNullableListSerializer,
        value.comparator.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        52 + descriptorOffset,
        value.comparator,
      )
    }
    if (value.modifier.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        53 + descriptorOffset,
        stringNullableListSerializer,
        value.modifier.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 54 + descriptorOffset, value.modifier)
    }
    if (value.chain.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        55 + descriptorOffset,
        stringNullableListSerializer,
        value.chain.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 56 + descriptorOffset, value.chain)
    }
    if (value.component.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        SearchParameterComponentSerializer.listSerializer,
        value.component,
      )
  }
}
