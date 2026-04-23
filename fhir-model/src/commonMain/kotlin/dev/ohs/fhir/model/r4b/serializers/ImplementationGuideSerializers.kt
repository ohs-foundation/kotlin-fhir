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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.ImplementationGuide
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.FHIRVersion
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> uri = decoder.decodeStringElement(__desc, 3)
        4 -> _uri = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.uriSer, null)
        5 -> packageId = decoder.decodeStringElement(__desc, 5)
        6 -> _packageId = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.uriSer, null)
        7 -> version = decoder.decodeStringElement(__desc, 7)
        8 -> _version = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.uriSer, null)
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
      version = R4bString.of(version, _version),
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> profile = decoder.decodeStringElement(__desc, 5)
        6 -> _profile = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          grouping = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.groupingSer, null)
        4 ->
          resource = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.resourceSer, null)
        5 -> page = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.pageSer, null)
        6 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.parameterSer, null)
        7 ->
          template = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.templateSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Grouping: " + __i)
      }
    }
    return ImplementationGuide.Definition.Grouping(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name)!!,
      description = R4bString.of(description, _description),
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
      element("exampleBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exampleBoolean", Element.serializer().descriptor, isOptional = true)
      element("exampleCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_exampleCanonical", Element.serializer().descriptor, isOptional = true)
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
    var exampleBoolean: KotlinBoolean? = null
    var _exampleBoolean: Element? = null
    var exampleCanonical: KotlinString? = null
    var _exampleCanonical: Element? = null
    var groupingId: KotlinString? = null
    var _groupingId: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.referenceSer, null)
        4 ->
          fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.fhirVersionSer, null)
        5 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.fhirVersionSer2, null)
        6 -> name = decoder.decodeStringElement(__desc, 6)
        7 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.fhirVersionSerInner2, null)
        8 -> description = decoder.decodeStringElement(__desc, 8)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.fhirVersionSerInner2, null)
        10 -> exampleBoolean = decoder.decodeBooleanElement(__desc, 10)
        11 ->
          _exampleBoolean =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        12 -> exampleCanonical = decoder.decodeStringElement(__desc, 12)
        13 ->
          _exampleCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        14 -> groupingId = decoder.decodeStringElement(__desc, 14)
        15 ->
          _groupingId =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
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
      name = R4bString.of(name, _name),
      description = R4bString.of(description, _description),
      example =
        ImplementationGuide.Definition.Resource.Example.from(
          R4bBoolean.of(exampleBoolean, _exampleBoolean),
          Canonical.of(exampleCanonical, _exampleCanonical),
        ),
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
    when (val __d = value.example) {
      null -> {}
      is ImplementationGuide.Definition.Resource.Example.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.fhirVersionSerInner2, it)
        }
      }
      is ImplementationGuide.Definition.Resource.Example.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.fhirVersionSerInner2, it)
        }
      }
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
      element("nameUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_nameUrl", Element.serializer().descriptor, isOptional = true)
      element("nameReference", Reference.serializer().descriptor, isOptional = true)
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
    var nameUrl: KotlinString? = null
    var _nameUrl: Element? = null
    var nameReference: Reference? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var generation: KotlinString? = null
    var _generation: Element? = null
    var page: List<ImplementationGuide.Definition.Page>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> nameUrl = decoder.decodeStringElement(__desc, 3)
        4 ->
          _nameUrl = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameUrlSer, null)
        5 ->
          nameReference =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.nameReferenceSer, null)
        6 -> title = decoder.decodeStringElement(__desc, 6)
        7 -> _title = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.nameUrlSer, null)
        8 -> generation = decoder.decodeStringElement(__desc, 8)
        9 ->
          _generation =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.nameUrlSer, null)
        10 -> page = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.pageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Page: " + __i)
      }
    }
    return ImplementationGuide.Definition.Page(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        ImplementationGuide.Definition.Page.Name.from(Url.of(nameUrl, _nameUrl), nameReference)!!,
      title = R4bString.of(title, _title)!!,
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
    when (val __d = value.name) {
      null -> {}
      is ImplementationGuide.Definition.Page.Name.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.nameUrlSer, it)
        }
      }
      is ImplementationGuide.Definition.Page.Name.Reference -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.nameReferenceSer, __d.value)
      }
    }
    ((value.title.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.nameUrlSer, it)
    }
    ((value.generation.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.generation.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.nameUrlSer, it)
    }
    if (value.page.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.pageSer, value.page)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameUrlSer: KSerializer<Element> = Element.serializer()

    public val nameReferenceSer: KSerializer<Reference> = Reference.serializer()

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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
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
    var code: KotlinString? = null
    var _code: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
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
        5 -> `value` = decoder.decodeStringElement(__desc, 5)
        6 -> _value = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return ImplementationGuide.Definition.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Enumeration.of(ImplementationGuide.GuideParameterCode.fromCode(code!!), _code),
      `value` = R4bString.of(`value`, _value)!!,
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
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> source = decoder.decodeStringElement(__desc, 5)
        6 -> _source = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 -> scope = decoder.decodeStringElement(__desc, 7)
        8 -> _scope = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Template: " + __i)
      }
    }
    return ImplementationGuide.Definition.Template(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      source = R4bString.of(source, _source)!!,
      scope = R4bString.of(scope, _scope),
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> rendering = decoder.decodeStringElement(__desc, 3)
        4 ->
          _rendering =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.renderingSer, null)
        5 ->
          resource = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.resourceSer, null)
        6 -> page = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.pageSer, null)
        7 -> image = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.imageSer, null)
        8 -> _image = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.imageSer2, null)
        9 -> other = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.imageSer, null)
        10 ->
          _other = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.imageSer2, null)
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
          R4bString.of(image?.getOrNull(__i)?.let { it }, _image?.getOrNull(__i))!!
        }),
      other =
        (kotlin.collections.List(maxOf(other?.size ?: 0, _other?.size ?: 0)) { __i ->
          R4bString.of(other?.getOrNull(__i)?.let { it }, _other?.getOrNull(__i))!!
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
      element("exampleBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exampleBoolean", Element.serializer().descriptor, isOptional = true)
      element("exampleCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_exampleCanonical", Element.serializer().descriptor, isOptional = true)
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
    var exampleBoolean: KotlinBoolean? = null
    var _exampleBoolean: Element? = null
    var exampleCanonical: KotlinString? = null
    var _exampleCanonical: Element? = null
    var relativePath: KotlinString? = null
    var _relativePath: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.referenceSer, null)
        4 -> exampleBoolean = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _exampleBoolean =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.exampleBooleanSer, null)
        6 -> exampleCanonical = decoder.decodeStringElement(__desc, 6)
        7 ->
          _exampleCanonical =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.exampleBooleanSer, null)
        8 -> relativePath = decoder.decodeStringElement(__desc, 8)
        9 ->
          _relativePath =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.exampleBooleanSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + __i)
      }
    }
    return ImplementationGuide.Manifest.Resource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference!!,
      example =
        ImplementationGuide.Manifest.Resource.Example.from(
          R4bBoolean.of(exampleBoolean, _exampleBoolean),
          Canonical.of(exampleCanonical, _exampleCanonical),
        ),
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
    when (val __d = value.example) {
      null -> {}
      is ImplementationGuide.Manifest.Resource.Example.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.exampleBooleanSer, it)
        }
      }
      is ImplementationGuide.Manifest.Resource.Example.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.exampleBooleanSer, it)
        }
      }
    }
    ((value.relativePath?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.relativePath?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.exampleBooleanSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSer: KSerializer<Reference> = Reference.serializer()

    public val exampleBooleanSer: KSerializer<Element> = Element.serializer()
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> title = decoder.decodeStringElement(__desc, 5)
        6 -> _title = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> anchor = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.anchorSer, null)
        8 ->
          _anchor = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.anchorSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Page: " + __i)
      }
    }
    return ImplementationGuide.Manifest.Page(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name)!!,
      title = R4bString.of(title, _title),
      anchor =
        (kotlin.collections.List(maxOf(anchor?.size ?: 0, _anchor?.size ?: 0)) { __i ->
          R4bString.of(anchor?.getOrNull(__i)?.let { it }, _anchor?.getOrNull(__i))!!
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

internal object ImplementationGuideDefinitionResourceExampleSerializer :
  KSerializer<ImplementationGuide.Definition.Resource.Example> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImplementationGuide.Definition.Resource.Example") {
      element("exampleBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exampleBoolean", Element.serializer().descriptor, isOptional = true)
      element("exampleCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_exampleCanonical", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: ImplementationGuide.Definition.Resource.Example,
  ) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ImplementationGuide.Definition.Resource.Example.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ImplementationGuide.Definition.Resource.Example.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Resource.Example =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): ImplementationGuide.Definition.Resource.Example {
    val __desc = descriptor
    var exampleBoolean: KotlinBoolean? = null
    var _exampleBoolean: Element? = null
    var exampleCanonical: KotlinString? = null
    var _exampleCanonical: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> exampleBoolean = decoder.decodeBooleanElement(__desc, 0)
        1 ->
          _exampleBoolean =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> exampleCanonical = decoder.decodeStringElement(__desc, 2)
        3 ->
          _exampleCanonical =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ImplementationGuide.Definition.Resource.Example: " + __i
          )
      }
    }
    return ImplementationGuide.Definition.Resource.Example.from(
      R4bBoolean.of(exampleBoolean, _exampleBoolean),
      Canonical.of(exampleCanonical, _exampleCanonical),
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ImplementationGuideDefinitionPageNameSerializer :
  KSerializer<ImplementationGuide.Definition.Page.Name> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImplementationGuide.Definition.Page.Name") {
      element("nameUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_nameUrl", Element.serializer().descriptor, isOptional = true)
      element("nameReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Page.Name) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ImplementationGuide.Definition.Page.Name.Url -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ImplementationGuide.Definition.Page.Name.Reference -> {
          encodeSerializableElement(__desc, 2, Hoisted.nameReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Page.Name =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): ImplementationGuide.Definition.Page.Name {
    val __desc = descriptor
    var nameUrl: KotlinString? = null
    var _nameUrl: Element? = null
    var nameReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> nameUrl = decoder.decodeStringElement(__desc, 0)
        1 ->
          _nameUrl = decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          nameReference =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.nameReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ImplementationGuide.Definition.Page.Name: " + __i
          )
      }
    }
    return ImplementationGuide.Definition.Page.Name.from(Url.of(nameUrl, _nameUrl), nameReference)!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val nameReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ImplementationGuideManifestResourceExampleSerializer :
  KSerializer<ImplementationGuide.Manifest.Resource.Example> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImplementationGuide.Manifest.Resource.Example") {
      element("exampleBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exampleBoolean", Element.serializer().descriptor, isOptional = true)
      element("exampleCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_exampleCanonical", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest.Resource.Example) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ImplementationGuide.Manifest.Resource.Example.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ImplementationGuide.Manifest.Resource.Example.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest.Resource.Example =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): ImplementationGuide.Manifest.Resource.Example {
    val __desc = descriptor
    var exampleBoolean: KotlinBoolean? = null
    var _exampleBoolean: Element? = null
    var exampleCanonical: KotlinString? = null
    var _exampleCanonical: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> exampleBoolean = decoder.decodeBooleanElement(__desc, 0)
        1 ->
          _exampleBoolean =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> exampleCanonical = decoder.decodeStringElement(__desc, 2)
        3 ->
          _exampleCanonical =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ImplementationGuide.Manifest.Resource.Example: " + __i
          )
      }
    }
    return ImplementationGuide.Manifest.Resource.Example.from(
      R4bBoolean.of(exampleBoolean, _exampleBoolean),
      Canonical.of(exampleCanonical, _exampleCanonical),
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ImplementationGuideSerializer : KSerializer<ImplementationGuide> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImplementationGuide") {
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
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element("packageId", KotlinString.serializer().descriptor, isOptional = true)
      element("_packageId", Element.serializer().descriptor, isOptional = true)
      element("license", KotlinString.serializer().descriptor, isOptional = true)
      element("_license", Element.serializer().descriptor, isOptional = true)
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
      element(
        "dependsOn",
        listSerialDescriptor(
          lazyDescriptor { ImplementationGuide.DependsOn.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "global",
        listSerialDescriptor(lazyDescriptor { ImplementationGuide.Global.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "definition",
        lazyDescriptor { ImplementationGuide.Definition.serializer().descriptor },
        isOptional = true,
      )
      element(
        "manifest",
        lazyDescriptor { ImplementationGuide.Manifest.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ImplementationGuide =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ImplementationGuide {
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
    var copyright: KotlinString? = null
    var _copyright: Element? = null
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
        15 -> name = decoder.decodeStringElement(__desc, 15)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(__desc, 17)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 -> status = decoder.decodeStringElement(__desc, 19)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> experimental = decoder.decodeBooleanElement(__desc, 21)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> date = decoder.decodeStringElement(__desc, 23)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> publisher = decoder.decodeStringElement(__desc, 25)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.contactSer, null)
        28 -> description = decoder.decodeStringElement(__desc, 28)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.useContextSer, null)
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.jurisdictionSer, null)
        32 -> copyright = decoder.decodeStringElement(__desc, 32)
        33 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 -> packageId = decoder.decodeStringElement(__desc, 34)
        35 ->
          _packageId =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> license = decoder.decodeStringElement(__desc, 36)
        37 ->
          _license =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 ->
          fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.fhirVersionSer, null)
        39 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.fhirVersionSer2, null)
        40 ->
          dependsOn =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.dependsOnSer, null)
        41 ->
          global = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.globalSer, null)
        42 ->
          definition =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.definitionSer, null)
        43 ->
          manifest =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.manifestSer, null)
        CompositeDecoder.DECODE_DONE -> break
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
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name)!!,
      title = R4bString.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      copyright = Markdown.of(copyright, _copyright),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImplementationGuide) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ImplementationGuide")
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
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 21, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    ((value.packageId.value))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.packageId.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    ((value.license?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.license?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    (value.fhirVersion.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.fhirVersionSer, it)
    }
    (value.fhirVersion.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.fhirVersionSer2, it)
    }
    if (value.dependsOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.dependsOnSer, value.dependsOn)
    if (value.global.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.globalSer, value.global)
    (value.definition)?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.definitionSer, it)
    }
    (value.manifest)?.let { encoder.encodeSerializableElement(__desc, 43, Hoisted.manifestSer, it) }
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
