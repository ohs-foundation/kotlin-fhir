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
import dev.ohs.fhir.model.r5.ImplementationGuide
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.FHIRVersion
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.ResourceType
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

internal object ImplementationGuideDependsOnSerializer :
  KSerializer<ImplementationGuide.DependsOn> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DependsOn") {
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
      element("uri", KotlinString.serializer().descriptor, isOptional = true)
      element("_uri", Element.serializer().descriptor, isOptional = true)
      element("packageId", KotlinString.serializer().descriptor, isOptional = true)
      element("_packageId", Element.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("reason", KotlinString.serializer().descriptor, isOptional = true)
      element("_reason", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.DependsOn =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.DependsOn) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.DependsOn {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var packageId: KotlinString? = null
    var _packageId: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var reason: KotlinString? = null
    var _reason: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> uri = decoder.decodeStringElement(__desc, __i)
        4 -> _uri = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.uriSer, null)
        5 -> packageId = decoder.decodeStringElement(__desc, __i)
        6 ->
          _packageId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.uriSer, null)
        7 -> version = decoder.decodeStringElement(__desc, __i)
        8 -> _version = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.uriSer, null)
        9 -> reason = decoder.decodeStringElement(__desc, __i)
        10 -> _reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.uriSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DependsOn: " + __i)
      }
    }
    return ImplementationGuide.DependsOn(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      uri = Canonical.of(uri, _uri)!!,
      packageId = Id.of(packageId, _packageId),
      version = R5String.of(version, _version),
      reason = Markdown.of(reason, _reason),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImplementationGuide.DependsOn) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.uri.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.uri.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.uriSer, it)
    }
    ((value.packageId?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.packageId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.uriSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.uriSer, it)
    }
    ((value.reason?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.reason?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.uriSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val uriSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ImplementationGuideGlobalSerializer : KSerializer<ImplementationGuide.Global> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Global") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("profile", KotlinString.serializer().descriptor, isOptional = true)
      element("_profile", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Global =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Global) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Global {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, __i)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 -> profile = decoder.decodeStringElement(__desc, __i)
        6 ->
          _profile = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Global: " + __i)
      }
    }
    return ImplementationGuide.Global(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(ResourceType.fromCode(type!!), _type),
      profile = Canonical.of(profile, _profile)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImplementationGuide.Global) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    ((value.profile.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.profile.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ImplementationGuideDefinitionSerializer :
  KSerializer<ImplementationGuide.Definition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Definition") {
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
      element(
        "grouping",
        listSerialDescriptor(
          lazyDescriptor { ImplementationGuide.Definition.Grouping.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "resource",
        listSerialDescriptor(
          lazyDescriptor { ImplementationGuide.Definition.Resource.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "page",
        lazyDescriptor { ImplementationGuide.Definition.Page.serializer().descriptor },
        isOptional = true,
      )
      element(
        "parameter",
        listSerialDescriptor(
          lazyDescriptor { ImplementationGuide.Definition.Parameter.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "template",
        listSerialDescriptor(
          lazyDescriptor { ImplementationGuide.Definition.Template.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Definition {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var grouping: List<ImplementationGuide.Definition.Grouping>? = null
    var resource: List<ImplementationGuide.Definition.Resource>? = null
    var page: ImplementationGuide.Definition.Page? = null
    var parameter: List<ImplementationGuide.Definition.Parameter>? = null
    var template: List<ImplementationGuide.Definition.Template>? = null
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
          grouping =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.groupingSer, null)
        4 ->
          resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.resourceSer, null)
        5 -> page = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.pageSer, null)
        6 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parameterSer, null)
        7 ->
          template =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.templateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Definition: " + __i)
      }
    }
    return ImplementationGuide.Definition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      grouping = grouping ?: listOf(),
      resource = resource ?: listOf(),
      page = page,
      parameter = parameter ?: listOf(),
      template = template ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImplementationGuide.Definition) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.grouping.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.groupingSer, value.grouping)
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.resourceSer, value.resource)
    (value.page)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.pageSer, it) }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.parameterSer, value.parameter)
    if (value.template.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.templateSer, value.template)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val groupingSerInner: KSerializer<ImplementationGuide.Definition.Grouping> =
      ImplementationGuide.Definition.Grouping.serializer()

    public val groupingSer: KSerializer<List<ImplementationGuide.Definition.Grouping>> =
      ListSerializer(Hoisted.groupingSerInner)

    public val resourceSerInner: KSerializer<ImplementationGuide.Definition.Resource> =
      ImplementationGuide.Definition.Resource.serializer()

    public val resourceSer: KSerializer<List<ImplementationGuide.Definition.Resource>> =
      ListSerializer(Hoisted.resourceSerInner)

    public val pageSer: KSerializer<ImplementationGuide.Definition.Page> =
      ImplementationGuide.Definition.Page.serializer()

    public val parameterSerInner: KSerializer<ImplementationGuide.Definition.Parameter> =
      ImplementationGuide.Definition.Parameter.serializer()

    public val parameterSer: KSerializer<List<ImplementationGuide.Definition.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)

    public val templateSerInner: KSerializer<ImplementationGuide.Definition.Template> =
      ImplementationGuide.Definition.Template.serializer()

    public val templateSer: KSerializer<List<ImplementationGuide.Definition.Template>> =
      ListSerializer(Hoisted.templateSerInner)
  }
}

