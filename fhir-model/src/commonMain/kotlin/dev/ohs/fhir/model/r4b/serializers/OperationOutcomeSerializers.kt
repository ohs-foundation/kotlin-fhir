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

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.OperationOutcome
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: OperationOutcome.Issue) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): OperationOutcome.Issue {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> severity = decoder.decodeStringElement(__desc, 3)
        4 ->
          _severity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.severitySer, null)
        5 -> code = decoder.decodeStringElement(__desc, 5)
        6 -> _code = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.severitySer, null)
        7 ->
          details = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.detailsSer, null)
        8 -> diagnostics = decoder.decodeStringElement(__desc, 8)
        9 ->
          _diagnostics =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.severitySer, null)
        10 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.locationSer, null)
        11 ->
          _location =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.locationSer2, null)
        12 ->
          expression =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.locationSer, null)
        13 ->
          _expression =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.locationSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Issue: " + __i)
      }
    }
    return OperationOutcome.Issue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      severity = Enumeration.of(OperationOutcome.IssueSeverity.fromCode(severity!!), _severity),
      code = Enumeration.of(OperationOutcome.IssueType.fromCode(code!!), _code),
      details = details,
      diagnostics = R4bString.of(diagnostics, _diagnostics),
      location =
        (kotlin.collections.List(maxOf(location?.size ?: 0, _location?.size ?: 0)) { __i ->
          R4bString.of(location?.getOrNull(__i)?.let { it }, _location?.getOrNull(__i))!!
        }),
      expression =
        (kotlin.collections.List(maxOf(expression?.size ?: 0, _expression?.size ?: 0)) { __i ->
          R4bString.of(expression?.getOrNull(__i)?.let { it }, _expression?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: OperationOutcome.Issue) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.severity.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.severity.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.severitySer, it)
    }
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.severitySer, it)
    }
    (value.details)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.detailsSer, it) }
    ((value.diagnostics?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.diagnostics?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.severitySer, it)
    }
    (value.location.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.locationSer, it)
    }
    (value.location.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.locationSer2, it)
    }
    (value.expression.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.locationSer, it)
    }
    (value.expression.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.locationSer2, it)
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
      element(
        "issue",
        listSerialDescriptor(lazyDescriptor { OperationOutcome.Issue.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): OperationOutcome =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: OperationOutcome) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): OperationOutcome {
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
    var issue: List<OperationOutcome.Issue>? = null
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
        11 -> issue = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.issueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OperationOutcome: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: OperationOutcome) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "OperationOutcome")
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
    if (value.issue.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.issueSer, value.issue)
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
