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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.OperationDefinition
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.BindingStrength
import dev.ohs.fhir.model.r5.terminologies.FHIRTypes
import dev.ohs.fhir.model.r5.terminologies.OperationKind
import dev.ohs.fhir.model.r5.terminologies.OperationParameterScope
import dev.ohs.fhir.model.r5.terminologies.OperationParameterUse
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import dev.ohs.fhir.model.r5.terminologies.VersionIndependentResourceTypesAll
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

internal object OperationDefinitionParameterSerializer :
  FhirSerializer<OperationDefinition.Parameter> {
  override val descriptor: SerialDescriptor = buildDescriptor("Parameter", this)

  @JvmField
  internal val listSerializer: KSerializer<List<OperationDefinition.Parameter>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("use")
    b.strPrimList("scope")
    b.intPrim("min")
    b.strPrim("max")
    b.strPrim("documentation")
    b.strPrim("type")
    b.strPrimList("allowedType")
    b.strPrimList("targetProfile")
    b.strPrim("searchType")
    b.optionalElement("binding", OperationDefinitionParameterBindingSerializer.descriptor)
    b.optionalElement(
      "referencedFrom",
      OperationDefinitionParameterReferencedFromSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "part",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.OperationDefinitionParameterSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var use: OperationParameterUse? = null
    var _use: Element? = null
    var scope: List<KotlinString?>? = null
    var _scope: List<Element?>? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var type: FHIRTypes? = null
    var _type: Element? = null
    var allowedType: List<KotlinString?>? = null
    var _allowedType: List<Element?>? = null
    var targetProfile: List<KotlinString?>? = null
    var _targetProfile: List<Element?>? = null
    var searchType: SearchParamType? = null
    var _searchType: Element? = null
    var binding: OperationDefinition.Parameter.Binding? = null
    var referencedFrom: List<OperationDefinition.Parameter.ReferencedFrom>? = null
    var part: List<OperationDefinition.Parameter>? = null
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
          use = OperationParameterUse.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          scope =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        8 ->
          _scope =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 -> min = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _min =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> max = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _max =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> type = FHIRTypes.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          allowedType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        18 ->
          _allowedType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        19 ->
          targetProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        20 ->
          _targetProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        21 ->
          searchType = SearchParamType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        22 ->
          _searchType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          binding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterBindingSerializer,
              null,
            )
        24 ->
          referencedFrom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterReferencedFromSerializer.listSerializer,
              null,
            )
        25 ->
          part =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val scope_ =
      List(maxSize(scope, _scope)) { index ->
        entryRequired(
          Enumeration.of(
            at(scope, index)?.let { OperationParameterScope.fromCode(it) },
            at(_scope, index),
          ),
          "OperationDefinition.Parameter",
          "scope",
        )
      }
    val allowedType_ =
      List(maxSize(allowedType, _allowedType)) { index ->
        entryRequired(
          Enumeration.of(
            at(allowedType, index)?.let { FHIRTypes.fromCode(it) },
            at(_allowedType, index),
          ),
          "OperationDefinition.Parameter",
          "allowedType",
        )
      }
    val targetProfile_ =
      List(maxSize(targetProfile, _targetProfile)) { index ->
        entryRequired(
          Canonical.of(at(targetProfile, index), at(_targetProfile, index)),
          "OperationDefinition.Parameter",
          "targetProfile",
        )
      }
    return OperationDefinition.Parameter(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(Code.of(name, _name), "OperationDefinition.Parameter", "name"),
      use = required(Enumeration.of(use, _use), "OperationDefinition.Parameter", "use"),
      scope = scope_,
      min = required(Integer.of(min, _min), "OperationDefinition.Parameter", "min"),
      max = required(R5String.of(max, _max), "OperationDefinition.Parameter", "max"),
      documentation = Markdown.of(documentation, _documentation),
      type = Enumeration.of(type, _type),
      allowedType = allowedType_,
      targetProfile = targetProfile_,
      searchType = Enumeration.of(searchType, _searchType),
      binding = binding,
      referencedFrom = listOrEmpty(referencedFrom),
      part = listOrEmpty(part),
    )
  }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.use.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.use)
    if (!value.scope.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        stringNullableListSerializer,
        value.scope.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.scope)
    }
    compositeEncoder.encodeIntIfNotNull(descriptor, 9, value.min.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.min)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.max.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.max)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.documentation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.type)
    if (!value.allowedType.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        17,
        stringNullableListSerializer,
        value.allowedType.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 18, value.allowedType)
    }
    if (!value.targetProfile.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        19,
        stringNullableListSerializer,
        value.targetProfile.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 20, value.targetProfile)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 21, value.searchType?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22, value.searchType)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23,
      OperationDefinitionParameterBindingSerializer,
      value.binding,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24,
      OperationDefinitionParameterReferencedFromSerializer.listSerializer,
      value.referencedFrom,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25,
      OperationDefinitionParameterSerializer.listSerializer,
      value.part,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object OperationDefinitionParameterBindingSerializer :
  FhirSerializer<OperationDefinition.Parameter.Binding> {
  override val descriptor: SerialDescriptor = buildDescriptor("Binding", this)

  @JvmField
  internal val listSerializer: KSerializer<List<OperationDefinition.Parameter.Binding>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("strength")
    b.strPrim("valueSet")
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.Binding {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var strength: BindingStrength? = null
    var _strength: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
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
        3 ->
          strength = BindingStrength.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _strength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueSet =
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
    return OperationDefinition.Parameter.Binding(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      strength =
        required(
          Enumeration.of(strength, _strength),
          "OperationDefinition.Parameter.Binding",
          "strength",
        ),
      valueSet =
        required(
          Canonical.of(valueSet, _valueSet),
          "OperationDefinition.Parameter.Binding",
          "valueSet",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.Binding) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.strength.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.strength)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.valueSet.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.valueSet)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object OperationDefinitionParameterReferencedFromSerializer :
  FhirSerializer<OperationDefinition.Parameter.ReferencedFrom> {
  override val descriptor: SerialDescriptor = buildDescriptor("ReferencedFrom", this)

  @JvmField
  internal val listSerializer: KSerializer<List<OperationDefinition.Parameter.ReferencedFrom>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("source")
    b.strPrim("sourceId")
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.ReferencedFrom {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var sourceId: KotlinString? = null
    var _sourceId: Element? = null
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
        3 -> source = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> sourceId = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _sourceId =
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
    return OperationDefinition.Parameter.ReferencedFrom(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      source =
        required(
          R5String.of(source, _source),
          "OperationDefinition.Parameter.ReferencedFrom",
          "source",
        ),
      sourceId = R5String.of(sourceId, _sourceId),
    )
  }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.ReferencedFrom) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.source.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.source)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.sourceId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.sourceId)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object OperationDefinitionOverloadSerializer :
  FhirSerializer<OperationDefinition.Overload> {
  override val descriptor: SerialDescriptor = buildDescriptor("Overload", this)

  @JvmField
  internal val listSerializer: KSerializer<List<OperationDefinition.Overload>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrimList("parameterName")
    b.strPrim("comment")
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Overload {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var parameterName: List<KotlinString?>? = null
    var _parameterName: List<Element?>? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
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
        3 ->
          parameterName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        4 ->
          _parameterName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        5 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _comment =
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
    val parameterName_ =
      List(maxSize(parameterName, _parameterName)) { index ->
        entryRequired(
          R5String.of(at(parameterName, index), at(_parameterName, index)),
          "OperationDefinition.Overload",
          "parameterName",
        )
      }
    return OperationDefinition.Overload(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      parameterName = parameterName_,
      comment = R5String.of(comment, _comment),
    )
  }

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Overload) {
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
    if (!value.parameterName.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        3,
        stringNullableListSerializer,
        value.parameterName.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 4, value.parameterName)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.comment)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object OperationDefinitionSerializer : FhirResourceSerializer<OperationDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("OperationDefinition")

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
    b.strPrim("versionAlgorithmString")
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("title")
    b.strPrim("status")
    b.strPrim("kind")
    b.boolPrim("experimental")
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("copyright")
    b.strPrim("copyrightLabel")
    b.boolPrim("affectsState")
    b.strPrim("code")
    b.strPrim("comment")
    b.strPrim("base")
    b.strPrimList("resource")
    b.boolPrim("system")
    b.boolPrim("type")
    b.boolPrim("instance")
    b.strPrim("inputProfile")
    b.strPrim("outputProfile")
    b.optionalElement("parameter", OperationDefinitionParameterSerializer.listSerializer.descriptor)
    b.optionalElement("overload", OperationDefinitionOverloadSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): OperationDefinition {
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
    var status: PublicationStatus? = null
    var _status: Element? = null
    var kind: OperationKind? = null
    var _kind: Element? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var affectsState: KotlinBoolean? = null
    var _affectsState: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var base: KotlinString? = null
    var _base: Element? = null
    var resource: List<KotlinString?>? = null
    var _resource: List<Element?>? = null
    var system: KotlinBoolean? = null
    var _system: Element? = null
    var type: KotlinBoolean? = null
    var _type: Element? = null
    var instance: KotlinBoolean? = null
    var _instance: Element? = null
    var inputProfile: KotlinString? = null
    var _inputProfile: Element? = null
    var outputProfile: KotlinString? = null
    var _outputProfile: Element? = null
    var parameter: List<OperationDefinition.Parameter>? = null
    var overload: List<OperationDefinition.Overload>? = null
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
        15 -> versionAlgorithmString = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          versionAlgorithmCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        18 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        23 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> kind = OperationKind.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        25 ->
          _kind =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        27 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        29 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        33 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        36 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        37 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> copyrightLabel = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _copyrightLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> affectsState = compositeDecoder.decodeBooleanElement(descriptor, i)
        44 ->
          _affectsState =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        46 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        48 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        49 -> base = compositeDecoder.decodeStringElement(descriptor, i)
        50 ->
          _base =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        51 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        52 ->
          _resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        53 -> system = compositeDecoder.decodeBooleanElement(descriptor, i)
        54 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        55 -> type = compositeDecoder.decodeBooleanElement(descriptor, i)
        56 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        57 -> instance = compositeDecoder.decodeBooleanElement(descriptor, i)
        58 ->
          _instance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        59 -> inputProfile = compositeDecoder.decodeStringElement(descriptor, i)
        60 ->
          _inputProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        61 -> outputProfile = compositeDecoder.decodeStringElement(descriptor, i)
        62 ->
          _outputProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        63 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionParameterSerializer.listSerializer,
              null,
            )
        64 ->
          overload =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationDefinitionOverloadSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val resource_ =
      List(maxSize(resource, _resource)) { index ->
        entryRequired(
          Enumeration.of(
            at(resource, index)?.let { VersionIndependentResourceTypesAll.fromCode(it) },
            at(_resource, index),
          ),
          "OperationDefinition",
          "resource",
        )
      }
    return OperationDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = Uri.of(url, _url),
      identifier = listOrEmpty(identifier),
      version = R5String.of(version, _version),
      versionAlgorithm =
        OperationDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = required(R5String.of(name, _name), "OperationDefinition", "name"),
      title = R5String.of(title, _title),
      status = required(Enumeration.of(status, _status), "OperationDefinition", "status"),
      kind = required(Enumeration.of(kind, _kind), "OperationDefinition", "kind"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      affectsState = R5Boolean.of(affectsState, _affectsState),
      code = required(Code.of(code, _code), "OperationDefinition", "code"),
      comment = Markdown.of(comment, _comment),
      base = Canonical.of(base, _base),
      resource = resource_,
      system = required(R5Boolean.of(system, _system), "OperationDefinition", "system"),
      type = required(R5Boolean.of(type, _type), "OperationDefinition", "type"),
      instance = required(R5Boolean.of(instance, _instance), "OperationDefinition", "instance"),
      inputProfile = Canonical.of(inputProfile, _inputProfile),
      outputProfile = Canonical.of(outputProfile, _outputProfile),
      parameter = listOrEmpty(parameter),
      overload = listOrEmpty(overload),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: OperationDefinition,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is OperationDefinition.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is OperationDefinition.VersionAlgorithm.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.kind.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.kind)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      35 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      36 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.copyrightLabel?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.copyrightLabel)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.affectsState?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.affectsState)
    compositeEncoder.encodeStringIfNotNull(descriptor, 45 + descriptorOffset, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 47 + descriptorOffset, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.comment)
    compositeEncoder.encodeStringIfNotNull(descriptor, 49 + descriptorOffset, value.base?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.base)
    if (!value.resource.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        51 + descriptorOffset,
        stringNullableListSerializer,
        value.resource.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 52 + descriptorOffset, value.resource)
    }
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 53 + descriptorOffset, value.system.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 54 + descriptorOffset, value.system)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 55 + descriptorOffset, value.type.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 56 + descriptorOffset, value.type)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 57 + descriptorOffset, value.instance.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 58 + descriptorOffset, value.instance)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      59 + descriptorOffset,
      value.inputProfile?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 60 + descriptorOffset, value.inputProfile)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      61 + descriptorOffset,
      value.outputProfile?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 62 + descriptorOffset, value.outputProfile)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      63 + descriptorOffset,
      OperationDefinitionParameterSerializer.listSerializer,
      value.parameter,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      64 + descriptorOffset,
      OperationDefinitionOverloadSerializer.listSerializer,
      value.overload,
    )
  }
}
