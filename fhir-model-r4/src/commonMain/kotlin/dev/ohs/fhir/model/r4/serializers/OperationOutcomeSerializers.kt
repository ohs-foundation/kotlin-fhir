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

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.OperationOutcome
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object OperationOutcomeIssueSerializer : KSerializer<OperationOutcome.Issue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Issue") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("severity", KotlinString.serializer().descriptor)
      optionalElement("_severity", ElementSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("details", CodeableConceptSerializer.descriptor)
      optionalElement("diagnostics", KotlinString.serializer().descriptor)
      optionalElement("_diagnostics", ElementSerializer.descriptor)
      optionalElement("location", stringNullableListSerializer.descriptor)
      optionalElement("_location", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("expression", stringNullableListSerializer.descriptor)
      optionalElement("_expression", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<OperationOutcome.Issue>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): OperationOutcome.Issue =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var severity: KotlinString? = null
      var _severity: Element? = null
      var code: KotlinString? = null
      var _code: Element? = null
      var details: CodeableConcept? = null
      var diagnostics: KotlinString? = null
      var _diagnostics: Element? = null
      var location: List<KotlinString?>? = null
      var _location: List<Element?>? = null
      var expression: List<KotlinString?>? = null
      var _expression: List<Element?>? = null
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
          3 -> severity = decodeStringElement(descriptor, i)
          4 -> _severity = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> code = decodeStringElement(descriptor, i)
          6 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            details =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 -> diagnostics = decodeStringElement(descriptor, i)
          9 ->
            _diagnostics = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            location =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          11 ->
            _location =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          12 ->
            expression =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          13 ->
            _expression =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Issue: " + i)
        }
      }
      OperationOutcome.Issue(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        severity =
          Enumeration.of(
            if (severity != null) OperationOutcome.IssueSeverity.fromCode(severity) else null,
            _severity,
          )
            ?: throw SerializationException(
              "Missing required property 'severity' on OperationOutcome.Issue"
            ),
        code =
          Enumeration.of(
            if (code != null) OperationOutcome.IssueType.fromCode(code) else null,
            _code,
          )
            ?: throw SerializationException(
              "Missing required property 'code' on OperationOutcome.Issue"
            ),
        details = details,
        diagnostics = R4String.of(diagnostics, _diagnostics),
        location =
          (kotlin.collections.List(maxOf(location?.size ?: 0, _location?.size ?: 0)) { index ->
            R4String.of(location?.getOrNull(index), _location?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'location' on OperationOutcome.Issue has neither a value nor an id/extension"
              )
          }),
        expression =
          (kotlin.collections.List(maxOf(expression?.size ?: 0, _expression?.size ?: 0)) { index ->
            R4String.of(expression?.getOrNull(index), _expression?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'expression' on OperationOutcome.Issue has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: OperationOutcome.Issue) {
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
      encodeStringIfNotNull(descriptor, 3, value.severity.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.severity)
      encodeStringIfNotNull(descriptor, 5, value.code.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.code)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.details)
      encodeStringIfNotNull(descriptor, 8, value.diagnostics?.value)
      encodeElementIfNotNull(descriptor, 9, value.diagnostics)
      if (value.location.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          10,
          stringNullableListSerializer,
          value.location.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 11, value.location)
      }
      if (value.expression.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          12,
          stringNullableListSerializer,
          value.expression.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 13, value.expression)
      }
    }
  }
}

internal object OperationOutcomeSerializer : FhirResourceSerializer<OperationOutcome> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("OperationOutcome")

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
    b.optionalElement("issue", OperationOutcomeIssueSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): OperationOutcome {
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
    var issue: List<OperationOutcome.Issue>? = null
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
        10 ->
          issue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              OperationOutcomeIssueSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding OperationOutcome: " + i)
      }
    }
    return OperationOutcome(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      issue = issue ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: OperationOutcome,
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
    if (value.issue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        OperationOutcomeIssueSerializer.listSerializer,
        value.issue,
      )
  }
}
