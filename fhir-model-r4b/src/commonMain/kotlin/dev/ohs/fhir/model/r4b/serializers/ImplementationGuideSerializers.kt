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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.DependsOn) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImplementationGuide.DependsOn {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> uri = decoder.decodeStringElement(descriptor, i)
        4 -> _uri = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uriSer, null)
        5 -> packageId = decoder.decodeStringElement(descriptor, i)
        6 ->
          _packageId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uriSer, null)
        7 -> version = decoder.decodeStringElement(descriptor, i)
        8 ->
          _version = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.uriSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DependsOn: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ImplementationGuide.DependsOn) {
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
    ((value.uri.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.uri.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.uriSer, it)
    }
    ((value.packageId?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.packageId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.uriSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.uriSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Global) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImplementationGuide.Global {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> profile = decoder.decodeStringElement(descriptor, i)
        6 ->
          _profile = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Global: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ImplementationGuide.Global) {
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
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    ((value.profile.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.profile.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImplementationGuide.Definition {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var grouping: List<ImplementationGuide.Definition.Grouping>? = null
    var resource: List<ImplementationGuide.Definition.Resource>? = null
    var page: ImplementationGuide.Definition.Page? = null
    var parameter: List<ImplementationGuide.Definition.Parameter>? = null
    var template: List<ImplementationGuide.Definition.Template>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          grouping =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.groupingSer, null)
        4 ->
          resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        5 -> page = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pageSer, null)
        6 ->
          parameter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parameterSer, null)
        7 ->
          template =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.templateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Definition: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition,
  ) {
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
    if (value.grouping.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.groupingSer, value.grouping)
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.resourceSer, value.resource)
    (value.page)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.pageSer, it) }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.parameterSer, value.parameter)
    if (value.template.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.templateSer, value.template)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Grouping) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ImplementationGuide.Definition.Grouping {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Grouping: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Grouping,
  ) {
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Resource) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ImplementationGuide.Definition.Resource {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        4 ->
          fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fhirVersionSer, null)
        5 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fhirVersionSer2, null)
        6 -> name = decoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        8 -> description = decoder.decodeStringElement(descriptor, i)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        10 -> exampleBoolean = decoder.decodeBooleanElement(descriptor, i)
        11 ->
          _exampleBoolean =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        12 -> exampleCanonical = decoder.decodeStringElement(descriptor, i)
        13 ->
          _exampleCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        14 -> groupingId = decoder.decodeStringElement(descriptor, i)
        15 ->
          _groupingId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.fhirVersionSerInner2,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + i)
      }
    }
    return ImplementationGuide.Definition.Resource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference!!,
      fhirVersion =
        (kotlin.collections.List(maxOf(fhirVersion?.size ?: 0, _fhirVersion?.size ?: 0)) { index ->
          Enumeration.of(
            FHIRVersion.fromCode(fhirVersion?.getOrNull(index)!!),
            _fhirVersion?.getOrNull(index),
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Resource,
  ) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.referenceSer, value.reference)
    (value.fhirVersion.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.fhirVersionSer, it)
    }
    (value.fhirVersion.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.fhirVersionSer2, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.fhirVersionSerInner2, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.fhirVersionSerInner2, it)
    }
    when (val choice = value.example) {
      null -> {}
      is ImplementationGuide.Definition.Resource.Example.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.fhirVersionSerInner2, it)
        }
      }
      is ImplementationGuide.Definition.Resource.Example.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.fhirVersionSerInner2, it)
        }
      }
    }
    ((value.groupingId?.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
    (value.groupingId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.fhirVersionSerInner2, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Page) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImplementationGuide.Definition.Page {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> nameUrl = decoder.decodeStringElement(descriptor, i)
        4 ->
          _nameUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameUrlSer, null)
        5 ->
          nameReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameReferenceSer, null)
        6 -> title = decoder.decodeStringElement(descriptor, i)
        7 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameUrlSer, null)
        8 -> generation = decoder.decodeStringElement(descriptor, i)
        9 ->
          _generation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameUrlSer, null)
        10 -> page = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Page: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Page,
  ) {
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
    when (val choice = value.name) {
      is ImplementationGuide.Definition.Page.Name.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameUrlSer, it)
        }
      }
      is ImplementationGuide.Definition.Page.Name.Reference -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.nameReferenceSer, choice.value)
      }
    }
    ((value.title.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.nameUrlSer, it)
    }
    ((value.generation.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.generation.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.nameUrlSer, it)
    }
    if (value.page.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.pageSer, value.page)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Parameter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ImplementationGuide.Definition.Parameter {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> `value` = decoder.decodeStringElement(descriptor, i)
        6 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Parameter,
  ) {
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
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Template) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ImplementationGuide.Definition.Template {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> source = decoder.decodeStringElement(descriptor, i)
        6 ->
          _source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 -> scope = decoder.decodeStringElement(descriptor, i)
        8 ->
          _scope = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Template: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Definition.Template,
  ) {
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
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.source.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.source.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
    ((value.scope?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.scope?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.codeSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImplementationGuide.Manifest {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> rendering = decoder.decodeStringElement(descriptor, i)
        4 ->
          _rendering =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.renderingSer, null)
        5 ->
          resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        6 -> page = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pageSer, null)
        7 ->
          image = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.imageSer, null)
        8 ->
          _image = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.imageSer2, null)
        9 ->
          other = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.imageSer, null)
        10 ->
          _other = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.imageSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Manifest: " + i)
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
        (kotlin.collections.List(maxOf(image?.size ?: 0, _image?.size ?: 0)) { index ->
          R4bString.of(image?.getOrNull(index)?.let { it }, _image?.getOrNull(index))!!
        }),
      other =
        (kotlin.collections.List(maxOf(other?.size ?: 0, _other?.size ?: 0)) { index ->
          R4bString.of(other?.getOrNull(index)?.let { it }, _other?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ImplementationGuide.Manifest) {
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
    ((value.rendering?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.rendering?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.renderingSer, it)
    }
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.resourceSer, value.resource)
    if (value.page.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.pageSer, value.page)
    (value.image.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.imageSer, it)
    }
    (value.image.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.imageSer2, it)
    }
    (value.other.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.imageSer, it)
    }
    (value.other.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.imageSer2, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest.Resource) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ImplementationGuide.Manifest.Resource {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        4 -> exampleBoolean = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _exampleBoolean =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.exampleBooleanSer,
              null,
            )
        6 -> exampleCanonical = decoder.decodeStringElement(descriptor, i)
        7 ->
          _exampleCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.exampleBooleanSer,
              null,
            )
        8 -> relativePath = decoder.decodeStringElement(descriptor, i)
        9 ->
          _relativePath =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.exampleBooleanSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Manifest.Resource,
  ) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.referenceSer, value.reference)
    when (val choice = value.example) {
      null -> {}
      is ImplementationGuide.Manifest.Resource.Example.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.exampleBooleanSer, it)
        }
      }
      is ImplementationGuide.Manifest.Resource.Example.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.exampleBooleanSer, it)
        }
      }
    }
    ((value.relativePath?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.relativePath?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.exampleBooleanSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest.Page) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ImplementationGuide.Manifest.Page {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> title = decoder.decodeStringElement(descriptor, i)
        6 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 ->
          anchor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.anchorSer, null)
        8 ->
          _anchor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.anchorSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Page: " + i)
      }
    }
    return ImplementationGuide.Manifest.Page(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name)!!,
      title = R4bString.of(title, _title),
      anchor =
        (kotlin.collections.List(maxOf(anchor?.size ?: 0, _anchor?.size ?: 0)) { index ->
          R4bString.of(anchor?.getOrNull(index)?.let { it }, _anchor?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ImplementationGuide.Manifest.Page,
  ) {
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
    (value.anchor.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.anchorSer, it)
    }
    (value.anchor.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.anchorSer2, it)
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
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
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
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ImplementationGuide")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ImplementationGuide {
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
        16 -> title = decoder.decodeStringElement(descriptor, i)
        17 ->
          _title =
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
        31 -> copyright = decoder.decodeStringElement(descriptor, i)
        32 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 -> packageId = decoder.decodeStringElement(descriptor, i)
        34 ->
          _packageId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> license = decoder.decodeStringElement(descriptor, i)
        36 ->
          _license =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 ->
          fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fhirVersionSer, null)
        38 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fhirVersionSer2, null)
        39 ->
          dependsOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dependsOnSer, null)
        40 ->
          global = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.globalSer, null)
        41 ->
          definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.definitionSer, null)
        42 ->
          manifest =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.manifestSer, null)
        else -> throw SerializationException("Unexpected index decoding ImplementationGuide: " + i)
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
        (kotlin.collections.List(maxOf(fhirVersion?.size ?: 0, _fhirVersion?.size ?: 0)) { index ->
          Enumeration.of(
            FHIRVersion.fromCode(fhirVersion?.getOrNull(index)!!),
            _fhirVersion?.getOrNull(index),
          )
        }),
      dependsOn = dependsOn ?: listOf(),
      global = global ?: listOf(),
      definition = definition,
      manifest = manifest,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImplementationGuide,
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
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
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
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
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
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.packageId.value))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.packageId.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.license?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.license?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.fhirVersion.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.fhirVersionSer,
        it,
      )
    }
    (value.fhirVersion.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.fhirVersionSer2,
        it,
      )
    }
    if (value.dependsOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.dependsOnSer,
        value.dependsOn,
      )
    if (value.global.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.globalSer,
        value.global,
      )
    (value.definition)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.definitionSer,
        it,
      )
    }
    (value.manifest)?.let {
      encoder.encodeSerializableElement(descriptor, 42 + descriptorOffset, Hoisted.manifestSer, it)
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
      ImplementationGuideSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide =
    decoder.decodeStructure(descriptor) {
      ImplementationGuideSerializer.deserializeInternal(this, descriptor, 0)
    }
}
