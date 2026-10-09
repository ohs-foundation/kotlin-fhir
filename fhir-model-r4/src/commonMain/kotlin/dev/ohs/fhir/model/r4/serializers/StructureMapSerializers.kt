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

import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.Age
import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Base64Binary
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Contributor
import dev.ohs.fhir.model.r4.Count
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Distance
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Oid
import dev.ohs.fhir.model.r4.ParameterDefinition
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.SampledData
import dev.ohs.fhir.model.r4.Signature
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.StructureMap
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.TriggerDefinition
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.Uuid
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.StructureMapContextType
import dev.ohs.fhir.model.r4.terminologies.StructureMapGroupTypeMode
import dev.ohs.fhir.model.r4.terminologies.StructureMapInputMode
import dev.ohs.fhir.model.r4.terminologies.StructureMapModelMode
import dev.ohs.fhir.model.r4.terminologies.StructureMapSourceListMode
import dev.ohs.fhir.model.r4.terminologies.StructureMapTargetListMode
import dev.ohs.fhir.model.r4.terminologies.StructureMapTransform
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.datetime.LocalTime
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

internal object StructureMapStructureSerializer : FhirSerializer<StructureMap.Structure> {
  override val descriptor: SerialDescriptor = buildDescriptor("Structure", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Structure>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("url")
    b.strPrim("mode")
    b.strPrim("alias")
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Structure {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var mode: StructureMapModelMode? = null
    var _mode: Element? = null
    var alias: KotlinString? = null
    var _alias: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          mode = StructureMapModelMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _mode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> alias = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _alias =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
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
    return StructureMap.Structure(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = required(Canonical.of(url, _url), "StructureMap.Structure", "url"),
      mode = required(Enumeration.of(mode, _mode), "StructureMap.Structure", "mode"),
      alias = R4String.of(alias, _alias),
      documentation = R4String.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Structure) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.url.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.url)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.mode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.mode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.alias?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.alias)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupSerializer : FhirSerializer<StructureMap.Group> {
  override val descriptor: SerialDescriptor = buildDescriptor("Group", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("extends")
    b.strPrim("typeMode")
    b.strPrim("documentation")
    b.optionalElement("input", StructureMapGroupInputSerializer.listSerializer.descriptor)
    b.optionalElement("rule", StructureMapGroupRuleSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var extends: KotlinString? = null
    var _extends: Element? = null
    var typeMode: StructureMapGroupTypeMode? = null
    var _typeMode: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var input: List<StructureMap.Group.Input>? = null
    var rule: List<StructureMap.Group.Rule>? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> extends = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _extends =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          typeMode =
            StructureMapGroupTypeMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _typeMode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          input =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupInputSerializer.listSerializer,
              null,
            )
        12 ->
          rule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(Id.of(name, _name), "StructureMap.Group", "name"),
      extends = Id.of(extends, _extends),
      typeMode = required(Enumeration.of(typeMode, _typeMode), "StructureMap.Group", "typeMode"),
      documentation = R4String.of(documentation, _documentation),
      input = listOrEmpty(input),
      rule = listOrEmpty(rule),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.extends?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.extends)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.typeMode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.typeMode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      StructureMapGroupInputSerializer.listSerializer,
      value.input,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      StructureMapGroupRuleSerializer.listSerializer,
      value.rule,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupInputSerializer : FhirSerializer<StructureMap.Group.Input> {
  override val descriptor: SerialDescriptor = buildDescriptor("Input", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Input>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("type")
    b.strPrim("mode")
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Input {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var mode: StructureMapInputMode? = null
    var _mode: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          mode = StructureMapInputMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _mode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
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
    return StructureMap.Group.Input(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(Id.of(name, _name), "StructureMap.Group.Input", "name"),
      type = R4String.of(type, _type),
      mode = required(Enumeration.of(mode, _mode), "StructureMap.Group.Input", "mode"),
      documentation = R4String.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Input) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.type?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.mode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.mode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleSerializer : FhirSerializer<StructureMap.Group.Rule> {
  override val descriptor: SerialDescriptor = buildDescriptor("Rule", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.optionalElement("source", StructureMapGroupRuleSourceSerializer.listSerializer.descriptor)
    b.optionalElement("target", StructureMapGroupRuleTargetSerializer.listSerializer.descriptor)
    b.optionalElement(
      "rule",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.StructureMapGroupRuleSerializer)),
    )
    b.optionalElement(
      "dependent",
      StructureMapGroupRuleDependentSerializer.listSerializer.descriptor,
    )
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var source: List<StructureMap.Group.Rule.Source>? = null
    var target: List<StructureMap.Group.Rule.Target>? = null
    var rule: List<StructureMap.Group.Rule>? = null
    var dependent: List<StructureMap.Group.Rule.Dependent>? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleSourceSerializer.listSerializer,
              null,
            )
        6 ->
          target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleTargetSerializer.listSerializer,
              null,
            )
        7 ->
          rule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleSerializer.listSerializer,
              null,
            )
        8 ->
          dependent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleDependentSerializer.listSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
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
    return StructureMap.Group.Rule(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(Id.of(name, _name), "StructureMap.Group.Rule", "name"),
      source = listOrEmpty(source),
      target = listOrEmpty(target),
      rule = listOrEmpty(rule),
      dependent = listOrEmpty(dependent),
      documentation = R4String.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      StructureMapGroupRuleSourceSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      StructureMapGroupRuleTargetSerializer.listSerializer,
      value.target,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      StructureMapGroupRuleSerializer.listSerializer,
      value.rule,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      StructureMapGroupRuleDependentSerializer.listSerializer,
      value.dependent,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleSourceSerializer :
  FhirSerializer<StructureMap.Group.Rule.Source> {
  override val descriptor: SerialDescriptor = buildDescriptor("Source", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Source>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("context")
    b.intPrim("min")
    b.strPrim("max")
    b.strPrim("type")
    b.strPrim("defaultValueBase64Binary")
    b.boolPrim("defaultValueBoolean")
    b.strPrim("defaultValueCanonical")
    b.strPrim("defaultValueCode")
    b.strPrim("defaultValueDate")
    b.strPrim("defaultValueDateTime")
    b.prim("defaultValueDecimal", FhirDecimalSerializer.descriptor)
    b.strPrim("defaultValueId")
    b.strPrim("defaultValueInstant")
    b.intPrim("defaultValueInteger")
    b.strPrim("defaultValueMarkdown")
    b.strPrim("defaultValueOid")
    b.intPrim("defaultValuePositiveInt")
    b.strPrim("defaultValueString")
    b.prim("defaultValueTime", LocalTimeSerializer.descriptor)
    b.intPrim("defaultValueUnsignedInt")
    b.strPrim("defaultValueUri")
    b.strPrim("defaultValueUrl")
    b.strPrim("defaultValueUuid")
    b.optionalElement("defaultValueAddress", AddressSerializer.descriptor)
    b.optionalElement("defaultValueAge", AgeSerializer.descriptor)
    b.optionalElement("defaultValueAnnotation", AnnotationSerializer.descriptor)
    b.optionalElement("defaultValueAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("defaultValueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("defaultValueCoding", CodingSerializer.descriptor)
    b.optionalElement("defaultValueContactPoint", ContactPointSerializer.descriptor)
    b.optionalElement("defaultValueCount", CountSerializer.descriptor)
    b.optionalElement("defaultValueDistance", DistanceSerializer.descriptor)
    b.optionalElement("defaultValueDuration", DurationSerializer.descriptor)
    b.optionalElement("defaultValueHumanName", HumanNameSerializer.descriptor)
    b.optionalElement("defaultValueIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("defaultValueMoney", MoneySerializer.descriptor)
    b.optionalElement("defaultValuePeriod", PeriodSerializer.descriptor)
    b.optionalElement("defaultValueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("defaultValueRange", RangeSerializer.descriptor)
    b.optionalElement("defaultValueRatio", RatioSerializer.descriptor)
    b.optionalElement("defaultValueReference", ReferenceSerializer.descriptor)
    b.optionalElement("defaultValueSampledData", SampledDataSerializer.descriptor)
    b.optionalElement("defaultValueSignature", SignatureSerializer.descriptor)
    b.optionalElement("defaultValueTiming", TimingSerializer.descriptor)
    b.optionalElement("defaultValueContactDetail", ContactDetailSerializer.descriptor)
    b.optionalElement("defaultValueContributor", ContributorSerializer.descriptor)
    b.optionalElement("defaultValueDataRequirement", DataRequirementSerializer.descriptor)
    b.optionalElement("defaultValueExpression", ExpressionSerializer.descriptor)
    b.optionalElement("defaultValueParameterDefinition", ParameterDefinitionSerializer.descriptor)
    b.optionalElement("defaultValueRelatedArtifact", RelatedArtifactSerializer.descriptor)
    b.optionalElement("defaultValueTriggerDefinition", TriggerDefinitionSerializer.descriptor)
    b.optionalElement("defaultValueUsageContext", UsageContextSerializer.descriptor)
    b.optionalElement("defaultValueDosage", DosageSerializer.descriptor)
    b.optionalElement("defaultValueMeta", MetaSerializer.descriptor)
    b.strPrim("element")
    b.strPrim("listMode")
    b.strPrim("variable")
    b.strPrim("condition")
    b.strPrim("check")
    b.strPrim("logMessage")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Source {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var context: KotlinString? = null
    var _context: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var defaultValueBase64Binary: KotlinString? = null
    var _defaultValueBase64Binary: Element? = null
    var defaultValueBoolean: KotlinBoolean? = null
    var _defaultValueBoolean: Element? = null
    var defaultValueCanonical: KotlinString? = null
    var _defaultValueCanonical: Element? = null
    var defaultValueCode: KotlinString? = null
    var _defaultValueCode: Element? = null
    var defaultValueDate: FhirDate? = null
    var _defaultValueDate: Element? = null
    var defaultValueDateTime: FhirDateTime? = null
    var _defaultValueDateTime: Element? = null
    var defaultValueDecimal: FhirDecimal? = null
    var _defaultValueDecimal: Element? = null
    var defaultValueId: KotlinString? = null
    var _defaultValueId: Element? = null
    var defaultValueInstant: FhirDateTime? = null
    var _defaultValueInstant: Element? = null
    var defaultValueInteger: Int? = null
    var _defaultValueInteger: Element? = null
    var defaultValueMarkdown: KotlinString? = null
    var _defaultValueMarkdown: Element? = null
    var defaultValueOid: KotlinString? = null
    var _defaultValueOid: Element? = null
    var defaultValuePositiveInt: Int? = null
    var _defaultValuePositiveInt: Element? = null
    var defaultValueString: KotlinString? = null
    var _defaultValueString: Element? = null
    var defaultValueTime: LocalTime? = null
    var _defaultValueTime: Element? = null
    var defaultValueUnsignedInt: Int? = null
    var _defaultValueUnsignedInt: Element? = null
    var defaultValueUri: KotlinString? = null
    var _defaultValueUri: Element? = null
    var defaultValueUrl: KotlinString? = null
    var _defaultValueUrl: Element? = null
    var defaultValueUuid: KotlinString? = null
    var _defaultValueUuid: Element? = null
    var defaultValueAddress: Address? = null
    var defaultValueAge: Age? = null
    var defaultValueAnnotation: Annotation? = null
    var defaultValueAttachment: Attachment? = null
    var defaultValueCodeableConcept: CodeableConcept? = null
    var defaultValueCoding: Coding? = null
    var defaultValueContactPoint: ContactPoint? = null
    var defaultValueCount: Count? = null
    var defaultValueDistance: Distance? = null
    var defaultValueDuration: Duration? = null
    var defaultValueHumanName: HumanName? = null
    var defaultValueIdentifier: Identifier? = null
    var defaultValueMoney: Money? = null
    var defaultValuePeriod: Period? = null
    var defaultValueQuantity: Quantity? = null
    var defaultValueRange: Range? = null
    var defaultValueRatio: Ratio? = null
    var defaultValueReference: Reference? = null
    var defaultValueSampledData: SampledData? = null
    var defaultValueSignature: Signature? = null
    var defaultValueTiming: Timing? = null
    var defaultValueContactDetail: ContactDetail? = null
    var defaultValueContributor: Contributor? = null
    var defaultValueDataRequirement: DataRequirement? = null
    var defaultValueExpression: Expression? = null
    var defaultValueParameterDefinition: ParameterDefinition? = null
    var defaultValueRelatedArtifact: RelatedArtifact? = null
    var defaultValueTriggerDefinition: TriggerDefinition? = null
    var defaultValueUsageContext: UsageContext? = null
    var defaultValueDosage: Dosage? = null
    var defaultValueMeta: Meta? = null
    var element: KotlinString? = null
    var _element: Element? = null
    var listMode: StructureMapSourceListMode? = null
    var _listMode: Element? = null
    var variable: KotlinString? = null
    var _variable: Element? = null
    var condition: KotlinString? = null
    var _condition: Element? = null
    var check: KotlinString? = null
    var _check: Element? = null
    var logMessage: KotlinString? = null
    var _logMessage: Element? = null
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
        3 -> context = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _context =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> min = compositeDecoder.decodeIntElement(descriptor, i)
        6 ->
          _min =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> max = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _max =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> defaultValueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _defaultValueBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> defaultValueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        14 ->
          _defaultValueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> defaultValueCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _defaultValueCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> defaultValueCode = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _defaultValueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          defaultValueDate =
            FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        20 ->
          _defaultValueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          defaultValueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        22 ->
          _defaultValueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          defaultValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        24 ->
          _defaultValueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> defaultValueId = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _defaultValueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          defaultValueInstant =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        28 ->
          _defaultValueInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 -> defaultValueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        30 ->
          _defaultValueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 -> defaultValueMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _defaultValueMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> defaultValueOid = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _defaultValueOid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 -> defaultValuePositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        36 ->
          _defaultValuePositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> defaultValueString = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _defaultValueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 ->
          defaultValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        40 ->
          _defaultValueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> defaultValueUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        42 ->
          _defaultValueUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> defaultValueUri = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _defaultValueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 -> defaultValueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        46 ->
          _defaultValueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 -> defaultValueUuid = compositeDecoder.decodeStringElement(descriptor, i)
        48 ->
          _defaultValueUuid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        49 ->
          defaultValueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        50 ->
          defaultValueAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        51 ->
          defaultValueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        52 ->
          defaultValueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        53 ->
          defaultValueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        54 ->
          defaultValueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        55 ->
          defaultValueContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        56 ->
          defaultValueCount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
        57 ->
          defaultValueDistance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DistanceSerializer,
              null,
            )
        58 ->
          defaultValueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        59 ->
          defaultValueHumanName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        60 ->
          defaultValueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        61 ->
          defaultValueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        62 ->
          defaultValuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        63 ->
          defaultValueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        64 ->
          defaultValueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        65 ->
          defaultValueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        66 ->
          defaultValueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        67 ->
          defaultValueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        68 ->
          defaultValueSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        69 ->
          defaultValueTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        70 ->
          defaultValueContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer,
              null,
            )
        71 ->
          defaultValueContributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContributorSerializer,
              null,
            )
        72 ->
          defaultValueDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        73 ->
          defaultValueExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        74 ->
          defaultValueParameterDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ParameterDefinitionSerializer,
              null,
            )
        75 ->
          defaultValueRelatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer,
              null,
            )
        76 ->
          defaultValueTriggerDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TriggerDefinitionSerializer,
              null,
            )
        77 ->
          defaultValueUsageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer,
              null,
            )
        78 ->
          defaultValueDosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer,
              null,
            )
        79 ->
          defaultValueMeta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        80 -> element = compositeDecoder.decodeStringElement(descriptor, i)
        81 ->
          _element =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        82 ->
          listMode =
            StructureMapSourceListMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        83 ->
          _listMode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        84 -> variable = compositeDecoder.decodeStringElement(descriptor, i)
        85 ->
          _variable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        86 -> condition = compositeDecoder.decodeStringElement(descriptor, i)
        87 ->
          _condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        88 -> check = compositeDecoder.decodeStringElement(descriptor, i)
        89 ->
          _check =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        90 -> logMessage = compositeDecoder.decodeStringElement(descriptor, i)
        91 ->
          _logMessage =
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
    return StructureMap.Group.Rule.Source(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      context = required(Id.of(context, _context), "StructureMap.Group.Rule.Source", "context"),
      min = Integer.of(min, _min),
      max = R4String.of(max, _max),
      type = R4String.of(type, _type),
      defaultValue =
        StructureMap.Group.Rule.Source.DefaultValue.from(
          Base64Binary.of(defaultValueBase64Binary, _defaultValueBase64Binary),
          R4Boolean.of(defaultValueBoolean, _defaultValueBoolean),
          Canonical.of(defaultValueCanonical, _defaultValueCanonical),
          Code.of(defaultValueCode, _defaultValueCode),
          Date.of(defaultValueDate, _defaultValueDate),
          DateTime.of(defaultValueDateTime, _defaultValueDateTime),
          Decimal.of(defaultValueDecimal, _defaultValueDecimal),
          Id.of(defaultValueId, _defaultValueId),
          Instant.of(defaultValueInstant, _defaultValueInstant),
          Integer.of(defaultValueInteger, _defaultValueInteger),
          Markdown.of(defaultValueMarkdown, _defaultValueMarkdown),
          Oid.of(defaultValueOid, _defaultValueOid),
          PositiveInt.of(defaultValuePositiveInt, _defaultValuePositiveInt),
          R4String.of(defaultValueString, _defaultValueString),
          Time.of(defaultValueTime, _defaultValueTime),
          UnsignedInt.of(defaultValueUnsignedInt, _defaultValueUnsignedInt),
          Uri.of(defaultValueUri, _defaultValueUri),
          Url.of(defaultValueUrl, _defaultValueUrl),
          Uuid.of(defaultValueUuid, _defaultValueUuid),
          defaultValueAddress,
          defaultValueAge,
          defaultValueAnnotation,
          defaultValueAttachment,
          defaultValueCodeableConcept,
          defaultValueCoding,
          defaultValueContactPoint,
          defaultValueCount,
          defaultValueDistance,
          defaultValueDuration,
          defaultValueHumanName,
          defaultValueIdentifier,
          defaultValueMoney,
          defaultValuePeriod,
          defaultValueQuantity,
          defaultValueRange,
          defaultValueRatio,
          defaultValueReference,
          defaultValueSampledData,
          defaultValueSignature,
          defaultValueTiming,
          defaultValueContactDetail,
          defaultValueContributor,
          defaultValueDataRequirement,
          defaultValueExpression,
          defaultValueParameterDefinition,
          defaultValueRelatedArtifact,
          defaultValueTriggerDefinition,
          defaultValueUsageContext,
          defaultValueDosage,
          defaultValueMeta,
        ),
      element = R4String.of(element, _element),
      listMode = Enumeration.of(listMode, _listMode),
      variable = Id.of(variable, _variable),
      condition = R4String.of(condition, _condition),
      check = R4String.of(check, _check),
      logMessage = R4String.of(logMessage, _logMessage),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Source) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.context.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.context)
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.min?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.min)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.max?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.max)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.type?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.type)
    when (val choice = value.defaultValue) {
      null -> {}
      is StructureMap.Group.Rule.Source.DefaultValue.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 11, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 13, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 15, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 17, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 19, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 20, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 21, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 22, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          23,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 24, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 25, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 26, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Instant -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 27, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 28, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 29, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 30, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 31, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 32, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Oid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 33, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 34, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 35, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 36, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 37, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 38, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          39,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 40, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 41, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 42, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 43, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 44, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 45, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 46, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Uuid -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 47, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 48, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 49, AddressSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 50, AgeSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          51,
          AnnotationSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          52,
          AttachmentSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          53,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 54, CodingSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          55,
          ContactPointSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Count -> {
        compositeEncoder.encodeSerializableElement(descriptor, 56, CountSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Distance -> {
        compositeEncoder.encodeSerializableElement(descriptor, 57, DistanceSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 58, DurationSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.HumanName -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          59,
          HumanNameSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          60,
          IdentifierSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 61, MoneySerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 62, PeriodSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 63, QuantitySerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 64, RangeSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 65, RatioSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          66,
          ReferenceSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          67,
          SampledDataSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Signature -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          68,
          SignatureSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 69, TimingSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.ContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          70,
          ContactDetailSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Contributor -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          71,
          ContributorSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          72,
          DataRequirementSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          73,
          ExpressionSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.ParameterDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          74,
          ParameterDefinitionSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.RelatedArtifact -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          75,
          RelatedArtifactSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.TriggerDefinition -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          76,
          TriggerDefinitionSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.UsageContext -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          77,
          UsageContextSerializer,
          choice.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Dosage -> {
        compositeEncoder.encodeSerializableElement(descriptor, 78, DosageSerializer, choice.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Meta -> {
        compositeEncoder.encodeSerializableElement(descriptor, 79, MetaSerializer, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 80, value.element?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 81, value.element)
    compositeEncoder.encodeStringIfNotNull(descriptor, 82, value.listMode?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 83, value.listMode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 84, value.variable?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 85, value.variable)
    compositeEncoder.encodeStringIfNotNull(descriptor, 86, value.condition?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 87, value.condition)
    compositeEncoder.encodeStringIfNotNull(descriptor, 88, value.check?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 89, value.check)
    compositeEncoder.encodeStringIfNotNull(descriptor, 90, value.logMessage?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 91, value.logMessage)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleTargetSerializer :
  FhirSerializer<StructureMap.Group.Rule.Target> {
  override val descriptor: SerialDescriptor = buildDescriptor("Target", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Target>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("context")
    b.strPrim("contextType")
    b.strPrim("element")
    b.strPrim("variable")
    b.strPrimList("listMode")
    b.strPrim("listRuleId")
    b.strPrim("transform")
    b.optionalElement(
      "parameter",
      StructureMapGroupRuleTargetParameterSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var context: KotlinString? = null
    var _context: Element? = null
    var contextType: StructureMapContextType? = null
    var _contextType: Element? = null
    var element: KotlinString? = null
    var _element: Element? = null
    var variable: KotlinString? = null
    var _variable: Element? = null
    var listMode: List<KotlinString?>? = null
    var _listMode: List<Element?>? = null
    var listRuleId: KotlinString? = null
    var _listRuleId: Element? = null
    var transform: StructureMapTransform? = null
    var _transform: Element? = null
    var parameter: List<StructureMap.Group.Rule.Target.Parameter>? = null
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
        3 -> context = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _context =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          contextType =
            StructureMapContextType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _contextType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> element = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _element =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> variable = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _variable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          listMode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _listMode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 -> listRuleId = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _listRuleId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          transform =
            StructureMapTransform.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _transform =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleTargetParameterSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val listMode_ =
      List(maxSize(listMode, _listMode)) { index ->
        entryRequired(
          Enumeration.of(
            at(listMode, index)?.let { StructureMapTargetListMode.fromCode(it) },
            at(_listMode, index),
          ),
          "StructureMap.Group.Rule.Target",
          "listMode",
        )
      }
    return StructureMap.Group.Rule.Target(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      context = Id.of(context, _context),
      contextType = Enumeration.of(contextType, _contextType),
      element = R4String.of(element, _element),
      variable = Id.of(variable, _variable),
      listMode = listMode_,
      listRuleId = Id.of(listRuleId, _listRuleId),
      transform = Enumeration.of(transform, _transform),
      parameter = listOrEmpty(parameter),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Target) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.context?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.context)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.contextType?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.contextType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.element?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.element)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.variable?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.variable)
    if (!value.listMode.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11,
        stringNullableListSerializer,
        value.listMode.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 12, value.listMode)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.listRuleId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.listRuleId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.transform?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.transform)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17,
      StructureMapGroupRuleTargetParameterSerializer.listSerializer,
      value.parameter,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleTargetParameterSerializer :
  FhirSerializer<StructureMap.Group.Rule.Target.Parameter> {
  override val descriptor: SerialDescriptor = buildDescriptor("Parameter", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Target.Parameter>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("valueId")
    b.strPrim("valueString")
    b.boolPrim("valueBoolean")
    b.intPrim("valueInteger")
    b.prim("valueDecimal", FhirDecimalSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target.Parameter {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var valueId: KotlinString? = null
    var _valueId: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDecimal: FhirDecimal? = null
    var _valueDecimal: Element? = null
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
        3 -> valueId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _valueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        12 ->
          _valueDecimal =
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
    return StructureMap.Group.Rule.Target.Parameter(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      `value` =
        required(
          StructureMap.Group.Rule.Target.Parameter.Value.from(
            Id.of(valueId, _valueId),
            R4String.of(valueString, _valueString),
            R4Boolean.of(valueBoolean, _valueBoolean),
            Integer.of(valueInteger, _valueInteger),
            Decimal.of(valueDecimal, _valueDecimal),
          ),
          "StructureMap.Group.Rule.Target.Parameter",
          "value",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Target.Parameter) {
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
    when (val choice = value.`value`) {
      is StructureMap.Group.Rule.Target.Parameter.Value.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 9, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          11,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleDependentSerializer :
  FhirSerializer<StructureMap.Group.Rule.Dependent> {
  override val descriptor: SerialDescriptor = buildDescriptor("Dependent", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Dependent>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrimList("variable")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Dependent {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var variable: List<KotlinString?>? = null
    var _variable: List<Element?>? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          variable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        6 ->
          _variable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val variable_ =
      List(maxSize(variable, _variable)) { index ->
        entryRequired(
          R4String.of(at(variable, index), at(_variable, index)),
          "StructureMap.Group.Rule.Dependent",
          "variable",
        )
      }
    return StructureMap.Group.Rule.Dependent(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(Id.of(name, _name), "StructureMap.Group.Rule.Dependent", "name"),
      variable = variable_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Dependent) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    if (!value.variable.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        stringNullableListSerializer,
        value.variable.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.variable)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapSerializer : FhirResourceSerializer<StructureMap> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("StructureMap")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("version")
    b.strPrim("name")
    b.strPrim("title")
    b.strPrim("status")
    b.boolPrim("experimental")
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("copyright")
    b.optionalElement("structure", StructureMapStructureSerializer.listSerializer.descriptor)
    b.strPrimList("import")
    b.optionalElement("group", StructureMapGroupSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): StructureMap {
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
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
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
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var structure: List<StructureMap.Structure>? = null
    var `import`: List<KotlinString?>? = null
    var _import: List<Element?>? = null
    var group: List<StructureMap.Group>? = null
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
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        20 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        24 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          structure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapStructureSerializer.listSerializer,
              null,
            )
        37 ->
          `import` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        38 ->
          _import =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        39 ->
          group =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val import_ =
      List(maxSize(`import`, _import)) { index ->
        entryRequired(
          Canonical.of(at(`import`, index), at(_import, index)),
          "StructureMap",
          "import",
        )
      }
    return StructureMap(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = required(Uri.of(url, _url), "StructureMap", "url"),
      identifier = listOrEmpty(identifier),
      version = R4String.of(version, _version),
      name = required(R4String.of(name, _name), "StructureMap", "name"),
      title = R4String.of(title, _title),
      status = required(Enumeration.of(status, _status), "StructureMap", "status"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      structure = listOrEmpty(structure),
      `import` = import_,
      group = listOrEmpty(group),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: StructureMap,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.copyright)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      36 + descriptorOffset,
      StructureMapStructureSerializer.listSerializer,
      value.structure,
    )
    if (!value.`import`.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        37 + descriptorOffset,
        stringNullableListSerializer,
        value.`import`.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 38 + descriptorOffset, value.`import`)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      39 + descriptorOffset,
      StructureMapGroupSerializer.listSerializer,
      value.group,
    )
  }
}
