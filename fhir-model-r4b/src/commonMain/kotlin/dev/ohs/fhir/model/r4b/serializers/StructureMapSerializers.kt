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

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Age
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Contributor
import dev.ohs.fhir.model.r4b.Count
import dev.ohs.fhir.model.r4b.DataRequirement
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Distance
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Oid
import dev.ohs.fhir.model.r4b.ParameterDefinition
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.SampledData
import dev.ohs.fhir.model.r4b.Signature
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.StructureMap
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.TriggerDefinition
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.Uuid
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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

internal object StructureMapStructureSerializer : KSerializer<StructureMap.Structure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Structure") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
      optionalElement("mode", KotlinString.serializer().descriptor)
      optionalElement("_mode", ElementSerializer.descriptor)
      optionalElement("alias", KotlinString.serializer().descriptor)
      optionalElement("_alias", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureMap.Structure>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureMap.Structure {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var mode: KotlinString? = null
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
        5 -> mode = compositeDecoder.decodeStringElement(descriptor, i)
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
        else -> throw SerializationException("Unexpected index decoding Structure: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Structure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url =
        Canonical.of(url, _url)
          ?: throw SerializationException(
            "Missing required property 'url' on StructureMap.Structure"
          ),
      mode =
        Enumeration.of(
          if (mode != null) StructureMap.StructureMapModelMode.fromCode(mode) else null,
          _mode,
        )
          ?: throw SerializationException(
            "Missing required property 'mode' on StructureMap.Structure"
          ),
      alias = R4bString.of(alias, _alias),
      documentation = R4bString.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Structure) {
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

internal object StructureMapGroupSerializer : KSerializer<StructureMap.Group> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Group") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("extends", KotlinString.serializer().descriptor)
      optionalElement("_extends", ElementSerializer.descriptor)
      optionalElement("typeMode", KotlinString.serializer().descriptor)
      optionalElement("_typeMode", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
      optionalElement("input", StructureMapGroupInputSerializer.listSerializer.descriptor)
      optionalElement("rule", StructureMapGroupRuleSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureMap.Group>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureMap.Group {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var extends: KotlinString? = null
    var _extends: Element? = null
    var typeMode: KotlinString? = null
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
        7 -> typeMode = compositeDecoder.decodeStringElement(descriptor, i)
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
        else -> throw SerializationException("Unexpected index decoding Group: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        Id.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on StructureMap.Group"),
      extends = Id.of(extends, _extends),
      typeMode =
        Enumeration.of(
          if (typeMode != null) StructureMap.StructureMapGroupTypeMode.fromCode(typeMode) else null,
          _typeMode,
        )
          ?: throw SerializationException(
            "Missing required property 'typeMode' on StructureMap.Group"
          ),
      documentation = R4bString.of(documentation, _documentation),
      input = input ?: listOf(),
      rule = rule ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.extends?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.extends)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.typeMode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.typeMode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    if (value.input.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        StructureMapGroupInputSerializer.listSerializer,
        value.input,
      )
    if (value.rule.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        StructureMapGroupRuleSerializer.listSerializer,
        value.rule,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupInputSerializer : KSerializer<StructureMap.Group.Input> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Input") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("mode", KotlinString.serializer().descriptor)
      optionalElement("_mode", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureMap.Group.Input>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureMap.Group.Input {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var mode: KotlinString? = null
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
        7 -> mode = compositeDecoder.decodeStringElement(descriptor, i)
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
        else -> throw SerializationException("Unexpected index decoding Input: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group.Input(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        Id.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on StructureMap.Group.Input"
          ),
      type = R4bString.of(type, _type),
      mode =
        Enumeration.of(
          if (mode != null) StructureMap.StructureMapInputMode.fromCode(mode) else null,
          _mode,
        )
          ?: throw SerializationException(
            "Missing required property 'mode' on StructureMap.Group.Input"
          ),
      documentation = R4bString.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Input) {
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

internal object StructureMapGroupRuleSerializer : KSerializer<StructureMap.Group.Rule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Rule") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("source", StructureMapGroupRuleSourceSerializer.listSerializer.descriptor)
      optionalElement("target", StructureMapGroupRuleTargetSerializer.listSerializer.descriptor)
      optionalElement(
        "rule",
        listSerialDescriptor(lazyDescriptor { StructureMapGroupRuleSerializer.descriptor }),
      )
      optionalElement(
        "dependent",
        StructureMapGroupRuleDependentSerializer.listSerializer.descriptor,
      )
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule {
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
        else -> throw SerializationException("Unexpected index decoding Rule: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group.Rule(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        Id.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on StructureMap.Group.Rule"
          ),
      source = source ?: listOf(),
      target = target ?: listOf(),
      rule = rule ?: listOf(),
      dependent = dependent ?: listOf(),
      documentation = R4bString.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    if (value.source.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        StructureMapGroupRuleSourceSerializer.listSerializer,
        value.source,
      )
    if (value.target.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        StructureMapGroupRuleTargetSerializer.listSerializer,
        value.target,
      )
    if (value.rule.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        StructureMapGroupRuleSerializer.listSerializer,
        value.rule,
      )
    if (value.dependent.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
  KSerializer<StructureMap.Group.Rule.Source> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Source") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("context", KotlinString.serializer().descriptor)
      optionalElement("_context", ElementSerializer.descriptor)
      optionalElement("min", Int.serializer().descriptor)
      optionalElement("_min", ElementSerializer.descriptor)
      optionalElement("max", KotlinString.serializer().descriptor)
      optionalElement("_max", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("defaultValueBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueBase64Binary", ElementSerializer.descriptor)
      optionalElement("defaultValueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_defaultValueBoolean", ElementSerializer.descriptor)
      optionalElement("defaultValueCanonical", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueCanonical", ElementSerializer.descriptor)
      optionalElement("defaultValueCode", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueCode", ElementSerializer.descriptor)
      optionalElement("defaultValueDate", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueDate", ElementSerializer.descriptor)
      optionalElement("defaultValueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueDateTime", ElementSerializer.descriptor)
      optionalElement("defaultValueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_defaultValueDecimal", ElementSerializer.descriptor)
      optionalElement("defaultValueId", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueId", ElementSerializer.descriptor)
      optionalElement("defaultValueInstant", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueInstant", ElementSerializer.descriptor)
      optionalElement("defaultValueInteger", Int.serializer().descriptor)
      optionalElement("_defaultValueInteger", ElementSerializer.descriptor)
      optionalElement("defaultValueMarkdown", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueMarkdown", ElementSerializer.descriptor)
      optionalElement("defaultValueOid", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueOid", ElementSerializer.descriptor)
      optionalElement("defaultValuePositiveInt", Int.serializer().descriptor)
      optionalElement("_defaultValuePositiveInt", ElementSerializer.descriptor)
      optionalElement("defaultValueString", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueString", ElementSerializer.descriptor)
      optionalElement("defaultValueTime", LocalTimeSerializer.descriptor)
      optionalElement("_defaultValueTime", ElementSerializer.descriptor)
      optionalElement("defaultValueUnsignedInt", Int.serializer().descriptor)
      optionalElement("_defaultValueUnsignedInt", ElementSerializer.descriptor)
      optionalElement("defaultValueUri", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueUri", ElementSerializer.descriptor)
      optionalElement("defaultValueUrl", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueUrl", ElementSerializer.descriptor)
      optionalElement("defaultValueUuid", KotlinString.serializer().descriptor)
      optionalElement("_defaultValueUuid", ElementSerializer.descriptor)
      optionalElement("defaultValueAddress", AddressSerializer.descriptor)
      optionalElement("defaultValueAge", AgeSerializer.descriptor)
      optionalElement("defaultValueAnnotation", AnnotationSerializer.descriptor)
      optionalElement("defaultValueAttachment", AttachmentSerializer.descriptor)
      optionalElement("defaultValueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("defaultValueCoding", CodingSerializer.descriptor)
      optionalElement("defaultValueContactPoint", ContactPointSerializer.descriptor)
      optionalElement("defaultValueCount", CountSerializer.descriptor)
      optionalElement("defaultValueDistance", DistanceSerializer.descriptor)
      optionalElement("defaultValueDuration", DurationSerializer.descriptor)
      optionalElement("defaultValueHumanName", HumanNameSerializer.descriptor)
      optionalElement("defaultValueIdentifier", IdentifierSerializer.descriptor)
      optionalElement("defaultValueMoney", MoneySerializer.descriptor)
      optionalElement("defaultValuePeriod", PeriodSerializer.descriptor)
      optionalElement("defaultValueQuantity", QuantitySerializer.descriptor)
      optionalElement("defaultValueRange", RangeSerializer.descriptor)
      optionalElement("defaultValueRatio", RatioSerializer.descriptor)
      optionalElement("defaultValueReference", ReferenceSerializer.descriptor)
      optionalElement("defaultValueSampledData", SampledDataSerializer.descriptor)
      optionalElement("defaultValueSignature", SignatureSerializer.descriptor)
      optionalElement("defaultValueTiming", TimingSerializer.descriptor)
      optionalElement("defaultValueContactDetail", ContactDetailSerializer.descriptor)
      optionalElement("defaultValueContributor", ContributorSerializer.descriptor)
      optionalElement("defaultValueDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("defaultValueExpression", ExpressionSerializer.descriptor)
      optionalElement("defaultValueParameterDefinition", ParameterDefinitionSerializer.descriptor)
      optionalElement("defaultValueRelatedArtifact", RelatedArtifactSerializer.descriptor)
      optionalElement("defaultValueTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("defaultValueUsageContext", UsageContextSerializer.descriptor)
      optionalElement("defaultValueDosage", DosageSerializer.descriptor)
      optionalElement("defaultValueMeta", MetaSerializer.descriptor)
      optionalElement("element", KotlinString.serializer().descriptor)
      optionalElement("_element", ElementSerializer.descriptor)
      optionalElement("listMode", KotlinString.serializer().descriptor)
      optionalElement("_listMode", ElementSerializer.descriptor)
      optionalElement("variable", KotlinString.serializer().descriptor)
      optionalElement("_variable", ElementSerializer.descriptor)
      optionalElement("condition", KotlinString.serializer().descriptor)
      optionalElement("_condition", ElementSerializer.descriptor)
      optionalElement("check", KotlinString.serializer().descriptor)
      optionalElement("_check", ElementSerializer.descriptor)
      optionalElement("logMessage", KotlinString.serializer().descriptor)
      optionalElement("_logMessage", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Source>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Source {
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
    var defaultValueDate: KotlinString? = null
    var _defaultValueDate: Element? = null
    var defaultValueDateTime: KotlinString? = null
    var _defaultValueDateTime: Element? = null
    var defaultValueDecimal: FhirDecimal? = null
    var _defaultValueDecimal: Element? = null
    var defaultValueId: KotlinString? = null
    var _defaultValueId: Element? = null
    var defaultValueInstant: KotlinString? = null
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
    var listMode: KotlinString? = null
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
        19 -> defaultValueDate = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _defaultValueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> defaultValueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
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
        27 -> defaultValueInstant = compositeDecoder.decodeStringElement(descriptor, i)
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
        82 -> listMode = compositeDecoder.decodeStringElement(descriptor, i)
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
        else -> throw SerializationException("Unexpected index decoding Source: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group.Rule.Source(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      context =
        Id.of(context, _context)
          ?: throw SerializationException(
            "Missing required property 'context' on StructureMap.Group.Rule.Source"
          ),
      min = Integer.of(min, _min),
      max = R4bString.of(max, _max),
      type = R4bString.of(type, _type),
      defaultValue =
        StructureMap.Group.Rule.Source.DefaultValue.from(
          Base64Binary.of(defaultValueBase64Binary, _defaultValueBase64Binary),
          R4bBoolean.of(defaultValueBoolean, _defaultValueBoolean),
          Canonical.of(defaultValueCanonical, _defaultValueCanonical),
          Code.of(defaultValueCode, _defaultValueCode),
          Date.of(
            if (defaultValueDate != null) FhirDate.fromString(defaultValueDate) else null,
            _defaultValueDate,
          ),
          DateTime.of(
            if (defaultValueDateTime != null) FhirDateTime.fromString(defaultValueDateTime)
            else null,
            _defaultValueDateTime,
          ),
          Decimal.of(defaultValueDecimal, _defaultValueDecimal),
          Id.of(defaultValueId, _defaultValueId),
          Instant.of(
            if (defaultValueInstant != null) FhirDateTime.fromString(defaultValueInstant) else null,
            _defaultValueInstant,
          ),
          Integer.of(defaultValueInteger, _defaultValueInteger),
          Markdown.of(defaultValueMarkdown, _defaultValueMarkdown),
          Oid.of(defaultValueOid, _defaultValueOid),
          PositiveInt.of(defaultValuePositiveInt, _defaultValuePositiveInt),
          R4bString.of(defaultValueString, _defaultValueString),
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
      element = R4bString.of(element, _element),
      listMode =
        Enumeration.of(
          if (listMode != null) StructureMap.StructureMapSourceListMode.fromCode(listMode)
          else null,
          _listMode,
        ),
      variable = Id.of(variable, _variable),
      condition = R4bString.of(condition, _condition),
      check = R4bString.of(check, _check),
      logMessage = R4bString.of(logMessage, _logMessage),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Source) {
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
  KSerializer<StructureMap.Group.Rule.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Target") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("context", KotlinString.serializer().descriptor)
      optionalElement("_context", ElementSerializer.descriptor)
      optionalElement("contextType", KotlinString.serializer().descriptor)
      optionalElement("_contextType", ElementSerializer.descriptor)
      optionalElement("element", KotlinString.serializer().descriptor)
      optionalElement("_element", ElementSerializer.descriptor)
      optionalElement("variable", KotlinString.serializer().descriptor)
      optionalElement("_variable", ElementSerializer.descriptor)
      optionalElement("listMode", stringNullableListSerializer.descriptor)
      optionalElement("_listMode", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("listRuleId", KotlinString.serializer().descriptor)
      optionalElement("_listRuleId", ElementSerializer.descriptor)
      optionalElement("transform", KotlinString.serializer().descriptor)
      optionalElement("_transform", ElementSerializer.descriptor)
      optionalElement(
        "parameter",
        StructureMapGroupRuleTargetParameterSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Target>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var context: KotlinString? = null
    var _context: Element? = null
    var contextType: KotlinString? = null
    var _contextType: Element? = null
    var element: KotlinString? = null
    var _element: Element? = null
    var variable: KotlinString? = null
    var _variable: Element? = null
    var listMode: List<KotlinString?>? = null
    var _listMode: List<Element?>? = null
    var listRuleId: KotlinString? = null
    var _listRuleId: Element? = null
    var transform: KotlinString? = null
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
        5 -> contextType = compositeDecoder.decodeStringElement(descriptor, i)
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
        15 -> transform = compositeDecoder.decodeStringElement(descriptor, i)
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
        else -> throw SerializationException("Unexpected index decoding Target: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group.Rule.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      context = Id.of(context, _context),
      contextType =
        Enumeration.of(
          if (contextType != null) StructureMap.StructureMapContextType.fromCode(contextType)
          else null,
          _contextType,
        ),
      element = R4bString.of(element, _element),
      variable = Id.of(variable, _variable),
      listMode =
        (kotlin.collections.List(maxOf(listMode?.size ?: 0, _listMode?.size ?: 0)) { index ->
          Enumeration.of(
            listMode?.getOrNull(index)?.let {
              StructureMap.StructureMapTargetListMode.fromCode(it)
            },
            _listMode?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'listMode' on StructureMap.Group.Rule.Target has neither a value nor an id/extension"
            )
        }),
      listRuleId = Id.of(listRuleId, _listRuleId),
      transform =
        Enumeration.of(
          if (transform != null) StructureMap.StructureMapTransform.fromCode(transform) else null,
          _transform,
        ),
      parameter = parameter ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Target) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.context?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.context)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.contextType?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.contextType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.element?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.element)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.variable?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.variable)
    if (value.listMode.isNotEmpty()) {
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
    if (value.parameter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        17,
        StructureMapGroupRuleTargetParameterSerializer.listSerializer,
        value.parameter,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleTargetParameterSerializer :
  KSerializer<StructureMap.Group.Rule.Target.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("valueId", KotlinString.serializer().descriptor)
      optionalElement("_valueId", ElementSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_valueDecimal", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Target.Parameter>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target.Parameter {
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
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group.Rule.Target.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        StructureMap.Group.Rule.Target.Parameter.Value.from(
          Id.of(valueId, _valueId),
          R4bString.of(valueString, _valueString),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          Decimal.of(valueDecimal, _valueDecimal),
        )
          ?: throw SerializationException(
            "Missing required property 'value' on StructureMap.Group.Rule.Target.Parameter"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Target.Parameter) {
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
  KSerializer<StructureMap.Group.Rule.Dependent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dependent") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("variable", stringNullableListSerializer.descriptor)
      optionalElement("_variable", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Dependent>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Dependent {
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
        else -> throw SerializationException("Unexpected index decoding Dependent: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group.Rule.Dependent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        Id.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on StructureMap.Group.Rule.Dependent"
          ),
      variable =
        (kotlin.collections.List(maxOf(variable?.size ?: 0, _variable?.size ?: 0)) { index ->
          R4bString.of(variable?.getOrNull(index), _variable?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'variable' on StructureMap.Group.Rule.Dependent has neither a value nor an id/extension"
            )
        }),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Dependent) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    if (value.variable.isNotEmpty()) {
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
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
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
    b.optionalElement("structure", StructureMapStructureSerializer.listSerializer.descriptor)
    b.optionalElement("import", stringNullableListSerializer.descriptor)
    b.optionalElement("_import", ElementSerializer.nullableListSerializer.descriptor)
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
        19 -> status = compositeDecoder.decodeStringElement(descriptor, i)
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
        23 -> date = compositeDecoder.decodeStringElement(descriptor, i)
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
        else -> throw SerializationException("Unexpected index decoding StructureMap: " + i)
      }
    }
    return StructureMap(
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
          ?: throw SerializationException("Missing required property 'url' on StructureMap"),
      identifier = identifier ?: listOf(),
      version = R4bString.of(version, _version),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on StructureMap"),
      title = R4bString.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on StructureMap"),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      structure = structure ?: listOf(),
      `import` =
        (kotlin.collections.List(maxOf(`import`?.size ?: 0, _import?.size ?: 0)) { index ->
          Canonical.of(`import`?.getOrNull(index), _import?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'import' on StructureMap has neither a value nor an id/extension"
            )
        }),
      group = group ?: listOf(),
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
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
    if (value.structure.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        StructureMapStructureSerializer.listSerializer,
        value.structure,
      )
    if (value.`import`.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        37 + descriptorOffset,
        stringNullableListSerializer,
        value.`import`.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 38 + descriptorOffset, value.`import`)
    }
    if (value.group.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        StructureMapGroupSerializer.listSerializer,
        value.group,
      )
  }
}