internal object ImplementationGuideDefinitionGroupingSerializer :
  KSerializer<ImplementationGuide.Definition.Grouping> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Grouping") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Grouping =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Grouping) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Definition.Grouping {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 -> description = decoder.decodeStringElement(__desc, __i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Grouping: " + __i)
      }
    }
    return ImplementationGuide.Definition.Grouping(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name)!!,
      description = Markdown.of(description, _description),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Grouping,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ImplementationGuideDefinitionResourceSerializer :
  KSerializer<ImplementationGuide.Definition.Resource> {
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
      element("reference", Reference.serializer().descriptor, isOptional = true)
      element(
        "fhirVersion",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_fhirVersion",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("isExample", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isExample", Element.serializer().descriptor, isOptional = true)
      element(
        "profile",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_profile", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("groupingId", KotlinString.serializer().descriptor, isOptional = true)
      element("_groupingId", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Resource =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Resource) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Definition.Resource {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var fhirVersion: List<KotlinString?>? = null
    var _fhirVersion: List<Element?>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var isExample: KotlinBoolean? = null
    var _isExample: Element? = null
    var profile: List<KotlinString?>? = null
    var _profile: List<Element?>? = null
    var groupingId: KotlinString? = null
    var _groupingId: Element? = null
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
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceSer, null)
        4 ->
          fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.fhirVersionSer, null)
        5 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.fhirVersionSer2, null)
        6 -> name = decoder.decodeStringElement(__desc, __i)
        7 ->
          _name =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        8 -> description = decoder.decodeStringElement(__desc, __i)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        10 -> isExample = decoder.decodeBooleanElement(__desc, __i)
        11 ->
          _isExample =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        12 ->
          profile =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.fhirVersionSer, null)
        13 ->
          _profile =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.fhirVersionSer2, null)
        14 -> groupingId = decoder.decodeStringElement(__desc, __i)
        15 ->
          _groupingId =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + __i)
      }
    }
    return ImplementationGuide.Definition.Resource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference!!,
      fhirVersion =
        (kotlin.collections.List(maxOf(fhirVersion?.size ?: 0, _fhirVersion?.size ?: 0)) { __i ->
          Enumeration.of(
            FHIRVersion.fromCode(fhirVersion?.getOrNull(__i)!!),
            _fhirVersion?.getOrNull(__i),
          )
        }),
      name = R5String.of(name, _name),
      description = Markdown.of(description, _description),
      isExample = R5Boolean.of(isExample, _isExample),
      profile =
        (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { __i ->
          Canonical.of(profile?.getOrNull(__i)?.let { it }, _profile?.getOrNull(__i))!!
        }),
      groupingId = Id.of(groupingId, _groupingId),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Resource,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.referenceSer, it)
    }
    (value.fhirVersion.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.fhirVersionSer, it)
    }
    (value.fhirVersion.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.fhirVersionSer2, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.fhirVersionSerInner2, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.fhirVersionSerInner2, it)
    }
    ((value.isExample?.value))?.let { encoder.encodeBooleanElement(__desc, 10, it) }
    (value.isExample?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.fhirVersionSerInner2, it)
    }
    (value.profile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.fhirVersionSer, it)
    }
    (value.profile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.fhirVersionSer2, it)
    }
    ((value.groupingId?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.groupingId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.fhirVersionSerInner2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSer: KSerializer<Reference> = Reference.serializer()

    public val fhirVersionSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val fhirVersionSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.fhirVersionSerInner).nullable)

    public val fhirVersionSerInner2: KSerializer<Element> = Element.serializer()

    public val fhirVersionSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.fhirVersionSerInner2).nullable)
  }
}

