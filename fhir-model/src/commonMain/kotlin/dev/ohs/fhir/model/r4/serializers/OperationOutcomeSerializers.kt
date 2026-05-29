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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.OperationOutcome
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
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

internal object OperationOutcomeIssueSerializer : KSerializer<OperationOutcome.Issue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Issue") {
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
      element("severity", KotlinString.serializer().descriptor, isOptional = true)
      element("_severity", Element.serializer().descriptor, isOptional = true)
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("details", CodeableConcept.serializer().descriptor, isOptional = true)
      element("diagnostics", KotlinString.serializer().descriptor, isOptional = true)
      element("_diagnostics", Element.serializer().descriptor, isOptional = true)
      element(
        "location",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_location", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "expression",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_expression",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): OperationOutcome.Issue =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: OperationOutcome.Issue) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): OperationOutcome.Issue {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> severity = decoder.decodeStringElement(descriptor, i)
        4 ->
          _severity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.severitySer, null)
        5 -> code = decoder.decodeStringElement(descriptor, i)
        6 ->
          _code =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.severitySer, null)
        7 ->
          details =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailsSer, null)
        8 -> diagnostics = decoder.decodeStringElement(descriptor, i)
        9 ->
          _diagnostics =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.severitySer, null)
        10 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        11 ->
          _location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer2, null)
        12 ->
          expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        13 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Issue: " + i)
      }
    }
    return OperationOutcome.Issue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      severity = Enumeration.of(OperationOutcome.IssueSeverity.fromCode(severity!!), _severity),
      code = Enumeration.of(OperationOutcome.IssueType.fromCode(code!!), _code),
      details = details,
      diagnostics = R4String.of(diagnostics, _diagnostics),
      location =
        (kotlin.collections.List(maxOf(location?.size ?: 0, _location?.size ?: 0)) { index ->
          R4String.of(location?.getOrNull(index)?.let { it }, _location?.getOrNull(index))!!
        }),
      expression =
        (kotlin.collections.List(maxOf(expression?.size ?: 0, _expression?.size ?: 0)) { index ->
          R4String.of(expression?.getOrNull(index)?.let { it }, _expression?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: OperationOutcome.Issue) {
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
    ((value.severity.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.severity.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.severitySer, it)
    }
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.severitySer, it)
    }
    (value.details)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.detailsSer, it)
    }
    ((value.diagnostics?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.diagnostics?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.severitySer, it)
    }
    (value.location.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.locationSer, it)
    }
    (value.location.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.locationSer2, it)
    }
    (value.expression.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.locationSer, it)
    }
    (value.expression.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.locationSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val severitySer: KSerializer<Element> = Element.serializer()

    public val detailsSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val locationSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val locationSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.locationSerInner).nullable)

    public val locationSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.severitySer).nullable)
  }
}

internal object OperationOutcomeSerializer : KSerializer<OperationOutcome> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OperationOutcome") {
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
    b.element(
      "issue",
      listSerialDescriptor(lazyDescriptor { OperationOutcome.Issue.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): OperationOutcome =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: OperationOutcome) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "OperationOutcome")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        10 ->
          issue = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.issueSer, null)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: OperationOutcome,
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
    if (value.issue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.issueSer,
        value.issue,
      )
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

    public val issueSerInner: KSerializer<OperationOutcome.Issue> =
      OperationOutcome.Issue.serializer()

    public val issueSer: KSerializer<List<OperationOutcome.Issue>> =
      ListSerializer(Hoisted.issueSerInner)
  }
}

internal object OperationOutcomePolymorphicSerializer : KSerializer<OperationOutcome> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OperationOutcome") {
      OperationOutcomeSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: OperationOutcome) {
    encoder.encodeStructure(descriptor) {
      OperationOutcomeSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): OperationOutcome =
    decoder.decodeStructure(descriptor) {
      OperationOutcomeSerializer.deserializeInternal(this, descriptor, 0)
    }
}
