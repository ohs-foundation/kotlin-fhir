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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.CompartmentDefinition
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object CompartmentDefinitionResourceSerializer :
  KSerializer<CompartmentDefinition.Resource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Resource") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element(
        "param",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_param", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
      element("startParam", KotlinString.serializer().descriptor, isOptional = true)
      element("_startParam", Element.serializer().descriptor, isOptional = true)
      element("endParam", KotlinString.serializer().descriptor, isOptional = true)
      element("_endParam", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CompartmentDefinition.Resource =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CompartmentDefinition.Resource) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CompartmentDefinition.Resource {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var `param`: List<KotlinString?>? = null
    var _param: List<Element?>? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var startParam: KotlinString? = null
    var _startParam: Element? = null
    var endParam: KotlinString? = null
    var _endParam: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> `param` = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.paramSer, null)
        6 -> _param = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.paramSer2, null)
        7 -> documentation = decoder.decodeStringElement(__desc, 7)
        8 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.codeSer, null)
        9 -> startParam = decoder.decodeStringElement(__desc, 9)
        10 ->
          _startParam = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.codeSer, null)
        11 -> endParam = decoder.decodeStringElement(__desc, 11)
        12 ->
          _endParam = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + __i)
      }
    }
    return CompartmentDefinition.Resource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Enumeration.of(ResourceType.fromCode(code!!), _code),
      `param` =
        (kotlin.collections.List(maxOf(`param`?.size ?: 0, _param?.size ?: 0)) { __i ->
          R5String.of(`param`?.getOrNull(__i)?.let { it }, _param?.getOrNull(__i))!!
        }),
      documentation = R5String.of(documentation, _documentation),
      startParam = Uri.of(startParam, _startParam),
      endParam = Uri.of(endParam, _endParam),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CompartmentDefinition.Resource) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    (value.`param`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.paramSer, it)
    }
    (value.`param`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.paramSer2, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, it)
    }
    ((value.startParam?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.startParam?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.codeSer, it)
    }
    ((value.endParam?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.endParam?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val paramSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val paramSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.paramSerInner).nullable)

    public val paramSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.codeSer).nullable)
  }
}

internal object CompartmentDefinitionVersionAlgorithmSerializer :
  KSerializer<CompartmentDefinition.VersionAlgorithm> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CompartmentDefinition.VersionAlgorithm") {
      element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: CompartmentDefinition.VersionAlgorithm) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is CompartmentDefinition.VersionAlgorithm.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is CompartmentDefinition.VersionAlgorithm.Coding -> {
          encodeSerializableElement(__desc, 2, Hoisted.versionAlgorithmCodingSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): CompartmentDefinition.VersionAlgorithm =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): CompartmentDefinition.VersionAlgorithm {
    val __desc = descriptor
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 0)
        1 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              2,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding CompartmentDefinition.VersionAlgorithm: " + __i
          )
      }
    }
    return CompartmentDefinition.VersionAlgorithm.from(
      R5String.of(versionAlgorithmString, _versionAlgorithmString),
      versionAlgorithmCoding,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object CompartmentDefinitionSerializer : KSerializer<CompartmentDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CompartmentDefinition") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("search", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_search", Element.serializer().descriptor, isOptional = true)
      element(
        "resource",
        listSerialDescriptor(
          lazyDescriptor { CompartmentDefinition.Resource.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): CompartmentDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CompartmentDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): CompartmentDefinition {
    val __desc = descriptor
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
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var search: KotlinBoolean? = null
    var _search: Element? = null
    var resource: List<CompartmentDefinition.Resource>? = null
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
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 -> version = decoder.decodeStringElement(__desc, 13)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 15)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(__desc, 18)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(__desc, 20)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> status = decoder.decodeStringElement(__desc, 22)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(__desc, 24)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> date = decoder.decodeStringElement(__desc, 26)
        27 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> publisher = decoder.decodeStringElement(__desc, 28)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.contactSer, null)
        31 -> description = decoder.decodeStringElement(__desc, 31)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.useContextSer, null)
        34 -> purpose = decoder.decodeStringElement(__desc, 34)
        35 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> code = decoder.decodeStringElement(__desc, 36)
        37 ->
          _code =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> search = decoder.decodeBooleanElement(__desc, 38)
        39 ->
          _search =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 ->
          resource =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.resourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding CompartmentDefinition: " + __i)
      }
    }
    return CompartmentDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url)!!,
      version = R5String.of(version, _version),
      versionAlgorithm =
        CompartmentDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name)!!,
      title = R5String.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      code = Enumeration.of(CompartmentDefinition.CompartmentType.fromCode(code!!), _code),
      search = R5Boolean.of(search, _search)!!,
      resource = resource ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CompartmentDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "CompartmentDefinition")
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
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is CompartmentDefinition.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
        }
      }
      is CompartmentDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(__desc, 17, Hoisted.versionAlgorithmCodingSer, __d.value)
      }
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 24, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.useContextSer, value.useContext)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.search.value))?.let { encoder.encodeBooleanElement(__desc, 38, it) }
    (value.search.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.resourceSer, value.resource)
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

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val resourceSerInner: KSerializer<CompartmentDefinition.Resource> =
      CompartmentDefinition.Resource.serializer()

    public val resourceSer: KSerializer<List<CompartmentDefinition.Resource>> =
      ListSerializer(Hoisted.resourceSerInner)
  }
}