internal object ImplementationGuideDefinitionPageSerializer :
  KSerializer<ImplementationGuide.Definition.Page> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Page") {
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
      element("sourceUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceUrl", Element.serializer().descriptor, isOptional = true)
      element("sourceString", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceString", Element.serializer().descriptor, isOptional = true)
      element("sourceMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceMarkdown", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("generation", KotlinString.serializer().descriptor, isOptional = true)
      element("_generation", Element.serializer().descriptor, isOptional = true)
      element(
        "page",
        listSerialDescriptor(
          lazyDescriptor { ImplementationGuide.Definition.Page.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Page =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Page) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Definition.Page {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sourceUrl: KotlinString? = null
    var _sourceUrl: Element? = null
    var sourceString: KotlinString? = null
    var _sourceString: Element? = null
    var sourceMarkdown: KotlinString? = null
    var _sourceMarkdown: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var generation: KotlinString? = null
    var _generation: Element? = null
    var page: List<ImplementationGuide.Definition.Page>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> sourceUrl = decoder.decodeStringElement(__desc, __i)
        4 ->
          _sourceUrl =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceUrlSer, null)
        5 -> sourceString = decoder.decodeStringElement(__desc, __i)
        6 ->
          _sourceString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceUrlSer, null)
        7 -> sourceMarkdown = decoder.decodeStringElement(__desc, __i)
        8 ->
          _sourceMarkdown =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceUrlSer, null)
        9 -> name = decoder.decodeStringElement(__desc, __i)
        10 ->
          _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceUrlSer, null)
        11 -> title = decoder.decodeStringElement(__desc, __i)
        12 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceUrlSer, null)
        13 -> generation = decoder.decodeStringElement(__desc, __i)
        14 ->
          _generation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceUrlSer, null)
        15 -> page = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.pageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Page: " + __i)
      }
    }
    return ImplementationGuide.Definition.Page(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      source =
        ImplementationGuide.Definition.Page.Source.from(
          Url.of(sourceUrl, _sourceUrl),
          R5String.of(sourceString, _sourceString),
          Markdown.of(sourceMarkdown, _sourceMarkdown),
        ),
      name = Url.of(name, _name)!!,
      title = R5String.of(title, _title)!!,
      generation =
        Enumeration.of(ImplementationGuide.GuidePageGeneration.fromCode(generation!!), _generation),
      page = page ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Page,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.source) {
      null -> {}
      is ImplementationGuide.Definition.Page.Source.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.sourceUrlSer, it)
        }
      }
      is ImplementationGuide.Definition.Page.Source.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.sourceUrlSer, it)
        }
      }
      is ImplementationGuide.Definition.Page.Source.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.sourceUrlSer, it)
        }
      }
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.sourceUrlSer, it)
    }
    ((value.title.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.sourceUrlSer, it)
    }
    ((value.generation.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.generation.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.sourceUrlSer, it)
    }
    if (value.page.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.pageSer, value.page)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sourceUrlSer: KSerializer<Element> = Element.serializer()

    public val pageSerInner: KSerializer<ImplementationGuide.Definition.Page> =
      ImplementationGuide.Definition.Page.serializer()

    public val pageSer: KSerializer<List<ImplementationGuide.Definition.Page>> =
      ListSerializer(Hoisted.pageSerInner)
  }
}

