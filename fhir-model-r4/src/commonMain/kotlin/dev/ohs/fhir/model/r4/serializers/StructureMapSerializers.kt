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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

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

  override fun deserialize(decoder: Decoder): StructureMap.Structure =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> url = decodeStringElement(descriptor, i)
          4 -> _url = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> mode = decodeStringElement(descriptor, i)
          6 -> _mode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> alias = decodeStringElement(descriptor, i)
          8 -> _alias = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> documentation = decodeStringElement(descriptor, i)
          10 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Structure: " + i)
        }
      }
      StructureMap.Structure(
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
        alias = R4String.of(alias, _alias),
        documentation = R4String.of(documentation, _documentation),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Structure) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.url.value)
      encodeElementIfNotNull(descriptor, 4, value.url)
      encodeStringIfNotNull(descriptor, 5, value.mode.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.mode)
      encodeStringIfNotNull(descriptor, 7, value.alias?.value)
      encodeElementIfNotNull(descriptor, 8, value.alias)
      encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 10, value.documentation)
    }
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

  override fun deserialize(decoder: Decoder): StructureMap.Group =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> extends = decodeStringElement(descriptor, i)
          6 -> _extends = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> typeMode = decodeStringElement(descriptor, i)
          8 -> _typeMode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> documentation = decodeStringElement(descriptor, i)
          10 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            input =
              decodeNullableSerializableElement(
                descriptor,
                i,
                StructureMapGroupInputSerializer.listSerializer,
                null,
              )
          12 ->
            rule =
              decodeNullableSerializableElement(
                descriptor,
                i,
                StructureMapGroupRuleSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Group: " + i)
        }
      }
      StructureMap.Group(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          Id.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on StructureMap.Group"
            ),
        extends = Id.of(extends, _extends),
        typeMode =
          Enumeration.of(
            if (typeMode != null) StructureMap.StructureMapGroupTypeMode.fromCode(typeMode)
            else null,
            _typeMode,
          )
            ?: throw SerializationException(
              "Missing required property 'typeMode' on StructureMap.Group"
            ),
        documentation = R4String.of(documentation, _documentation),
        input = input ?: listOf(),
        rule = rule ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeStringIfNotNull(descriptor, 5, value.extends?.value)
      encodeElementIfNotNull(descriptor, 6, value.extends)
      encodeStringIfNotNull(descriptor, 7, value.typeMode.value?.code)
      encodeElementIfNotNull(descriptor, 8, value.typeMode)
      encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 10, value.documentation)
      if (value.input.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          StructureMapGroupInputSerializer.listSerializer,
          value.input,
        )
      if (value.rule.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          StructureMapGroupRuleSerializer.listSerializer,
          value.rule,
        )
    }
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

  override fun deserialize(decoder: Decoder): StructureMap.Group.Input =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> type = decodeStringElement(descriptor, i)
          6 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> mode = decodeStringElement(descriptor, i)
          8 -> _mode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> documentation = decodeStringElement(descriptor, i)
          10 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Input: " + i)
        }
      }
      StructureMap.Group.Input(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          Id.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on StructureMap.Group.Input"
            ),
        type = R4String.of(type, _type),
        mode =
          Enumeration.of(
            if (mode != null) StructureMap.StructureMapInputMode.fromCode(mode) else null,
            _mode,
          )
            ?: throw SerializationException(
              "Missing required property 'mode' on StructureMap.Group.Input"
            ),
        documentation = R4String.of(documentation, _documentation),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Input) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeStringIfNotNull(descriptor, 5, value.type?.value)
      encodeElementIfNotNull(descriptor, 6, value.type)
      encodeStringIfNotNull(descriptor, 7, value.mode.value?.code)
      encodeElementIfNotNull(descriptor, 8, value.mode)
      encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 10, value.documentation)
    }
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

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                StructureMapGroupRuleSourceSerializer.listSerializer,
                null,
              )
          6 ->
            target =
              decodeNullableSerializableElement(
                descriptor,
                i,
                StructureMapGroupRuleTargetSerializer.listSerializer,
                null,
              )
          7 ->
            rule =
              decodeNullableSerializableElement(
                descriptor,
                i,
                StructureMapGroupRuleSerializer.listSerializer,
                null,
              )
          8 ->
            dependent =
              decodeNullableSerializableElement(
                descriptor,
                i,
                StructureMapGroupRuleDependentSerializer.listSerializer,
                null,
              )
          9 -> documentation = decodeStringElement(descriptor, i)
          10 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Rule: " + i)
        }
      }
      StructureMap.Group.Rule(
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
        documentation = R4String.of(documentation, _documentation),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      if (value.source.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          StructureMapGroupRuleSourceSerializer.listSerializer,
          value.source,
        )
      if (value.target.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          StructureMapGroupRuleTargetSerializer.listSerializer,
          value.target,
        )
      if (value.rule.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          StructureMapGroupRuleSerializer.listSerializer,
          value.rule,
        )
      if (value.dependent.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          StructureMapGroupRuleDependentSerializer.listSerializer,
          value.dependent,
        )
      encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 10, value.documentation)
    }
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

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Source =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> context = decodeStringElement(descriptor, i)
          4 -> _context = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> min = decodeIntElement(descriptor, i)
          6 -> _min = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> max = decodeStringElement(descriptor, i)
          8 -> _max = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> type = decodeStringElement(descriptor, i)
          10 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> defaultValueBase64Binary = decodeStringElement(descriptor, i)
          12 ->
            _defaultValueBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> defaultValueBoolean = decodeBooleanElement(descriptor, i)
          14 ->
            _defaultValueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> defaultValueCanonical = decodeStringElement(descriptor, i)
          16 ->
            _defaultValueCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> defaultValueCode = decodeStringElement(descriptor, i)
          18 ->
            _defaultValueCode =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 -> defaultValueDate = decodeStringElement(descriptor, i)
          20 ->
            _defaultValueDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          21 -> defaultValueDateTime = decodeStringElement(descriptor, i)
          22 ->
            _defaultValueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          23 ->
            defaultValueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          24 ->
            _defaultValueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          25 -> defaultValueId = decodeStringElement(descriptor, i)
          26 ->
            _defaultValueId =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          27 -> defaultValueInstant = decodeStringElement(descriptor, i)
          28 ->
            _defaultValueInstant =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          29 -> defaultValueInteger = decodeIntElement(descriptor, i)
          30 ->
            _defaultValueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          31 -> defaultValueMarkdown = decodeStringElement(descriptor, i)
          32 ->
            _defaultValueMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          33 -> defaultValueOid = decodeStringElement(descriptor, i)
          34 ->
            _defaultValueOid =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          35 -> defaultValuePositiveInt = decodeIntElement(descriptor, i)
          36 ->
            _defaultValuePositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          37 -> defaultValueString = decodeStringElement(descriptor, i)
          38 ->
            _defaultValueString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          39 ->
            defaultValueTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          40 ->
            _defaultValueTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          41 -> defaultValueUnsignedInt = decodeIntElement(descriptor, i)
          42 ->
            _defaultValueUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          43 -> defaultValueUri = decodeStringElement(descriptor, i)
          44 ->
            _defaultValueUri =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          45 -> defaultValueUrl = decodeStringElement(descriptor, i)
          46 ->
            _defaultValueUrl =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          47 -> defaultValueUuid = decodeStringElement(descriptor, i)
          48 ->
            _defaultValueUuid =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          49 ->
            defaultValueAddress =
              decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          50 ->
            defaultValueAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          51 ->
            defaultValueAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          52 ->
            defaultValueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          53 ->
            defaultValueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          54 ->
            defaultValueCoding =
              decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          55 ->
            defaultValueContactPoint =
              decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          56 ->
            defaultValueCount =
              decodeNullableSerializableElement(descriptor, i, CountSerializer, null)
          57 ->
            defaultValueDistance =
              decodeNullableSerializableElement(descriptor, i, DistanceSerializer, null)
          58 ->
            defaultValueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          59 ->
            defaultValueHumanName =
              decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          60 ->
            defaultValueIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          61 ->
            defaultValueMoney =
              decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          62 ->
            defaultValuePeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          63 ->
            defaultValueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          64 ->
            defaultValueRange =
              decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          65 ->
            defaultValueRatio =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          66 ->
            defaultValueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          67 ->
            defaultValueSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          68 ->
            defaultValueSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          69 ->
            defaultValueTiming =
              decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          70 ->
            defaultValueContactDetail =
              decodeNullableSerializableElement(descriptor, i, ContactDetailSerializer, null)
          71 ->
            defaultValueContributor =
              decodeNullableSerializableElement(descriptor, i, ContributorSerializer, null)
          72 ->
            defaultValueDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          73 ->
            defaultValueExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          74 ->
            defaultValueParameterDefinition =
              decodeNullableSerializableElement(descriptor, i, ParameterDefinitionSerializer, null)
          75 ->
            defaultValueRelatedArtifact =
              decodeNullableSerializableElement(descriptor, i, RelatedArtifactSerializer, null)
          76 ->
            defaultValueTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          77 ->
            defaultValueUsageContext =
              decodeNullableSerializableElement(descriptor, i, UsageContextSerializer, null)
          78 ->
            defaultValueDosage =
              decodeNullableSerializableElement(descriptor, i, DosageSerializer, null)
          79 ->
            defaultValueMeta =
              decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
          80 -> element = decodeStringElement(descriptor, i)
          81 -> _element = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          82 -> listMode = decodeStringElement(descriptor, i)
          83 ->
            _listMode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          84 -> variable = decodeStringElement(descriptor, i)
          85 ->
            _variable = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          86 -> condition = decodeStringElement(descriptor, i)
          87 ->
            _condition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          88 -> check = decodeStringElement(descriptor, i)
          89 -> _check = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          90 -> logMessage = decodeStringElement(descriptor, i)
          91 ->
            _logMessage = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Source: " + i)
        }
      }
      StructureMap.Group.Rule.Source(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        context =
          Id.of(context, _context)
            ?: throw SerializationException(
              "Missing required property 'context' on StructureMap.Group.Rule.Source"
            ),
        min = Integer.of(min, _min),
        max = R4String.of(max, _max),
        type = R4String.of(type, _type),
        defaultValue =
          StructureMap.Group.Rule.Source.DefaultValue.from(
            Base64Binary.of(defaultValueBase64Binary, _defaultValueBase64Binary),
            R4Boolean.of(defaultValueBoolean, _defaultValueBoolean),
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
              if (defaultValueInstant != null) FhirDateTime.fromString(defaultValueInstant)
              else null,
              _defaultValueInstant,
            ),
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
        listMode =
          Enumeration.of(
            if (listMode != null) StructureMap.StructureMapSourceListMode.fromCode(listMode)
            else null,
            _listMode,
          ),
        variable = Id.of(variable, _variable),
        condition = R4String.of(condition, _condition),
        check = R4String.of(check, _check),
        logMessage = R4String.of(logMessage, _logMessage),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Source) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.context.value)
      encodeElementIfNotNull(descriptor, 4, value.context)
      encodeIntIfNotNull(descriptor, 5, value.min?.value)
      encodeElementIfNotNull(descriptor, 6, value.min)
      encodeStringIfNotNull(descriptor, 7, value.max?.value)
      encodeElementIfNotNull(descriptor, 8, value.max)
      encodeStringIfNotNull(descriptor, 9, value.type?.value)
      encodeElementIfNotNull(descriptor, 10, value.type)
      when (val choice = value.defaultValue) {
        null -> {}
        is StructureMap.Group.Rule.Source.DefaultValue.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 13, choice.value.value)
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Canonical -> {
          encodeStringIfNotNull(descriptor, 15, choice.value.value)
          encodeElementIfNotNull(descriptor, 16, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Code -> {
          encodeStringIfNotNull(descriptor, 17, choice.value.value)
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Date -> {
          encodeStringIfNotNull(descriptor, 19, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 20, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.DateTime -> {
          encodeStringIfNotNull(descriptor, 21, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 22, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 23, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 24, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Id -> {
          encodeStringIfNotNull(descriptor, 25, choice.value.value)
          encodeElementIfNotNull(descriptor, 26, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Instant -> {
          encodeStringIfNotNull(descriptor, 27, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 28, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Integer -> {
          encodeIntIfNotNull(descriptor, 29, choice.value.value)
          encodeElementIfNotNull(descriptor, 30, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Markdown -> {
          encodeStringIfNotNull(descriptor, 31, choice.value.value)
          encodeElementIfNotNull(descriptor, 32, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Oid -> {
          encodeStringIfNotNull(descriptor, 33, choice.value.value)
          encodeElementIfNotNull(descriptor, 34, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 35, choice.value.value)
          encodeElementIfNotNull(descriptor, 36, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.String -> {
          encodeStringIfNotNull(descriptor, 37, choice.value.value)
          encodeElementIfNotNull(descriptor, 38, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Time -> {
          encodeSerializableIfNotNull(descriptor, 39, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 40, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 41, choice.value.value)
          encodeElementIfNotNull(descriptor, 42, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Uri -> {
          encodeStringIfNotNull(descriptor, 43, choice.value.value)
          encodeElementIfNotNull(descriptor, 44, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Url -> {
          encodeStringIfNotNull(descriptor, 45, choice.value.value)
          encodeElementIfNotNull(descriptor, 46, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Uuid -> {
          encodeStringIfNotNull(descriptor, 47, choice.value.value)
          encodeElementIfNotNull(descriptor, 48, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Address -> {
          encodeSerializableElement(descriptor, 49, AddressSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Age -> {
          encodeSerializableElement(descriptor, 50, AgeSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Annotation -> {
          encodeSerializableElement(descriptor, 51, AnnotationSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Attachment -> {
          encodeSerializableElement(descriptor, 52, AttachmentSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.CodeableConcept -> {
          encodeSerializableElement(descriptor, 53, CodeableConceptSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Coding -> {
          encodeSerializableElement(descriptor, 54, CodingSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.ContactPoint -> {
          encodeSerializableElement(descriptor, 55, ContactPointSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Count -> {
          encodeSerializableElement(descriptor, 56, CountSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Distance -> {
          encodeSerializableElement(descriptor, 57, DistanceSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Duration -> {
          encodeSerializableElement(descriptor, 58, DurationSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.HumanName -> {
          encodeSerializableElement(descriptor, 59, HumanNameSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Identifier -> {
          encodeSerializableElement(descriptor, 60, IdentifierSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Money -> {
          encodeSerializableElement(descriptor, 61, MoneySerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Period -> {
          encodeSerializableElement(descriptor, 62, PeriodSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Quantity -> {
          encodeSerializableElement(descriptor, 63, QuantitySerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Range -> {
          encodeSerializableElement(descriptor, 64, RangeSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Ratio -> {
          encodeSerializableElement(descriptor, 65, RatioSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Reference -> {
          encodeSerializableElement(descriptor, 66, ReferenceSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.SampledData -> {
          encodeSerializableElement(descriptor, 67, SampledDataSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Signature -> {
          encodeSerializableElement(descriptor, 68, SignatureSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Timing -> {
          encodeSerializableElement(descriptor, 69, TimingSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.ContactDetail -> {
          encodeSerializableElement(descriptor, 70, ContactDetailSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Contributor -> {
          encodeSerializableElement(descriptor, 71, ContributorSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.DataRequirement -> {
          encodeSerializableElement(descriptor, 72, DataRequirementSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Expression -> {
          encodeSerializableElement(descriptor, 73, ExpressionSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.ParameterDefinition -> {
          encodeSerializableElement(descriptor, 74, ParameterDefinitionSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.RelatedArtifact -> {
          encodeSerializableElement(descriptor, 75, RelatedArtifactSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 76, TriggerDefinitionSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.UsageContext -> {
          encodeSerializableElement(descriptor, 77, UsageContextSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Dosage -> {
          encodeSerializableElement(descriptor, 78, DosageSerializer, choice.value)
        }
        is StructureMap.Group.Rule.Source.DefaultValue.Meta -> {
          encodeSerializableElement(descriptor, 79, MetaSerializer, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 80, value.element?.value)
      encodeElementIfNotNull(descriptor, 81, value.element)
      encodeStringIfNotNull(descriptor, 82, value.listMode?.value?.code)
      encodeElementIfNotNull(descriptor, 83, value.listMode)
      encodeStringIfNotNull(descriptor, 84, value.variable?.value)
      encodeElementIfNotNull(descriptor, 85, value.variable)
      encodeStringIfNotNull(descriptor, 86, value.condition?.value)
      encodeElementIfNotNull(descriptor, 87, value.condition)
      encodeStringIfNotNull(descriptor, 88, value.check?.value)
      encodeElementIfNotNull(descriptor, 89, value.check)
      encodeStringIfNotNull(descriptor, 90, value.logMessage?.value)
      encodeElementIfNotNull(descriptor, 91, value.logMessage)
    }
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

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> context = decodeStringElement(descriptor, i)
          4 -> _context = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> contextType = decodeStringElement(descriptor, i)
          6 ->
            _contextType = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> element = decodeStringElement(descriptor, i)
          8 -> _element = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> variable = decodeStringElement(descriptor, i)
          10 ->
            _variable = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            listMode =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          12 ->
            _listMode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          13 -> listRuleId = decodeStringElement(descriptor, i)
          14 ->
            _listRuleId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> transform = decodeStringElement(descriptor, i)
          16 ->
            _transform = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 ->
            parameter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                StructureMapGroupRuleTargetParameterSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Target: " + i)
        }
      }
      StructureMap.Group.Rule.Target(
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
        element = R4String.of(element, _element),
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.context?.value)
      encodeElementIfNotNull(descriptor, 4, value.context)
      encodeStringIfNotNull(descriptor, 5, value.contextType?.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.contextType)
      encodeStringIfNotNull(descriptor, 7, value.element?.value)
      encodeElementIfNotNull(descriptor, 8, value.element)
      encodeStringIfNotNull(descriptor, 9, value.variable?.value)
      encodeElementIfNotNull(descriptor, 10, value.variable)
      if (value.listMode.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          11,
          stringNullableListSerializer,
          value.listMode.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 12, value.listMode)
      }
      encodeStringIfNotNull(descriptor, 13, value.listRuleId?.value)
      encodeElementIfNotNull(descriptor, 14, value.listRuleId)
      encodeStringIfNotNull(descriptor, 15, value.transform?.value?.code)
      encodeElementIfNotNull(descriptor, 16, value.transform)
      if (value.parameter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          17,
          StructureMapGroupRuleTargetParameterSerializer.listSerializer,
          value.parameter,
        )
    }
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

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target.Parameter =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> valueId = decodeStringElement(descriptor, i)
          4 -> _valueId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> valueString = decodeStringElement(descriptor, i)
          6 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> valueBoolean = decodeBooleanElement(descriptor, i)
          8 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> valueInteger = decodeIntElement(descriptor, i)
          10 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          12 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
        }
      }
      StructureMap.Group.Rule.Target.Parameter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` =
          StructureMap.Group.Rule.Target.Parameter.Value.from(
            Id.of(valueId, _valueId),
            R4String.of(valueString, _valueString),
            R4Boolean.of(valueBoolean, _valueBoolean),
            Integer.of(valueInteger, _valueInteger),
            Decimal.of(valueDecimal, _valueDecimal),
          )
            ?: throw SerializationException(
              "Missing required property 'value' on StructureMap.Group.Rule.Target.Parameter"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Target.Parameter) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      when (val choice = value.`value`) {
        is StructureMap.Group.Rule.Target.Parameter.Value.Id -> {
          encodeStringIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is StructureMap.Group.Rule.Target.Parameter.Value.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is StructureMap.Group.Rule.Target.Parameter.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is StructureMap.Group.Rule.Target.Parameter.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is StructureMap.Group.Rule.Target.Parameter.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 11, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
      }
    }
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

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Dependent =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var variable: List<KotlinString?>? = null
      var _variable: List<Element?>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            variable =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          6 ->
            _variable =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Dependent: " + i)
        }
      }
      StructureMap.Group.Rule.Dependent(
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
            R4String.of(variable?.getOrNull(index), _variable?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'variable' on StructureMap.Group.Rule.Dependent has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Dependent) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      if (value.variable.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          stringNullableListSerializer,
          value.variable.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.variable)
      }
    }
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
    decoder: CompositeDecoder,
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> publisher = decoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = decoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> purpose = decoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 -> copyright = decoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 ->
          structure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapStructureSerializer.listSerializer,
              null,
            )
        37 ->
          `import` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        38 ->
          _import =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        39 ->
          group =
            decoder.decodeNullableSerializableElement(
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
      version = R4String.of(version, _version),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on StructureMap"),
      title = R4String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on StructureMap"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
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
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: StructureMap,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 21 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.copyright)
    if (value.structure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        StructureMapStructureSerializer.listSerializer,
        value.structure,
      )
    if (value.`import`.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        37 + descriptorOffset,
        stringNullableListSerializer,
        value.`import`.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 38 + descriptorOffset, value.`import`)
    }
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        StructureMapGroupSerializer.listSerializer,
        value.group,
      )
  }
}
