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
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object SearchParameterComponentSerializer : FhirSerializer<SearchParameter.Component> {
  override val descriptor: SerialDescriptor = buildDescriptor("Component", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SearchParameter.Component>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("definition")
    b.strPrim("expression")
  }

  override fun deserialize(decoder: Decoder): SearchParameter.Component {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SearchParameter.Component(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      definition =
        required(Canonical.of(definition, _definition), "SearchParameter.Component", "definition"),
      expression =
        required(R4String.of(expression, _expression), "SearchParameter.Component", "expression"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SearchParameter.Component) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("url")
    b.strPrim("version")
    b.strPrim("name")
    b.strPrim("derivedFrom")
    b.strPrim("status")
    b.boolPrim("experimental")
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("code")
    b.strPrimList("base")
    b.strPrim("type")
    b.strPrim("expression")
    b.strPrim("xpath")
    b.strPrim("xpathUsage")
    b.strPrimList("target")
    b.boolPrim("multipleOr")
    b.boolPrim("multipleAnd")
    b.strPrimList("comparator")
    b.strPrimList("modifier")
    b.strPrimList("chain")
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
    var status: PublicationStatus? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: FhirDateTime? = null
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
    var type: SearchParamType? = null
    var _type: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var xpath: KotlinString? = null
    var _xpath: Element? = null
    var xpathUsage: XPathUsageType? = null
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
        18 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        22 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        37 -> type = SearchParamType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        43 ->
          xpathUsage = XPathUsageType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    val base_ =
      List(maxSize(base, _base)) { index ->
        entryRequired(
          Enumeration.of(at(base, index)?.let { ResourceType.fromCode(it) }, at(_base, index)),
          "SearchParameter",
          "base",
        )
      }
    val target_ =
      List(maxSize(target, _target)) { index ->
        entryRequired(
          Enumeration.of(at(target, index)?.let { ResourceType.fromCode(it) }, at(_target, index)),
          "SearchParameter",
          "target",
        )
      }
    val comparator_ =
      List(maxSize(comparator, _comparator)) { index ->
        entryRequired(
          Enumeration.of(
            at(comparator, index)?.let { SearchComparator.fromCode(it) },
            at(_comparator, index),
          ),
          "SearchParameter",
          "comparator",
        )
      }
    val modifier_ =
      List(maxSize(modifier, _modifier)) { index ->
        entryRequired(
          Enumeration.of(
            at(modifier, index)?.let { SearchModifierCode.fromCode(it) },
            at(_modifier, index),
          ),
          "SearchParameter",
          "modifier",
        )
      }
    val chain_ =
      List(maxSize(chain, _chain)) { index ->
        entryRequired(R4String.of(at(chain, index), at(_chain, index)), "SearchParameter", "chain")
      }
    return SearchParameter(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = required(Uri.of(url, _url), "SearchParameter", "url"),
      version = R4String.of(version, _version),
      name = required(R4String.of(name, _name), "SearchParameter", "name"),
      derivedFrom = Canonical.of(derivedFrom, _derivedFrom),
      status = required(Enumeration.of(status, _status), "SearchParameter", "status"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description =
        required(Markdown.of(description, _description), "SearchParameter", "description"),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      code = required(Code.of(code, _code), "SearchParameter", "code"),
      base = base_,
      type = required(Enumeration.of(type, _type), "SearchParameter", "type"),
      expression = R4String.of(expression, _expression),
      xpath = R4String.of(xpath, _xpath),
      xpathUsage = Enumeration.of(xpathUsage, _xpathUsage),
      target = target_,
      multipleOr = R4Boolean.of(multipleOr, _multipleOr),
      multipleAnd = R4Boolean.of(multipleAnd, _multipleAnd),
      comparator = comparator_,
      modifier = modifier_,
      chain = chain_,
      component = listOrEmpty(component),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      29 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.code)
    if (!value.base.isEmpty()) {
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
    if (!value.target.isEmpty()) {
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
    if (!value.comparator.isEmpty()) {
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
    if (!value.modifier.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        53 + descriptorOffset,
        stringNullableListSerializer,
        value.modifier.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 54 + descriptorOffset, value.modifier)
    }
    if (!value.chain.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        55 + descriptorOffset,
        stringNullableListSerializer,
        value.chain.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 56 + descriptorOffset, value.chain)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      57 + descriptorOffset,
      SearchParameterComponentSerializer.listSerializer,
      value.component,
    )
  }
}