internal object ImplementationGuideDefinitionParameterSerializer :
  KSerializer<ImplementationGuide.Definition.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
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
      element("code", Coding.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Parameter =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Parameter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Definition.Parameter {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: Coding? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 -> `value` = decoder.decodeStringElement(__desc, __i)
        5 -> _value = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return ImplementationGuide.Definition.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      `value` = R5String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Parameter,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Coding> = Coding.serializer()

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ImplementationGuideDefinitionTemplateSerializer :
  KSerializer<ImplementationGuide.Definition.Template> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Template") {
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
      element("source", KotlinString.serializer().descriptor, isOptional = true)
      element("_source", Element.serializer().descriptor, isOptional = true)
      element("scope", KotlinString.serializer().descriptor, isOptional = true)
      element("_scope", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Template =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Template) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Definition.Template {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var scope: KotlinString? = null
    var _scope: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, __i)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> source = decoder.decodeStringElement(__desc, __i)
        6 -> _source = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        7 -> scope = decoder.decodeStringElement(__desc, __i)
        8 -> _scope = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Template: " + __i)
      }
    }
    return ImplementationGuide.Definition.Template(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      source = R5String.of(source, _source)!!,
      scope = R5String.of(scope, _scope),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Template,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.source.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.source.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    ((value.scope?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.scope?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ImplementationGuideManifestSerializer : KSerializer<ImplementationGuide.Manifest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Manifest") {
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
      element("rendering", KotlinString.serializer().descriptor, isOptional = true)
      element("_rendering", Element.serializer().descriptor, isOptional = true)
      element(
        "resource",
        listSerialDescriptor(
          lazyDescriptor { ImplementationGuide.Manifest.Resource.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "page",
        listSerialDescriptor(
          lazyDescriptor { ImplementationGuide.Manifest.Page.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "image",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_image", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "other",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_other", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Manifest {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var rendering: KotlinString? = null
    var _rendering: Element? = null
    var resource: List<ImplementationGuide.Manifest.Resource>? = null
    var page: List<ImplementationGuide.Manifest.Page>? = null
    var image: List<KotlinString?>? = null
    var _image: List<Element?>? = null
    var other: List<KotlinString?>? = null
    var _other: List<Element?>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> rendering = decoder.decodeStringElement(__desc, __i)
        4 ->
          _rendering =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.renderingSer, null)
        5 ->
          resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.resourceSer, null)
        6 -> page = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.pageSer, null)
        7 -> image = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.imageSer, null)
        8 ->
          _image = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.imageSer2, null)
        9 -> other = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.imageSer, null)
        10 ->
          _other = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.imageSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Manifest: " + __i)
      }
    }
    return ImplementationGuide.Manifest(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      rendering = Url.of(rendering, _rendering),
      resource = resource ?: listOf(),
      page = page ?: listOf(),
      image =
        (kotlin.collections.List(maxOf(image?.size ?: 0, _image?.size ?: 0)) { __i ->
          R5String.of(image?.getOrNull(__i)?.let { it }, _image?.getOrNull(__i))!!
        }),
      other =
        (kotlin.collections.List(maxOf(other?.size ?: 0, _other?.size ?: 0)) { __i ->
          R5String.of(other?.getOrNull(__i)?.let { it }, _other?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImplementationGuide.Manifest) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.rendering?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.rendering?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.renderingSer, it)
    }
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.resourceSer, value.resource)
    if (value.page.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.pageSer, value.page)
    (value.image.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.imageSer, it)
    }
    (value.image.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.imageSer2, it)
    }
    (value.other.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.imageSer, it)
    }
    (value.other.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.imageSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val renderingSer: KSerializer<Element> = Element.serializer()

    public val resourceSerInner: KSerializer<ImplementationGuide.Manifest.Resource> =
      ImplementationGuide.Manifest.Resource.serializer()

    public val resourceSer: KSerializer<List<ImplementationGuide.Manifest.Resource>> =
      ListSerializer(Hoisted.resourceSerInner)

    public val pageSerInner: KSerializer<ImplementationGuide.Manifest.Page> =
      ImplementationGuide.Manifest.Page.serializer()

    public val pageSer: KSerializer<List<ImplementationGuide.Manifest.Page>> =
      ListSerializer(Hoisted.pageSerInner)

    public val imageSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val imageSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.imageSerInner).nullable)

    public val imageSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.renderingSer).nullable)
  }
}

