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
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.SearchParameter
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
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

internal object SearchParameterComponentSerializer : KSerializer<SearchParameter.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
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
      element("definition", KotlinString.serializer().descriptor, isOptional = true)
      element("_definition", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SearchParameter.Component =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SearchParameter.Component) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SearchParameter.Component {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> definition = decoder.decodeStringElement(descriptor, i)
        4 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.definitionSer, null)
        5 -> expression = decoder.decodeStringElement(descriptor, i)
        6 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.definitionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + i)
      }
    }
    return SearchParameter.Component(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      definition = Canonical.of(definition, _definition)!!,
      expression = R4String.of(expression, _expression)!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SearchParameter.Component) {
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
    ((value.definition.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.definition.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.definitionSer, it)
    }
    ((value.expression.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.expression.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.definitionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val definitionSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SearchParameterSerializer : KSerializer<SearchParameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SearchParameter") {
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
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("derivedFrom", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_derivedFrom", Element.serializer().descriptor, isOptional = true)
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
    b.element("code", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_code", Element.serializer().descriptor, isOptional = true)
    b.element("base", listSerialDescriptor(KotlinString.serializer().descriptor), isOptional = true)
    b.element("_base", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element("expression", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_expression", Element.serializer().descriptor, isOptional = true)
    b.element("xpath", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_xpath", Element.serializer().descriptor, isOptional = true)
    b.element("xpathUsage", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_xpathUsage", Element.serializer().descriptor, isOptional = true)
    b.element(
      "target",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_target", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("multipleOr", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_multipleOr", Element.serializer().descriptor, isOptional = true)
    b.element("multipleAnd", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_multipleAnd", Element.serializer().descriptor, isOptional = true)
    b.element(
      "comparator",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_comparator",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifier",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_modifier", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "chain",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_chain", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "component",
      listSerialDescriptor(lazyDescriptor { SearchParameter.Component.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SearchParameter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: SearchParameter) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SearchParameter")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 -> version = decoder.decodeStringElement(descriptor, i)
        13 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 -> derivedFrom = decoder.decodeStringElement(descriptor, i)
        17 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        21 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> date = decoder.decodeStringElement(descriptor, i)
        23 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> publisher = decoder.decodeStringElement(descriptor, i)
        25 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        27 -> description = decoder.decodeStringElement(descriptor, i)
        28 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        30 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        31 -> purpose = decoder.decodeStringElement(descriptor, i)
        32 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 -> code = decoder.decodeStringElement(descriptor, i)
        34 ->
          _code =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> base = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer, null)
        36 ->
          _base = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer2, null)
        37 -> type = decoder.decodeStringElement(descriptor, i)
        38 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> expression = decoder.decodeStringElement(descriptor, i)
        40 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> xpath = decoder.decodeStringElement(descriptor, i)
        42 ->
          _xpath =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 -> xpathUsage = decoder.decodeStringElement(descriptor, i)
        44 ->
          _xpathUsage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer, null)
        46 ->
          _target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer2, null)
        47 -> multipleOr = decoder.decodeBooleanElement(descriptor, i)
        48 ->
          _multipleOr =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        49 -> multipleAnd = decoder.decodeBooleanElement(descriptor, i)
        50 ->
          _multipleAnd =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        51 ->
          comparator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer, null)
        52 ->
          _comparator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer2, null)
        53 ->
          modifier = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer, null)
        54 ->
          _modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer2, null)
        55 ->
          chain = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer, null)
        56 ->
          _chain = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseSer2, null)
        57 ->
          component =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.componentSer, null)
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
      url = Uri.of(url, _url)!!,
      version = R4String.of(version, _version),
      name = R4String.of(name, _name)!!,
      derivedFrom = Canonical.of(derivedFrom, _derivedFrom),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description)!!,
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      code = Code.of(code, _code)!!,
      base =
        (kotlin.collections.List(maxOf(base?.size ?: 0, _base?.size ?: 0)) { index ->
          Enumeration.of(ResourceType.fromCode(base?.getOrNull(index)!!), _base?.getOrNull(index))
        }),
      type = Enumeration.of(SearchParamType.fromCode(type!!), _type),
      expression = R4String.of(expression, _expression),
      xpath = R4String.of(xpath, _xpath),
      xpathUsage =
        xpathUsage?.let {
          Enumeration.of(SearchParameter.XPathUsageType.fromCode(it), _xpathUsage)
        },
      target =
        (kotlin.collections.List(maxOf(target?.size ?: 0, _target?.size ?: 0)) { index ->
          Enumeration.of(
            ResourceType.fromCode(target?.getOrNull(index)!!),
            _target?.getOrNull(index),
          )
        }),
      multipleOr = R4Boolean.of(multipleOr, _multipleOr),
      multipleAnd = R4Boolean.of(multipleAnd, _multipleAnd),
      comparator =
        (kotlin.collections.List(maxOf(comparator?.size ?: 0, _comparator?.size ?: 0)) { index ->
          Enumeration.of(
            SearchParameter.SearchComparator.fromCode(comparator?.getOrNull(index)!!),
            _comparator?.getOrNull(index),
          )
        }),
      modifier =
        (kotlin.collections.List(maxOf(modifier?.size ?: 0, _modifier?.size ?: 0)) { index ->
          Enumeration.of(
            SearchParameter.SearchModifierCode.fromCode(modifier?.getOrNull(index)!!),
            _modifier?.getOrNull(index),
          )
        }),
      chain =
        (kotlin.collections.List(maxOf(chain?.size ?: 0, _chain?.size ?: 0)) { index ->
          R4String.of(chain?.getOrNull(index)?.let { it }, _chain?.getOrNull(index))!!
        }),
      component = component ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SearchParameter,
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
    ((value.url.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.derivedFrom?.value))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.derivedFrom?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.description.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.base.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, Hoisted.baseSer, it)
    }
    (value.base.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 36 + descriptorOffset, Hoisted.baseSer2, it)
    }
    ((value.type.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.expression?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.xpath?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.xpath?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.xpathUsage?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.xpathUsage?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.target.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 45 + descriptorOffset, Hoisted.baseSer, it)
    }
    (value.target.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 46 + descriptorOffset, Hoisted.baseSer2, it)
    }
    ((value.multipleOr?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 47 + descriptorOffset, it)
    }
    (value.multipleOr?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.multipleAnd?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 49 + descriptorOffset, it)
    }
    (value.multipleAnd?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.comparator.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 51 + descriptorOffset, Hoisted.baseSer, it)
    }
    (value.comparator.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 52 + descriptorOffset, Hoisted.baseSer2, it)
    }
    (value.modifier.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 53 + descriptorOffset, Hoisted.baseSer, it)
    }
    (value.modifier.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 54 + descriptorOffset, Hoisted.baseSer2, it)
    }
    (value.chain.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 55 + descriptorOffset, Hoisted.baseSer, it)
    }
    (value.chain.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 56 + descriptorOffset, Hoisted.baseSer2, it)
    }
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        Hoisted.componentSer,
        value.component,
      )
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

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val baseSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val baseSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.baseSerInner).nullable)

    public val baseSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val componentSerInner: KSerializer<SearchParameter.Component> =
      SearchParameter.Component.serializer()

    public val componentSer: KSerializer<List<SearchParameter.Component>> =
      ListSerializer(Hoisted.componentSerInner)
  }
}

internal object SearchParameterPolymorphicSerializer : KSerializer<SearchParameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SearchParameter") {
      SearchParameterSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SearchParameter) {
    encoder.encodeStructure(descriptor) {
      SearchParameterSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SearchParameter =
    decoder.decodeStructure(descriptor) {
      SearchParameterSerializer.deserializeInternal(this, descriptor, 0)
    }
}
