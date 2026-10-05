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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Permission
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object PermissionJustificationSerializer : KSerializer<Permission.Justification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Justification") {
      element("id", String.serializer().descriptor, isOptional = true)
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
        "basis",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "evidence",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Permission.Justification>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Justification =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Justification) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Permission.Justification {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var basis: List<CodeableConcept>? = null
    var evidence: List<Reference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          basis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          evidence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Justification: " + i)
      }
    }
    return Permission.Justification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      basis = basis ?: listOf(),
      evidence = evidence ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Permission.Justification) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.basis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableConceptSerializer.listSerializer,
        value.basis,
      )
    if (value.evidence.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        ReferenceSerializer.listSerializer,
        value.evidence,
      )
  }
}

internal object PermissionRuleSerializer : KSerializer<Permission.Rule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Rule") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("type", String.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element(
        "data",
        listSerialDescriptor(lazyDescriptor { Permission.Rule.Data.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "activity",
        listSerialDescriptor(lazyDescriptor { Permission.Rule.Activity.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "limit",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Permission.Rule>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Rule =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Permission.Rule {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: String? = null
    var _type: Element? = null
    var `data`: List<Permission.Rule.Data>? = null
    var activity: List<Permission.Rule.Activity>? = null
    var limit: List<CodeableConcept>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          `data` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PermissionRuleDataSerializer.listSerializer,
              null,
            )
        6 ->
          activity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PermissionRuleActivitySerializer.listSerializer,
              null,
            )
        7 ->
          limit =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Rule: " + i)
      }
    }
    return Permission.Rule(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(type?.let { Permission.ConsentProvisionType.fromCode(it) }, _type),
      `data` = `data` ?: listOf(),
      activity = activity ?: listOf(),
      limit = limit ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Permission.Rule) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.type?.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.`data`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        PermissionRuleDataSerializer.listSerializer,
        value.`data`,
      )
    if (value.activity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        PermissionRuleActivitySerializer.listSerializer,
        value.activity,
      )
    if (value.limit.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        CodeableConceptSerializer.listSerializer,
        value.limit,
      )
  }
}

internal object PermissionRuleDataSerializer : KSerializer<Permission.Rule.Data> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Data") {
      element("id", String.serializer().descriptor, isOptional = true)
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
        "resource",
        listSerialDescriptor(
          lazyDescriptor { Permission.Rule.Data.Resource.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("security", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element("period", listSerialDescriptor(Period.serializer().descriptor), isOptional = true)
      element("expression", Expression.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Permission.Rule.Data>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Rule.Data =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Data) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Permission.Rule.Data {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var resource: List<Permission.Rule.Data.Resource>? = null
    var security: List<Coding>? = null
    var period: List<Period>? = null
    var expression: Expression? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          resource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PermissionRuleDataResourceSerializer.listSerializer,
              null,
            )
        4 ->
          security =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        5 ->
          period =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer.listSerializer,
              null,
            )
        6 ->
          expression =
            decoder.decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Data: " + i)
      }
    }
    return Permission.Rule.Data(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      resource = resource ?: listOf(),
      security = security ?: listOf(),
      period = period ?: listOf(),
      expression = expression,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Permission.Rule.Data) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        PermissionRuleDataResourceSerializer.listSerializer,
        value.resource,
      )
    if (value.security.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        CodingSerializer.listSerializer,
        value.security,
      )
    if (value.period.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        PeriodSerializer.listSerializer,
        value.period,
      )
    (value.expression)?.let {
      encoder.encodeSerializableElement(descriptor, 6, ExpressionSerializer, it)
    }
  }
}

internal object PermissionRuleDataResourceSerializer : KSerializer<Permission.Rule.Data.Resource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Resource") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("meaning", String.serializer().descriptor, isOptional = true)
      element("_meaning", Element.serializer().descriptor, isOptional = true)
      element("reference", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Permission.Rule.Data.Resource>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Rule.Data.Resource =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Data.Resource) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Permission.Rule.Data.Resource {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var meaning: String? = null
    var _meaning: Element? = null
    var reference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> meaning = decoder.decodeStringElement(descriptor, i)
        4 ->
          _meaning =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + i)
      }
    }
    return Permission.Rule.Data.Resource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      meaning =
        Enumeration.of(meaning?.let { Permission.ConsentDataMeaning.fromCode(it) }, _meaning)
          ?: throw SerializationException(
            "Missing required property 'meaning' on Permission.Rule.Data.Resource"
          ),
      reference =
        reference
          ?: throw SerializationException(
            "Missing required property 'reference' on Permission.Rule.Data.Resource"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Permission.Rule.Data.Resource) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.meaning.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.meaning.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.reference)
  }
}