internal object ImplementationGuideManifestResourceSerializer :
  KSerializer<ImplementationGuide.Manifest.Resource> {
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
      element("reference", Reference.serializer().descriptor, isOptional = true)
      element("isExample", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isExample", Element.serializer().descriptor, isOptional = true)
      element(
        "profile",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_profile", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("relativePath", KotlinString.serializer().descriptor, isOptional = true)
      element("_relativePath", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest.Resource =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest.Resource) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Manifest.Resource {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var isExample: KotlinBoolean? = null
    var _isExample: Element? = null
    var profile: List<KotlinString?>? = null
    var _profile: List<Element?>? = null
    var relativePath: KotlinString? = null
    var _relativePath: Element? = null
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
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceSer, null)
        4 -> isExample = decoder.decodeBooleanElement(__desc, __i)
        5 ->
          _isExample =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.isExampleSer, null)
        6 ->
          profile = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.profileSer, null)
        7 ->
          _profile =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.profileSer2, null)
        8 -> relativePath = decoder.decodeStringElement(__desc, __i)
        9 ->
          _relativePath =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.isExampleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + __i)
      }
    }
    return ImplementationGuide.Manifest.Resource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference!!,
      isExample = R5Boolean.of(isExample, _isExample),
      profile =
        (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { __i ->
          Canonical.of(profile?.getOrNull(__i)?.let { it }, _profile?.getOrNull(__i))!!
        }),
      relativePath = Url.of(relativePath, _relativePath),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Manifest.Resource,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.referenceSer, it)
    }
    ((value.isExample?.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.isExample?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.isExampleSer, it)
    }
    (value.profile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.profileSer, it)
    }
    (value.profile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.profileSer2, it)
    }
    ((value.relativePath?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.relativePath?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.isExampleSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSer: KSerializer<Reference> = Reference.serializer()

    public val isExampleSer: KSerializer<Element> = Element.serializer()

    public val profileSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val profileSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.profileSerInner).nullable)

    public val profileSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.isExampleSer).nullable)
  }
}

internal object ImplementationGuideManifestPageSerializer :
  KSerializer<ImplementationGuide.Manifest.Page> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Page") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element(
        "anchor",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_anchor", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest.Page =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest.Page) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide.Manifest.Page {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var anchor: List<KotlinString?>? = null
    var _anchor: List<Element?>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 -> title = decoder.decodeStringElement(__desc, __i)
        6 -> _title = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        7 ->
          anchor = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.anchorSer, null)
        8 ->
          _anchor = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.anchorSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Page: " + __i)
      }
    }
    return ImplementationGuide.Manifest.Page(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name)!!,
      title = R5String.of(title, _title),
      anchor =
        (kotlin.collections.List(maxOf(anchor?.size ?: 0, _anchor?.size ?: 0)) { __i ->
          R5String.of(anchor?.getOrNull(__i)?.let { it }, _anchor?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImplementationGuide.Manifest.Page) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    (value.anchor.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.anchorSer, it)
    }
    (value.anchor.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.anchorSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val anchorSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val anchorSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.anchorSerInner).nullable)

    public val anchorSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.nameSer).nullable)
  }
}

