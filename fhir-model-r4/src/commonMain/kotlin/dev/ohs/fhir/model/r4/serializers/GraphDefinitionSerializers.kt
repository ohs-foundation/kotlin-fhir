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
import dev.ohs.fhir.model.r4.GraphDefinition
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.CompartmentType
import dev.ohs.fhir.model.r4.terminologies.GraphCompartmentRule
import dev.ohs.fhir.model.r4.terminologies.GraphCompartmentUse
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
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

internal object GraphDefinitionLinkSerializer : FhirSerializer<GraphDefinition.Link> {
  override val descriptor: SerialDescriptor = buildDescriptor("Link", this)

  @JvmField
  internal val listSerializer: KSerializer<List<GraphDefinition.Link>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("path")
    b.strPrim("sliceName")
    b.intPrim("min")
    b.strPrim("max")
    b.strPrim("description")
    b.optionalElement("target", GraphDefinitionLinkTargetSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var sliceName: KotlinString? = null
    var _sliceName: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var target: List<GraphDefinition.Link.Target>? = null
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
        3 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> sliceName = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _sliceName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> min = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _min =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> max = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _max =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              GraphDefinitionLinkTargetSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return GraphDefinition.Link(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      path = R4String.of(path, _path),
      sliceName = R4String.of(sliceName, _sliceName),
      min = Integer.of(min, _min),
      max = R4String.of(max, _max),
      description = R4String.of(description, _description),
      target = listOrEmpty(target),
    )
  }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.path?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.path)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.sliceName?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.sliceName)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.min?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.min)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.max?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.max)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      GraphDefinitionLinkTargetSerializer.listSerializer,
      value.target,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object GraphDefinitionLinkTargetSerializer : FhirSerializer<GraphDefinition.Link.Target> {
  override val descriptor: SerialDescriptor = buildDescriptor("Target", this)

  @JvmField
  internal val listSerializer: KSerializer<List<GraphDefinition.Link.Target>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("params")
    b.strPrim("profile")
    b.optionalElement(
      "compartment",
      GraphDefinitionLinkTargetCompartmentSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "link",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.GraphDefinitionLinkSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link.Target {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: ResourceType? = null
    var _type: Element? = null
    var params: KotlinString? = null
    var _params: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    var compartment: List<GraphDefinition.Link.Target.Compartment>? = null
    var link: List<GraphDefinition.Link>? = null
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
        3 -> type = ResourceType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> params = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _params =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> profile = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          compartment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              GraphDefinitionLinkTargetCompartmentSerializer.listSerializer,
              null,
            )
        10 ->
          link =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              GraphDefinitionLinkSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return GraphDefinition.Link.Target(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(Enumeration.of(type, _type), "GraphDefinition.Link.Target", "type"),
      params = R4String.of(params, _params),
      profile = Canonical.of(profile, _profile),
      compartment = listOrEmpty(compartment),
      link = listOrEmpty(link),
    )
  }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.params?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.params)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.profile?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.profile)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      GraphDefinitionLinkTargetCompartmentSerializer.listSerializer,
      value.compartment,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      GraphDefinitionLinkSerializer.listSerializer,
      value.link,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object GraphDefinitionLinkTargetCompartmentSerializer :
  FhirSerializer<GraphDefinition.Link.Target.Compartment> {
  override val descriptor: SerialDescriptor = buildDescriptor("Compartment", this)

  @JvmField
  internal val listSerializer: KSerializer<List<GraphDefinition.Link.Target.Compartment>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("use")
    b.strPrim("code")
    b.strPrim("rule")
    b.strPrim("expression")
    b.strPrim("description")
  }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link.Target.Compartment {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var use: GraphCompartmentUse? = null
    var _use: Element? = null
    var code: CompartmentType? = null
    var _code: Element? = null
    var rule: GraphCompartmentRule? = null
    var _rule: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
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
        3 -> use = GraphCompartmentUse.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> code = CompartmentType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          rule = GraphCompartmentRule.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _rule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> expression = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _description =
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
    return GraphDefinition.Link.Target.Compartment(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      use = required(Enumeration.of(use, _use), "GraphDefinition.Link.Target.Compartment", "use"),
      code =
        required(Enumeration.of(code, _code), "GraphDefinition.Link.Target.Compartment", "code"),
      rule =
        required(Enumeration.of(rule, _rule), "GraphDefinition.Link.Target.Compartment", "rule"),
      expression = R4String.of(expression, _expression),
      description = R4String.of(description, _description),
    )
  }

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target.Compartment) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.use.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.use)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.code.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.rule.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.rule)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.expression?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.expression)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.description)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object GraphDefinitionSerializer : FhirResourceSerializer<GraphDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("GraphDefinition")

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
    b.strPrim("status")
    b.boolPrim("experimental")
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("start")
    b.strPrim("profile")
    b.optionalElement("link", GraphDefinitionLinkSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): GraphDefinition {
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
    var start: ResourceType? = null
    var _start: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    var link: List<GraphDefinition.Link>? = null
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
        16 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        17 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        19 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        21 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        25 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        28 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        29 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 -> start = ResourceType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        32 ->
          _start =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> profile = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          link =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              GraphDefinitionLinkSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return GraphDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = Uri.of(url, _url),
      version = R4String.of(version, _version),
      name = required(R4String.of(name, _name), "GraphDefinition", "name"),
      status = required(Enumeration.of(status, _status), "GraphDefinition", "status"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      start = required(Enumeration.of(start, _start), "GraphDefinition", "start"),
      profile = Canonical.of(profile, _profile),
      link = listOrEmpty(link),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: GraphDefinition,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      28 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.start.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.start)
    compositeEncoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.profile?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.profile)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      35 + descriptorOffset,
      GraphDefinitionLinkSerializer.listSerializer,
      value.link,
    )
  }
}