internal object PermissionRuleActivitySerializer : KSerializer<Permission.Rule.Activity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Activity") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("actor", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "action",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "purpose",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Permission.Rule.Activity>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Rule.Activity =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Activity) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Permission.Rule.Activity {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var actor: List<Reference>? = null
    var action: List<CodeableConcept>? = null
    var purpose: List<CodeableConcept>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          actor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        4 ->
          action =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          purpose =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Activity: " + i)
      }
    }
    return Permission.Rule.Activity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      actor = actor ?: listOf(),
      action = action ?: listOf(),
      purpose = purpose ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Permission.Rule.Activity) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        ReferenceSerializer.listSerializer,
        value.actor,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.action,
      )
    if (value.purpose.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        CodeableConceptSerializer.listSerializer,
        value.purpose,
      )
  }
}

internal object PermissionSerializer : KSerializer<Permission> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Permission") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("asserter", Reference.serializer().descriptor, isOptional = true)
    b.element("date", listSerialDescriptor(String.serializer().descriptor), isOptional = true)
    b.element("_date", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("validity", Period.serializer().descriptor, isOptional = true)
    b.element(
      "justification",
      lazyDescriptor { Permission.Justification.serializer().descriptor },
      isOptional = true,
    )
    b.element("combining", String.serializer().descriptor, isOptional = true)
    b.element("_combining", Element.serializer().descriptor, isOptional = true)
    b.element(
      "rule",
      listSerialDescriptor(lazyDescriptor { Permission.Rule.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Permission =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Permission) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Permission")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Permission {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var status: String? = null
    var _status: Element? = null
    var asserter: Reference? = null
    var date: List<String?>? = null
    var _date: List<Element?>? = null
    var validity: Period? = null
    var justification: Permission.Justification? = null
    var combining: String? = null
    var _combining: Element? = null
    var rule: List<Permission.Rule>? = null
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
        10 -> status = decoder.decodeStringElement(descriptor, i)
        11 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          asserter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        13 ->
          date =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _date =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          validity =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        16 ->
          justification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PermissionJustificationSerializer,
              null,
            )
        17 -> combining = decoder.decodeStringElement(descriptor, i)
        18 ->
          _combining =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          rule =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PermissionRuleSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Permission: " + i)
      }
    }
    return Permission(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      status =
        Enumeration.of(status?.let { Permission.PermissionStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on Permission"),
      asserter = asserter,
      date =
        (kotlin.collections.List(maxOf(date?.size ?: 0, _date?.size ?: 0)) { index ->
          DateTime.of(
            date?.getOrNull(index)?.let { it?.let { FhirDateTime.fromString(it) } },
            _date?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'date' on Permission has neither a value nor an id/extension"
            )
        }),
      validity = validity,
      justification = justification,
      combining =
        Enumeration.of(
          combining?.let { Permission.PermissionRuleCombining.fromCode(it) },
          _combining,
        ) ?: throw SerializationException("Missing required property 'combining' on Permission"),
      rule = rule ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Permission,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, ElementSerializer, it)
    }
    (value.asserter)?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.date.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.date.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.validity)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, PeriodSerializer, it)
    }
    (value.justification)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        PermissionJustificationSerializer,
        it,
      )
    }
    ((value.combining.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.combining.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, ElementSerializer, it)
    }
    if (value.rule.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        PermissionRuleSerializer.listSerializer,
        value.rule,
      )
  }
}

internal object PermissionPolymorphicSerializer : KSerializer<Permission> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Permission") { PermissionSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Permission) {
    encoder.encodeStructure(descriptor) {
      PermissionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Permission =
    decoder.decodeStructure(descriptor) {
      PermissionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