internal object ImplementationGuideSerializer : KSerializer<ImplementationGuide> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImplementationGuide") {
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
    b.element("packageId", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_packageId", Element.serializer().descriptor, isOptional = true)
    b.element("license", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_license", Element.serializer().descriptor, isOptional = true)
    b.element(
      "fhirVersion",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_fhirVersion",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "dependsOn",
      listSerialDescriptor(
        lazyDescriptor { ImplementationGuide.DependsOn.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "global",
      listSerialDescriptor(lazyDescriptor { ImplementationGuide.Global.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "definition",
      lazyDescriptor { ImplementationGuide.Definition.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "manifest",
      lazyDescriptor { ImplementationGuide.Manifest.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ImplementationGuide")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): ImplementationGuide {
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
    var packageId: KotlinString? = null
    var _packageId: Element? = null
    var license: KotlinString? = null
    var _license: Element? = null
    var fhirVersion: List<KotlinString?>? = null
    var _fhirVersion: List<Element?>? = null
    var dependsOn: List<ImplementationGuide.DependsOn>? = null
    var global: List<ImplementationGuide.Global>? = null
    var definition: ImplementationGuide.Definition? = null
    var manifest: ImplementationGuide.Manifest? = null
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
        41 -> packageId = decoder.decodeStringElement(__desc, __i)
        42 ->
          _packageId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        43 -> license = decoder.decodeStringElement(__desc, __i)
        44 ->
          _license =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        45 ->
          fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.fhirVersionSer, null)
        46 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.fhirVersionSer2, null)
        47 ->
          dependsOn =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dependsOnSer, null)
        48 ->
          global = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.globalSer, null)
        49 ->
          definition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionSer, null)
        50 ->
          manifest =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.manifestSer, null)
        else ->
          throw SerializationException("Unexpected index decoding ImplementationGuide: " + __i)
      }
    }
    return ImplementationGuide(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url)!!,
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        ImplementationGuide.VersionAlgorithm.from(
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
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      packageId = Id.of(packageId, _packageId)!!,
      license =
        license?.let { Enumeration.of(ImplementationGuide.SPDXLicense.fromCode(it), _license) },
      fhirVersion =
        (kotlin.collections.List(maxOf(fhirVersion?.size ?: 0, _fhirVersion?.size ?: 0)) { __i ->
          Enumeration.of(
            FHIRVersion.fromCode(fhirVersion?.getOrNull(__i)!!),
            _fhirVersion?.getOrNull(__i),
          )
        }),
      dependsOn = dependsOn ?: listOf(),
      global = global ?: listOf(),
      definition = definition,
      manifest = manifest,
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: ImplementationGuide,
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
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.url.toElement())?.let {
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
      is ImplementationGuide.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is ImplementationGuide.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          __desc,
          17 + __off,
          Hoisted.versionAlgorithmCodingSer,
          __d.value,
        )
      }
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.name.toElement())?.let {
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
    ((value.packageId.value))?.let { encoder.encodeStringElement(__desc, 41 + __off, it) }
    (value.packageId.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.license?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 43 + __off, it) }
    (value.license?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.fhirVersion.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.fhirVersionSer, it)
    }
    (value.fhirVersion.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.fhirVersionSer2, it)
    }
    if (value.dependsOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.dependsOnSer, value.dependsOn)
    if (value.global.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48 + __off, Hoisted.globalSer, value.global)
    (value.definition)?.let {
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.definitionSer, it)
    }
    (value.manifest)?.let {
      encoder.encodeSerializableElement(__desc, 50 + __off, Hoisted.manifestSer, it)
    }
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

    public val fhirVersionSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val fhirVersionSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.fhirVersionSerInner).nullable)

    public val fhirVersionSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val dependsOnSerInner: KSerializer<ImplementationGuide.DependsOn> =
      ImplementationGuide.DependsOn.serializer()

    public val dependsOnSer: KSerializer<List<ImplementationGuide.DependsOn>> =
      ListSerializer(Hoisted.dependsOnSerInner)

    public val globalSerInner: KSerializer<ImplementationGuide.Global> =
      ImplementationGuide.Global.serializer()

    public val globalSer: KSerializer<List<ImplementationGuide.Global>> =
      ListSerializer(Hoisted.globalSerInner)

    public val definitionSer: KSerializer<ImplementationGuide.Definition> =
      ImplementationGuide.Definition.serializer()

    public val manifestSer: KSerializer<ImplementationGuide.Manifest> =
      ImplementationGuide.Manifest.serializer()
  }
}

internal object ImplementationGuidePolymorphicSerializer : KSerializer<ImplementationGuide> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImplementationGuide") {
      ImplementationGuideSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide) {
    encoder.encodeStructure(descriptor) {
      ImplementationGuideSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide =
    decoder.decodeStructure(descriptor) {
      ImplementationGuideSerializer.deserializeJson(this, descriptor, 0)
    }
}
